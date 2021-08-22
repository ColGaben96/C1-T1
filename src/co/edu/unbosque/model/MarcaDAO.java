package co.edu.unbosque.model;

import co.edu.unbosque.model.exception.AlreadyExistsException;
import co.edu.unbosque.model.exception.NotFoundException;
import co.edu.unbosque.model.persistence.MarcaDTO;
import co.edu.unbosque.model.persistence.RegionDTO;
import co.edu.unbosque.model.persistence.utils.FileMaker;

import java.io.IOException;
import java.util.ArrayList;

public class MarcaDAO {

    private ArrayList<MarcaDTO> marcas = new ArrayList<>();

    public MarcaDAO() {
        try {
            var marcasRestored = new FileMaker().leer("marcas");
            this.marcas = (ArrayList<MarcaDTO>) marcasRestored;
        } catch (IOException | ClassNotFoundException e) {
            //TODO: Poner algo aqui
        }
    }

    public ArrayList<MarcaDTO> findAll() {
        return marcas;
    }

    public void save(String nombre, RegionDTO region) throws AlreadyExistsException, IOException {
        var marca = new MarcaDTO(nombre, region);
        for (MarcaDTO busqueda : marcas) {
            if (busqueda.getNombre().equals(marca.getNombre())) {
                throw new AlreadyExistsException();
            }
        }
        this.marcas.add(marca);
        new FileMaker().escribir(marcas, "marcas");
    }

    public void delete(MarcaDTO marca) throws IOException {
        this.marcas.remove(marca);
        new FileMaker().escribir(marcas, "marcas");
    }

    public ArrayList<MarcaDTO> findByName(String nombre) {
        var encontrados = new ArrayList<MarcaDTO>();
        for (MarcaDTO busqueda : marcas) {
            if (busqueda.getNombre().contains(nombre)) {
                encontrados.add(busqueda);
            }
        }
        return encontrados;
    }

    public MarcaDTO findByExactName(String nombre) throws NotFoundException {
        for (MarcaDTO busqueda : marcas) {
            if (busqueda.getNombre().equals(nombre)) {
                return busqueda;
            }
        }
        throw new NotFoundException();
    }
}
