
import org.testng.annotations.Test;

public class TextBoxPageTest extends BaseTest {

    @Test
    void fillUpTheFormTest(){
        driver.get("https://demoqa.com/text-box");
        textBoxPage
                .fillUpTheFullName("Elbob Elbobov")
                .fillUpTheEmailName("elbob@gmail.com")
                .fillUpTheCurrentAddress("2 bob, Bishkek")
                .fillUpThePermanentAddress("2 bob, Bishkek")
                .submitForm().testTexBoxForm();

    }

}
