CREATE TABLE course (
	id serial NOT NULL PRIMARY KEY,
	code VARCHAR(10) NOT NULL,
	name VARCHAR(100) NOT NULL,
	enrolledStudents INTEGER NOT NULL
);

CREATE TABLE systemuser (
	id serial NOT NULL PRIMARY KEY,
	email VARCHAR(100) NOT NULL,
	password VARCHAR(50) NOT NULL,
	student_id INTEGER NULL,
	UNIQUE (email)
);

CREATE TABLE student (
	id serial NOT NULL PRIMARY KEY,
	studentNumber INTEGER NOT NULL,
	firstName VARCHAR(50) NOT NULL,
	lastName VARCHAR(50) NOT NULL,
	UNIQUE (studentNumber)
);

CREATE TABLE courseEntry (
	id serial NOT NULL PRIMARY KEY,
	course_id INTEGER NOT NULL,
	student_id INTEGER NOT NULL,
	UNIQUE (course_id, student_id),
	FOREIGN KEY (course_id) REFERENCES course (id),
	FOREIGN KEY (student_id) REFERENCES student (id)
);