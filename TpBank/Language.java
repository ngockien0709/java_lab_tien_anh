
import java.util.ResourceBundle;

public class Language {

    public String errorCheckInputIntLimit;
    public String errCheckInputIntLimit;
    public String errCheckInputAccount;
    public String errCheckPassword;
    public String errCaptchaIncorrect;
    public String enterCaptcha;
    public String enterAccountNumber;
    public String enterPassword;
    public String loginSuccess;
    public String loginFail;

    public Language() {
        ResourceBundle rb = ResourceBundle.getBundle("Language");
        errorCheckInputIntLimit = rb.getString("errorCheckInputIntLimit");
        errCheckInputIntLimit = rb.getString("errCheckInputIntLimit");
        errCheckInputAccount = rb.getString("errCheckInputAccount");
        errCheckPassword = rb.getString("errCheckPassword");
        errCaptchaIncorrect = rb.getString("errCaptchaIncorrect");
        enterCaptcha = rb.getString("enterCaptcha");
        enterAccountNumber = rb.getString("enterAccountNumber");
        enterPassword = rb.getString("enterPassword");
        loginSuccess = rb.getString("loginSuccess");
        loginFail = rb.getString("loginFail");
    }

}
