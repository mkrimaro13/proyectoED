package PrimeraEntrega;

import SegundaEntrega.Validations;

/**
 *
 * @author marco
 */
public class Vaccine {
    private Integer code;
    private String name;
    private Double price;
    private Integer quantity;

    public Vaccine(Integer code, String name, Double price, Integer quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Vaccine() {
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
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Código de la vacuna: " + code + "\n" +
        "Nombre de la vacuna: " + name + "\n" +
        "Precio unitario de la vacuna: " + price + "\n" +
        "Cantidad de vacunas disponibles: " + quantity + "\n" ;
    }

    // Para la segunda entrega, registro de vacunas
    public Vaccine vaccineRegistry() {
        String name;
        Integer code, quantity;
        Double price;
        Vaccine vaccine;
        code = Validations.readInteger("Ingresa el código de la vacuna: ");
        name = Validations.readString("Ingresa el nombre de la vacuna: ");
        price = Validations.readReal("Ingresa el precio por unidad de la vacuna: ");
        quantity = Validations.readInteger("Ingresa la cantidad de vacunas disponibles: ");
        vaccine = new Vaccine(code, name, price, quantity);
        return vaccine;
    }

}
