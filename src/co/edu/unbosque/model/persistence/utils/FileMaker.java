package co.edu.unbosque.model.persistence.utils;

import java.io.*;
import java.util.ArrayList;

public class FileMaker {

    public void escribir(Object obj, String nombre) throws IOException {
        File f = new File(nombre+".celuventas");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        fos.close();
    }

    public Object leer(String nombre) throws IOException, ClassNotFoundException {
        Object obj = null;
        File f = new File(nombre+".celuventas");
        FileInputStream fis = new FileInputStream(f);
        try {
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = ois.readObject();
        } catch (EOFException e) {
            fis.close();
        }
        return obj;
    }
}
