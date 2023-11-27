package PrimeraEntrega;

import java.io.Serializable;

import SegundaEntrega.Validations;

/**
 *
 * @author marco
 */
public class Vaccine implements Serializable{
    private Integer code;
    private String name;
    private Double price;
    private Integer quantity;

    public Vaccine() {
    }

    public Vaccine(Integer code, String name, Double price, Integer quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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
                "Cantidad de vacunas disponibles: " + quantity + "\n";
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

    // Para la cuarta entrega, registro de vacunas ingresando el código.
    public Vaccine vaccineRegistry(int code) {
        String name;
        int quantity;
        Double price;
        Vaccine vaccine;
        name = Validations.readString("Ingresa el nombre de la vacuna: ");
        price = Validations.readReal("Ingresa el precio por unidad de la vacuna: ");
        quantity = Validations.readInteger("Ingresa la cantidad de vacunas disponibles: ");
        vaccine = new Vaccine(code, name, price, quantity);
        return vaccine;
    }

    public Object Edit(Object data) {
        String name;
        int code, quantity,op;
        Double price;
        Vaccine vaccine;
        // pasamos a las variables auxiliares locales los datos del empleado
        code = ((Vaccine) data).getCode();
        name = ((Vaccine) data).getName();
        price = ((Vaccine) data).getPrice();
        quantity = ((Vaccine) data).getQuantity();

        do {// mientras para el menu
            op = Validations.readInteger("Menu Cambios\n"
                    + "\n1. Nombre " + name
                    + "\n2. Precio " + price
                    + "\n3. Cantidad " + quantity
                    + "\n4. Terminar o salir");
            switch (op) {
                case 1:
                    name = Validations.readString("Nombre: ");
                    break;
                case 2:
                    price = Validations.readReal("Precio: ");
                    break;
                case 3:
                    quantity = Validations.readInteger("Cantidad: ");
                    break;


            }// fin caso

        } while (op < 4);// fin mientras del menu
        // instanciamos un objeto para los nuevos datos
        vaccine = new Vaccine(code, name, price, quantity);
        return vaccine;
    }
}
