/*
----------------
      Nodo 
----------------
-data: objeto
- next: Nodo
- prev: Nodo
----------------
Nodo()
Nodo(d)
Nodo(li,d,ld)
----------------

*/

package SegundaEntrega;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Node {

    // atributos propios de la clase
    private Object data;
    private Node next;
    private Node prev;

    // constructor vacio
    public Node() {
    }
    // fin método Nodo

    /*
     * constructor que recibe el data
     * y crea el nodo con su información
     * y coloca las ligas en null
     */
    public Node(Object d) {
        data = d;
        next = null;

    }// fin método Nodo

    /*
     * este constructor lo vamos a usar para el nodo doble de la lista
     * o el arbol, recibe tres parametros
     */
    public Node(Node li, Object d, Node ld) {
        prev = li;
        data = d;
        next = ld;

    }// fin método Nodo

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    // destructor ojo, este metodo finalize se genera, es el inicio de un
    // constructor
    public void finalize() {
        try {
            super.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(Node.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return data.toString();
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}// fin clase nodo
