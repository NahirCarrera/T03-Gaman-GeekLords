package ec.edu.espe.mongodbmanager;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Nahir Carrera, Gaman GeekLords, DCC0-ESPE
 */
public class MongoDbManager {

    public static MongoCollection connectToCollection(String uri, String dataBase, String collection){
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(dataBase);
        System.out.println("-> Connected successfully to server " + dataBase + "/" + collection);
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(collection);
        return mongoCollection;   
    }

    public static boolean insert(MongoCollection collection, ArrayList keys, ArrayList values){
        Object documentId  = values.get(0);
        boolean existence;
        existence = findDocument(collection,"id", (int)documentId);
        if(!existence){
            Document document = new Document("_id", new ObjectId());
            for (int i = 0; i< keys.size(); i++){
                document.append((String) keys.get(i),values.get(i));
            }
            collection.insertOne(document);
            System.out.println("-> Inserted successfully");
            return true;
        }else{
            System.out.println("-> Insertion failed");
            System.out.println("A document with id: " + documentId + " already exists");
            System.out.println("You cannot enter another document with the same id");
            return false;
        }
    }
    public static ArrayList readAll(MongoCollection collection, String key){
        ArrayList readedValues = new ArrayList();
        Object document;
        Bson filter = Filters.and(Filters.gt("id", 0));
        Document projectionDocument = new Document("_id", 0).append(key, 1);
        try(MongoCursor<Document> cursor = collection.find(filter).projection(projectionDocument).iterator()) {
            if(cursor.hasNext()){
                while(cursor.hasNext()){
                    document =  cursor.next().toJson().replaceFirst(key,"").replaceFirst(" ","").replaceAll("[{}:"+"\"\""+"]", "");
                    readedValues.add(document);
                }
            }else{
                System.out.println("-> There is no documents in the database, or database doesn't exists");
            }
        }
        return readedValues;
    }
    
    public static ArrayList read(MongoCollection collection){
        ArrayList readedDocuments = new ArrayList();
        int document;
        Bson filter = Filters.and(Filters.gt("id", 0));
        Document projectionDocument = new Document("_id", 0).append("id", 1);
        try(MongoCursor<Document> cursor = collection.find(filter).projection(projectionDocument).iterator()) {
            if(cursor.hasNext()){
                while(cursor.hasNext()){
                    document = Integer.parseInt( cursor.next().toJson().replaceAll("[{}: "+"\"\""+"]", "").replaceFirst("id",""));
                    readedDocuments.add(document);
                }
            }else{
                System.out.println("-> There is no documents in the database, or database doesn't exists");
            }
        }
        return readedDocuments;
    }
    
    public static boolean update(MongoCollection collection, int documentId, String key, Object newValue){
        if (findDocument(collection,"id", documentId)){
            Bson query  =Filters.eq("id", documentId);
            Bson updates;
            updates = Updates.set(key, newValue);
            collection.updateOne(query, updates);
            System.out.println("-> Updated successfully ");
            return true;
        }else{
            System.out.println("-> Update failed");
            return false;
        }
    }
    
    public static boolean delete(MongoCollection collection, int documentId){
        Boolean existence;
        existence = findDocument(collection,"id",  documentId);
        if (existence){
            Bson query  =Filters.eq("id", documentId); 
            collection.deleteMany(query);
            System.out.println("-> Deleted successfully");
            return true;
        }else{
            System.out.println("-> Delete failed");
            return false;
        }
    }
    
    public static String findValue(MongoCollection collection, String documentKey, Object documentValue, String valueSearched){
        String foundValue;
        if (findDocument(collection,documentKey,  documentValue)){
            Document projectionDocument = new Document("_id", 0).append(valueSearched, 1);
            Bson filter = Filters.and(Filters.all(documentKey, documentValue));
            MongoCursor<Document> cursor = collection.find(filter).projection(projectionDocument).iterator();
            String value;
            value = cursor.next().toJson();
            if(value.equals("{}")){
                foundValue =  "";
            }else{
                foundValue = value.replaceFirst(valueSearched,"").replaceFirst(" ","").replaceAll("[{}:"+"\"\""+"]", "");
            }
        }else{
            System.out.println("-> Search failed");
            foundValue =  "";
        }
     return foundValue;   
    }
    
    public static boolean findDocument(MongoCollection collection,String key,  Object value){
        Document projectionDocument = new Document("_id", 0);
        Bson filter = Filters.and(Filters.all(key, value));
        MongoCursor<Document> cursor = collection.find(filter).projection(projectionDocument).iterator();
        if(cursor.hasNext()){
            return true;
        }else{
            System.out.println("-> Document not found");
            return false;
        }
    }
    

}