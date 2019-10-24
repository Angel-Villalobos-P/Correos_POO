/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

public class Counter {
    private String nombre;
    private String cedula;
    private Direccion direccion;
    private int cantidadCasilleros;
    private ArrayList<Casillero> registroCasilleros;
    
    public Counter(){
        registroCasilleros = new ArrayList<>();
    }
    public Counter(String nombre,String cedula, Direccion direccion, int cantidadCasilleros){
        this.nombre=nombre;
        this.cedula=cedula;
        this.direccion=direccion;
        //this.cantidadCasilleros=cantidadCasilleros;
        registroCasilleros = new ArrayList<>();

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

    public boolean registrarCliente(Cliente cliente) {
        for (int i = 0; i < registroCasilleros.size(); i++){
            if (registroCasilleros.get(i).getCliente().getId() == cliente.getId()) {
                return false;
            }
            if (registroCasilleros.get(i).getEstado() == (TipoEstadoCasillero.Libre)) {
                registroCasilleros.get(i).setCliente(cliente);
                return true;
            }
        }
        return false;
    }

    public boolean modificarCliente(int id,Cliente clienteMod){
        for (int i = 0; i < registroCasilleros.size(); i++){
            if (registroCasilleros.get(i).getCliente().getId() == id) {
                registroCasilleros.get(i).setCliente(clienteMod);
                return true;
            }
        }
        return false;
    }

    public Cliente consultarCliente(int id){
        Cliente clienteConsultado = null;
        for (int i = 0; i < registroCasilleros.size(); i++){
            if (registroCasilleros.get(i).getEstado() == TipoEstadoCasillero.Libre){
                break;
            }
            if (registroCasilleros.get(i).getCliente().getId() ==id) {
                return registroCasilleros.get(i).getCliente();
            }
        }
        return clienteConsultado;
    }

    public boolean eliminarCliente(int id){
        for (int i = 0; i < registroCasilleros.size(); i++){
            if (registroCasilleros.get(i).getEstado() == TipoEstadoCasillero.Libre){
                break;
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
     
}
