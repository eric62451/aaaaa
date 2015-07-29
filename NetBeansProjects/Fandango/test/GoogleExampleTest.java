
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.WebAssert;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;

public class GoogleExampleTest extends HtmlUnitExampleTestBase  {


	@Before
	public void setup() {
		try{
			goToGoogle();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void testThatIAmTheFirstInGoogle() {
		try{

			search("aviyehuda");

			String result = getFirstResult();
			assertTrue(result.contains("aviyehuda.com"));
		}
		catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

	private void goToAdvancedSearch() throws Exception{
		HtmlAnchor advancedSearchAn = currentPage.getAnchorByText("Advanced Search");
		currentPage = advancedSearchAn.click();
		WebAssert.assertTitleEquals(currentPage,"Google Advanced Search");
	}

	private String getFirstResult() {
		HtmlElement element = (HtmlElement)currentPage.getByXPath("//h3").get(0);
		DomNode result = element.getChildNodes().get(0);
		return result.toString();
	}


	private void search(String query) throws Exception {
		setInput("q",query);
		clickButton("btnG");
		WebAssert.assertTitleEquals(currentPage, query + " - Google Search");
	}


	private void goToGoogle() throws Exception {
		WebClient webClient = new WebClient();
		currentPage = webClient.getPage("http://www.google.com/");
		WebAssert.assertTitleEquals(currentPage,"Google");
	}

}
