
import org.testng.annotations.Test;

public class FramesPageTest extends BaseTest {

    @Test
    void testFrames(){
        driver.get("https://demoqa.com/frames");
        framesPage.switchToFirstFrame().switchToSecondFrame();
    }
}
