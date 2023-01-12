package ec.edu.espe.ehamanagement.controller;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.ehamanagement.model.Product;
import ec.edu.espe.mongodbmanager.MongoDbManager;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Nahir Carrera, Gaman GeekLords, DCC0-ESPE
 */
public class Inventory {
    public static void insertProduct(MongoCollection productsCollection, Product product){
        ArrayList keys = Product.getAttributesNames();
        ArrayList values = Product.getAttributes(product);
        MongoDbManager.insert(productsCollection, keys, values);
    }
    
    public static int assignIdToProduct(MongoCollection collection){
        ArrayList products = MongoDbManager.read(collection);
        if(!products.isEmpty()){
            int lastId = (int) Collections.max(products);
            int newId = lastId + 1;
            return newId;
        }else{
            return 1;
        }
    }
    
    public static boolean deleteProduct( int id){
        MongoCollection productsCollection = createConnectionToCollection();
        return MongoDbManager.delete(productsCollection, id);
    }
    public static String findValue(MongoCollection productsCollection, int id, String key){
        String foundValue;
        foundValue = MongoDbManager.findValue(productsCollection, "id",id, key);
        return foundValue;
    }
    public static ArrayList readDatabase(){
        MongoCollection productsCollection = createConnectionToCollection();
        ArrayList productsIds;
        productsIds = MongoDbManager.read(productsCollection);
        return productsIds;
    }
    public static void updateProduct(Product product, int id){
        MongoCollection productsCollection = createConnectionToCollection();
        MongoDbManager.update(productsCollection, id, "name", product.getName());
        MongoDbManager.update(productsCollection, id, "description", product.getDescription());
        MongoDbManager.update(productsCollection, id, "quantity", product.getQuantity());
        MongoDbManager.update(productsCollection, id, "workingTime", product.getWorkingTime());
        MongoDbManager.update(productsCollection, id, "materialsIds", product.getMaterialsIds());
        MongoDbManager.update(productsCollection, id, "materialsQuantities", product.getMaterialsQuantities());
    }
    public static MongoCollection createConnectionToCollection(){
        String uri = "mongodb+srv://oop:oop@cluster0.og4urrq.mongodb.net/?retryWrites=true&w=majority";
        String dataBase = "ManagementSoftware";
        String collection = "Products";
        MongoCollection productsCollection =MongoDbManager.connectToCollection(uri, dataBase, collection);
        return productsCollection;
    }
}
