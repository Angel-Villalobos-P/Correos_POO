/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import util.GeneradorDeCorreo;

import java.util.ArrayList;
import java.util.Date;

/**
 * El Counter contiene los casilleros que van a ser creados vacíos. Va a recibir artículos y es capaz de almacenar estos mismos.
 * */
public class Counter {
    //public static Counter counter;
    private String nombre;
    private String cedula;
    private Direccion direccion;
    private int cantidadCasilleros;

    public ArrayList<Casillero> getRegistroCasilleros() {
        return registroCasilleros;
    }

    private ArrayList<Casillero> registroCasilleros;
    //private ArrayList<Entregable> registroEntregablesRecibidos;
    private ArrayList<Entregable> registroEntregablesEntregados;

    /**
     * Constructor del Counter
     * @param nombre Nombre del counter
     * @param cedula cédula jurídica del counter
     * @param direccion dirección del counter
     * @param cantidadCasilleros cantidad de casilleros disponibles que va a tener el counter
     * */
    public Counter(String nombre,String cedula, Direccion direccion, int cantidadCasilleros){
        this.nombre=nombre;
        this.cedula=cedula;
        this.direccion=direccion;
        //this.cantidadCasilleros=cantidadCasilleros;
        registroCasilleros = new ArrayList<>();
        //registroEntregablesSinDueño = new ArrayList<>();
        registroEntregablesEntregados = new ArrayList<>();

        for (int i=0;i<cantidadCasilleros;i++){
            Casillero casillero = new Casillero(i+1000);
            registroCasilleros.add(casillero);
        }
    }


    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setCedula(String cedula){
        this.cedula=cedula;
    }
    public void setDireccion(Direccion direccion){
        this.direccion=direccion;
    }
    public void setCantidadCasilleros(int cantidadCasilleros) {
        this.cantidadCasilleros = cantidadCasilleros;
    }

    /**
     * Registra el cliente a un casillero vacío
     * @param cliente cliente que quiere registrarse
     * @return true si se registró exitosamente el cliente, false en los demás casos
     * */
    public boolean registrarCliente(Cliente cliente) {

        //Revisa si el cliente ya está registrado
        if (this.checkForClient(cliente.getId())) {
            return false;
        }
        for (Casillero casillero : registroCasilleros) {
            if (casillero.getCliente() == null) {
                casillero.setCliente(cliente);
                return true;
            }
        }
        return false;
        /*for (int i = 0; i < registroCasilleros.size(); i++) {
            if (registroCasilleros.get(i).getEstado() != (TipoEstadoCasillero.Libre)) {
                if (registroCasilleros.get(i).getCliente().getId() == cliente.getId()) {
                    return false;
                }
            }
            registroCasilleros.get(i).setCliente(cliente);
            //return true;
        }
        return true;*/
    }
    /**
     * Modifica el cliente buscado con el id y lo reemplaza con un cliente casi parecido pero con los cambios
     * @param id identificación del cliente
     * @param clienteMod objeto Cliente con los cambios deseados
     * @return devuelve true si se modificó el cliente y false si hubo un problema
     * */
    public boolean modificarCliente(int id,Cliente clienteMod){
        for (int i = 0; i < registroCasilleros.size(); i++){
            if (registroCasilleros.get(i).getCliente() == null){
                continue;
            }
            if (registroCasilleros.get(i).getCliente().getId() == id) {
                registroCasilleros.get(i).setCliente(clienteMod);
                return true;
            }
        }
        return false;
    }
    /**
     * Modifica el cliente buscado con el id y lo reemplaza con un cliente casi parecido pero con los cambios
     * @param id identificación del cliente
     * @param clienteMod objeto Cliente con los cambios deseados
     * */
    public void modificarClienteVoid(int id,Cliente clienteMod){
        for (int i = 0; i < registroCasilleros.size(); i++){
            if (registroCasilleros.get(i).getCliente() == null){
                continue;
            }
            if (registroCasilleros.get(i).getCliente().getId() == id) {
                registroCasilleros.get(i).setCliente(clienteMod);
            }
        }
    }
    /**
     * Consulta un cliente registrado en el counter
     * @param id identificación del cliente que se quiere buscar
     * @return Retorna el cliente deseado si se encontró, en caso contrario devuelve un null
     * */
    public Cliente consultarCliente(int id){
        Cliente clienteConsultado = null;
        for (int i = 0; i < registroCasilleros.size(); i++){
            if (registroCasilleros.get(i).getCliente() == null){
                continue;
            }
            if (registroCasilleros.get(i).getCliente().getId() ==id) {
                return registroCasilleros.get(i).getCliente();
            }
        }
        return clienteConsultado;
    }

