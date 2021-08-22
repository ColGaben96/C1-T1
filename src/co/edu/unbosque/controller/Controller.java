package co.edu.unbosque.controller;

import co.edu.unbosque.model.Celuventas;
import co.edu.unbosque.model.exception.AlreadyExistsException;
import co.edu.unbosque.model.exception.NotFoundException;

import java.io.IOException;

public class Controller {

    private Celuventas modelo = new Celuventas();

    public void consola() {
        try {
            modelo.getRegion().save(1, "Norteamérica");
            modelo.getMarca().save("Apple",
                    modelo.getRegion().findByID(1));
            modelo.getMarca().save("Google",
                    modelo.getRegion().findByID(1));
        } catch (AlreadyExistsException | IOException | NotFoundException e) {
            e.printStackTrace();
        }
        var listas = modelo.getRegion().findByName("a");
        for (int i = 0; i < listas.size(); i++) {
            System.out.println(listas.get(i).getNombre());
        }
    }
}

class Launcher {
    public static void main(String[] args) {
        Controller c = new Controller();
        c.consola();
    }
}
