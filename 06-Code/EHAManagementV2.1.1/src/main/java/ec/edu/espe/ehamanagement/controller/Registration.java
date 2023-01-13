package ec.edu.espe.ehamanagement.controller;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.ehamanagement.model.User;
import ec.edu.espe.mongodbmanager.MongoDbManager;
import java.util.ArrayList;

/**
 *
 * @author Nahir Carrera, Gaman GeekLords, DCC0-ESPE
 */
public class Registration {
    private static ArrayList getKeysToInsert(){
        ArrayList keys = new ArrayList(5);
        keys.add("id");
        keys.add("userName");
        keys.add("email");
        keys.add("password");
        keys.add("currentSalary");
        return keys;   
    }
    private static ArrayList getValuesToInsert(User user){
        ArrayList values = new ArrayList(5);
        values.add(user.getId());
        values.add(user.getUserName());
        values.add(user.getEmail());
        values.add(user.getPassword());
        values.add(user.getCurrentSalary());
        return values;
    }
    
    public static void insertUser(User user){
        MongoCollection userCollection = createConnectionToCollection();
        ArrayList keys = getKeysToInsert();
        ArrayList values = getValuesToInsert(user);
        MongoDbManager.insert(userCollection, keys, values);
    }
    
  
    public static boolean deleteUser( int id){
        MongoCollection userCollection = createConnectionToCollection();
        return MongoDbManager.delete(userCollection, id);
    }
    public static String findValue(MongoCollection userCollection, int id, String key){
        String foundValue;
        foundValue = MongoDbManager.findValue(userCollection, "id",id, key);
        return foundValue;
    }
    
    
    public static boolean updateUser(User user, int id){
        MongoCollection userCollection = createConnectionToCollection();
        MongoDbManager.update(userCollection, id, "userName", user.getUserName());
        MongoDbManager.update(userCollection, id, "email", user.getEmail());
        MongoDbManager.update(userCollection, id, "password", user.getPassword());
        MongoDbManager.update(userCollection, id, "currentSalary", user.getCurrentSalary());
        return true;
    }
    
    public static MongoCollection createConnectionToCollection(){
        String uri = "mongodb+srv://oop:oop@cluster0.og4urrq.mongodb.net/?retryWrites=true&w=majority";
        String dataBase = "ManagementSoftware";
        String collection = "User";
        MongoCollection userCollection =MongoDbManager.connectToCollection(uri, dataBase, collection);
        return userCollection;
    }
}
