# Sentiment-Analysis-of-Twitter-Feed
This repository contains code to extract sentiment from twitter feed.
A topic is choosen, and tweets about that topic are sraped using the "MyTwitterScraper" tool.
Data is cleaned and tweets are extracted.
Sentiment of each tweet is extracted by extracting sentiment associated with each word in that tweet.
For extracting sentiment of each tweet, a dictionary of word_sentiment is used from
http://mpqa.cs.pitt.edu/lexicons/subj_lexicon/
Each tweet is classified in to positive or negative or neutral based on the sentiment of the words in that tweet.
After analyzing all the tweets, postivie sentiment percent and negative sentiment percent are calculated.

Application.
-----------
In this projet, tweets containing #DonaldTrump are extracted. The above mentioned model calculated the positive sentiment percent to 
be 37.7 and negative sentiment percent to be 62.2 
