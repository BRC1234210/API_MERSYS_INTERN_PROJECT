package api;

import api.pojo.Country;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.management.BadAttributeValueExpException;

import java.util.List;

import static io.restassured.RestAssured.filters;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class US003_CRUDState extends BaseTest {

    String stateID = null;

    @Test(priority = 1, description = "Get Countries")
    public void getAllCountries() {

        String usaId = null;
        Response response =
                given()
                        .spec(request)
                        .when()
                        .get("/school-service/api/countries");

        response.then()
                .statusCode(200);

        List<Country> allCountries = response.jsonPath().getList("", Country.class);

        for (Country c : allCountries) {
            if (c.getName().equalsIgnoreCase("United States of America")) {
                usaId = c.getId();
                break;
            }
        }
        System.out.println("USA ID= " + usaId);

        Assert.assertNotNull(usaId, "State ID is null");
    }


    @Test(priority = 2, description = "Create State")
    public void createState() {

        String createStateBody = """
                {
                
                  "name": "WestMemphis",
                  "shortName": "WM",
                  "country": {
                    "id": "5baac28d91cefe05fc6e3fe6"
                  },
                  "translateName": []
                }
                """;
        Response response =
                given()
                        .spec(request)
                        .body(createStateBody)
                        .when()
                        .post("/school-service/api/states")
                        .then()
                        .statusCode(201)
                        .body("name", equalTo("WestMemphis"))
                        .body("shortName", notNullValue())
                        .extract().response();
        stateID = response.path("id");
        Assert.assertNotNull(stateID, "State ID is null");

    }

    @Test(priority = 3, description = "Get State", dependsOnMethods = "createState")
    public void getState() {
        Assert.assertNotNull(stateID, "State ID is null");
        Response response =
                given()
                        .spec(request)
                        .pathParam("stateId", stateID)
                        .when()
                        .get("/school-service/api/states/{stateId}")
                        .then()
                        .statusCode(200)
                        .body("name", equalTo("WestMemphis"))
                        .body("shortName", equalTo("WM"))
                        .extract().response();
        stateID = response.path("id");


    }

    @Test(priority = 4, description = "Update State", dependsOnMethods = "createState")
    public void updateState() {
        Assert.assertNotNull(stateID, "State ID is null");
        String updateBody = """
                {
                "id": "%s",
                  "name": "NorthMemphis",
                  "shortName": "NM",
                  "country": {
                    "id": "5baac28d91cefe05fc6e3fe6"
                  },
                  "translateName": []
                }
                """.formatted(stateID);

        given()
                .spec(request)
                .contentType("application/json")
                .body(updateBody)
                .when()
                .put("/school-service/api/states")
                .then()
                .statusCode(200)
                .extract().response();
    }

    @Test(priority = 5, description = "Delete State", dependsOnMethods = "createState")
    public void deleteState() {
        Assert.assertNotNull(stateID, "State ID is null");
        given()
                .spec(request)
                .pathParam("stateId", stateID)
                .when()
                .delete("/school-service/api/states/{stateId}")
                .then()
                .statusCode(200);
    }

}
