package com.digital.pages;

import com.digital.models.Student;
import com.digital.utils.FakeDataProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.*;

public class PracticeFormPage extends BasePage {
    @FindBy(id = "firstName")
    public WebElement firstNameInput;
    @FindBy(id = "lastName")
    public WebElement lastNameInput;
    @FindBy(id = "userEmail")
    public WebElement emailInput;
    @FindBy(xpath = "//div[contains(@class, 'custom-radio')]//label[@class='custom-control-label']")
    public List<WebElement> radioGenderButtons;
    @FindBy(id = "userNumber")
    public WebElement mobilePhoneInput;
    @FindBy(id = "dateOfBirthInput")
    public WebElement openToCalendarInput;
    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    public WebElement selectMonthList;
    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    public WebElement selectYearList;
    @FindBy(xpath = "//div[@class='react-datepicker__month']//div[contains(@class, 'react-datepicker__day')]")
    public List<WebElement> selectDayList;
    @FindBy(id = "subjectsInput")
    public WebElement subjectInputForSetText;
    @FindBy(xpath = "//div[@id='subjectsContainer']/div[2]")
    public List<WebElement> subjectList;
    @FindBy(xpath = "//div[@id='hobbiesWrapper']//label[@class='custom-control-label']")
    public List<WebElement> hobbiesCheckboxList;
    @FindBy(id = "uploadPicture")
    public WebElement uploadPictureInput;
    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;
    @FindBy(xpath = "//div[@id='state']//div[@aria-hidden='true']")
    public WebElement inputOpenState;
    @FindBy(id = "react-select-3-input")
    public WebElement inputForSetText;
    @FindBy(id = "react-select-4-input")
    public WebElement inputForSetCity;
    @FindBy(id = "submit")
    public WebElement sendFormBtn;
    @FindBy(xpath = "//td[text()='Student Name']/../td[2]")
    public WebElement expectedFirstName;


//    @FindBy(xpath = "//div[@id='state']//div[2]")
//    public List<WebElement> containerForStateTexts;

    ////////////////////////////////////////////////////////////
    @FindBy(xpath = "//td[text()='Student Email']/../td[2]")
    public WebElement expectedEmail;
    @FindBy(xpath = "//td[text()='Gender']/../td[2]")
    public WebElement expectedGender;
    @FindBy(xpath = "//td[text()='Mobile']/../td[2]")
    public WebElement expectedMobilePhone;
    @FindBy(xpath = "//td[text()='Date of Birth']/../td[2]")
    public WebElement expectedDate;
    @FindBy(xpath = "//td[text()='Subjects']/../td[2]")
    public WebElement expectedSubjects;
    @FindBy(xpath = "//td[text()='Hobbies']/../td[2]")
    public WebElement expectedHobbies;
    @FindBy(xpath = "//td[text()='Picture']/../td[2]")
    public WebElement expectedPicture;
    @FindBy(xpath = "//td[text()='Address']/../td[2]")
    public WebElement expectedAddress;
    @FindBy(xpath = "//td[text()='State and City']/../td[2]")
    public WebElement expectedStateAndCity;
    Map<String, String> userDatas;

    public PracticeFormPage generateAndFillUserData() {
        userDatas = new HashMap<>();

        String firstName = FakeDataProvider.generateFakeFirstName();
        userDatas.put("firstName", firstName);
        fillUpTheFirstName(firstName);

        String lastName = FakeDataProvider.generateFakeLastName();
        userDatas.put("lastName", lastName);
        fillUpTheLastName(lastName);

        String email = FakeDataProvider.generateFakeEmail();
        userDatas.put("email", email);
        fillUpTheEmail(email);

        String mobilePhone = FakeDataProvider.generateMobilePhone();
        userDatas.put("mobilePhone", mobilePhone);
        fillUpMobilePhoneInput(mobilePhone);

        String address = FakeDataProvider.generateFakeUserCurrentAddress();
        userDatas.put("address", address);
        fillUpCurrentAddressInput(address);
        return this;
    }


    public PracticeFormPage fillUpTheFirstName(String txt) {
        elementActions.writeText(firstNameInput, txt);
        return this;
    }

