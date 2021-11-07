import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String rank;
        if (n < 1) rank = "no army";
        else if(n > 0 && n < 20)  rank = "pack";
        else if (n > 19 && n < 250) rank = "throng";
        else if (n > 999) rank = "legion";
        else rank = "zounds";

        System.out.println(rank);
    }
}