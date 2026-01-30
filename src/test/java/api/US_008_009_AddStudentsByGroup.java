package api;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class US_008_009_AddStudentsByGroup extends BaseTest {

    private String groupId;

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
                       "name": "US_08 test",
                       "description": "alsfklamnskfnslşkdnklanmdilgimslşkfgnskldmgşlsdmgşjnsdgmlsdg",
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
        groupId = response.path("id").toString();

        System.out.println("Created id = " + groupId);
    }

    @Test(priority = 3, description = "Adding a student to the group")
    public void addStudentsbyGroup() {

        String addStudentsBody = """
                [
                    "6978e21ff620a8876fd6ea4d",
                    "6978e21ff620a8876fd6ea55",
                    "6978e21ff620a8876fd6ea56"
                ]
                """;

        Response response =
                given()
                        .spec(request)
                        .body(addStudentsBody)
                        .post("/school-service/api/student-group/{id}/add-students?page=0&size=10", groupId)
                        .then()
                        .statusCode(200)
                        .extract().response();
    }



    @Test(priority = 4,description = "")
    public void getStudents(){
        given()
                .spec(request)
                .when()
                .get("/school-service/api/student-group/{id}",groupId)
                .then()
                .statusCode(200);
    }
    @Test(priority = 5, description = "Removing students from the group")
    public void deleteStudents() {

        String deleteBody = """
                [
                    "6978e21ff620a8876fd6ea4d",
                    "6978e21ff620a8876fd6ea55",
                    "6978e21ff620a8876fd6ea56"
                ]
                """;


        given()
                .spec(request)
                .body(deleteBody)
                .when()
                .post("/school-service/api/student-group/{id}/remove-students?page=0&size=10", groupId)
                .then()
                .statusCode(200);
    }

    @Test(priority = 6,description = "student group delete")
    public void deleteGroup(){

        given()
                .spec(request)
                .when()
                .delete("school-service/api/student-group/{id}",groupId)
                .then()
                .statusCode(200);
    }

}
