package com.courses.rest.webservices.restfulwebservices.user;

import com.courses.rest.webservices.restfulwebservices.error.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {
    public static List<User> users = new ArrayList<>();
    public static int userCounter = 3;


    static {
        users.add(new User(1,"Matej", "m.l@gmail.com", LocalDate.of(1999, Month.JANUARY, 3) ));
        users.add(new User(2, "Josip", "j.lo@gmail.com", LocalDate.of(2003, Month.FEBRUARY, 4) ));
        users.add(new User(3, "Karlo", "k.nje@gmail.com", LocalDate.of(1991, Month.DECEMBER, 5) ));
    }


    public List<User> findAll(){
        return users;
    }

    public User findById(int userId){
        return users.stream()
                .filter(user -> user.getId() == userId)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    public User save(User user) {
        user.setId(++userCounter);
        users.add(user);
        return user;
    }
}
