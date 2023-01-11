package ec.edu.espe.mongodbmanager;

import com.mongodb.client.MongoCollection;

/**
 *
 * @author Nahir Carrera, Gaman GeekLords, DCC0-ESPE
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String uri = "mongodb+srv://oop:oop@cluster0.og4urrq.mongodb.net/?retryWrites=true&w=majority";
        String dataBase = "ManagementSoftware";
        String collection = "Products";
        MongoCollection productsCollection = MongoDbManager.connectToCollection(uri, dataBase, collection);
        float num1 = Float.parseFloat((String) MongoDbManager.readAll(productsCollection, "cost").get(2));
        float num2 = Float.parseFloat((String) MongoDbManager.readAll(productsCollection, "quantity").get(1));
        System.out.println("Prueba: "+ num1 + " + " + num2 + " = " + (num1 + num2));
        System.out.println(MongoDbManager.findDocument(productsCollection,"name",  "Lola"));
        System.out.println(MongoDbManager.findDocument(productsCollection,"name",  "Reno"));
        System.out.println("Found :" + MongoDbManager.findValue(productsCollection, "id", 5, "name"));
        System.out.println(productsCollection);
    }
    
}
