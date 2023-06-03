package course.smm_server.service;

import course.smm_server.models.Place;
import course.smm_server.models.Shop;
import course.smm_server.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ShopDAO implements DAO<Shop,Integer, Place>{

    @Autowired
    ShopRepository shopRepository;

    @Override
    public void create(Shop shop) {
        shopRepository.save(shop);
    }

    @Override
    public List<Shop> getAll() {
        return shopRepository.findAll();
    }

    @Override
    public Shop getByPk(Integer integer) {
        return shopRepository.findById(integer).get();
    }

    @Override
    public List<Place> getByFk(Integer integer) {
        return null;
    }

    @Override
    public void update(Shop shop, Integer integer) {
        shop.setId(integer);
        shopRepository.save(shop);
    }

    @Override
    public void deleteByPk(Integer integer) {
        shopRepository.deleteById(integer);
    }

    @Override
    public void deleteAll() {
        shopRepository.deleteAll();
    }
}
