package ru.job4j.dream.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.store.PsqlStore;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс IndexServlet - сервлет главной страницы.
 *
 * @author Evgeniy Zaytsev
 * @version 1.0
 */
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
