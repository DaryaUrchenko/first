package html;

/**
 * Created by delr on 17.08.15.
 */
public class Html {
    static private final int refreshTime = 100000;

    static private String pagePart0 =  "<html>\n" +
            "<head>\n" +
            "<script type=\"text/javascript\">\n" +
                "function reload()\n{" +
                    "setInterval(function(){window.location.reload();}," + refreshTime +");\n" +
                "}\n"+

//                "function reloadPage() {\n" +
//                    "window.location.reload();\n" +
//                "}\n" +
            "</script>\n" +
            "</head>\n" +
            "<body onload=reload()>\n" +
            "<form action='/auth' enctype='text/plain' method='post'>\n" +
                "<p><input name='login' name='login'/> <input type='password' name='pass'/></p>" +
                "<p><input type='submit' value='select'/></p>\n" +
            "</form>"
            ;
    static private String PagePart1 = "<p>Your IdSession</p> ";


    static private String PagePart2 = "\n" +
            "</body>\n" +
            "</html>\n" +
            "\n" +
            "\n";


    public static String responsePage(String idSession) {
        return pagePart0 + PagePart1 + idSession + PagePart2;
    }
}
