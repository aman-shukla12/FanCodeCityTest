package tests;

import base.APITestBase;
import model.Todo;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.CityValidator;

import java.util.List;

public class FanCodeTests extends APITestBase {


    @Test(description = "User Completed task percentage should be greater than 50%")
    public void validateUsersCompletedTask() {

        getTest().info("Get all user info");
        List<User> users = userService.getAllUsers();

        List<User> fanCodeUsers = users.stream().filter(CityValidator::isFanCodeCity).toList();
        getTest().info("Get all fanCode users");

        for(User user : fanCodeUsers)
        {
            List<Todo> todos = todoService.getTodoListPerUser(user.getId());

            List<Todo> todoCompleted = todos.stream().filter(Todo::getCompleted).toList();

            double percentageCompletion = todoCompleted.size()* 100.0 / todos.size();
            if(percentageCompletion>50)
            {
                getTest().pass(String.format("User %s has completed %.2f percent todos.",user.getName(),percentageCompletion));
            }
            else
                getTest().fail(String.format("Test failed for user %s ",user.getName()));
            Assert.assertTrue(percentageCompletion>50,String.format("User '%s' has completed %.2f percent todos.",user.getName(),percentageCompletion));


        }

    }
}
