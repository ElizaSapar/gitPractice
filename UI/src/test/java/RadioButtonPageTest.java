
import org.testng.annotations.Test;

public class RadioButtonPageTest  extends BaseTest {

    @Test
    void test(){
        driver.get("https://demoqa.com/radio-button");
        radioButtonPage.clickYesBtn().clickNoBtn().clickNoRadioBtn().testPage();
    }
}
