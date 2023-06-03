package course.smm_server.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import course.smm_server.models.*;
import course.smm_server.service.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

@RestController
public class MainController {
    private final UserDAO userDAO;
    private final PlaceDAO placeDAO;
    private final ShopDAO shopDAO;
    private final ReviewDAO reviewDAO;
    private final LoginDAO loginDAO;
    public MainController(UserDAO userDAO, PlaceDAO placeDAO, ShopDAO shopDAO,
                          ReviewDAO reviewDAO, LoginDAO loginDAO) {
        this.userDAO = userDAO;
        this.placeDAO = placeDAO;
        this.shopDAO = shopDAO;
        this.reviewDAO = reviewDAO;
        this.loginDAO = loginDAO;
    }

    @GetMapping(value = "/users")
    public List<User> readUser() throws IOException {
        final List<User> users = userDAO.getAll();

        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, users);
        System.out.println(writer.toString());

        return users;
    }
    @GetMapping(value = "/users/{id}")
    public User readUserById(@PathVariable Integer id) throws IOException{
        final  User user = userDAO.getByPk(id);
        return user;
    }
    @GetMapping(value = "/users/{id}/reviews")
    public List<Review> readReviewsByUserId(@PathVariable Integer id) throws IOException{
        final  List<Review> reviewList = userDAO.getByFk(id);
        return reviewList;
    }
    @PatchMapping(value = "/users/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody User user){
        userDAO.update(user,id);
    }

    @PostMapping(value = "/users")
    public void createUser(@RequestBody User user){
        userDAO.create(user);
    }

    @DeleteMapping(value = "/users")
    public void  deleteUsers(){
        userDAO.deleteAll();
    }

    @DeleteMapping(value = "/users/{id}")
    public void deleteUsersById(@PathVariable Integer id) throws IOException{
        userDAO.deleteByPk(id);
    }

    @GetMapping(value = "/places/{id}")
    public Place readPlacesById(@PathVariable Integer id){
        final Place place = placeDAO.getByPk(id);
        return place;
    }

    @GetMapping(value = "/places")
    public List<Place> readPlaces(){
        final List<Place> placeList = placeDAO.getAll();
        return placeList;
    }

    @GetMapping(value = "/shops")
    public List<Shop> readShops(){
        return shopDAO.getAll();
    }
    @GetMapping(value = "/shops/{id}")
    public Shop readShopsById(@PathVariable Integer id){
        return shopDAO.getByPk(id);
    }

    @GetMapping(value = "/reviews")
    public List<Review> readReviews(){
        return reviewDAO.getAll();
    }
    @GetMapping(value = "/reviews/{id}")
    public Review readReviewsById(@PathVariable Integer id){
        return reviewDAO.getByPk(id);
    }

    @DeleteMapping(value = "/reviews/{id}")
    public void deleteReviewsById(@PathVariable Integer id){
        reviewDAO.deleteByPk(id);
    }
    @PostMapping(value = "/login")
    public void createLogin(@RequestBody Login login){
        loginDAO.create(login);
    }

}
