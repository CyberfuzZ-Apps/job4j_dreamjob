package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Класс MemStore - описывает хранилище в памяти.
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
public class MemStore implements Store {

    private static final MemStore INST = new MemStore();

    private static final AtomicInteger POST_ID = new AtomicInteger(4);
    private static final AtomicInteger CANDIDATE_ID = new AtomicInteger(4);
    private static final AtomicInteger USER_ID = new AtomicInteger();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();
    private final Map<Integer, User> users = new ConcurrentHashMap<>();
    private final Map<Integer, City> cities = new ConcurrentHashMap<>();

    private MemStore() {
        posts.put(1, new Post(
                1,
                "Junior Java Job",
                "A java developer with a salary of 1250 dollars is invited",
                LocalDateTime.now()));
        posts.put(2, new Post(2, "Middle Java Job",
                "A java developer with a salary of 2500 dollars is invited",
                LocalDateTime.now()));
        posts.put(3, new Post(3, "Senior Java Job",
                "A java developer with a salary of 4375 dollars is invited",
                LocalDateTime.now()));
        candidates.put(1, new Candidate(1, "Junior Java"));
        candidates.put(2, new Candidate(2, "Middle Java"));
        candidates.put(3, new Candidate(3, "Senior Java"));
        User user = new User();
        user.setId(1);
        user.setName("Admin");
        user.setEmail("root@local");
        user.setPassword("root");
        users.put(1, user);
        cities.put(1, new City(1, "Moscow"));
        cities.put(2, new City(1, "Perm"));
        cities.put(3, new City(1, "Abakan"));
    }

    public static MemStore instOf() {
        return INST;
    }

    @Override
    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    @Override
    public Collection<Post> findTodayPosts() {
        LocalDateTime now = LocalDateTime.now();
        int today = now.getDayOfYear();
        int year = now.getYear();
        List<Post> todayPosts = new ArrayList<>();
        for (Post post : posts.values()) {
            if (year == post.getCreated().getYear()
                    && today == post.getCreated().getDayOfYear()) {
                todayPosts.add(post);
            }
        }
        return todayPosts;
    }

    @Override
    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }

    @Override
    public Collection<Candidate> findTodayCandidates() {
        LocalDateTime now = LocalDateTime.now();
        int today = now.getDayOfYear();
        int year = now.getYear();
        List<Candidate> todayCandidates = new ArrayList<>();
        for (Candidate c : candidates.values()) {
            if (year == c.getCreated().getYear()
                    && today == c.getCreated().getDayOfYear()) {
                todayCandidates.add(c);
            }
        }
        return todayCandidates;
    }

    @Override
    public void save(Post post) {
        if (post.getId() == 0) {
            post.setId(POST_ID.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }

    @Override
    public void save(Candidate candidate) {
        if (candidate.getId() == 0) {
            candidate.setId(CANDIDATE_ID.incrementAndGet());
        }
        candidates.put(candidate.getId(), candidate);
    }

    @Override
    public Post findPostById(int id) {
        return posts.get(id);
    }

    @Override
    public Candidate findCandidateById(int id) {
        return candidates.get(id);
    }

    @Override
    public Collection<User> findAllUsers() {
        return users.values();
    }

    @Override
    public void save(User user) {
        if (user.getId() == 0) {
            user.setId(USER_ID.incrementAndGet());
        }
        users.put(user.getId(), user);
    }

    @Override
    public User findUserById(int id) {
        return users.get(id);
    }

    @Override
    public User findUserByEmail(String email) {
        for (User user : users.values()) {
            if (email.equals(user.getEmail())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public Collection<City> findAllCities() {
        return cities.values();
    }

    @Override
    public void deleteCandidate(int id) {
        for (Map.Entry<Integer, Candidate> set : candidates.entrySet()) {
            if (id == set.getValue().getId()) {
                candidates.remove(set.getKey());
                break;
            }
        }
    }

    @Override
    public void deletePost(int id) {
        for (Map.Entry<Integer, Post> set : posts.entrySet()) {
            if (id == set.getValue().getId()) {
                posts.remove(set.getKey());
                break;
            }
        }
    }

    @Override
    public void clear(String name) {

    }
}
