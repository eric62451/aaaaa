<?php
include 'connection.php';

$sql = "SELECT * FROM `account`";
$result = $con->query($sql);

if ($result->num_rows > 0) {
    
	createTableHeaders();
	
    while($row = $result->fetch_array(MYSQLI_BOTH)) {
        createTableRow($row);
    }
} else {
    echo "0 results";
}
echo "</table>";
$con->close();

//end of file

//creates table headers
function createTableHeaders()
{
	echo "<table id='actualBaseTable' class='center'>
  <tr>
    <th>Primary Surname</th>
    <th>Secondary Surname</th> 
    <th>Account Address</th>
	<th>Account City</th>
	<th>Account State Balance</th>
	<th>Account Zip</th>
    <th>Date Opened</th> 
    <th>Primary Age</th>
	<th>Primary sex</th>
	<th>Primary Marital</th>
  </tr>";
}

//creates a row in the outputed table using a row from the query
function createTableRow($row)
{
	echo "
  <tr>
    <td>$row[1]</td> 
    <td>$row[2]</td>
	<td>$row[3]</td>
	<td>$row[4]</td>
	<td>$row[5]</td>
    <td>$row[6]</td> 
    <td>$row[7]</td>
	<td>$row[8]</td>
	<td>$row[9]</td>
	<td>$row[10]</td>
  </tr>";
}
?>