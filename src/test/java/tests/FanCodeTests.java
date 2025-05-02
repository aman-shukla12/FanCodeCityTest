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

        List<User> users = userService.getAllUsers();

        List<User> fanCodeUsers = users.stream().filter(CityValidator::isFanCodeCity).toList();

        for(User user : fanCodeUsers)
        {
            List<Todo> todos = todoService.getTodoListPerUser(user.getId());

            List<Todo> todoCompleted = todos.stream().filter(Todo::getCompleted).toList();

            double percentageCompletion = todoCompleted.size()* 100.0 / todos.size();

            Assert.assertTrue(percentageCompletion>50,String.format("User '%s' has completed %.2f percent todos.",user.getName(),percentageCompletion));

        }

    }
}
