/*Roll-up on store dimension*/
SELECT s.county, month, year, sum(sales_in_dollar) FROM sales f, store s, date d WHERE f.storeID = s.storeID AND f.dateID = d.dateID GROUP BY county, month;