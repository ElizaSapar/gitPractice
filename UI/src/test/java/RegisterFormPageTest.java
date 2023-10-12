
import com.digital.models.Person;
import org.testng.annotations.Test;

public class RegisterFormPageTest extends BaseTest {

    @Test
    void fillUpTheFormTest() throws InterruptedException {
        driver.get("https://demoqa.com/register");
        Person person = fakeDataProvider.createFakeUser();
        loginPage.clickToRecaptcha();

    }





}
