package PrimeraEntrega;

/**
 *
 * @author marco
 */
public class PetProtectionAssociation {

    private Integer parvovirusVaccines;
    private Integer hepatitisVaccines;
    private Integer rabiaVaccines;
    private Integer trivalenteVaccines;
    private Double totalDonation;

    public Integer getParvovirusVaccines() {
        return parvovirusVaccines;
    }

    public Integer getHepatitisVaccines() {
        return hepatitisVaccines;
    }

    public Integer getRabiaVaccines() {
        return rabiaVaccines;
    }

    public Integer getTrivalenteVaccines() {
        return trivalenteVaccines;
    }

    public Double getTotalDonation() {
        return totalDonation;
    }

    public PetProtectionAssociation() {
        this.hepatitisVaccines = 0;
        this.parvovirusVaccines = 0;
        this.trivalenteVaccines = 0;
        this.rabiaVaccines = 0;
        this.totalDonation = 0.0;
    }

    public void vaccinate(Pet pet, Vaccine vaccine) {
        System.out.println(pet.toString());
        System.out.println("Se aplicará la vacuna: " + vaccine.getName());

        if (pet.getAppliedVaccine() == null) {
            switch (vaccine.getName()) {
                case "Parvovirus" -> {
                    pet.setAppliedVaccine(vaccine);
                    parvovirusVaccines++;
                }
                case "Hepatitis" -> {
                    pet.setAppliedVaccine(vaccine);
                    hepatitisVaccines++;
                }
                case "Trivalente" -> {
                    pet.setAppliedVaccine(vaccine);
                    trivalenteVaccines++;
                }
                case "Rabia" -> {
                    pet.setAppliedVaccine(vaccine);
                    rabiaVaccines++;
                }
                default -> System.out.println("Código de vacuna inválido");

            }
            totalDonation += vaccine.getPrice();
            System.out.println("");

        } else {
            System.out.println("Lo sentimos ya se le ha aplicado una vacuna durante la jornada");
        }
    }

    public static void main(String[] args) {
        Vaccine parvovirus = new Vaccine(1, "Parvovirus", 20.0, 11);
        Vaccine trivalente = new Vaccine(2, "Trivalente", 12.0, 5);
        Vaccine rabia = new Vaccine(3, "Rabia", 30.0, 8);
        Vaccine hepatitis = new Vaccine(3, "Hepatitis", 18.0, 10);

        Pet pet1 = new Pet(101, "Firulais", 3, 12345670);
        Pet pet2 = new Pet(102, "Pepe", 7, 12345671);
        Pet pet3 = new Pet(103, "Elver", 1, 12345672);
        Pet pet4 = new Pet(104, "Gomez", 8, 12345673);
        Pet pet5 = new Pet(105, "Torba", 5, 12345674);
        Pet pet6 = new Pet(106, "Tortilla", 2, 12345670);
        Pet pet7 = new Pet(107, "Caramelo", 5, 12345671);
        Pet pet8 = new Pet(108, "Algodon", 6, 12345672);
        Pet pet9 = new Pet(109, "Crispeta", 0, 12345673);
        Pet pet10 = new Pet(110, "Chorizo", 4, 12345674);

        PetProtectionAssociation PPA = new PetProtectionAssociation();

        System.out.println("PROCESO DE VACUNACIÓN: ");

        PPA.vaccinate(pet1, parvovirus);
        PPA.vaccinate(pet2, parvovirus);
        PPA.vaccinate(pet3, trivalente);
        PPA.vaccinate(pet4, hepatitis);
        PPA.vaccinate(pet5, parvovirus);
        PPA.vaccinate(pet6, rabia);
        PPA.vaccinate(pet7, parvovirus);
        PPA.vaccinate(pet8, trivalente);
        PPA.vaccinate(pet9, hepatitis);
        PPA.vaccinate(pet10, parvovirus);

        System.out.println("----------------------------------------------");

        System.out.println("INFORMACIÓN FINAL DE LAS MASCOTAS: ");
        System.out.println(pet1.toString());
        System.out.println(pet2.toString());
        System.out.println(pet3.toString());
        System.out.println(pet4.toString());
        System.out.println(pet5.toString());
        System.out.println(pet6.toString());
        System.out.println(pet7.toString());
        System.out.println(pet8.toString());
        System.out.println(pet9.toString());
        System.out.println(pet10.toString());

        System.out.println("----------------------------------------------");

        System.out.println("Total de vacunas \"Parvovirus\" aplicadas: " + PPA.getParvovirusVaccines());

        Integer percentageHepatitis = (PPA.getHepatitisVaccines() * 100) / hepatitis.getQuantity();
        Double percentage = percentageHepatitis * 1.0;
        System.out.println("Porcentaje de vacunas \"Hepatitis\" aplicadas: " + percentage + "%");

        System.out.println("Donación total: $" + PPA.getTotalDonation());
    }

}
