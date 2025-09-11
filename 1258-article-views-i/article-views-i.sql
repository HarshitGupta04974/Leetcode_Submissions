/* Write your T-SQL query statement below */
SELECT Distinct(t1.author_id) as id FROM views as t1
WHERE t1.author_id=t1.viewer_id;