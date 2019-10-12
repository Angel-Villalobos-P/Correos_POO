package util;

import cr.fi.bccr.sdde.ws.WsIndicadoresEconomicosSoap;
import cr.fi.bccr.sdde.ws.WsIndicadoresEconomicosSoapProxy;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;


/**
 * Esta clase consume del Web Service del Banco Central de Costa Rica. Se puede obtener los cambios de venta/compra del dólar en colones
 * @author Zhong Jie Liu Guo
 * */
public class WebServiceBccr {
  private WsIndicadoresEconomicosSoap indicadores;
  
  /**
   * Constructor de la clase. Inicializa el WebService
   */
  public WebServiceBccr() {
    indicadores = new WsIndicadoresEconomicosSoapProxy();
  }
  
  /**
   * Obtiene el valor Venta del cambio del Dólar
   * @param pFechaConsulta fecha en formato (dd/mm/yyyy) que se consulta el cambio
   * @return Retorna el valor del cambio de dólar
   * */
  public double getCambioVenta(String pFechaConsulta) throws IOException,Exception {
    String nuevo = indicadores. obtenerIndicadoresEconomicosXML("318", pFechaConsulta, pFechaConsulta, "Nombre","N");
    double cambioActual = Double.parseDouble(parsearCadena(nuevo));
    return cambioActual;  
  }
  
  /**
   * Obtiene el valor Venta del cambio del Dólar
   *@param fecha Recibe iun objeto Date del la fecha deseada
   * @return Retorna el valor del cambio de dólar
   */
  public double getCambioVenta(Date fecha) throws IOException,Exception {
    String fechaConsulta = "" + fecha.getDate() +"/" + (fecha.getMonth() + 1) + "/" + (fecha.getYear()+1900);
    String nuevo = indicadores. obtenerIndicadoresEconomicosXML("318", fechaConsulta, fechaConsulta, "Nombre","N");
    double cambioActual = Double.parseDouble(parsearCadena(nuevo));
    return cambioActual;  
  }
  
  /**
   * Obtiene el valor Compra del cambio del Dólar
   * @param pFechaConsulta fecha en formato (dd/mm/yyyy) que se consulta el cambio
   * @return Retorna el valor del cambio de dólar
   * */
  public double getCambioCompra(String pFechaConsulta) throws IOException,Exception{
    String nuevo = indicadores. obtenerIndicadoresEconomicosXML("317", pFechaConsulta, pFechaConsulta, "Nombre","N");
    double cambioActual = Double.parseDouble(parsearCadena(nuevo));
    return cambioActual; 
  }
  
  /**
   * Obtiene el valor Compra del cambio del Dólar
   * @param fecha fecha de tipo Date para buscar el cambio de la fecha dada
   * @return Retorna el valor del cambio de dólar
   * */
  public double getCambioCompra(Date fecha) throws IOException,Exception{
    String fechaConsulta = "" + fecha.getDate() +"/" + (fecha.getMonth() + 1) + "/" + (fecha.getYear()+1900);
    String nuevo = indicadores. obtenerIndicadoresEconomicosXML("317", fechaConsulta, fechaConsulta, "Nombre","N");
    double cambioActual = Double.parseDouble(parsearCadena(nuevo));
    return cambioActual; 
  }
  
  
  /**
   * Recibe un String en formato XML y extrae el valor de cambio deseado
   * @param pXml Recibe un String en formato XML
   * @return Valor de cambio en String 
   * */
  private String parsearCadena(String pXml) throws IOException,Exception {
    StringXmlParser parser = new StringXmlParser();
    return parser.parse(pXml);
  }
}
