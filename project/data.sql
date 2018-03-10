create table user (
username text NOT NULL PRIMARY KEY,
password text NOT NULL,
type text NOT NULL 
);


 create table IF NOT EXISTS student (
  student_id INTEGER NOT NULL PRIMARY KEY ,
  name TEXT not NULL ,
  phone integer NOT NULL ,
  dob date NOT NULL ,
   address text NOT NULL
   
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
  score integer NOT NULL 

);
