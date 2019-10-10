import java.util.ArrayList;
import java.util.List;

public class CuttingService {

    //pojedyńcze cięcie poziome
    void doHorizontalCut(Tinware tinware, Cut cut) {

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
    }

    //pojedyńcze cięcie pionowe
    void doVerticalCut(Tinware tinware, Cut cut) {

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
    }

}
