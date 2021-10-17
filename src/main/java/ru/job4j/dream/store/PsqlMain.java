package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

/**
 * Класс PsqlMain
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
public class PsqlMain {
    public static void main(String[] args) {
        Store store = PsqlStore.instOf();
        store.save(new Post(0, "Java Job"));
        for (Post post : store.findAllPosts()) {
            System.out.println(post.getId() + " " + post.getName());
        }
        store.save(new Candidate(0, "First Candidate"));
        for (Candidate candidate : store.findAllCandidates()) {
            System.out.println(candidate.getId() + " " + candidate.getName());
        }
        /* update candidate */
        store.save(new Candidate(1, "Second Candidate"));
        for (Candidate candidate : store.findAllCandidates()) {
            System.out.println(candidate.getId() + " " + candidate.getName());
        }
        System.out.println("***");
        System.out.println(store.findPostById(1));
        System.out.println(store.findCandidateById(1));
    }
}
