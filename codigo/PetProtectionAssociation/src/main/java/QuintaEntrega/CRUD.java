package QuintaEntrega;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.awt.HeadlessException;

import javax.swing.JOptionPane;

import PrimeraEntrega.Vaccine;
import SegundaEntrega.Validations;
import TerceraEntrega.DoubleList;

public class CRUD implements Serializable {
    private boolean changes = false;
    private String path = "D:\\Universidad\\2023-2\\ED\\proyecto\\Vacunas.txt";

    public Fiile Creation() {
        Fiile file = null;
        ObjectInputStream inputStream = null;
        try {
            File f = new File(path);
            if (!f.exists()) {
                file = new Fiile();
                JOptionPane.showMessageDialog(null, "*********** A R C H I V O  N U E V O *********");
            } else {
                inputStream = new ObjectInputStream(new FileInputStream(path));
                file = (Fiile) inputStream.readObject();
            }
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Error: " + e.toString());

        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
            }

        }
        return file;
    }

    public void Adding(Fiile file) {
        int location, code = 0;
        try {
            code = Validations.readInteger("Ingresa el código de la vacuna a agregar");
        } catch (HeadlessException | NumberFormatException e) {
        }
        location = file.Search(code);
        if (location == -1) {
            try {
                file.Add(new Vaccine().vaccineRegistry(code));
                changes = true;
            } catch (HeadlessException | NumberFormatException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "*********** R E G I S T R O   Y A   E X I S T E *********");
        }

    }

    public void AddingLeafs(Fiile file, DoubleList leafNodes) {
        try {
            do {
                file.Add(leafNodes.ReleaseFinal());
            } while (!leafNodes.isEmpty());
            changes = true;
        } catch (HeadlessException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void Remove(Fiile file) {
        int code = 0;
        boolean removed = false;// bandera o swiche para saber si ocurre o no el borrado
        try {

            code = Validations.readInteger("Ingrese el código de la mascota a Borrar:  ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        removed = file.Remove(code);// se recibe falso o verdadero de acuerdo si se hizo o no la accion
        if (removed == true)// si se elimina
        {
            JOptionPane.showMessageDialog(null,
                    "************* Registro eliminado del archivo*****************  " + code);
            changes = true;// cambios es la bandera o swiche que informa si aumenta o disminuye el vector
        } else if (file.Length() != 0)// archivo vector NO esta vacio
        {
            JOptionPane.showMessageDialog(null,
                    "************* Registro No se Encuentra en el archivo*****************" + code);
        } else // si esta vacio
        {
            JOptionPane.showMessageDialog(null, "************* A r c h i v o   v a c i o *****************");
        }
    }

    public void Search(Fiile file) {
        int location, code = 0;
        try {
            code = Validations.readInteger("Ingrese el código de la mascota a Consultar:  ");

        } catch (Exception e) {
            e.printStackTrace();
        }
        location = file.Search(code);
        if (location == -1) {
            if (file.Length() != 0) {
                JOptionPane.showMessageDialog(null,
                        "************* Registro No se Encuentra en el archivo***************** " + code);
            } else {
                JOptionPane.showMessageDialog(null, "************* A r c h i v o   v a c i o *****************");
            }
        } else {
            JOptionPane.showMessageDialog(null, "  " + file.VaccineLocation(location).toString());
        }
    }

    public void Write(Fiile file) {
        ObjectOutputStream oStream = null;
        try {
            if (changes == true) {
                oStream = new ObjectOutputStream(new FileOutputStream(path));
                oStream.writeObject(file);
            }
            file = null;
        } catch (IOException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                if (oStream != null) {
                    oStream.close();
                }
            } catch (IOException e) {
            }
        }
    }

    public void Update(Fiile file) {
        boolean location;
        int code = 0;
        try {
            code = Validations.readInteger("Ingrese el código para actualizar: ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        location = file.Change(code);
        if (location == true) {
            JOptionPane.showMessageDialog(null,
                    "************* Registro No se Encuentra en el archivo***************** " + code);
        } else {
            if (file.Length() != 0) {// si no hay registros
                JOptionPane.showMessageDialog(null, "************* A r c h i v o   v a c i o *****************");
            }
        }
    }
}
