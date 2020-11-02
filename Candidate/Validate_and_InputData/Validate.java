 package Validate_and_InputData;

import Entities.Candidate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


public class Validate {

    //check duplicate id of list candidate
    public boolean checkDuplicateID(ArrayList<Candidate> candi, String id) {

        //loop begin at first ID element, come to next ID element 
        //and stop at last ID element
        for (int i = 0; i < candi.size(); i++) {
            //compare id check with id of candidate
            if (candi.get(i).getID().equalsIgnoreCase(id)) {
                System.err.println("Duplicate ID. Enter other ID, please!");
                return false;
            }
        }
        return true;
    }
   public boolean checkDuplicateEmail(ArrayList<Candidate> candi, String email) {
        //loop begin at first ID element, come to next ID element 
        //and stop at last ID element
        for (int i = 0; i < candi.size(); i++) {
            //compare id check with id of candidate
            if (candi.get(i).getEmail().equalsIgnoreCase(email)) {
                System.err.println("Duplicate Email. Enter other Email, please!");
                return false;
            }
        }
        return true;
    }
   public boolean checkDuplicatePhone(ArrayList<Candidate> candi, String phone) {

        //loop begin at first ID element, come to next ID element 
        //and stop at last ID element
        for (int i = 0; i < candi.size(); i++) {
            //compare id check with id of candidate
            if (candi.get(i).getPhone().equalsIgnoreCase(phone)) {
                System.err.println("Duplicate phone. Enter other phone, please!");
                return false;
            }
        }
        return true;
    }
    public static int checkYearEXP(ArrayList<Candidate> candi, int birthDate){
          int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;
        while (true) {
            int yearExperience = InputData.inputIntegerNumber(0, 100,
                "Enter Year of Experience: ");
            if (yearExperience > age) {
                System.err.println("Experience must be smaller than age");
            } else {
                return yearExperience;
            }
        }
    }
    public static int checkGraduationDate(ArrayList<Candidate> candi,int birthDate) {
        Scanner in = new Scanner(System.in);
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        //loop until user input correct
        while (true) {
            
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < birthDate || result > yearCurrent) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("The graduation date must be greater than the year of birth and smaller than the current year");
                System.out.print("Enter again: ");
            }
        }
    }
    
     
}
