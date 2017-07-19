import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

/**
 * Created by msrabon on 08-May-17.
 */
public class ProposedAlgorithm {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //
        List<Integer> integerList = new ArrayList<>();
        List<Integer> minterms;
        //
        List<Integer> grp;
        List<Integer> grp_0 = new ArrayList<>();
        List<Integer> grp_1 = new ArrayList<>();
        //
        List<List<Integer>> kMap = new ArrayList<>();
        List<List<Minterm_Group>> minterm_groups = new ArrayList<>();
        //
        List<Minterm_Group> result_SOP = new ArrayList<>();
        List<Minterm_Group> result_SOP_final = new ArrayList<>();

        boolean pair = false;
        int x, totalBits, max = 0;

        System.out.println("Enter Minterms (input -1 to stop input.): ");
        while ((x = scan.nextInt()) != -1) {
            integerList.add(x);
            if (x > max) {
                max = x;
            }
        }

        //Step-1: Create groups based on even-odds.
        final long startTime = System.nanoTime();
        totalBits = (int) Math.ceil((double) Math.log(max) / Math.log(2));

        for (int i = 0; i <= totalBits; i++) {
            minterm_groups.add(new ArrayList<>());
        }

        for (Integer integer : integerList) {
            if (integer % 2 == 0) {
                grp_0.add(integer);
            } else {
                grp_1.add(integer);
            }
        }

        //finding even-odd using bitwise operation.
//        System.out.println(24 & 1);
//        System.out.println(25 & 1);
//        System.out.println(26 & 1);

        minterms = new ArrayList<>(integerList);
        kMap.add(grp_0);
        kMap.add(grp_1);
        //Step-1: complete.

        //Step-2: Starting to find pairs.
        Minterm_Group mintermGroup;
        for (int i = 0; i < 2; i++) {
            grp = kMap.get(i);
            int size = grp.size();

            if (size > 1) {
                for (int j = 0; j < size - 1; j++) {
                    int a = grp.get(j);
                    for (int k = i + 1; k < size; k++) {
                        int b = grp.get(k);
                        pair = false;
                        switch (a ^ b) {
                            case 1:
                                pair = true;
                                minterm_groups.get(0).add(getPairedMinterms(0, totalBits, a, b));
                                break;
                            case 2:
                                pair = true;
                                minterm_groups.get(1).add(getPairedMinterms(1, totalBits, a, b));
                                break;
                            case 4:
                                pair = true;
                                minterm_groups.get(2).add(getPairedMinterms(2, totalBits, a, b));
                                break;
                            case 8:
                                pair = true;
                                minterm_groups.get(3).add(getPairedMinterms(3, totalBits, a, b));
                                break;
                            case 16:
                                pair = true;
                                minterm_groups.get(4).add(getPairedMinterms(4, totalBits, a, b));
                                break;
                            case 32:
                                pair = true;
                                minterm_groups.get(5).add(getPairedMinterms(5, totalBits, a, b));
                                break;
                            case 64:
                                pair = true;
                                minterm_groups.get(6).add(getPairedMinterms(6, totalBits, a, b));
                                break;
                            case 128:
                                pair = true;
                                minterm_groups.get(7).add(getPairedMinterms(7, totalBits, a, b));
                                break;
                            case 256:
                                pair = true;
                                minterm_groups.get(8).add(getPairedMinterms(8, totalBits, a, b));
                                break;
                            case 512:
                                pair = true;
                                minterm_groups.get(9).add(getPairedMinterms(9, totalBits, a, b));
                                break;
                            case 1024:
                                pair = true;
                                minterm_groups.get(10).add(getPairedMinterms(10, totalBits, a, b));
                                break;
                        }
                        if (pair) {
                            minterms.remove(grp.get(k));
                            minterms.remove(grp.get(j));
                        }
                    }
                }
            } else if (grp.size() == 1) {
                int a = grp.get(0);
                grp = kMap.get(1 ^ i);
                System.out.println("ELSE: " + size);
                pair = false;
                for (int j = 0; j < grp.size(); j++) {
                    /// changed here now 1.34am
                    int b = grp.get(j);
                    pair = false;
                    switch (a ^ b) {
                        case 1:
                            pair = true;
                            minterm_groups.get(0).add(getPairedMinterms(0, totalBits, a, b));
                            break;
                        case 2:
                            pair = true;
                            minterm_groups.get(1).add(getPairedMinterms(1, totalBits, a, b));
                            break;
                        case 4:
                            pair = true;
                            minterm_groups.get(2).add(getPairedMinterms(2, totalBits, a, b));
                            break;
                        case 8:
                            pair = true;
                            minterm_groups.get(3).add(getPairedMinterms(3, totalBits, a, b));
                            break;
                        case 16:
                            pair = true;
                            minterm_groups.get(4).add(getPairedMinterms(4, totalBits, a, b));
                            break;
                        case 32:
                            pair = true;
                            minterm_groups.get(5).add(getPairedMinterms(5, totalBits, a, b));
                            break;
                        case 64:
                            pair = true;
                            minterm_groups.get(6).add(getPairedMinterms(6, totalBits, a, b));
                            break;
                        case 128:
                            pair = true;
                            minterm_groups.get(7).add(getPairedMinterms(7, totalBits, a, b));
                            break;
                        case 256:
                            pair = true;
                            minterm_groups.get(8).add(getPairedMinterms(8, totalBits, a, b));
                            break;
                        case 512:
                            pair = true;
                            minterm_groups.get(9).add(getPairedMinterms(9, totalBits, a, b));
                            break;
                        case 1024:
                            pair = true;
                            minterm_groups.get(10).add(getPairedMinterms(10, totalBits, a, b));
                            break;
                    }
                    if (pair) {
                        minterms.remove(minterms.indexOf(b));
                        minterms.remove(minterms.indexOf(a));
                    }
                }
            }
        }

