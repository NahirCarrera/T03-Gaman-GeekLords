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

    private static ArrayList getKeysToInsert(){
        ArrayList keys = new ArrayList(8);
        keys.add("id");
        keys.add("name");
        keys.add("cost");
        keys.add("description");
        keys.add("materialsIds");
        keys.add("materialsQuantities");
        keys.add("workingTime");
        keys.add("quantity");
        return keys;   
    }
    
    private static ArrayList getValuesToInsert(Product product){
        ArrayList values = new ArrayList(8);
        values.add(product.getId());
        values.add(product.getName());
        values.add(product.getProductionCost());
        values.add(product.getDescription());
        values.add(product.getMaterialsIds());
        values.add(product.getMaterialsQuantities());
        values.add(product.getWorkingTime());
        values.add(product.getQuantity());
        return values;
    }
    public static boolean insertProduct(Product product){
        MongoCollection productsCollection = createConnectionToCollection();
        ArrayList keys = getKeysToInsert();
        ArrayList values = getValuesToInsert(product);
        MongoDbManager.insert(productsCollection, keys, values);
        return true;
    }
    
    public static int assignIdToProduct(){
        MongoCollection productsCollection = createConnectionToCollection();
        ArrayList products = MongoDbManager.readAll(productsCollection, "id");
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
    public static String findValue(int id, String key){
        MongoCollection productsCollection = createConnectionToCollection();
        String foundValue;
        foundValue = MongoDbManager.findValue(productsCollection, "id",id, key);
        return foundValue;
    }
    public static ArrayList readAll(String key){
        MongoCollection productsCollection = createConnectionToCollection();
        ArrayList productsIds;
        productsIds = MongoDbManager.readAll(productsCollection, key);
        return productsIds;
    }
    
    public static boolean updateProduct(Product product){
        int id = product.getId();
        MongoCollection productsCollection = createConnectionToCollection();
        MongoDbManager.update(productsCollection, id, "name", product.getName());
        MongoDbManager.update(productsCollection, id, "description", product.getDescription());
        MongoDbManager.update(productsCollection, id, "quantity", product.getQuantity());
        MongoDbManager.update(productsCollection, id, "workingTime", product.getWorkingTime());
        MongoDbManager.update(productsCollection, id, "materialsIds", product.getMaterialsIds());
        MongoDbManager.update(productsCollection, id, "materialsQuantities", product.getMaterialsQuantities());
        return true;
    }
    public static MongoCollection createConnectionToCollection(){
        String uri = "mongodb+srv://oop:oop@cluster0.og4urrq.mongodb.net/?retryWrites=true&w=majority";
        String dataBase = "ManagementSoftware";
        String collection = "Products";
        MongoCollection productsCollection =MongoDbManager.connectToCollection(uri, dataBase, collection);
        return productsCollection;
    }
    
}
