package co.edu.unbosque.model.persistence;

import java.io.Serial;
import java.io.Serializable;
/**
 * @author Gabriel Blanco
 * @version 1.0
 * <h1>Descripción</h1>
 * Esta clase es para definir la entidad Modelo. Aquí se toma referencia la marca y la referencia.
 */
public class ModeloDTO implements Serializable {
    /**
     * Este atributo es para identificar el serial de la clase al momento de ser leído por FileMaker.
     */
    @Serial
    private static final long serialVersionUID = 107568060103L;
    /**
     * Este atributo es para identificar la referencia del modelo.
     */
    private String referencia;
    /**
     * Este atributo es para identificar la marca del modelo.
     */
    private MarcaDTO marca;

    /**
     *
     * @param referencia
     * @param marca
     * @author Gabriel Blanco
     * <h1>Descripción</h1>
     * Método constructor para definir objetos de tipo Modelo.
     */
    public ModeloDTO(String referencia, MarcaDTO marca) {
        this.referencia = referencia;
        this.marca = marca;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public MarcaDTO getMarca() {
        return marca;
    }

    public void setMarca(MarcaDTO marca) {
        this.marca = marca;
    }
}
