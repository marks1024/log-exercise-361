package kz.edu.nu.cs.exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/myservlet" })
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MyServlet() {
        super();
    }
    List<String> connections = new ArrayList<>();


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.getWriter().append("Served at: ").append(request.getContextPath());
        PrintWriter out = response.getWriter();
        Date time = new Date();
        String df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(time);
        String record = df + "||" + request.getRemoteHost() + "||" + request.getContextPath() + "\n" ;
        out.append("Here is the list:\n");
        connections.add(record);
        for(int i = 0; i < connections.size(); i++) {
            out.append(connections.get(i));
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
