// hw07
package ec.edu.espe.managementsoftware.model;
import java.util.ArrayList;

/**
 *
 * @author Nahir Carrera, Gaman GeekLords, DCC0-ESPE
 */
public class Product {
    private int id;
    private String name;
    private float cost;
    private String description;
    private ArrayList<Material> materials;
    private int workingTime;
    private int quantity;
    

    public Product(int id, String name, String description, ArrayList<Material> materials, int workingTime, int quantity ) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.materials = materials;
    this.workingTime = workingTime;
    this.quantity = quantity;
    }

    public Product() {
        
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", workingTime=" + workingTime + ", quantity=" + quantity + '}';
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cost
     */
    public float getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(float cost) {
        this.cost = cost;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the materialList
     */
    public ArrayList<Material> getMaterials() {
        return materials;
    }

    /**
     * @param materials
     
     */
    public void setMaterials(ArrayList<Material> materials) {
        this.materials = materials;
    }

    /**
     * @return the workingTime
     */
    public int getWorkingTime() {
        return workingTime;
    }

    /**
     * @param workingTime the workingTime to set
     */
    public void setWorkingTime(int workingTime) {
        this.workingTime = workingTime;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    

}
