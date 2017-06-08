import java.util.*;

/**
 * Created by msrabon on 08-May-17.
 */
public class ProposedAlgorithm_v2 {

    public static void main(String[] args) {
        List<Minterm> lsb_0 = new ArrayList<>();
        List<Minterm> lsb_1 = new ArrayList<>();
        List<List<Minterm>> kMap = new ArrayList<>();
        // patterns holder.
        List<List<Minterm_Group>> patterns = new ArrayList<>();
        List<List<Minterm_Group>> patternsFinale = new ArrayList<>();
        List<Minterm_Group> pairs = new ArrayList<>();
        Map<String, Boolean> minterms = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        boolean dontcaresAvailable;
        int minterm;
        int patternsCount = 0;
        // patterns holder based on position of x.
        for (int i = 0; i < 4; i++) {
            patterns.add(new ArrayList<>());
            patternsFinale.add(new ArrayList<>());
        }

        System.out.print("Enter minterm: ");
        while ((minterm = scan.nextInt()) != -1) {
            if (minterm % 2 == 0) {
                lsb_0.add(new Minterm(minterm, String.format("%4s", Integer.toBinaryString(minterm)).replace(" ",
                                                                                                             "0")));

            } else {
                lsb_1.add(new Minterm(minterm, String.format("%4s", Integer.toBinaryString(minterm)).replace(" ",
                                                                                                             "0")));
            }
            minterms.put(String.format("%4s", Integer.toBinaryString(minterm)).replace(" ",
                                                                                       "0"), false);
//            System.out.print("Enter minterm: ");
        }

        kMap.add(lsb_0);
        kMap.add(lsb_1);

        int count = 0;
        System.out.println("STEP-1.....................");
        final long startTime = System.nanoTime();
        for (List<Minterm> lsb : kMap) {
            int groupCount = 1;
            for (int i = 0; i < lsb.size(); i++) {
                for (int j = i + 1; j < lsb.size(); j++) {
                    count++;
                    boolean pair = false;
                    int location = 0;
                    int diff = 0;
                    int n = 4;
                    String str = null;
                    switch (lsb.get(i).getMinterm_no() ^ lsb.get(j).getMinterm_no()) {
                        case 1: str = getPair(lsb.get(i).getMinterm_no(), n - 1);
                            pair = true;
                            location = n - 1;
                            break;
                        case 2: str = getPair(lsb.get(i).getMinterm_no(), n - 2);
                            location = n - 2;
                            pair = true;
                            break;
                        case 4: str = getPair(lsb.get(i).getMinterm_no(), n - 3);
                            location = n - 3;
                            pair = true;
                            break;
                        case 8: str = getPair(lsb.get(i).getMinterm_no(), n - 4);
                            location = n - 4;
                            pair = true;
                            break;
                        case 16: str = getPair(lsb.get(i).getMinterm_no(), n - 5);
                            location = n - 5;
                            pair = true;
                            break;
                        case 32: str = getPair(lsb.get(i).getMinterm_no(), n - 6);
                            location = n - 6;
                            pair = true;
                            break;
                    }

                    if (pair) {
                        lsb.get(i).setPaired(true);
                        lsb.get(j).setPaired(true);
                        minterms.remove(lsb.get(i));
                        minterms.put(lsb.get(i).getBit_string(), true);
                        minterms.put(lsb.get(j).getBit_string(), true);
                        Minterm_Group mintermGroup = new Minterm_Group(str);
                        mintermGroup.addToGroupedMinterms(lsb.get(i));
                        mintermGroup.addToGroupedMinterms(lsb.get(j));
                        patterns.get(location).add(mintermGroup);
                        patternsCount++;
                    }
                    pair = false;
                    str = null;
                }
            }
            groupCount--;
        }

        System.out.println(count);
        System.out.println("Patterns: " + patternsCount);
//        System.out.println("STEP-2 ..............");

        for (int i = 0; i < patterns.size(); i++) {
            if (patterns.get(i).size() == 1) {
                pairs.add(patterns.get(i).get(0));
            }
            for (int j = 0; j < patterns.get(i).size() - 1; j++) {
//                System.out.println(j + " " + patterns.get(i).get(j) + "      " + patterns.get(i).get(j)
//                        .getAllMinterms());
                for (int g = j + 1; g < patterns.get(i).size(); g++) {
                    String mintermGroup = patterns.get(i).get(j).getBit_string();
                    String mintermGroup1 = patterns.get(i).get(g).getBit_string();
                    int bit_diff = 0;
                    int location = 0;
                    for (int k = 0; k < mintermGroup.length(); k++) {
                        if ((mintermGroup.charAt(k) != mintermGroup1.charAt(k)) &&
                                (mintermGroup1.charAt(k) != 'x')) {
//                        System.out.println(mintermGroup.charAt(k) + "  " +
//                                                   mintermGroup1.charAt(k));
                            bit_diff++;
                            location = k;
                        }
                    }

                    if (bit_diff == 1) {
                        System.out.println(mintermGroup + " " + mintermGroup1);
                        System.out.println(patterns.get(i).get(j).getGroupedMinterms() + "  " + patterns.get(i).get(g)
                                .getGroupedMinterms());
                        char[] patrn = mintermGroup.toCharArray();
                        patrn[location] = 'x';
                        Minterm_Group group = new Minterm_Group(String.copyValueOf(patrn));

                        group.setGroupedMinterms(new ArrayList<>(patterns.get(i).get(j).getGroupedMinterms()));
                        group.getGroupedMinterms().addAll(patterns.get(i).get(g).getGroupedMinterms());
                        pairs.add(group);
                    }
                }
            }
        }

        final long endTime = System.nanoTime();

        System.out.println("Total pairs: " + pairs.size());
        ShowResult.showPairs(pairs);



//        System.out.println("Start Time: " + startTime);
//        System.out.println("End Time: " + endTime);
        System.out.println("Total execution time: " + (double) (endTime - startTime) / 1000000);
//        File file = new File("logs_0.txt");
//        try (PrintStream out = new PrintStream(new FileOutputStream(file,true))) {
//            out.println("****************************************************");
//            out.println("Proposed Algorithm");
//            out.println("Kmap Data: 0 3 7 11 15 9 -1");
//            out.print("Start Time: " + startTime + "\n");
//            out.print("End Time: " + endTime + "\n");
//            out.print("Total execution time: " + (endTime - startTime) + "\n");
//            out.print("Total execution time: " + (double)(endTime - startTime)/1000000 + "milis \n");
//            out.println("****************************************************");
//            out.close();
//        } catch (FileNotFoundException e1) {
//            e1.printStackTrace();
//        }
    }

    private static String getPair(int x, int pos) {
        char[] pattern = String.format("%4s", Integer.toBinaryString(x)).replace(" ", "0").toCharArray();
        pattern[pos] = 'x';
        return String.valueOf(pattern);
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
