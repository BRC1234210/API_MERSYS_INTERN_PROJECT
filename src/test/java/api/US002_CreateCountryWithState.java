package api;

import api.pojo.Login;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class US002_CreateCountryWithState extends BaseTest{

    @Test(priority = 1, description = "Creating a Country with state")
    @Story("Create a country")
    @Description("Create a Country with state")
    @Severity(SeverityLevel.CRITICAL)
    public void createCountry() {

        Login requestCountry =
                new Login("Ahmetland","AL","true");

        Login createdCountry =
                given()
                        .spec(request)
                        .body(requestCountry)

                        .when()
                        .post("school-service/api/countries")

                        .then()
                        .statusCode(201)
                        .extract()
                        .as(Login.class);

        System.out.println("Country:"+createdCountry);

    }
}
