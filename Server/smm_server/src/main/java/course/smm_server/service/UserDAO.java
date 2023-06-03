package course.smm_server.service;

import course.smm_server.models.Review;
import course.smm_server.models.User;
import course.smm_server.repository.UserRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserDAO implements DAO<User,Integer,Review>{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getByPk(Integer integer) {
        return userRepository.findById(integer).get();
    }

    @Override
    public List<Review> getByFk(Integer integer){
        User user = userRepository.findById(integer).get();
        return user.getReviewList();
    }
    @Override
    public void update(User user, Integer integer){
        user.setId(integer);
        userRepository.save(user);
    }

    @Override
    public void deleteByPk(Integer integer) {
        userRepository.deleteById(integer);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
