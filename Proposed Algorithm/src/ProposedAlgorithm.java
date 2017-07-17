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

        ShowResult showResult = ShowResult.getInstance();
        List<Integer> integerList = new ArrayList<>();
        List<Integer> minterms;
        List<Integer> grp;
        List<Integer> grp_0 = new ArrayList<>();
        List<Integer> grp_1 = new ArrayList<>();
        List<List<Integer>> kMap = new ArrayList<>();
        List<Minterm_Group> minterm_groups = new ArrayList<>();
        List<Minterm_Group> result_SOP = new ArrayList<>();

        boolean pair = false;
        int x, totalBits, max = 0;

        System.out.println("Enter Minterms (input -1 to stop input.): ");
        while ((x = scan.nextInt()) != -1) {
            integerList.add(x);
            if (x > max) {
                max = x;
            }
        }

        final long startTime = System.nanoTime();
        totalBits = (int) Math.ceil((double) Math.log(max) / Math.log(2));

        for (Integer integer : integerList) {
            if (integer % 2 == 0) {
                grp_0.add(integer);
            } else {
                grp_1.add(integer);
            }
        }

        minterms = new ArrayList<>(integerList);
        kMap.add(grp_0);
        kMap.add(grp_1);

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
                                minterm_groups.add(getPairedMinterms(0, totalBits, a, b));
                                break;
                            case 2:
                                pair = true;
                                minterm_groups.add(getPairedMinterms(1, totalBits, a, b));
                                break;
                            case 4:
                                pair = true;
                                minterm_groups.add(getPairedMinterms(2, totalBits, a, b));
                                break;
                            case 8:
                                pair = true;
                                minterm_groups.add(getPairedMinterms(3, totalBits, a, b));
                                break;
                            case 16:
                                pair = true;
                                minterm_groups.add(getPairedMinterms(4, totalBits, a, b));
                                break;
                            case 32:
                                pair = true;
                                minterm_groups.add(getPairedMinterms(5, totalBits, a, b));
                                break;
                            case 64:
                                pair = true;
                                minterm_groups.add(getPairedMinterms(6, totalBits, a, b));
                                break;
                            case 128:
                                pair = true;
                                minterm_groups.add(getPairedMinterms(7, totalBits, a, b));
                                break;
                            case 256:
                                pair = true;
                                minterm_groups.add(getPairedMinterms(8, totalBits, a, b));
                                break;
                            case 512:
                                pair = true;
                                minterm_groups.add(getPairedMinterms(9, totalBits, a, b));
                                break;
                            case 1024:
                                pair = true;
                                minterm_groups.add(getPairedMinterms(10, totalBits, a, b));
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
                    int b = minterms.get(j);
                    pair = false;
                    switch (a ^ b) {
                        case 1:
                            pair = true;
                            minterm_groups.add(getPairedMinterms(0, totalBits, a, b));
                            break;
                        case 2:
                            pair = true;
                            minterm_groups.add(getPairedMinterms(1, totalBits, a, b));
                            break;
                        case 4:
                            pair = true;
                            minterm_groups.add(getPairedMinterms(2, totalBits, a, b));
                            break;
                        case 8:
                            pair = true;
                            minterm_groups.add(getPairedMinterms(3, totalBits, a, b));
                            break;
                        case 16:
                            pair = true;
                            minterm_groups.add(getPairedMinterms(4, totalBits, a, b));
                            break;
                        case 32:
                            pair = true;
                            minterm_groups.add(getPairedMinterms(5, totalBits, a, b));
                            break;
                        case 64:
                            pair = true;
                            minterm_groups.add(getPairedMinterms(6, totalBits, a, b));
                            break;
                        case 128:
                            pair = true;
                            minterm_groups.add(getPairedMinterms(7, totalBits, a, b));
                            break;
                        case 256:
                            pair = true;
                            minterm_groups.add(getPairedMinterms(8, totalBits, a, b));
                            break;
                        case 512:
                            pair = true;
                            minterm_groups.add(getPairedMinterms(9, totalBits, a, b));
                            break;
                        case 1024:
                            pair = true;
                            minterm_groups.add(getPairedMinterms(10, totalBits, a, b));
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
            for (int j = i + 1; j < minterms.size(); j++) {
                int b = minterms.get(j);
                pair = false;
                switch (a ^ b) {
                    case 1:
                        pair = true;
                        minterm_groups.add(getPairedMinterms(0, totalBits, a, b));
                        break;
                    case 2:
                        pair = true;
                        minterm_groups.add(getPairedMinterms(1, totalBits, a, b));
                        break;
                    case 4:
                        pair = true;
                        minterm_groups.add(getPairedMinterms(2, totalBits, a, b));
                        break;
                    case 8:
                        pair = true;
                        minterm_groups.add(getPairedMinterms(3, totalBits, a, b));
                        break;
                    case 16:
                        pair = true;
                        minterm_groups.add(getPairedMinterms(4, totalBits, a, b));
                        break;
                    case 32:
                        pair = true;
                        minterm_groups.add(getPairedMinterms(5, totalBits, a, b));
                        break;
                    case 64:
                        pair = true;
                        minterm_groups.add(getPairedMinterms(6, totalBits, a, b));
                        break;
                    case 128:
                        pair = true;
                        minterm_groups.add(getPairedMinterms(7, totalBits, a, b));
                        break;
                    case 256:
                        pair = true;
                        minterm_groups.add(getPairedMinterms(8, totalBits, a, b));
                        break;
                    case 512:
                        pair = true;
                        minterm_groups.add(getPairedMinterms(9, totalBits, a, b));
                        break;
                    case 1024:
                        pair = true;
                        minterm_groups.add(getPairedMinterms(10, totalBits, a, b));
                        break;
                }
                if (pair) {
                    minterms.remove(minterms.indexOf(b));
                    j--;
                }
                if (pair && minterms.contains(a)) {
                    minterms.remove(minterms.indexOf(a));
                    j -= 2;
                }
            }
        }

        for (Integer integer : minterms) {
            result_SOP.add(getPairedMinterms(-1, totalBits, integer, -1));
        }

        final long endTime = System.nanoTime();
        System.out.println("Total execution time: " + ((double) (endTime - startTime) / 1000000) + " mili.Sec");

        for (int i = 0; i < minterm_groups.size(); i++) {
            System.out.println(minterm_groups.get(i).getBit_string());
        }

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

    public static String getBitString(String bitString, int location_X) {
        char[] ch = bitString.toCharArray();
        ch[location_X] = 'X';
        bitString = ch.toString();
        return bitString;
    }

}
