/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.managementsoftware.controller;

import ec.edu.espe.managementsoftware.model.Order;
import ec.edu.espe.managementsoftware.view.ManagementSoftware;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Nahir Carrera, Gaman GeekLords, DCC0-ESPE
 */
public class AgendaReport {
    private static int getMenuChosenOption(Scanner scannerKeyboard){
        int chosenAgendaReportMenuOption; 
        try{
            printMenu();
            chosenAgendaReportMenuOption = scannerKeyboard.nextInt();
        }catch(InputMismatchException error){
            return 6;
        }
    return chosenAgendaReportMenuOption; 
    }
    public static void runMenu(Scanner scannerKeyboard){
        int chosenAngendaReportMenuOption = getMenuChosenOption(scannerKeyboard);
        ArrayList<Order> ordersForAgendaReport = Agenda.readOrdersFromFile();
        switch(chosenAngendaReportMenuOption){
            case 1->{
                generatePendingOrdersReport(ordersForAgendaReport);
                runMenu(scannerKeyboard);
                break;
            }
            case 2->{
                generateCompletedOrdersReport(ordersForAgendaReport);
                runMenu(scannerKeyboard);
                break;
            }
            case 3->{
                System.out.println("\t\tTOTAL REPORT");
                generatePendingOrdersReport(ordersForAgendaReport);
                generateCompletedOrdersReport(ordersForAgendaReport);
                runMenu(scannerKeyboard);
                break;
            }
            case 4->{
                Report.runMenu(scannerKeyboard);
                break;
            }
            case 5->{
                ManagementSoftware.runMainMenu(scannerKeyboard);
                break;
            }
            default->{
                ManagementSoftware.printWrongOptionErrorMessage();
                runMenu(scannerKeyboard);  
            }

        }
    }
    public static void generatePendingOrdersReport(ArrayList<Order> ordersForAgendaReport){
        ArrayList<Order> pendingOrders = new ArrayList<>();
        for(Order order: ordersForAgendaReport){
            if (!order.getIsDelivered()){
                pendingOrders.add(order);
            }
        }
        System.out.println("-> PENDING ORDERS");
        Agenda.printOrdersTable(pendingOrders);
    }
    public static void generateCompletedOrdersReport(ArrayList<Order> ordersForAgendaReport){
        ArrayList<Order> completedOrders = new ArrayList<>();
        for(Order order: ordersForAgendaReport){
        if (order.getIsDelivered()){
            completedOrders.add(order);
            }
        }
        System.out.println("->COMPLETED ORDERS");
        Agenda.printOrdersTable(completedOrders);
    }
    
    private static void printMenu(){
        String agendaReportMenu = """
                          ______________________________________________________
                         /                                                     / 
                     (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><><)==(O)
                          /''''''''''''''''''''''''''''''''''''''''''''''''''''''/
                         (       "ENTRE HILOS & ALGODON" MANAGMENT SOFTWARE     (
                          )                    AGENDA REPORT                     )
                         (    -------------------      ---------------------    (
                          )  | 1. Pending Orders |    | 2. Completed Orders  |   )
                              -------------------      ----------------------   (                                                      (
                          )               --------------------------             )
                         (               |     3. Total Report      |           (
                          )               --------------------------             )
                          )               --------------------------             )
                         (               |  4. Back to Report Menu  |           (
                          )               --------------------------             )
                          )               --------------------------             )
                         (               |    5. Back to Main Menu  |           (
                          )               --------------------------             )
                         / ''''''''''''''''''''''''''''''''''''''''''''''''''''''/    
                     (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><><)==(O)
                          /______________________________________________________/
                                          WHAT DO YOU WANT TO DO? 
                   """;
        System.out.println(agendaReportMenu);
    }
}
