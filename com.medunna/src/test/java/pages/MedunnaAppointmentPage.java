package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class MedunnaAppointmentPage {
    public MedunnaAppointmentPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//a[@class='btn btn-primary btn-sm']") public WebElement edit;


    @FindBy(xpath="//textarea[@id='appointment-anamnesis']") public WebElement anamnesis;
    @FindBy(xpath="//textarea[@id='appointment-treatment']") public WebElement treatment;
    @FindBy(xpath="//textarea[@id='appointment-diagnosis']") public WebElement diagnosis;
    @FindBy(xpath="/html/body/div/div/div/div[4]/div/div/div/div[3]/div/form/button") public WebElement save;
    @FindBy( xpath= "//select[@class = 'form-control is-touched is-dirty av-valid form-control']") public WebElement statusCompleted;


    @FindBy(xpath="//td[normalize-space()='135183']") public WebElement id;
    @FindBy(xpath="//span[normalize-space()='23/07/22 00:00']") public WebElement startDate;
    @FindBy(xpath="//span[normalize-space()='28/07/22 00:00']") public WebElement endDate;
    @FindBy(xpath="//*[@id=\"app-view-container\"]/div/div/div/div/div/table/tbody/tr/td[4]") public WebElement status;
    @FindBy(xpath="//a[normalize-space()='Kay']") public WebElement physician;
    @FindBy(xpath="//a[normalize-space()='Myrtice']") public WebElement patient;


    @FindBy(xpath="//body//div//div//div//div//div//div//div//div//div//div[1]//div[1]//div[1]") public WebElement thisFieldIsRequired;
    @FindBy(xpath="//select[@id='appointment-status']") public WebElement statusChange;

    @FindBy(xpath="//a[@class='btn btn-danger btn-sm']") public WebElement showTestResults;
    @FindBy(xpath="//span[@class='d-none d-md-inline']") public WebElement viewResults;
    @FindBy(xpath="//tbody/tr/td[2]")  public WebElement tableSonuc1;
    @FindBy(xpath="//tbody/tr[2]/td[2]")  public WebElement tableSonuc2;
    @FindBy(xpath="//tbody/tr[3]/td[2]")  public WebElement tableSonuc3;
    @FindBy(xpath="//button[@class='btn btn-warning btn-sm']") public WebElement requestInpatient;
    @FindBy(xpath=" //span[normalize-space()='Show Appointments']") public WebElement showAppointments;
    @FindBy(xpath=" //span[normalize-space()='Edit']") public WebElement editAppointments;
    @FindBy(xpath=" //span[normalize-space()='Create or Edit an Appointment']") public WebElement editAppointmentPage;
    @FindBy(xpath=" //select[@id='appointment-status']") public WebElement statusPopup;
    @FindBy(xpath=" //option[@value='UNAPPROVED']") public WebElement statusPopupUnapproved;
    @FindBy(xpath=" //option[@value='PENDING']") public WebElement statusPopupPending;
    @FindBy(xpath=" //option[@value='COMPLETED']") public WebElement statusPopupCompleted;
    @FindBy(xpath=" //option[@value='CANCELLED']") public WebElement statusPopupCancelled;
    @FindBy(xpath=" //div[@class='invalid-feedback']") public WebElement invalidFeedback;
    @FindBy(xpath=" //textarea[@id='appointment-anamnesis']") public WebElement anamnesisArea;
    @FindBy(xpath=" //textarea[@id='appointment-treatment']") public WebElement treatmentArea;
    @FindBy(xpath=" //textarea[@id='appointment-diagnosis']") public WebElement diagnosisArea;
    @FindBy(xpath=" //select[@id='appointment-physician']") public WebElement physicianArea;
    @FindBy(xpath=" //a[@class='btn btn-primary btn-sm']") public WebElement showTestsButton;
    @FindBy(xpath=" //span[normalize-space()='Tests']") public WebElement isTestsPage;











}
