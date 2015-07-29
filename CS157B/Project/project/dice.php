<?php
include 'connection.php';

$accountlevel = $_POST['accountlevel'];
$branchlevel = $_POST['branchlevel'];
$monthlevel = $_POST['monthlevel'];
$productlevel = $_POST['productlevel'];
$inputs = array();
$empty_inputs = array();
$input11 = $_POST['input11'];
$input12 = $_POST['input12'];
$input13 = $_POST['input13'];
$input21 = $_POST['input21'];
$input22 = $_POST['input22'];
$input23 = $_POST['input23'];
$input31 = $_POST['input31'];
$input32 = $_POST['input32'];
$input33 = $_POST['input33'];
$input41 = $_POST['input41'];
$input42 = $_POST['input42'];
$input43 = $_POST['input43'];

array_push($inputs, $input11);
array_push($inputs, $input12);
array_push($inputs, $input13);
array_push($inputs, $input21);
array_push($inputs, $input22);
array_push($inputs, $input23);
array_push($inputs, $input31);
array_push($inputs, $input32);
array_push($inputs, $input33);
array_push($inputs, $input41);
array_push($inputs, $input42);
array_push($inputs, $input43);

$columns_size = 5;

if($input11 == '' AND $input12 == '' AND $input13 == '')
{array_push($empty_inputs, "account");}
if($input21 == '' AND $input22 == '' AND $input23 == '')
{array_push($empty_inputs, "branch");}
if($input31 == '' AND $input32 == '' AND $input33 == '')
{array_push($empty_inputs, "month");}
if($input41 == '' AND $input42 == '' AND $input43 == '')
{array_push($empty_inputs, "product");}



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
$sql = "select $accountSQL, $branchSQL, $monthSQL, $productSQL, ";

// if(!(in_array("account", $empty_inputs, true)))
// {$sql = $sql . "$accountSQL, ";}
// else
// {$accountHeader = ""; $columns_size -= 1;}
// if(!(in_array("branch", $empty_inputs, true)))
// {$sql = $sql . "$branchSQL, ";}
// else
// {$branchHeader = ""; $columns_size -= 1;}
// if(!(in_array("month", $empty_inputs, true)))
// {$sql = $sql . "$monthSQL, ";}
// else
// {$monthHeader = ""; $columns_size -= 1;}
// if(!(in_array("product", $empty_inputs, true)))
// {$sql = $sql . "$productSQL, ";}
// else
// {$productHeader = ""; $columns_size -= 1;}

$sql = $sql . "primary_balance from household_facts H, account A, branch B, month M, product P where ";

// $sql = "select $accountSQL, $branchSQL, $productSQL, $monthSQL, primary_balance from household_facts H, account A, branch B, month M, product P where ";
if(!(in_array("account", $empty_inputs, true)))
{$sql = $sql . "($accountSQL='$inputs[0]' or $accountSQL='$inputs[1]' or $accountSQL='$inputs[2]') and ";}
if(!(in_array("branch", $empty_inputs, true)))
{$sql = $sql . "($branchSQL='$inputs[3]' or $branchSQL='$inputs[4]' or $branchSQL='$inputs[5]') and ";}
if(!(in_array("month", $empty_inputs, true)))
{$sql = $sql . "($monthSQL='$inputs[6]' or $monthSQL='$inputs[7]' or $monthSQL='$inputs[8]') and ";}
if(!(in_array("product", $empty_inputs, true)))
{$sql = $sql . "($productSQL='$inputs[9]' or $productSQL='$inputs[10]' or $productSQL='$inputs[11]') and ";}


$sql = $sql . "H.account_key = A.account_key and H.branch_key = B.branch_key and H.month_key = M.month_key and H.product_key = P.product_key group by $accountSQL, $branchSQL, $monthSQL,  $productSQL;";


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
	// global $accountHeader, $branchHeader, $productHeader, $monthHeader;
	// echo "<table id='actualBaseTable' class='center'>
  // <tr>";
	// if(!($accountHeader == ""))
    // {echo "<th>$accountHeader</th>";}
    // if(!($branchHeader == ""))
    // {echo "<th>$branchHeader</th>";} 
    // if(!($productHeader == ""))
    // {echo "<th>$productHeader</th>";}
	// if(!($monthHeader == ""))
    // {echo "<th>$monthHeader</th>";}
	// echo"<th>Primary Balance</th>
  // </tr>";
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
	// global $columns_size;
	// echo "
	// <tr>
		// ";
	// for($x = 0; $x < $columns_size; $x++)
	// {
		// echo "<td>$row[$x]</td>
			// ";
	// }
  // echo "</tr>";
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