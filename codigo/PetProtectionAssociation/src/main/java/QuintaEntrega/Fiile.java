package QuintaEntrega;
import java.io.Serializable;
import javax.swing.JOptionPane;

import PrimeraEntrega.Vaccine;
import TerceraEntrega.DoubleList;

public class Fiile implements Serializable {
    private Object[] file;
    private int nElements;

    public Fiile() {
        nElements = 0;
        file = Sizing(nElements);
    }

    private Object[] Sizing(int nElements) {
        try {
            return new Vaccine[nElements];
        } catch (OutOfMemoryError e) {
            System.out.println(e.toString());
            return file;
        }
    }

    public Object VaccineLocation(int i) {
        if (i >= 0 && i < nElements) {
            return file[i];
        } else {
            System.out.println("No hay empleado en esa posicion");
            return null;
        }
    }

    public int Length() {
        return file.length;
    }

    public void Add(Object vaccine) {
        Object[] listCopy;
        listCopy = file;
        nElements = listCopy.length;
        file = Sizing(nElements + 1);
        for (int i = 0; i < nElements; i++) {
            file[i] = listCopy[i];
        }
        file[nElements] = vaccine;
        nElements++;
    }

    public boolean Remove(int code) {
        Object[] listCopy;
        int location = Search(code);
        if (location != -1) {
            file[location] = null;
            listCopy = file;
            if (listCopy.length != 0) {

                nElements = listCopy.length;
                file = Sizing(nElements - 1);
                int j = 0;
                for (int i = 0; i < nElements; i++) {
                    if (listCopy[i] != null) {
                        file[j] = listCopy[i];
                        j = j + 1;
                    }
                }
                nElements--;
                return true;
            }
        }
        return false;
    }

    public int Search(int code) {
        int location = -1;
        for (int i = 0; i < nElements; i++) {
            if (((Vaccine) file[i]).getCode() == code) {
                location = i;
            }
        }
        return location;
    }

    public String ShowAll() {
        String text = "";
        if (nElements == 0) {
            System.out.println("**** A R C H I V O   V A C I O *****");
        } else {
            for (int i = 0; i < nElements; i++) {
                text = text + "  " + file[i].toString() + "\n";
            }
        }
        return text;
    }

    public boolean Change(int code) {
        boolean sw = false;
        int resp;
        Vaccine vaccine = new Vaccine();
        Object ovaccine;
        int location = -1;
        location = Search(code);
        if (location != -1) {
            ovaccine = VaccineLocation(location);
            ovaccine = vaccine.Edit(ovaccine);
            resp = JOptionPane.showConfirmDialog(null, "¿Guardar los cambios?", "Actualizando",
                    JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                Replace(ovaccine);
                sw = true;
                JOptionPane.showMessageDialog(null, "Se guardaron los cambios satisfactoriamente");
            } else
                JOptionPane.showMessageDialog(null, "NO se grabaron los cambios");

        }
        return sw;
    }

    public void Replace(Object ovaccine) {
        Object[] listCopy;
        listCopy = file;
        nElements = listCopy.length;
        file = Sizing(nElements);
        for (int i = 0; i < nElements; i++) {
            if (((Vaccine) listCopy[i]).getCode() == ((Vaccine) ovaccine).getCode()) {
                file[i] = ovaccine;
            } else {
                file[i] = listCopy[i];
            }
        }
    }

    public DoubleList CopyListFile(DoubleList DList) {
        if (nElements == 0) {
            System.out.println("**** A R C H I V O   V A C I O *****");
        } else {
            for (int i = 0; i < nElements; i++) {
                DList.CreateNodeByEnd(file[i]);
            }
        }
        return DList;
    }
}
