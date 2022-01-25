package SERVICIOS;

import ENTIDADES.Producto;
import EXCEPCION.MiExcepcion;
import PERSISTENCIA.ProductoDAO;
import java.util.List;

public class ProductoService {

    private ProductoDAO productoDAO;

    public ProductoService() {
        productoDAO = new ProductoDAO();
    }

    public void crearProducto(Integer codigo, String nombre, Double precio, Integer codigo_fabricante) throws MiExcepcion {
        try {
            // VALIDACIÓN
            if (codigo == null) {
                throw new MiExcepcion("DEBE INGRESAR UN CODIGO");
            }

            if (nombre == null | nombre.trim().isEmpty()) {
                throw new MiExcepcion("DEBE INGRESAR UN NOMBRE");
            }

            if (precio == null) {
                throw new MiExcepcion("DEBE INGRESAR UN PRECIO");
            }
            if (codigo_fabricante == null) {
                throw new MiExcepcion("DEBE INGRESAR UN CODIGO DE FABRICANTE");
            }

            Producto producto = new Producto();

            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigo_fabricante(codigo_fabricante);

            productoDAO.guardarProducto(producto);
        } catch (MiExcepcion e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }

    public void modificarProducto(Integer codigo, String nombre, Double precio, Integer codigo_fabricante) throws MiExcepcion {
        try {
            // VALIDACIÓN
            if (codigo == null) {
                throw new MiExcepcion("DEBE INGRESAR UN CODIGO");
            }

            if (nombre == null | nombre.trim().isEmpty()) {
                throw new MiExcepcion("DEBE INGRESAR UN NOMBRE");
            }

            if (precio == null) {
                throw new MiExcepcion("DEBE INGRESAR UN PRECIO");
            }
            if (codigo_fabricante == null) {
                throw new MiExcepcion("DEBE INGRESAR UN CODIGO_FABRICANTE");
            }

            Producto producto = productoDAO.buscarProductoPorNombre(nombre);

            if (nombre == null) {
                throw new MiExcepcion("EL NOMBRE NO ESTÁ ASOCIADO A NINGÚN USUARIO");
            }

            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigo_fabricante(codigo_fabricante);

            productoDAO.modificarProducto(producto);
        } catch (MiExcepcion e) {
            // e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }

    public void ejercicioA() throws MiExcepcion {
        try {
            List<Producto> productos = null;
            productos = productoDAO.obtenerProductos();

            if (productos.isEmpty()) {
                throw new MiExcepcion("NO EXISTEN PRODUCTOS");
            } else {
                System.out.println("*** LISTA DE PRODUCTOS ***");
                System.out.printf("%-20s%-15s%-15s\n", "CODIGO", "NOMBRE", "PRECIO", "CODIGO_FABRICANTE"); // FORMATO DE IMPRESIÓN
                for (Producto producto : productos) {
                    System.out.println(producto);
                }
                System.out.println();
            }
        } catch (MiExcepcion e) {
            //e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }

    public void ejercicioB() throws MiExcepcion {
        try {
            List<Producto> productos = null;
            productos = productoDAO.obtenerNombrePrecio();

            if (productos.isEmpty()) {
                throw new MiExcepcion("NO EXISTEN PRODUCTOS");
            } else {
                System.out.println("*** LISTA DE PRODUCTOS ***");
                System.out.printf("%-20s%-15s%-15s\n", "CODIGO", "NOMBRE", "PRECIO", "CODIGO_FABRICANTE"); // FORMATO DE IMPRESIÓN
                for (Producto producto : productos) {
                    System.out.println(producto);
                }
                System.out.println();
            }
        } catch (MiExcepcion e) {
            //e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }

    public void ejercicioC() throws MiExcepcion {
        try {
            List<Producto> productos = null;
            productos = productoDAO.obtenerTodo120202();

            if (productos.isEmpty()) {
                throw new MiExcepcion("NO EXISTEN PRODUCTOS");
            } else {
                System.out.println("*** LISTA DE PRODUCTOS ***");
                System.out.printf("%-20s%-15s%-15s\n", "CODIGO", "NOMBRE", "PRECIO", "CODIGO_FABRICANTE"); // FORMATO DE IMPRESIÓN
                for (Producto producto : productos) {
                    System.out.println(producto);
                }
                System.out.println();
            }
        } catch (MiExcepcion e) {
            //e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }

    public void ejercicioD() throws MiExcepcion {
        try {
            List<Producto> productos = null;
            productos = productoDAO.obtenerPortatiles();

            if (productos.isEmpty()) {
                throw new MiExcepcion("NO EXISTEN PRODUCTOS");
            } else {
                System.out.println("*** LISTA DE PRODUCTOS ***");
                System.out.printf("%-20s%-15s%-15s\n", "CODIGO", "NOMBRE", "PRECIO", "CODIGO_FABRICANTE"); // FORMATO DE IMPRESIÓN
                for (Producto producto : productos) {
                    System.out.println(producto);
                }
                System.out.println();
            }
        } catch (MiExcepcion e) {
            //e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }

    public void ejercicioE() throws MiExcepcion {
        try {
            List<Producto> productos = null;
            productos = productoDAO.obtenerMasBarato();

            if (productos.isEmpty()) {
                throw new MiExcepcion("NO EXISTEN PRODUCTOS");
            } else {
                System.out.println("*** LISTA DE PRODUCTOS ***");
                System.out.printf("%-20s%-15s%-15s\n", "CODIGO", "NOMBRE", "PRECIO", "CODIGO_FABRICANTE"); // FORMATO DE IMPRESIÓN
                for (Producto producto : productos) {
                    System.out.println(producto);
                }
                System.out.println();
            }
        } catch (MiExcepcion e) {
            //e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }
}
