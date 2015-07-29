<?php
include 'connection.php';

$sql = "select A.account_city, B.branch_state, P.type, M.month, primary_balance from household_facts H, account A, branch B, month M, product P where H.account_key = A.account_key and H.branch_key = B.branch_key and H.month_key = M.month_key and H.product_key = P.product_key group by B.branch_state, M.month, A.account_city, P.type;";
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
    <th>Account City</th>
    <th>Branch State</th> 
    <th>Type</th>
	<th>Month</th>
	<th>Primary Balance</th>
  </tr>";
}

//creates a row in the outputed table using a row from the query
function createTableRow($row)
{
	echo "
  <tr>
    <td>$row[0]</td>
    <td>$row[1]</td> 
    <td>$row[2]</td>
	<td>$row[3]</td>
	<td>$row[4]</td>
  </tr>";
}
?>