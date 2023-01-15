
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
    
    private static int assignIdToOrder(){
        MongoCollection ordersCollection = createConnectionToCollection();
        ArrayList <String> ordersIds = MongoDbManager.readAll(ordersCollection, "id");
        if(!ordersIds.isEmpty()){
            int lastId = Integer.valueOf(Collections.max(ordersIds));
            int newId = lastId + 1;
            return newId;
        }else{
            return 1;
        }
    }

    public static boolean insertOrder(Order order){
        MongoCollection ordersCollection = createConnectionToCollection();
        int newId = assignIdToOrder();
        order.setId(newId);
        ArrayList keys = getKeysToInsert();
        ArrayList values = getValuesToInsert(order);
        MongoDbManager.insert(ordersCollection, keys, values);
        return true;
    }
    
    public static boolean deleteOrder( int id){
        MongoCollection ordersCollection = createConnectionToCollection();
        return MongoDbManager.delete(ordersCollection, id);
    }
    public static String findValue(MongoCollection ordersCollection, int id, String key){
        String foundValue;
        foundValue = MongoDbManager.findValue(ordersCollection, "id",id, key);
        return foundValue;
    }
    
    
    public static boolean updateOrder(Order order){
        MongoCollection ordersCollection = createConnectionToCollection();
        int id = order.getId();
        MongoDbManager.update(ordersCollection, id, "clientName", order.getClientName());
        MongoDbManager.update(ordersCollection, id, "deliveryDate", order.getDeliveryDate());
        MongoDbManager.update(ordersCollection, id, "deliveryPlace", order.getDeliveryPlace());
        MongoDbManager.update(ordersCollection, id, "description", order.getDescription());
        MongoDbManager.update(ordersCollection, id, "isDelivered", String.valueOf(order.getIsDelivered()));
        return true;
    }
    
    public static MongoCollection createConnectionToCollection(){
        String uri = "mongodb+srv://oop:oop@cluster0.og4urrq.mongodb.net/?retryWrites=true&w=majority";
        String dataBase = "ManagementSoftware";
        String collection = "Orders";
        MongoCollection userCollection =MongoDbManager.connectToCollection(uri, dataBase, collection);
        return userCollection;
    }
}
