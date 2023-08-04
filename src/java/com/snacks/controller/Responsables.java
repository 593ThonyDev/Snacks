/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.snacks.controller;

import com.snacks.dao.ResponsablesDao;
import com.snacks.model.responsable;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class Responsables extends HttpServlet {

    String LOGIN = "index.jsp";
    String CREAR = "views/UsuariosCrear.jsp";
    String EDITAR = "views/UsuariosActualizar.jsp";
    String REGISTROS = "views/Usuarios.jsp";

    //Objetos
    responsable res = new responsable();
    ResponsablesDao dao = new ResponsablesDao();
    //
    Integer idResponsable = 0;
    Integer resIntento = 0;
    String resNombres;
    String resApellidos;
    String resRole;
    String resUsuario;
    String resClave;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        HttpSession session = request.getSession();
//        Responsables usu = (Responsables) session.getAttribute("usuario");
//        if (usu == null) {
//            request.getRequestDispatcher(LOGIN).forward(request, response);
//        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("accion");
        String acceso = "";
        //========================================================================================== GLOBALES
        HttpSession session = request.getSession();
        responsable usu = (responsable) session.getAttribute("usuario");
        switch (action) {
            case "guardar":
                resIntento = 0;
                resNombres = request.getParameter("resNombres");
                resApellidos = request.getParameter("resApellidos");
                resRole = "Administrador";
                resUsuario = request.getParameter("resUsuario");
                resClave = request.getParameter("resClave");
                res = new responsable(resIntento, resNombres, resApellidos, resRole, resUsuario, resClave);
                dao.add(res);
                acceso = REGISTROS;
                break;
            case "actualizar":
                idResponsable = Integer.parseInt(request.getParameter("idResponsable"));
                resIntento = 0;
                resNombres = request.getParameter("resNombres");
                resApellidos = request.getParameter("resApellidos");
                resRole = "Administrador";
                resUsuario = request.getParameter("resUsuario");
                resClave = request.getParameter("resClave");
                res = new responsable(idResponsable, resIntento, resNombres, resApellidos, resRole, resUsuario, resClave);
                dao.updateById(res);
                System.out.println(dao.updateById(res));
                acceso = REGISTROS;
                break;
            default:
                acceso = LOGIN;
        }
        RequestDispatcher view = request.getRequestDispatcher(acceso);
        view.forward(request, response);
//        if (usu == null) {
//            // si no existe un usuario activo en el servidor se redirige al login
//            request.setAttribute("errorSesion", "Debes iniciar sesion, para acceder al contenido!!");
//            request.getRequestDispatcher(LOGIN).forward(request, response);
//        } else {
//            
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("accion");
        String acceso = "";
        //========================================================================================== GLOBALES
        HttpSession session = request.getSession();
        Responsables usu = (Responsables) session.getAttribute("usuario");
//        if (usu == null) {
//            // si no existe un usuario activo en el servidor se redirige al login
//            request.setAttribute("errorSesion", "Debes iniciar sesion, para acceder al contenido!!");
//            request.getRequestDispatcher(LOGIN).forward(request, response);
//        } else {
            switch (action) {
                case "nuevo":
                    acceso = CREAR;
                    break;
                case "editar":
                    request.setAttribute("idResponsable", request.getParameter("idResponsable"));
                    acceso = EDITAR;
                    break;
                case "eliminar":
                    idResponsable = Integer.parseInt((String) request.getParameter("idResponsable"));
                    /* ========== ENVIO EL OBJETO A LA DB=========*/
                    dao.deleteById(idResponsable);
                    acceso = REGISTROS;
                    break;

                default:
                    acceso = LOGIN;
            }
            RequestDispatcher view = request.getRequestDispatcher(acceso);
            view.forward(request, response);
//        }
    }
}
