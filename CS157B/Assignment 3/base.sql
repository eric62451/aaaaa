/*base*/
SELECT f.storeID, s.city, s.county, month, year, sum(sales_in_dollar) sales FROM sales f, store s, date d WHERE f.storeID = s.storeID AND f.dateID = d.dateID GROUP BY f.storeID, month;