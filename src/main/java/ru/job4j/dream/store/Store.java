package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Collection;

/**
 * Интерфейс Store - описывает хранилище.
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
public interface Store {
    Collection<Post> findAllPosts();

    Collection<Post> findTodayPosts();

    Collection<Candidate> findAllCandidates();

    Collection<Candidate> findTodayCandidates();

    Collection<User> findAllUsers();

    Collection<City> findAllCities();

    void save(Post post);

    void save(Candidate candidate);

    void save(User user);

    Post findPostById(int id);

    Candidate findCandidateById(int id);

    User findUserById(int id);

    User findUserByEmail(String email);
}
