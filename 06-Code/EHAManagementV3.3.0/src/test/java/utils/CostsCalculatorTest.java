package utils;

import ec.edu.espe.ehamanagement.model.Material;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Nahir Carrera, Gaman GeekLords, DCC0-ESPE
 */
public class CostsCalculatorTest {

    public CostsCalculatorTest() {
    }

    /**
     * Test of computeMaterialUnitCost method with two decimal places for generalCost, of class CostsCalculator.
     */
    @Test
    public void testComputeMaterialUnitCostTwoDecimalPlacesForGeneralCost(){
        System.out.println("computeMaterialUnitCost with two decimal places for genetalCost");
        Material material;
        material = new Material(1, "materialTest", 10, 5.00F, 0.00F);
        float expResult = 0.50F;
        float result = CostsCalculator.computeMaterialUnitCost(material);
        assertEquals(expResult, result, 0);

        material.setGeneralCost(2.50F);
        material.setGeneralQuantity(2);
        expResult = 1.25F;
        result = CostsCalculator.computeMaterialUnitCost(material);
        assertEquals(expResult, result, 0);

        material.setGeneralCost(5.83F);
        material.setGeneralQuantity(3);
        expResult = 1.94F;
        result = CostsCalculator.computeMaterialUnitCost(material);
        assertEquals(expResult, result, 0);
    }

