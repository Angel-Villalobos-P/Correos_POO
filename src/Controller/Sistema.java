
package Controller;
import Model.Counter;
import Model.Direccion;
import Model.Casillero;
import Model.Cliente;
import Model.TipoSexo;
import Model.TipoEntrega;
import Model.TipoEntregable;
import Model.Entregable;
import java.util.Scanner;
import java.util.Date;
import Model.Paquete;
import Model.Sobre;
import Model.Revista;
import Model.TipoSobre;
import Model.TipoTemaRevista;
import java.util.ArrayList;

public class Sistema {
    
    
    public Sistema(){
    
    }
    public Counter inicializarCounter(String nombre,String cedula, Direccion direccion, int cantidadCasilleros){
        Counter CorreoCR = new Counter(nombre, cedula, direccion, cantidadCasilleros);
        return CorreoCR;
    }
    public Direccion crearDireccion(String provincia,String canton, String distrito, String senias){
        Direccion direccion=new Direccion(provincia,canton,distrito,senias);
        return direccion;
    }
    
}
