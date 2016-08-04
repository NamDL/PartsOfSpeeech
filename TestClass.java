import static org.junit.Assert.*;
import org.junit.Test;


public class TestClass {
	@Test
	public void testText(){
		PageTagger pt= new PageTagger();
		assertEquals(pt.getText("http://cs-server.usc.edu:22045/sample-input.html"), ("A passenger plane has crashed shortly after take-off from Kyrgyzstan's capital, Bishkek, killing a large number of those on board. The head of Kyrgyzstan's civil aviation authority said that out of about 90 passengers and crew, only about 20 people have survived. The Itek Air Boeing 737 took off bound for Mashhad, in north-eastern Iran, but turned round some 10 minutes later.").replaceAll("[_]"," "));		
	}
	
	@Test
	public void testTag(){
		PageTagger pt= new PageTagger();
		assertEquals(pt.tagText(pt.getText("http://cs-server.usc.edu:22045/sample-input.html")),"A:Determiner passenger:Nouncomma singular or mass plane:Nouncomma singular or mass has:Verbcomma 3rd person singular present crashed:Verbcomma past participle shortly:Adverb after:Preposition or subordinating conjunction take-off:Nouncomma singular or mass from:Preposition or subordinating conjunction Kyrgyzstan:Proper nouncomma singular 's:Possessive ending capital:Nouncomma singular or mass comma:comma Bishkek:Proper nouncomma singular comma:comma killing:Verbcomma gerund or present participle a:Determiner large:Adjective number:Nouncomma singular or mass of:Preposition or subordinating conjunction those:Determiner on:Preposition or subordinating conjunction board:Nouncomma singular or mass .:sentence terminator The:Determiner head:Nouncomma singular or mass of:Preposition or subordinating conjunction Kyrgyzstan:Proper nouncomma singular 's:Possessive ending civil:Adjective aviation:Nouncomma singular or mass authority:Nouncomma singular or mass said:Verbcomma past tense that:Preposition or subordinating conjunction out:Preposition or subordinating conjunction of:Preposition or subordinating conjunction about:Preposition or subordinating conjunction 90:Cardinal number passengers:Nouncomma plural and:Coordinating conjunction crew:Nouncomma singular or mass comma:comma only:Adverb about:Preposition or subordinating conjunction 20:Cardinal number people:Nouncomma plural have:VBP survived:Verbcomma past participle .:sentence terminator The:Determiner Itek:Proper nouncomma singular Air:Proper nouncomma singular Boeing:Proper nouncomma singular 737:Cardinal number took:Verbcomma past tense off:RP bound:Verbcomma past participle for:Preposition or subordinating conjunction Mashhad:Proper nouncomma singular comma:comma in:Preposition or subordinating conjunction north-eastern:Adjective Iran:Proper nouncomma singular comma:comma but:Coordinating conjunction turned:Verbcomma past tense round:Nouncomma singular or mass some:Determiner 10:Cardinal number minutes:Nouncomma plural later:Adverb .:sentence terminator");
	}

}
