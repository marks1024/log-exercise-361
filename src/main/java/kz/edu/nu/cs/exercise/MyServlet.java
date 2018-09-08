package kz.edu.nu.cs.exercise;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@WebServlet(urlPatterns = { "/myservlet" })
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static ArrayList<String> log;
    public MyServlet() {
        super();
        log = new ArrayList<>();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DateFormat date = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");
        String dt = date.format(new Date());
        String res = dt + "Host:" + request.getRemoteHost() + "Path" + request.getContextPath();

        log.add(res);
        for (String l : log) {
            response.getWriter().append(l).append("\n");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
