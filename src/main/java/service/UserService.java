package service;

import base.APIBase;
import io.restassured.response.Response;
import model.User;
import utility.ConfigReader;
import utility.JsonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class UserService extends APIBase {


    private static UserService userService;
    public static UserService getUserService()
    {
        if(userService == null)
            userService = new UserService();
        return userService;
    }

    public List<User> getAllUsers(){

        Response response = executeRequest(null,"/users", ConfigReader.getBaseURI(),"GET");
        User [] users;
        try{
            users = JsonUtil.fromJson(response.getBody().asString(),User[].class);
        }catch (Exception e)
        {
            System.out.println("Some exception occurred");
            return null;
        }
        return Arrays.asList(users);
    }
}
