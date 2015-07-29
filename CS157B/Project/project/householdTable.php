<?php
include 'connection.php';

$sql = "SELECT * FROM `household_facts`";
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
    <th>Account Key</th>
    <th>Product Key</th> 
    <th>Branch Key</th>
	<th>Household Key</th>
    <th>Status Key</th> 
    <th>Primary Balance</th>
	<th>Transaction Count</th>
    <th>Account Count</th> 
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
  </tr>";
}
?>