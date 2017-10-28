package tasks.task1;

public class Main {
    public static int gcdWithRem(int a, int b) {
        while (a != 0 && b != 0) {
            if (Math.abs(a) > Math.abs(b))
                a = Math.abs(a % b);
            else
                b = Math.abs(b % a);
        }
        return Math.abs(a + b);
    }

    public static int gcdWithFloorMod(int a, int b) {
        while (a != 0 && b != 0) {
            if (Math.abs(a) > Math.abs(b))
                a = Math.floorMod(a, b);
            else
                b = Math.floorMod(b, a);
        }
        return a + b;
    }

    public static int gcd(int a, int b){
        while (a != 0 && b != 0) {
            if (Math.abs(a) > Math.abs(b))
                a = a % b;
            else
                b = b % a;
        }
        return a + b;
    }

    public static void main(String[] args) {
        int a = -1;
        int b = -5;

        System.out.println(gcd(a, b));
        System.out.println(gcdWithFloorMod(a, b));
        System.out.println(gcdWithRem(a, b));
    }
}