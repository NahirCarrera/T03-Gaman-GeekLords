package ec.edu.espe.managementsoftware.view;
//import ec.edu.espe.managmentsoftware.model.Product;
import ec.edu.espe.managementsoftware.controller.Agenda;
import ec.edu.espe.managementsoftware.controller.GeneralMaterialList;
import ec.edu.espe.managementsoftware.controller.Inventory;
import ec.edu.espe.managementsoftware.controller.Registration;
import ec.edu.espe.managementsoftware.controller.Report;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Nahir Carrera, Gaman GeekLords, DCC0-ESPE 
 */

public class ManagementSoftware {

    public static void main(String[] args) {
    Scanner scannerKeyboard = new Scanner(System.in);   
        int chosenRegistrationMenuOption;
        chosenRegistrationMenuOption = Registration.getMenuChosenOption(scannerKeyboard);
        switch(chosenRegistrationMenuOption){
            case 1-> {
                Registration.signIn();
                boolean loginConfirmation = Registration.logIn(scannerKeyboard);
                if (loginConfirmation){
                   runMainMenu(scannerKeyboard);
                }
                break;
            }
            case 2->{
                Registration.signIn();
                boolean loginConfirmation = Registration.logIn(scannerKeyboard);
                if (loginConfirmation){
                   runMainMenu(scannerKeyboard);
                }

            }

        }
    }
           

    private static int getMainMenuChosenOption(Scanner scannerKeyboard){
        int chosenMainMenuOption; 
            try{
                printMainMenu();
                chosenMainMenuOption = scannerKeyboard.nextInt();
            }catch(InputMismatchException error){
                return 5;
            }
       return chosenMainMenuOption; 
    }    
   
    public static void runMainMenu(Scanner scannerKeyboard){
        int chosenMainMenuOption;
        boolean endMainMenu;
        
        do {
            endMainMenu = false;
            chosenMainMenuOption = getMainMenuChosenOption(scannerKeyboard);
            switch(chosenMainMenuOption){
                case 1 -> {
                    Registration.showUserProfile(scannerKeyboard);
                } 
                case 2->{
                    Inventory.runMenu(scannerKeyboard);
                    break;
                }     
                case 3->{
                    Agenda.runMenu(scannerKeyboard);
                    break;
                }
                case 4->{
                    Report.runMenu(scannerKeyboard);
                    break;
                }
                case 5 ->{
                    GeneralMaterialList.runMenu(scannerKeyboard);
                    break;
                }
                case 6 -> {
                    endMainMenu = true;
                    break;
                }
                default -> { 
                    printWrongOptionErrorMessage();
                    runMainMenu(scannerKeyboard);    
                    break;
                }
            } 
        }while(endMainMenu == false);
    }

    private static void printMainMenu(){
        String mainMenu = """
                     ______________________________________________________
                    /                                                     /
                (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><><)==(O)
                     /''''''''''''''''''''''''''''''''''''''''''''''''''''''/
                    (      "ENTRE HILOS & ALGODON" MANAGMENT SOFTWARE      (
                     )                         MENU                         )
                    (      ----------------          ----------------      (
                     )    |  1. Profile    |        |  2. Inventory  |      )
                           ----------------          ----------------      (                                                      (
                     )                                                      )
                    (      ----------------          ----------------      (
                     )    |   3. Agenda    |        |   4. Reports   |      )
                           ----------------          ----------------
                    (                                                      (
                     )     ----------------          ----------------       )
                    (     |  5. Materials  |        |    6. Exit     |     (
                     )     ----------------          ----------------       )
                    (                                                      (
                    / ''''''''''''''''''''''''''''''''''''''''''''''''''''''/
                (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><><)==(O)
                     /______________________________________________________/
                                     WHAT DO YOU WANT TO DO?
              """;
        System.out.println(mainMenu);
    }
    
    public static void printWrongOptionErrorMessage(){
    String message = """
                        \n--------- DEAR USER ----------
                              ENTER A VALID NUMBER
                        ------------------------------\n""";
    System.out.println(message);
    }

    public static void printInputMismatchErrorMessage(){
        String message = """
                            \n--------- DEAR USER ----------
                                 ENTER VALID INFORMATION
                            ------------------------------\n""";
        System.out.println(message);
    }
    
}

