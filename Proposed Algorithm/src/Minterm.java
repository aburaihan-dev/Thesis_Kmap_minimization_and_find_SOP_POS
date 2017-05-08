/**
 * Created by msrabon on 08-May-17.
 */
public class Minterm {
    private int minterm_no;
    private String bit_string;

    public Minterm() {
    }

    public Minterm(int minterm_no, String bit_string) {
        this.minterm_no = minterm_no;
        this.bit_string = bit_string;
    }

    public int getMinterm_no() {
        return minterm_no;
    }

    public void setMinterm_no(int minterm_no) {
        this.minterm_no = minterm_no;
    }

    public String getBit_string() {
        return bit_string;
    }

    public void setBit_string(String bit_string) {
        this.bit_string = bit_string;
    }
}
