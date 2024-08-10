package tests;

import websearch.WebCrawler;

/** Test program for WebCrawler class*/
public class TestWebCrawler {

	/**Crawl acm.org or the 110 textbook author's site and find 10 
	 * subULRs.
	 * @param args
	 */
	public static void main(String[] args) {
            //String URLString = "https://www.acm.org";
            String URLString = "https://www.rwu.edu";

            WebCrawler w = new WebCrawler(URLString);
            w.setMaxURLs(10);
            w.crawlAndPrint();
                
	}

}
