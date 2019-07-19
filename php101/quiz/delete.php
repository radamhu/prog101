<html>
    <head>
        <title>Delete Data from Mysql database using php</title>
    </head>
    <body>
    <center>
        <h1>Delete Data from Mysql database using php</h1>
        <form action="delete.php" method="post">
            <input type="text" name="id" placeholder="Enter ID" method="post"/>
            <input type="submit" name="delbtn" value="Submit" method="post"/></br>
    </center>
</form>
</body>
</html>
<?php
include "connect.php";

if (isset($_POST['delbtn'])) {
    $del = $_POST['id'];
    try {
        $stmt = $conn->prepare("DELETE FROM users WHERE id=:del");
        $stmt->bindparam(":del", $del);
        $result = $stmt->execute();
        if ($result === TRUE) {
            if (($stmt->rowCount()) > 0) {
                echo "<center>record Deleted successfully!</center>";
            } else {
                echo "<center>No such record exists!</center>";
            }
        } else {
            echo "<center>Something Went Wrong!</center>";
        }
        return true;
    } catch (PDOException $e) {
        echo $e->getMessage();
        return false;
    }
}
?>