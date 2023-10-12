import org.testng.annotations.Test;

public class AlertsPageTest extends BaseTest {

    @Test
    void  testAlertsPage(){
        driver.get("https://demoqa.com/alerts");
        alertsPage.clickBtnToSeeAlert().clickWithTimer().clickToConfirm().clickToWriteInPromt("hello world!");
    }

}
