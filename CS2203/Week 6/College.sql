CREATE TABLE Student(
    Student_ID char(4) primary key ,
    Student_Name char(5),
    Dept_Name varchar(30)
);

CREATE TABLE Student_Courses(
    Student_ID char(4),
    Course_ID varchar(30),
    Section int,
    Year int,
    Grade char(1)
);

INSERT INTO Student (Student_ID, Student_Name, Dept_Name) VALUES
('0000','AAAAA', 'Computer Science'),
('1111', 'BBBBB', 'Computer Science'),
('2222', 'CCCCC', 'Business Administration'),
('3333', 'DDDDD', 'Education'),
('4444', 'EEEEE', 'Physics'),
('5555', 'FFFFF', 'History')
;

INSERT INTO Student_Courses (Student_ID, Course_ID, Section, Year, Grade) VALUES
('0000',	'CS 2203',	'2'	, 2020,	'A'),
('0000',	'CS 1101',	'1'	,2019	,'A'),
('1111',	'CS 1101',	'5'	,2019	,'B'),
('1111',	'CS 1102',	'1'	,2019	,'B'),
('1111',	'CS 2204',	'1'	,2020	,'A'),
('1111',	'CS 2401',	'1'	,2020	,'A'),
('2222',	'BUS 1101',	'3'	,2019	,'C'),
('2222',	'BUS 2201',	'1'	,2020	,'B'),
('2222',	'BUS 3302',	'1'	,2020	,'B'),
('3333',	'EDUC 501','0'		 ,2019	,'A'),
('3333',	'EDUC 521','0'		,2020	,'B'),
('4444',	'PHY 110','1'		,2019	,'A'),
('4444',	'PHY 220','2'		,2020	,'C'),
('4444',	'PHY 330','4'		, 2020,	'A');

-- Inner join
select Student.student_id, Student.student_name, Student_Courses.Course_ID
from student
join student_courses on Student.Student_ID = Student_Courses.Student_ID;

-- union
select student_id from student
union
select student_id from Student_Courses;

-- left outer join
select Student.student_id, Student.student_name, Student_Courses.Course_ID
from student
left outer join student_courses on Student.Student_ID = Student_Courses.Student_ID;

-- right outer join
select Student.student_id, Student.student_name, Student_Courses.Course_ID
from student
right join student_courses on Student.Student_ID = Student_Courses.Student_ID;

-- full join
select Student.student_id, Student.student_name, Student_Courses.Course_ID
from student
full join student_courses on Student.Student_ID = Student_Courses.Student_ID;