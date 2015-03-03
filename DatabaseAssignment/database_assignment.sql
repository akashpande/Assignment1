
create database assessment;

use assessment;



create table roles
(
id INT(10) PRIMARY KEY,
role VARCHAR(20)
);



insert into roles values(1,'admin');
insert into roles values(2,'candidate');



create table users
(
id INT(10) PRIMARY KEY,
name VARCHAR(20),
password VARCHAR(20)
);


insert into users values(1,'akash','akash123');
insert into users values(2,'sudeep','sudeep123');
insert into users values(3,'rakesh','rakesh123');
insert into users values(4,'dhiraj','dhiraj123');
insert into users values(5,'vaibhav','vaibhav123');


create table user_roles
(
id INT(10) PRIMARY KEY,
users_id INT(10) REFERENCES users(id),
roles_id INT(10) REFERENCES roles(id)
);


insert into user_roles values(1,1,1);
insert into user_roles values(2,2,1);
insert into user_roles values(3,3,2);
insert into user_roles values(4,4,2);
insert into user_roles values(5,5,2);






create table questions
(
id INT(10) PRIMARY KEY,
question varchar(100)
);




insert into questions values(1,'What is the full form of IP');
insert into questions values(2,'Which of these are output devices');
insert into questions values(3,'Where is Pune located');
insert into questions values(4,'Which of these is an Operating System');
insert into questions values(5,'Who is current President of India');
insert into questions values(6,'Which of these are vowels');
insert into questions values(7,'What is the name of Joker in Batman');
insert into questions values(8,'Which of these are platform independent language');




create table options
(
id INT(10) PRIMARY KEY,
questions_id INT(10) REFERENCES questions(id),
option_text VARCHAR(100)
);


insert into options values(1,1,'Internet Protocol');
insert into options values(2,1,'Information Protocol');
insert into options values(3,1,'Inter Protocol');
insert into options values(4,1,'International Protocol');
insert into options values(5,2,'Keyboard');
insert into options values(6,2,'Mouse');
insert into options values(7,2,'Monitor');
insert into options values(8,2,'Printer');
insert into options values(9,2,'Plotter');
insert into options values(10,3,'Goa');
insert into options values(11,3,'Uttar Pradesh');
insert into options values(12,3,'Andhra Pradesh');
insert into options values(13,3,'Maharashtra');
insert into options values(14,4,'HTML');
insert into options values(15,4,'Android');
insert into options values(16,4,'ISDN');
insert into options values(17,4,'Macintosh');
insert into options values(18,5,'Narayan Murthi');
insert into options values(19,5,'Pratibha Patil');
insert into options values(20,5,'Pranab Mukherjee');
insert into options values(21,6,'P');
insert into options values(22,6,'A');
insert into options values(23,6,'R');
insert into options values(24,6,'E');
insert into options values(25,7,'Salman Khan');
insert into options values(26,7,'Heath Ledger');
insert into options values(27,7,'Tom Cruise');
insert into options values(28,7,'Jim Carrey');
insert into options values(29,8,'Microsoft .NET');
insert into options values(30,8,'Visual Basic');
insert into options values(31,8,'Java');
insert into options values(32,8,'C');
insert into options values(33,8,'PHP');
insert into options values(34,8,'Karaoke');





create table answers
(
id INT(10) PRIMARY KEY,
questions_id INT(10) REFERENCES questions(id),
options_correct INT(10) REFERENCES options(id)
);



insert into answers values(1,1,1);
insert into answers values(2,2,6);
insert into answers values(3,2,7);
insert into answers values(4,3,13);
insert into answers values(5,4,15);
insert into answers values(6,4,17);
insert into answers values(7,5,20);
insert into answers values(8,6,22);
insert into answers values(9,6,24);
insert into answers values(10,7,26);
insert into answers values(11,8,31);
insert into answers values(12,8,33);





create table assignments
(
id INT(10) PRIMARY KEY,
assignment VARCHAR(100),
users_admin_id INT(10) REFERENCES users(id)
);





