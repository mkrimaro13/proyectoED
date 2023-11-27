package PrimeraEntrega;

import java.io.Serializable;

import SegundaEntrega.Validations;

/**
 *
 * @author marco
 */
public class Pet implements Serializable {

    private Integer code;
    private String name;
    private Integer age;
    private Integer ownerId;
    private Vaccine appliedVaccine;

    public Pet() {
    }

    public Pet(int code, String name, int age, Integer ownerId, Vaccine appliedVaccine) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.ownerId = ownerId;
        this.appliedVaccine = appliedVaccine;
    }

    public Pet(int code, String name, int age, Integer ownerId) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.ownerId = ownerId;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Vaccine getAppliedVaccine() {
        return appliedVaccine;
    }

    public void setAppliedVaccine(Vaccine appliedVaccine) {
        this.appliedVaccine = appliedVaccine;
    }

    @Override
    public String toString() {
        if (appliedVaccine == null) {
            return "Código de la mascota: " + code + "\n" +
                    "Nombre de la mascota: " + name + "\n" +
                    "Edad de la mascota: " + age + "\n" +
                    "Identificación del propietario de la mascota: " + ownerId;
        } else {
            return "Código de la mascota: " + code + "\n" +
                    "Nombre de la mascota: " + name + "\n" +
                    "Edad de la mascota: " + age + "\n" +
                    "Identificación del propietario de la mascota: " + ownerId + "\n" +
                    "Vacuna aplicada a la mascota:" + "\n" +
                    "- Código de la vacuna: " + appliedVaccine.getCode() + "\n" +
                    "- Nombre de la vacuna: " + appliedVaccine.getName() + "\n";
        }
    }

    // Para la segunda entrega, registro de mascotas
    public Pet petRegistry() {
        String name;
        Integer code, age, ownerId;
        Pet pet;
        code = Validations.readInteger("Ingresa el código de la mascota: ");
        name = Validations.readString("Ingresa el nombre de la mascota: ");
        age = Validations.readInteger("Ingresa la edad: ");
        ownerId = Validations.readInteger("Ingresa el número de documento del dueño de la mascota: ");
        pet = new Pet(code, name, age, ownerId);
        return pet;
    }

    // Para la tercer entrega, registro de mascota por código
    public Pet petRegistry(int code) {
        String name;
        Integer age, ownerId;
        Pet pet;
        name = Validations.readString("Ingresa el nombre de la mascota: ");
        age = Validations.readInteger("Ingresa la edad: ");
        ownerId = Validations.readInteger("Ingresa el número de documento del dueño de la mascota: ");
        pet = new Pet(code, name, age, ownerId);
        return pet;
    }

    // Para la quinta entrega, editar el registro de una mascota
    public Object Edit(Object data) {
        String name;
        Integer code, age, ownerId,op;
        Pet pet;
        // pasamos a las variables auxiliares locales los datos del empleado
        code = ((Pet) data).getCode();
        name = ((Pet) data).getName();
        age = ((Pet) data).getAge();
        ownerId = ((Pet) data).getOwnerId();

        do {// mientras para el menu
            op = Validations.readInteger("Menu Cambios\n"
                    + "\n1. Nombre " + name
                    + "\n2. Edad " + age
                    + "\n3. Identificación del dueño " + ownerId
                    + "\n4. Terminar o salir");
            switch (op) {
                case 1:
                    name = Validations.readString("Nombre: ");
                    break;
                case 2:
                    age = Validations.readInteger("Edad: ");
                    break;
                case 3:
                    ownerId = Validations.readInteger("Identificación del dueño: ");
                    break;


            }// fin caso

        } while (op < 4);// fin mientras del menu
        // instanciamos un objeto para los nuevos datos
        pet = new Pet(code,name,age,ownerId);
        return pet;
    }
}
