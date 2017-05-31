/**
 * Created by msrabon on 10-May-17.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println("nanotime experiment");
//        for (int i = 0; i < 10; i++) {
//            final long startTime = System.nanoTime();
//            Thread.sleep(1000);
//            final long endTime = System.nanoTime();
//            System.out.println(i + " Total execution time: " + (double) (endTime - startTime) / 1000000);
//        }
//
//        System.out.println("Currentmillis experiment");
//        for (int i = 0; i < 10; i++) {
//            final long startTime = System.currentTimeMillis();
//            Thread.sleep(1000);
//            final long endTime = System.currentTimeMillis();
//            System.out.println(i + " Total execution time: " + (double) (endTime - startTime));
//        }

        String s = "1011";
        String s1 = "1x11";
        for (int j = 0; j <s.length() ; j++) {
            if ((s.charAt(j) != s1.charAt(j))&&(s1.charAt(j)=='x')){
                System.out.println(s.charAt(j) + "  " + s1.charAt(j));
            }
        }
    }
}
