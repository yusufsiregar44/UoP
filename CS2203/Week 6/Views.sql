CREATE OR REPLACE VIEW student_grades AS
select Student.student_id, student_courses.course_id,student_courses.grade
from student
left outer join student_courses on Student.Student_ID = Student_Courses.Student_ID;

SELECT * FROM student_grades;

CREATE OR REPLACE VIEW student_year AS
select Student.student_id, student_courses.year
from student
left outer join student_courses on Student.Student_ID = Student_Courses.Student_ID;

SELECT * FROM student_year;

DROP VIEW student_year;

DROP VIEW view_name;