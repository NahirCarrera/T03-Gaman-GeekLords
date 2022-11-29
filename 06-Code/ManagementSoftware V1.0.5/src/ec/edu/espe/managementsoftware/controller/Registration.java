package ec.edu.espe.managementsoftware.controller;
import ec.edu.espe.managementsoftware.model.User;
import com.google.gson.Gson;
import ec.edu.espe.managementsoftware.view.ManagementSoftware;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nahir Carrera, Gaman GeekLords, DCC0-ESPE
 */
public class Registration {

    public static int getMenuChosenOption(Scanner scannerKeyboard){
        int chosenRegistrationMenuOption; 
        try{
            printMenu();
            chosenRegistrationMenuOption = scannerKeyboard.nextInt();
        }catch(InputMismatchException error){
            return 5;
        }
        return chosenRegistrationMenuOption; 
    }
    
    public static boolean logIn(Scanner scannerKeyboard){
        File userDataBase = createUserDataBaseFile();
        String loginUserName;
        String loginPassword;
        User userFromFile;
        boolean end;
        boolean loginConfirmation;
        int exit;
        loginConfirmation = false;
        do{
    
            end = false;
            try{
                System.out.println("""
                                  ______________________________________________________
                                 /                                                     / 
                             (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><><)==(O)
                                  /''''''''''''''''''''''''''''''''''''''''''''''''''''''/
                                 (      "ENTRE HILOS & ALGODON" MANAGMENT SOFTWARE      (
                                  )                       LOGIN                          )
                                 (                                                      ( """);
          System.out.print("     )             User Name ->"); 
                loginUserName = scannerKeyboard.next();
          System.out.print("    (              Password -> "); 
                loginPassword = scannerKeyboard.next();
                System.out.println( """
                                  )                                                      )
                                 / ''''''''''''''''''''''''''''''''''''''''''''''''''''''/    
                             (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><><)==(O)
                                  /______________________________________________________/""");
                
                userFromFile = readUserFromFile(userDataBase);
                if(loginUserName.equals(userFromFile.getUserName())&& loginPassword.equals(userFromFile.getPassword()) ){
                    loginConfirmation = true;
                    end = true;
                }else{
                    printLogInErrorMessage();
                    System.out.println("- ENTER 1 TO TRY AGAIN / ENTER 2 TO EXIT -   ");
                    exit = scannerKeyboard.nextInt();
                    end = exit != 1;
                }
            }catch(InputMismatchException error){
                ManagementSoftware.printInputMismatchErrorMessage();
                }
        }while(!end);
        return loginConfirmation;
    }
        
    
    private static User readUserFromFile(File userDataBase){
        Scanner scUserDataBase;
        User userFromFile = new User();
        try {
            scUserDataBase = new Scanner(userDataBase);
            Gson gson = new Gson();
            userFromFile = gson.fromJson(scUserDataBase.nextLine(), User.class);
            return userFromFile;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userFromFile;
    }
    
    public static User searchUser(){
        File userDataBase = createUserDataBaseFile();     
        User foundUser;
        foundUser = readUserFromFile(userDataBase);
        return foundUser;
    } 
    
    
    public static void signIn(){
     File userDataBase = createUserDataBaseFile();
     Scanner scUserDataBase;
        try {
            scUserDataBase = new Scanner(userDataBase);       
            if(!scUserDataBase.hasNext()){
               try(FileWriter fileWriter = new FileWriter(userDataBase);){
                    User newUser;
                    Gson gson = new Gson();
                    String userToFile;
                    newUser = createUser();
                    userToFile = gson.toJson(newUser);
                    fileWriter.write(userToFile + "\n");
               } catch (IOException ex) {
                   Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
               } 
            }else{
                printSignInErrorMessage();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private static User createUser(){
        Scanner sc = new Scanner(System.in);
        String name;
        String email;
        String password;
        float currentSalary;
        User newUser;
        try{
                System.out.println(" =^..^=   =^..^=   =^..^=    =^..^=    =^..^=   ");
                System.out.print("""             
                                                 Enter User Name 
                                 Ex -> UserName:  
                                 """); 
                name = sc.next();
                System.out.print("""            
                                                  Enter email
                                 Ex -> exam@gmail.com: 
                                 """);
                email = sc.next();
                System.out.print("""           
                                                Enter password 
                                 Ex -> password1234:  
                                 """);
                password = sc.next();
                System.out.print("""            
                                           Enter Your Current Salary 
                                 Ex -> 450,00:  
                                 """);
                currentSalary = sc.nextFloat();
                System.out.println(" =^..^=   =^..^=   =^..^=    =^..^=    =^..^=   ");
                newUser = new User(name, email, password, currentSalary); 
                return newUser;
            }catch(InputMismatchException error){
                ManagementSoftware.printInputMismatchErrorMessage();
                }
        return null;
    }
    

    public static void showUserProfile(Scanner scannerKeyboard){
        File userDataBase = createUserDataBaseFile();
        Scanner scUserDataBase;
        try { 
            scUserDataBase = new Scanner(userDataBase);
            Gson gson = new Gson();
            User userForUserProfile;
            userForUserProfile = gson.fromJson(scUserDataBase.nextLine(), User.class);
            String userProfile = """
                                  ______________________________________________________
                                 /                                                     / 
                             (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><><)==(O)
                                  /''''''''''''''''''''''''''''''''''''''''''''''''''''''/
                                 (      "ENTRE HILOS & ALGODON" MANAGMENT SOFTWARE      (
                                  )                   USER PROFILE                       )
                                 (      //|\\   User Name:      %10s               
                                  )      c_"/  Password:       %10s                
                                 (     __/\\__  Email:          %10s                                                                     (
                                  )     /  \\   Current Salary: %10s                
                                 (     /____\\                                          (
                                  )       11                                             )
                                 / ''''''''''''''''''''''''''''''''''''''''''''''''''''''/    
                             (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><><)==(O)
                                  /______________________________________________________/
                           """;
            System.out.format(userProfile, userForUserProfile.getUserName(), userForUserProfile.getPassword(), userForUserProfile.getEmail(), userForUserProfile.getCurrentSalary());
            
            runUserProfileMenu(scannerKeyboard);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }   
    } 
    
    private static int getUserProfileChosenMenuOption(Scanner scannerKeyboard){
        int chosenUserProfileMenuOption; 
        try{
            printUserProfileMenu();
            chosenUserProfileMenuOption = scannerKeyboard.nextInt();
        }catch(InputMismatchException error){
            return 4;
        }
        return chosenUserProfileMenuOption; 
    }
    private static void runUserProfileMenu(Scanner scannerKeyboard){
        int chosenUserProfileMenuOption;
        chosenUserProfileMenuOption = getUserProfileChosenMenuOption(scannerKeyboard);
        switch(chosenUserProfileMenuOption){

            case 1-> {
                updateUserInformation();
                break;
            }
            case 2->{
                deleteUser();
                break;
            }
            case 3->{
                ManagementSoftware.runMainMenu(scannerKeyboard);
                break;
            }

            default ->{
                ManagementSoftware.printWrongOptionErrorMessage();
                runUserProfileMenu(scannerKeyboard);  
                break;
            }
        }
    }
    
    
    private static void updateUserInformation(){
        File userDataBase = createUserDataBaseFile();
        try(FileWriter fileWriter = new FileWriter(userDataBase);){
                    User newUser;
                    Gson gson = new Gson();
                    String userToFile;
                    newUser = createUser();
                    userToFile = gson.toJson(newUser);
                    fileWriter.write(userToFile + "\n");
        } catch (IOException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void deleteUser(){
        System.out.println("We are working on the option to delete the user");
    }
    
    
    private static void printLogInErrorMessage(){
        String logInErrorMessage = """
                           \n  ------------  DEAR USER  ------------
                                 ENTER VALID USERNAME AND PASSWORD
                               -------------------------------------
                           """;
        System.out.println(logInErrorMessage);
    }
    private static void printSignInErrorMessage(){
        String signInErrorMessage = """
                              \n     ---------------------  DEAR USER  ----------------------
                                         YOU HAVE ALREADY CREATED AN ACCOUNT, PLEASE LOGIN
                                     --------------------------------------------------------
                              """;
        System.out.println(signInErrorMessage);
    }
    private static void printMenu(){
        String registrationMenu = """
              ______________________________________________________
             /                                                     / 
         (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><><)==(O)
              /''''''''''''''''''''''''''''''''''''''''''''''''''''''/
             (      "ENTRE HILOS & ALGODON" MANAGMENT SOFTWARE      (
              )                   REGISTRATION                      )
             (      ----------------          ----------------      (
              )    |   1. Sign In   |        |    2. Log In   |      )
                    ----------------          ----------------      (                                                      (
             (                                                      (
             / ''''''''''''''''''''''''''''''''''''''''''''''''''''''/    
         (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><><)==(O)
              /______________________________________________________/
                              WHAT DO YOU WANT TO DO? 
        """;
        System.out.println(registrationMenu);
    }
    private static void printUserProfileMenu(){
    String userProfileMenu = """
              ______________________________________________________
             /                                                     / 
         (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><><)==(O)
              /''''''''''''''''''''''''''''''''''''''''''''''''''''''/
             (      "ENTRE HILOS & ALGODON" MANAGMENT SOFTWARE      (
              )                   USER PROFILE                       )
             (      ----------------          ----------------      (
              )    |  1. Edit User  |        | 2. Delete User |      )
                    ----------------          ----------------      (     
              )             ----------------------------             )
             (             |   3. Back to Main Menu     |           (
              )             ----------------------------             )
             (                                                      (
             / ''''''''''''''''''''''''''''''''''''''''''''''''''''''/    
         (O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><><)==(O)
              /______________________________________________________/
                              WHAT DO YOU WANT TO DO? 
        """;
        System.out.println(userProfileMenu);
    }
    private static File createUserDataBaseFile(){
        String userDataBaseDirectoryName = System.getProperty("user.dir") + "\\userDataBase.json";
        File userDataBase = new File (userDataBaseDirectoryName);
        return userDataBase;
    }
}



