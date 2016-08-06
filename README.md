README.txt


This program is used to find and tag different parts of speech. The user provides an URL as input. This URL is parsed and the data in the body tag is extracted. This extracted data is then sent to the tagger, so different parts of speech can be tagged.


Running the Program:
The java class PageTagger takes in two command line argument:
a) The first one is the link to site that needs to parsed and whose data needs to tagged.
b)The second one is the location of tthe file where the tagged data needs to be written.

The libraries used in this program are as follows:
Jsoup 1.9.2
Stanford PosTagger
