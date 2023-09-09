/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;


import Modelo.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pahuena
 */
@WebServlet(name = "Registrarse", urlPatterns = {"/Registrarse"})
public class Registrarse extends HttpServlet {
    UsuarioDao Udao= new UsuarioDao();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registrarse</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registrarse at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
       
        if(accion.equalsIgnoreCase("Registrarse")){
            String email=request.getParameter("txtemail");
            String pass=request.getParameter("txtpass");
            String passconfir=request.getParameter("txtpassConfir");
            
            String Cod_Materia=request.getParameter("txtCod_Materia");
            String Materia=request.getParameter("txtMateria");
            
            
            
            
            if(pass.equals(passconfir)){
                boolean validar = Udao.registrar(email,pass, Cod_Materia, Materia);
                if(validar){
                    response.sendRedirect("index.jsp");
                }else{
                    response.sendRedirect("registrar_1.jsp?Vemail=false");
                }
            }else{
                response.sendRedirect("registrar_1.jsp?Vpass=false");
            }
            
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