    /**
     * Despeja del casillero a un cliente para dejarlo libre
     * @param id identificación del cliente a remover
     * @return true si se removió correctamente, false si no estaba registrado
     * */
    public boolean eliminarCliente(int id){
        for (int i = 0; i < registroCasilleros.size(); i++){
            if (registroCasilleros.get(i).getCliente() == null){
                continue;
            }
            if (registroCasilleros.get(i).getCliente().getId() ==id) {
                registroCasilleros.get(i).setCliente(null);
                registroCasilleros.get(i).setEstado(TipoEstadoCasillero.Libre);
                return true;
            }
        }
        return false;
    }
    /**
     * Da una lista con todos los clientes registrados en el counter
     * @return lista con los datos de los clientes
     * */
    public String concatenarClientes(){
        String salida="";
        for(int i=0; i<registroCasilleros.size();i++){
            if (registroCasilleros.get(i).getCliente() == null){
                continue;
            }
            if (registroCasilleros.get(i).getCliente().getId()!=0){
                salida = salida + registroCasilleros.get(i).getCliente() + " ";
            }
        }
        return salida;
    }
    /**
     * Entrega un entregable al casillero de un cliente
     * @param entregable el entregable que se quiere depositar
     * @param idCliente identificación del receptor del artículo
     * */
    public void registrarArticulo(Entregable entregable,int idCliente){
        for (int i = 0; i < registroCasilleros.size(); i++){
            if (registroCasilleros.get(i).getCliente() == null){
                continue;
            }
            if (registroCasilleros.get(i).getCliente().getId()==idCliente){
                registroCasilleros.get(i).getRegistroEntregable().add(entregable);
                GeneradorDeCorreo genCorreo = new GeneradorDeCorreo();
                genCorreo.mandarCorreo(registroCasilleros.get(i).getCliente().getCorreo(),"Estimado usuario(a):\n      A usted le llegó un paquete a su casillero. Por favor venga a la"
                        + " sucursal y retire su paquete.\n\nGracias por elegirnos.");

            }
        }
    }



    /**
     * Revisa si el casillero tiene un cliente asignado
     * @param numCliente identificación del cliente que se quiere buscar
     * @return true si existe un cliente, false en los demás casos
     * */
    public boolean estadoCasillero1(int numCliente){    //-------------------------------1
        for (int i = 0; i < registroCasilleros.size(); i++){
            if (registroCasilleros.get(i).getCliente() == null){
                continue;
            }
            if(registroCasilleros.get(i).getCliente().getId()==numCliente) {
                return true;
            }
        }
        return false;
    }

    /**
     * Revisa si el id de casillero existe en el counter
     * @param idCasillero identificación del casillero
     * @return true si existe el casillero, false en los demás casos
     * */
    public boolean estadoCasillero2(int idCasillero){   //--------------------------------2
        for (int i = 0; i < registroCasilleros.size(); i++){
            if(registroCasilleros.get(i).getNumCasillero()==idCasillero) {
                return true;
            }
        }
        return false;
    }

    /**
     * Revisa los artículos pendientes en el casillero de un cliente
     * @param idCliente identificación del cliente para buscar
     * @return lista con los artículos pendientes en el casillero
     * */
    public String paquetesPorRetirar(int idCliente){
        String salida="";
        for (int i = 0; i < registroCasilleros.size(); i++){
            if (registroCasilleros.get(i).getCliente() == null){
                continue;
            }
            if (registroCasilleros.get(i).getCliente().getId()==idCliente){
                for(int p = 0; p < registroCasilleros.get(i).getRegistroEntregable().size(); p++) {
                    salida = salida + registroCasilleros.get(i).getRegistroEntregable().get(p).toStringInicial() + " ";
                }
            }
        }
        return salida;
    }

    /**
     * Envía un correo que avisa sobre los pendientes que se tiene en el casillero
     * @param correo correo del receptor a enviar
     * */
    public void enviarCorreoPendientes(String correo){
        GeneradorDeCorreo genCorreo = new GeneradorDeCorreo();
        genCorreo.mandarCorreo(correo,"Estimado usuario(a):\n      Tiene varios paquetes sin retirar. Por favor venga a la"
                + " sucursal y retire su paquete.\n\nGracias por elegirnos.");
    }

