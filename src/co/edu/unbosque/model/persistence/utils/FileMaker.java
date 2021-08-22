package co.edu.unbosque.model.persistence.utils;

import java.io.*;
import java.util.ArrayList;

public class FileMaker {

    public void escribir(Object obj, String nombre) throws IOException {
        File f = new File(nombre+".cer");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        fos.close();
    }

    public ArrayList<Object> leer(String nombre) throws IOException, ClassNotFoundException {
        var obj = new ArrayList<Object>();
        File f = new File(nombre+".cer");
        FileInputStream fis = new FileInputStream(f);
        try {
            ObjectInputStream ois = new ObjectInputStream(fis);
            var line = ois.readObject();
            while (line != null) {
                obj.add(line);
                line = ois.readObject();
            }
        } catch (EOFException e) {
            fis.close();
        }
        fis.close();
        return obj;
    }
}
