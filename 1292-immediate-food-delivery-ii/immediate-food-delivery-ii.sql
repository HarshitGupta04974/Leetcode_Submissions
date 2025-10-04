# Write your MySQL query statement below
SELECT ROUND(100 *
COUNT(*)/(SELECT COUNT( DISTINCT customer_id ) FROM Delivery),2) AS immediate_percentage
FROM
Delivery as d1
WHERE d1.order_date =
    (SELECT MIN(order_date) 
    FROM Delivery as d2
    WHERE d1.customer_id = d2.customer_id)
 AND
 d1.order_date = d1.customer_pref_delivery_date;