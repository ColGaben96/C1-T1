package co.edu.unbosque.model;

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

    public void findAll() {

    }

    public void save() {

    }

    public void delete() {

    }

    public void findBy() {

    }
}
