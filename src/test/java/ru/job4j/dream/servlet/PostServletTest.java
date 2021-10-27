package ru.job4j.dream.servlet;

import org.junit.Test;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.store.PsqlStore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Класс PostServletTest - тест сервлета PostServlet.
 * Тест запускается из Maven с профилем "test":
 *
 * mvn test -Ptest
 *
 * Настройки тестовой базы данных: /test/resources/db.properties
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
public class PostServletTest {

    @Test
    public void whenCreatePost() throws IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("id")).thenReturn("0");
        when(req.getParameter("name")).thenReturn("name of new post");
        when(req.getParameter("description")).thenReturn("d");
        new PostServlet().doPost(req, resp);
        Post post = PsqlStore.instOf().findPostById(1);
        assertThat(post.getName(), is("name of new post"));
        PsqlStore.instOf().clear("POST");
    }
}