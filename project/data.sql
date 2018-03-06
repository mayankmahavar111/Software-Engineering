CREATE TABLE if NOT EXISTS address(
  add_id integer not NULL PRIMARY KEY ,
  number text ,
  city text,
  street text
);
 create table IF NOT EXISTS student (
  student_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  name TEXT not NULL ,
  phone integer NOT NULL ,
  dob date NOT NULL ,
   add_id integer NOT NULL ,
   FOREIGN KEY (add_id) REFERENCES address(add_id)
 );
CREATE TABLE if NOT EXISTS exam(
  exam_no integer NOT NULL PRIMARY KEY ,
  subject text NOT NULL ,
  student_id integer not NULL ,
  FOREIGN KEY (student_id) REFERENCES student(student_id)
);

CREATE TABLE if NOT EXISTS record_card(
  record_no integer NOT NULL PRIMARY KEY ,
  subject text NOT NULL ,
  name text,
  score integer NOT NULL ,
  FOREIGN KEY (subject) REFERENCES exam(subject)

);