package ec.edu.espe.mongodbmanager;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Nahir Carrera, Gaman GeekLords, DCC0-ESPE
 */
public class MongoDbManager {

    public static MongoDatabase connectToDatabase(String uri, String dataBase){
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(dataBase);
        System.out.println("-> Connected successfully to server " + dataBase);  
        return mongoDatabase;
    }
    
    public static MongoCollection connectToCollection(MongoDatabase database, String collection){
        MongoCollection<Document> mongoCollection = database.getCollection(collection);
        return mongoCollection; 
    }
    public static  boolean insertDocument(MongoCollection collection, HashMap<Object, Object> map){
        Object documentId  = map.get("id");
        if(!existsDocument(collection,"id", (int)documentId)){
            Document document = createDocument(map);
            try {
                collection.insertOne(document);
                System.out.println("-> Inserted successfully");
                return true;
            } catch (Exception e) {
                System.out.println("-> Insertion failed");
                return false;
            }
        }else{
            System.out.println("-> Insertion failed");
            return false;
        }
    }
    
    private static Document createDocument(HashMap<Object, Object> map) {
        Document document = new Document();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            document.append(entry.getKey().toString(), entry.getValue());
        }
        return document;
    }
    

    
    public static ArrayList<Object> getFieldValues(MongoCollection<Document> collection, String field) {
        ArrayList<Object> readedValues = new ArrayList<>();
        if (existsField(collection, field)) {
            try (MongoCursor<Document> cursor = collection.find().iterator()) {
                while (cursor.hasNext()) {
                    Document document = cursor.next();
                    readedValues.add(document.get(field));
                }
            }
        }
        return readedValues;
    }
    
    public  static boolean updateDocument(MongoCollection<Document> collection, String searchField, Object searchValue, String targetField, Object newValue) {
        if (existsDocument(collection, searchField, searchValue)) {
            Document document = new Document(searchField, searchValue);
            Bson update = Updates.set(targetField, newValue);
            collection.updateOne(document,update );
            System.out.println("-> Updated succesfully");
            return true;
        }
        else {
            System.out.println("-> Updated failed");
            return false;
        }
    }
    
    public static boolean deleteDocument(MongoCollection<Document> collection, String searchField, Object searchValue) {
        if (existsDocument(collection, searchField, searchValue)) {
            Bson query =Filters.eq(searchField, searchValue);
            collection.deleteOne(query);
            System.out.println("-> Deleted successfully");
            return true; 
        }
        else {
            System.out.println("-> Deleted failed");
            return false;
        }
    }
    
    public static Object getDocumentValue(MongoCollection<Document> collection, String searchField, Object searchValue, String targetField) {
        if (existsDocument(collection, searchField, searchValue)) {
            Document query = new Document(searchField, searchValue);
            Document document = collection.find(query).first();
            Object value =document.get(targetField);
            return value;
        } else {
            return null;
        }
    }
    
    public static boolean existsDocument(MongoCollection collection, String field,  Object value){
        Document query = new Document(field, value);
        FindIterable<Document> documents = collection.find(query);
        return documents.first() != null;
    }
    
    public static boolean existsField(MongoCollection<Document> collection, String field) {
        // Obtenemos un documento de la colección como ejemplo
        Document sampleDoc = collection.find().first();
        // Verificamos si el documento es null y si contiene la clave dada
        return sampleDoc != null && sampleDoc.containsKey(field);
    }

}
