package PERSISTENCIA;

import ENTIDADES.Fabricante;
import EXCEPCION.MiExcepcion;

public final class FabricanteDAO extends DAO {

    public void guardarFabricante(Fabricante fabricante) throws MiExcepcion {
        try {
            if (fabricante == null) {
                throw new MiExcepcion("USUARIO INVÁLIDO");
            }

            // SENTENCIA SQL DE INSERCIÓN
            String sql = "INSERT INTO fabricante(codigo, nombre) "
                    + "VALUES('" + fabricante.getCodigo()
                    + "', '" + fabricante.getNombre()
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

}
