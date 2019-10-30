/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

/**
 * Se comporta como un contenedor de paquetes y puede estar asignado a un cliente, tiene una identifación
 * */
public class Casillero{
    private Cliente cliente;
    private int numCasillero;
    private TipoEstadoCasillero estado;
    private ArrayList<Entregable> registroEntregable;
    private SimpleStringProperty noAsignado = new SimpleStringProperty("No asignado");

    public String getNoAsignado() {
        return noAsignado.get();
    }


    /**
     * Constructor del Casillero, no tiene dueño y no tiene elementos guardados
     * @param nCasillero id del casillero que se le asignó
     *
     * */
    public Casillero(int nCasillero){
        this.numCasillero=nCasillero;
        this.estado=TipoEstadoCasillero.Libre;
        this.cliente=null;
        registroEntregable=new ArrayList<>();
    }
    public void setEstado(TipoEstadoCasillero estado){
        this.estado=estado;
    }
    public void setNumeroCasillero(int nCasillero){
        this.numCasillero=nCasillero;
    }

    public void setCliente(Cliente newC){
        this.cliente=newC;
        this.estado = TipoEstadoCasillero.Ocupado; //(newC == null ? TipoEstadoCasillero.Libre : TipoEstadoCasillero.Ocupado);
        noAsignado = (newC != null ? new SimpleStringProperty(cliente.getNombre()) : new SimpleStringProperty("No asignado"));
    }

    /**
     * Agrega un paquete al casillero
     * @param entregable Un artículo recibido de tipo Entregable
     * */
    public void addEntregable(Entregable entregable){
        registroEntregable.add(entregable);
    }

    @Override
    public String toString() {
        return "Casillero{" + "Numero de casillero=" + numCasillero + 
                ", Cliente=" + cliente + 
                ", Estado del Casillero=" + estado + '}'+"\n";  
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getNumCasillero() {
        return numCasillero;
    }

    public TipoEstadoCasillero getEstado() {
        return estado;
    }

    public ArrayList<Entregable> getRegistroEntregable() {
        return registroEntregable;
    }

}
