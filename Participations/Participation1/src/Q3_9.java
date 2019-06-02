import java.util.Scanner;

public class Q3_9 {
    public static void main(String[] args) {
        ISBNChecksum checksum = new ISBNChecksum();
        checksum.solve();
    }
}

class ISBNChecksum {
    String ISBN9;

    void getUserInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first 9 digits of an ISBN as integer: ");
        ISBN9 = input.nextLine();
    }

    void solve() {
        this.getUserInput();
        int result = 0;
        for (int i = 0; i < ISBN9.length(); i++) {
            int tmp = ISBN9.charAt(i) - '0';
            result += tmp*(i + 1);
        }
        result %= 11;
        if (result != 10) {
            System.out.format("The ISBN-10 number is %s%d\n", ISBN9, result);
        } else if (result == 10) {
            System.out.format("The ISBN-10 number is %sX\n", ISBN9);
        }

    }
}