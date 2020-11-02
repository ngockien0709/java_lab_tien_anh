package Entities;

import Validate_and_InputData.InputData;
import Validate_and_InputData.Validate;
import java.util.ArrayList;

public class Experience extends Candidate {

    private int explnYear;
    private String proSkill;

    public Experience() {
    }

    public Experience(int explnYear, String proSkill, String ID, String firstName, String lastName, int birthDate, String address, String phone, String email, int type) {
        super(ID, firstName, lastName, birthDate, address, phone, email, type);
        this.explnYear = explnYear;
        this.proSkill = proSkill;
    }

    public void setExplnYear(int explnYear) {
        this.explnYear = explnYear;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    // create experience candidate
    public void createCandidateExperience(ArrayList<Candidate> candi) {
        System.out.println("-------- Experience candidate --------");
        // extends candidate method
        super.createCandidate(candi);

        type = 0;

        explnYear = Validate.checkYearEXP(candi, birthDate);
        proSkill = InputData.inputWord(InputData.AlphaBetNumber, "Enter ProSkill: ",
                "ProSkill must not contain special character. Try again!");

        System.out.println("Create Successful!");
    }

}
