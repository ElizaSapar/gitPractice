
import org.testng.annotations.Test;

public class LinksPageTest extends BaseTest {
    @Test
    void testLinksPage(){
        driver.get("https://demoqa.com/links");
        linksPage
                .clickToHomeLink()
                .clickToDynamicLink()
                .clickToCreateResponseBtn()
                .clickToNoContentResponseBtn()
                .clickToMovedResponseBtn()
                .clickToBadRequestBtn()
                .clickToUnauthorizedBtn()
                .clickToForbiddenBtn()
                .clickToInvalidBtn()
                .test();
    }
}
