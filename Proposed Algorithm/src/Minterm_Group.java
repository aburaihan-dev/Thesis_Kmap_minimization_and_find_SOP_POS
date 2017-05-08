import java.util.List;

/**
 * Created by msrabon on 08-May-17.
 */
public class Minterm_Group {
    private String bit_string;
    private List<Minterm> groupedMinterms;

    public Minterm_Group(String bit_string, List<Minterm> groupedMinterms) {
        this.bit_string = bit_string;
        this.groupedMinterms = groupedMinterms;
    }

    public String getBit_string() {
        return bit_string;
    }

    public void setBit_string(String bit_string) {
        this.bit_string = bit_string;
    }

    public List<Minterm> getGroupedMinterms() {
        return groupedMinterms;
    }

    public void setGroupedMinterms(List<Minterm> groupedMinterms) {
        this.groupedMinterms = groupedMinterms;
    }
}
