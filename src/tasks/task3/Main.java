package tasks.task3;

public class Main {
    public static int getValue(char a){
        if (a >= '0' && a <= '9')
            return a - '0';
        if (a >= 'A' && a <= 'F')
            return 10 + a - 'A';
        if (a >= 'a' && a <= 'f')
            return 10 + a - 'a';
        return -1;
    }
    public static long getDecimal(String value) {
        long result = 0L;

        int len = value.length();
        for (int i = len - 1 ; i >= 0; i--) {
            int cur = getValue(value.charAt(i));
            if (cur == -1) {
                System.out.println("Not a hexadecimal");
                return -1L;
            }
            result += Math.pow(16, len - i - 1) * cur;
        }

        return result;
    }

    public static void main(String[] args) {
        String a = "FF";
        String[] arr = a.split("");

        System.out.println(getDecimal(a));
        System.out.println(Long.decode("0x" + a));
    }
}