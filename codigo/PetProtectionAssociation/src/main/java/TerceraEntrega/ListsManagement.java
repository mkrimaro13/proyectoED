
package TerceraEntrega;

import javax.swing.JOptionPane;

import PrimeraEntrega.Pet;
import SegundaEntrega.Validations;

// La implementación de este método se realiza en la clase "PetProtectionAssociation.java" de la segunda entrega.
public class ListsManagement {
    /*
     * este metodo ingresa varios datos en la lista doble
     * por el inicio o por el final, mientras que el usuario quiera,
     * la opcion 1 esta ingresando por el inicio, de lo contrario
     * se esta ingresando por el final
     */
    public DoubleList InsertData(DoubleList objl, int op) {
        int resp, id;
        Pet pet;
        resp = JOptionPane.showConfirmDialog(null, "¿Ingresar datos?", "Lista Doble", JOptionPane.YES_NO_OPTION);
        while (resp == JOptionPane.YES_OPTION) {
            id = Integer.parseInt(Validations.readString("Código de la mascota: "));
            pet = new Pet();
            pet = pet.petRegistry(id);
            if (op == 1)// creando por el inicio
                objl.CreateNodeByStart(pet);
            else// creando por el final...son excluyentes
                objl.CreateNodeByEnd(pet);
            resp = JOptionPane.showConfirmDialog(null, "¿Ingresar mas datos?", "Lista doble", JOptionPane.YES_NO_OPTION);
        } // fin mientras
        return objl;
    }// fin de ingresar

}
