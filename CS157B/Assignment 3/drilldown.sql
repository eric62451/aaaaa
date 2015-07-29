/*Drill-down on date dimension*/
SELECT f.storeID, s.city, s.county, day, month, year, sales_in_dollar sales FROM sales f, store s, date d WHERE f.storeID = s.storeID AND f.dateID = d.dateID;