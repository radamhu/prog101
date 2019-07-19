<html>
    <head>
        <title>Retrieve data from mysql database using php</title>
    </head>
    <body>
    <center>
        <h1>Insert data into database using php, mysql</h1>
        <form action="display.php" method="post">
            <input type="text" name="id" placeholder="Enter ID" method="post"/>
            <input type="submit" name="subbtn" value="Submit" method="post"/></br>

            <?php
            if (isset($_POST['subbtn'])) {

                $con = mysqli_connect("localhost", "root", "Pass.word1", "quiz");
                // Check connection
                if (mysqli_connect_errno()) {
                    echo "Failed to connect to MySQL: " . mysqli_connect_error();
                }

                $id = $_POST['id'];

                //Getting Name
                $result = $con->query("SELECT name FROM users WHERE id=$id")
                        or trigger_error($con->error);
                $name = $result->fetch_array();
                echo "<br/>Name: " . $name['name'];
            }
            ?>
        </form>
    </body>
</html>