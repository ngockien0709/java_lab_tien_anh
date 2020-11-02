
import Entities.Candidate;
import Entities.Experience;
import Entities.Fresher;
import Entities.Intership;
import Functions.*;
import Validate_and_InputData.InputData;
import java.util.ArrayList;


public class Main {
    //menu option
    public static void menuOption() {
        System.out.println("CANDIDATE MANAGEMENT SYSTEM\n"
                + "1. Experience\n"
                + "2. Fresher\n"
                + "3. Internship\n"
                + "4. Searching\n"
                + "5. Exit\n"
                + " (Please choose 1 to Create Experience Candidate, 2 to Create Fresher Candidate,"
                + " 3 to Internship Candidate, 4 to Searching and 5 to Exit program).");
       
    }
    public static void main(String[] args) {  
        ArrayList<Candidate> candi = new ArrayList<>();
        candi.add(new Experience(4, "Code","1", "a", "hihi", 1999, "hanoi", "0123456789", "ahihi@gmail.com", 0));
        candi.add(new Experience(2, "Code","4", "a", "hehi", 1990, "hanoi", "0123456788", "hehi@gmail.com", 0));
        candi.add(new Fresher(2019, "good", "FPTU", "2", "i", "hihi", 1999, "hanoi", "1234567890", "ihihi@gmail.com", 1));
        candi.add(new Intership("PRJ", "fall", "FPTU", "3", "e", "hehe", 1999, "hanoi", "1231231230", "ehehe@gmail.com", 2));      
        int optionNumber;
        
        //loop until have error or command "break"
        while (true) {
            menuOption();
            optionNumber = InputData.inputIntegerNumber(1, 5, "Enter option number: ");
            System.out.println("");
            //check option number and go to case of it
            switch (optionNumber) {
                case 1:
                    CreateCandidate.createCandidateWithType(0, candi);
                    System.out.println("");
                    continue;
                case 2:
                    CreateCandidate.createCandidateWithType(1, candi);
                    System.out.println("");
                    continue;
                case 3:
                    CreateCandidate.createCandidateWithType(2, candi);
                    System.out.println("");
                    continue;
                case 4:
                    SearchCandidate.searchCandidate(candi);
                    System.out.println("");
                    continue;
                case 5:
                    return;
            }
        }
    }
}
