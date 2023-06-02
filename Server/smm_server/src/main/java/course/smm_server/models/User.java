package course.smm_server.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
@JsonAutoDetect
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column
    public String name;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "login_id")
    private Login login;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviewList;

    public void setLogin(Login login) {
        this.login = login;
    }

    public void addReviews(Review review){
        review.setUser(this);
        reviewList.add(review);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Review> getReviewList(){
        return reviewList;
    }
}