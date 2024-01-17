INSERT INTO professor (name, department) 
VALUES ('John Smith', 'Computer Science');
INSERT INTO professor (name, department) 
VALUES ('Mary Johnson', 'Physics');
INSERT INTO professor (name, department) 
VALUES ('David Lee', 'Mathematics');

INSERT INTO course (name, credits, professorId)
VALUES ('Introduction to Programming', 3, 1);
INSERT INTO course (name, credits, professorId)
VALUES ('Quantum Mechanics', 4, 2);
INSERT INTO course (name, credits, professorId)
VALUES ('Calculus', 4, 3);

INSERT INTO student (name, email)
VALUES ('Alice Johnson', 'alice@example.com');
INSERT INTO student (name, email)
VALUES ('Bob Davis', 'bob@example.com');
INSERT INTO student (name, email)
VALUES ('Eva Wilson', 'eva@example.com');

INSERT INTO course_student (courseId, studentId)
VALUES (1, 1);
INSERT INTO course_student (courseId, studentId)
VALUES (1, 2);
INSERT INTO course_student (courseId, studentId)
VALUES (2, 2);
INSERT INTO course_student (courseId, studentId)
VALUES (2, 3);
INSERT INTO course_student (courseId, studentId)
VALUES (3, 1);
INSERT INTO course_student (courseId, studentId)
VALUES (3, 3);
