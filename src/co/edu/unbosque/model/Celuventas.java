package co.edu.unbosque.model;

public class Celuventas {

    private CelularDAO celular = new CelularDAO();
    private MarcaDAO marca = new MarcaDAO();
    private ModeloDAO modelo = new ModeloDAO();
    private RegionDAO region = new RegionDAO();

    public CelularDAO getCelular() {
        return celular;
    }

    public MarcaDAO getMarca() {
        return marca;
    }

    public ModeloDAO getModelo() {
        return modelo;
    }

    public RegionDAO getRegion() {
        return region;
    }
}
