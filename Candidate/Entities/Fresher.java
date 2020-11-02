package Entities;

import Validate_and_InputData.InputData;
import Validate_and_InputData.Validate;
import java.util.ArrayList;

public class Fresher extends Candidate {

    private int graduation_date;
    private String graduation_rank;
    private String education;

    public Fresher() {
    }

    public Fresher(int graduation_date, String graduation_rank, String education,
            String ID, String firstName, String lastName, int birthDate,
            String address, String phone, String email, int type) {
        super(ID, firstName, lastName, birthDate, address, phone, email, type);
        this.graduation_date = graduation_date;
        this.graduation_rank = graduation_rank;
        this.education = education;
    }

    public void setGraduation_date(int graduation_date) {
        this.graduation_date = graduation_date;
    }

    public void setGraduation_rank(String graduation_rank) {
        this.graduation_rank = graduation_rank;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    // create fresher candidate
    public void createCandidateFresher(ArrayList<Candidate> candi) {
        System.out.println("-------- Fresher candidate --------");
        // extends candidate method
        super.createCandidate(candi);
        InputData input = new InputData();

        type = 1;
        System.out.print("Enter Graduation Date: ");
        graduation_date = Validate.checkGraduationDate(candi, birthDate);
        //regex contain four numbers

        //regex must accept one of four words: Excellence, Good, Fair or Poor
        graduation_rank = input.inputWord("^(Excellence|Good|Fair|Poor)$", "Graduation_rank: ",
                "Rank of Graduation must be with one of 4 values (Excellence, Good, Fair, Poor)");
        education = input.inputWord(InputData.AlphaBetNumber, "Enter school education: ",
                "Education must not contain special character. Try again!");

        System.out.println("Create Successful!");
    }
}
