
import org.testng.annotations.Test;

public class CheckBoxPageTest extends BaseTest {
    @Test
    void test(){
        driver.get("https://demoqa.com/checkbox");
        String[] titleTxt = new String[]{"home", "desktop", "notes", "commands", "documents", "workspace", "react", "angular",
                "veu", "office", "public", "private", "classified", "general", "downloads", "wordFile", "excelFile"
        };
        checkBoxPage
                .openAllPackage()
                .selectedCheckbox()
                .testCheckBoxTitle(titleTxt);
    }
}
