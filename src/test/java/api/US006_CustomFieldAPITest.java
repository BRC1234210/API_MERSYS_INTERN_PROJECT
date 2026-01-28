package api;

import api.pojo.Exams;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class US006_CustomFieldAPITest extends BaseTest {

    private String fieldId;
    private final String tenant_id = "5e39ade1cb4c066deeb43015";


    @Test(priority = 1, description = "POST - Create Custom Field (Valid)")
    public void createCustomFieldValid() {

        String uniqueName = "US006_TestField_" + System.currentTimeMillis();
        String uniqueCode = "CF_US006_" + System.currentTimeMillis();

        Exams.EntityField requestField = new Exams.EntityField(
                tenant_id,
                uniqueName,
                uniqueCode,
                "STRING",
                "Test Custom Field",
                "TestValue"
        );
        Exams.EntityField createdField =
                given()
                        .spec(request)
                        .body(requestField)
                            .when()
                        .post("school-service/api/entity-field")
                        .then()
                        .statusCode(201)
                        .body("id", notNullValue())
                        .body("name", equalTo(uniqueName))
                        .body("code", equalTo(uniqueCode))
                        .extract()
                        .as(Exams.EntityField.class);

        fieldId = createdField.getId();
        System.out.println("Test 1: POST Create [Status: 201]");
    }

    @Test(priority = 2, description = "POST - Create Custom Field (Duplicate Code)")
    public void createCustomFieldDuplicateCode() {
        Exams.EntityField requestField = new Exams.EntityField(
                tenant_id,
                "US006_TestField_Duplicate",
                "CF_US006_001",
                "STRING",
                "Test Custom Field",
                "TestValue"
        );
        given()
                .spec(request)
                .body(requestField)
                .when()
                .post("school-service/api/entity-field")
                .then()
                .statusCode(400);

        System.out.println("Test 2: POST Duplicate Code [Status: 400]");
    }

    @Test(priority = 3, description = "PUT - Update Custom Field (Valid)")
    public void updateCustomFieldValid() {

        String updatedName = "US006_TestField_" + System.currentTimeMillis() + "_Updated";

        Exams.EntityField updateRequest = new Exams.EntityField(
                tenant_id,
                updatedName,
                "CF_US006_" + System.currentTimeMillis(),
                "STRING",
                "Updated Test Custom Field",
                "UpdatedValue"
        );
        updateRequest.setId(fieldId);

        Exams.EntityField updatedField =
                given()
                        .spec(request)
                        .body(updateRequest)
                        .when()
                        .put("school-service/api/entity-field")
                        .then()
                        .statusCode(200)
                        .body("id", equalTo(fieldId))
                        .body("name", equalTo(updatedName))
                        .body("hint", equalTo("Updated Test Custom Field"))
                        .body("defaultValue", equalTo("UpdatedValue"))
                        .extract()
                        .as(Exams.EntityField.class);

        System.out.println("Test 3: PUT Update [Status: 200]");
    }

    @Test(priority = 4, description = "PUT - Update Custom Field (Duplicate Name with Different Code)")
    public void updateCustomFieldDuplicateName() {
        Exams.EntityField updateWithDuplicateName = new Exams.EntityField(
                tenant_id,
                "US006_TestField_001_Updated",
                "CF_US006_999",
                "STRING",
                "Trying duplicate name",
                "TestValue"
        );
        updateWithDuplicateName.setId(fieldId);

        given()
                .spec(request)
                .body(updateWithDuplicateName)
                .when()
                .put("school-service/api/entity-field")
                .then()
                .statusCode(400);

        System.out.println("Test 4: PUT Duplicate Name (Different Code) [Status: 400]");
    }

    @Test(priority = 5, description = "DELETE - Valid Custom Field")
    public void deleteCustomFieldValid() {
        given()
                .spec(request)
                .when()
                .delete("school-service/api/entity-field/{id}", fieldId)
                .then()
                .statusCode(204);

        System.out.println("Test 5: DELETE Valid [Status: 204]");
    }

    @Test(priority = 6, description = "DELETE - Invalid ID")
    public void deleteCustomFieldInvalidId() {
        String invalidId = "85f2c5a894c7e9fd28306478";

        given()
                .spec(request)
                .when()
                .delete("school-service/api/entity-field/{id}", invalidId)
                .then()
                .statusCode(400);

        System.out.println("Test 6: DELETE Invalid ID [Status: 400]");
    }
    @Test(priority = 7, description = "GET - List Custom Fields")
    public void getListCustomFields() {
        given()
                .spec(request)
                .when()
                .get("school-service/api/entity-field")
                .then()
                .statusCode(200);

        System.out.println("Test 7: GET List [Status: 200]");
    }
    @Test(priority = 8, description = "GET - Single Custom Field")
    public void getSingleCustomField() {
        given()
                .spec(request)
                .when()
                .get("school-service/api/entity-field/{id}", "anyValidId")
                .then()
                .statusCode(200);

        System.out.println("Test 8: GET Single [Status: 200]");

    }
}