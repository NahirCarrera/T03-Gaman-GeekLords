
package ec.edu.espe.ehamanagement.controller;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.ehamanagement.model.Order;
import ec.edu.espe.mongodbmanager.MongoDbManager;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Nahir Carrera, Gaman GeekLords, DCC0-ESPE
 */
public class Agenda {
    public static ArrayList getKeysToInsert(){
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
        ArrayList <String> ordersIds = MongoDbManager.readAll(ordersCollection, "id");
        if(!ordersIds.isEmpty()){
            int lastId = Integer.valueOf(Collections.max(ordersIds));
            int newId = lastId + 1;
            return newId;
        }else{
            return 1;
        }
    }
    
    public static ArrayList <String> readAll(MongoCollection ordersCollection, String key){
        ArrayList <String> values;
        values = MongoDbManager.readAll(ordersCollection, key);
        return values;
    }
    public static boolean insertOrder(MongoCollection ordersCollection, Order order){
        int newId = assignIdToOrder(ordersCollection);
        order.setId(newId);
        ArrayList keys = getKeysToInsert();
        ArrayList values = getValuesToInsert(order);
        MongoDbManager.insert(ordersCollection, keys, values);
        return true;
    }
    
    public static boolean deleteOrder(MongoCollection ordersCollection, int id){
        return MongoDbManager.delete(ordersCollection, id);
    }
    public static String findValue(MongoCollection ordersCollection,String key,  Object value, String keyToFind){
        String foundValue;
        foundValue = MongoDbManager.findValue(ordersCollection, key,value, keyToFind);
        return foundValue;
    }
    
    
    public static boolean updateOrder(MongoCollection ordersCollection, Order order){
        int id = order.getId();
        MongoDbManager.update(ordersCollection, id, "clientName", order.getClientName());
        MongoDbManager.update(ordersCollection, id, "deliveryDate", order.getDeliveryDate());
        MongoDbManager.update(ordersCollection, id, "deliveryPlace", order.getDeliveryPlace());
        MongoDbManager.update(ordersCollection, id, "description", order.getDescription());
        MongoDbManager.update(ordersCollection, id, "isDelivered", String.valueOf(order.getIsDelivered()));
        return true;
    }
    public static boolean findDocument(String key, Object value){
        MongoCollection ordersCollection = createConnectionToCollection();
        return MongoDbManager.findDocument(ordersCollection, key, value);
    }
    
    public static ArrayList <Order> read( MongoCollection ordersCollection){
        ArrayList <String> ids = readAll (ordersCollection, "id");
        Order readedOrder;
        ArrayList <Order> readedOrders = new ArrayList();
        for (String readedId: ids){
            int id = Integer.valueOf(readedId);
            String clientName = findValue(ordersCollection, "id", id, "clientName");
            String deliveryPlace = findValue(ordersCollection, "id", id, "deliveryPlace");
            String deliveryDate = findValue(ordersCollection, "id", id, "deliveryDate");
            String description = findValue(ordersCollection, "id", id, "description");
            String isDelivered = findValue(ordersCollection, "id", id, "isDelivered");
            readedOrder = new Order(Integer.valueOf(id), clientName, deliveryPlace, deliveryDate, description, Boolean.valueOf(isDelivered)); 
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
