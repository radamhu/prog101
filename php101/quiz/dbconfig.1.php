<?php

$con = mysqli_connect("localhost","root","Pass.word1","quiz");
 
// Check connection
if (mysqli_connect_errno())
  {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();

  }
?>