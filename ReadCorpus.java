import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class ReadCorpus 
{
	public static HashMap<String, Integer> getWordSentiment() throws Exception 
	{
		String corpusFile = "subjclueslen1-HLTEMNLP05.tff";
		BufferedReader br = new BufferedReader(new FileReader(corpusFile));
		String line="", word = "", sentiment = "";
		line = br.readLine();
		HashMap<String, Integer> word_sentiment = new HashMap<>();
		int index1, index2, sentiscore=0;	
		while(line!=null)
		{	
			index1 = line.indexOf("word1=")+6;
			index2 = line.indexOf("pos1=")-1;
			word = line.substring(index1, index2);
			index1 = line.lastIndexOf("=")+1;
			sentiment = line.substring(index1);
			switch(sentiment)
			{
				case "positive":
					sentiscore =1;
					break;
				case "negative":
					sentiscore =-1;
					break;
				case "neutral":
					sentiscore =0;
					break;
			}
			word_sentiment.put(word, sentiscore);
			line = br.readLine();
		}
		br.close();
		return word_sentiment;
	}
}
