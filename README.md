# Web Search Engine

This application is built using JAVA, JS, BootStrap and Jquery.
The Application consists of below functionalities:
Web Crawler - which is gathering the string tokens from a URL recursively. Currently, we have limited the scope of URL crawling to be 10,000. But can easily be changed.
Inverted Index - We have used the inverted Index to store the Data Dictionary from Web Crawler Output. This is implemented using Trie(for Data Dictionary) and HashMap(Occurrences of Strings in a URL).
Ranking of Webpages: QuickSelect Algorithm is used to rank the top 5 web pages for the searched String.
Autocompletion of words using Trie.
Correct Word recommendation using EDIT Distance Algorithm. Currently, we are recommending the words from Data Dictionary which are 1 edit distance away from the User's Searched word.
