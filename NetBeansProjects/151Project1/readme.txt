Requirement 1:
1000
500
500
3000
-------Initialized the ATM-----------
Requirement 2:
1
4567
3451010
0315
0050
500

1
4567
3451010
0315
0050
500

1
4567
3451015
0913
0075
500

1
4567
3451015
0913
0075
500

1
4567
3451005
1014
0025
500

1
4567
3451005
1014
0025
300
1
----------ATM1 out of cash-----------
Requirement 3,4,5,6,10 and 11:
2
4567
3451001
0313     <------- DATE: MMYY Expired    #3
4566     <------- different bank ID     #10
3451004
0315
0004     <-------- authorization rejected, Bank not supported by ATM   #5
2
4567
3451005
1014     <-------- Valid card, Starts authorization   #3
0024     <-------- authorization rejected, wrong password. prompt user to enter password again   #4,5,11
0025     <-------- Correct password, authorization complete #11
140      <-------- Transaction dialogue, withdraw 140   #6

-------ATM Checks if cards are valid--------
Requirement 7,8,9,13,14 and 15:
2
4567
3451020
1215
0010
0010
0010     <------ Wrong password 3 times, does not return the card  #7
4567
3451005
1014
0025
520      <------ over transaction limit   #8,14
60       <------ account not enough balance  #9,13,14
20       <------ successfully withdraw   #9,15
------------------------------------------------
Requirement 11 and 12:
2
4567
3451004   <----- invalid cashcard #11,12	
0319
0005
4567
3455035
0917
0375
2
20
0
------------------------------------------------------