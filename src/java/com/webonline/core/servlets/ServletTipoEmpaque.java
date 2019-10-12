/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webonline.core.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.webonline.core.model.AccessToken;
import java.lang.reflect.Type;
import com.webonline.core.model.TipoEmpaque;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cmayen
 */
public class ServletTipoEmpaque extends HttpServlet {

    public void doPost(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException {
        RequestDispatcher despachador = null;
        HttpSession session = peticion.getSession();
        AccessToken token = (AccessToken) session.getAttribute("token");
        URL url = new URL("http://192.168.31.110:9200/api/v1/tiposempaque");
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");
        conexion.setRequestProperty("Accept", "application/json"); 
         conexion.setRequestProperty("Authorization", "Bearer ".concat(token.getAccessToken()));   
        String encode = conexion.getContentEncoding();
        System.out.println("Encoding:" + encode);
        if (conexion.getResponseCode() != 200) {
            throw new RuntimeException("Failed: HTTP 1.1 Error code "
                    .concat(String.valueOf(conexion.getResponseCode())));
        } else {
            InputStreamReader in = new InputStreamReader(conexion.getInputStream(), "UTF-8");
            BufferedReader br = new BufferedReader(in);
            String salida;
            Gson gson = new Gson();
            Type tipoTipoEmpaque = new TypeToken<List<TipoEmpaque>>() {
            }.getType();
            List<TipoEmpaque> listaTipoEmpaque = null;
            while ((salida = br.readLine()) != null) {
                listaTipoEmpaque = gson.fromJson(salida, tipoTipoEmpaque);
                System.out.println("salida: " + salida);
                System.out.println("listaTipoEmpaque: " + listaTipoEmpaque);
            }
            conexion.disconnect();
            peticion.setAttribute("tiposempaque", listaTipoEmpaque);
            despachador = peticion.getRequestDispatcher("tipoempaque.jsp");
        }
        despachador.forward(peticion, respuesta);
    }

    public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException {
        doPost(peticion, respuesta);
    }
}
