package SegundaEntrega;

import java.io.Serializable;

import javax.swing.JOptionPane;

import CuartaEntrega.BinaryTree;
import PrimeraEntrega.Pet;
import PrimeraEntrega.Vaccine;
import QuintaEntrega.CRUD;
import QuintaEntrega.Fiile;
import TerceraEntrega.DoubleList;
import TerceraEntrega.ListsManagement;

public class PetProtectionAssociation implements Serializable {
    public static void main(String[] args) {
        Stack stack = new Stack(4);
        Stack auxStack = new Stack(4);
        StackManagement stackManager = new StackManagement();
        Tail tail = new Tail(10);
        Tail auxTail = new Tail(10);
        TailManagement tailManager = new TailManagement();
        DoubleList doubleList = new DoubleList();
        DoubleList doubleList2 = new DoubleList();
        ListsManagement listsManager = new ListsManagement();
        int mainOp, stMenOp, stackMenOp, tailMenOp, listMenOp, listMenOp2, code1, code2, treeMenOp, fileMenOp;
        Pet pet = new Pet();
        Vaccine vaccine = new Vaccine();
        BinaryTree tree = new BinaryTree();
        PetProtectionAssociation PPA = new PetProtectionAssociation();
        Fiile file = new Fiile();
        CRUD crud = new CRUD();
        file = crud.Creation();
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
                                            if (stack.isEmpty()) {
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
                                    treeMenOp = Validations.readInteger(PPA.treeMenu());
                                    switch (treeMenOp) {
                                        case 1:
                                            tree = new BinaryTree();
                                            int vaccioneCode = Validations.readInteger(
                                                    "Ingresa el código de la vacuna que será la raíz del árbol");
                                            vaccine = vaccine.vaccineRegistry(vaccioneCode);
                                            tree.CreateRoot(vaccine);
                                            tree.Create(tree.getRoot());
                                            break;
                                        case 2:
                                            // Valida que el árbol no esté vacío para poder imprimirlo.
                                            if (tree.isEmpty()) {
                                                JOptionPane.showMessageDialog(null, "Árbol Vacío");
                                            } else {
                                                tree.Initialize();
                                                JOptionPane.showMessageDialog(null, "Los datos almacenados son: \n"
                                                        + tree.PostOrder(tree.getRoot()));
                                            }
                                            break;
                                        case 3:
                                            doubleList2 = tree.leafNodes(tree.getRoot());
                                            if (tree.isEmpty()) {
                                                JOptionPane.showMessageDialog(null, "No hay nodos terminales");
                                            } else {
                                                tree.Initialize();
                                                JOptionPane.showMessageDialog(null, "Los nodos terminales son: \n"
                                                        + doubleList2.PrintFromFinal());
                                            }
                                            break;
                                        case 4:
                                            if (tree.isEmpty()) {
                                                JOptionPane.showMessageDialog(null,
                                                        "Árbol vacío ingresa datos primero.");
                                            } else {
                                                do {
                                                    fileMenOp = Validations.readInteger(PPA.FileMenu());
                                                    String text;
                                                    switch (fileMenOp) {
                                                        case 1:
                                                            crud.AddingLeafs(file, doubleList2);
                                                            text = file.ShowAll();
                                                            if (!text.equals("")) {
                                                                JOptionPane.showMessageDialog(null, "" + text);
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                doubleList.ReleaseFinal();
                                                            } while (!doubleList.isEmpty());
                                                            file.CopyListFile(doubleList);
                                                            JOptionPane.showMessageDialog(null, "Se copió la información del archivo" + doubleList.PrintFromFinal());
                                                            break;
                                                    }
                                                    crud.Write(file);
                                                } while (fileMenOp < 3);
                                            }
                                            break;
                                    }
                                } while (treeMenOp < 5);
                                break;
                            case 3:
                                do {
                                    tailMenOp = Validations.readInteger(PPA.TailMenu());
                                    switch (tailMenOp) {
                                        case 1:
                                            tail = tailManager.enterData(tail);
                                            break;
                                        case 2:
                                            do {
                                                listMenOp = Validations.readInteger(PPA.listMenu());
                                                switch (listMenOp) {
                                                    case 1:
                                                        listMenOp2 = Validations.readInteger("Ingresar datos por: \n"
                                                                + "1. Ingresar datos por el inicio.\n"
                                                                + "2. Ingresar datos por el final. \n");
                                                        doubleList = listsManager.InsertData(doubleList, listMenOp2);
                                                        break;
                                                    case 2:
                                                        if (doubleList.isEmpty()) {
                                                            JOptionPane.showMessageDialog(null, "No hay información");
                                                        } else {
                                                            JOptionPane.showMessageDialog(null,
                                                                    "La información registrada es: \n"
                                                                            + doubleList.PrintFromHead());
                                                        }
                                                        break;
                                                    case 3:
                                                        if (doubleList.isEmpty()) {
                                                            JOptionPane.showMessageDialog(null, "No hay información");
                                                        } else {
                                                            JOptionPane.showMessageDialog(null,
                                                                    "La información registrada es: \n"
                                                                            + doubleList.PrintFromFinal());
                                                        }
                                                        break;
                                                    case 4:
                                                        if (doubleList.isEmpty()) {
                                                            JOptionPane.showMessageDialog(null, "No hay información");
                                                        } else {
                                                            code1 = Validations
                                                                    .readInteger("Código de la mascota a buscar");
                                                            JOptionPane.showMessageDialog(null,
                                                                    "La información de la mascota es: \n"
                                                                            + doubleList.Search(code1));
                                                        }
                                                        break;
                                                    case 5:
                                                        if (doubleList.isEmpty()) {
                                                            JOptionPane.showMessageDialog(null,
                                                                    "Lista vacia no se puede insertar debe crear");
                                                        } else {
                                                            code1 = Validations.readInteger(
                                                                    "Código de la mascota que se va a ingresa");
                                                            pet = pet.petRegistry(code1);
                                                            doubleList.InsertAsHead(pet);
                                                            JOptionPane.showMessageDialog(null,
                                                                    "Se ha registrado a la mascota con código " + code1
                                                                            + " al principio de la lista");
                                                        }
                                                        break;
                                                    case 6:
                                                        if (doubleList.isEmpty()) {
                                                            JOptionPane.showMessageDialog(null,
                                                                    "Lista vacia no se puede insertar debe crear");
                                                        } else {
                                                            code1 = Validations.readInteger(
                                                                    "Código de la mascota que se va a ingresa");
                                                            pet = pet.petRegistry(code1);
                                                            doubleList.InsertAsFinal(pet);
                                                            JOptionPane.showMessageDialog(null,
                                                                    "Se ha registrado a la mascota con código " + code1
                                                                            + " al final de la lista");
                                                        }
                                                        break;
                                                    case 7:
                                                        if (doubleList.isEmpty()) {
                                                            JOptionPane.showMessageDialog(null,
                                                                    "Lista vacia no se puede insertar debe crear");
                                                        } else {
                                                            code1 = Validations.readInteger(
                                                                    "Indica el código de la mascota que se usará como referencia");
                                                            if (doubleList.Search(code1) == true) {
                                                                code2 = Validations.readInteger(
                                                                        "Ingresa el código de la mascota que registrará: ");
                                                                pet = pet.petRegistry(code2);
                                                                doubleList.InsertAfter(code2, pet);
                                                            } else {
                                                                JOptionPane.showMessageDialog(null,
                                                                        "La mascota de referencia no existe");
                                                            }
                                                        }
                                                        break;
                                                    case 8:
                                                        if (doubleList.isEmpty()) {
                                                            JOptionPane.showMessageDialog(null,
                                                                    "Lista vacia no se puede insertar debe crear");
                                                        } else {
                                                            code1 = Validations.readInteger(
                                                                    "Indica el código de la mascota que se usará como referencia");
                                                            if (doubleList.Search(code1) == true) {
                                                                code2 = Validations.readInteger(
                                                                        "Ingresa el código de la mascota que registrará: ");
                                                                pet = pet.petRegistry(code2);
                                                                doubleList.InsertBefore(code2, pet);
                                                            } else {
                                                                JOptionPane.showMessageDialog(null,
                                                                        "La mascota de referencia no existe");
                                                            }
                                                        }
                                                        break;
                                                    case 9:
                                                        if (doubleList.isEmpty()) {
                                                            JOptionPane.showMessageDialog(null,
                                                                    "Lista vacia no se puede insertar debe crear");
                                                        } else {
                                                            JOptionPane.showMessageDialog(null,
                                                                    "Se eliminará el registro de la mascota: "
                                                                            + doubleList.ReleaseHead());
                                                        }
                                                        break;
                                                    case 10:
                                                        if (doubleList.isEmpty()) {
                                                            JOptionPane.showMessageDialog(null,
                                                                    "Lista vacia no se puede insertar debe crear");
                                                        } else {
                                                            JOptionPane.showMessageDialog(null,
                                                                    "Se eliminará el registro de la mascota: "
                                                                            + doubleList.ReleaseFinal());
                                                        }
                                                        break;
                                                    case 11:
                                                        if (doubleList.isEmpty()) {
                                                            JOptionPane.showMessageDialog(null,
                                                                    "Lista vacia no se puede insertar debe crear");
                                                        } else {
                                                            code1 = Validations.readInteger(
                                                                    "Indica el código de la mascota que se va a eliminar: ");
                                                            JOptionPane.showMessageDialog(null,
                                                                    "Se eliminará el registro de la mascota: "
                                                                            + doubleList.ReleaseHead());
                                                        }
                                                        break;
                                                    case 12:
                                                        doubleList2 = doubleList;
                                                        Double addingAges = 0.0, n = 0.0, averageAge;
                                                        while (doubleList2.isEmpty() == false) {
                                                            pet = (Pet) doubleList2.ReleaseFinal();
                                                            addingAges += pet.getAge();
                                                            n++;
                                                        }
                                                        averageAge = (double) (addingAges / n);
                                                        JOptionPane.showMessageDialog(null,
                                                                "La promedio de las mascotas es: \n" + averageAge);
                                                        break;
                                                }
                                            } while (listMenOp < 13);
                                            break;
                                        case 3:

                                            if (tail.isEmpty()) {
                                                JOptionPane.showMessageDialog(null,
                                                        "La información registrada es: \n"
                                                                + tailManager.print(tail, auxTail));
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No hay información registrada.");
                                            }
                                            break;

                                    }
                                } while (tailMenOp < 4);
                                break;
                        }
                    } while (stMenOp < 4);
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
                + "1. Consultar información de las vacunas con pilas\n"
                + "2. Consultar información de las vacunas con árbol binario\n"
                + "3. Consultar información de las mascotas\n"
                + "4. Volver al menu principal ";
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
        return "MENU DE MASCOTAS CON LISTAS DOBLES\n"
                + "1. Crear la lista\n"
                + "2. Imprimir desde el inicio de la lista\n"
                + "3. Imprimir desde el final de la lista\n"
                + "4. Imprimir la información de una mascota por su código\n"
                + "5. Registrar una mascota al inicio de la lista\n"
                + "6. Registrar una mascota al final de la lista\n"
                + "7. Registrar una mascota después de una mascota de referencia\n"
                + "8. Registrar una mascota antes de una mascota de referencia\n"
                + "9. Eliminar el registro de una mascota al inicio de la lista\n"
                + "10. Eliminar el registro de una mascota al final de la lista\n"
                + "11. Eliminar el registro de una mascota que sea indicado.\n"
                + "12. Calcular el promedio de edad de las mascotas.\n"
                + "13. Volver a l menu anterior\n";
    }

    public String treeMenu() {
        return "MENÚ DE VACUNAS CON ÁRBOL BINARIO\n"
                + "1. Crear árbol\n"
                + "2. Mostrar PostOrden\n"
                + "3. Mostrar los nodos terminales\n"
                + "4. Gestión de archivos.\n"
                + "5. Volver al menu anterior";
    }

    public String FileMenu() {
        return "MENÚ DE GESTIÓN DE ARCHIVO\n"
                + "1. Grabar los nodos terminales del árbol binario\n"
                + "2. Copiar los datos del archivo a la lista por el final, y despilar los datos existentes.\n"
                + "3. Volver al menu anterior";
    }

}
