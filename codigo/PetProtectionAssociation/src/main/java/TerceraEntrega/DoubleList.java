
package TerceraEntrega;

import javax.swing.JOptionPane;

import PrimeraEntrega.Pet;

public class DoubleList {
    // atributos propios y privados
    private DoubleNode Head;

    // constructor vacio
    public DoubleList() {
        Head = null;// condiciones iniciales de lista doble
    }

    // nodos auxiliares
    DoubleNode q, p, End;

    /*
     * metodo para validar si la lista esta vacia
     * o tiene datos, retorna verdadero si no hay datos
     */
    public boolean isEmpty() {
        if (getHead() == null)
            // "LISTA VACIA!!!“ //mensaje opcional
            return true;
        else
            return false;
        // fin si
    }// fin esta vacia

    /*
     * este metodo ubica el apuntador auxiliar Fin en el ultimo nodo
     * de la lista
     */
    public DoubleNode LocateLast() {
        End = getHead();
        while (End.getNext() != null) {
            End = End.getNext();
        } // fin de mientras
        return End;
    }// fin de ubicarultimo

    /*
     * este metodo crea la lista en caso de que no exista y coloca
     * nuevos datos por el apuntador Fin, quedando de primero el primero
     * que ingresa, el apuntador Fin es un auxiliar y por eso NO se encapsula
     * y siempre se debe estar ubicando
     */
    public void CreateNodeByEnd(Object info) {
        q = new DoubleNode(null, info, null);
        if (isEmpty() == true) {
            setHead(q);
            End = q;
        } else {
            End.setNext(q);
            q.setPrevious(End);
            End = q;
        } // Fin si
    }// fin crearlista por final

    /*
     * este metodo crea la lista en caso de que no exista y coloca
     * nuevos datos por el apuntador cabeza, quedando de ultimo el primero
     * que ingresa
     */

    public void CreateNodeByStart(Object info) {
        q = new DoubleNode(null, info, null);// se crea el nodo y se le mandan los 3 parametros o argumentos
        if (isEmpty() == true)
            setHead(q);
        else {
            getHead().setPrevious(q);
            q.setNext(getHead());
            setHead(q);
        } // Fin si
    }// fin crearlista por final

    /*
     * metodo que retorna una cadena con los datos de la lista desde el primero
     * NO imprime
     */
    public String PrintFromHead() {
        String text = " \n";
        if (isEmpty() == false)// si la lista tiene datos
        {
            q = getHead();
            while (q != null) {
                text = text + "\n" + q.toString(); // q.obtenerDato()
                q = q.getNext();
            } // fin mientras
        } // Fin si
        return text;
    }// Fin imprimir

    /*
     * metodo que retorna una cadena con los datos de la lista desde el ultimo
     * NO imprime
     */
    public String PrintFromFinal() {
        String text = " \n";
        if (isEmpty() == false) {
            LocateLast(); // ubica al nodo fin
            while (End != null) {
                text = text + "\n" + End.toString();// fin.obtenerDato()
                End = End.getPrevious();
            } // fin mientras
        } // Fin si
        return text;
    }// Fin imprimir

    /*
     * este metodo inserta un nodo de primero y SIEMPRE parte de
     * la base de tener informacion la lista, o sea NO crea la lista desde
     * cero
     */
    public void InsertAsHead(Object info) {
        if (isEmpty() == false)// si hay datos
        {
            getHead().setPrevious(new DoubleNode(null, info, getHead()));
            setHead(getHead().getPrevious());
        }

        // Fin si
    }// Fin de insertar como cabeza

    /*
     * este metodo inserta un nodo de ultimo y SIEMPRE parte de
     * la base de tener informacion la lista, o sea NO crea la lista desde
     * cero
     */
    public void InsertAsFinal(Object info) {
        if (isEmpty() == false) {
            End = LocateLast();
            End.setNext(new DoubleNode(End, info, null));

        } // Fin si
    }// Fin de insertar Final

