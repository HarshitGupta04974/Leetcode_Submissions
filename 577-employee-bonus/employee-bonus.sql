/* Write your T-SQL query statement below */
SELECT t3.name,t3.bonus FROM
(SELECT t1.name,t2.bonus FROM Employee t1
FULL OUTER JOIN Bonus t2 
ON t1.empId=t2.empId) t3
WHERE t3.bonus<1000 OR t3.bonus IS NULL