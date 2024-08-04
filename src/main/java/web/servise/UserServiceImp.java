package web.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDaoImp;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {


    private final UserDaoImp userDao;

    @Autowired
    public UserServiceImp(UserDaoImp userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getListUser() {
        return userDao.getListUser();
    }

    @Override
    public void save(String name, String surname, int age) {
        userDao.save(name, surname, age);
    }

    @Override
    public void update(User user, long id) {
        userDao.update(user, id);
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    public User getUser(long id) {
        return userDao.getUser(id);

    }


}
