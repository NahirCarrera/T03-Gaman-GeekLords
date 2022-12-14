package ec.edu.espe.managementsoftware.controller;
import ec.edu.espe.managementsoftware.model.Product;
import ec.edu.espe.managementsoftware.model.Material;
import com.google.gson.Gson;
import ec.edu.espe.managementsoftware.view.ManagementSoftware;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nahir Carrera, Gaman GeekLords, DCC0-ESPE
 */
public class Inventory {
    private static int getUserProfileMenuChosenOption(Scanner scannerKeyboard){
        int chosenInventoryMenuOption; 
        try{
            printMenu();
            chosenInventoryMenuOption = scannerKeyboard.nextInt();
        }catch(InputMismatchException error){
            return 5;
        }
       return chosenInventoryMenuOption; 
    }    
    
    public static void runMenu(Scanner scannerKeyboard){
        int chosenInventoryMenuOption;
        chosenInventoryMenuOption = Inventory.getUserProfileMenuChosenOption(scannerKeyboard);
            switch(chosenInventoryMenuOption){
                case 1-> {
                    addProducts(scannerKeyboard);
                    runMenu(scannerKeyboard);
                    break;
                }
                case 2->{
                    ArrayList<Product> productsList  = readProductsFromFile();
                    printProductsTable(productsList);
                    runMenu(scannerKeyboard);
                    break;
                }
                case 3->{
                    ArrayList<Product> productsList  = readProductsFromFile();
                    printProductsTable(productsList);
                    viewProduct(scannerKeyboard);
                    runMenu(scannerKeyboard);
                    break;
                }
                case 4->{
                    ManagementSoftware.runMainMenu(scannerKeyboard);
                    break;
                }
                   
                default ->{
                    ManagementSoftware.printWrongOptionErrorMessage();
                    runMenu(scannerKeyboard);  
                    break;
                }
            }  
    }
    
    private static void viewProduct(Scanner scannerKeyboard){
        boolean wantToSearchProduct;
        int productId;
        Product foundProduct;
        wantToSearchProduct = true;
        do{
            if (wantToSearchProduct){
                System.out.println("Enter the product ID:");
                productId = scannerKeyboard.nextInt();
                foundProduct = searchProduct(productId);
                printProduct(foundProduct);
                runFoundProductMenu(scannerKeyboard, productId);
                System.out.println("Do you want to search a product? true / false ->"); 
                wantToSearchProduct = scannerKeyboard.nextBoolean();
            }
        }while(wantToSearchProduct);
    }
    
    private static Product searchProduct(int productId){
    ArrayList<Product> productListFromFile  = readProductsFromFile();
    Product foundProduct = new Product();
    for(Product product: productListFromFile){
        if(product.getId()== productId){
            foundProduct = product;
        }
    }
    return foundProduct;
    }
    
