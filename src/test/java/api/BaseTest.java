package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected RequestSpecification request;


    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "https://campus.techno.study/";

        String token = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0c19zdGFqIiwiaXNzIjoiY2FtcHVzIiwidGVuYW50SWQiOiI1ZTM5YWRlMWNiNGMwNjZkZWViNDMwMTUiLCJleHAiOjE3Njk2ODM5MTIsImlhdCI6MTc2OTA3OTExMiwidXNlcklkIjoiNjk1YzE4ZDU0NzkzMjg5OTJlNzAyNWI2IiwianRpIjoiMDFLRkpOQTBYRkNLVFRBNzc3RVFOTU1WS0siLCJhdXRob3JpdGllcyI6IlJPTEVfVEVDSE5PX1RFU1QsUk9MRV9FVkVSWU9ORSJ9.F_1TPOH7w1fhqiib3LaHfB4d6kezG6W8fEvnE3iAAanYWw7sXCqLwmTLu0j8mTy93W4zJ58xjq_nbia0YtGBr5nxrv9vdoExdjwvl-5Bn4O5nK5RcKDd24mz0Dr1fR2r8p4Vw5JIHJBQhG8oaBZfRvzzeqSUNeDgpKVLiMPOsVHE4HUjFd90-kFJwLpfZaA5ygBpYc4Z9h6qZY0pSWQyx0EkAJFpmEcv8XjZddv5WzHOF10CbC9LDAI1XAxZCEwHu27IddhBGuA7Nh8Frp0bPZpNpZe8whTKVsC2TqBVdBPSN6KBCvcS7xSeckwmAB4yfm1lpCvbtM_hrG2W3hWLXg";

        request = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + token);
    }
    }


