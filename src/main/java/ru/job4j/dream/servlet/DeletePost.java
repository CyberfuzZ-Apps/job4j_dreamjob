package ru.job4j.dream.servlet;

import ru.job4j.dream.store.PsqlStore;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Класс DeletePost - сервлет удаления вакансии.
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
public class DeletePost extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PsqlStore.instOf().deletePost(Integer.parseInt(request.getParameter("id")));
        request.getRequestDispatcher("/posts.do").forward(request, response);
    }

}
