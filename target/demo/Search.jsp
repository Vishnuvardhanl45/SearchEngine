<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Results</title>
</head>
<body>
    <h1>Search Results</h1>
    <table border="1">
        <tr>
            <th>Webpage Title</th>
            <th>Webpage Link</th>
        </tr>
        <%
            List<SearchResult> searchResults = (List<SearchResult>) request.getAttribute("searchResults");
            for (SearchResult result : searchResults) {
        %>
        <tr>
            <td><%= result.getTitle() %></td>
            <td><a href="<%= result.getLink() %>"><%= result.getLink() %></a></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
