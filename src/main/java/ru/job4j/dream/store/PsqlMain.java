package ru.job4j.dream.store;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Класс PsqlMain
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
public class PsqlMain {
    public static void main(String[] args) {
        Candidate candidate = new Candidate(0, "Today's candidate", 1, LocalDateTime.now());
        PsqlStore.instOf().save(candidate);
        System.out.println(PsqlStore.instOf().findTodayCandidates());
    }
}
