public class Test {

    public static void main(String[] args) {

        stringSum("456text54");
        stringSum("45654");

    }

    public static void stringSum(String str) {
        int sum = 0;
        try {
            int value = Integer.parseInt(str);
            while (value != 0) {
                sum += value % 10;
                value /= 10;
            }
        } catch (NumberFormatException err) {
            System.out.println(err.toString());
        }
        System.out.println(sum);
    }
}



