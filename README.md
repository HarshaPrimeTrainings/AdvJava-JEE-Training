# AdvJava-JEE-Training

# Creating a stored procedure to give all the records;
```DELIMITER $$
create procedure select_student()
 BEGIN 
   select * from student;
   END $$
DELIMITER ;
```
# calling stored procedure
call select_student;

# creating stored procedure update grades;
```
DELIMITER $$
create procedure update_grade()
 BEGIN 
   update student set grade='A' where marks>=75;
    update student set grade='B' where marks>=50 AND marks<=76;
     update student set grade='C' where marks>=35 AND marks<=56;
   END $$
DELIMITER ;
```
# calling stored procedure
call update_grade;