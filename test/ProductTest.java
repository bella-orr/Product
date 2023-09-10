import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product example;

    @BeforeEach
    void setUp()
    {
        example = new Product("000001", "Pipeweed", "Long Bottom Leaf", 600.0);
    }

    @Test
    void testToString()
    {
        assertEquals("Product{" +
                "ID='" + "000001" + '\'' +
                ", name='" + "Pipeweed" + '\'' +
                ", description='" + "Long Bottom Leaf" + '\'' +
                ", cost=" + 600.0 +
                '}' , example.toString());
    }

    @Test
    void setID()
    {
        example.setID("000001");
        assertEquals("000001",example.getID());
    }

    @Test
    void setName()
    {
        example.setID("Pipeweed");
        assertEquals("Pipeweed",example.getName());

    }

    @Test
    void setDescription()
    {
        example.setID("Long Bottom Leaf");
        assertEquals("Long Bottom Leaf",example.getDescription());
    }

    @Test
    void setCost()
    {
        example.setCost(600.0);
        assertEquals(600.0, example.getCost());
    }

    @Test
    void toCSVDataRecord()
    {
        assertEquals("000001"+", "+"Pipeweed"+", "+"Long Bottom Leaf"+", "+600.0, example.toCSVDataRecord());
    }
}