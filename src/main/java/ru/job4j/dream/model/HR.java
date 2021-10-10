package ru.job4j.dream.model;

import java.util.Objects;

/**
 * Класс HR - описывает модель данных кадровика.
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
public class HR {
    private int id;
    private String name;

    public HR(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HR hr = (HR) o;
        return id == hr.id && Objects.equals(name, hr.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "HR{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }
}
