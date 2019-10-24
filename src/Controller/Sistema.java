
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sistema {
    Counter miCounter;
    
    public Sistema(){
        miCounter = null;
    }

    public boolean crearCounter(String nombre,String cedula, Direccion direccion, int cantidadCasilleros){
        if(miCounter == null) {
            this.miCounter = new Counter(nombre, cedula, direccion, cantidadCasilleros);
            return true;
        }
        return false;

    }
    public Direccion crearDireccion(String provincia,String canton, String distrito, String senias) {
        Direccion direccion = new Direccion(provincia, canton, distrito, senias);
        return direccion;
    }

    private boolean validarNumero (String numero){
        if (numero.length() == 8){
            return true;
        }
        return false;
    }

    private boolean validarCorreo(String correo){
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
}
