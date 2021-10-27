package ru.job4j.dream.servlet;

import org.junit.Test;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.store.PsqlStore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Класс CandidateServletTest - тест сервлета CandidateServlet.
 * Тест запускается из Maven с профилем "test":
 *
 * mvn test -Ptest
 *
 * Настройки тестовой базы данных: /test/resources/db.properties
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
public class CandidateServletTest {

    @Test
    public void whenCreateCandidate() throws IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("id")).thenReturn("0");
        when(req.getParameter("name")).thenReturn("name of new candidate");
        when(req.getParameter("city")).thenReturn("1");
        new CandidateServlet().doPost(req, resp);
        Candidate candidate = PsqlStore.instOf().findCandidateById(1);
        assertThat(candidate.getName(), is("name of new candidate"));
        PsqlStore.instOf().clear("CANDIDATES");
    }
}