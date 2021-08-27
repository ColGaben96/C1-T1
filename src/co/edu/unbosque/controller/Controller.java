package co.edu.unbosque.controller;

import co.edu.unbosque.model.Celuventas;
import co.edu.unbosque.model.exception.AlreadyExistsException;
import co.edu.unbosque.model.exception.NotFoundException;
import co.edu.unbosque.model.persistence.ModeloDTO;
import co.edu.unbosque.model.persistence.utils.Condicion;

import java.io.IOException;
import java.util.Date;
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
                case "2" -> celulares();
                case "3" -> marcas();
                case "4" -> modelos();
                case "5" -> regiones();
            }
        }
    }

    public void modelos() {
        System.out.println("""
                0) Volver
                1) Añadir un modelo
                2) Listar todos los modelos
                3) Buscar modelos
                4) Editar un modelo
                5) Eliminar un modelo""");
        System.out.print("Ingresa una opción: ");
        var opcion = sc.next();
        switch (opcion) {
            case "0" -> System.out.println();
            case "1" -> anadirModelo();
            case "2" -> listarModelos();
            case "3" -> System.out.println();
            case "4" -> {
                System.out.println("""
                        /!\\ ¡ALERTA!   /!\\
                        
                        Al editar un modelo es posible que se vean afectados uno o más celulares ligados a este. Solamente
                        realice esta operación si está completamente seguro.""");
                System.out.print("¿Desea Continuar? [si/no]: ");
                var confirmacion = sc.next();
                if (confirmacion.equals("si") || confirmacion.equals("no") || confirmacion.equals("s") || confirmacion.equals("n")) {

                }
            }
            case "5" -> {
                System.out.println("""
                        /!\\ ¡ALERTA!   /!\\
                        
                        Al eliminar un modelo es posible que elimine uno o más celulares ligados a este. Solamente
                        realice esta operación si está completamente seguro.""");
                System.out.print("¿Desea Continuar? [si/no]: ");
                var confirmacion = sc.next();
                if (confirmacion.equals("si") || confirmacion.equals("no") || confirmacion.equals("s") || confirmacion.equals("n")) {

                }
            }
        }
    }

    public void marcas() {
        System.out.println("""
                0) Volver
                1) Añadir una marca
                2) Listar todas las marcas
                3) Buscar marcas
                4) Editar una marca
                5) Eliminar una marca""");
        System.out.print("Ingresa una opción: ");
        var opcion = sc.next();
        switch (opcion) {
            case "0" -> System.out.println();
            case "1" -> anadirMarca();
            case "2" -> listarMarcas();
            case "3" -> System.out.println();
            case "4" -> {
                System.out.println("""
                        /!\\ ¡ALERTA!   /!\\
                        
                        Al editar un modelo es posible que se vean afectados uno o más celulares ligados a este. Solamente realice esta operación si está completamente seguro.""");
                System.out.print("¿Desea Continuar? [si/no]: ");
                var confirmacion = sc.next();
                if (confirmacion.equals("si") || confirmacion.equals("s")) {

                }
            }
            case "5" -> {
                System.out.println("""
                        /!\\ ¡ALERTA!   /!\\
                        
                        Al eliminar un modelo es posible que elimine uno o más celulares ligados a este. Solamente realice esta operación si está completamente seguro.""");
                System.out.print("¿Desea Continuar? [si/no]: ");
                var confirmacion = sc.next();
                if (confirmacion.equals("si") || confirmacion.equals("s")) {

                }
            }
        }
    }

    public void celulares() {
        System.out.println("""
                0) Volver
                1) Añadir un celular
                2) Listar todos los celulares
                3) Buscar celulares
                4) Editar un celular
                5) Eliminar un celular""");
        System.out.print("Ingresa una opción: ");
        var opcion = sc.next();
        switch (opcion) {
            case "0" -> System.out.println();
            case "1" -> anadirCelular();
            case "2" -> listarCelulares();
            case "3" -> System.out.println();
            case "4" -> {

            }
            case "5" -> {

            }
        }
    }

    public void regiones() {
        System.out.println("""
                0) Volver
                1) Añadir una región
                2) Listar todas las regiones
                3) Buscar regiones
                4) Editar una región
                5) Eliminar una región""");
        System.out.print("Ingresa una opción: ");
        var opcion = sc.next();
        switch (opcion) {
            case "0" -> System.out.println();
            case "1" -> anadirRegion();
            case "2" -> listarRegiones();
            case "3" -> System.out.println();
            case "4" -> {
                System.out.println("""
                        /!\\ ¡ALERTA!   /!\\
                        
                        Al editar una región es posible que se vea afectada una gran parte de los celulares registrados. Solamente realice esta operación si está completamente seguro.""");
                System.out.print("¿Desea Continuar? [si/no]: ");
                var confirmacion = sc.next();
                if (confirmacion.equals("si") || confirmacion.equals("s")) {

                }
            }
            case "5" -> {
                System.out.println("""
                        /!\\ ¡ALERTA!   /!\\
                        
                        Al eliminar una región es posible que elimine una gran parte de los celulares registrados. Solamente realice esta operación si está completamente seguro.""");
                System.out.print("¿Desea Continuar? [si/no]: ");
                var confirmacion = sc.next();
                if (confirmacion.equals("si") || confirmacion.equals("s")) {

                }
            }
        }
    }

    public void ayuda() {
        System.out.println("""
                0 - Salir de esta aplicación
                1 - Mostrar esta ayuda
                2 - Operaciones con celulares
                3 - Operaciones con marcas
                4 - Operaciones con modelos
                5 - Operaciones con regiones""");
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
        var referencia = new Object();
        if (modelos.size() == 0) {
            anadirModelo();
        } else {
            System.out.println("Selecciona los siguientes modelos del celular a registrar: ");
            for (int i = 0; i < modelos.size(); i++) {
                System.out.print((i+1)+") "+modelos.get(i).getMarca().getNombre()+" "+modelos.get(i).getReferencia()
                        +"\n");
            }
            System.out.println(modelos.size()+1+") Añadir un modelo nuevo");
            System.out.print("Ingresa una opción: ");
            opcion = sc.next();
            if (Integer.parseInt(opcion) == modelos.size()+1) {
                anadirModelo();
            }
            for (int i = 0; i < modelos.size(); i++) {
                referencia = modelos.get(Integer.parseInt(opcion)-1);
            }
            System.out.print("Ingresa el SKU de inventario: ");
            var sku = sc.nextLong();
            System.out.print("Ingresa el IMEI del equipo: ");
            var imei = sc.nextLong();
            System.out.println("Ingresa la condición del equipo: ");
            System.out.println("1) "+Condicion.NUEVO+"\n" +
                    "2) "+Condicion.REACONDICIONADO+"\n" +
                    "3) "+Condicion.USADO+"\n" +
                    "4) "+Condicion.DEFECTUOSO+"\n" +
                    "5) "+Condicion.ALTERADO);
            System.out.print("Ingresa una opción: ");
            var condicion = sc.next();
            switch (condicion) {
                default -> {
                    System.out.println("Opción Inválida");
                    anadirCelular();
                }
                case "1" -> condicion = Condicion.NUEVO.toString();
                case "2" -> condicion = Condicion.REACONDICIONADO.toString();
                case "3" -> condicion = Condicion.USADO.toString();
                case "4" -> condicion = Condicion.DEFECTUOSO.toString();
                case "5" -> condicion = Condicion.ALTERADO.toString();
            }
            try {
                modelo.getCelular().save(sku, imei, (ModeloDTO) referencia, new Date(), null,
                        Condicion.valueOf(condicion));
            } catch (AlreadyExistsException | IOException e) {
                System.out.println("El celular que intentas agregar "+e.getMessage());
            }
        }
    }

    public void anadirModelo() {
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
        var marcas = modelo.getMarca().findAll();
        System.out.println("""
                |Marca|Región|""");
        for (int i = 0; i < marcas.size(); i++) {
            System.out.print("|"+marcas.get(i).getNombre()+"|"+marcas.get(i).getRegion().getNombre()+"|\n");
        }
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
        var celulares = modelo.getCelular().findAll();
        System.out.println("""
                |Marca|Referencia|SKU|IMEI|Condición|Fecha de Ingreso""");
        for (int i = 0; i < celulares.size(); i++) {
            System.out.print("|"+celulares.get(i).getModelo().getMarca().getNombre() +
                    "|"+celulares.get(i).getModelo().getReferencia() +
                    "|"+celulares.get(i).getSku() +
                    "|"+celulares.get(i).getCondicion() +
                    "|"+celulares.get(i).getFechaIngreso()+"\n");
        }
    }
}

class Launcher {
    public static void main(String[] args) {
        Controller c = new Controller();
        c.consola();
    }
}
