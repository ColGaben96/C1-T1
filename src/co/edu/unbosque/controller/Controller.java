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
        inventariar();
        boolean active = true;
        while(active) {
            System.out.print("\nIngresa una opción: ");
            var opcion = sc.next();
            switch (opcion) {
                default -> System.out.println("Opción Inválida");
                case "0" -> active = false;
                case "1" -> ayuda();
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

    }

    public void anadirModelo() {

    }

    public void anadirMarca() {

    }

    public void anadirRegion() {

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