    /*
     * Libera el espacio de memoria y elimina el primer dato de la lista
     * usa el destructor basico que es finalize
     */
    public Object ReleaseHead() {
        Object info = null;
        if (isEmpty() == false) /// si hay datos
        {
            q = getHead(); // toma la memoria donde esta el primer nodo
            info = q.getData();
            if (getHead().getNext() == null) // si es lista de un solo nodo
                setHead(null); // lista quedo vacia
            else {
                setHead(getHead().getNext());
                getHead().setPrevious(null);
            } // fin si
            q.finalize();
        } else
            JOptionPane.showMessageDialog(null, "Lista vacia No podemos liberar cabeza");
        // fin si
        return info;
    }// fin liberar cabeza

    /*
     * Libera el espacio de memoria y elimina el ultimo dato de la lista
     * usa el destructor basico que es finalize
     */
    public Object ReleaseFinal() {
        Object info = null;
        if (isEmpty() == false) /// si hay datos
        {
            LocateLast();
            info = End.getData();
            if (getHead().getNext() == null) // si es lista de un solo nodo
                setHead(null); // lista quedo vacia
            else {
                End.getPrevious().setNext(null);
                // fin si
                End.finalize();
            }

        } else
            JOptionPane.showMessageDialog(null, "Lista vacia No podemos liberar el ultimo");
        // fin si
        return info;
    }// fin liberar ultimo

    /*
     * busca por código y si lo encuentra retorna verdadero y deja ubicado en el dato
     * al nodo p ....y si no lo encuentra retorna falso y p no apunta a nada
     */
    public boolean Search(int id) {
        p = getHead();
        Pet pet;
        pet = (Pet) p.getData();// se toma el primer dato
        int idp = pet.getCode();// se toma el código del primer dato
        while (p != null && !(id == idp)) {
            p = p.getNext();
            if (p != null) {
                pet = (Pet) p.getData();// se toma el dato señalado por p en este momento
                idp = pet.getCode();// se toma el código del dato señalado por p para compararlo
            }
        } // fin mientras
        if (p == null)
            return false;
        else
            p.toString();
            return true;
        // fin si
    }// fin buscar

    /*
     * Libera el espacio de memoria y elimina el dato del id que se busca, puede
     * estar en
     * cualquier nodo de la lista y debe tomarse en cuenta
     * usa el destructor basico que es finalize
     */
    public void ReleaseData(int id) {
        if (isEmpty() == false) {
            if (Search(id) == false)
                JOptionPane.showMessageDialog(null, "Dato no se encuentra en la lista");
            else {
                if (p.getPrevious() == null) // Si(p=obtenerCabeza()) ///si es el primer dato
                    ReleaseHead();
                else {
                    if (p.getNext() == null)// si es el ultimo dato de la lista
                        ReleaseFinal();
                    else// sino esta entre dos nodos
                    {
                        p.getPrevious().setNext(p.getNext());
                        p.getNext().setPrevious(p.getPrevious());
                        p.finalize(); // - liberar(p);
                    } // fin si
                } // fin si
            } // fin si

        } // fin si
    }// fin liberar dato

    public void InsertAfter(int idSearch, Object dataIns) {

        if (Search(idSearch) == true) {

            if (p.getNext() == null) {
                InsertAsFinal(dataIns);
            } else {
                p.setNext(new DoubleNode(p, dataIns, p.getNext()));
                p.getNext().getNext().setPrevious(p.getNext());
            } // fin si
        }

        // Fin si
    }// fin metodo insertar despues

    public void InsertBefore(int idSearch, Object dataIns) {

        if (Search(idSearch) == true) {

            if (p.getPrevious() == null)// if(p==getCabeza())
            {
                InsertAsHead(dataIns);
            } else {
                p.setPrevious(new DoubleNode(p.getPrevious(), dataIns, p));
                p.getPrevious().getPrevious().setNext(p.getPrevious());
            } // fin si
        }
        // Fin si
    }// fin metodo insertar despues

    /**
     * @return the Cabeza
     */
    public DoubleNode getHead() {
        return Head;
    }

    /**
     * @param Cabeza the Cabeza to set
     */
    public void setHead(DoubleNode Head) {
        this.Head = Head;
    }

}// fin clase lista doble
