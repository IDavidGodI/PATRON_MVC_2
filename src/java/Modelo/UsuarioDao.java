/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Random;
/**
 *
 * @author Pahuena
 */
public class UsuarioDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs = null;
    
    public Usuario validar(String email, String pass)throws SQLException{
        Usuario user = new Usuario();
        String newpass = cifrarPassword(pass);
        
        
        String sql = "Select * from Materias where email=? and contraseña=?";
        
        try{
            con=Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, newpass);
            
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setContraseña(rs.getString("contraseña"));
                user.setCod_Materia(rs.getString("Cod_Materia"));
                
               
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error en DAOAxxxxxxxxxxxxxxxxxxx: " + e.getMessage());
        }
        return user;
    }
    public boolean registrar(String email, String pass, String Cod_Materia, String Materia){
        if(validateUser(email)){
            String sql = "INSERT INTO MATERIAS (email,contraseña, Cod_Materia, Materia) values (?,?,?,?)";
            String newpass = cifrarPassword(pass);
            try{
                con=Conexion.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, newpass);
                
                ps.setString(3, Cod_Materia);
                ps.setString(4, Materia);
                
                
                
                
                ps.execute();
                return true;
            }catch(ClassNotFoundException | SQLException e){
                System.out.println("Error en DAOB: " + e.getMessage());
                return false;
            }
        }else{
            return false;
        }    
    }
    public boolean validateUser(String email){
        Usuario user = new Usuario();
        
        String sql = "Select * from MATERIAS where email=?";
      
        
        try{
            con=Conexion.getConnection();
            ps = con.prepareStatement(sql);
           
            ps.setString(1, email);
                            
            
            rs = ps.executeQuery();
            System.out.println(rs);
            
            while(rs.next()){
               user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setContraseña(rs.getString("contraseña"));
                
                user.setCod_Materia(rs.getString("Cod_Materia"));
                user.setMateria(rs.getString("Materia"));
                
                
                return user.getCod_Materia() == null;
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error en DAOCxxxxxxxxxxxxxxxxx: " + e.getMessage());
        }
        return user.getEmail() == null;
   
        
    }
    public String cifrarPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
    public String enviarCorreo(String correo) {
        
        final String username = "XXX@gmail.com";
        final String password = "LA CONTRASEÑA CON FONDO AMARILLO";
        Random random = new Random();
        int codigo = random.nextInt(900000) + 100000;
        String destinatario = correo;
        String asunto = "Codigo de autenticacion";
        String mensaje = "Su codigo de autenticacion es: "+codigo;
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.ssl.protocols","TLSv1.2");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        //props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

        Session session;
        session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
System.out.println(username);
System.out.println(password);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(mensaje);

            Transport.send(message);
            return cifrarPassword(Integer.toString(codigo));

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
}
