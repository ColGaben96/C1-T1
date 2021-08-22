package co.edu.unbosque.model;

import co.edu.unbosque.model.exception.AlreadyExistsException;
import co.edu.unbosque.model.exception.NotFoundException;
import co.edu.unbosque.model.persistence.MarcaDTO;
import co.edu.unbosque.model.persistence.ModeloDTO;
import co.edu.unbosque.model.persistence.utils.FileMaker;

import java.io.IOException;
import java.util.ArrayList;

public class ModeloDAO {

    private ArrayList<ModeloDTO> modelos = new ArrayList<>();

    public ModeloDAO() {
        try {
            var modelosRestored = new FileMaker().leer("celulares");
            this.modelos = (ArrayList<ModeloDTO>) modelosRestored;
        } catch (ClassNotFoundException | IOException e) {
            //TODO: Poner algo aqui
        }
    }

    public ArrayList<ModeloDTO> findAll() {
        return modelos;
    }

    public void save(String referencia, MarcaDTO marca) throws AlreadyExistsException, IOException {
        var modelo = new ModeloDTO(referencia, marca);
        for (ModeloDTO busqueda : modelos) {
            if (busqueda.getReferencia().equals(modelo.getReferencia())) {
                throw new AlreadyExistsException();
            }
        }
        this.modelos.add(modelo);
        new FileMaker().escribir(modelos, "modelos");

    }

    public void delete() {

    }

    public ArrayList<ModeloDTO> findByName(String referencia) {
        var encontrados = new ArrayList<ModeloDTO>();
        for (ModeloDTO busqueda : modelos) {
            if (busqueda.getReferencia().contains(referencia)) {
                encontrados.add(busqueda);
            }
        }
        return encontrados;
    }

    public ModeloDTO findByExactName(String referencia) throws NotFoundException {
        for (ModeloDTO busqueda : modelos) {
            if (busqueda.getReferencia().equals(referencia)) {
                return busqueda;
            }
        }
        throw new NotFoundException();
    }
}
