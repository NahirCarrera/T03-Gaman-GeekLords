package utils;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.ehamanagement.model.Product;
import ec.edu.espe.mongodbmanager.MongoDbManager;
import java.util.ArrayList;

/**
 *
 * @author Nahir Carrera, Gaman GeekLords, DCC0-ESPE
 */
public class CostCalculator {
    private static float computeMaterialUnitCost(int id){
        String uri = "mongodb+srv://oop:oop@cluster0.og4urrq.mongodb.net/?retryWrites=true&w=majority";
        String dataBase = "ManagementSoftware";
        String collection = "Materials";
        MongoCollection materialsCollection =  MongoDbManager.connectToCollection(uri, dataBase, collection);
        float totalCost = Float.parseFloat(String.valueOf(MongoDbManager.getDocumentValue(materialsCollection,"id", id, "cost")));
        int quantity = Integer.parseInt(String.valueOf(MongoDbManager.getDocumentValue(materialsCollection,"id", id, "quantity")));
        float unitQuantity = Math.round(totalCost/quantity);
        MongoDbManager.updateDocument(materialsCollection,"id", id, "unitCost", unitQuantity);
        return unitQuantity;
    }
    
    private static float computeMaterialsCostPerProduct(Product product){
        ArrayList materialsListPerProduct  = DictionaryConversor.convertToArrayList(product.getMaterials(), "values");
        ArrayList materialsQuantitiesPerProduct = DictionaryConversor.convertToArrayList(product.getMaterials(), "keys");
        float totalMaterialsCostPerProduct = 0;
        if(!materialsListPerProduct.isEmpty()){
            for(int i = 0; i< materialsListPerProduct.size(); i++){
                int materialId = Integer.parseInt(String.valueOf(materialsListPerProduct.get(i)));
                float materialUnitCost = computeMaterialUnitCost(materialId);
                float materialQuantity =  Float.parseFloat(String.valueOf(materialsQuantitiesPerProduct.get(i)));
                float materialTotalCost = materialUnitCost * materialQuantity;
                totalMaterialsCostPerProduct += materialTotalCost;
                }
        }
        return totalMaterialsCostPerProduct;
    }
    
    private static float computeWorkingTimeCostPerProduct(Product product){
        int workingTime = product.getWorkingTime();
        float currentSalary = 400.0F; //this value must come from database
        float workingHourCost = (float) ((currentSalary/30)/8);
        float workingTimeCostPerProduct = workingHourCost * workingTime;
        return workingTimeCostPerProduct;
    } 
    
    public static float calculateTotalProductProductionCost(Product product){
        float totalProductProductionCost = Math.round(computeMaterialsCostPerProduct(product) + computeWorkingTimeCostPerProduct(product));
        return totalProductProductionCost;
    }
}
