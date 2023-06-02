package course.smm_server.service;

import course.smm_server.models.Login;
import course.smm_server.models.User;
import course.smm_server.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class LoginDAO implements DAO<Login, Integer, User> {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public void create(Login login) {
        loginRepository.save(login);
    }

    @Override
    public List<Login> getAll() {
        return loginRepository.findAll();
    }

    @Override
    public Login getByPk(Integer integer) {
        return loginRepository.findById(integer).get();
    }

    @Override
    public List<User> getByFk(Integer integer) {
        List<User> userList = new ArrayList<>();
        userList.add(loginRepository.findById(integer).get().getUser());
        return userList;
    }

    @Override
    public void update(Login login, Integer integer) {
        loginRepository.save(login);
    }

    @Override
    public void deleteByPk(Integer integer) {
        loginRepository.deleteById(integer);
    }

    @Override
    public void deleteAll() {
        loginRepository.deleteAll();
    }
}
