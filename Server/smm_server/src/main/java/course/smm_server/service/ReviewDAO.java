package course.smm_server.service;

import course.smm_server.models.Place;
import course.smm_server.models.Review;
import course.smm_server.models.User;
import course.smm_server.repository.ReviewRepository;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class ReviewDAO implements DAO2<Review,Integer, Place, User>{

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public void create(Review review) {
        reviewRepository.save(review);
    }

    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Review> getAll() {
        return em.createQuery("from Review", Review.class).getResultList();
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
    public void update(Review review, Integer integer) {
        review.setId(integer);
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
