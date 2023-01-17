package ec.edu.espe.ehamanagement.controller;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.ehamanagement.model.Product;
import ec.edu.espe.mongodbmanager.MongoDbManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import utils.DictionaryConversor;

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
        ArrayList materialsIds = DictionaryConversor.convertToArrayList(product.getMaterials(), "values");
        ArrayList materialsQuantities = DictionaryConversor.convertToArrayList(product.getMaterials(), "keys");
        values.add(materialsIds);
        values.add(materialsQuantities);
        values.add(product.getWorkingTime());
        values.add(product.getQuantity());
        return values;
    }
    

    public static boolean insertProduct( MongoCollection productsCollection ,Product product){
        ArrayList keys = getKeysToInsert();
        ArrayList values = getValuesToInsert(product);
        HashMap productToInsert = DictionaryConversor.convertToDictionary(keys, values);
        MongoDbManager.insertDocument(productsCollection, productToInsert);
        return true;
    }
    
    public static int assignIdToProduct(MongoCollection productsCollection){
        ArrayList products = MongoDbManager.getFieldValues(productsCollection, "id");
        if(!products.isEmpty()){
            int lastId = (int) Collections.max(products);
            int newId = lastId + 1;
            return newId;
        }else{
            return 1;
        }
    }
    
    public static boolean deleteProduct(MongoCollection productsCollection, int id){
        return MongoDbManager.deleteDocument(productsCollection, "id", id);
    }
    
    public static Object getValueFromProduct(MongoCollection productsCollection,int id, String field){
        Object foundValue;
        foundValue = MongoDbManager.getDocumentValue(productsCollection, "id",id, field);
        return foundValue;
    }
    
    public static ArrayList readAll(MongoCollection productsCollection, String field){
        ArrayList productsIds;
        productsIds = MongoDbManager.getFieldValues(productsCollection, field);
        return productsIds;
    }
    
    public static boolean updateProduct(Product product){
        int id = product.getId();
        MongoCollection productsCollection = createConnectionToCollection();
        MongoDbManager.updateDocument(productsCollection, "id",id, "name", product.getName());
        MongoDbManager.updateDocument(productsCollection, "id",id, "description", product.getDescription());
        MongoDbManager.updateDocument(productsCollection, "id",id, "quantity", product.getQuantity());
        MongoDbManager.updateDocument(productsCollection,"id", id, "workingTime", product.getWorkingTime());
        MongoDbManager.updateDocument(productsCollection,"id",id, "materialsIds", product.getMaterials().values());
        MongoDbManager.updateDocument(productsCollection,"id",id, "materialsQuantities", product.getMaterials().keySet());
        return true;
    }
        public static ArrayList <Product> readInventory( MongoCollection productsCollection){
        ArrayList <Object> ids = readAll(productsCollection, "id");
        Product readedProduct;
        ArrayList <Product> readedProducts = new ArrayList();
        for (Object readedId: ids){
            int id = Integer.parseInt(String.valueOf(readedId));
            String name = String.valueOf(getValueFromProduct( productsCollection, id, "name"));
            Float productionCost = Float.valueOf(String.valueOf(getValueFromProduct(productsCollection,id, "cost")));
            String description = String.valueOf(getValueFromProduct(productsCollection,id, "description"));
            ArrayList materialsIds = (ArrayList<Object>)(getValueFromProduct(productsCollection,id, "materialsIds"));
            ArrayList materialsQuantities = (ArrayList<Object>)(getValueFromProduct(productsCollection,id, "materialsQuantities"));
            HashMap materials = DictionaryConversor.convertToDictionary(materialsIds, materialsQuantities);
            int workingTime = Integer.parseInt(String.valueOf(getValueFromProduct( productsCollection, id, "workingTime")));
            int quantity = Integer.parseInt(String.valueOf(getValueFromProduct( productsCollection, id, "quantity")));
            readedProduct = new Product(id,  name, productionCost, description, materials, workingTime, quantity);
            readedProducts.add(readedProduct);
        }
        return readedProducts;
    }
        
        
    public static MongoCollection createConnectionToCollection(){
        String uri = "mongodb+srv://oop:oop@cluster0.og4urrq.mongodb.net/?retryWrites=true&w=majority";
        String dataBase = "ManagementSoftware";
        String collection = "Products";
        MongoCollection productsCollection =MongoDbManager.connectToCollection(uri, dataBase, collection);
        return productsCollection;
    }
    
}
