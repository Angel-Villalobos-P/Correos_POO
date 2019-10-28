/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;


/**
 * El Counter contiene los casilleros que van a ser creados vacíos. Va a recibir artículos y es capaz de almacenar estos mismos.
 * */
public class Counter {
    //public static Counter counter;
    private String nombre;
    private String cedula;
    private Direccion direccion;
    private int cantidadCasilleros;
    private ArrayList<Casillero> registroCasilleros;
    private ArrayList<Entregable> registroEntregablesSinDueño;
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
        registroEntregablesSinDueño = new ArrayList<>();
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
	if (this.checkForClient(cliente.getId()) == true){
	   return false;
	}

        for (int i = 0; i < registroCasilleros.size(); i++){
            if (registroCasilleros.get(i).getEstado() == (TipoEstadoCasillero.Libre)) {
                if (registroCasilleros.get(i).getCliente() == null){
                    System.out.println("Sin cliente");
                    return false;
                }
                if(registroCasilleros.get(i).getCliente().getId() == cliente.getId()){
                    return false;
                }
                /*registroCasilleros.get(i).setCliente(cliente);
                return true;*/
            }
        }
        return false;
    }


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
     * Elimima un cliente registrado en el counter
     * @param id identificación del cliente que se quiere eliminar
     * @return true si se eliminó exitosamente el cliente, false en los demás casos
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


    @Override
    public String toString() {
        return "Counter{" + "Nombre=" + nombre + 
                ", CedulaJur=" + cedula + 
                ", descripcion=" + direccion + 
                ", Cantidad de Casilleros=" + cantidadCasilleros + '}'+"\n"; 
    }

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
     
}
