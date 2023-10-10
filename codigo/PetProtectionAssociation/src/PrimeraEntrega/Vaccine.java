package PrimeraEntrega;

/**
 *
 * @author marco
 */
public class Vaccine {
    private Integer code;
    private String name;
    private Double price;
    private Integer Quantity;

    public Vaccine(Integer code, String name, Double price, Integer Quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.Quantity = Quantity;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }
    
    
}