    /*
     * Test of computeMaterialUnitCost method with none decimal places for generalCost, of class CostsCalculator.
     */
    @Test
    public void testComputeMaterialUnitCostNoneDecimalPlacesForGeneralCost(){
        System.out.println("computeMaterialUnitCost with none decimal places for genetalCost");
        Material material;
        material = new Material(1, "materialTest", 5, 10F, 0.00F);
        float expResult = 2.00F;
        float result = CostsCalculator.computeMaterialUnitCost(material);
        assertEquals(expResult, result, 0);

        material.setGeneralCost(5F);
        material.setGeneralQuantity(5);
        expResult = 1.00F;
        result = CostsCalculator.computeMaterialUnitCost(material);
        assertEquals(expResult, result, 0);

        material.setGeneralCost(5F);
        material.setGeneralQuantity(8);
        expResult = 0.63F;
        result = CostsCalculator.computeMaterialUnitCost(material);
        assertEquals(expResult, result, 0);
    }
      /*
     * Test of computeMaterialUnitCost method with cero value for generalCost, of class CostsCalculator.
     */
    @Test
    public void testComputeMaterialUnitCostCeroForGeneralCost(){
        System.out.println("computeMaterialUnitCost with cero value for genetalCost");
        Material material;
        material = new Material(1, "materialTest", 7, 0.00F, 0.00F);
        float expResult = 0.00F;
        float result = CostsCalculator.computeMaterialUnitCost(material);
        assertEquals(expResult, result, 0);
    }
    /*
     * Test of computeMaterialUnitCost method with big number to
     * generalQauntity, of class CostsCalculator.
     */
    @Test
    public void testComputeMaterialUnitCostBigNumberToGeneralQuantity(){
        System.out.println("computeMaterialUnitCost with big number to generalQuantity");
        Material material;
        material = new Material(1, "materialTest", 10000, 4.00F, 0.00F);
        float expResult = 0.00F;
        float result = CostsCalculator.computeMaterialUnitCost(material);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of computeMaterialUnitCost method with big number to generalCost, of
     * class CostsCalculator.
     */
    @Test
    public void testComputeMaterialUnitCostBigNumberToGeneralCost(){
        System.out.println("computeMaterialUnitCost for big number to generalCost");
        Material material;
        material = new Material(1, "materialTest", 10, 555555555.00F, 0.00F);
        float expResult = 5.555556E7F;
        float result = CostsCalculator.computeMaterialUnitCost(material);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of computeMaterialUnitCost method with big number to generalCost and generalQuantity, of class CostsCalculator.
     */
    @Test
    public void testComputeMaterialUnitCostTwoDecimalPlacesForBoth(){
        System.out.println("computeMaterialUnitCost with big number yo generalCost and generalQuantity");
        Material material;
        material = new Material(1, "materialTest", 7500, 2222222.2F, 0.00F);
        float expResult = 296.30F;
        float result = CostsCalculator.computeMaterialUnitCost(material);
        assertEquals(expResult, result, 0);

        material.setGeneralCost(2222222222F);
        material.setGeneralQuantity(30000001);
        expResult = 74.07F;
        result = CostsCalculator.computeMaterialUnitCost(material);
        assertEquals(expResult, result, 0);
    }
    /**
     * Test of computeWorkingTimeCostProduct method with two equal decimal places, of class CostsCalculator.
     */
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Test
    public void testComputeWorkingTimeCostProductTwoEqualDecimalPlaces(){
        System.out.println("computeWorkingTimeCostProduct with  two equal decimal places");
        float currentSalary = 400.00F;
        int working = 5;
        float expResult = 8.33F;
        float result = CostsCalculator.computeWorkingTimeCostProduct(currentSalary, working);
        assertEquals(expResult, result, 0);
        currentSalary=400.63F;
        working=10;
        expResult=18.78F;
        result=CostsCalculator.computeWorkingTimeCostProduct(currentSalary, working);

    }
    //*
    
     @Test
    public void testComputeWorkingTimeCostProductSmallPurePeriodicDecimals(){
        System.out.println("computeWorkingTimeCostProduct with compute small pure periodic decimals  ");
        float currentSalary = 22F;
        int working = 1;
        float expResult = 0.09F;
        float result = CostsCalculator.computeWorkingTimeCostProduct(currentSalary, working);
        assertEquals(expResult, result, 0);
    }
    @Test
     public void testComputeWorkingTimeCostProductLargeNumbersMixedNewspapers(){
        System.out.println("computeWorkingTimeCostProduct with with cero value ");
        float currentSalary = 98888888.10F;
        int working = 666666666;
        float expResult = 274691355558642.00F;
        float result = CostsCalculator.computeWorkingTimeCostProduct(currentSalary, working);
        assertEquals(expResult, result, 0);
    }

    /**
     *
     * Test the computeWorkingTimeCostProduct method with 2 decimal places.
     */

    @Test
    public void testComputeWorkingTimeCostProductTwoDecimal(){
        System.out.println("computeWorkingTimeCostProduct with two decimal");
        float currentSalary = 987.1F;
        int working = 8;
        float expResult = 32.90F;
        float result = CostsCalculator.computeWorkingTimeCostProduct(currentSalary, working);
        assertEquals(expResult, result, 0);

    }

    /**
     * Test of computeWorkingTimeCostProduct method with big number , of class CostsCalculator.
     */

    @Test
    public void testComputeWorkingTimeCostProductUnitCostBigNumber(){
        System.out.println("computeWorkingTimeCostProduct with big number");
        float currentSalary = 666321.03F;
        int working = 2;
        float expResult = 5552.67F;
        float result = CostsCalculator.computeWorkingTimeCostProduct(currentSalary, working);
        assertEquals(expResult, result, 0);
        currentSalary = 98765.22F;
        working = 12;
        expResult = 4938.26F;
        result = CostsCalculator.computeWorkingTimeCostProduct(currentSalary, working);
        assertEquals(expResult, result, 0);

    }

    /**
     * Test of computeMaterialUnitCost method  with an integer of zero, of class CostsCalculator.
     */

    @Test
    public void testComputeWorkingTimeCostProductCero(){
        System.out.println("computeWorkingTimeCostProduct with with cero value ");
        float currentSalary = 123.32F;
        int working = 0;
        float expResult = 0.00F;
        float result = CostsCalculator.computeWorkingTimeCostProduct(currentSalary, working);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of computeMaterialUnitCost method with  an exact decimal place
     */

    @Test
    public void testComputeWorkingTimeCostProductNoneDecimal(){
        System.out.println("computeWorkingTimeCostProduct none decimal places");
        float currentSalary = 24.00F;
        int working = 100;
        float expResult = 10.00F;
        float result = CostsCalculator.computeWorkingTimeCostProduct(currentSalary, working);
        assertEquals(expResult, result, 0);

    }
    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    /**
     * Test of computeMaterialsCostPerProduct method with two decimal places
     */
    @Test
    public void testComputeMaterialsCostPerProductTwoDecimal(){
        System.out.println("computeMaterialsCostPerProduct two decimal places");
        ArrayList materialsUnitCosts;
        ArrayList materialsQuantities;
    
        materialsUnitCosts = new ArrayList <>(Arrays.asList(0.5F, 1.00F, 1.42F, 1.80F));
        materialsQuantities = new ArrayList <>(Arrays.asList(2.1F, 1.0F, 3.5F, 1.0f));
        float expResult = 8.82F;
        float result = CostsCalculator.computeMaterialsCostPerProduct(materialsUnitCosts, materialsQuantities);
        assertEquals(expResult, result, 0);

    }
    
    /**
     * Test of computeMaterialsCostPerProduct method with none decimal places
     */
    @Test
    public void testComputeMaterialsCostPerProductNoneDecimal(){
        System.out.println("computeMaterialsCostPerProduct none decimal places");
        ArrayList materialsUnitCosts;
        ArrayList materialsQuantities;
    
        materialsUnitCosts = new ArrayList <>(Arrays.asList(1F, 2F, 3F, 1F));
        materialsQuantities = new ArrayList <>(Arrays.asList(1F, 5F, 3F, 1F));
        float expResult = 21F;
        float result = CostsCalculator.computeMaterialsCostPerProduct(materialsUnitCosts, materialsQuantities);
        assertEquals(expResult, result, 0);
    }
    
    /**
     * Test of computeMaterialsCostPerProduct method with both decimal and none decimal places
     */
    @Test
    public void testComputeMaterialsCostPerProductNoneAndDecimal(){
        System.out.println("computeMaterialsCostPerProduct none decimal places");
        ArrayList materialsUnitCosts;
        ArrayList materialsQuantities;
    
        materialsUnitCosts = new ArrayList <>(Arrays.asList(1.32F, 0.74F, 2.32F, 4F));
        materialsQuantities = new ArrayList <>(Arrays.asList(2F, 1F, 3F, 1f));
        float expResult = 14.34F;
        float result = CostsCalculator.computeMaterialsCostPerProduct(materialsUnitCosts, materialsQuantities);
        assertEquals(expResult, result, 0);
    }
    
    /**
     * Test of computeMaterialsCostPerProduct method with more decimal places
     */
    @Test
    public void testComputeMaterialsCostPerProductDecimals(){
        System.out.println("computeMaterialsCostPerProduct more decimal places");
        ArrayList materialsUnitCosts;
        ArrayList materialsQuantities;
    
        materialsUnitCosts = new ArrayList <>(Arrays.asList(2.1212F, 0.25F, 1.754F, 2F));
        materialsQuantities = new ArrayList <>(Arrays.asList(2.588F, 4.53F, 1.0004F, 6.5F));
        float expResult = 21.38F;
        float result = CostsCalculator.computeMaterialsCostPerProduct(materialsUnitCosts, materialsQuantities);
        assertEquals(expResult, result, 0);
        
        materialsUnitCosts = new ArrayList <>(Arrays.asList(0.32F, 2F, 1.2F, 0.3221F));
        materialsQuantities = new ArrayList <>(Arrays.asList(6F, 0.3F, 1F, 1.111111111F));
            expResult = 4.08F;
        result = CostsCalculator.computeMaterialsCostPerProduct(materialsUnitCosts, materialsQuantities);
        assertEquals(expResult, result, 0);
    }
    
    /**
     * Test of computeMaterialsCostPerProduct method with three materials
     */
    @Test
    public void testComputeMaterialsCostPerProductThreeMaterials(){
        System.out.println("computeMaterialsCostPerProduct three materials");
        ArrayList materialsUnitCosts;
        ArrayList materialsQuantities;
    
        materialsUnitCosts = new ArrayList <>(Arrays.asList(12F, 0.2F, 3F));
        materialsQuantities = new ArrayList <>(Arrays.asList(0.3F, 10F, 1.3F));
        float expResult = 9.5F;
        float result = CostsCalculator.computeMaterialsCostPerProduct(materialsUnitCosts, materialsQuantities);
        assertEquals(expResult, result, 0);
    }
    
    /**
     * Test of computeMaterialsCostPerProduct method with big numbers
     */
    @Test
    public void testComputeMaterialsCostPerProductBigNumbers(){
        System.out.println("computeMaterialsCostPerProduct big numbers");
        ArrayList materialsUnitCosts;
        ArrayList materialsQuantities;
    
        materialsUnitCosts = new ArrayList <>(Arrays.asList(200.11F, 90.1F, 212.11F, 40.21F));
        materialsQuantities = new ArrayList <>(Arrays.asList(1F, 2F, 0.05F, 12F));
        float expResult = 873.44F;
        float result = CostsCalculator.computeMaterialsCostPerProduct(materialsUnitCosts, materialsQuantities);
        assertEquals(expResult, result, 0);
        
        materialsUnitCosts = new ArrayList <>(Arrays.asList(21F, 1F, 3.21F, 921212.11F));
        materialsQuantities = new ArrayList <>(Arrays.asList(0.02F, 0.2F, 0.76F,0.72F));
        expResult = 663275.78F;
        result = CostsCalculator.computeMaterialsCostPerProduct(materialsUnitCosts, materialsQuantities);
        assertEquals(expResult, result, 0);
    }
    
    /**
     * Test of computeMaterialsCostPerProduct method with bIg numbers and two decimal places.
     */
    @Test
    public void testComputeMaterialsCostPerProductBigAndDecimal(){
        System.out.println("computeMaterialsCostPerProduct big numbers and two decimal places");
        ArrayList materialsUnitCosts;
        ArrayList materialsQuantities;
    
        materialsUnitCosts = new ArrayList <>(Arrays.asList(1111111.1F, 212F, 2222222.2F, 0.21F));
        materialsQuantities = new ArrayList <>(Arrays.asList(0.1F, 0.12F, 0.55F, 0.03F));
        float expResult = 133358.77F;
        float result = CostsCalculator.computeMaterialsCostPerProduct(materialsUnitCosts, materialsQuantities);
        assertEquals(expResult, result, 0);
    }
    
    /**
     * Test of computeMaterialsCostPerProduct method with same numbers;
     */
    @Test
    public void testComputeMaterialsCostPerProductSameNumbers(){
        System.out.println("computeMaterialsCostPerProduct big numbers and two decimal places");
        ArrayList materialsUnitCosts;
        ArrayList materialsQuantities;
    
        materialsUnitCosts = new ArrayList <>(Arrays.asList(1F, 1F,1F));
        materialsQuantities = new ArrayList <>(Arrays.asList(1F, 1F, 1F));
        float expResult = 3F;
        float result = CostsCalculator.computeMaterialsCostPerProduct(materialsUnitCosts, materialsQuantities);
        assertEquals(expResult, result, 0);
    }
    
    
}
