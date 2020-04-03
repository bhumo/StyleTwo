 create view studentView as
 select roll_number,student.name as name,address,city_code,gender,indian,city.name as city_name,date_of_birth from student inner join city on city.code =student.city_code;