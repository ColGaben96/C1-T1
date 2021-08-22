package co.edu.unbosque.model;

import co.edu.unbosque.model.exception.AlreadyExistsException;
import co.edu.unbosque.model.exception.NotFoundException;
import co.edu.unbosque.model.persistence.RegionDTO;
import co.edu.unbosque.model.persistence.utils.FileMaker;

import java.io.IOException;
import java.util.ArrayList;

public class RegionDAO {

    private ArrayList<RegionDTO> regiones = new ArrayList<>();

    public RegionDAO() {
        try {
            var regionesRestored = new FileMaker().leer("regiones");
            this.regiones = (ArrayList<RegionDTO>) regionesRestored;
        } catch (IOException | ClassNotFoundException e) {
            //TODO: Poner algo aqui
        }
    }

    public ArrayList<RegionDTO> findAll() {
        return regiones;
    }

    public void save(int id, String nombre) throws AlreadyExistsException, IOException {
        var region = new RegionDTO(id, nombre);
        for (RegionDTO busqueda : regiones) {
            if (busqueda.getNombre().equals(region.getNombre())) {
                throw new AlreadyExistsException();
            }
        }
        this.regiones.add(region);
        new FileMaker().escribir(regiones, "regiones");
    }

    public void delete(RegionDTO region) {
        this.regiones.remove(region);
    }

    public RegionDTO findByID(int id) throws NotFoundException {
        for (RegionDTO busqueda : regiones) {
            if (busqueda.getId() == id) {
                return busqueda;
            }
        }
        throw new NotFoundException();
    }

    public ArrayList<RegionDTO> findByName(String nombre) {
        var encontrados = new ArrayList<RegionDTO>();
        for (RegionDTO busqueda : regiones) {
            if (busqueda.getNombre().contains(nombre)) {
                encontrados.add(busqueda);
            }
        }
        return encontrados;
    }
}
