/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;

public class Casillero implements IRango{
    private Cliente cliente;
    private int numCasillero;
    private TipoEstadoCasillero estado;
    private ArrayList<Entregable> registroEntregable;
    
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
        this.estado = TipoEstadoCasillero.Ocupado;
    }
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

    public void getRanking(){
        if (cliente.getPaquetesRetirados() >= SILVER_RANK && cliente.getPaquetesRetirados() < GOLD_RANK){
            cliente.setTipo(TipoRango.Plata);
        } else if (cliente.getPaquetesRetirados() >= GOLD_RANK){
            cliente.setTipo(TipoRango.Oro);
        } else {

        }
    }
}
