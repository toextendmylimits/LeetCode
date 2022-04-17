# Write your MySQL query statement below
select w.id as 'Id' from Weather as w
inner join Weather as yesterdayW
on DATEDIFF(w.recordDate, yesterdayW.recordDate) = 1 and w.temperature > yesterdayW.temperature
