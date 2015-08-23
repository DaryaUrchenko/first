package main;

/**
 * Created by delr on 16.08.15.
 */

import frontend.Frontend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import html.Html;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main  {

//    public void handle(String target,
//                       Request baseRequest,
//                       HttpServletRequest request,
//                       HttpServletResponse response)
//    throws IOException, ServletException
//    {
//        response.setContentType("text/html;charset=utf-8");
//        response.setStatus(HttpServletResponse.SC_OK);
//        baseRequest.setHandled(true);
//        response.getWriter().println(Html.responsePage());
//    }

    public static void main(String[] args) throws Exception   {
        Frontend frontend = new Frontend();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(frontend), "/authform");
        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        server.join();
    }
}