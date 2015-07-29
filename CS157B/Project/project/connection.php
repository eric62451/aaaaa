 <?php
$username = "root";
$password = "99643333";
$hostname = "localhost";
$dbname = "bank";

// connection to the database
$con = new mysqli($hostname, $username, $password, $dbname);

    if($con->connect_errno)
		{die("Error connecting" . $myqli->connect_error);}

 ?>