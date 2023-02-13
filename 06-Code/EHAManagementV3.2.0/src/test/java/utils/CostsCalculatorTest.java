package utils;

import ec.edu.espe.ehamanagement.model.Material;
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
    public void testComputeMaterialUnitCostTwoDecimalPlacesForGeneralCost() throws Exception {
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
    /**
     * Test of computeMaterialUnitCost method with none decimal places for generalCost, of class CostsCalculator.
     */
    @Test
    public void testComputeMaterialUnitCostNoneDecimalPlacesForGeneralCost() throws Exception {
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
    /**
     * Test of computeMaterialUnitCost method with cero value for generalCost, of class CostsCalculator.
     */
    @Test
    public void testComputeMaterialUnitCostCeroForGeneralCost() throws Exception {
        System.out.println("computeMaterialUnitCost with cero value for genetalCost");
        Material material;
        material = new Material(1, "materialTest", 7, 0.00F, 0.00F);
        float expResult = 0.00F;
        float result = CostsCalculator.computeMaterialUnitCost(material);
        assertEquals(expResult, result, 0);
    }
    /**
     * Test of computeMaterialUnitCost method with big number to generalQauntity, of class CostsCalculator.
     */
    
    @Test
    public void testComputeMaterialUnitCostBigNumberToGeneralQuantity() throws Exception {
        System.out.println("computeMaterialUnitCost with big number to generalQuantity");
        Material material;
        material = new Material(1, "materialTest", 10000, 4.00F, 0.00F);
        float expResult = 0.00F;
        float result = CostsCalculator.computeMaterialUnitCost(material);
        assertEquals(expResult, result, 0);
    }
    /**
     * Test of computeMaterialUnitCost method with big number to generalCost, of class CostsCalculator.
     */
    @Test
    public void testComputeMaterialUnitCostBigNumberToGeneralCost() throws Exception {
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
    public void testComputeMaterialUnitCostTwoDecimalPlacesForBoth() throws Exception {
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
}
