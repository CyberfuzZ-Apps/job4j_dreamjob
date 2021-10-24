package ru.job4j.dream.store;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.User;

import java.util.List;

/**
 * Класс PsqlMain
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
public class PsqlMain {
    public static void main(String[] args) {
        List<City> cities = (List<City>) PsqlStore.instOf().findAllCities();
        Gson gson = new GsonBuilder().create();
        String s = gson.toJson(cities);
        System.out.println(s);
//        Store store = PsqlStore.instOf();
//        User user = new User(
//                0,
//                "Mark",
//                "mark@mail.ru",
//                "12345"
//        );
//        store.save(user);
//        for (User u : store.findAllUsers()) {
//            System.out.println(u.getId() + " "
//                    + u.getName() + " "
//                    + u.getEmail() + " "
//                    + u.getPassword());
//        }
//        System.out.println("*****");
//        System.out.println(store.findUserById(1));
//        System.out.println(store.findUserByEmail("mark@mail.ru"));
    }
}
