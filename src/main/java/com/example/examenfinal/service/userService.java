import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Service
public class userService {
   private userDAO dao;

   public userService(userDAO dao){
       System.out.println("Appel du constructeur de service");
       this.dao = dao;
   }

   public List<user> getAllUsers() throws SQLException {
       return dao.getAll();
   }
}