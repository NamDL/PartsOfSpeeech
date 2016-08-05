import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;


public class PageTagger {
	static MaxentTagger tagger = new MaxentTagger("D:/Speech Tagging/stanford-postagger-2015-12-09/models/english-left3words-distsim.tagger");
	
	public static void main(String[] args) throws IOException {
		String url=args[0];
		PageTagger pageTagger= new PageTagger();
		String[] arr= (pageTagger.getText(url)).split("\\.");
		Map<String,String> map=pageTagger.mapping();		
		StringBuilder sb= new StringBuilder();
		for (String string : arr) {
			String taggedSentence=(pageTagger.tagText(string+"."));
			String[] words=taggedSentence.split(" ");
			for (String wrd : words) {
				if(wrd.contains("_")){
					System.out.println(wrd);
					String[] split=wrd.split("_");
					String pos=split[split.length-1];
					System.out.println(pos);
					sb.append(split[0]).append(":").append(map.get(pos.replaceAll("\\s+",""))).append(" ");
				}
			}									
		}
		FileWriter fw=new FileWriter(args[1]);
		fw.write(sb.toString());	
		fw.close();
	}
	
	/*tagText returns a String that contains the POS tagged for the input String*/
	
	String tagText(String inputStr){
		return (tagger.tagString(inputStr));
	}
	
	/*getText function makes use of the JSoup library in order to parse the web page denoted 
	 * by the string value: url. This function returns the text data present within the body
	 * tag of the html*/
	
	String getText(String url){
		Document doc = null;
        try {
	        	doc = Jsoup.connect(url)
	                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
	                    .maxBodySize(0)
	                    .get();
        } catch (IOException e) {
            System.out.println("Error in extracting text");
        }
        return (doc.body().text().replaceAll("[_]"," "));
    
	}
	
	/*This function creates a map with key as the symbol of the POS in (Penn) Treebank Tag-set 
	 * as returned by tagString function. The value associated with each key is name of the POS
	 * the key represents. 
	 * 
	 * Example: JJ -> Adjective
	 */
	
	Map<String,String> mapping(){
		Map<String,String> map= new HashMap<String, String>();
		map.put("$", "dollar");
		map.put("``", "opening quotation mark");
		map.put("''", "closing quotation mark");
		map.put("(", "opening parenthesis");
		map.put(")", "closing parenthesis");
		map.put(",", "comma");
		map.put("--", "DASH");
		map.put(".", "sentence terminator");
		map.put(":", "colon or ellipsis");
		map.put("CC", "Coordinating conjunction");
		map.put("CD", "Cardinal number");
		map.put("DT", "Determiner");
		map.put("EX", "Existential there");
		map.put("FW", "Foreign word");
		map.put("IN", "Preposition or subordinating conjunction");
		map.put("JJ", "Adjective");
		map.put("JJR", "Adjective, comparative");
		map.put("JJS", "Adjective, superlative");
		map.put("LS", "List item marker");
		map.put("MD", "Modal");
		map.put("NN", "Noun, singular or mass");
		map.put("NNS", "Noun, plural");
		map.put("NNP", "Proper noun, singular");
		map.put("NNPS", "Proper noun, plural");
		map.put("PDT", "Predeterminer");
		map.put("POS", "Possessive ending");
		map.put("PRP", "Personal pronoun");
		map.put("PRP$", "Possessive pronoun");
		map.put("RB", "Adverb");
		map.put("RBR", "Adverb, comparative");
		map.put("RBS", "Adverb, superlative");
		map.put("RP", "Particle");
		map.put("SYM", "Symbol");
		map.put("TO", "to");
		map.put("UH", "Interjection");
		map.put("VB", "Verb, base form");
		map.put("VBD", "Verb, past tense");
		map.put("VBG", "Verb, gerund or present participle");
		map.put("VBN", "Verb, past participle");
		map.put("VBP", "Verb, non­3rd person singular present");
		map.put("VBZ", "Verb, 3rd person singular present");
		map.put("WDT", "Wh­determiner");
		map.put("WP", "Wh­pronoun");
		map.put("WP$", "Possessive wh­pronoun");
		map.put("WRB", "Wh­adverb");
		return map;
	}
	
	//Class written for testing purposes
	
	public static String test(String html){
		PageTagger pageTagger= new PageTagger();
		Map<String,String> map=pageTagger.mapping();		
		StringBuilder sb= new StringBuilder();
		String[] arr= (pageTagger.getText(html)).split("\\.");
		for (String string : arr) {
			String taggedSentence=(pageTagger.tagText(string+"."));
			String[] words=taggedSentence.split(" ");
			for (String wrd : words) {
				if(wrd.contains("_")){
					String[] split=wrd.split("_");
					String pos=split[split.length-1];
					sb.append(split[0]).append(":").append(map.get(pos.replaceAll("\\s+",""))).append(" ");
				}
			}									
		}
		return sb.toString();
	}
}
