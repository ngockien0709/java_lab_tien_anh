/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

/**
 *
 * @author Admin
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    //bài này có rất nhiều cách làm
    //đây là cách sự dụng đệ quy nhanh nhất đúng theo yêu cầu đề bài 
    
  
    
   static void fibonacci(int count,int fibo0, int fibo1){
        int result;
        if(count >2){
            result = fibo0 + fibo1;
            fibo0 = fibo1;
            fibo1 = result;
            System.out.print(", "+result);
            count--;
            fibonacci(count, fibo0, fibo1);
        }
    }
    
    public static void main(String[] args) {
       
        // TODO code application logic here
        System.out.print("0");
        System.out.print(", 1");
        fibonacci(45               ,0,1);
    }
    
}
