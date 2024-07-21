package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class History extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT keyword, timestamp FROM history;");
            ArrayList<HistoryResult> results = new ArrayList<>();
            while (resultSet.next()) {
                HistoryResult historyResult = new HistoryResult();
                historyResult.setKeyword(resultSet.getString("keyword"));
                historyResult.setTimestamp(resultSet.getTimestamp("timestamp"));
                results.add(historyResult);
            }
            request.setAttribute("results", results);
            request.getRequestDispatcher("history.jsp").forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
