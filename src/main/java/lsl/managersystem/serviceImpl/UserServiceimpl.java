package lsl.managersystem.serviceImpl;
import lsl.managersystem.dao.UserDao;
import lsl.managersystem.domain.User;
import lsl.managersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import java.util.List;
@EnableTransactionManagement
@Service
public class UserServiceimpl implements UserService {
    @Autowired
    UserDao UserDao;
    @Override
    public List<User> query() {
        return UserDao.query();
    }


    @Override
    public User queryid(String id) {
        return UserDao.queryid(id);
    }

    @Override
    public int insertUser(User User) {
        UserDao.insertUser(User);
        return 0;
    }

    @Override
    public int updateUser(User User) {
        UserDao.updateUser(User);
        return 0;
    }

    @Override
    public int deleteUser(User User) {
        UserDao.deleteUser(User);
        return 0;
    }
}