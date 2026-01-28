package api;

import api.pojo.Exams;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class US005_ExamsAPITest extends BaseTest {
    private String examID;

    private final String school_id = "695c16bdc138c05a387fe36f";
    private final String academicPeriod = "695c1c03f620a8876fd6e521";
    private final String gradeLevelId = "5e909860b0fd8113ea1432b4";

    @Test(priority = 1, description = "Create a new exam")
    public void createExam() {
        Exams.GradeLevel gradeLevel = new Exams.GradeLevel(gradeLevelId);

        Exams requestExam = new Exams(
                school_id,
                "TestExam",
                academicPeriod,
                gradeLevel,
                "REGISTRATION"
        );
        Exams createdExam =
                given()
                        .spec(request)
                        .body(requestExam)
                        .when()
                        .post("school-service/api/exams")
                        .then()
                        .statusCode(201)
                        .body("id", notNullValue())
                        .extract()
                        .as(Exams.class);

        System.out.println("Exam Created [Status: 201]:" + createdExam);
        examID = createdExam.getId();

    }
    @Test(priority = 2, description = "Create exam - Missing required field (name)")
    public void createExamMissingName() {

        Exams.GradeLevel gradeLevel = new Exams.GradeLevel(gradeLevelId);

        Exams requestExam = new Exams(
                school_id,
                null,
                academicPeriod,
                gradeLevel,
                "REGISTRATION"
        );

        given()
                .spec(request)
                .body(requestExam)
                .when()
                .post("school-service/api/exams")
                .then()
                .statusCode(400);

        System.out.println("Create Exam - Missing Name [Status: 400]");
    }

    @Test(priority = 3, description = "Get exam by id")
    public void getExamById() {

        Exams exam =
                given()
                        .spec(request)
                        .when()
                        .get("school-service/api/exams/{id}", examID)
                        .then()
                        .statusCode(200)
                        .body("id", equalTo(examID))
                        .body("name", equalTo("TestExam"))
                        .extract()
                        .as(Exams.class);

        System.out.println("Exam Retrieved [Status: 200]: " + exam);
    }
    @Test(priority = 4, description = "Update exam")
    public void updateExam() {

        Exams.GradeLevel gradeLevel = new Exams.GradeLevel(gradeLevelId);

        Exams updateRequest = new Exams(
                school_id,
                "TestExam_Updated",
                academicPeriod,
                gradeLevel,
                "REGISTRATION"
        );
        updateRequest.setId(examID);

        Exams updatedExam =
                given()
                        .spec(request)
                        .body(updateRequest)
                        .when()
                        .put("school-service/api/exams")
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(Exams.class);

        System.out.println("Exam Updated [Status: 200]:  " + updatedExam);
    }
    @Test(priority = 5, description = "Update exam - Invalid ID")
    public void updateExamInvalidId() {

        String invalidId = "invalidID123";

        Exams.GradeLevel gradeLevel = new Exams.GradeLevel(gradeLevelId);

        Exams updateRequest = new Exams(
                school_id,
                "TestExam",
                academicPeriod,
                gradeLevel,
                "REGISTRATION"
        );
        updateRequest.setId(invalidId);

        given()
                .spec(request)
                .body(updateRequest)
                .when()
                .put("school-service/api/exams")
                .then()
                .statusCode(400);

        System.out.println("Update Exam - Invalid ID [Status: 400]");
    }
    @Test(priority = 6, description = "Delete exam")
    public void deleteExam() {

        given()
                .spec(request)
                .when()
                .delete("school-service/api/exams/{id}", examID)
                .then()
                .statusCode(204);

        System.out.println("Exam Deleted [Status: 204]: ID =" + examID);
    }
    @Test(priority = 7, description = "Delete exam - Invalid ID")
    public void deleteExamInvalidId() {

        String invalidId = "invalidID123";

        given()
                .spec(request)
                .when()
                .delete("school-service/api/exams/{id}", invalidId)
                .then()
                .statusCode(400);

        System.out.println("Delete Exam - Invalid ID [Status: 400]");
    }

    }
