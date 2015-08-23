package frontend;


import html.Html;
import templates.PageGenerator;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by delr on 19.08.15.
 */
public class Frontend extends HttpServlet{

    public String login = "";

//    private String idSession ="";

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

//        idSession = request.getParameter("idSession");
        response.setContentType("text/html;charset=utf-8");

        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("lastLogin", login== null ? "" : login);
        response.getWriter().println(PageGenerator.getPage("authform.html", pageVariables));


        response.setStatus(HttpServletResponse.SC_OK);

//        if( idSession == null || idSession.isEmpty()) {
//            idSession = "ura";
//            response.getWriter().println(Html.responsePage(idSession));
//        }
//        else
//            response.getWriter().println();
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws  ServletException, IOException {

//        idSession = request.getParameter("idSession");
        login = request.getParameter("login");

        response.setContentType("text/html;charset=utf-8");

        if( login == null || login.isEmpty())
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        else
            response.setStatus(HttpServletResponse.SC_OK);

//        if( idSession == null || idSession.isEmpty()) {
//            idSession = "sqrt";
//            response.getWriter().println(Html.responsePage(idSession));
//        }
//        else{
//            idSession = "sqrt32";
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("lastLogin", login== null ? "" : login);
        response.getWriter().println(PageGenerator.getPage("authform.html", pageVariables));

    }
}
