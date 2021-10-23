package ru.job4j.dream.servlet;

import ru.job4j.dream.Config;
import ru.job4j.dream.store.PsqlStore;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;

/**
 * Класс DeleteCandidate - сервлет удаления кандидата.
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
public class DeleteCandidate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PsqlStore.instOf().deleteCandidate(Integer.parseInt(request.getParameter("id")));
        String path = Config.value("path");
        String id = request.getParameter("id");
        File file = new File(path + id);
        file.delete();
        request.getRequestDispatcher("/candidates.do").forward(request, response);
    }
}
