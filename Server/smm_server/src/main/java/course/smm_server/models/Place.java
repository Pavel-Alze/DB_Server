package course.smm_server.models;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "places")
@JsonAutoDetect
@JsonIgnoreProperties({"shops","reviews"})
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviewList;
    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Shop> shopList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
