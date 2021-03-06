package ru.job4j.dream.servlet;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Класс CandidateServlet - сервлет списка кандидатов.
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
public class CandidateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("candidates", PsqlStore.instOf().findAllCandidates());
        req.getRequestDispatcher("candidates.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        PsqlStore.instOf().save(
                new Candidate(
                        Integer.parseInt(req.getParameter("id")),
                        req.getParameter("name"),
                        new City(Integer.parseInt(req.getParameter("city")), ""),
                        LocalDateTime.now()
                )
        );
        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }
}
