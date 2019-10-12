package util;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * Parsea un String en formato XML
 * @author Zhong Jie Liu Guo
 * */
public class StringXmlParser extends Exception{
  private String indicadorMayor;
  private String referenciaBusqueda;
  private String cambioDolarObtenido;
  
  /**
   * Constructor de la clase
   * @param pIndicadorMayor Categoria mayor del XML
   * @param pReferenciaBusqueda etiqueta específica al que se quiere extraer el dato.
   * */
  public StringXmlParser(String pIndicadorMayor,String pReferenciaBusqueda) {
    indicadorMayor = pIndicadorMayor;
    referenciaBusqueda = pReferenciaBusqueda;
  }
  
  /**
   * Constructor de la clase, útil para obtener valores del cambio de dólar
   * */
  public StringXmlParser() {
    indicadorMayor = "INGC011_CAT_INDICADORECONOMIC";
    referenciaBusqueda = "NUM_VALOR";
  }
  
  
  /**
   * Parsea un String en formato XML y extrae el dato por Referencia de Busqueda
   * @param xmlRecords Cadena con el String deseado
   * @return dato que se deseo buscar, en el web service del BCCR, se obtiene el valor de cambio
   * */
  public String parse(String xmlRecords) throws Exception{

    DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    InputSource is = new InputSource();
    is.setCharacterStream(new StringReader(xmlRecords));

    Document doc = db.parse(is);
    NodeList nodes = doc.getElementsByTagName(indicadorMayor);

    for (int i = 0; i < nodes.getLength(); i++) {
      Element element = (Element) nodes.item(i);

      NodeList cambio = element.getElementsByTagName(referenciaBusqueda);
      Element lineCambio = (Element) cambio.item(0);
      cambioDolarObtenido = getCharacterDataFromElement(lineCambio);
      
      //NodeList date = element.getElementsByTagName("DES_FECHA");
      //Element lineDate = (Element) date.item(0);
      //System.out.println("Fecha: " + getCharacterDataFromElement(lineDate));
    }
    return cambioDolarObtenido;

  }
  
  /**
   * Obtiene el String del objeto CharacterData como el dato a extraer del XML
   * @param e elemento donde se quiere extraer
   * @return String con los datos del elemento.
   * */
  private String getCharacterDataFromElement(Element e) {
    Node child = e.getFirstChild();
    if (child instanceof CharacterData) {
      CharacterData cd = (CharacterData) child;
      return cd.getData();
    }
    return "";
  }
}