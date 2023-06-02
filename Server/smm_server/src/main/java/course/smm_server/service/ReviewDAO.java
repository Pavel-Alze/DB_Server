package course.smm_server.service;

import course.smm_server.models.Place;
import course.smm_server.models.Review;
import course.smm_server.models.User;
import course.smm_server.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReviewDAO implements DAO2<Review,Integer, Place, User>{

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public void create(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getByPk(Integer integer) {
        return reviewRepository.findById(integer).get();
    }

    @Override
    public List<Place> getByFk1(Integer integer) {
        return null;
    }

    @Override
    public List<User> getByFk2(Integer integer) {
        return null;
    }

    @Override
    public void update(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void deleteByPk(Integer integer) {
        reviewRepository.deleteById(integer);
    }

    @Override
    public void deleteAll() {
        reviewRepository.deleteAll();
    }
}
