import java.util.List;

public class Tinware {
    List<Fragment> fragments;
    int cost;

    public Tinware(List<Fragment> fragments, int cost) {
        this.fragments = fragments;
        this.cost = cost;
    }

    public List<Fragment> getFragments() {
        return fragments;
    }

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}
