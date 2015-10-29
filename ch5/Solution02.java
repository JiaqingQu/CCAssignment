package ch5;

public class Solution02 {

    public static void main(String[] args) {
        System.out.println(printDoubleBinary(0.75));
    }

    /**
     * Suppose that num = 0.n1n2n3...(decimal) = 0.x1x2x3...(binary)
     * We can multiply num by 2 and get the radix part one by one
     * */
    private static String printDoubleBinary(double num) {

        StringBuilder binary = new StringBuilder();
        binary.append("0.");

        while (num > 0) {


            num = num * 2;

            if (num >= 1) {
                num = num - 1;
                binary.append(1);
            } else {
                binary.append(0);
            }

            if(binary.length() > 32) {
                return "OutOfBound";
            }

        }

        return binary.toString();
    }


}
