package base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.ConfigReader;

import java.util.Map;

public class APIBase {

    static RequestSpecification requestSpecification;
    static RequestSpecBuilder requestSpecBuilder;

    private RequestSpecBuilder getRequestSpecBuilder()
    {
        if (requestSpecBuilder==null)
            requestSpecBuilder = new RequestSpecBuilder();
        return requestSpecBuilder;
    }

    public void setUpConnetion()
    {
        RestAssured.baseURI = ConfigReader.getBaseURI();
        requestSpecBuilder = getRequestSpecBuilder();
        RestAssured.defaultParser= Parser.JSON;
    }

    public Response executeRequest(Object requestOrParams, String endpoint, String baseURI,String method)
    {
        Response response;
        requestSpecBuilder = getRequestSpecBuilder();
        requestSpecBuilder.setBaseUri(baseURI+endpoint);
        requestSpecification = requestSpecBuilder.addFilter(new RequestLoggingFilter()).addFilter(new ResponseLoggingFilter()).build();

        switch(method.toUpperCase()){
            case "POST":
                requestSpecBuilder.setBody(requestOrParams);
                requestSpecBuilder.setContentType(ContentType.JSON);
                response = RestAssured.given().spec(requestSpecification).when().post();
                break;
            case "GET":
                if(requestOrParams instanceof Map)
                {
                    requestSpecification.queryParams((Map<String,?> )requestOrParams);
                }
                response = RestAssured.given().spec(requestSpecification).when().get();
                break;
            default:
                return null;//Need to throw exception here,
        }
        return response;
    }

}
