package co.edu.unbosque.model.persistence;

import java.io.Serial;
import java.io.Serializable;
/**
 * @author Gabriel Blanco
 * @version 1.0
 * <h1>Descripción</h1>
 * Esta clase es para definir la entidad Región. Aquí se toma como referencia un ID y un nombre.
 */
public class RegionDTO implements Serializable {
    /**
     * Este atributo es para identificar el serial de la clase al momento de ser leído por FileMaker.
     */
    @Serial
    private static final long serialVersionUID = 107568060104L;
    /**
     * Este atributo es para identificar el ID de la región.
     */
    private int id;
    /**
     * Este atributo es para identificar el nombre de la región.
     */
    private String nombre;

    /**
     * @param id
     * @param nombre
     * @author Gabriel Blanco
     * <h1>Descripción</h1>
     * Método constructor para definir objetos de tipo Región.
     */
    public RegionDTO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
