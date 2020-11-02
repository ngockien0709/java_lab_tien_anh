package Functions;

import Entities.*;
import Validate_and_InputData.InputData;
import java.util.ArrayList;

public class CreateCandidate {

    //create Candidate with the corresponding type
    public static void createCandidateWithType(int type, ArrayList<Candidate> candi) {
        while (true) {
            //check value of type is equal 0
            switch (type) {
                //check value of type is equal 1
                case 0:
                    Experience exper = new Experience();
                    exper.createCandidateExperience(candi);
                    candi.add(exper);
                    break;
                case 1:
                    Fresher fresh = new Fresher();
                    fresh.createCandidateFresher(candi);
                    candi.add(fresh);
                    break;
                case 2:
                    Intership intern = new Intership();
                    intern.createCandidateIntership(candi);
                    candi.add(intern);
                    break;
            }
            String choose = InputData.inputWord("^[YyNn]", "Do you want to continue (Y/N)?",
                    "You must input letter Y or N. Try again!");
            if (choose.equalsIgnoreCase("N")) {
                break;
            }
        }
    }
}
