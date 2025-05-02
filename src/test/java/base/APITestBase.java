package base;

import org.testng.annotations.BeforeClass;
import service.TodoService;
import service.UserService;

public class APITestBase {

    public static TodoService todoService;
    public static UserService userService;

    @BeforeClass
    public void setUp()
    {
        userService = UserService.getUserService();
        todoService = TodoService.getTodoService();
    }


}
