package co.edu.unbosque.model.persistence;

import java.io.Serial;
import java.io.Serializable;
/**
 * @author Gabriel Blanco
 * @version 1.0
 * <h1>Descripción</h1>
 * Esta clase es para definir la entidad Marca. Aquí se toma como referencia el nombre, y la región del manufacturador.
 */
public class MarcaDTO implements Serializable {
    /**
     * Este atributo es para identificar el serial de la clase al momento de ser leído por FileMaker.
     */
    @Serial
    private static final long serialVersionUID = 107568060102L;
    /**
     * Este atributo es para identificar el nombre de la marca.
     */
    private String nombre;
    /**
     * Este atributo es para identificar la región de la marca.
     */
    private RegionDTO region;

    /**
     *
     * @param nombre
     * @param region
     * @author Gabriel Blanco
     * <h1>Descripción</h1>
     * Método constructor para definir objetos de tipo Marca.
     */
    public MarcaDTO(String nombre, RegionDTO region) {
        this.nombre = nombre;
        this.region = region;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public RegionDTO getRegion() {
        return region;
    }

    public void setRegion(RegionDTO region) {
        this.region = region;
    }
}
