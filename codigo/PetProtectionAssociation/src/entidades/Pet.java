package entidades;

/**
 *
 * @author marco
 */
public class Pet {

    private Integer code;
    private String name;
    private Integer age;
    private String ownerId;
    private Vaccine appliedVaccine;

    public Pet(int code, String name, int age, String ownerId, Vaccine appliedVaccine) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.ownerId = ownerId;
        this.appliedVaccine = appliedVaccine;
    }

    public Pet(int code, String name, int age, String ownerId) {
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

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Vaccine getAppliedVaccine() {
        return appliedVaccine;
    }

    public void setAppliedVaccine(Vaccine appliedVaccine) {
        this.appliedVaccine = appliedVaccine;
    }

    public void printPetInformation() {
        System.out.println("Código de la mascota: " + code);
        System.out.println("Nombre de la mascota: " + name);
        System.out.println("Edad de la mascota: " + age);
        System.out.println("Identificación del propietario de la mascota: " + ownerId);
        if (appliedVaccine != null) {
            System.out.println("Vacuna aplicada a la mascota:");
            System.out.println("- Código de la vacuna: " + appliedVaccine.getCode());
            System.out.println("- Nombre de la vacuna: " + appliedVaccine.getName());
            System.out.println("");

        }
    }
}
