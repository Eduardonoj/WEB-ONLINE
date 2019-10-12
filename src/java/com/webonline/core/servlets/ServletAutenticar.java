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
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/**
 *
 * @author cmayen
 */
public class ServletAutenticar extends HttpServlet{
    public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) 
            throws IOException, ServletException{
        doPost(peticion, respuesta);
    }
    
    public void doPost(HttpServletRequest peticion, HttpServletResponse respuesta) 
            throws IOException, ServletException{
        try {
            RequestDispatcher despachador = null;
            HttpSession session = peticion.getSession(true);
            DefaultHttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost("http://192.168.31.110:9200/oauth/token");
            post.addHeader("Authorization", "Basic YWxtYWNlbjpAbG1hYzNu");
            post.addHeader("Content-Type", "application/x-www-form-urlencoded");
            
            List<NameValuePair> parameters = new ArrayList<NameValuePair>();
            if (peticion.getParameter("username") != null && peticion.getParameter("password") != null){
                if (peticion.getParameterValues("username").length > 0 && 
                        peticion.getParameter("password").length()> 0){
                   String username = peticion.getParameter("username");
                   String password = peticion.getParameter("password");
                   
                   parameters.add(new BasicNameValuePair("username", username));
            parameters.add(new BasicNameValuePair("password", password));
            parameters.add(new BasicNameValuePair("grant_type", "password"));
            post.setEntity(new UrlEncodedFormEntity(parameters,HTTP.UTF_8));
            HttpResponse response = client.execute(post);
            
            if (response.getStatusLine().getStatusCode() != 200) {
                if (response.getStatusLine().getStatusCode() == 400 ||
                        response.getStatusLine().getStatusCode() == 401) {
                    peticion.setAttribute("estado", "Las credenciales son invalidas");
                    despachador = peticion.getRequestDispatcher("login.jsp");
                }
                throw new RuntimeException("Failed; HTTP Error Code:"
                        .concat(String.valueOf(response.getStatusLine().getStatusCode())));
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            
            String output = "";
            while ((output = br.readLine()) != null) { 
                AccessToken token = new Gson().fromJson(output, AccessToken.class);  
                session.setAttribute("token", token);
                //System.out.println(token);
                //System.out.println(token.getAccessToken());
                System.out.println(session.getAttribute("token"));
            }
            despachador = peticion.getRequestDispatcher("index.jsp");
            despachador.forward(peticion, respuesta);
                        
            }

            }
            
            
        } catch(ClientProtocolException ex){
            ex.printStackTrace();
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
