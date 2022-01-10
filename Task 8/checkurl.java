import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.Desktop;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class checkurl {
	public static void main( String[] args ) throws IOException{ 
		File html = new File("C:/Users/Niketha/OneDrive/Documents/check.html");
        Document doc = Jsoup.parse(html, null);
		
        String para = doc.select("body").text();
        Element paragraph = doc.select("body").first();
        Elements links = doc.select("a[href]");  
        for (Element link : links) {  
            System.out.println("\nlink : " + link.attr("href"));  
            System.out.println("text : " + link.text()); 
            String hyperPattern = link.text();
            Pattern p = Pattern.compile(hyperPattern);
            String color="yellow";
            String highlight_l = " <span style= \"background-color: "+color+"\" >";
            String highlight_r = "</span> </a>";

            Matcher match = p.matcher(para);

            while(match.find()) {
               String m = match.group();
                if(para.contains(m))
                    para = para.replace(m, "<a href="+m+">"+highlight_l + m + highlight_r);
            }
            paragraph.html(para);
            System.out.println(doc.toString());

            File html_ = new File("homecopy2.html");
            FileWriter w = new FileWriter("homecopy2.html");
            w.write(String.valueOf(doc));
            w.close();
            Document doc_ = Jsoup.parse(html_, null);

            Desktop.getDesktop().browse(html_.toURI());
        }  
	}
}
