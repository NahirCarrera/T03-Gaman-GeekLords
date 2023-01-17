
package ec.edu.espe.ehamanagement.controller;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.ehamanagement.model.Order;
import ec.edu.espe.mongodbmanager.MongoDbManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import utils.DictionaryConversor;

/**
 *
 * @author Nahir Carrera, Gaman GeekLords, DCC0-ESPE
 */
public class Agenda {
    public static ArrayList getFieldsToInsert(){
        ArrayList keys = new ArrayList(5);
        keys.add("id");
        keys.add("clientName");
        keys.add("description");
        keys.add("deliveryDate");
        keys.add("deliveryPlace");
        keys.add("isDelivered");
        return keys;   
    }
    public static ArrayList getValuesToInsert(Order order){
        ArrayList values = new ArrayList(5);
        values.add(order.getId());
        values.add(order.getClientName());
        values.add(order.getDescription());
        values.add(order.getDeliveryDate());
        values.add(order.getDeliveryPlace());
        values.add(order.getIsDelivered());
        return values;
    }
    
    private static int assignIdToOrder(MongoCollection ordersCollection){
        ArrayList <String> ordersIds = MongoDbManager.getFieldValues(ordersCollection, "id");
        if(!ordersIds.isEmpty()){
            int lastId = Integer.parseInt(Collections.max(ordersIds));
            int newId = lastId + 1;
            return newId;
        }else{
            return 1;
        }
    }
    
    public static ArrayList <Object> getAll(MongoCollection ordersCollection, String key){
        ArrayList <Object> values;
        values = MongoDbManager.getFieldValues(ordersCollection, key);
        return values;
    }
    public static boolean insertOrder(MongoCollection ordersCollection, Order order){
        int newId = assignIdToOrder(ordersCollection);
        order.setId(newId);
        ArrayList keys = getFieldsToInsert();
        ArrayList values = getValuesToInsert(order);
        HashMap orderToInsert = DictionaryConversor.convertToDictionary(keys, values);
        MongoDbManager.insertDocument(ordersCollection, orderToInsert);
        return true;
    }
    
    public static boolean deleteOrder(MongoCollection ordersCollection, int id){
        return MongoDbManager.deleteDocument(ordersCollection,"id", id);
    }
    
    public static Object getValueFromOrder(MongoCollection ordersCollection,String key,  Object value, String keyToFind){
        Object foundValue;
        foundValue = MongoDbManager.getDocumentValue(ordersCollection, key,value, keyToFind);
        return foundValue;
    }
    
    
    public static boolean updateOrder(MongoCollection ordersCollection, Order order){
        int id = order.getId();
        MongoDbManager.updateDocument(ordersCollection,"id", id, "clientName", order.getClientName());
        MongoDbManager.updateDocument(ordersCollection,"id", id, "deliveryDate", order.getDeliveryDate());
        MongoDbManager.updateDocument(ordersCollection,"id", id, "deliveryPlace", order.getDeliveryPlace());
        MongoDbManager.updateDocument(ordersCollection, "id",id, "description", order.getDescription());
        MongoDbManager.updateDocument(ordersCollection,"id", id, "isDelivered", String.valueOf(order.getIsDelivered()));
        return true;
    }
    public static  boolean existsOrder(String key, Object value){
        MongoCollection ordersCollection = createConnectionToCollection();
        return MongoDbManager.existsDocument(ordersCollection, key, value);
    }
    
    public static ArrayList <Order> readAgenda( MongoCollection ordersCollection){
        ArrayList <Object> ids = getAll (ordersCollection, "id");
        Order readedOrder;
        ArrayList <Order> readedOrders = new ArrayList();
        for (Object readedId: ids){
            int id = Integer.parseInt(String.valueOf(readedId));
            String clientName = String.valueOf(getValueFromOrder(ordersCollection, "id", id, "clientName"));
            String deliveryPlace = String.valueOf(getValueFromOrder(ordersCollection, "id", id, "deliveryPlace"));
            String deliveryDate = String.valueOf(getValueFromOrder(ordersCollection, "id", id, "deliveryDate"));
            String description = String.valueOf(getValueFromOrder(ordersCollection, "id", id, "description"));
            String isDelivered = String.valueOf(getValueFromOrder(ordersCollection, "id", id, "isDelivered"));
            readedOrder = new Order(id, clientName, deliveryPlace, deliveryDate, description, Boolean.parseBoolean(isDelivered)); 
            readedOrders.add(readedOrder);
        }
        return readedOrders;
    }
    
    public static MongoCollection createConnectionToCollection(){
        String uri = "mongodb+srv://oop:oop@cluster0.og4urrq.mongodb.net/?retryWrites=true&w=majority";
        String dataBase = "ManagementSoftware";
        String collection = "Orders";
        MongoCollection userCollection =MongoDbManager.connectToCollection(uri, dataBase, collection);
        return userCollection;
    }
}
