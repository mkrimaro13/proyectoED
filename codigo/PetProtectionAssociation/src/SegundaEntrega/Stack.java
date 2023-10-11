
package SegundaEntrega;

import javax.swing.JOptionPane;

public class Stack {
    // atributos propios y privados
    private int maxsize;// tamaño maximo del almacenamiento
    private int size;// contador de nodos para que no se pase de maximo tamaño
    private Node top, q;// apuntador al tope y auxiliar q

    // constructores
    public Stack() {
    }

    public Stack(int n)// condiciones iniciales del constructor
    {
        maxsize = n;
        top = null;
        size = 0;
    }

    public boolean isEmpty() {// si esta vacia
        if (getSize() <= 0)
            return true;
        else
            return false;
    }

    public boolean isFull() {// si esta llena o sea ya se llego al maximo
        if (getSize() >= getMaxsize())
            return true;
        else
            return false;
    }

    // JOptionPane.showMessageDialog(null,"*****Pila LLena DESBORDAMIENTO DE
    // PILA*****");//OPCIONAL

    public void Push(Object d)// apilar
    {
        if (isFull() == false)// se van a colocar datos...problema?si esta llena
        {
            setSize(getSize() + 1);
            q = new Node(d);
            q.setNext(getTop());
            setTop(q);
        } else {
            JOptionPane.showMessageDialog(null, "*****Pila Llena DESBORDAMIENTO DE PILA*****");
            // (OPCIONAL);opcional avisarle al usuario pila LLENA
        }
        // opcional avisarle al usuario "pila LLENA..Desbordamiento de pila"
    }// fin de push - apilar

    public Object Pop() {
        Object d = null;
        if (isEmpty() == false)// se van a quitar datos...problema?si esta vacia
        {
            if (getTop().getNext() == null) {
                d = getTop().getData();
                setTop(null);
            } else {
                d = getTop().getData();
                q = getTop();
                setTop(getTop().getNext());
                q = (null);
            }
            setSize(getSize() - 1);
        } else {
            JOptionPane.showMessageDialog(null, "*****Pila Vacia SUBDESBORDAMIENTO DE PILA*****");
            // OPCIONAL);opcional avisarle al usuario pila VACIA
        }
        return d;

    }// fin de pop - desapilar

    public Object peek() {
        Object dato = null;
        if (isEmpty() == false) {
            dato = getTop().getData();
        }
        return dato;
    }// Fin método pop

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public int getMaxsize() {
        return maxsize;
    }

    public void setMaxsize(int maxsize) {
        this.maxsize = maxsize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}// fin clase pila
