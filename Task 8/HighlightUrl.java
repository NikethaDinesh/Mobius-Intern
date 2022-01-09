import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//import java.awt.Desktop;
import java.io.*;

import java.net.URISyntaxException;

import java.util.regex.*;
import java.awt.*;

public class HighlightUrl {

	public static void main(String[] args)throws IOException ,URISyntaxException{
		
		File html=new File("C:/Users/dineshan.p/Documents/Mobius/urlfile.html");
		
		Document doc=Jsoup.parse(html, null);
		
		Elements htmlfile=doc.select("body");
		
		String para=doc.select("body").text();
	//	System.out.println(doc.toString());
		
		String expression="https://www.[a-z0-9A-Z]{1,256}\\\\.[a-zA-Z0-9]{1,6}";
		Pattern pattern=Pattern.compile(expression);
		Matcher m=pattern.matcher(para);
		if(para.matches(expression)) {		System.out.println("yes");
		}else {
			System.out.println("no");
		}
		
		String high_l="<span style=\"background-color:yellow;\">";
		String high_r="</span></a>";
		while(m.find()) {
			String match=m.group();
			
			if(para.matches(match)) {
				//para=para.replace(match,"<a href="+match+">" +high_l+match+high_r);
				System.out.println("yes");
		}else {
			System.out.println("no");
		}
		}
		
		htmlfile.html(para);
		
		//System.out.println(doc.toString());	
		File html_write=new File("C://Users//dineshan.p//Documents//newfile.html");
		
		
		FileWriter w=new  FileWriter("C://Users//dineshan.p//Documents//newfile.html");
		w.write(String.valueOf(doc));
		w.close();
		Document doct=Jsoup.parse(html_write, null);
		//Desktop.getDesktop().browse(html_write.toURI());
	//System.out.println(doct.toString());
	}
}

