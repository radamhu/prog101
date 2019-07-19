<html>
<head>
    <title>Insert data into database using php, mysql</title>
</head>
<body>
    <center>
        <h1>Insert data into database using php, mysql</h1>
        <form action="import.php" method="post">
            <input type="text" name="name" placeholder="Enter Name" method="post"/></br></br>
            <input type="text" name="email" placeholder="Enter Email" method="post"/></br></br>
            <input type="text" name="contact" placeholder="Enter Contact No." method="post"/></br></br>
            <input type="submit" name="subbtn" value="Submit" method="post"/></br>

<?php
    include 'connect.php';

    if(isset($_POST['subbtn'])) {
        $name=$_POST['name'];
        $email=$_POST['email'];
        $contact=$_POST['contact'];
        $sql = "INSERT INTO users (name, email, contact) VALUES ('$name', '$email', '$contact')";
            // use exec() because no results are returned
            $conn->exec($sql);
            echo "New record created successfully";
    }
?>
        </form>
    </center>
</body>
</html>