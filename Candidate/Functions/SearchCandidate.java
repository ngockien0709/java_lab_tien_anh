package Functions;

import Entities.*;
import Validate_and_InputData.InputData;
import java.util.ArrayList;


public class SearchCandidate {

    //Search function with first name, last name and type of candidate
    public static void searchCandidate(ArrayList<Candidate> candi) {
        printListNameCandidate(candi);
    
        String nameFind;
        int typeFind, count = 0;
        System.out.println("-------- Search candidate --------");
        nameFind = InputData.inputWord(InputData.AlphaBet,
                "Input Candidate name (First name or Last name): ",
                "Name contain only alphabet. Try again!");
        typeFind = InputData.inputIntegerNumber(0, 2, "Input type of candidate: ");

        //loop begin at first candidate element, come to next candidate element 
        //and stop at last candidate element
        for (int i = 0; i < candi.size(); i++) {
            //compare search name, id with candidate list first name, last name, id
            if ((candi.get(i).getFirstName().toLowerCase().contains(nameFind.toLowerCase())
                    || candi.get(i).getLastName().contains(nameFind))
                    && typeFind == candi.get(i).getType()) {
                count++;
                //check the first candidate is found
                if (count == 1) {
                    System.out.println("The candidates found:");
                }
                System.out.println(candi.get(i));
            }
        }

        //check not found candidate
        if (count == 0) {
            System.err.println("Not found!");
        }
    }
     //display list name candidate
    public static void printListNameCandidate(ArrayList<Candidate> candi) {
        System.out.println("===== Experience Candidate ===== ");
        for (Candidate candidate : candi) {
            // display name of experience candidate
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.out.println("===== Fresher Candidate =====");
        for (Candidate candidate : candi) {
            // display name of fresher candidate
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.out.println("===== Internship Candidate ===== ");
        for (Candidate candidate : candi) {
            // display name of intership candidate
            if (candidate instanceof Intership) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
    }
    
}
