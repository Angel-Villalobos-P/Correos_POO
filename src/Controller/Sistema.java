
package Controller;

import Model.Cliente;
import Model.Counter;
import Model.Direccion;
import util.WebServiceBccr;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sistema {
    Counter miCounter;

    public static Sistema sistema;

    public Sistema() {
        miCounter = null;
    }

    public static Sistema getInstance(){
        if (sistema == null)
            sistema = new Sistema();
        return sistema;
    }

    public boolean crearCounter(String nombre, String cedula, Direccion direccion, int cantidadCasilleros) {
        if (miCounter == null) {
            this.miCounter = new Counter(nombre, cedula, direccion, cantidadCasilleros);
            return true;
        }
        return false;

    }

    public Direccion crearDireccion(String provincia, String canton, String distrito, String senias) {
        return new Direccion(provincia, canton, distrito, senias);
    }

    private boolean validarNumero(String numero) {
        if (numero.length() == 8) {
            return true;
        }
        return false;
    }

    private boolean validarCorreo(String correo) {
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

    public String consultarCambio(Date fecha) {
        WebServiceBccr servicio = new WebServiceBccr();

        try {
            return Double.toString(servicio.getCambioCompra(fecha));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String consultarVenta(Date fecha) {
        WebServiceBccr servicio = new WebServiceBccr();
        try {
            return Double.toString(servicio.getCambioVenta(fecha));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public Counter getMiCounter(){
        return miCounter;
    }

    public void test(){
        System.out.print("Funciona el singleton");
    }

    public void registrarCliente(Cliente cliente) {
        miCounter.registrarCliente(cliente);
    }
}
