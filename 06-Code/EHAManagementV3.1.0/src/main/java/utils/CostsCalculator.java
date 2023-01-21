package utils;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.ehamanagement.controller.MaterialsOrganizer;
import ec.edu.espe.ehamanagement.controller.Profile;
import ec.edu.espe.ehamanagement.model.Material;
import ec.edu.espe.ehamanagement.model.Product;
import java.util.ArrayList;

/**
 *
 * @author Nahir Carrera, Gaman GeekLords, DCC0-ESPE
 */
public class CostsCalculator {
 
    public  static float computeMaterialUnitCost(Material material){
        float totalCost = material.getGeneralCost();
        double quantity = material.getGeneralQuantity();
        float unitQuantity = (float) (totalCost/quantity);
        return unitQuantity;
    }
    
    private  static float computeMaterialsCostPerProduct( MongoCollection materialsCollection, Product product){
        ArrayList materialsListPerProduct  = DictionaryConversor.convertToArrayList(product.getMaterials(), "keys");
        ArrayList materialsQuantitiesPerProduct = DictionaryConversor.convertToArrayList(product.getMaterials(), "values");
        float totalMaterialsCostPerProduct = 0;
        if(!materialsListPerProduct.isEmpty()){
            for(int i = 0; i< materialsListPerProduct.size(); i++){ 
                double materialId = Double.valueOf(String.valueOf(materialsListPerProduct.get(i)));
                float materialUnitCost = Float.parseFloat(String.valueOf(MaterialsOrganizer.getValueFromMaterial(materialsCollection, "id",(int)materialId, "unitCost")));
                float materialQuantity =  Float.valueOf(String.valueOf(materialsQuantitiesPerProduct.get(i)));
                float materialTotalCost = materialUnitCost * materialQuantity;
                totalMaterialsCostPerProduct += materialTotalCost;
                }
        }
        return totalMaterialsCostPerProduct;
    }
    
    private static float computeWorkingTimeCostPerProduct(MongoCollection userCollection, Product product){
        int workingTime = product.getWorkingTime();
        float currentSalary = Float.valueOf(String.valueOf(Profile.getValueFromUser(userCollection,1,"currentSalary"))); 
        float workingHourCost = (float) ((currentSalary/30)/8);
        float workingTimeCostPerProduct = workingHourCost * workingTime;
        return workingTimeCostPerProduct;
    } 
    
    public static float computeTotalProductProductionCost( MongoCollection materialsCollection, MongoCollection userCollection, Product product){
        float totalProductProductionCost = computeMaterialsCostPerProduct(materialsCollection, product) + computeWorkingTimeCostPerProduct(userCollection,product);
        return totalProductProductionCost;
    }
}
