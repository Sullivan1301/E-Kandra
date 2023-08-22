import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.examenfinal.entity.User;
import com.example.examenfinal.service.UserService;

@RestController
public class UserController {
    private UserService service;

    public UserController(UserService service) {
        System.out.println("Appel du contrôleur");
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() throws SQLException {
        return service.getAllUsers();
    }
}
