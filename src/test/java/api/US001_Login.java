package api;

import api.pojo.Ahmet;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;


public class US001_Login extends BaseTest {

    private String accessToken;

    @Test(priority = 1, description = "Login the homepage with valid data")
    @Story("Login as Authority")
    @Description("Login with valid data")
    @Severity(SeverityLevel.CRITICAL)
    public void createLogin() {

        Ahmet requestLogin =
                new Ahmet("TS_Staj", "TS_Staj2026");

        Ahmet createdLogin =
                given()
                        .spec(request)
                        .body(requestLogin)

                        .when()
                        .post("auth/login")

                        .then()
                        .statusCode(200)
                        .body("access_token", notNullValue())
                        .extract()
                        .as(Ahmet.class);

        accessToken = createdLogin.getAccess_token();
        System.out.println("Authorization Token:"+accessToken);
    }

    @Test(priority = 2, description = "Login the homepage with wrong password")
    @Story("Login as Authority")
    @Description("Login with invalid data")
    @Severity(SeverityLevel.NORMAL)
    public void invalidLogin1() {

        Ahmet requestLogin =
                new Ahmet("TS_Staj", "wrongPassword");

        Ahmet createdLogin =
                given()
                        .spec(request)
                        .body(requestLogin)

                        .when()
                        .post("auth/login")

                        .then()
                        .statusCode(401)
                        .extract()
                        .as(Ahmet.class);
    }
    @Test(priority = 3, description = "Login the homepage with wrong username")
    @Story("Login as Authority")
    @Description("Login with invalid data")
    @Severity(SeverityLevel.NORMAL)
    public void invalidLogin2() {

        Ahmet requestLogin =
                new Ahmet("wrongUsername", "TS_Staj2026");

        Ahmet createdLogin =
                given()
                        .spec(request)
                        .body(requestLogin)

                        .when()
                        .post("auth/login")

                        .then()
                        .statusCode(401)
                        .extract()
                        .as(Ahmet.class);
    }

}
