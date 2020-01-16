package WebCrawler;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

public class WebCrawlerNode implements java.io.Serializable {
	
	// Base of the visited node
	private String baseNodeUrl;
	
	// Tokens of the parsed HTML file into Text format
	private Collection<String> textContentsTokens;
	
	// All links found in the base URL of this node from the HTML received
	private Collection<String> nodeUrlLinks;
	
	// It informs if the Node is valid or node. It is FALSE, it mean that failed to connect and retrieve the HTML data
	private boolean isBadURL = false;

	/**
	 *      Builds a Node Based on the URL that is being visited to extract the TEXT
	 * 
	 * @param newBaseUrl
	 */
	public WebCrawlerNode(String newBaseUrl) {
		this.baseNodeUrl = newBaseUrl;
		this.textContentsTokens = new ArrayList<String>();
		this.nodeUrlLinks = new ArrayList<String>();		
	}
	
	
	/**
	 * 
	 * 	Returns the Tokens from the parsed TEXT from the HTML
	 * 
	 * @return
	 */
	public Collection<String> getTextContentsTokens() {
		return this.textContentsTokens;
	}
	
	/**
	 * 
	 * 	Returns ALL the LINKs found in the Base URL of the Node. They will be added to the WebCrawler search depending on the Queue size limit.
	 * 
	 * @return
	 */
	public Collection<String> getNodeUrlLinks() {
		return this.nodeUrlLinks;
	}
	
	/**
	 * 
	 * @param stringToken
	 */
	public void addTextContentToken(String stringToken) {
		this.textContentsTokens.add(stringToken);
	}
	
	/**
	 * 
	 * @param stringUrlLink
	 */
	public void addNodeUrlLink(String stringUrlLink) {
		this.nodeUrlLinks.add(stringUrlLink);
	}	
	

	/**
	 * 
	 * @return
	 */
	public String getNodeBaseUrl() {
		return this.baseNodeUrl;
	}
	
	/**
	 * 
	 * 
	 * @param isBad
	 */
	public void setBadURL(boolean isBad) {
		this.isBadURL = isBad;
	}
	

	/**
	 * 
	 * @return
	 */
	public boolean isBadURL() {
		return this.isBadURL;
	}

}

