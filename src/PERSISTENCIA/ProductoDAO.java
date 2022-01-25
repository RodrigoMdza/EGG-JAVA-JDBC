package PERSISTENCIA;

import ENTIDADES.Producto;
import EXCEPCION.MiExcepcion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class ProductoDAO extends DAO {

    public void guardarProducto(Producto producto) throws MiExcepcion {
        try {
            if (producto == null) {
                throw new MiExcepcion("USUARIO INVÁLIDO");
            }

            // SENTENCIA SQL DE INSERCIÓN
            String sql = "INSERT INTO producto(codigo, nombre, precio, codigo_fabricante) "
                    + "VALUES('" + producto.getCodigo()
                    + "', '" + producto.getNombre() + "', '" + producto.getPrecio() + "', '" + producto.getCodigo_fabricante()
                    + "');";

            // SE MUESTRA LA CADENA RESULTANTE
            System.out.println(sql);
            System.out.println();

            insertarModificarEliminar(sql);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL GUARDAR USUARIO");
        }
    }

    public void modificarProducto(Producto producto) throws MiExcepcion {
        try {
            if (producto == null) {
                throw new MiExcepcion("USUARIO INVÁLIDO");
            }

            // SENTENCIA SQL DE MODIFICACIÓN (solo se modifica la sentencia de MySQL con 
            // respecto al otro metodo.
            String sql = "UPDATE producto SET codigo = '" + producto.getCodigo() + "', "
                    + "nombre = '" + producto.getNombre() + "' "
                    + "precio = '" + producto.getPrecio() + "' "
                    + "codigo_fabricante = '" + producto.getCodigo_fabricante() + "' "
                    + "WHERE nombre = '" + producto.getNombre() + "';";

            // SE MUESTRA LA CADENA RESULTANTE
            System.out.println(sql);
            System.out.println();

            insertarModificarEliminar(sql);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL MODIFICAR USUARIO");
        }
    }

    public Producto buscarProductoPorNombre(String nombre) throws MiExcepcion {
        try {
            // SENTENCIA SQL DE CONSULTA
            String sql = "SELECT * FROM producto WHERE nombre = '" + nombre + "';";

            consultarBase(sql);

            // HAGO NACER UN USUARIO EN NULO YA QUE ES EL QUE ME VA A TRAER EL RESULTADO
            Producto producto = null;

            // SI RESULTADO DE DAO CAPTA ALGA LO CAPTURA EN EL NEXT
            while (resultado.next()) {
                // NACE EL USUARIO
                producto = new Producto();

                // LE SETEO LOS DATOS AL USUARIO QUE VIENEN DEL RESULTSET
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));
            }
            // RETORNO EL USUARIO GUARDADO EN EL RESULTSET
            return producto;
        } catch (SQLException | MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER USUARIO");
        } finally {
            desconectarBase();
        }
    }

    public List<Producto> obtenerProductos() throws MiExcepcion {
        try {
            // SENTENCIA SQL DE CONSULTA
            // LA SENTENCIA ESTA VA VARIANDO SEGUN LO QUE PIDA EL EJERCICIO O LO QUE QUIERA REALIZAR
            String sql = "SELECT * FROM producto"; // "SELECT correo, nombre, apellido FROM usuario";

            consultarBase(sql);

            List<Producto> productos = new ArrayList();
            Producto producto = null;

            while (resultado.next()) {
                producto = new Producto();
                // LOS NUMEROS (1) A (3) SON EL NUMERO DE COLUMNAS Y SE PUEDE PONER
                // EL NUMERO O EL NOMBRE DE LA MISMA
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));

                productos.add(producto);
            }

            return productos;
        } catch (SQLException | MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER USUARIOS");
        } finally {
            desconectarBase();
        }
    }

    public List<Producto> obtenerNombrePrecio() throws MiExcepcion {
        try {
            // SENTENCIA SQL DE CONSULTA
            // LA SENTENCIA ESTA VA VARIANDO SEGUN LO QUE PIDA EL EJERCICIO O LO QUE QUIERA REALIZAR
            String sql = "SELECT nombre, precio FROM producto"; // "SELECT correo, nombre, apellido FROM usuario";

            consultarBase(sql);

            List<Producto> productos = new ArrayList();
            Producto producto = null;

            while (resultado.next()) {
                producto = new Producto();
                // LOS NUMEROS (1) A (3) SON EL NUMERO DE COLUMNAS Y SE PUEDE PONER
                // EL NUMERO O EL NOMBRE DE LA MISMA

                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));

                productos.add(producto);
            }

            return productos;
        } catch (SQLException | MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER USUARIOS");
        } finally {
            desconectarBase();
        }
    }

    public List<Producto> obtenerTodo120202() throws MiExcepcion {
        try {
            // SENTENCIA SQL DE CONSULTA
            // LA SENTENCIA ESTA VA VARIANDO SEGUN LO QUE PIDA EL EJERCICIO O LO QUE QUIERA REALIZAR
            String sql = "SELECT * FROM producto WHERE precio BETWEEN 120 AND 202"; // "SELECT correo, nombre, apellido FROM usuario";

            consultarBase(sql);

            List<Producto> productos = new ArrayList();
            Producto producto = null;

            while (resultado.next()) {
                producto = new Producto();
                // LOS NUMEROS (1) A (3) SON EL NUMERO DE COLUMNAS Y SE PUEDE PONER
                // EL NUMERO O EL NOMBRE DE LA MISMA

                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));

                productos.add(producto);
            }

            return productos;
        } catch (SQLException | MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER USUARIOS");
        } finally {
            desconectarBase();
        }
    }

    public List<Producto> obtenerPortatiles() throws MiExcepcion {
        try {
            // SENTENCIA SQL DE CONSULTA
            // LA SENTENCIA ESTA VA VARIANDO SEGUN LO QUE PIDA EL EJERCICIO O LO QUE QUIERA REALIZAR
            String sql = "SELECT * FROM producto WHERE nombre like 'Portatil%'"; // "SELECT correo, nombre, apellido FROM usuario";

            consultarBase(sql);

            List<Producto> productos = new ArrayList();
            Producto producto = null;

            while (resultado.next()) {
                producto = new Producto();
                // LOS NUMEROS (1) A (3) SON EL NUMERO DE COLUMNAS Y SE PUEDE PONER
                // EL NUMERO O EL NOMBRE DE LA MISMA

                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));

                productos.add(producto);
            }

            return productos;
        } catch (SQLException | MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER USUARIOS");
        } finally {
            desconectarBase();
        }
    }

    public List<Producto> obtenerMasBarato() throws MiExcepcion {
        try {
            // SENTENCIA SQL DE CONSULTA
            // LA SENTENCIA ESTA VA VARIANDO SEGUN LO QUE PIDA EL EJERCICIO O LO QUE QUIERA REALIZAR
            String sql = "SELECT nombre, precio FROM producto ORDER BY precio LIMIT 1"; // "SELECT correo, nombre, apellido FROM usuario";

            consultarBase(sql);

            List<Producto> productos = new ArrayList();
            Producto producto = null;

            while (resultado.next()) {
                producto = new Producto();
                // LOS NUMEROS (1) A (3) SON EL NUMERO DE COLUMNAS Y SE PUEDE PONER
                // EL NUMERO O EL NOMBRE DE LA MISMA

                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));

                productos.add(producto);
            }

            return productos;
        } catch (SQLException | MiExcepcion e) {
            System.out.println(e.getMessage());
            throw new MiExcepcion("ERROR AL OBTENER USUARIOS");
        } finally {
            desconectarBase();
        }
    }
}
