import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Validation {

    //check user input number limit
    public static int checkInputIntLimit(int min, int max) {
        Scanner in = new Scanner(System.in);
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //check input account perform language
    public static String checkInputAccount() {
        //only accepts numbers containing 10 numbers
        String ACCOUNT_NUMBER_VALID = "^\\d{10}$";
        Language language = new Language();
        Scanner in = new Scanner(System.in);
        while (true) {
            String result = in.nextLine();
            //check if number account matches regex, return result  
            if (result.matches(ACCOUNT_NUMBER_VALID)) {
                return result;
            }//else print error
            System.out.println(language.errCheckInputAccount);
            System.out.print(language.enterAccountNumber);
        }
    }
    // check input of pass word just accpect regex char

    public static String checkInputPassword() {
        Language language = new Language();
        String result;
        while (true) {
            result = checkInputString();
            if (isValidPassword(result)) {
                return result;
            }
            System.out.print(language.enterPassword);
        }
    }
//check the valid of password, let user input every all characters  

    public static boolean isValidPassword(String password) {
        Language language = new Language();
        int lengthPassword = password.length();
        //check length of password in range (8,31)
        if (lengthPassword < 8 || lengthPassword > 31) {
            System.out.print(language.errCheckPassword);
            System.out.println();
            return false;
        } else {
            //count digit and letter
            int countDigit = 0;
            int countLetter = 0;
            for (int i = 0; i < lengthPassword; i++) {
                if (Character.isDigit(password.charAt(i))) {//check number in password
                    countDigit++;
                } else if (Character.isLetter(password.charAt(i))) {//check letter in password
                    countLetter++;
                }
            }
            //if missing digit or letter , return false and let user input again
            if (countDigit < 1 || countLetter < 1) {
                System.out.println(language.errCheckPassword);

                return false;
            }
        }
        return true;
    }
    //check input from keybroad of user

    public static String checkInputString() {
        Language language = new Language();
        Scanner in = new Scanner(System.in);
        while (true) {
            String result = in.nextLine();
            if (result.length() == 0) {
                System.out.println(language.errCheckInputIntLimit);

            } else {
                return result;
            }
        }
    }

//auto genarate string captcha
    public static String generateCaptchaText(int n) {
        //chars to genarete captcha among this alphabet   
        String CHARECTERS = "1234567890QWERTYUIOPASDFGHJKLZXCVBNM";
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            char ch = CHARECTERS.charAt(random.nextInt(CHARECTERS.length()));
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
    //check input captcha random genarate, if pair 1 char return true

    public static boolean checkInputCaptcha(String captchaGenerated) {
        Language language = new Language();
        System.out.print(language.enterCaptcha);
        String captchaInput = checkInputString();
        //run from start to the end captcha length and find if input captcha it contains return true.
        for (int i = 0; i < captchaInput.length(); i++) {
            if (!captchaGenerated.contains(Character.toString(captchaInput.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    //check account matches
    public static boolean checkAccountMatches(ArrayList<Account> accounts, String accountNumber,
            String passWord) {
        for (Account account : accounts) {
            if (accountNumber.equalsIgnoreCase(account.getAccountNumber())
                    && passWord.equalsIgnoreCase(account.getPassWord())) {
                return true;
            }
        }
        return false;
    }
}