    private static void addProducts(Scanner scannerKeyboard){
        int id;
        String name;
        float cost;
        String description;
        ArrayList<Material> materialList  = new ArrayList<>();
        int workingTime;
        int quantity;
        int materialId;
        float materialQuantity;
        boolean wantToAddMaterial;
        boolean wantToAddProduct;
        Material foundMaterial;
        Product newProduct;
        String successOperationMessage = """
                                   \n-----------------------------  DEAR USER  ---------------------------------
                                   The materials list of this product was successfully entered into the system 
                                   ---------------------------------------------------------------------------\n""";
        try{
            do {
                System.out.println("""
                                       \n____||________||_________||________||____
                                       ----||--------||---------||--------||---- 
                                                        NEW PRODUCT""");
                System.out.print("\tID:  "); 
                id = scannerKeyboard.nextInt();
                System.out.print("\tName: "); 
                name = scannerKeyboard.next();
                System.out.print("\tDescription: ");
                description = scannerKeyboard.next();
                System.out.print("\tWorking time (Hours): ");
                workingTime = scannerKeyboard.nextInt();
                System.out.print("\tQuantity: ");
                quantity = scannerKeyboard.nextInt();
                System.out.println("""
                                       \n____||________||_________||________||____
                                       ----||--------||---------||--------||---- """);
                
                System.out.println("\t\tPRODUCT MATERIALS LIST ");
                System.out.println("Dear user: Next you will enter the materials list used for the product you just added");
                GeneralMaterialList.printMaterialsTable();
                    do{
                        System.out.print("\t\tEnter the material ID: ");
                        materialId = scannerKeyboard.nextInt();
                        foundMaterial = GeneralMaterialList.searchMaterial(materialId);
                        System.out.format("\t\tEnter the quantity of %1s used: ", foundMaterial.getName());
                        materialQuantity = scannerKeyboard.nextFloat();
                        foundMaterial.setUnitQuantity(materialQuantity);
                        materialList.add(foundMaterial);
                        System.out.print("\t\tDo you want to add other material? true/false ->");
                        wantToAddMaterial = scannerKeyboard.nextBoolean();

                    }while (wantToAddMaterial);
                System.out.println(successOperationMessage);
                newProduct = new Product(id, name, description, materialList, workingTime, quantity); 
                cost = ProductCostCalculator.calculateTotalProductProductionCost(newProduct);
                newProduct.setCost(cost);
                printProduct(newProduct);
                writeProductToFile(newProduct);
                System.out.print("\t\tDo you wanna add other product? true/false ->");
                wantToAddProduct = scannerKeyboard.nextBoolean();
            }while(wantToAddProduct);

        }catch(InputMismatchException error){
            ManagementSoftware.printInputMismatchErrorMessage();
        }
    }
      
