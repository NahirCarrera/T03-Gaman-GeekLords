package ec.edu.espe.managementsoftware.controller;

import ec.edu.espe.managementsoftware.model.Product;
import ec.edu.espe.managementsoftware.view.ManagementSoftware;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Nahir Carrera, Gaman GeekLords, DCC0-ESPE
 */
public class InventoryReport {
    private static int getMenuChosenOption(Scanner scannerKeyboard){
        int chosenInventoryReportMenuOption; 
        try{
            printMenu();
            chosenInventoryReportMenuOption = scannerKeyboard.nextInt();
        }catch(InputMismatchException error){
            return 4;
        }
    return chosenInventoryReportMenuOption; 
    }
    
    public static void runMenu(Scanner scannerKeyboard){
        int chosenInventoryReportMenuOption = getMenuChosenOption(scannerKeyboard);
        ArrayList<Product> productsForInventoryReport = Inventory.readProductsFromFile();
        switch(chosenInventoryReportMenuOption){
            case 1->{
                generateStockReport(productsForInventoryReport );
                runMenu(scannerKeyboard);
                break;
            }
            case 2->{
                generateShortageReport(productsForInventoryReport);
                runMenu(scannerKeyboard);
                break;
                }
            case 3->{
                System.out.println("\t\tTOTAL REPORT");
                generateStockReport(productsForInventoryReport );
                generateShortageReport(productsForInventoryReport);
                runMenu(scannerKeyboard);
            }
            case 4->{
                Report.runMenu(scannerKeyboard);
            }
            case 5->{
                ManagementSoftware.runMainMenu(scannerKeyboard);
            }
            default->{
                ManagementSoftware.printWrongOptionErrorMessage();
                runMenu(scannerKeyboard);  
            }

        }
    }
    public static void generateStockReport(ArrayList<Product> productsForInventoryReport ){
        ArrayList<Product> productsInStock = new ArrayList<>();
        for(Product product: productsForInventoryReport){
            if (product.getQuantity()>3){
                productsInStock.add(product);
            }
        }
        System.out.println("\t\tPRODUCTS IN STOCK");
        Inventory.printProductsTable(productsInStock);
    }
    public static void generateShortageReport(ArrayList<Product> productsForInventoryReport){
        ArrayList<Product> productsInShortage = new ArrayList<>();
        for(Product product: productsForInventoryReport){
            if (product.getQuantity()<=3){
                productsInShortage.add(product);
            } 
        }
        System.out.println("\t\tPRODUCTS IN SHORTAGE");
        Inventory.printProductsTable(productsInShortage);
    }
    private static void printMenu(){
        String inventoryReportMenu = """
                  ______________________________________________________
                 /                                                     / 
             (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><><)==(O)
                  /''''''''''''''''''''''''''''''''''''''''''''''''''''''/
                 (       "ENTRE HILOS & ALGODON" MANAGMENT SOFTWARE     (
                  )                  INVENTORY REPORT                    )
                 (    -------------------      ----------------------   (
                  )  | 1. Products Stock |    | 2. Products Shortage |   )
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
        System.out.println(inventoryReportMenu);
                      
    }
}
