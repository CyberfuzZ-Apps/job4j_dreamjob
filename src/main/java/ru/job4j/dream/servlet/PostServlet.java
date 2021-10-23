package ru.job4j.dream.servlet;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * Класс PostServlet - сервлет списка вакансий.
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
public class PostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("posts", new ArrayList<>(PsqlStore.instOf().findAllPosts()));
        req.setAttribute("user", req.getSession().getAttribute("user"));
        req.getRequestDispatcher("posts.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        PsqlStore.instOf().save(
                new Post(
                        Integer.parseInt(req.getParameter("id")),
                        req.getParameter("name"),
                        req.getParameter("description"),
                        LocalDateTime.now()
                )
        );
        resp.sendRedirect(req.getContextPath() + "/posts.do");
    }
}
