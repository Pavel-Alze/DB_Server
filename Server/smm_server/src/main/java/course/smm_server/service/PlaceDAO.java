package course.smm_server.service;

import course.smm_server.models.Place;
import course.smm_server.models.Review;
import course.smm_server.models.Shop;
import course.smm_server.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceDAO implements DAO2<Place,Integer, Review, Shop>{

    @Autowired
    PlaceRepository placeRepository;

    @Override
    public void create(Place place) {
        placeRepository.save(place);
    }

    @Override
    public List<Place> getAll() {
        return placeRepository.findAll();
    }

    @Override
    public Place getByPk(Integer integer) {
        return placeRepository.findById(integer).get();
    }

    @Override
    public List<Review> getByFk1(Integer integer) {
        Place place = placeRepository.findById(integer).get();
        return place.getReviews();
    }

    @Override
    public List<Shop> getByFk2(Integer integer) {
        Place place = placeRepository.findById(integer).get();
        return place.getShops();
    }

    @Override
    public void update(Place place, Integer integer) {
        place.setId(integer);
        placeRepository.save(place);
    }

    @Override
    public void deleteByPk(Integer integer) {
        placeRepository.deleteById(integer);
    }

    @Override
    public void deleteAll() {
        placeRepository.deleteAll();
    }
}
