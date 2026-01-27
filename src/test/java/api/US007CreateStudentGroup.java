package api;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class US007CreateStudentGroup extends BaseTest {


    private String studentGroupId;


    @Test(priority = 1, description = "Login")
    public void login() {

        String createBody = """
                 {
                
                     "username": "TS_Staj",
                     "password": "TS_Staj2026",
                     "rememberMe": true
                
                }""";

        Response response =
                given()
                        .spec(request)
                        .body(createBody)
                        .post("/auth/login")
                        .then()
                        .statusCode(200)
                        .extract().response();

    }

    @Test(priority = 2, description = "Forming a student group")
    public void createStudentGroup() {

        String createBody = """
                   {
                    "id": null,
                    "schoolId": "695c16bdc138c05a387fe36f",
                    "name": "baris cansiz",
                    "description": "aeflşaslflşafşlasşfşalsflşasf",
                    "active": true,
                    "publicGroup": true,
                    "showToStudent": false
                }
                """;

        Response response = given()
                .spec(request)
                .body(createBody)
                .post("/school-service/api/student-group")
                .then()
                .statusCode(201)
                .extract().response();
        studentGroupId = response.path("id").toString();

        System.out.println("Created id = " + studentGroupId);
    }

    @Test(priority = 3, dependsOnMethods = "createStudentGroup", description = "Student group update")
    public void updateStudentGroup() {

        String updateBody = """
                {
                  "id": "%s",
                  "schoolId": "695c16bdc138c05a387fe36f",
                  "name": "baris cansiz100",
                  "description": "aeflşaslflşafşlasşfşalsflşasf",
                  "active": true,
                  "publicGroup": true,
                  "showToStudent": false
                }
                """.formatted(studentGroupId);

        given()
                .spec(request)
                .body(updateBody)
                .when()
                .put("/school-service/api/student-group")
                .then()
                .statusCode(200)
                .extract().response();
    }

    @Test(priority = 4, description = "student group control")
    public void getStudentGroup() {
        given()
                .spec(request)
                .when()
                .get("/school-service/api/students/group/6978c7a3c138c05a387fe829?page=0&size=10")
                .then()
                .statusCode(200);
    }


    @Test(priority = 5, description = "student group delete")
    public void deleteStudentsGroup() {

        given()
                .spec(request)
                .when()
                .delete("/school-service/api/student-group/{id}", studentGroupId)
                .then()
                .statusCode(200);
    }


}

