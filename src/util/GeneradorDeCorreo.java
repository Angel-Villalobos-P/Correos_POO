package util;

import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Multipart;
import java.util.Properties;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.InternetAddress;

/**
 * Clase GeneradorDeCorreo: permite enviar un correo a un destinatario.
 *
 */
public class GeneradorDeCorreo {
    Properties props = new Properties();

  /*
   * Mandar Correo: permite enviar un correo al usuario
   * @param   pContrasenia    contrasenia a ser enviada al usuario
   * @param   pDestinatario   correo del destinatario
   * 
   */
  public void mandarCorreo(String pDestinatario,String mensaje) {
    //Definicion de datos del correo del remitente
    String correoRemitente = "pooproyecto4@gmail.com";
    String claveCorreo = "qwerty!#$%";

    // Definicion de configuracion necesaria para el envio de correo
    Properties properties = new Properties();
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.starttls.enable", "true");
    //properties.put("mail.smtp.port", "587");
    properties.put("mail.smtp.port", "25");
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.user", correoRemitente);
    properties.put("mail.password", claveCorreo);

    // Obtencion de la sesion de la cuenta 
    Session session = Session.getInstance(properties, null);
      
    try {
      // Creacion del cuerpo del mensaje
      MimeMessage mimeMessage = new MimeMessage(session);

      // Definicion de datos del correo del remitente
      mimeMessage.setFrom(new InternetAddress(correoRemitente,"noreply@poo.com"));

      // Definicion del destinatario del correo
      InternetAddress destinatario = new InternetAddress (pDestinatario);
      mimeMessage.setRecipient(Message.RecipientType.TO, destinatario);

      // Definicion del asunto del correo
      mimeMessage.setSubject("Notificación de llegada de paquete al casillero");

      // Creacion del cuerpo del correo
      MimeBodyPart mimeBodyPart = new MimeBodyPart();
      mimeBodyPart.setText(mensaje);

      // Creacion del multipart para agregar el mensaje anterior
      Multipart multipart = new MimeMultipart();
      multipart.addBodyPart(mimeBodyPart);
      mimeMessage.setContent(multipart);

      // Envio del mensaje
      Transport transport = session.getTransport ("smtp");
      
      System.out.println("Conexión exitosa");
      transport.connect (correoRemitente, claveCorreo);
        
      transport.sendMessage (mimeMessage, mimeMessage.getAllRecipients());
      transport.close();
      System.out.println("Correo enviado");
    }
    catch (Exception excepcion) {
      excepcion.printStackTrace();
      System.out.println("Error al enviar el correo");
    }
    
  }
} 