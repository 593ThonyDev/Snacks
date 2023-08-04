package com.snacks.controller;

import com.snacks.model.*;
import com.snacks.dao.*;
import com.snacks.security.Encriptador;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class Login extends HttpServlet {

    /*Variables de sesion*/
    HttpSession session;
    responsable res = new responsable();
    ResponsablesDao dao = new ResponsablesDao();
    Encriptador enc = new Encriptador();
    /*Variables de la logica*/
    String resUsuario = "";
    String resClave = "";
    String resNombres = "";
    String resApellidos = "";
    String resRole = "";
    String resClaveBd = "";
    Integer resIntento = 0;
    Integer idResponsable = 0;

    // Constante para el número máximo de intentos permitidos
    final int MAX_INTENTOS = 3;

    /*Variables de navegacion*/
    String INCIO = "Controlador?accion=reporte";
    String LOGIN = "index.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        resUsuario = request.getParameter("resUsuario");
        resClave = request.getParameter("resClave");

        idResponsable = dao.getIdResponsable(resUsuario);
        res = dao.getById(idResponsable);

        // Si los parametros es igual a null o el id del idResponsable == 0 caso contrario pasa al else
        if (idResponsable == 0 || idResponsable == null) {
            request.setAttribute("errorSesion", "El responsable ingresado no esta registrado!!");
            request.getRequestDispatcher(LOGIN).forward(request, response);
        } else {
            // Utilizamos la bd para dar logica

            resClaveBd = res.getResClave();
            System.out.println("usuClaveBd " + res.getResClave());

            // SI LA CLAVE DESENCRIPTADA ES IGUAL A LA INGRESADA EN LA INTERFAZ SE DA EL ACCESO
            resIntento = res.getResIntento();

            // Validamos la clave
            // si la resClaveBd(BASE DE DATOS DESENCRIPTADA) es igual a la clave del input igresado por el responsable
            if (resClaveBd.equals(resClave)) {
                // GENERAMOS EL CONTROL DE INTENTOS
                if (resIntento <= MAX_INTENTOS) {
                    // ... Código de inicio de sesión exitoso ...
                    // Resetear intentos fallidos al inicio de sesión exitoso
                    resNombres= res.getResNombres();
                    resApellidos = res.getResApellidos();
                    resRole = res.getResRole();
                    res = new responsable(idResponsable, resIntento, resNombres, resApellidos, resRole, resUsuario, resClave);
                    dao.updateById(res);
                    // Realizamos la redireccion a la interfaz y agregamos los datos del responsable
                    session.setAttribute("idResponsables", idResponsable);
                    session.setAttribute("usuResponsables", resUsuario);
                    session.setAttribute("responsable", res);
                    response.sendRedirect(INCIO);
                } else {
                    request.setAttribute("errorSesion", "LIMITES DE INTENTOS EXCEDIDOS!!");
                    request.getRequestDispatcher(LOGIN).forward(request, response);
                }
            } else {
                // Incrementar el contador de intentos fallidos
                res = new responsable(idResponsable, resIntento + 1, resNombres, resApellidos, resRole, resUsuario, resClave);

                int intentosRestantes = MAX_INTENTOS - resIntento - 1; // Cálculo de intentos restantes

                if (resIntento >= MAX_INTENTOS) {
                    request.setAttribute("errorSesion", "LÍMITE DE INTENTOS EXCEDIDO," + "\n" + "USUARIO BLOQUEADO!!");
                } else {
                    if (intentosRestantes == 0) {
                        request.setAttribute("errorSesion", "CLAVE INCORRECTA!!" + "\n" + "USUARIO BLOQUEADO!!");
                        res = new responsable(idResponsable, 0, resNombres, resApellidos, resRole, resUsuario, resClave);
                    } else {
                        request.setAttribute("errorSesion", "CLAVE INCORRECTA!!" + "\n" + "Intentos restantes: " + intentosRestantes);
                    }
                }
                dao.updateById(res);
                request.getRequestDispatcher(LOGIN).forward(request, response);
            }
        }
    }
}