insert into assignments values(1,'Technical_Assignment',1);
insert into assignments values(2,'General_Assignment',2);






create table assignment_allocations
(
id INT(10) PRIMARY KEY,
assignments_id INT(10) REFERENCES assignments(id),
users_candidate_id INT(10) REFERENCES users(id)
);





insert into assignment_allocations values(1,1,3);
insert into assignment_allocations values(2,1,4);
insert into assignment_allocations values(3,1,5);
insert into assignment_allocations values(4,2,3);
insert into assignment_allocations values(5,2,5);




create table assignment_questions
(
id INT(10) PRIMARY KEY,
assignments_id INT(10) REFERENCES assignments(id),
questions_id INT(10) REFERENCES questions(id)
);





insert into assignment_questions values(1,1,1);
insert into assignment_questions values(2,1,2);
insert into assignment_questions values(3,1,3);
insert into assignment_questions values(4,1,8);
insert into assignment_questions values(5,1,4);
insert into assignment_questions values(6,2,5);
insert into assignment_questions values(7,2,6);
insert into assignment_questions values(8,2,7);
insert into assignment_questions values(9,2,2);






create table candidate_submissions
(
id INT(10) PRIMARY KEY,
assignments_id INT(10) REFERENCES assignments(id),
users_candidate_id INT(10) REFERENCES users(id),
questions_id INT(10) REFERENCES questions(id),
options_submitted_id INT(10) REFERENCES options(id)
);

insert into candidate_submissions values(1,1,3,1,1);
insert into candidate_submissions values(2,1,3,2,6);
insert into candidate_submissions values(3,1,3,3,13);
insert into candidate_submissions values(4,1,3,4,14);

insert into candidate_submissions values(5,1,4,1,1);
insert into candidate_submissions values(6,1,4,2,5);
insert into candidate_submissions values(7,1,4,8,31);
insert into candidate_submissions values(8,1,4,4,13);

insert into candidate_submissions values(9,1,5,8,33);
insert into candidate_submissions values(10,1,5,2,6);
insert into candidate_submissions values(11,1,5,3,12);
insert into candidate_submissions values(12,1,5,4,13);


insert into candidate_submissions values(13,2,3,5,13);
insert into candidate_submissions values(14,2,3,6,17);
insert into candidate_submissions values(15,2,3,7,20);
insert into candidate_submissions values(16,2,3,2,5);

insert into candidate_submissions values(17,2,5,5,13);
insert into candidate_submissions values(18,2,5,6,16);
insert into candidate_submissions values(19,2,5,7,20);
insert into candidate_submissions values(20,2,5,2,6);





create table assignment_scores
(
id INT(10) PRIMARY KEY,
assignments_id INT(10) REFERENCES assignments(id),
users_candidate_id INT(10) REFERENCES users(id),
score INT(100)
);



insert into assignment_scores values(1,1,3,2);
insert into assignment_scores values(2,1,4,2);
insert into assignment_scores values(3,1,5,1);
insert into assignment_scores values(4,2,3,2);
insert into assignment_scores values(5,2,5,2);


/********************************************************************/


create view candidate_view 
AS SELECT
u.id,u.name,assignments_id,score 
FROM users u 
JOIN
assignment_scores assn
ON
u.id=assn.users_candidate_id;

SELECT * FROM candidate_view;
/**********************************************************************/


create or replace view assessment_view
AS SELECT
u.id,u.name,question,opt.option_text
FROM users u
JOIN candidate_submissions cs
ON
u.id=cs.users_candidate_id


JOIN questions que
ON
que.id=cs.questions_id


JOIN options opt
ON
opt.id=cs.options_submitted_id;


SELECT * FROM assessment_view;
/*---------------------------------------------------------------------*/

SET @sql = NULL;
select group_concat(distinct concat('if(av.question = ''',question,''',option_text,NULL) as ',quote(question))) into @sql from assessment_view av;
set @sql = concat('select av.id,av.name,',@sql,' from assessment_view av');
prepare st from @sql;
execute st;














