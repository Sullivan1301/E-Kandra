import java.sql.SQLException;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import school.hei.userapp_springboot.model.User;
import school.hei.userapp_springboot.service.UserService;

@RestController
public class userController {
    private UserService service;

    public UserController(userService service){
        System.out.println("Appel du controller");
        this.service = service;
    }
   @GetMapping("/users")
    public List<user> getAllUsers() throws SQLException {
        return service.getAllUsers();
    }
}