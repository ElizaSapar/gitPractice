
import org.testng.annotations.Test;

public class ButtonsPageTest extends BaseTest {
    @Test
    void test(){
        driver.get("https://demoqa.com/buttons");
        buttonsPage.makeDoubleClick().makeRightClick().makeSimpleClick().testButtons();
    }
}
