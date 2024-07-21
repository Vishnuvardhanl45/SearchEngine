<%@ page import="java.util.ArrayList" %>
<%@ page import="com.Accio.HistoryResult" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1>Search History</h1>
<table border="2" class="table-fill">
    <tr>
        <th class="text-left">Keyword</th>
        <th class="text-left">Timestamp</th>
    </tr>
    <%
        ArrayList<HistoryResult> results = (ArrayList<HistoryResult>)request.getAttribute("results");
        for (HistoryResult result : results) {
    %>
    <tr class="table-hover">
        <td><%= result.getKeyword() %></td>
        <td><%= result.getTimestamp() %></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
