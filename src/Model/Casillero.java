/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
        
public class Casillero {
    private boolean estaOcupado;
    private Cliente cliente;
    private static int numeroCasillero = 1000;

    public Casillero(){
        numeroCasillero++;
    }

    /**
     * Asigna un cliente al casillero
     * @param pCliente cliente que se asignara al casillero
     * @return true si el cliente es agreado y false si el casillero ya tenia cliente
     */
    public boolean asignarCasillero(Cliente pCliente){
        if (cliente == null) {
            cliente = pCliente;
            estaOcupado = true;
            return true;
        }
        return false;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean getEstado() {
        return estaOcupado;
    }
}
