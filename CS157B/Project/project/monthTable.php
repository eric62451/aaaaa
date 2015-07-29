<?php
include 'connection.php';

$sql = "SELECT * FROM `month`";
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
    <th>Month</th>
    <th>Year</th> 
    <th>Fiscal Quarter</th>
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
  </tr>";
}
?>