
import com.digital.models.Student;
import org.testng.annotations.Test;

public class PracticePageFormTest extends BaseTest {

    @Test
    void fillUpTheFormTest() {
        driver.get("https://demoqa.com/automation-practice-form");
        Student student = fakeDataProvider.createFakeStudent();
        practiceFormPage.fillUpTheForm(student).checkStudentDatas(student);
    }





}