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
    
    public static boolean updateUser(User user){
        MongoCollection userCollection = createConnectionToCollection();
        MongoDbManager.updateDocument(userCollection, "id",1, "userName", user.getUserName());
        MongoDbManager.updateDocument(userCollection,"id", 1, "email", user.getEmail());
        MongoDbManager.updateDocument(userCollection, "id",1, "password", user.getPassword());
        MongoDbManager.updateDocument(userCollection, "id",1, "currentSalary", user.getCurrentSalary());
        return true;
    }
    
    public static boolean deleteUser( int id){
        MongoCollection userCollection = createConnectionToCollection();
        return MongoDbManager.deleteDocument(userCollection, "id", id);
    }
    
    public static Object getValueFromUser(MongoCollection userCollection, int id, String key){
        Object foundValue;
        foundValue = MongoDbManager.getDocumentValue(userCollection, "id",id, key);
        return foundValue;
    }

    public static MongoCollection createConnectionToCollection(){
        String uri = "mongodb+srv://oop:oop@cluster0.og4urrq.mongodb.net/?retryWrites=true&w=majority";
        String dataBase = "ManagementSoftware";
        String collection = "User";
        MongoCollection userCollection =MongoDbManager.connectToCollection(uri, dataBase, collection);
        return userCollection;
    }
}
