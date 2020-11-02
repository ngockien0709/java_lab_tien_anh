
import java.text.*;
import java.util.*;

public class Main {
    
    
    
    /////////// AE chú ý tự sửa lại chỗ phần input có thể là số double nha, mình quên nhìn kỹ đề :))))
    
    Scanner sc = new Scanner(System.in);
   
    public static void main(String[] args) {
        Main a = new Main();
        a.run();
    }
    public void menu(){
        System.out.println("=============== Calculator Program ==============");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
    }
    public void run(){
        while(true){
            menu();
            int choice = checkchoice("Please choice one option: ");
            switch(choice){
                case 1: 
                            normal();
                            break;
                case 2:
                            BMI();
                            break;
                case 3: return;
            }
        }
    }
    public int checkchoice(String message){
        int a = 0;
        while(true){
            try{
                System.out.print(message);
                a = Integer.parseInt(sc.nextLine());
                if(a  == 1 || a == 2 || a == 3){
                    break;
                } 
                else{
                    System.out.println("Please just enter 1 or 2 or 3");
                }
            }catch(NumberFormatException e){
                System.out.println("Please input number");
            }catch(NullPointerException e){
                System.out.println("Please don't input space!");
            }
        }
        return a;
    }
    
    public int checkNormal(String message){
        int a = 0;
        while(true){
            try{
                System.out.print(message);
                a = Integer.parseInt(sc.nextLine());
                break;
            }catch(NumberFormatException e){
                System.out.println("Please input number");
            }catch(NullPointerException e){
                System.out.println("Please don't input space!");
            }catch(ArithmeticException e){
                System.out.println("Please don't division for 0!");
            }
        }
        return a;
    }
    
    public String Operator(){
        String c = "";
        while(true){
            System.out.print("Enter Operator: ");
            c = sc.nextLine();
            if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") || c.equals("=") || c.equals("^")){
                break;
            }
            else{
                System.out.println("Please input ( +, -, *, /)");
            }
        }
        return c;
    }
    
    public void normal(){
        int a = 0, b = 0;
        System.out.println("-------------- Calculator ----------------");
        a = checkNormal("Enter number: ");
        while(true){
                String c = Operator();
                if(c.equals("=")){
                       break;
                }
                b = checkNormal("Enter number: ");
                if(c.equals("+")){
                    a += b;
                }
                if(c.equals("-")){
                    a -= b;
                }
                if(c.equals("*")){
                    a *= b;
                }
                if(c.equals("/")){
                    if(b == 0){
                        System.out.println("Please don't division for 0!");
                    }
                    else{
                        a /= b;
                    }
                }
                if(c.equals("^")){
                    a = (int) Math.pow(a, b);
                }
                
                System.out.println("Memory: " + a);
        }
        System.out.println("Result: " + a);
    }
    
    public void BMI(){
        NumberFormat nf = new DecimalFormat("#0.000000");
//        NumberFormat nf = new DecimalFormat(".");
        double weight = 0, height = 0, bmi = 0;
        System.out.println("------------ BMI Calculator -----------");
        weight = checkBMI("Enter Weight (kg): ");
        height = checkBMI("Enter Height (m): ");
        bmi = weight /(height * height);
        System.out.println("BMI number: " + nf.format(bmi));
        System.out.println("BMI status: " + statusBMI(bmi));
    }
    
    public double checkBMI(String message){
        double a = 0;
        while(true){
            try{
                System.out.print(message);
                a = Double.parseDouble(sc.nextLine());
                if(a <= 0){
                    System.out.println("Please enter positive integer!");
                }
                else{
                    break;
                }
            }catch(NumberFormatException e){
                System.out.println("BMI is digit");
            }
            
        }
        return a;
    }
    
    public String statusBMI(double n){
        if(n < 19){
            return "UNDER-STANDARD";
        }
        else if(n >= 19 && n < 25){
            return "STANDARD";
        }
        else if(n >= 25 && n < 30){
            return "OVERWEIGHT";
        }
        else if(n >= 30 && n < 40){
            return "FAT - should lose weight";
        }
        else{
            return "VERY FAT - should lose weight immediately";
        }
    } 
}
