package com.webonline.core.servlets;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.webonline.core.controller.CategoriaController;
import com.webonline.core.model.AccessToken;
import com.webonline.core.model.Categoria;
import com.webonline.core.model.DeleteResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletEliminarCategoria extends HttpServlet {

    public void doPost(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException {
        RequestDispatcher despachador = null;
        HttpSession sesion = peticion.getSession();
        AccessToken token = (AccessToken) sesion.getAttribute("token");
        String id = peticion.getParameter("codigoCategoria");
        String url = this.getServletContext().getInitParameter("endPoint")
                .concat("/categorias/").concat(id);
        CategoriaController controller = new CategoriaController(url, token.getAccessToken());
        controller.eliminar();
        controller.setEndPoint(this.getServletContext().getInitParameter("endPoint").concat("/categorias"));
        List<Categoria> lista = controller.getCategorias();
        peticion.setAttribute("categorias", lista);
        despachador = peticion.getRequestDispatcher("categorias.jsp");
        despachador.forward(peticion, respuesta);
        }

    public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException {
        doPost(peticion, respuesta);
    }
}