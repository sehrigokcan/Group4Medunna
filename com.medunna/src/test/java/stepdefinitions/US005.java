package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.MedunnaMainPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US005 {
    MedunnaMainPage mainPage=new MedunnaMainPage();
    Faker faker=new Faker();

    @Given("Medunna ana sayfasina gider")
    public void medunna_ana_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }


    @And("Make appointment butonuna tiklar")
    public void makeAppointmentButonunaTiklar() {
        mainPage.makeAnAppointment.click();
    }

    @Given("First name kutusuna uygun isim girer")
    public void first_name_kutusuna_uygun_isim_girer() {
        mainPage.firstName.sendKeys("Fatma"+ Keys.TAB);

    }

    @Then("hata mesajinin cikmadigini test eder")
    public void hata_mesajinin_cikmadigini_test_eder() {
        Assert.assertTrue("Hata mesaji gorundu",mainPage.nameVerification.isDisplayed());

    }

    @Then("tarayiciyi kapatir")
    public void tarayiciyi_kapatir() {
        Driver.closeDriver();
    }

    @And("SSN kutusuna uygun ssn girer")
    public void ssnKutusunaUygunSsnGirer() {
        mainPage.SSN.sendKeys("012-34-5678");

    }

    @Then("SSN icin hata mesajinin cikmadigini test eder")
    public void ssnIcinHataMesajininCikmadiginiTestEder() {
        Assert.assertTrue("Hata mesaji gorundu",mainPage.ssnVerification.isDisplayed());

    }

    @And("Last name kutusuna uygun lastname girer")
    public void lastNameKutusunaUygunLastnameGirer() {
        mainPage.lastName.sendKeys("Karaca");

    }

    @Then("Lastname icin hata mesajinin cikmadigini test eder")
    public void lastnameIcinHataMesajininCikmadiginiTestEder() {
        Assert.assertTrue("Hata mesaji gorundu",mainPage.lastNameVerification.isDisplayed());
    }

    @And("e-mail kutusuna uygun e-mail girer")
    public void eMailKutusunaUygunEMailGirer() {
        mainPage.email.sendKeys("proje@gmail.com");

    }

    @Then("e-mail icin hata mesajinin cikmadigini test eder")
    public void eMailIcinHataMesajininCikmadiginiTestEder() {
        Assert.assertTrue("Hata mesaji gorundu",mainPage.emailVerification.isDisplayed());

    }

    @And("Telefon kutusuna uygun telefon numarasi girer")
    public void telefonKutusunaUygunTelefonNumarasiGirer() {
        //mainPage.phone.sendKeys("123-456-1234");

        mainPage.phone.sendKeys(faker.random().nextInt(100, 999)+"-"+
                faker.random().nextInt(100, 999)+"-"+faker.random().nextInt(1000, 9999));
    }

    @Then("Telefon numarasi icin hata mesajinin cikmadigini test eder")
    public void telefonNumarasiIcinHataMesajininCikmadiginiTestEder() {
        Assert.assertTrue("Hata mesaji gorundu",mainPage.phoneVerification.isDisplayed());

    }
}
