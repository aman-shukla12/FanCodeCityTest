package service;

import base.APIBase;
import io.restassured.response.Response;
import model.Todo;
import utility.ConfigReader;
import utility.JsonUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoService extends APIBase {

    private static TodoService todoService;
    public static TodoService getTodoService() {
        if(todoService == null)
        {
            todoService = new TodoService();
        }
        return todoService;
    }

    public List<Todo> getTodoListPerUser(Integer id)
    {

        Map<String, Integer> queryParams = new HashMap<>();
        queryParams.put("userId",id);

        Response response = executeRequest(queryParams,"/todos", ConfigReader.getBaseURI(),"GET");

        Todo [] todoList = null;
        try {
            todoList = JsonUtil.fromJson(response.getBody().asString(), Todo[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Arrays.asList(todoList);
    }
}