        for (int i = 0; i < minterms.size(); i++) {
            int a = minterms.get(i);

            if (minterms.size() > 1) {
                for (int j = i + 1; j < minterms.size(); j++) {
                    int b = minterms.get(j);
                    pair = false;
                    switch (a ^ b) {
                        case 1:
                            pair = true;
                            minterm_groups.get(0).add(getPairedMinterms(0, totalBits, a, b));
                            break;
                        case 2:
                            pair = true;
                            minterm_groups.get(1).add(getPairedMinterms(1, totalBits, a, b));
                            break;
                        case 4:
                            pair = true;
                            minterm_groups.get(2).add(getPairedMinterms(2, totalBits, a, b));
                            break;
                        case 8:
                            pair = true;
                            minterm_groups.get(3).add(getPairedMinterms(3, totalBits, a, b));
                            break;
                        case 16:
                            pair = true;
                            minterm_groups.get(4).add(getPairedMinterms(4, totalBits, a, b));
                            break;
                        case 32:
                            pair = true;
                            minterm_groups.get(5).add(getPairedMinterms(5, totalBits, a, b));
                            break;
                        case 64:
                            pair = true;
                            minterm_groups.get(6).add(getPairedMinterms(6, totalBits, a, b));
                            break;
                        case 128:
                            pair = true;
                            minterm_groups.get(7).add(getPairedMinterms(7, totalBits, a, b));
                            break;
                        case 256:
                            pair = true;
                            minterm_groups.get(8).add(getPairedMinterms(8, totalBits, a, b));
                            break;
                        case 512:
                            pair = true;
                            minterm_groups.get(9).add(getPairedMinterms(9, totalBits, a, b));
                            break;
                        case 1024:
                            pair = true;
                            minterm_groups.get(10).add(getPairedMinterms(10, totalBits, a, b));
                            break;
                    }
                    if (pair) {
                        minterms.remove(minterms.indexOf(b));
                        j--;
                    }
                    if (pair && minterms.contains(a)) {
                        minterms.remove(minterms.indexOf(a));
                        j -= 1;
                        i--;
                    }
                }
            } else if (minterms.size() == 1) {
                int q = 0;
                if ((a ^ 1) == 0) {
                    q = 1;
                }
                grp = kMap.get(q);
                pair = false;
                for (int j = 0; j < grp.size(); j++) {
                    int b = grp.get(j);
                    pair = false;
                    switch (a ^ b) {
                        case 1:
                            pair = true;
                            minterm_groups.get(0).add(getPairedMinterms(0, totalBits, a, b));
                            break;
                        case 2:
                            pair = true;
                            minterm_groups.get(1).add(getPairedMinterms(1, totalBits, a, b));
                            break;
                        case 4:
                            pair = true;
                            minterm_groups.get(2).add(getPairedMinterms(2, totalBits, a, b));
                            break;
                        case 8:
                            pair = true;
                            minterm_groups.get(3).add(getPairedMinterms(3, totalBits, a, b));
                            break;
                        case 16:
                            pair = true;
                            minterm_groups.get(4).add(getPairedMinterms(4, totalBits, a, b));
                            break;
                        case 32:
                            pair = true;
                            minterm_groups.get(5).add(getPairedMinterms(5, totalBits, a, b));
                            break;
                        case 64:
                            pair = true;
                            minterm_groups.get(6).add(getPairedMinterms(6, totalBits, a, b));
                            break;
                        case 128:
                            pair = true;
                            minterm_groups.get(7).add(getPairedMinterms(7, totalBits, a, b));
                            break;
                        case 256:
                            pair = true;
                            minterm_groups.get(8).add(getPairedMinterms(8, totalBits, a, b));
                            break;
                        case 512:
                            pair = true;
                            minterm_groups.get(9).add(getPairedMinterms(9, totalBits, a, b));
                            break;
                        case 1024:
                            pair = true;
                            minterm_groups.get(10).add(getPairedMinterms(10, totalBits, a, b));
                            break;
                    }
                    if (pair) {
                        minterms.remove(minterms.indexOf(a));
                    }
                }
            }
        }
        //Step-2: Completed.

