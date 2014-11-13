INSERT INTO course (code, name, enrolledStudents) VALUES ('72.38', 'Proyecto de Aplicaciones Web', 3);
INSERT INTO course (code, name, enrolledStudents) VALUES ('93.58', 'Algebra', 5);
INSERT INTO course (code, name, enrolledStudents) VALUES ('93.26', 'Analisis Matematico I', 3);
INSERT INTO course (code, name, enrolledStudents) VALUES ('94.24', 'Metodologia del Aprendizaje', 6);

INSERT INTO student (studentNumber, firstName, lastName) VALUES ('1000', 'Jorge Humberto', 'Perez');
INSERT INTO student (studentNumber, firstName, lastName) VALUES ('1001', 'Jose Rigoberto', 'Gomez');
INSERT INTO student (studentNumber, firstName, lastName) VALUES ('1002', 'Maria Laura', 'Salerno');
INSERT INTO student (studentNumber, firstName, lastName) VALUES ('1003', 'Esteban', 'del Molino');
INSERT INTO student (studentNumber, firstName, lastName) VALUES ('1004', 'Esmeralda', 'Angeles');
INSERT INTO student (studentNumber, firstName, lastName) VALUES ('1005', 'Pedro', 'Picapiedra');
INSERT INTO student (studentNumber, firstName, lastName) VALUES ('1006', 'Juliana Ines', 'Marmol');

INSERT INTO courseEntry (course_id, student_id) VALUES (1, 1);
INSERT INTO courseEntry (course_id, student_id) VALUES (1, 3);
INSERT INTO courseEntry (course_id, student_id) VALUES (1, 4);
INSERT INTO courseEntry (course_id, student_id) VALUES (2, 1);
INSERT INTO courseEntry (course_id, student_id) VALUES (2, 2);
INSERT INTO courseEntry (course_id, student_id) VALUES (2, 4);
INSERT INTO courseEntry (course_id, student_id) VALUES (2, 6);
INSERT INTO courseEntry (course_id, student_id) VALUES (2, 7);
INSERT INTO courseEntry (course_id, student_id) VALUES (3, 1);
INSERT INTO courseEntry (course_id, student_id) VALUES (3, 6);
INSERT INTO courseEntry (course_id, student_id) VALUES (3, 7);
INSERT INTO courseEntry (course_id, student_id) VALUES (4, 1);
INSERT INTO courseEntry (course_id, student_id) VALUES (4, 2);
INSERT INTO courseEntry (course_id, student_id) VALUES (4, 3);
INSERT INTO courseEntry (course_id, student_id) VALUES (4, 4);
INSERT INTO courseEntry (course_id, student_id) VALUES (4, 6);
INSERT INTO courseEntry (course_id, student_id) VALUES (4, 7);

INSERT INTO systemuser (email, password, student_id) VALUES ('admin@paw.com', '123', NULL);
INSERT INTO systemuser (email, password, student_id) VALUES ('jperez@paw.com', 'jperez', 1);
INSERT INTO systemuser (email, password, student_id) VALUES ('msalerno@paw.com', 'msalerno', 3);
INSERT INTO systemuser (email, password, student_id) VALUES ('emolino@paw.com', 'emolino', 4);
INSERT INTO systemuser (email, password, student_id) VALUES ('eangeles@paw.com', 'eangeles', 5);