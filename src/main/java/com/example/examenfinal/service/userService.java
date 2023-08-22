import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.examenfinal.entity.User;
import com.example.examenfinal.repository.UserDAO;

@Service
public class UserService {
    private UserDAO dao;

    public UserService(UserDAO dao) {
        System.out.println("Appel du constructeur de service");
        this.dao = dao;
    }

    public List<User> getAllUsers() throws SQLException {
        return dao.getAll();
    }
}
