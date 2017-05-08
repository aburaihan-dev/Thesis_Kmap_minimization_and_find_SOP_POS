import java.util.*;

/**
 * Created by msrabon on 08-May-17.
 */
public class ProposedAlgorithm {


    public static void main(String[] args) {
        List<Minterm> lsb_0 = new ArrayList<>();
        List<Minterm> lsb_1 = new ArrayList<>();
        List<List<Minterm>> kMap = new ArrayList<>();
        List<Minterm_Group> pairs = new ArrayList<>();
        List<String> minterms = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        boolean dontcaresAvailable;
        int minterm;

        System.out.print("Enter minterm: ");
        while ((minterm = scan.nextInt()) != -1) {
            if (minterm % 2 == 0) {
                lsb_0.add(new Minterm(minterm, String.format("%4s", Integer.toBinaryString(minterm)).replace(" ",
                                                                                                             "0")));

            } else {
                lsb_1.add(new Minterm(minterm, String.format("%4s", Integer.toBinaryString(minterm)).replace(" ",
                                                                                                             "0")));
            }
            minterms.add(String.format("%4s", Integer.toBinaryString(minterm)).replace(" ",
                                                                                       "0"));
//            System.out.print("Enter minterm: ");
        }

        kMap.add(lsb_0);
        kMap.add(lsb_1);

        System.out.println("STEP-1.....................");
        final long startTime = System.currentTimeMillis();
        for (List<Minterm> lsb : kMap) {
            for (int i = 0; i < lsb.size(); i++) {
                for (int j = i + 1; j < lsb.size(); j++) {
                    String min_1 = lsb.get(i).getBit_string();
                    String min_2 = lsb.get(j).getBit_string();
                    int location = 0;
                    int diff = 0;
                    for (int k = 0; k < min_1.length(); k++) {
                        if (min_1.charAt(k) != min_2.charAt(k)) {
//                        System.out.println(min_1 + "  " + min_2);
                            diff++;
                            location = k;
                        }
                    }

                    if (diff == 1) {
                        char[] pattern = min_1.toCharArray();
                        pattern[location] = 'x';
                        minterms.remove(lsb.get(i).getBit_string());
                        minterms.remove(lsb.get(j).getBit_string());
                        Minterm_Group mintermGroup = new Minterm_Group(String.copyValueOf(pattern));
                        mintermGroup.addToGroupedMinterms(lsb.get(i));
                        mintermGroup.addToGroupedMinterms(lsb.get(j));
                        pairs.add(mintermGroup);
                    }
                }
            }
        }

        final long endTime = System.currentTimeMillis();

        System.out.println("Total execution time: " + (endTime - startTime));

    }
}
