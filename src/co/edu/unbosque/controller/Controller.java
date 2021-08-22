package co.edu.unbosque.controller;

import co.edu.unbosque.model.Celuventas;
import co.edu.unbosque.model.exception.AlreadyExistsException;
import co.edu.unbosque.model.exception.NotFoundException;
import co.edu.unbosque.model.persistence.utils.Condicion;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class Controller {

    private Celuventas modelo = new Celuventas();
    private Scanner sc = new Scanner(System.in);

    public void consola() {
        System.out.println("""
                --------------------------------------------------------
                                   Portal Celuventas
                                 V1.0 - Gabriel Blanco
                                 Para ayuda ingresar '1'.
                --------------------------------------------------------
                """);
        boolean active = true;
        while(active) {
            inventariar();
            System.out.print("\nIngresa una opción: ");
            var opcion = sc.next();
            switch (opcion) {
                default -> System.out.println("Opción Inválida");
                case "0" -> active = false;
                case "1" -> ayuda();
                case "2" -> anadirRegion();
                case "3" -> anadirMarca();
                case "4" -> anadirModelo();
                case "5" -> anadirCelular();
            }
        }
    }

    public void ayuda() {
        System.out.println("""
                0 - Salir de esta aplicación
                1 - Mostrar esta ayuda""");
    }

    public void inventariar() {
        var celulares = modelo.getCelular().findAll().size();
        var marcas = modelo.getMarca().findAll().size();
        var modelos = modelo.getModelo().findAll().size();
        System.out.println("\n"+celulares+" celulares registrados\n" +
                +marcas+" marcas registradas\n" +
                +modelos+" modelos registrados\n");
    }

    public void anadirCelular() {
        var modelos = modelo.getModelo().findAll();
        var opcion = "";
        if (modelos.size() == 0) {
            anadirModelo();
        } else {

        }
    }

    public void anadirModelo() { //delete
        var marcas = modelo.getMarca().findAll();
        var opcion = "";
        var nombre = "";
        if (marcas.size() == 0) {
            anadirMarca();
        } else {
            System.out.println("Selecciona las siguientes marcas del modelo a registrar: ");
            for (int i = 0; i < marcas.size(); i++) {
                System.out.print((i+1)+") "+marcas.get(i).getNombre()+"\n");
            }
            System.out.println(marcas.size()+1+") Añadir una nueva marca");
            System.out.print("Ingresa una opción: ");
            opcion = sc.next();
            if (Integer.parseInt(opcion) == marcas.size()+1) {
                anadirMarca();
            }
            for (int i = 0; i < marcas.size(); i++) {
                nombre = marcas.get(Integer.parseInt(opcion)-1).getNombre();
            }
        }
        System.out.print("Ingresa la referencia del modelo a registrar: ");
        var referencia = sc.next();
        try {
            modelo.getModelo().save(referencia,
                    modelo.getMarca().findByExactName(nombre));
        } catch (AlreadyExistsException | IOException e) {
            System.out.println("El modelo que intentas agregar "+e.getMessage());
        } catch (NotFoundException e) {
            System.out.println("Opción Inválida");
            anadirModelo();
        }
    }

    public void anadirMarca() {
        var regiones = modelo.getRegion().findAll();
        var opcion = "";
        if (regiones.size() == 0) {
            anadirRegion();
        } else {
            System.out.println("Selecciona las siguientes regiones de la marca a registrar: ");
            for (int i = 0; i < regiones.size(); i++) {
                System.out.print(regiones.get(i).getId()+") "+regiones.get(i).getNombre()+"\n");
            }
            System.out.println((regiones.size()+1)+") Añadir una nueva región");
            System.out.print("Ingresa una opción: ");
            opcion = sc.next();
            if (Integer.parseInt(opcion) == regiones.size()+1) {
                anadirRegion();
            }
        }
        System.out.print("Ingresa el nombre de la marca a registrar: ");
        var nombre = sc.next();
        try {
            modelo.getMarca().save(nombre, modelo.getRegion().findByID(Integer.parseInt(opcion)));
        } catch (AlreadyExistsException | IOException e) {
            System.out.println("La marca que estás intentando agregar "+e.getMessage());
        } catch (NotFoundException e) {
            System.out.println("Opción Inválida");
            anadirMarca();
        }

    }

    public void anadirRegion() {
        System.out.print("Ingresa el nombre de la región: ");
        var nombre = sc.next();
        var id = modelo.getRegion().findAll().size() + 1;
        try {
            modelo.getRegion().save(id, nombre);
        } catch (AlreadyExistsException | IOException e) {
            System.out.println("La región que estás intentando agregar "+e.getMessage());
        }
    }

    public void listarMarcas() {

    }

    public void listarRegiones() {
        var regiones = modelo.getRegion().findAll();
        System.out.println("""
                |Código ID|Nombre|""");
        for (int i = 0; i < regiones.size(); i++) {
            System.out.print("|"+regiones.get(i).getId()+"|"+regiones.get(i).getNombre()+"|\n");
        }
    }

    public void listarModelos() {
        var modelos = modelo.getModelo().findAll();
        System.out.println("""
                |Marca|Referencia|""");
        for (int i = 0; i < modelos.size(); i++) {
            System.out.print("|"+modelos.get(i).getMarca().getNombre()+"|"+modelos.get(i).getReferencia()+"|\n");
        }
    }

    public void listarCelulares() {

    }
}

class Launcher {
    public static void main(String[] args) {
        Controller c = new Controller();
        c.consola();
    }
}
