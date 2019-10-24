/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;

public class Casillero {
    private Cliente cliente;
    private int numCasillero;
    private TipoEstadoCasillero estado;
    private ArrayList<Entregable> registroEntregable;
    
    public Casillero(int nCasillero){
        this.numCasillero=nCasillero;
        this.estado=TipoEstadoCasillero.Ocupado;
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
    
    
}
