package com.example;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Search extends HttpServlet {

    private static final String API_KEY = "AIzaSyA1XfSpJToP9yMVADpu_bZuo55Ca3Lbd9E";
    private static final String CSE_ID = "15a23e0601e684f76";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = request.getParameter("query");
        if (query != null && !query.isEmpty()) {
            try {
                // Store the search keyword in the database
                storeKeyword(query);

                // Construct the URL for the Google CSE API request
                String encodedQuery = URLEncoder.encode(query, "UTF-8");
                String apiUrl = "https://www.googleapis.com/customsearch/v1?key=" + API_KEY + "&cx=" + CSE_ID + "&q="
                        + encodedQuery;

                // Create an HttpClient
                HttpClient httpClient = HttpClients.createDefault();

                // Create an HTTP GET request
                HttpGet httpGet = new HttpGet(apiUrl);

                // Execute the request and get the response
                HttpResponse apiResponse = httpClient.execute(httpGet);

                // Check if the request was successful (status code 200)
                if (apiResponse.getStatusLine().getStatusCode() == 200) {
                    // Parse and set the response content (search results)
                    String responseBody = EntityUtils.toString(apiResponse.getEntity());
                    request.setAttribute("searchResults", responseBody);
                    request.getRequestDispatcher("Search.jsp").forward(request, response);
                } else {
                    response.getWriter().println("Error: " + apiResponse.getStatusLine().getReasonPhrase());
                }
            } catch (Exception e) {
                throw new ServletException("Error processing search request", e);
            }
        } else {
            response.getWriter().println("Please enter a search query.");
        }
    }

    private void storeKeyword(String keyword) {
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("INSERT INTO history (keyword) VALUES (?)")) {
            System.out.println("Inserting keyword: " + keyword);
            preparedStatement.setString(1, keyword);
            preparedStatement.executeUpdate();
            System.out.println("Keyword inserted successfully.");
        } catch (Exception e) {
            System.err.println("Error storing keyword in the database: " + e.getMessage());
            throw new RuntimeException("Error storing keyword in the database", e);
        }
    }
}
