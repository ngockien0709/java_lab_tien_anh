public class Account {
    private String accountNumber;
    private String passWord;

    public Account() {
    }

    public Account(String accountNumber, String passWord) {
        this.accountNumber = accountNumber;
        this.passWord = passWord;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
