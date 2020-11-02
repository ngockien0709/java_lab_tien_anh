package Entities;

import Validate_and_InputData.InputData;
import Validate_and_InputData.Validate;
import java.util.ArrayList;

public class Candidate {

    protected String ID;
    protected String firstName;
    protected String lastName;
    protected int birthDate;
    protected String address;
    protected String phone;
    protected String email;
    protected int type;

    protected Candidate() {
    }

    protected Candidate(String ID, String firstName, String lastName, int birthDate, String address, String phone, String email, int type) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.type = type;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    protected void createCandidate(ArrayList<Candidate> candi) {

        InputData input = new InputData();
        Validate valid = new Validate();
        //loop until have error or command "break"
        while (true) {
            ID = input.inputWord(InputData.AlphaBetNumber, "Enter candidate ID: ",
                    "ID must not contain any special character. Try again!");
            // check id exist
            if (valid.checkDuplicateID(candi, ID)) {
                break;
            }
        }
        firstName = input.inputWord(InputData.AlphaBet, "Enter first name: ",
                "First name contain only alphabet. Try again!");
        lastName = input.inputWord(InputData.AlphaBet, "Enter last name: ",
                "First name contain only alphabet. Try again!");
        //regex contain four number
        birthDate = input.inputIntegerNumber(1900, 2019, "Enter birthdate: ");
        address = input.inputWord(InputData.AlphaBetNumber, "Enter address: ",
                "Address must not contain special character. Try again!");

        while (true) {
            //regex contain at least 10 number
            phone = input.inputWord("\\d{10,}", "Enter phone: ",
                    "Phone is number with minimum 10 characters. Try again!");
            // check phone duplicate
            if (valid.checkDuplicatePhone(candi, phone)) {
                break;
            }
        }

        while (true) {
            //regex check email contain: begin with more nhan one alphabet and number
            //next is @, next is domain and dot, dot between true domain
            email = input.inputWord("^[a-zA-Z0-9]+\\@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)+",
                    "Enter email: ", "Email must be with format <account name>@<domain>.");
            // check email duplicate 
            if (valid.checkDuplicateEmail(candi, email)) {
                break;
            }
        }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " | " + birthDate + " | "
                + address + " | " + phone + " | " + email + " | " + type;
    }

}
