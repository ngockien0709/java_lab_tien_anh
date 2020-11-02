import java.util.Locale;
import java.util.ArrayList;

public class Main {

    //login function
    public static void login() {
        Language language = new Language();
        // create account 
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("1234567890", "123456ab"));
        accounts.add(new Account("1234567899", "ahihi123"));
        while (true) {
            System.out.print(language.enterAccountNumber);
            String accountNumber = Validation.checkInputAccount();//enter account by language
            System.out.print(language.enterPassword);
            String passString = Validation.checkInputPassword();//enter password by language
            String captchaGenerated = Validation.generateCaptchaText(5);
            System.out.println("Captcha: " + captchaGenerated);
            // check captcha
            while (true) {
                if (Validation.checkInputCaptcha(captchaGenerated)) {
                    // check account number and password
                    if (Validation.checkAccountMatches(accounts, accountNumber, passString)) {
                        System.out.println(language.loginSuccess);
                        return;
                    } else {
                        System.out.println(language.loginFail);
                    }
                } else {
                    System.out.println(language.errCaptchaIncorrect);
                }
            }
        }
    }

    //display menu
    public static int menu() {
        System.out.println("----- Login Program -----");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        System.out.print("Please choice one option: ");
        int choice = Validation.checkInputIntLimit(1, 3);
        return choice;
    }

    public static void main(String[] args) {
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    Locale.setDefault(new Locale("vi", "VN"));
                    login();
                    break;
                case 2:
                    Locale.setDefault(new Locale("en", "US"));
                    login();
                    break;
                case 3:
                    return;
            }
        }
    }
}

