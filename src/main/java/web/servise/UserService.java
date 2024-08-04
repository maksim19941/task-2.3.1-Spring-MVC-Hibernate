package web.servise;


import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getListUser();

    void save(String name, String surname, int age);

    void update(User User, long id);

    void delete(long id);

    User getUser(long id);

}

