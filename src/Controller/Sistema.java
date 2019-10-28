
package Controller;

import Model.TipoSexo;
import Model.Cliente;
import Model.Counter;
import Model.Direccion;
import Model.Entregable;
import Model.Casillero;
import util.WebServiceBccr;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * La clase controla las funciones del modelo y ejecuta las funciones del counter
 *
 * */
public class Sistema {
    Counter miCounter;

    /**
     * Constructor que inicializa el objeto
     * */
    public static Sistema sistema;

    public Sistema() {
        miCounter = null;
    }

    /**
     *
     * Crea el counter
     * @param nombre Nombre del counter
     * @param cedula Cédula jurídica del counter
     * @param direccion Dirección del counter
     * @param cantidadCasilleros Cantidad de casilleros que tendrá el counter
     * @return true si se logró crear el counter, false si ya se creó el counter anteriormente
     * */
    public static Sistema getInstance(){
        if (sistema == null)
            sistema = new Sistema();
        return sistema;
    }

    public boolean crearCounter(String nombre, String cedula, Direccion direccion, int cantidadCasilleros) {
        if (miCounter == null) {
            this.miCounter = new Counter(nombre, cedula, direccion, cantidadCasilleros);
            return true;
        }
        return false;

    }

    /**
     * Crea un objeto dirección
     * @param provincia Provincia
     * @param canton Cantón
     * @param distrito Distrito
     * @param senias Señas varias para indicar
     * @return devuelve el objeto direccion creado
     * */
    public Direccion crearDireccion(String provincia, String canton, String distrito, String senias) {
        return new Direccion(provincia, canton, distrito, senias);
    }

    /**
     * Valida si un número es de largo 8
     * @param numero numero telefónico para validar
     * @return true si el número es de largo 8, al contrario devuelve false
     *
     * */
    private boolean validarNumero(String numero) {
        if (numero.length() == 8) {
            return true;
        }
        return false;
    }

    /**
     * Valida si el correo es correcto con respecto al formato, no su existencia
     * @param correo Correo para validar
     * @return true si el correo es del formato correcto, al contrario false
     * */
    private boolean validarCorreo(String correo) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(correo);
        if (mather.find() == true) {
            System.out.println("El email ingresado es válido.");
            return true;
        } else {
            System.out.println("El email ingresado es inválido.");
            return false;
        }

    }

    /**
     * Registra el cliente
     * @param cliente cliente que quiere registrarse
     * @return true si se registró exitosamente el cliente, false en los demás casos
     * */
    public boolean registrarClienteSiNo(Cliente cliente){
        boolean resultado = miCounter.registrarCliente(cliente);
        return resultado;
    }

    /**
     * Consulta un cliente registrado en el counter
     * @param id identificación del cliente que se quiere buscar
     * @return Retorna el cliente deseado si se encontró, en caso contrario devuelve un null
     * */
    public Cliente consultarCliente(String id){
        return miCounter.consultarCliente(Integer.parseInt(id));
    }

    /**
     * Elimima un cliente registrado en el counter
     * @param id identificación del cliente que se quiere eliminar
     * @return true si se eliminó exitosamente el cliente, false en los demás casos
     * */
    public boolean eliminarCliente(String id){
        return miCounter.eliminarCliente(Integer.parseInt(id));
    }

    /**
     * Consulta el tipo de cambio del BCCR de un día dado
     * @param fecha Objeto Date que indica la fecha deseada
     * @return valor del cambio de dolar
     * */
    public String consultarCambio(Date fecha) {
        WebServiceBccr servicio = new WebServiceBccr();

        try {
            return Double.toString(servicio.getCambioCompra(fecha));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Consulta el tipo de venta del BCCR de un día dado
     * @param fecha Objeto Date que indica la fecha deseada
     * @return valor de la venta de dolar
     * */
    public String consultarVenta(Date fecha) {
        WebServiceBccr servicio = new WebServiceBccr();
        try {
            return Double.toString(servicio.getCambioVenta(fecha));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public Counter getMiCounter(){
        return miCounter;
    }

    public void test(){
        System.out.print("Funciona el singleton");
    }

    public void registrarCliente(Cliente cliente) {
        miCounter.registrarCliente(cliente);
    }
    /**
     * Consulta el casillero por medio del ID del Cliente
     * @param id tipo String que indica el id del casillero por buscar
     * @return el casillero encontrado
     * */
    public Casillero consultarEstadoCasillero(String id){

        return null;
    }
    /**
     * Consulta el casillero por medio del ID del Casillero
     * @param numCasillero tipo int que indica el id del casillero por buscar
     * @return el casillero encontrado
     * */
    public Casillero consultarEstadoCasillero(int numCasillero){

        return null;
    }
    /**
     * Consulta los entregables de sin dueño de una fecha especifica
     * @param fecha tipo Date que indica la fecha de los entregables por buscar
     * @return el casillero con entregables sin dueño
     * */
    public ArrayList<Entregable> consultaEntregableSinDueno(Date fecha){
        return null;
    }
    /**
     * Consulta los entregables entregados de una fecha especifica
     * @param fecha tipo Date que indica la fecha de los entregables por buscar
     * @return el casillero con entregables entregados
     * */
    public ArrayList<Entregable> consultaEntregableEntregado(Date fecha){
        return null;
    }

    /**
     * Consulta los entregables de un cliente en especifico
     * @param id tipo String que indica el cliente a buscarle los entregable
     * @return su lista de entregables, del dueno
     * */
    public ArrayList<Entregable> consultaEntregable(String id){
        return null;
    }
    /**
     * Retira un articulo de un casillero de un cliente
     * @param id tipo String que indica el entregable a retirar
     * @return si se elimino o no el articulo
     * */
    public boolean retirarArticulo(String id){
        return false;
    }
    /**
     * Consulta todos los cliente con articulos pendientes por retirar pendientes
     * @return Los clientes concatenados en un String
     * */
    public String consultarClientesConPendientes(){
        return "";
    }
    /**
     * Genera un reporte general de la contabilidad de ganancias, impuestos, descuentos y total
     * @param fecha tipo Date que indica la fecha a generar el reporte
     * @return el string con todos los datos reportados
     * */
    public String generarReporte(Date fecha){
        return "";
    }
    /**
     * Modifica un Cliente si encuentra el ID de dicho cliente
     * @param allDatos tipos varios que indican los datos a modificar del cliente
     * @return el booleano indicando si se pudo modificar el cliente
     * */
    public boolean modificarCliente(int id,String nombre,String correo,String telefono,Direccion direccion,Date fecha,TipoSexo sexo){
        return false;
    }
    /**
     * visualiza todos los clientes
     * @return el String con todos los clientes concatenados
     * */
    public String visualizarClientes(){
        return "";
    }
    /**
     * Indica entregable por retirar de lista entregableSinEntregar y agrega a lista entregble retirados
     * @param entregable tipo Entregable que indicando el entregable a retirar de entregables
     * @return el booleano indicando si se pudo entregar al cliente
     * */
    public boolean recivirEntregable(Entregable entregable){
        return false;
    }
}
