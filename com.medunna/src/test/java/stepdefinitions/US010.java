package stepdefinitions;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.MedunnaAdminItemsAndTitles;
import pages.MedunnaAppointmentPage;
import pages.MedunnaMainPage;
import pages.MedunnaPhysicianPage;
import pojo.Appointment;
import utilities.ConfigReader;
import utilities.Driver;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.Authentication.tokenGenerate;

public class US010 {
    MedunnaMainPage mainPage = new MedunnaMainPage();
    MedunnaAppointmentPage appointmentPage = new MedunnaAppointmentPage();
    MedunnaAdminItemsAndTitles medunnaAdminItemsAndTitles=new MedunnaAdminItemsAndTitles();
    MedunnaPhysicianPage physicianPage = new MedunnaPhysicianPage();

    Response response;
    Appointment actualAppointment;
    public static RequestSpecification spec;




    @And("doktor kullanici adini ve sifresini girer")
    public void doktorKullaniciAdiniVeSifresiniGirer() {

        mainPage.username.sendKeys(ConfigReader.getProperty("asa"));
        mainPage.password.sendKeys(ConfigReader.getProperty("123456"));

        Driver.wait(2);

    }
    @And("Mypages butonuna tiklar")
    public void mypagesButonunaTiklar() {
        mainPage.mYPAGES.click();
        Driver.wait(2);


    }



    @And("Items&titles butonuna tiklar")
    public void clicksOnItemsAndTitles() {
        medunnaAdminItemsAndTitles.itemsTitlesButton.click();

    }
    @Then("MyAppointmenti secer")
    public void myappointmentiSecer() {
        mainPage.myAppointments.click();
        Driver.wait(2);
    }



    @Then("randevu listesi ve zaman dilimleri oldugunu kontrol eder")
    public void randevuListesiVeZamanDilimleriOldugunuKontrolEder() {
        Assert.assertTrue(appointmentPage.appointmentsHeading.isDisplayed());
        Assert.assertTrue(appointmentPage.appointmentStartDate.isDisplayed());
        Assert.assertTrue(appointmentPage.appointmentEndDate.isDisplayed());

    }

    @Then("patient id, start date, end date ve status bilgileri oldugunu kontrol eder")
    public void patientIdStartDateEndDateVeStatusBilgileriOldugunuKontrolEder() {
        Assert.assertTrue(appointmentPage.appointmentsHeading.isDisplayed());
        Assert.assertTrue(appointmentPage.selectedAppointmentStartDate.isDisplayed());
        Assert.assertTrue(appointmentPage.selectedAppointmentEndDate.isDisplayed());
        Assert.assertTrue(appointmentPage.selectedAppointmentStatus.isDisplayed());

    }


    @Given("Doktor Medunna randevu API endpointini {string} ile olusturur")
    public void doktorMedunnaRandevulerAPIEndpointiniIleOlurturur(String id) {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("1", "api", "2", "appointments", "3", id);
    }
    @Then("Doktor randevu icin Get request olusturur ve gonderir")
    public void doktor_randevu_icin_get_request_i_olusturu_ve_gonderir() {
        response = given().spec(spec).header("Authorization", "Bearer "+ tokenGenerate())
                .contentType(ContentType.JSON)
                .when()
                .get("/{1}/{2}/{3}/");
    }
    @Then("Doktor randevu icin Get response alir")
    public void doktor_randevu_icin_get_response_i_alir() {
        response.prettyPrint();
    }
    @Given("Doktor Status Kodun {int} oldugunu dogrular")
    public void doktor_status_kodun_oldugunu_dogrular(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
    @Given("Doktor gelen json randevu datalarini javaya donusturur")
    public void doktor_gelen_json_randevu_datalarini_javaya_donusturur() throws JsonProcessingException {
         ObjectMapper obj = new ObjectMapper();
        Appointment actualAppointment =obj.readValue(response.asString(),Appointment.class);
        actualAppointment = response.as(Appointment.class);

    }
    @Given("Doktor gelen randevu datalarini kayit eder")
    public void doktor_gelen_randevu_datalarini_kayit_eder() {
        //saveAppointData(actualAppointment);
    }

    @Given("Doctor API ile gelen datalar {string} {string} {string} {string} dogrular")
    public void doctor_api_ile_gelen_datalar_dogrular(String patientId, String startDate, String endDate, String status) {
        //assertEquals(Integer.parseInt(patientId), actualAppointment.getPatient().getId());
        assertEquals(startDate, actualAppointment.getStartDate());
        assertEquals(endDate, actualAppointment.getEndDate());
        assertEquals(status,actualAppointment.getStatus());
    }
}