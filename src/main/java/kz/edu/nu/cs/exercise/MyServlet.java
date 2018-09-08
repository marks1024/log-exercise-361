package kz.edu.nu.cs.exercise;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = { "/myservlet" })

public class MyServlet extends HttpServlet {
   
    private static final long serialVersionUID = 1L;

    ArrayList<String> resList = new ArrayList<String>();


    public MyServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String resString = request.getRemoteHost() + " | " + request.getContextPath() + " | " + LocalDateTime.now().toString() + "\n";
        resList.add(resString); 

        for(int i=0; i<resList.size(); i++) {
            response.getWriter().append(resList.get(i));
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
