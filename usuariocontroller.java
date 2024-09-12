/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.UsuarioDao;
import ModeloVeo.UsuarioVeo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sena
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/Usuario"})
public class UsuarioControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //1. Resivir los datos de la Vista
        String usuId = request.getParameter("textId");
        String usuLogin = request.getParameter("textLogin");
        String usuPassword = request.getParameter("textPassword");
        int opcion = Integer.parseInt(request.getParameter("opcion"));

        //2. El Vo tiene los datos de forma segura entonces se instacia
        UsuarioVeo usuVo = new UsuarioVeo(usuId, usuLogin, usuPassword);

        //3. Dao hace las operaciones; tambien se instacia
        UsuarioDao usuDao = new UsuarioDao(usuVo);

        //4. Administrar Operaciones
        switch (opcion) {
            case 1: //Agregar Registro
                if (usuDao.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "El usuario se registro correctamente");
                } else {
                    request.setAttribute("mensajeError", "El usuario no se registro correctamente");
                }
                request.getRequestDispatcher("registrarUsuario.jsp").forward(request, response);
                break;
            case 2: //Actualizar Registro
                if (usuDao.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El usuario se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeError", "El usuario no se actualizo correctamente");
                }
                request.getRequestDispatcher("actualizarUsuario.jsp").forward(request, response);
                break;

            case 3: //Eliminar Registro
                if (usuDao.eliminarRegistro()) {
                    request.setAttribute("mensajeExito", "El usuario se elimino correctamente");
                } else {
                    request.setAttribute("mensajeError", "El usuario no se elimino correctamente");
                }
                request.getRequestDispatcher("eliminarUsuario.jsp").forward(request, response);
                break;

            case 4: //Iniciar Sesion
                if (usuDao.inicioSesion(usuLogin, usuPassword)) {
                    request.getRequestDispatcher("dashboard.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "Por favor verifique sus datos de acceso");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }

                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
