package course.smm_server.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "places")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Review> reviewList;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Shop> shopList;

    public void addReviews(Review review){
        review.setPlace(this);
        reviewList.add(review);
    }

    public void addShops(Shop shop){
        shop.setPlace(this);
        shopList.add(shop);
    }

    public List<Review> getReviews(){
        return reviewList;
    }
    public List<Shop> getShops(){
        return shopList;
    }
}
