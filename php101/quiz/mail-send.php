?php
$email = $_POST['email'];
$message = $_POST['message'];
$formcontent=" \n Message: $message\n \nYou have successfully implemented the php mail tutorial.\n Keep Coding! \n\n Regards, \n Technopoints\n https://technopoints.co.in";
$recipient = $email;
$subject = "php mail tutorial";
$mailheader = "From: admin@technopoints.co.in \r\n";
mail($recipient, $subject, $formcontent, $mailheader) or die("Error!");
echo "<center>Your mail has been sent successfully!</center>" . "<center> -</center>" . "<center><a href='mail.html' style='text-decoration:none;color:#ff0099;'> Return Home</a></center>";
?>