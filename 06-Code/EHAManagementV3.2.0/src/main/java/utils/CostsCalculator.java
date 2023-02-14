package utils;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.ehamanagement.controller.MaterialsOrganizer;
import ec.edu.espe.ehamanagement.controller.Profile;
import ec.edu.espe.ehamanagement.model.Material;
import ec.edu.espe.ehamanagement.model.Product;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Nahir Carrera, Gaman GeekLords, DCC0-ESPE
 */
public class CostsCalculator {

    public static float computeMaterialUnitCost(Material material) throws ParseException {
        float totalCost = material.getGeneralCost();
        double quantity = material.getGeneralQuantity();
        float unitQuantity = (float) (totalCost / quantity);
        unitQuantity = roundToTwoDecimalPlaces(unitQuantity);
        System.out.println("material unit quantity ->" + unitQuantity);
        return unitQuantity;
    }

    private static float computeMaterialsCostPerProduct(MongoCollection materialsCollection, Product product) {
        ArrayList materialsListPerProduct = DictionaryConversor.convertToArrayList(product.getMaterials(), "keys");
        ArrayList materialsQuantitiesPerProduct = DictionaryConversor.convertToArrayList(product.getMaterials(), "values");
        float totalMaterialsCostPerProduct = 0;
        if (!materialsListPerProduct.isEmpty()) {
            for (int i = 0; i < materialsListPerProduct.size(); i++) {
                double materialId = Double.valueOf(String.valueOf(materialsListPerProduct.get(i)));
                float materialUnitCost = Float.parseFloat(String.valueOf(MaterialsOrganizer.getValueFromMaterial(materialsCollection, "id", (int) materialId, "unitCost")));
                float materialQuantity = Float.valueOf(String.valueOf(materialsQuantitiesPerProduct.get(i)));
                float materialTotalCost = materialUnitCost * materialQuantity;
                totalMaterialsCostPerProduct += materialTotalCost;
            }
        }
        return totalMaterialsCostPerProduct;
    }

    private static float obtainingValuesforWorkingTime(MongoCollection userCollection, Product product) throws ParseException {
        int workingTime = product.getWorkingTime();
        float currentSalary = Float.valueOf(String.valueOf(Profile.getValueFromUser(userCollection, 1, "currentSalary")));
        return computeWorkingTimeCostProduct(currentSalary, workingTime);

    }

    public static float computeTotalProductProductionCost(MongoCollection materialsCollection, MongoCollection userCollection, Product product) throws ParseException {
        float totalProductProductionCost = computeMaterialsCostPerProduct(materialsCollection, product) + obtainingValuesforWorkingTime(userCollection, product);
        return totalProductProductionCost;
    }

    private static float roundToTwoDecimalPlaces(float number) throws ParseException {
        BigDecimal bd = new BigDecimal(number);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        double roundedNumber = bd.doubleValue();
        float convertedNumber = Float.parseFloat(String.valueOf(roundedNumber));
        return convertedNumber;
    }

    public static float computeWorkingTimeCostProduct(float currentSalar, int working) throws ParseException {
        int workingTime = working;
        float currentSalary = currentSalar;
        float workingHourCost = (float) ((currentSalary / 30) / 8);
        float workingTimeCostPerProduct = workingHourCost * workingTime;
        return workingTimeCostPerProduct = roundToTwoDecimalPlaces(workingTimeCostPerProduct);
    }
}
