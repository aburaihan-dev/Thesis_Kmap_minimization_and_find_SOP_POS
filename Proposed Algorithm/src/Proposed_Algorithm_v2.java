import java.util.*;

/**
 * Created by msrabon on 08-May-17.
 */
public class Proposed_Algorithm_v2 {
    List<Integer> integerList;
    int max;

    List<List<Integer>> kMap = new ArrayList<>();

    public Proposed_Algorithm_v2(List<Integer> minterInput, int max) {
        integerList = minterInput;
        this.max = max;
    }

    public void automate() {
        createGroup();
    }

    public void createGroup() {
        List<Integer> grp_1 = new ArrayList<>();
        List<Integer> grp_2 = new ArrayList<>();

        for (Integer integer : integerList) {
            if (integer % 2 == 0) {
                grp_1.add(integer);
            } else {
                grp_2.add(integer);
            }
        }

        kMap.add(grp_1);
        kMap.add(grp_2);
    }
}