    private static void writeProductToFile(Product productToWrite){
        ArrayList<Product> readedProductsFromFile  = readProductsFromFile(); 
        try(FileWriter fileWriter = new FileWriter("./productDataBase.json");){
            Gson gson = new Gson();
            String productToFile;

            for (Product product: readedProductsFromFile){
                productToFile = gson.toJson(product);
                fileWriter.write(productToFile + "\n");
            }  
            productToFile = gson.toJson(productToWrite);
            fileWriter.write(productToFile + "\n");
            System.out.println("\n---------------------  DEAR USER  -------------------------");
            System.out.println("\t\tProduct ingresed to the System" );
            System.out.println(productToWrite);
            System.out.println("-----------------------------------------------------------\n");
        }catch (IOException ex) {
            Logger.getLogger(GeneralMaterialList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<Product> readProductsFromFile(){
      File productDataBase = new File ("./productDataBase.json");
      ArrayList<Product> productListFromFile  = new ArrayList<>();
      Scanner scProductDataBase;
      try {
          scProductDataBase = new Scanner(productDataBase);
          Product productFromFile;
          Gson gson = new Gson();
          if(scProductDataBase.hasNext()){
             while(scProductDataBase.hasNextLine()){
             productFromFile = gson.fromJson(scProductDataBase.nextLine(), Product.class);
             productListFromFile.add(productFromFile);
              }    
          }else{
              System.err.println("\t\tThere are not products in your inventory");
          }


      } catch (FileNotFoundException ex) {
          Logger.getLogger(GeneralMaterialList.class.getName()).log(Level.SEVERE, null, ex);
      }
      return productListFromFile;
  }  
   
    private static void printProduct(Product product){
        if(!(product.getId() == 0)){
        String productTemplate="""
                      ______________________________________________________
                     /                                                     / 
                 (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><><)==(O)
                      /''''''''''''''''''''''''''''''''''''''''''''''''''''''/
                     (                      PRODUCT                         (
                      )                                                      )
                     (      //|\\   ID:      %10s               
                      )      c_"/  NAME:       %10s                
                     (     __/\\__  DESCRIPTION: %10s              
                      )     /  \\   WORKING TIME: %10s                
                     (     /____\\  FINAL COST: %10s                      
                      )      11                                              )
                     / ''''''''''''''''''''''''''''''''''''''''''''''''''''''/    
                 (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><><)==(O)
                      /______________________________________________________/
                     
               """;
        System.out.format(productTemplate, product.getId(), product.getName(), product.getDescription(), product.getWorkingTime(), product.getCost());
        }
    }
        
    public static void printProductsTable(ArrayList <Product> productsList){
        int numberOfProducts = 0;
        if(!productsList.isEmpty()){
            System.out.println("                               PRODUCTS LIST");    
            System.out.println("|--------------------------------------------------------------------------|");
            System.out.printf("  %5s %20s %20s %20s ","NUM", "ID", "NAME", "QUANTITY");
            System.out.println();
            System.out.println("|--------------------------------------------------------------------------|");
            for (Product product: productsList){
                numberOfProducts +=1;
                System.out.format("  %5s %20s %20s %20s ", numberOfProducts,product.getId(), product.getName(),product.getQuantity());
                System.out.println();
                System.out.println("|--------------------------------------------------------------------------|");
            }
            System.out.println("""
                                       ____||________||_________||________||_________||________||_________||_______
                                       ----||--------||---------||--------||---------||--------||---------||-------\n """);
        }else{
            System.err.println("Theres no products in your inventory. Add a new product, then try again");
        }
    }
    
    private static int getFoundProductChosenMenuOption(Scanner scannerKeyboard){
        int chosenFoundProductMenuOption; 
        try{
            printFoundProductMenu();
            chosenFoundProductMenuOption = scannerKeyboard.nextInt();
        }catch(InputMismatchException error){
            return 4;
        }
        return chosenFoundProductMenuOption; 
    }
    private static void runFoundProductMenu(Scanner scannerKeyboard, int productId){
        int chosenFoundProductMenuOption;
        chosenFoundProductMenuOption = getFoundProductChosenMenuOption(scannerKeyboard);
        switch(chosenFoundProductMenuOption){
            case 1-> {
                updateProductInformation(productId);
                break;
            }
            case 2->{
                deleteProduct(productId);
                break;
            }
            case 3->{
                runMenu(scannerKeyboard);
                break;
            }

            default ->{
                ManagementSoftware.printWrongOptionErrorMessage();
                runFoundProductMenu(scannerKeyboard, productId);  
                break;
            }

        }
    }
    
    
    private static void updateProductInformation(int productId){
        System.out.println("We are working on the option to update the information of the product");
    }
    
    private static void deleteProduct(int productId){
        System.out.println("We are working on the option to delete the product");
    }

    private static void printMenu(){
        String inventoryMenu = """
                      ______________________________________________________
                     /                                                     / 
                 (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><><)==(O)
                      /''''''''''''''''''''''''''''''''''''''''''''''''''''''/
                     (       "ENTRE HILOS & ALGODON" MANAGMENT SOFTWARE     (
                      )                      INVENTORY                       )
                     (      --------------------      -----------------     (
                      )    | 1. Add New Product |    | 2. Product List |     )
                            --------------------      -----------------     (                                                      (
                     (                                                      (
                      )             ----------------------------             )
                     (             |     3. Search Product      |           (
                      )             ----------------------------             )
                      )             ----------------------------             )
                     (             |   4. Back to Main Menu     |           (
                      )             ----------------------------             )
                     (                                                      (
                     / ''''''''''''''''''''''''''''''''''''''''''''''''''''''/    
                 (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><><)==(O)
                      /______________________________________________________/
                                      WHAT DO YOU WANT TO DO? 
               """;
        System.out.println(inventoryMenu);
    }
    private static void printFoundProductMenu(){
        String foundProductMenu = """
                  ______________________________________________________
                 /                                                     / 
             (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><><)==(O)
                  /''''''''''''''''''''''''''''''''''''''''''''''''''''''/
                 (      "ENTRE HILOS & ALGODON" MANAGMENT SOFTWARE      (
                  )                   USER PROFILE                       )
                 (      ----------------       ------------------       (
                  )    | 1. Edit Product|     | 2. Delete Product |      )
                        ----------------       ------------------       (     
                  )             ----------------------------             )
                 (           |   3. Back to Inventory Menu     |        (
                  )             ----------------------------             )
                 (                                                      (
                 / ''''''''''''''''''''''''''''''''''''''''''''''''''''''/    
             (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><><)==(O)
                  /______________________________________________________/
                                  WHAT DO YOU WANT TO DO? 
            """;
        System.out.println(foundProductMenu);
    }
}
