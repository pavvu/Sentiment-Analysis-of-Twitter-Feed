import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ReadTweets 
{
	public static void main(String[] args) throws Exception
	{
		String corpusFile = "trump.csv";
		BufferedReader br = new BufferedReader(new FileReader(corpusFile));
		String line="", word = "", sentiment = "";
		line = br.readLine();
		ArrayList<String> tweets = new ArrayList<>();
		int count =0;
			while(line!=null)
			{
				try
				{
					line = line.split(",")[3];
					line = line.toLowerCase();
					tweets.add(line);
					count+=1;
				}
				catch(Exception e)
				{
					//System.out.println("error "  + " " + count);
				}
				line = br.readLine();
			}
		br.close();
		
		// sentiment
		HashMap<String, Integer> word_sentiment = ReadCorpus.getWordSentiment();
		int score =0;
		count =0;
		int tweet_Count = tweets.size();
		float positive_tweets = 0;
		float negative_tweets = 0;
		for (String tweet : tweets) 
		{
			score=0;
			count+=1;
			for (String word1 : tweet.split(" ")) 
			{
				if(word_sentiment.containsKey(word1))
				{
					score = score + word_sentiment.get(word1);
				}
			}
			if(score > 1)
				positive_tweets+=1;
			if(score<0)
				negative_tweets+=1;
		}
		float negative = (negative_tweets/(positive_tweets +negative_tweets))*100;
		float postive = 100 - negative;
		System.out.println("negative " + negative_tweets + " " + "positive " + positive_tweets);
		System.out.println("positive sentiment " + postive + " negative sentiment " + negative);
	}
}
