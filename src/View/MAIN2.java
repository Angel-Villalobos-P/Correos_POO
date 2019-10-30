/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.Sistema;
import Model.*;
import util.WebServiceBccr;

import java.util.Date;

public class MAIN2 {
    
    //public static ArrayList<Entregable> entregable = new ArrayList<Entregable>();
    public static void main(String[] args) throws Exception {
        //Sistema sistema=new Sistema();
        //Direccion direccionCounter=null;
        //Counter counter=null;

 
    
        Sistema sistema=new Sistema();
        //1-Inicializar Counter//
        Direccion direccion = new Direccion("Cartago","La Unión","Tres Ríos","Donde Doña Lela");
        sistema.crearCounter("La POOsada","412341245",direccion,1000);
        //2-*/
        
        
        //scanners//
        //Scanner entrada = new Scanner(System.in);
        //System.out.print("Nombre del counter: ");
        String nombreCounter = "Lala";
        //System.out.print("CedulaJ del counter: ");
        String cedulaCounter = "234";
        //System.out.print("Direccion del counter: ");
        //System.out.print("Provincia: ");
        String provinciaCounter = "Punta";
        //System.out.print("Canton: ");
        String cantonCounter = "puntaa";
        //System.out.print("Distrito: ");
        String distritoCounter = "puntaaa";
        //System.out.print("Señas: ");
        String seniasCounter = "nonono";
        //System.out.print("Cantidad de casilleros del counter: ");
        int cantCasilleros = 2;
        
                //CREAR DIRECCION DEL COUNTER//
        Direccion direccionCounter=new Direccion(provinciaCounter, cantonCounter, distritoCounter, seniasCounter);
                //CREAR DIRECCION DEL CLIENTE//
        Direccion direccionCliente=new Direccion(provinciaCounter, cantonCounter, distritoCounter, seniasCounter);
                //CREAR FECHA NACIMIENTO DEL CLIENTE//
        Date fecha=new Date();
        //CREAR COUNTER//
        Counter CorreoCR = new Counter(nombreCounter, cedulaCounter, direccionCounter, cantCasilleros);
        //CREAR CLIENTE//        - ASIGNAR CASILLERO//
        int id=145;
        String nombreCli="",correo="",telefono="";
        TipoSexo sexo=TipoSexo.otro;
        Cliente clienteN=new Cliente(id,nombreCli,correo,telefono,direccionCliente,fecha,sexo);
                   //Crear Entregable//
        //CREAR PAQUETE//
        int numReferencia=45;
        boolean entregado=true,isElectric=true,isFragile=true;
        TipoEntregable descripcion=TipoEntregable.Paquete;
        String remitente="Carlos";
        TipoEntrega formaDeEntrega=TipoEntrega.bolsa;
        double peso=0.5;
        Paquete PaqueteN= new Paquete(numReferencia,entregado,descripcion,remitente,20,formaDeEntrega,isElectric,isFragile,peso,fecha);
        //CREAR CASILLERO//
        Casillero casilleroN=new Casillero(1);
        //ASIGNAR CLIENTE//
        casilleroN.setCliente(clienteN);
        //CREAR REVISTA//
        int numReferenciarevi=45;
        boolean entregadorevi=true;
        TipoEntregable descripcionrevi=TipoEntregable.Revista;
        String remitenterevi="Carlos";
        String nombreRevi="Revi";
        boolean isCatalogo=true;
        TipoTemaRevista tema=TipoTemaRevista.belleza;
        Revista RevistaN= new Revista(numReferenciarevi,entregadorevi,descripcionrevi,remitenterevi,20,nombreRevi,isCatalogo,tema,fecha);
        //CREAR SOBRE//
        int numReferenciasob=45;
        boolean entregadosob=true;
        TipoEntregable descripcionsob=TipoEntregable.Revista;
        String remitentesob="Carlos";
        TipoSobre tiposob = TipoSobre.aereo;
        String contenidosob="Mucho";
        double pesosob = 0.5;
        Sobre SobreN= new Sobre(numReferenciasob,entregadosob,descripcionsob,remitentesob,20,tiposob,contenidosob,pesosob,fecha);
        //ASIGNAR PAQUETE - Revista//
        casilleroN.addEntregable(PaqueteN);
        casilleroN.addEntregable(RevistaN);
        casilleroN.addEntregable(SobreN);
        
        //agregarCasillero al Counter
        //CorreoCR.addCasillero(casilleroN);
        //Imprimir//
        //Imprimir Entregables//
        System.out.println(PaqueteN.toString());
        System.out.println(PaqueteN.toStringInicial());
        System.out.println(RevistaN.toString());
        System.out.println(SobreN.toString());
        //Imprimir Clientes//
        System.out.println(clienteN.toString());
        //Imprimir Casilleros//
        System.out.println(casilleroN.toString());
        //Imprimir todo el counter//
        System.out.println(CorreoCR.toString());
    }
}
