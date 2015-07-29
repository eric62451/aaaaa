drop table if exists Sales;
drop table if exists Store;
drop table if exists Date;


create table Store(storeID char(10) primary key, city Char(20), county Char(30), state Char(15), country Char(15));

create table Date(dateID Integer primary key, day Integer, month Char(10), quarter Integer, year Integer);

create table Sales(storeID char(10) references Store(storeID), dateID Integer, sales_in_dollar Decimal(6,2), FOREIGN KEY (storeID) REFERENCES Store(storeID), FOREIGN KEY (dateID) REFERENCES Date(dateID));

