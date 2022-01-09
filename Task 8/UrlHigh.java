import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Text;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlHigh {
    void findHyper(String url, String color) throws IOException, URISyntaxException {
        File html = new File(url);
        Document doc = Jsoup.parse(html, null);
        String para = doc.select("body").text();
        System.out.println(para);
        Element paragraph = doc.select("body").first();
        System.out.println(paragraph.text());
        String hyperPattern = "(http(s))://?.(www).[-a-zA-Z0-9@:%.+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%+.~#?&//=]*)?";
        Pattern p = Pattern.compile(hyperPattern);
        String highlight_l = " <span style= \"background-color: "+color+"\" >";
        String highlight_r = "</span> </a>";

        Matcher match = p.matcher(para);

        while(match.find()) {
           String m = match.group();
          //  System.out.println(m);
       // }*/
            if(para.contains(m))
                para = para.replace(m, "<a href="+m+">"+highlight_l + m + highlight_r);
        }
        //System.out.println(para);
        paragraph.html(para);
        System.out.println(doc.toString());

        File html_ = new File("homecopy.html");
        FileWriter w = new FileWriter("homecopy.html");
        w.write(String.valueOf(doc));
        w.close();
        Document doc_ = Jsoup.parse(html_, null);

        Desktop.getDesktop().browse(html_.toURI());
        //System.out.println(paragraph);*/
    }
    public static void main(String[] args) throws IOException, URISyntaxException {
        UrlHigh h = new UrlHigh();
        h.findHyper("C:/Users/dineshan.p/Documents/Mobius/url1.html", "yellow");
        System.out.println("Done");
    }
}
