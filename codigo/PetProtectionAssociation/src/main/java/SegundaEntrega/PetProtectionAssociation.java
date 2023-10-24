package SegundaEntrega;

import javax.swing.JOptionPane;

import PrimeraEntrega.Pet;
import PrimeraEntrega.Vaccine;
import TerceraEntrega.DoubleList;

public class PetProtectionAssociation {
    public static void main(String[] args) {
        Stack stack = new Stack(4);
        Stack auxStack = new Stack(4);
        StackManagement stackManager = new StackManagement();
        Tail tail = new Tail(10);
        Tail auxTail = new Tail(10);
        TailManagement tailManager = new TailManagement();
        DoubleList doubleList = new DoubleList();
        int mainOp, stMenOp, stackMenOp, tailMenOp, listMenOp;
        PetProtectionAssociation PPA = new PetProtectionAssociation();
        do {
            mainOp = Validations.readInteger(PPA.MainMenu());
            switch (mainOp) {
                case 1:
                    do {
                        stMenOp = Validations.readInteger(PPA.StructuresMenu());
                        switch (stMenOp) {
                            case 1:
                                do {
                                    stackMenOp = Validations.readInteger(PPA.StackMenu());
                                    switch (stackMenOp) {
                                        case 1:
                                            stack = stackManager.enterData(stack);
                                            break;
                                        case 2:
                                            if (stack.isEmpty() == false) {
                                                JOptionPane.showMessageDialog(null,
                                                        "La información registrada es: \n"
                                                                + stackManager.print(stack, auxStack));
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No hay información registrada.");
                                            }
                                            break;
                                    }
                                } while (stackMenOp < 3);
                                break;
                            case 2:
                                do {
                                    tailMenOp = Validations.readInteger(PPA.TailMenu());
                                    switch (tailMenOp) {
                                        case 1:
                                            tail = tailManager.enterData(tail);
                                            break;
                                        case 2:
                                            if (tail.isEmpty() == false) {
                                                JOptionPane.showMessageDialog(null,
                                                        "La información registrada es: \n"
                                                                + tailManager.print(tail, auxTail));
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No hay información registrada.");
                                            }
                                            break;
                                        case 3:
                                            do{
                                                listMenOp = Validations.readInteger(null)
                                                doubleList = new DoubleList();

                                            }while (listMenOp < 3)
                                            break;
                                    }
                                } while (tailMenOp < 4);
                                break;
                        }
                    } while (stMenOp < 3);
                    break;
                case 2:
                    Vaccine highsetPriceVaccine = (Vaccine) stack.Pop();
                    while (stack.isEmpty() == false) {
                        Vaccine actualVaccine = (Vaccine) stack.Pop();
                        if (actualVaccine.getPrice() > highsetPriceVaccine.getPrice()) {
                            highsetPriceVaccine = actualVaccine;
                        }
                    }
                    JOptionPane.showMessageDialog(null,
                            "La vacuna de mayor precio por unidad es: \n" + highsetPriceVaccine);
                    break;
                case 3:
                    Pet pet;
                    Integer addingAges = 0, n = 0;
                    Double averageAge;
                    while (tail.isEmpty() == false) {
                        pet = (Pet) tail.Pop();
                        addingAges += pet.getAge();
                        n++;
                    }
                    averageAge = (double) (addingAges / n);
                    JOptionPane.showMessageDialog(null,
                            "La promedio de las mascotas es: \n" + averageAge);
            }
        } while (mainOp < 4);

    }

    public String MainMenu() {
        return "MENU PRINCIPAL\n"
                + "1. Ingreso de información\n"
                + "2. Vacuna de mayor precio\n"
                + "3. Promedio de edad de las mascotas\n"
                + "4. Salir ";
    }

    public String StructuresMenu() {
        return "MENU INFORMATIVO\n"
                + "1. Consultar información de las vacunas\n"
                + "2. Consultar información de las mascotas\n"
                + "3. Volver al menu principal ";
    }

    public String StackMenu() {
        return "MENU DE VACUNAS\n"
                + "1. Registrar información de la vacuna\n"
                + "2. Imprimir la información de las vacunas\n"
                + "3. Volver al menu anterior ";
    }

    public String TailMenu() {
        return "MENU DE MASCOTAS\n"
                + "1. Registrar información sobre las mascotas\n"
                + "2. Registrar información de las mascotas usando la lista doble \n"
                + "3. Imprimir la información de las mascotas registradas\n"
                + "4. Volver al menu anterior ";
    }

    public String listMenu() {
        return "SUBMENU DE MASCOTAS CON LISTAS DOBLES\n"
                + "1. Ingresar una mascota al inicio de la lista\n"
                + "2. Ingresar una mascota al final de la lista \n"
                + "3. Buscar una mascota por su código\n"
                + "4. Imprimir desde el inicio de la lista\n"
                + "5. Imprimir desde el final de la lista\n"
                + "2. Imprimir datos de forma ascendente\n";
    }

}
