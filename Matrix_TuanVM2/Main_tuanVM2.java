/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix_tuanvm2;

/**
 *
 * @author macma
 */
public class Main_tuanVM2 {
    public static void main(String[] args) {
        while(true){
            int choice = Manager.menu();
            switch(choice){
                case 1:
                    Manager.additionMatrix();
                    break;
                case 2:
                    Manager.subtractionMatrix();
                    break;
                case 3:
                    Manager.multiplicationMatrix();
                    break;
                case 4:
                    return;
                          
            }
        }
    }
}
