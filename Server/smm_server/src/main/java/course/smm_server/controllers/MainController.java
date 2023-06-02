package course.smm_server.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import course.smm_server.models.Review;
import course.smm_server.models.User;
import course.smm_server.service.UserDAO;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

@RestController
public class MainController {
    private final UserDAO userDAO;

    public MainController(UserDAO userDAO) {
        this.userDAO = userDAO;
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


}
