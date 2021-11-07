import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int h = scanner.nextInt();

        if (h > b) {
            System.out.println("Excess");
        } else if (h < a) {
            System.out.println("Deficiency");
        } else {
            System.out.println("Normal");
        }
    }
}