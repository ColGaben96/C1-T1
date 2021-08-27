package co.edu.unbosque.model;

import co.edu.unbosque.model.exception.AlreadyExistsException;
import co.edu.unbosque.model.exception.NotFoundException;
import co.edu.unbosque.model.persistence.CelularDTO;
import co.edu.unbosque.model.persistence.ModeloDTO;
import co.edu.unbosque.model.persistence.utils.Condicion;
import co.edu.unbosque.model.persistence.utils.FileMaker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Gabriel Blanco
 * @version 1.0
 * <h1>Descripción</h1>
 *
 */
public class CelularDAO {

    private ArrayList<CelularDTO> celulares = new ArrayList<>();

    public CelularDAO() {
        try {
            var celularesRestored = new FileMaker().leer("celulares");
            this.celulares = (ArrayList<CelularDTO>) celularesRestored;
        } catch (IOException | ClassNotFoundException e) {
            //TODO: Poner algo aqui
        }
    }

    public ArrayList<CelularDTO> findAll() {
        return celulares;
    }

    public void save(Long sku, Long imei, ModeloDTO modelo, Date fechaIngreso, Date fechaVenta, Condicion condicion)
            throws AlreadyExistsException, IOException {
        var celular = new CelularDTO(sku, imei, modelo, fechaIngreso, fechaVenta, condicion);
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

    public CelularDTO findBySKU(long sku) throws NotFoundException {
        for (CelularDTO busqueda : celulares) {
            if (busqueda.getSku() == sku) {
                return busqueda;
            }
        }
        throw new NotFoundException();
    }

    public ArrayList<CelularDTO> findByCondition(Condicion condicion) {
        var encontrados = new ArrayList<CelularDTO>();
        for (CelularDTO busqueda : celulares) {
            if (busqueda.getCondicion() == condicion) {
                encontrados.add(busqueda);
            }
        }
        return encontrados;
    }

    public void update(CelularDTO objViejo, Long sku, Long imei, ModeloDTO modelo, Date fechaIngreso, Date fechaVenta, Condicion condicion) {
        var celular = new CelularDTO(sku, imei, modelo, fechaIngreso, fechaVenta, condicion);
        for (int i = 0; i < celulares.size(); i++) {
            if (celulares.get(i) == objViejo) {
                celulares.set(i, celular);
                break;
            }
        }
    }
}
