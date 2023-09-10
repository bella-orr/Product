public class Product
{
    private String ID = "";
    private String name = "";
    private String description = "";
    private String record = "";
    private double cost = 0;

    public Product(String ID, String name, String description, String record, double cost) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.record = record;
        this.cost = cost;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
