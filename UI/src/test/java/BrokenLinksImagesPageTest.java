
import org.testng.annotations.Test;

public class BrokenLinksImagesPageTest extends BaseTest {
    @Test
    void test(){
        driver.get("https://demoqa.com/broken");
        brokenLinksImagesPage.clickToValidLink().clickToBrokenLink().test();
    }
}
