<%@page import="model.Artist"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Artists artist = (Artists) request.getAttribute("artist");%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update An Artist</title>

        <link rel="stylesheet" type="text/css" href="CSS/stylesheet.css" />

    </head>
    <body>

        <div class="wrap"> <!--div to contain all other divs -->

            <%@ include file="includes/header.jsp" %>

            <%@ include file="includes/menu.jsp" %>

            <div class="wrap"> <!--div to contain all other divs -->

                <h1>Update An Artist Record</h1>

                <form name="updateForm" action="updateAlbum" method="get">

                    <table class="update">
                        <label>Artist ID:</label>
                        <input type="text" name="id" value="<%= artist.getArtistID()%>" readonly />
                        <label>First Name:</label>
                        <input type="text" name="fName" value="<%= artist.getFName()%>" />
                        <br>
                        <label>Last Name:</label>
                        <input type="text" name="lName" value="<%= artist.getLName()%>" />
                        <br>
                        <label>Stage Name:</label>
                        <input type="text" name="stageName" value="<%= artist.getStageName()%>" />
                        <br>
                        <label>Age:</label>
                        <input type="text" name="age" value="<%= artist.getAge()%>" />
                    </table>
                    <br>
                    <input type="submit" name="submit" value="Update" />
                    <br>
                    <input type="reset" name="reset" value="Clear" />
                </form>

            </div>

            <%@ include file="includes/footer.jsp" %>

        </div> <!-- close main div -->

    </body>
</html>
