import java.util.Scanner;

public class Q4_21 {

    public static void main(String[] args) {
        System.out.print("Enter a SSN: ");
        Scanner input = new Scanner(System.in);
        String ssn = input.nextLine();
        if (SSNValidation.validate(ssn))
            System.out.println(ssn + " is a valid social security number");
        else
            System.out.println(ssn + " is an invalid social security number");
    }
}

class SSNValidation {
    static boolean validate(String input) {
        if (input.length() != 11)
            return false;
        if (!(input.charAt(3) == '-' && input.charAt(6) == '-'))
            return false;
        for (char tmp: input.substring(0,2).toCharArray()) {
            if(!Character.isDigit(tmp))
                return false;
        }
        for (char tmp: input.substring(4,5).toCharArray()) {
            if(!Character.isDigit(tmp))
                return false;
        }
        for (char tmp: input.substring(7,10).toCharArray()) {
            if(!Character.isDigit(tmp))
                return false;
        }
        return true;
    }
}