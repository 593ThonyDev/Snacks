package com.snacks.controller;

import com.snacks.dao.*;
import com.snacks.model.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

public class Controlador extends HttpServlet {

    String LOGIN = "index.jsp";
    String reporte = "views/Reportes.jsp";
    String reportesCrear = "views/ReportesCrear.jsp";
    String UsuariosCrear = "views/UsuariosCrear.jsp";
    String Usuarios = "views/Usuarios.jsp";
    String acceso = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("accion");
        //========================================================================================== GLOBALES
        HttpSession session = request.getSession();
        responsable usu = (responsable) session.getAttribute("responsables");
        //if (usu == null) {
        // si no existe un usuario activo en el servidor se redirige al login
        //request.setAttribute("errorSesion", "Debes iniciar sesion, para acceder al contenido!!");
        // request.getRequestDispatcher(LOGIN).forward(request, response);
        // } else {}
        switch (page) {
            case "responsables":
                acceso = Usuarios;
                break;
            case "responsablesCrear":
                acceso = UsuariosCrear;
                break;
            case "reporte":
                acceso = reporte;
                break;
            case "ReportesCrear":
                acceso = reportesCrear;
                break;
            default:
                acceso = LOGIN;
        }
        RequestDispatcher view = request.getRequestDispatcher(acceso);
        view.forward(request, response);
    }

}
