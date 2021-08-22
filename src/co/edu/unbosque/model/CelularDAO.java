package co.edu.unbosque.model;

import co.edu.unbosque.model.exception.AlreadyExistsException;
import co.edu.unbosque.model.persistence.CelularDTO;
import co.edu.unbosque.model.persistence.RegionDTO;
import co.edu.unbosque.model.persistence.utils.FileMaker;

import java.io.IOException;
import java.util.ArrayList;

public class CelularDAO {

    private ArrayList<CelularDTO> celulares = new ArrayList<>();

    public CelularDAO() {
        try {
            var celularesRestored = new FileMaker().leer("celulares");
            this.celulares.getClass().cast(celularesRestored);
        } catch (IOException | ClassNotFoundException e) {
            //TODO: Poner algo aqui
        }
    }

    public ArrayList<CelularDTO> findAll() {
        return celulares;
    }

    public void save(CelularDTO celular) throws AlreadyExistsException, IOException {
        for (CelularDTO busqueda : celulares) {
            if(busqueda.getImei() == celular.getImei()) {
                throw new AlreadyExistsException();
            }
        }
        celulares.add(celular);
        new FileMaker().escribir(findAll(), "celulares");
    }

    public void delete(CelularDTO celular) throws IOException {
        this.celulares.remove(celular);
        new FileMaker().escribir(findAll(), "celulares");
    }
}
