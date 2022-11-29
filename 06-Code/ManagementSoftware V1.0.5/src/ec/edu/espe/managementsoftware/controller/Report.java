package ec.edu.espe.managementsoftware.controller;

import ec.edu.espe.managementsoftware.view.ManagementSoftware;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author Nahir Carrera, Gaman GeekLords, DCC0-ESPE
 */
public class Report {
    
    private static int getMenuChosenOption(Scanner scannerKeyboard){
        int chosenReportsMenuOption; 
        String reportMenu = """
                                  ______________________________________________________
                                 /                                                     / 
                             (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><><)==(O)
                                  /''''''''''''''''''''''''''''''''''''''''''''''''''''''/
                                 (       "ENTRE HILOS & ALGODON" MANAGMENT SOFTWARE     (
                                  )                       REPORTS                        )
                                 (    --------------------      -----------------       (
                                  )  | 1. Inventory Report |  | 2. Agenda Report  |      )
                                      --------------------      -----------------       (                                                      (
                                  )                                                      )
                                 (      ------------------------------------------      (
                                  )    |             3. General Report            |      )
                                        ------------------------------------------
                                 (                                                      (
                                  )             ----------------------------             )
                                 (             |   4. Back to Main Menu     |           (
                                  )             ----------------------------             )
                                 (                                                      (
                                 / ''''''''''''''''''''''''''''''''''''''''''''''''''''''/    
                             (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><><)==(O)
                                  /______________________________________________________/
                                                  WHAT DO YOU WANT TO DO? 
                           """;
        try{
            System.out.println(reportMenu);
            chosenReportsMenuOption = scannerKeyboard.nextInt();
        }catch(InputMismatchException error){
            return 5;
        }
       return chosenReportsMenuOption;
    }
    public static void runMenu(Scanner scannerKeyboard){
        int chosenReportMenuOption = getMenuChosenOption(scannerKeyboard);
        String wrongOptionErrorMessage = """
                        \n--------- DEAR USER ----------
                              ENTER A VALID NUMBER
                        ------------------------------\n""";
        switch(chosenReportMenuOption){
            case 1->{
                InventoryReport.runMenu(scannerKeyboard);
                runMenu(scannerKeyboard);
                break;
            }
            case 2->{
                AgendaReport.runMenu(scannerKeyboard);
                runMenu(scannerKeyboard);
                break;
            }
            case 3->{
                GeneralReport.generateReport();
                runMenu(scannerKeyboard);
                break;
            }
            case 4->{
                ManagementSoftware.runMainMenu(scannerKeyboard);
            }
            default ->{
                System.err.println(wrongOptionErrorMessage);
                runMenu(scannerKeyboard);  
                break;
            }
               
        }
    }
}
