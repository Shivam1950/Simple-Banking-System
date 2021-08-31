package banking;
import java.util.*;

public class Main {
    
    private static final Scanner cin = new Scanner(System.in);
    private static final Random rand = new Random();
    
    private static String[][] cardDetails =new String[100][3];
    //[][0] = card Number; [][1] = pin; [][2] = balance
    private static int currentLogInIndex = 0;
    private static int currentAccIndex = 0;
    
    private static boolean checkCred(String userCard, String userPin) {
        for (int i = 0; i < currentAccIndex; i++) {
            if (cardDetails[i][0].equals(userCard)) {
                if(cardDetails[i][1].equals(userPin)) {
                    currentLogInIndex = i;
                    return true;
                }
            }
        }
        return false;
    }
    
    private static void accountOptions() {
        boolean dontStop = true;
        do {    
            System.out.println("1. Balance");
            System.out.println("2. Log out");
            System.out.println("0. Exit");
            int userChoice = cin.nextInt();
            switch (userChoice) {
                case 1 :
                    System.out.println("Balance: " + cardDetails[currentLogInIndex][2]);
                    break;
                case 2 :
                    dontStop = false;
                    System.out.println("You have successfully logged out!");
                    break;
                case 0 :
                    System.out.println("Bye!");
                    System.exit(0);
            }
        } while (dontStop);
        
    }
    
    private static void accountLogin() {
        cin.nextLine();
        System.out.println("Enter your card number:");
        String userCardInput = cin.nextLine();
        System.out.println("Enter your PIN:");
        String userPinInput = cin.nextLine();
        boolean isValid = checkCred(userCardInput, userPinInput);
        if (isValid) {
            System.out.println("You have successfully logged in!");
            accountOptions();
        } else {
            System.out.println("Wrong card number or PIN!");
        }
    }
    
    private static String generateCheckDigit(String tempCard) {
        int sumDigit = 0;
        for (int i = 0; i < tempCard.length(); i++) {
            int digit = Integer.parseInt(tempCard.charAt(i) + "");
            if(i % 2 == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sumDigit += digit;
        }
        return String.valueOf((10 - (sumDigit % 10)) % 10);
    } 
    
    private static void generateCard() {
        String tempCard = "";
        String tempPin = "";
        boolean flag = false;
        do {
            String first = "400000";
            String mid = String.format("%09d", rand.nextInt(1000000000));
            tempPin = String.format("%04d", rand.nextInt(10000));
            tempCard = first + mid + generateCheckDigit(first + mid);
            for (int i = 0; i < currentAccIndex; i++) {
                if (tempCard == cardDetails[i][0]) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
        } while (flag);
        cardDetails[currentAccIndex][0] = tempCard;
        cardDetails[currentAccIndex][1] = tempPin;
        cardDetails[currentAccIndex][2] = "0";
        currentAccIndex++;
        System.out.println("Your card has been created");
        System.out.println("Your card number:");
        System.out.println(cardDetails[currentAccIndex-1][0]);
        System.out.println("Your card PIN:");
        System.out.println(cardDetails[currentAccIndex-1][1]);
    }
    
    public static void main(String[] args) {
        boolean dontStop = true;
        do {
            System.out.println("1. Create an account");
            System.out.println("2. Log into account");
            System.out.println("0. Exit");
            int userChoice = cin.nextInt();
            switch (userChoice) {
                case 1 :
                    generateCard();
                    break;
                case 2 :
                    accountLogin();
                    break;
                case 0 :
                    dontStop = false;
                    System.out.println("Bye!");
                    break;
            }
        } while (dontStop);
    }
}
