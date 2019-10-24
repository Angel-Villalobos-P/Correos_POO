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
        this.cantidadCasilleros=cantidadCasilleros;
        registroCasilleros = new ArrayList<>();
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
    public void setCantidadCasilleros(int cantidadCasilleros){
        this.cantidadCasilleros=cantidadCasilleros;
    }
    public void addCasillero(Casillero casi){
        registroCasilleros.add(casi);
    }
    @Override
    public String toString() {
        return "Counter{" + "Nombre=" + nombre + 
                ", CedulaJur=" + cedula + 
                ", descripcion=" + direccion + 
                ", Cantidad de Casilleros=" + cantidadCasilleros + '}'+"\n"; 
    }
     
}
