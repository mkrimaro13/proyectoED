package CuartaEntrega;

import javax.swing.JOptionPane;

import PrimeraEntrega.Vaccine;
import SegundaEntrega.Validations;
import TerceraEntrega.DoubleList;
import TerceraEntrega.DoubleNode;

// La ejecución del árbol se incluye en la clase PetProtectionAssociation.java de la segunda entrega.
public class BinaryTree {
    private DoubleNode root;

    public BinaryTree() {
        root = null;
    }

    // Get y Set
    public DoubleNode getRoot() {
        return root;
    }

    public void setRoot(DoubleNode root) {
        this.root = root;
    }

    // Objetos auxiliares.
    Object info;
    DoubleNode q, aux;
    DoubleList l = new DoubleList();
    String text = "";
    int id, count = 0;
    Vaccine vaccine = new Vaccine();

    // Valida que la lista no esté vacía
    public boolean isEmpty() {
        return root == null;
    }

    // Crea la raíz.
    public void CreateRoot(Object info) {
        setRoot(new DoubleNode(null, info, null));
        q = getRoot();
    }

    // Crea los nodos.
    public void InsertNodes(DoubleNode q) {
        id = Validations.readInteger("Ingrese el código para la vacuna: " + q.getData().toString());
        vaccine = vaccine.vaccineRegistry(id);
        aux = new DoubleNode(null, vaccine, null);
    }

    // Inserta los nodos al árbol según la decisión del usuario.
    public void InsertSiblings(DoubleNode q) {
        int resp;
        resp = JOptionPane.showConfirmDialog(null, "Ingresar hijo izquierdo (Anterior) de\n" + q.getData(),
                "Ingreso de datos", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            // Inserta a la izquierda.
            InsertNodes(q);
            q.setPrevious(aux);
        }

        resp = JOptionPane.showConfirmDialog(null, "Ingresar hijo derecho (Siguiente) de " + q.getData(),
                "Ingreso de datos", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            // Inserta a la derecha
            InsertNodes(q);
            q.setNext(aux);
        }
    }

    public DoubleList leafNodes(DoubleNode q) {
        if (q != null) {
            leafNodes(q.getNext());
            leafNodes(q.getPrevious());
            if (q.getNext() == null && q.getPrevious() == null) {
                l.CreateNodeByEnd(q.getData());
            }
        }
        return l;
    }

    // Inicializa la variable que concatena los nodos en texto y el contador.
    public void Initialize() {
        text = "";
        count = 0;
    }

    // Método recursivo que crea el árbol y añade los nodos hijos utilizando el
    // método que inserta los nodos.
    public void Create(DoubleNode q) {
        if (q != null) {
            InsertSiblings(q);
            Create(q.getPrevious());
            Create(q.getNext());
        }
    }

    // Imprime el árbol en post orden.
    public String PostOrder(DoubleNode q) {
        if (q != null) {
            PostOrder(q.getPrevious());
            PostOrder(q.getNext());
            text = text + "(" + q.getData().toString() + ")\n";
        }
        return text;
    }
}