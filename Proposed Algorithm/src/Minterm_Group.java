import java.util.ArrayList;
import java.util.List;

/**
 * Created by msrabon on 08-May-17.
 */
public class Minterm_Group {
    private String bit_string;
    private List<Integer> groupedMinterms;

    public Minterm_Group(String bit_string) {
        this.bit_string = bit_string;
        groupedMinterms = new ArrayList<>();
    }

    public String getBit_string() {
        return bit_string;
    }

    public void setBit_string(String bit_string) {
        this.bit_string = bit_string;
    }

    public List<Integer> getGroupedMinterms() {
        return groupedMinterms;
    }

    public String getAllMinterms() {
        String str = "";
        for (int i = 0; i < groupedMinterms.size(); i++) {
            str += String.valueOf(groupedMinterms.get(i)) + " ";
        }
        return str;
    }

    public void setGroupedMinterms(List<Integer> groupedMinterms) {
        this.groupedMinterms = groupedMinterms;
    }

    public void addToGroupedMinterms(int x, int y) {
        this.groupedMinterms.add(x);
        this.groupedMinterms.add(y);
    }

    @Override
    public String toString() {
        return bit_string;
    }
}