    /**
     * Retira el artículo deseado del casillero y le asigna un tiempo de retiro
     * @param numEntregable codigo del árticulo para retirar
     * */
    public void retirarEntregable(int numEntregable){
        Date fecha= new Date();
        for (int i = 0; i < registroCasilleros.size(); i++){
            for (int p = 0; p < registroCasilleros.get(i).getRegistroEntregable().size(); p++){
                if(registroCasilleros.get(i).getRegistroEntregable().get(p).getNumReferencia()==numEntregable){
                    registroCasilleros.get(i).getCliente().retirarPaquete(1);
                    registroCasilleros.get(i).getCliente().getRanking();

                    //setear fecha de recibido al cliente.
                    registroCasilleros.get(i).getRegistroEntregable().get(p).setFechaEntregadoCliente(fecha);

                    registroEntregablesEntregados.add(registroCasilleros.get(i).getRegistroEntregable().get(p));

                    registroCasilleros.get(i).deleteEntregable(registroCasilleros.get(i).getRegistroEntregable().get(p));

                }
            }
        }
    }

    @Override
    public String toString() {
        return "Counter{" + "Nombre=" + nombre + 
                ", CedulaJur=" + cedula + 
                ", descripcion=" + direccion + 
                ", Cantidad de Casilleros=" + cantidadCasilleros + '}'+"\n"; 
    }

    /**
     * Método para revisar si el cliente existe en el counter
     * @param id identificación del cliente
     * @return true si el cliente existe, false si no existe
     * */
    public boolean checkForClient(int id){
	    for (int i = 0; i < registroCasilleros.size(); i++){
	        if (registroCasilleros.get(i).getEstado() == (TipoEstadoCasillero.Libre)) {
		    continue;
	        }
            if(registroCasilleros.get(i).getCliente().getId() == id){
		    return true;
	        }
	    }
	    return false;
    }

    /**
     * Hace una lista con todos los clientes con artículos pendientes a retirar
     * @return lista con los clientes
     * */
    public String listadoClientesPaquetePendiente(){
        String salida="";
        for (int i = 0; i < registroCasilleros.size(); i++){
            if(registroCasilleros.get(i).getRegistroEntregable()!=null) {
                for (int p = 0; p < registroCasilleros.get(i).getRegistroEntregable().size(); p++) {
                    salida = salida + registroCasilleros.get(i).getCliente().toString() + " = " + p + " ";
                }
            }
        }
        return salida;
    }

    /**
     * Consulta todos los paquetes que han sido recibidos, no incluyen los que hayan sido retirados
     * @param fecha fecha de consulta
     * @return lista con todos los entregables en los casilleros
     * */
    public String consultarEntregablesRecibidos(Date fecha){
        String salida="";
        for (int i = 0; i<registroCasilleros.size();i++) {
            if (registroCasilleros.get(i).getRegistroEntregable() != null) {
                for (int j = 0; j < registroCasilleros.get(i).getRegistroEntregable().size(); j++) {
                    Entregable articulo = registroCasilleros.get(i).getRegistroEntregable().get(j);
                    if (articulo.getFechaEntregadoCliente().compareTo(fecha) == 0) {
                        salida += articulo.toString();
                    }
                }
            }
        }

        return salida;
    }

    /**
     * Consulta todos los paquetes que han sido retirados
     * @param fecha fecha de consulta
     * @return lista con todos los entregables retirados
     * */
    public String consultarEntregablesEntregados(Date fecha) {
        String salida = "";
        for (int i = 0; i<registroEntregablesEntregados.size();i++){
            if (registroEntregablesEntregados.get(i).getFechaEntregadoCliente().compareTo(fecha) == 0) {
                salida += registroEntregablesEntregados.get(i).toString();
            }
        }
        return salida;
    }

    /**
     * Consulta todos los paquetes que han sido recibidos, no incluyen los que hayan sido retirados
     * @param fechaConsulta fecha de consulta
     * @return lista con los siguientes datos: fecha, costo de impuestos, costo de descuentos, costo Total y ganancia total de ese día
     * */
    public String generarReporte(Date fechaConsulta){

        double ganancia= 0;
        double costoImpuestos= 0;
        double costoTotal= 0;
        double costoDescuentos = 0;
        for (int i = 0;i < registroEntregablesEntregados.size();i++){
            Entregable articulo = registroEntregablesEntregados.get(i);

            costoImpuestos += articulo.calcularImpuesto();
            costoDescuentos += articulo.getDescuento();
            double costoFinalTemp = articulo.getPrecio() + articulo.calcularImpuesto() -articulo.getDescuento();
            costoTotal += costoFinalTemp;
            ganancia += costoFinalTemp - articulo.calcularImpuesto() -articulo.getDescuento();
        }
        String reporte = "Reporte Dia" + fechaConsulta.toString() + "\n";
        reporte += "Costo de impuestos: " + costoImpuestos + "\n" +
                   "Costo de descuentos: " + costoDescuentos + "\n" +
                   "Costo Total: " + costoTotal + "\n" +
                   "Ganancias = " + ganancia + "\n";

        return reporte;
    }
}
