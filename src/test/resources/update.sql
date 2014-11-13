alter table course add column MAX_STUDENTS int default 1;
update course set max_students = 20;
update course set max_students = 5 where id = 3;/*This will give an error when adding a student into 93.26 **/