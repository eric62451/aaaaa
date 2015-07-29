import com.gargoylesoftware.htmlunit.BrowserVersion;
import java.io.File;
import java.io.IOException;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;


public class HtmlUnitExampleTestBase {
	protected HtmlPage currentPage;


	protected String getCurrentAsHtml(){
		return currentPage.getWebResponse().getContentAsString();
	}

	protected void setInput(String name, String value){
		HtmlInput element = currentPage.getElementByName(name);
		element.setValueAttribute(value);
	}

	protected void clickButton(String name) throws Exception {
		currentPage = ((HtmlSubmitInput)currentPage.getElementByName(name)).click();

	}

	public void openInBrowser() throws IOException {
		String filePath = "temp.html";
		currentPage.save(new File(filePath));
		Runtime.getRuntime().exec("explorer "+ filePath);
	}

	public static void main(String[] args) {
		try{
			WebClient webClient = new WebClient(BrowserVersion.FIREFOX_38);
			HtmlPage currentPage = webClient.getPage("http://www.fandango.com/");
//			HtmlTextInput zip = (HtmlTextInput)currentPage.getHtmlElementById("global-search-input");
//                        zip.setValueAttribute("94044");
//                        HtmlAnchor anc = (HtmlAnchor) currentPage.getAnchorByName("global-search-button");
//			System.out.println(anc.getHrefAttribute());
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
