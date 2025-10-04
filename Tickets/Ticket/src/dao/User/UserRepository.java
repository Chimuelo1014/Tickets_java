package dao.User;
import domain.User;
import java.util.ArrayList;
public interface UserRepository {
    void createUser(User user);
    User getUserById(int id);
    ArrayList<User> getAllUsers();
    void updateUser(User user, int id);
    void deleteUser(int id);

}
