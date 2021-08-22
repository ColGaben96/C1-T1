package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.persistence.utils.Condicion;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Gabriel Blanco
 * @version 1.0
 * <h1>Descripción</h1>
 * Esta clase es para definir la entidad Celular. Aquí se toma referencia la marca, el modelo, el imei,
 * la fecha de ingreso a la tienda y la fecha de venta.
 */
public class CelularDTO implements Serializable {
    /**
     * Este atributo es para identificar el serial de la clase al momento de ser leído por FileMaker.
     */
    @Serial
    private static final long serialVersionUID = 107568060101L;
    /**
     * Este atributo es para identificar el celular mediante el identificador de inventario del equipo.
     */
    private long sku;
    /**
     * Este atributo es para identificar el celular mediante la identificación de la antena del equipo.
     */
    private long imei;
    /**
     * Este atributo es para identificar el celular mediante el modelo de la marca del equipo.
     */
    private ModeloDTO modelo;
    /**
     * Este atributo es para identificar la fecha de ingreso a la tienda del celular.
     */
    private Date fechaIngreso;
    /**
     * Este atributo es para identificar la fecha de venta del celular. Puede ser nula, puesto que puede presentarse aún
     * en venta.
     */
    private Date fechaVenta;
    /**
     * Este atributo es para identificar la condición del celular.
     */
    private Condicion condicion;

    /**
     * @author Gabriel Blanco
     * <h1>Descripción</h1>
     * Método constructor para crear objetos de tipo Celular.
     * @param sku
     * @param imei
     * @param modelo
     * @param fechaIngreso
     * @param fechaVenta
     * @param condicion
     *
     */
    public CelularDTO(Long sku, Long imei, ModeloDTO modelo, Date fechaIngreso, Date fechaVenta, Condicion condicion) {
        this.sku = sku;
        this.imei = imei;
        this.modelo = modelo;
        this.fechaIngreso = fechaIngreso;
        this.fechaVenta = fechaVenta;
        this.condicion = condicion;
    }

    public long getSku() {
        return sku;
    }

    public void setSku(long sku) {
        this.sku = sku;
    }

    public long getImei() {
        return imei;
    }

    public void setImei(long imei) {
        this.imei = imei;
    }

    public ModeloDTO getModelo() {
        return modelo;
    }

    public void setModelo(ModeloDTO modelo) {
        this.modelo = modelo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Condicion getCondicion() {
        return condicion;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }
}
