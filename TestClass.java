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
		assertEquals(PageTagger.test("http://cs-server.usc.edu:22045/sample-input.html"),"A:Determiner passenger:Noun, singular or mass plane:Noun, singular or mass has:Verb, 3rd person singular present crashed:Verb, past participle shortly:Adverb after:Preposition or subordinating conjunction take-off:Noun, singular or mass from:Preposition or subordinating conjunction Kyrgyzstan:Proper noun, singular 's:Possessive ending capital:Noun, singular or mass ,:comma Bishkek:Proper noun, singular ,:comma killing:Verb, gerund or present participle a:Determiner large:Adjective number:Noun, singular or mass of:Preposition or subordinating conjunction those:Determiner on:Preposition or subordinating conjunction board:Noun, singular or mass .:sentence terminator The:Determiner head:Noun, singular or mass of:Preposition or subordinating conjunction Kyrgyzstan:Proper noun, singular 's:Possessive ending civil:Adjective aviation:Noun, singular or mass authority:Noun, singular or mass said:Verb, past tense that:Preposition or subordinating conjunction out:Preposition or subordinating conjunction of:Preposition or subordinating conjunction about:Preposition or subordinating conjunction 90:Cardinal number passengers:Noun, plural and:Coordinating conjunction crew:Noun, singular or mass ,:comma only:Adverb about:Preposition or subordinating conjunction 20:Cardinal number people:Noun, plural have:Verb, non­3rd person singular present survived:Verb, past participle .:sentence terminator The:Determiner Itek:Proper noun, singular Air:Proper noun, singular Boeing:Proper noun, singular 737:Cardinal number took:Verb, past tense off:Particle bound:Verb, past participle for:Preposition or subordinating conjunction Mashhad:Proper noun, singular ,:comma in:Preposition or subordinating conjunction north-eastern:Adjective Iran:Proper noun, singular ,:comma but:Coordinating conjunction turned:Verb, past tense round:Noun, singular or mass some:Determiner 10:Cardinal number minutes:Noun, plural later:Adverb .:sentence terminator ");
	}

}
