package api;

import api.pojo.Country;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class US004_CRUD_City extends BaseTest{

    String stateID = null;
    String cityID = null;
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
        System.out.println("USA id= " + usaId);

        Assert.assertNotNull(usaId, "State ID is null");
    }

    @Test(priority = 2, description = "Create State")
    public void createState() {

        String createStateBody = """
                {
                
                  "name": "EastCoast",
                  "shortName": "EC",
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
                        .body("name", equalTo("EastCoast"))
                        .body("shortName", notNullValue())
                        .extract().response();
        stateID = response.path("id");
        Assert.assertNotNull(stateID, "State ID is null");
    }
    @Test(priority = 3, description = "Get State", dependsOnMethods = "createState")
    public void getState(){
        Assert.assertNotNull(stateID, "State ID is null");
        Response response =
                given()
                        .spec(request)
                        .pathParam("stateId2", stateID)
                        .when()
                        .get("/school-service/api/states/{stateId2}")
                        .then()
                        .statusCode(200)
                        .body("name", equalTo("EastCoast"))
                        .body("shortName", equalTo("EC"))
                        .extract().response();
        stateID = response.path("id");
    }

    @Test(priority = 4, description = "Create City", dependsOnMethods = "getState")
    public void createCity(){

        String createCityBody = """
               {
                   "country": {
                       "id": "5baac28d91cefe05fc6e3fe6"
                   },
                   "state": {
                       "id": "%s"
                   },
                   "name": "Bronx",
                   "translateName": []
               }""".formatted(stateID);
        Response response =
                given()
                        .spec(request)
                        .body(createCityBody)
                        .when()
                        .post("/school-service/api/cities")
                        .then()
                        .statusCode(201)
                        .body("name", equalTo("Bronx"))
                        .extract().response();
        cityID = response.path("id");
        Assert.assertNotNull(cityID, "City ID is null");
    }
    @Test(priority = 5, description = "Update City", dependsOnMethods = "createCity")
    public void updateCity(){

            Assert.assertNotNull(cityID, "City ID is null");
            String updateBody = """
                    {
                      "id": "%s",
                      "name": "Aden",
                      "country": {
                        "id": "5baac28d91cefe05fc6e3fe6"
                      },
                      "state": {
                        "id": "%s"
                      },
                      "translateName": []
                    }
                """.formatted(cityID, stateID);

            given()
                    .spec(request)
                    .contentType("application/json")
                    .body(updateBody)
                    .when()
                    .put("/school-service/api/cities")
                    .then()
                    .statusCode(200)
                    .extract().response();
        }
    @Test(priority = 5, description = "Delete City", dependsOnMethods = "updateCity")
    public void deleteCity() {
        Assert.assertNotNull(cityID, "City ID is null");
        given()
                .spec(request)
                .pathParam("cityId", cityID)
                .when()
                .delete("/school-service/api/cities/{cityId}")
                .then()
                .statusCode(200);
    }
    @Test(priority = 5, description = "Delete State", dependsOnMethods = "deleteCity")
    public void deleteState() {
        Assert.assertNotNull(stateID, "State ID is null");
        given()
                .spec(request)
                .pathParam("stateId2", stateID)
                .when()
                .delete("/school-service/api/states/{stateId2}")
                .then()
                .statusCode(200);
    }


    }




