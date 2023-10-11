package SegundaEntrega;

import javax.swing.JOptionPane;

import PrimeraEntrega.Pet;

public class TailManagement {

    // Registro de mascotas.
    public Tail enterData(Tail tail) {
        Pet pet = new Pet();
        int resp = JOptionPane.showConfirmDialog(null, "¿Ingresar Mascota?", "Encolando datos",
                JOptionPane.YES_NO_OPTION);
        while (resp == JOptionPane.YES_OPTION) {
            pet = pet.petRegistry();
            tail.Push(pet);
            resp = JOptionPane.showConfirmDialog(null, "¿Ingresar otra Mascota?", "encolando datos",
                    JOptionPane.YES_NO_OPTION);
        }
        return tail;
    }

    // Elemina elementos de la cola A mientras lo encola en la cola B.
    public void tailMovement(Tail a, Tail b) {
        while (a.isEmpty() == false) {
            b.Push(a.Pop());
        }
    }

    // Retorna los datos de una cola en una cadena, sin perder la cadena original.
    public String print(Tail tail, Tail auxTail) {
        String text = "";
        Object data;
        while (tail.isEmpty() == false) {
            data = tail.Pop();
            text = text + data.toString() + "\n";
            auxTail.Push(data);
        }
        tailMovement(auxTail, tail);
        return text;
    }

}
