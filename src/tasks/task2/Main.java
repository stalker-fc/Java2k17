package tasks.task2;

public class Main {
    public static String decode(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 'a' && c <= 'm' || c >= 'A' && c <= 'M')
                c += 13;
            else if (c >= 'n' && c <= 'z' || c >= 'N' && c <= 'Z')
                c -= 13;
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "lOOOolks";
        System.out.println(input);
        System.out.println(decode(input));
        System.out.println(decode(decode(input)));
    }
}