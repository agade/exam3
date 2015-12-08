<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/stylesheet.css" />
        <title>JSP Page</title>
    </head>

    <% String table = (String) request.getAttribute("table");%>


    <body>

        <div class="wrap"> <!--div to contain all other divs -->

            <%@ include file="includes/header.jsp" %>

            <%@ include file="includes/menu.jsp" %>

            <div class="wrap"> <!--div to contain all other divs -->
                <h1>Alex's Favorite Artists</h1>

                <%= table%>

                <br><br>

                <a href ="add">Add A New Artist</a>
                <br><br>
                <a href="search.jsp">Search Artists</a>

            </div>

            <%@ include file="includes/footer.jsp" %>

        </div> <!-- close main div -->

    </body>
</html>
