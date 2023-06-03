package course.smm_server.models;


import jakarta.persistence.*;

@Entity
@Table(name="logins")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    @Column
    private String login;
    private String password;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "login")
    private User user;

    public void addUser(User user) {
        user.setLogin(this);
        this.user=user;
    }

    public User getUser(){
        return user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
