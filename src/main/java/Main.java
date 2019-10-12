import model.Cut;
import model.Fragment;
import model.Tinware;
import service.CuttingService;

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
        List<model.Cut> cuts = Arrays.asList(
                new model.Cut("vertical", 1, 2),
                new model.Cut("vertical", 2, 1),
                new model.Cut("vertical", 3, 3),
                new model.Cut("vertical", 4, 1),
                new model.Cut("vertical", 5, 4),
                new model.Cut("horizontal", 1, 4),
                new model.Cut("horizontal", 2, 1),
                new model.Cut("horizontal", 3, 2)
        );*/

        //sortowanie listy cięć według kosztu malejąco - cięcia pionowe i poziome razem
        cutsList.sort(Comparator.comparing(Cut::getCost).reversed());

        CuttingService cuttingService = new CuttingService();
        //wykonywanie cięć pionowych lub poziomych wg powyższej kolejności
        for (Cut cut : cutsList) {
            System.out.println(cut.getOrientation());

            if (cut.getOrientation().equals("vertical")) {
                cuttingService.doVerticalCut(tinware, cut);
            } else {
                cuttingService.doHorizontalCut(tinware, cut);
            }
            System.out.println(tinware.getCost());
        }

        System.out.println(tinware.getCost());

    }

}




