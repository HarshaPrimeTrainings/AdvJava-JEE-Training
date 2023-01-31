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
```
call select_student;
```
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
```
call update_grade;
```
# Create strored procedure to insert values with IN parameters;
```
DELIMITER $$
create procedure insert_student(IN roll INT, IN name varchar(100), IN addr varchar(100), IN marks INT, IN grade varchar(45))
 BEGIN 
  insert into student values (roll,name,addr,marks,grade);
   END $$
DELIMITER ;
```
 # Calling stored procedure with in parameters;
 ```
 call insert_student(1,'Ross','NY',75,'A')
```