        //Step-3: Starts here.
        for (int i = 0; i < minterm_groups.size(); i++) {
            if (minterm_groups.get(i).size() == 1) {
                result_SOP.add(minterm_groups.get(i).get(0));
            } else {
                boolean[] pairFound = new boolean[minterm_groups.get(i).size()];
                for (int j = 0; j < minterm_groups.get(i).size() - 1; j++) {
                    String temp_a = minterm_groups.get(i).get(j).getBit_string();
                    String temp_b = minterm_groups.get(i).get(j + 1).getBit_string();
                    int location = -1;
                    int bitDiff = 0;
                    for (int k = 0; k < totalBits; k++) {
                        if (temp_a.charAt(k) != temp_b.charAt(k)) {
                            location = k;
                            bitDiff++;
                        }
                    }

                    if (location != -1 && bitDiff == 1) {
                        char[] temp_ch_array = temp_a.toCharArray();
                        temp_ch_array[location] = '_';
                        Minterm_Group group = new Minterm_Group(String.valueOf(temp_ch_array));
                        group.addToGroupedMintermsList(minterm_groups.get(i).get(j).getGroupedMinterms());
                        group.addToGroupedMintermsList(minterm_groups.get(i).get(j + 1).getGroupedMinterms());
                        result_SOP.add(group);
                        pairFound[j] = true;
                        pairFound[j + 1] = true;
                    }
                }

                for (int j = 0; j < pairFound.length; j++) {
                    if (!pairFound[j]) {
                        result_SOP.add(minterm_groups.get(i).get(j));
                    }
                }
            }
        }

        //Step-4: final Result.
        for (Integer integer : minterms) {
            result_SOP.add(getPairedMinterms(-1, totalBits, integer, -1));
        }

        boolean[] pairFound = new boolean[result_SOP.size()];
        for (int i = 0; i < result_SOP.size() - 1; i++) {
            String temp_a = result_SOP.get(i).getBit_string();
            String temp_b = result_SOP.get(i + 1).getBit_string();
            int location = -1;
            int bitDiff = 0;
            for (int k = 0; k < totalBits; k++) {
                if (temp_a.charAt(k) != temp_b.charAt(k)) {
                    location = k;
                    bitDiff++;
                }
            }

            if (location != -1 && bitDiff == 1) {
                char[] temp_ch_array = temp_a.toCharArray();
                temp_ch_array[location] = '_';
                Minterm_Group group = new Minterm_Group(String.valueOf(temp_ch_array));
                group.addToGroupedMintermsList(result_SOP.get(i).getGroupedMinterms());
                group.addToGroupedMintermsList(result_SOP.get(i + 1).getGroupedMinterms());
                result_SOP_final.add(group);
                pairFound[i] = true;
                pairFound[i + 1] = true;
            }
        }

        for (int i = 0; i < pairFound.length; i++) {
            if (pairFound[i]) {
//                result_SOP.remove(i);
            } else {
                result_SOP_final.add(result_SOP.get(i));
            }
        }

        final long endTime = System.nanoTime();

        for (int i = 0; i < minterm_groups.size(); i++) {
            System.out.println(minterm_groups.get(i));
        }

        for (Minterm_Group group : result_SOP_final) {
            System.out.println(group.getBit_string() + "    " + convertToVariables(group.getBit_string()));
        }

        System.out.print("Result: ");
        for (Minterm_Group group : result_SOP_final) {
            if (result_SOP_final.indexOf(group) < (result_SOP_final.size() - 1)) {
                System.out.print(convertToVariables(group.getBit_string()) + " + ");
            } else {
                System.out.print(convertToVariables(group.getBit_string()));
            }
        }

        System.out.println();

        System.out.println("Total execution time: " + ((double) (endTime - startTime) / 1000000) + " mili.Sec");

    }

    public static Minterm_Group getPairedMinterms(int location_X, int totalBits, int a, int b) {
        String str = "";
        int x;
        for (int i = 0; i < totalBits; i++) {
            x = a % 2;
            if (x == 0) {
                str = 0 + str;
            } else {
                str = 1 + str;
            }
            a /= 2;
        }

        if (location_X != -1) {
            char[] ch = str.toCharArray();
            ch[totalBits - location_X - 1] = '_';
            str = String.valueOf(ch);
        }
        Minterm_Group mintermGroup = new Minterm_Group(str);
        mintermGroup.addToGroupedMinterms(a, b);
        return mintermGroup;
    }

    public static String convertToVariables(String bitString) {
        String temp_String = "";

        for (int i = 0; i < bitString.length(); i++) {
            if (bitString.charAt(i) == '0') {
                char temp_char;
                temp_char = (char) ('a' + i);
                temp_String += String.valueOf(temp_char);
            } else if (bitString.charAt(i) == '1') {
                char temp_char;
                temp_char = (char) ('A' + i);
                temp_String += String.valueOf(temp_char);
            }
        }

        return temp_String.trim();
    }

}
