package ru.job4j.dream.store;

import org.junit.*;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Класс PsqlStoreTest - тест класса хранилища PsqlStore.
 * Тест запускается из Maven с профилем "test":
 *
 * mvn test -Ptest
 *
 * Настройки тестовой базы данных: /test/resources/db.properties
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
public class PsqlStoreTest {

    @Test
    public void findAllPosts() {
        Store store = PsqlStore.instOf();
        Post post1 = new Post(
                0,
                "Java Job 1",
                "Description 1",
                LocalDateTime.now());
        Post post2 = new Post(
                0,
                "Java Job 2",
                "Description 2",
                LocalDateTime.now());
        store.save(post1);
        store.save(post2);
        assertThat(store.findAllPosts(), is(List.of(post1, post2)));
        store.clear("POST");
    }

    @Test
    public void findAllCandidates() {
        Store store = PsqlStore.instOf();
        Candidate candidate1 = new Candidate(
                0,
                "Name1",
                new City(1, ""),
                LocalDateTime.now());
        Candidate candidate2 = new Candidate(
                0,
                "Name2",
                new City(2, ""),
                LocalDateTime.now());
        store.save(candidate1);
        store.save(candidate2);
        assertThat(store.findAllCandidates(), is(List.of(candidate1, candidate2)));
        store.clear("candidates");
    }

    @Test
    public void findAllUsers() {
        Store store = PsqlStore.instOf();
        User user1 = new User(
                0,
                "Name1",
                "Email1",
                "password1");
        User user2 = new User(
                0,
                "Name2",
                "Email2",
                "password2");
        store.save(user1);
        store.save(user2);
        assertThat(store.findAllUsers(), is(List.of(user1, user2)));
        store.clear("USERS");
    }

    @Test
    public void whenSavePost() {
        Store store = PsqlStore.instOf();
        Post post = new Post(
                0,
                "Java Job",
                "Description",
                LocalDateTime.now());
        store.save(post);
        Post postInDb = store.findPostById(1);
        assertThat(postInDb.getName(), is(post.getName()));
        store.clear("POST");
    }

    @Test
    public void whenSaveCandidate() {
        Store store = PsqlStore.instOf();
        Candidate candidate = new Candidate(
                0,
                "Candidate Name",
                new City(1, ""),
                LocalDateTime.now());
        store.save(candidate);
        Candidate candidateInDb = store.findCandidateById(1);
        assertThat(candidateInDb.getName(), is(candidate.getName()));
        store.clear("candidates");
    }

    @Test
    public void whenSaveUser() {
        Store store = PsqlStore.instOf();
        String name = "User name";
        String email = "User@mail.ru";
        User user = new User(
                0,
                name,
                email,
                "password");
        store.save(user);
        User userInDbById = store.findUserById(1);
        assertThat(userInDbById.getName(), is(user.getName()));

        User userInDbByEmail = store.findUserByEmail(email);
        assertThat(userInDbByEmail.getEmail(), is(user.getEmail()));

        store.clear("USERS");
    }

    @Test
    public void deleteCandidate() {
        Store store = PsqlStore.instOf();
        Candidate candidate1 = new Candidate(
                0,
                "Name1",
                new City(1, ""),
                LocalDateTime.now());
        Candidate candidate2 = new Candidate(
                0,
                "Name2",
                new City(2, ""),
                LocalDateTime.now());
        store.save(candidate1);
        store.save(candidate2);
        assertThat(store.findAllCandidates(), is(List.of(candidate1, candidate2)));

        store.deleteCandidate(1);
        assertThat(store.findAllCandidates(), is(List.of(candidate2)));
        store.clear("candidates");
    }

    @Test
    public void deletePost() {
        Store store = PsqlStore.instOf();
        Post post1 = new Post(
                0,
                "Java Job 1",
                "Description 1",
                LocalDateTime.now());
        Post post2 = new Post(
                0,
                "Java Job 2",
                "Description 2",
                LocalDateTime.now());
        store.save(post1);
        store.save(post2);
        assertThat(store.findAllPosts(), is(List.of(post1, post2)));

        store.deletePost(1);
        assertThat(store.findAllPosts(), is(List.of(post2)));
        store.clear("POST");
    }
}