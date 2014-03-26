/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.feu.eac;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.lucene.demo.IndexFiles;
import pitt.search.semanticvectors.FlagConfig;
import pitt.search.semanticvectors.LSA;
import pitt.search.semanticvectors.Search;
import pitt.search.semanticvectors.VectorStoreTranslater;

/**
 *
 * @author Simaco.Menzon
 */
public class Controller extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
        
        if (request.getParameter("submit") != null && request.getParameter("submit").equals("Submit")) {
            String text =  request.getParameter("input");
            PrintWriter out = response.getWriter();
            FlagConfig defaultFlagConfig = FlagConfig.getFlagConfig(null);

            String DEFAULT_VECTOR_FILE = "src/test/resources/termvectors.bin";
            
            List<String> strlist = new ArrayList<String>();
            strlist.add("-searchvectorfile");
            strlist.add("docvectors.bin");
            
            String[] st = text.split("\\s");
            for(String s : st){
                strlist.add(s);
            }
            String[] strarray = strlist.toArray(new String[0]);
            Search.main(strarray);
            out.println(text); 
        }
        
        if (request.getParameter("train") != null && request.getParameter("train").equals("Train")) {
            FlagConfig defaultFlagConfig = FlagConfig.getFlagConfig(null);
            String[] indexString = {"-docs", "C:\\Users\\Simaco.Menzon\\Documents\\NetBeansProjects\\SVectorTest\\corpus", "-index", "C:\\Users\\Simaco.Menzon\\Documents\\NetBeansProjects\\SVectorTest\\index"};
            IndexFiles.main(indexString);
            PrintWriter out = response.getWriter();
            String[] lsaString = {"-termweight", "idf", "-minfrequency", "2", "-luceneindexpath", "C:\\Users\\Simaco.Menzon\\Documents\\NetBeansProjects\\SVectorTest\\index"};
            LSA.main(lsaString);
            
            VectorStoreTranslater.main(new String[] {"-lucenetotext", "termvectors.bin","termvectorsCheck.txt"});
            VectorStoreTranslater.main(new String[] {"-lucenetotext", "docvectors.bin","docvectorsCheck.txt"});
            
            out.println("training..");
        }
              
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
