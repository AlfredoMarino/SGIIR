/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import sgiir.propiedades.propiedades;

/**
 *
 * @author Alfredo Mariño
 */
public class email {
    MimeMessage msg;
    propiedades configuracionEmail = new propiedades(4);
    Properties props;
    String userEmail, passEmail, host, port;
    
    private class SMTPAuthenticator extends Authenticator{
        public PasswordAuthentication getPasswordAuthentication(){
            //return new PasswordAuthentication("ushcau@gmail.com", "kuscpclebdfilcxc");
            return new PasswordAuthentication(userEmail, passEmail);
        }
    }
    
    //INICIALIZA EL ENVIO DE MENSAJES
    public void email(){
        
        this.userEmail = configuracionEmail.getProperty("userEmail");
        this.passEmail = configuracionEmail.getProperty("passEmail");
        this.host = configuracionEmail.getProperty("hostEmail");
        this.port = configuracionEmail.getProperty("portEmail");
        
        props = new Properties();
        props.put("mail.smtp.user", userEmail);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        SMTPAuthenticator auth = new SMTPAuthenticator();
        Session session = Session.getInstance(props, auth);
        session.setDebug(true);
        msg = new MimeMessage(session);
    }
    
    //INICIALIZA EL ENVIO DE MENSAJES, RECIBE COMO PARAMATROS LOS DATOS DEL EMISOR
    public void email(String user, String pass, String host, String port){
        
        this.userEmail = user;
        this.passEmail = pass;
        this.host = host;
        this.port = port;

        props = new Properties();
        props.put("mail.smtp.user", userEmail);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        SMTPAuthenticator auth = new SMTPAuthenticator();
        Session session = Session.getInstance(props, auth);
        session.setDebug(true);
        msg = new MimeMessage(session);
    }
    
    //ENVIA EMAIL A UN SOLO DESTINO
    public boolean sendEmail(String subject, String to, String text){
        
        try {
            msg.setText(text);
            msg.setSubject(subject);
            msg.setFrom(new InternetAddress(userEmail));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            
            Transport.send(msg);
            
            return true;
        } catch (MessagingException ex) {
            Logger.getLogger(email.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }
    }
    
    //ENVIA EMAIL A UN GRUPO DE DESTINATARIOS
    public boolean sendEmail(String subject, String[] to, String text){
        
        try {
            msg.setText(text);
            msg.setSubject(subject);
            msg.setFrom(new InternetAddress(userEmail));
            for(String destinatario : to){
                msg.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            }

            Transport.send(msg);
            
            return true;
        } catch (MessagingException ex) {
            Logger.getLogger(email.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }
    }
    
}
