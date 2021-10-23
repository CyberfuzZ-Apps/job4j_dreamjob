package ru.job4j.dream.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Класс Candidate - описывает модель данных кандидата.
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
public class Candidate {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    private int id;
    private String name;
    private String city;
    private LocalDateTime created;
    private String formattedDate;

    public Candidate() {
    }

    public Candidate(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Candidate(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Candidate(int id, String name, String city, LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getFormattedDate() {
        return FORMATTER.format(created);
    }

    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Candidate candidate = (Candidate) o;
        return id == candidate.id && Objects.equals(name, candidate.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Candidate{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", city=" + city
                + ", created=" + created
                + '}';
    }
}
