package Servlet_learn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by fupeng on 2017/4/17.
 */
public class Helloo extends HttpServlet {
    private String msg;

    public void init() throws ServletException{
        msg = "hello world ff";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print(msg);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
