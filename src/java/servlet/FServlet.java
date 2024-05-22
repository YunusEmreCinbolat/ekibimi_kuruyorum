/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import beans.DosyaController;
import entity.Dosya;
import jakarta.inject.Inject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.nio.file.Files;

/**
 *
 * @author Dell
 */
@WebServlet(name = "fileservlet", urlPatterns = {"/file/*"})
public class FServlet extends HttpServlet {

 
    @Inject
    private DosyaController controller;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{    
        String path= request.getPathInfo();
        String[] id= path.split("/");
        Long fileId= Long.valueOf(id[1]);
        Dosya d = controller.readDosya(fileId);
        File f = new File(d.getFpath()+d.getFname());
        Files.copy(f.toPath(), response.getOutputStream());
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
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
