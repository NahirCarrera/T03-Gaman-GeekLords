package ec.edu.espe.filemanager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Nahir Carrera, Gaman GeekLords, DCC0-ESPE
 */
public class AgendaFileManager extends FileManager {

    @Override
    public Object find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Object> convertToArrayList(String objectsToConvert) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    
    public void save(ArrayList<Product> objectsToSave, String fileName) {
        String objectsToSaveToJson = convertToJson(objectsToSave);
        try {
            FileWriter file = new FileWriter(fileName);
            try (BufferedWriter writer = new BufferedWriter(file)) {
                writer.write(objectsToSaveToJson);
            }   
        } catch (IOException ex) {
            System.out.println("Error");
        }  
    }



}
