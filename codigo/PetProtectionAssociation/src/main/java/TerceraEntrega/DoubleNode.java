package TerceraEntrega;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DoubleNode {
    private Object data;
    private DoubleNode next;
    private DoubleNode previous;

    public DoubleNode() {
    }

    public DoubleNode(Object d) {
        data = d;
        next = null;
    }

    public DoubleNode(DoubleNode prev, Object d, DoubleNode nxt) {
        previous = prev;
        data = d;
        next = nxt;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void finalize() {
        try{
            super.finalize();
        } catch (Throwable t) {
            Logger.getLogger(DoubleNode.class.getName()).log(Level.SEVERE, null, t);
        }
    }

    @Override
    public String toString() {
        return data.toString();
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public DoubleNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode previous) {
        this.previous = previous;
    }

}