import java.util.*;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Podaj wymiar poziomy blachy: ");
        int m = scan.nextInt();
        System.out.println("Podaj wymiar pionowy blachy: ");
        int n = scan.nextInt();

        List<Cut> cutsList = new ArrayList<Cut>();
        System.out.println("Podaj kolejne wartości cięcia blachy pionowo. Program przyjmie tylko " + (m-1) + " wartości.");

        for(int i=1; i<m; i++){
            int x = scan.nextInt();
            Cut cut = new Cut("vertical", i, x);
            cutsList.add(cut);
        }

        System.out.println("Podaj kolejne wartości cięcia blachy poziomo. Program przyjmie tylko " + (n-1) + " wartości.");

        for(int i=1; i<n; i++){
            int y = scan.nextInt();
            Cut cut = new Cut("horizontal", i, y);
            cutsList.add(cut);
        }

        System.out.println(cutsList.size());

        Fragment fragment = new Fragment(1, 1, m, n);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(fragment);

        Tinware tinware = new Tinware(fragments, 0);
        /*
        List<Cut> cuts = Arrays.asList(
                new Cut("vertical", 1, 2),
                new Cut("vertical", 2, 1),
                new Cut("vertical", 3, 3),
                new Cut("vertical", 4, 1),
                new Cut("vertical", 5, 4),
                new Cut("horizontal", 1, 4),
                new Cut("horizontal", 2, 1),
                new Cut("horizontal", 3, 2)
        );*/

        //sortowanie listy cięć według kosztu malejąco - cięcia pionowe i poziome razem
        cutsList.sort(Comparator.comparing(Cut::getCost).reversed());

        //wykonywanie cięć pionowych lub poziomych wg powyższej kolejności
        for (Cut cut : cutsList) {
            System.out.println(cut.getOrientation());

            if (cut.getOrientation().equals("vertical")) {
                doVerticalCut(tinware, cut);
            } else {
                doHorizontalCut(tinware, cut);
            }
            System.out.println(tinware.cost);
        }

        System.out.println(tinware.cost);

    }

    //pojedyńcze cięcie poziome
    static Tinware doHorizontalCut(Tinware tinware, Cut cut) {

        int cutPosition = cut.getPosition();
        List<Fragment> fragments = tinware.getFragments();
        List<Fragment> newFragments = new ArrayList<>();

        for (Fragment fragment : fragments) {
            int startY = fragment.getCoordinateY();
            int endY = fragment.getCoordinateY() + fragment.getDimensionY() - 1;
            int startX = fragment.getCoordinateX();
            int dimX = fragment.getDimensionX();

            if (cutPosition >= startY && cutPosition < endY) {
                tinware.setCost(tinware.getCost() + cut.getCost());

                newFragments.add(new Fragment(startX, startY, dimX, cutPosition));
                newFragments.add(new Fragment(startX, cutPosition + 1, dimX, endY - cutPosition));
            } else {
                newFragments.add(fragment);
            }
        }
        tinware.setFragments(newFragments);
        return tinware;
    }

    //pojedyńcze cięcie pionowe
    static Tinware doVerticalCut(Tinware tinware, Cut cut) {

        int cutPosition = cut.getPosition();
        List<Fragment> fragments = tinware.getFragments();
        List<Fragment> newFragments = new ArrayList<>();

        for (Fragment fragment : fragments) {
            int startX = fragment.getCoordinateX();
            int endX = fragment.getCoordinateX() + fragment.getDimensionX() - 1;
            int startY = fragment.getCoordinateY();
            int dimY = fragment.getDimensionY();

            if (cutPosition >= startX && cutPosition < endX) {
                tinware.setCost(tinware.getCost() + cut.getCost());

                newFragments.add(new Fragment(startX, startY, cutPosition, dimY));
                newFragments.add(new Fragment(cutPosition + 1, startY, endX - cutPosition, dimY));
            } else {
                newFragments.add(fragment);
            }
        }
        tinware.setFragments(newFragments);
        return tinware;
    }

}




