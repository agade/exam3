<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/stylesheet.css" />
        <title>Add A New Artist</title>
    </head>
    <body>

        <div class="wrap"> <!--div to contain all other divs -->

            <%@ include file="includes/header.jsp" %>

            <%@ include file="includes/menu.jsp" %>

            <div class="wrap"> <!--div to contain all other divs -->

                <h1>Add A New Artist</h1>

                <form name="addForm" action="addArtist" method="get">

                    <label>First Name:</label>
                    <input type="text" name="fName" value="" />
                    <br>
                    <label>Last Name:</label>
                    <input type="text" name="lName" value="" />
                    <br>
                    <label>Stage Name:</label>
                    <input type="text" name="sName" value="" />
                    <br>
                    <label>Age:</label>
                    <input type="text" name="date" value="" />
                    <br>
                    <input type="submit" name="submit" value="Submit" />
                    <br>
                    <input type="reset" name="reset" value="Clear" />
                    
                </form>

            </div>

            <%@ include file="includes/footer.jsp" %>

        </div> <!-- close main div -->

    </body>
</html>
