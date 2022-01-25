package MENU;

import EXCEPCION.MiExcepcion;
import SERVICIOS.FabricanteService;
import SERVICIOS.ProductoService;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Scanner leer;
    private ProductoService productoService;
    private FabricanteService fabricanteService;
    int respuesta = 0;

    public Menu() {
        leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        productoService = new ProductoService();
        fabricanteService = new FabricanteService();
        respuesta = 0;
    }

    public void menuPrincipal() {
        do {
            try {
                System.out.println("ELIJA UNA OPCIÓN");
                System.out.println("1. EJERCICIO A)");
                System.out.println("2. EJERCICIO B)");
                System.out.println("3. EJERCICIO C)");
                System.out.println("4. EJERCICIO D)");
                System.out.println("5. EJERCICIO E)");
                System.out.println("6. EJERCICIO F)");
                System.out.println("7. EJERCICIO G");
                System.out.println("8. EJERCICIO H");
                System.out.println("9. SALIR");

                respuesta = leer.nextInt();

                switch (respuesta) {
                    case 1:
                        productoService.ejercicioA();
                        break;
                    case 2:
                        productoService.ejercicioB();
                        break;
                    case 3:
                        productoService.ejercicioC();
                        break;
                    case 4:
                        productoService.ejercicioD();
                        break;
                    case 5:
                        productoService.ejercicioE();
                        break;
                    case 6:
                        crearProducto();
                        break;
                    case 7:
                        fabricanteService.crearFabricante(leer.nextInt(), leer.next());
                        break;
                    case 8:
                        modificarProducto();
                        break;
                    case 9:
                        System.out.println("*** SESIÓN FINALIZADA ***");
                        break;
                    default:
                        System.out.println("LA OPCIÓN INGRESADA ES INVÁLIDA");
                }
            } catch (InputMismatchException e) {
                System.out.println("NO SE ADMITEN CARACTERES");
                leer.next();
            } catch (MiExcepcion e) {
                System.out.println(e.getMessage());
            }
        } while (respuesta != 5);
    }

    public void crearProducto() {
        try {
            System.out.println("INGRESE CODIGO: ");
            Integer codigo = leer.nextInt();

            System.out.println("INGRESE NOMBRE: ");
            String nombre = leer.next();

            System.out.println("INGRESE PRECIO: ");
            Double precio = leer.nextDouble();

            System.out.println("INGRESE EL CODIGO_FABRICANTE");
            Integer codigo_fabricante = leer.nextInt();

            productoService.crearProducto(codigo, nombre, precio, codigo_fabricante);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
        }
    }

    public void modificarProducto() {
        try {

            System.out.println("INGRESE NOMBRE: ");
            String nombre = leer.next();

            System.out.println("INGRESE CODIGO: ");
            Integer codigo = leer.nextInt();

            System.out.println("INGRESE PRECIO: ");
            Double precio = leer.nextDouble();

            System.out.println("INGRESE EL CODIGO_FABRICANTE");
            Integer codigo_fabricante = leer.nextInt();

            productoService.modificarProducto(codigo, nombre, precio, codigo_fabricante);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
        }
    }
}
