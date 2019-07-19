<html>
<head>
    <title>Update data in mysql database using php</title>
</head>
<body>
    <center>
    <h1>Update data in mysql database using php</h1>
    <form action="update.php" method="post">
    <input type="text" name="id" placeholder="Enter ID" method="post" required="required"/>
    <input type="submit" name="subbtn" value="Submit" method="post"/></br>

    <?php include "connect.php";
        $name = $result->fetch_array(MYSQL_BOTH);
    ?>
    Name:<?php echo $name['name']; ?>
    <input type="submit" name="chngval" value="Change Name" method="post"/>
    </form>

    <?php if(isset($_POST['chngval'])) {?>
    <form action="update.php" method="post">
    <input type="text" name="id" placeholder="Enter ID" method="post" required="required"/>
    <input type="text" name="name" placeholder="Enter Name" method="post" required="required"/></br>
    <input type="submit" name="submitchng" value="Submit" method="post"/></br>
    </br>

    <?php } if(isset($_POST['submitchng'])) { $id=$_POST['id']; $name=$_POST['name']; try{ $stmt=$conn->prepare("UPDATE users SET name=:name WHERE id=:id");

            $stmt->bindparam(":id",$id);
            $stmt->bindparam(":name",$name);
                    $result=$stmt->execute();
            if($result===TRUE)
            {
                if(($stmt->rowCount())>0)
                {
                    echo "<i>record UPDATED successfully!</i>";
                }
                else{
                  echo "<i>No changes made!</i>";
                }
            }
            else{
                echo "Something Went Wrong!";
            }
            return true;
        }
        catch(PDOException $e)
        {
         echo $e->getMessage();
         return false;
        }
    }
    ?>
    </form>
</body>
</html>