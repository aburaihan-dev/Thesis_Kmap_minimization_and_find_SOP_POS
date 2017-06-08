import java.util.List;

/**
 * Created by msrabon on 07-Jun-17.
 */
public class ShowResult {

    public static void showTruthtable() {
        for (int i = 0; i < 16; i++) {
            System.out.println(String.format("%4s", Integer.toBinaryString(i)).replace(" ", "0"));
        }
    }

    public static void showPairs(List<Minterm_Group> groups) {
        System.out.println("Patterns    Minterm Groups");
        for (Minterm_Group group : groups) {
            System.out.println(resultConverter(group.getBit_string()) + "  " + group.getAllMinterms());
        }
    }

    public static String resultConverter(String bit_string) {
        String str = "";
        if (bit_string.charAt(0) == '1') {
            str += 'A';
        } else if (bit_string.charAt(0) == '0') {
            str += 'a';
        }
        if (bit_string.charAt(1) == '1') {
            str += 'B';
        } else if (bit_string.charAt(1) == '0') {
            str += 'b';
        }
        if (bit_string.charAt(2) == '1') {
            str += 'C';
        } else if (bit_string.charAt(2) == '0') {
            str += 'c';
        }
        if (bit_string.charAt(3) == '1') {
            str += 'D';
        } else if (bit_string.charAt(3) == '0') {
            str += 'd';
        }
        return str;
    }
}
