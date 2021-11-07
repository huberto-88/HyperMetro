import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder s = new StringBuilder(scanner.next());
        System.out.println(s.toString().equals(s.reverse().toString()) ? 1 : 37);
    }
}
