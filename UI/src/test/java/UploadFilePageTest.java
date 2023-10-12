
import org.testng.annotations.Test;

public class UploadFilePageTest extends BaseTest {
    @Test
    void test(){
        driver.get("https://demoqa.com/upload-download");
        uploadFilePage.clickToUploadInput().test();
    }
}
