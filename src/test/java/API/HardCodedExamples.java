package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    String baseURI = RestAssured.baseURI ="http://hrm.syntaxtechs.net/syntaxapi/api";
    String token ="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUzODU1MjMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTQyODcyMywidXNlcklkIjoiNTMwOCJ9.8PwYuLrZCvrbhW_ORnBp5-IydjU54zjCf7bxruL7PiU";
    static String employee_id;
    @Test
    public  void  bgetCreatedEmployee(){
       RequestSpecification preparedRequest=given().header("Content-Type","application/json").
               header("Authorization",token).
               queryParam("employee_id",employee_id);

       // hitting the endpoint
        Response response=preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        // verify the response
        response.then().assertThat().statusCode(200);

        String tempEmpId=response.jsonPath().getString("employee.employee_id");

        //we have 2 emp id , one is global and second is local
        Assert.assertEquals(employee_id,tempEmpId);
    }


    @Test
    public void  acreateEmployee(){
        //prepare the request
        RequestSpecification preparedRequest= given().header("Content-Type","application/json").
                header("Authorization",token).body("{\n" +
                        "  \"emp_firstname\": \"Synflo\",\n" +
                        "  \"emp_lastname\": \"Blend\",\n" +
                        "  \"emp_middle_name\": \"fb\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1999-05-05\",\n" +
                        "  \"emp_status\": \"Confirmed\",\n" +
                        "  \"emp_job_title\": \"QA\"\n" +
                        "}");
        // hitting the endpoint/ send the request
       Response response= preparedRequest.when().post("/createEmployee.php");

        // verifying the assertion/ get response
        response.then().assertThat().statusCode(201);

        //we are capturing employee id from response
        employee_id= response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);
        //it will print the output in the console like System.out.println
        response.prettyPrint();


        //verifying the first name in the response body
        response.then().assertThat().body("Employee.emp_firstname",equalTo("Synflo"));
        response.then().assertThat().body("Employee.emp_lastname",equalTo("Blend"));

        //verify the response headers
        response.then().assertThat().header("Content-Type","application/json");
    }

//in homework create a method to get all employee and job title
    @Test
    public void GetJobTitle(){
        RequestSpecification preparedRequest=given().header("Authorization",token);
        Response response=preparedRequest.when().get("jobTitle.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getAllEmployee(){
        RequestSpecification preparedRequest=given().header("Authorization",token);
        Response response=preparedRequest.when().get("/getAllEmployees.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }


    @Test
    public void  cupdateEmployee(){
        RequestSpecification preparedRequest=given().header("Content-Type","application/json").
                header("Authorization",token).
               body("{\n" +
                       "  \"employee_id\": \""+employee_id+"\",\n" +
                       "  \"emp_firstname\": \"Kolu\",\n" +
                       "  \"emp_lastname\": \"Presst\",\n" +
                       "  \"emp_middle_name\": \"kp\",\n" +
                       "  \"emp_gender\": \"M\",\n" +
                       "  \"emp_birthday\": \"2000-05-28\",\n" +
                       "  \"emp_status\": \"probation\",\n" +
                       "  \"emp_job_title\": \"API tester\"\n" +
                       "}");

        //hitting the endpoint
        Response response= preparedRequest.when().put("/updateEmployee.php");
        response.then().assertThat().statusCode(200);

        //for verification
        response.then().assertThat().body("Message",equalTo("Employee record Updated"));
    }
    @Test
    public  void dgetUpdatedEmployee(){
        RequestSpecification preparedRequest=given().header("Content-Type","application/json").
                header("Authorization",token).
                queryParam("employee_id",employee_id);
        Response response=preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);
        // if you want to verify the body of the response
        // you can do that using hamcrest matchers

    }
}
