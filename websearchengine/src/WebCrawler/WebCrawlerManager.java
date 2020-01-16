package WebCrawler;


import java.io.*;
import java.util.Collection;
import java.util.Iterator;

import resources.InvertedIndex;
import utilities.Util;

public class WebCrawlerManager {
	
	private static final String FILE_PREFIX = "WebCrawlerNodes";
	private static final String FILE_TYPE = ".ser";

	/**
	 * 
	 * 
	 * @param groupName
	 * @param nodes
	 * @return
	 * @throws IOException
	 */
	public static boolean saveWebCrawlerNode (String groupName, Collection<WebCrawlerNode> nodes) throws IOException {
		boolean saved = false; 
		FileOutputStream fileOut = new FileOutputStream(FILE_PREFIX + groupName + FILE_TYPE);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(nodes);
		out.close();
		fileOut.close();
		saved = true;
		Util.printDebug(true, "Serialization Done at: " + fileOut.toString());
		return saved;
	}
   
   
   /**
    * 
    * 
    * @param groupName
    * @return
    */
   public static Collection<WebCrawlerNode> loadWebCrawlerNodes (String groupName) throws IOException, ClassNotFoundException {
	   Collection<WebCrawlerNode> nodes = null;
	   FileInputStream fileIn = new FileInputStream(FILE_PREFIX + groupName + FILE_TYPE);
	   ObjectInputStream in = new ObjectInputStream(fileIn);
	   nodes = (Collection<WebCrawlerNode>) in.readObject();
	   in.close();
	   fileIn.close();    	  
       return nodes;
    }


   /**
    * 
    * @param groupName
    * @param nodes
    * @return
    * @throws IOException
    */
	public static boolean saveSerializableObject(String suffixName, Object objectToSave) throws IOException {
		boolean saved = false; 
		FileOutputStream fileOut = new FileOutputStream("C:/Users/khush/Documents/Courses/Advanced Computing/websearchengine/"+objectToSave.getClass().getSimpleName() + "-" + suffixName + FILE_TYPE);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(objectToSave);
		out.close();
		fileOut.close();
		saved = true;
		Util.printDebug(true, "Serialization Done at: " + fileOut.toString());
		return saved;
	}
	
   /**
	* 
	* 
	* 
	* 
	* @param groupName
	* @return
	*/
	public static Object loadSerializedObject (String suffixName, String className) throws IOException, ClassNotFoundException {
		Object loadedObject = null;
		System.out.println("Serialized Class File to open is: " + className + "-" + suffixName + FILE_TYPE);
		FileInputStream fileIn = new FileInputStream("C:/Users/khush/Documents/Courses/Advanced Computing/websearchengine/"+className + "-" + suffixName + FILE_TYPE);
		ObjectInputStream in = new ObjectInputStream(fileIn);
		loadedObject = in.readObject();
		System.out.println("Object loaded !! => " + loadedObject);
		in.close();
		fileIn.close();    	  
	    return loadedObject;
	}   

   
	/**
	 * 
	 * 
	 * @param args
	 * @throws InvalidURLException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		/**
		 *  Create an object WebCrawler and build  a list of LInks size N times based on the Constructor object
		 *  These LInks will be visited, their HTML will be parsed to TEXT and saved as tokens.
		 *  And then will QUEUE all links of this page. The limit of pages QUEUED is N
		 *  No link is visited Twice, it is guaranteed by a HashSet of links
		 */
		WebCrawler webCrawler = new WebCrawler(1000);
////		// Starts Crawling links based on a URL, in this case the W3G
		webCrawler.buildWebCrawl("https://en.wikipedia.org/wiki/Cristiano_Ronaldo");
//     	// Final number of nodes, that means, number of links and its text parsed into Tokens
		System.out.println("List size : " + webCrawler.getWebCrawledNodes().size());
		Collection<WebCrawlerNode> nodesMemory = webCrawler.getWebCrawledNodes();
		Iterator<WebCrawlerNode> it = nodesMemory.iterator();
		System.out.println(">>>>>>>>>> Will save Nodes to file!");
		WebCrawlerManager.saveSerializableObject("karan1000URL", webCrawler.getWebCrawledNodes());	
		System.out.println("############## Nodes save to file! #########################");
//		
		
		// This loads the Collections of Nodes from serialized Files directly into memory
		System.out.println("Now will load from file ...........");
		Collection<WebCrawlerNode> nodesSaved = (Collection<WebCrawlerNode>)WebCrawlerManager.loadSerializedObject("karan1000URL", "LinkedList");
		InvertedIndex obj = new InvertedIndex();
		obj.updatedloadData(nodesSaved);
   }
   
}

