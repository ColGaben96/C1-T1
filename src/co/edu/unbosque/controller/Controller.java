package co.edu.unbosque.controller;

import co.edu.unbosque.model.Celuventas;
import co.edu.unbosque.model.exception.AlreadyExistsException;
import co.edu.unbosque.model.exception.NotFoundException;
import co.edu.unbosque.model.persistence.utils.Condicion;

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
            modelo.getModelo().save("iPhone 11 Pro",
                    modelo.getMarca().findByExactName("Apple"));
            modelo.getCelular().save(1235L, 4323L,
                    modelo.getModelo().findByExactName("iPhone 11 Pro"),
                    null,
                    null, Condicion.REACONDICIONADO);
            modelo.getCelular().save(1235L, 4324L,
                    modelo.getModelo().findByExactName("iPhone 11 Pro"),
                    null,
                    null, Condicion.USADO);
        } catch (AlreadyExistsException | IOException | NotFoundException e) {
            e.printStackTrace();
        }
        var listas = modelo.getCelular().findAll();
        for (int i = 0; i < listas.size(); i++) {
            System.out.println(listas.get(i).getModelo().getMarca().getNombre()+" "+listas.get(i).getModelo().getReferencia()+" "+listas.get(i).getCondicion());
        }
    }

    public void consola2() {
        var listas = modelo.getCelular().findAll();
        for (int i = 0; i < listas.size(); i++) {
            System.out.println(listas.get(i).getModelo().getMarca().getNombre()+" "+listas.get(i).getModelo().getReferencia()+" "+listas.get(i).getCondicion());
        }
    }
}

class Launcher {
    public static void main(String[] args) {
        Controller c = new Controller();
        c.consola();
    }
}
