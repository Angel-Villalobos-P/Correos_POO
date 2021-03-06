/**
 * ObtenerIndicadoresEconomicosXMLResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cr.fi.bccr.sdde.ws;

public class ObtenerIndicadoresEconomicosXMLResponse  implements java.io.Serializable {
    private String obtenerIndicadoresEconomicosXMLResult;

    public ObtenerIndicadoresEconomicosXMLResponse() {
    }

    public ObtenerIndicadoresEconomicosXMLResponse(
           String obtenerIndicadoresEconomicosXMLResult) {
           this.obtenerIndicadoresEconomicosXMLResult = obtenerIndicadoresEconomicosXMLResult;
    }


    /**
     * Gets the obtenerIndicadoresEconomicosXMLResult value for this ObtenerIndicadoresEconomicosXMLResponse.
     * 
     * @return obtenerIndicadoresEconomicosXMLResult
     */
    public String getObtenerIndicadoresEconomicosXMLResult() {
        return obtenerIndicadoresEconomicosXMLResult;
    }


    /**
     * Sets the obtenerIndicadoresEconomicosXMLResult value for this ObtenerIndicadoresEconomicosXMLResponse.
     * 
     * @param obtenerIndicadoresEconomicosXMLResult
     */
    public void setObtenerIndicadoresEconomicosXMLResult(String obtenerIndicadoresEconomicosXMLResult) {
        this.obtenerIndicadoresEconomicosXMLResult = obtenerIndicadoresEconomicosXMLResult;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ObtenerIndicadoresEconomicosXMLResponse)) return false;
        ObtenerIndicadoresEconomicosXMLResponse other = (ObtenerIndicadoresEconomicosXMLResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.obtenerIndicadoresEconomicosXMLResult==null && other.getObtenerIndicadoresEconomicosXMLResult()==null) || 
             (this.obtenerIndicadoresEconomicosXMLResult!=null &&
              this.obtenerIndicadoresEconomicosXMLResult.equals(other.getObtenerIndicadoresEconomicosXMLResult())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getObtenerIndicadoresEconomicosXMLResult() != null) {
            _hashCode += getObtenerIndicadoresEconomicosXMLResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObtenerIndicadoresEconomicosXMLResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.sdde.bccr.fi.cr", ">ObtenerIndicadoresEconomicosXMLResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obtenerIndicadoresEconomicosXMLResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.sdde.bccr.fi.cr", "ObtenerIndicadoresEconomicosXMLResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