    public PracticeFormPage fillUpTheLastName(String txt) {
        elementActions.writeText(lastNameInput, txt);
        return this;
    }

    public PracticeFormPage fillUpTheEmail(String txt) {
        elementActions.writeText(emailInput, txt);
        return this;
    }

    public PracticeFormPage clickGender() {
        elementActions.clickToRandomElement(radioGenderButtons);
        return this;
    }

    public PracticeFormPage fillUpMobilePhoneInput(String txt) {
        elementActions.writeText(mobilePhoneInput, txt);
        return this;
    }

    public PracticeFormPage selectDateOfBirthInput() {
        elementActions.clickElement(openToCalendarInput);
        elementActions.selectRandomInSelect(selectMonthList);
        elementActions.selectRandomInSelect(selectYearList);
        elementActions.clickToRandomElement(selectDayList);
        return this;
    }

    public PracticeFormPage selectSubject() {
        Random random = new Random();
        String[] randomChar = new String[]{"A", "S", "D", "G", "H", "L", "C", "V", "B", "N", "M", "E", "R", "T", "Y", "U", "I", "O", "P"};
        int randomIndex = random.nextInt(randomChar.length);
        String randomLetter = randomChar[randomIndex];
        elementActions.writeText(subjectInputForSetText, randomLetter);
        for (WebElement el : subjectList) {
            elementActions.waitElementToBeVisible(el);
        }
        elementActions.clickToRandomElement(subjectList);
        return this;
    }

    public PracticeFormPage clickHobbies() {
        elementActions.clickToRandomElement(hobbiesCheckboxList);
        return this;
    }

    public PracticeFormPage uploadPictureInput() {
        elementActions.writeText(uploadPictureInput, "C:\\Users\\Asus\\Downloads\\kitty.jpg");
        return this;
    }

    public PracticeFormPage fillUpCurrentAddressInput(String txt) {
        elementActions.writeText(currentAddressInput, txt);
        return this;
    }

    public PracticeFormPage selectState() {
        elementActions.scrollToTheElement(inputOpenState);
        elementActions.clickElement(inputOpenState);
        Map<String, String[]> stateAndCityList = new HashMap<>();
        stateAndCityList.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        stateAndCityList.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        stateAndCityList.put("Haryana", new String[]{"Karnal", "Panipat"});
        stateAndCityList.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
        Random random = new Random();
        String randomKey = new ArrayList<>(stateAndCityList.keySet()).get(random.nextInt(stateAndCityList.size()));
        String randomCity = stateAndCityList.get(randomKey)[random.nextInt(stateAndCityList.get(randomKey).length)];

        elementActions.setTextAndEnterElement(inputForSetText, randomKey);
        elementActions.setTextAndEnterElement(inputForSetCity, randomCity);

        return this;
    }

    public PracticeFormPage sendForm() {
        elementActions.clickByJS(sendFormBtn);
        return this;
    }

    public PracticeFormPage fillUpTheForm(Student student){
        fillUpTheFirstName(student.getFirstName())
                .fillUpTheLastName(student.getLastName())
                .fillUpTheEmail(student.getEmail())
                .clickGender()
                .fillUpMobilePhoneInput(student.getMobileNumber())
                .selectDateOfBirthInput()
                .selectSubject()
                .clickHobbies()
                .uploadPictureInput()
                .fillUpCurrentAddressInput(student.getCurrentAddress())
                .selectState()
                .sendForm();
        return this;
    }


    public PracticeFormPage checkStudentDatas(Student student) {
        Assert.assertTrue(expectedFirstName.getText().contains(student.getFirstName()));
        Assert.assertTrue(expectedEmail.getText().contains(student.getEmail()));
        Assert.assertNotNull(expectedGender.getText());
        Assert.assertTrue(expectedMobilePhone.getText().contains(student.getMobileNumber()));
        Assert.assertNotNull(expectedDate.getText());
        Assert.assertNotNull(expectedSubjects.getText());
        Assert.assertNotNull(expectedHobbies.getText());
        Assert.assertNotNull(expectedPicture.getText());
        Assert.assertTrue(expectedAddress.getText().contains(student.getCurrentAddress()));
        Assert.assertNotNull(expectedStateAndCity.getText());
        return this;
    }

}
