package SERVICIOS;

import ENTIDADES.Fabricante;
import EXCEPCION.MiExcepcion;
import PERSISTENCIA.FabricanteDAO;

public class FabricanteService {

    private FabricanteDAO fabricanteDAO;

    public FabricanteService() {
        fabricanteDAO = new FabricanteDAO();
    }

    public void crearFabricante(Integer codigo, String nombre) throws MiExcepcion {
        try {
            // VALIDACIÓN
            if (codigo == null) {
                throw new MiExcepcion("DEBE INGRESAR UN CODIGO");
            }

            if (nombre == null | nombre.trim().isEmpty()) {
                throw new MiExcepcion("DEBE INGRESAR UN NOMBRE");
            }

            Fabricante fabricante = new Fabricante();

            fabricante.setCodigo(codigo);
            fabricante.setNombre(nombre);

            fabricanteDAO.guardarFabricante(fabricante);
        } catch (MiExcepcion e) {
            // e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }

}
