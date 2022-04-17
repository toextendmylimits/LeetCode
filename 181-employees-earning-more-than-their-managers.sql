# Write your MySQL query statement below
##inner join Employee as manager
#on employee.managerId = manager.id and employee.salary > manager.salary

select e.name as 'Employee'
from Employee as e, Employee as m
where e.managerId = m.Id and e.salary > m.salary
