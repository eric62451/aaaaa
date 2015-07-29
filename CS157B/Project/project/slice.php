<?php
include 'connection.php';

$accountlevel = $_POST['accountlevel'];
$branchlevel = $_POST['branchlevel'];
$monthlevel = $_POST['monthlevel'];
$productlevel = $_POST['productlevel'];
$dimension = $_POST['name'];
$input = $_POST['input'];

switch ($accountlevel) {
    case 1:
        $accountSQL = "A.account_address";
		$accountHeader = "Account Address";
        break;
    case 2:
        $accountSQL = "A.account_city";
		$accountHeader = "Account City";
        break;
    case 3:
        $accountSQL = "A.account_state";
		$accountHeader = "Account State";
        break;
    default:
        die("error reading account level");
}

switch ($branchlevel) {
    case 1:
        $branchSQL = "B.branch_address";
		$branchHeader = "Branch Address";
        break;
    case 2:
        $branchSQL = "B.branch_city";
		$branchHeader = "Branch City";
        break;
    case 3:
        $branchSQL = "B.branch_state";
		$branchHeader = "Branch State";
        break;
    default:
        die("error reading branch level");
}

switch ($monthlevel) {
    case 1:
        $monthSQL = "M.month";
		$monthHeader = "Month";
        break;
    case 2:
        $monthSQL = "M.year";
		$monthHeader = "year";
        break;
    case 3:
        $monthSQL = "M.fiscal_quarter";
		$monthHeader = "Fiscal Quarter";
        break;
    default:
        die("error reading month level");
}

switch ($productlevel) {
    case 1:
        $productSQL = "P.product_description";
		$productHeader = "Product Description";
        break;
    case 2:
        $productSQL = "P.type";
		$productHeader = "Product Type";
        break;
    case 3:
        $productSQL = "P.category";
		$productHeader = "Product Category";
        break;
    default:
        die("error reading product level");
}

switch ($dimension) {
    case "account":
		$sql = "select $accountSQL, $branchSQL, $productSQL, $monthSQL, primary_balance from household_facts H, account A, branch B, month M, product P where $accountSQL='$input' and H.account_key = A.account_key and H.branch_key = B.branch_key and H.month_key = M.month_key and H.product_key = P.product_key group by $branchSQL, $monthSQL, $accountSQL, $productSQL;";
        break;
    case "branch":
		$sql = "select $accountSQL, $branchSQL, $productSQL, $monthSQL, primary_balance from household_facts H, account A, branch B, month M, product P where $branchSQL='$input' and H.account_key = A.account_key and H.branch_key = B.branch_key and H.month_key = M.month_key and H.product_key = P.product_key group by $branchSQL, $monthSQL, $accountSQL, $productSQL;";
        break;
    case "month":
		$sql = "select $accountSQL, $branchSQL,$productSQL, $monthSQL, primary_balance from household_facts H, account A, branch B, month M, product P where $monthSQL='$input' and H.account_key = A.account_key and H.branch_key = B.branch_key and H.month_key = M.month_key and H.product_key = P.product_key group by $branchSQL, $monthSQL, $accountSQL, $productSQL;";
        break;
	case "product":
		$sql = "select $accountSQL, $branchSQL, $productSQL, $monthSQL, primary_balance from household_facts H, account A, branch B, month M, product P where $productSQL='$input' and H.account_key = A.account_key and H.branch_key = B.branch_key and H.month_key = M.month_key and H.product_key = P.product_key group by $branchSQL, $monthSQL, $accountSQL, $productSQL;";
		break;
    default:
        die("error getting dimension name");
}
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
	global $accountHeader, $branchHeader, $productHeader, $monthHeader;
	echo "<table id='actualBaseTable' class='center'>
  <tr>
    <th>$accountHeader</th>
    <th>$branchHeader</th> 
    <th>$productHeader</th>
	<th>$monthHeader</th>
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