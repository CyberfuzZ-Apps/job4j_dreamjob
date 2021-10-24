package ru.job4j.dream.servlet;

import ru.job4j.dream.Config;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Класс PhotoDeleteServlet - сервлет удаляет фото кандидата.
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
public class PhotoDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String path = Config.value("path");
        String id = req.getParameter("id");
        File file = new File(path + id);
        file.delete();
        resp.sendRedirect(req.getContextPath() + "/candidate/edit.jsp?id=" + id);
    }

}
