package ec.edu.espe.filemanager;

import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Nahir Carrera, Gaman GeekLords, DCC0-ESPE
 */
public abstract class FileManager {
    
    public abstract void save(ArrayList<Object> objectsToSave, String fileName);
    public abstract Object find(int id);
    public abstract void delete(int id);
    public abstract void deleteAll();
    public static String convertToJson(ArrayList<Object> objectsToConvert){
        String convertedNotebooksToJson;
        Gson gson = new Gson();
        convertedNotebooksToJson = gson.toJson(objectsToConvert);
        return convertedNotebooksToJson;
    }
    public abstract ArrayList<Object> convertToArrayList(String objectsToConvert);
}
