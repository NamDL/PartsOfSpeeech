import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;


public class SpeechTagger {

	public static void main(String[] args) throws IOException {
		String url="<h1>abc_def<h1>";
		//String html = (Jsoup.connect(url).maxBodySize(0).timeout(90000000).get().html());
		//System.out.println(html);
        Document doc = Jsoup.parse(url);

        String text = (doc.body().text());
        System.out.println(text);
        
	}

}
