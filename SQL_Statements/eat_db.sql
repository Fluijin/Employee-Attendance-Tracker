-- Author: Mondia, Robbie A.
-- BSCS 3-1N
-- Database Administration: Prof. Monina Barretto

-- ---------------------- OFFICIAL SYNTAX --------------------------

CREATE SCHEMA eat_db;
CREATE TABLE employee_tbl
(
EmpID VARCHAR (10) NOT NULL,
Lname VARCHAR (30) NOT NULL, 
Fname VARCHAR (30) NOT NULL,
MI VARCHAR (5),
Nickname VARCHAR (15) NOT NULL,
Sex CHAR (1) NOT NULL,
Birthdate DATE NOT NULL, 
Age INT (2), 
Address VARCHAR (50) NOT NULL,
Email VARCHAR (60) NOT NULL,
ContactNo VARCHAR (11) NOT NULL DEFAULT "N/A", 
EmpType VARCHAR (15) NOT NULL,
TeamName VARCHAR (10) NOT NULL,
TeacherClass VARCHAR (30) NOT NULL,
Password VARCHAR (30) DEFAULT "pass",
PRIMARY KEY (EmpID)
);

-- ---------------------- TEST DATA --------------------------

INSERT INTO employee_tbl (EmpID, Lname, Fname, MI, Nickname, Sex, Birthdate, Age, Address, Email, ContactNo, EmpType, TeamName, TeacherClass, Password)
VALUES
("JA-150", "Mondia", "Robbie", "A.", "Rob", "M", "2000-03-10", "20", "Caloocan City", "", "09996876151", "Part-timer", "Nico Robin", "Class B - 140/hr", "ja150"),
("JA-151", "Queen", "Oliver", "B.", "Ollie", "M", "1990-01-22", "31", "Star City", "", "09911185542", "Part-timer", "Nico Robin", "Class A - 160/hr", "ja151"),
("JA-152", "Allen", "Barry", "C.", "Bar", "M", "1995-01-22", "26", "Star City", "", "09408659816", "Regular", "Luffy", "Class A - 160/hr", "ja152"),

("JA-153", "Swan", "Samirah ", "J.", "Swan", "F", "1997-12-23", "24", "Pasay City", "", DEFAULT, "Regular", "Nico Robin", "Class B - 140/hr", "ja153"),
("JA-154", "Adam", "Tamera ", "D.", "Adam", "M", "1996-11-14", "25", "Cobert City", "", DEFAULT, "Provisional", "Nami", "Class C - 120/hr", "ja154"),
("JA-155", "Hicks", "Jez", "G.", "Jez", "M", "1984-12-07", "37", "Klark City", "", "09976431477", "Regular", "Zoro", "Class A - 160/hr", "ja155"),
("JA-156", "Yu", "Orion", "S.", "Ori", "F", "1996-08-24", "25", "Quezon City", "", "09432552592", "Provisional", "Sanji", "Class C - 120/hr", "ja156"),

("JA-157", "Mendez", "Shawn", "R.", "Shawn", "M", "1988-09-08", "33", "Vineware City", "", "09229359233", "Provisional", "Nami", "Class C - 120/hr", "ja157"),
("JA-158", "Regan", "Tom ", "M.", "Tom", "M", "1989-06-07", "32", "Sawwares City", "", "09161365797", "Part-timer", "Zoro", "Class B - 140/hr", "ja158"),
("JA-159", "Rajan", "Coulson", "F.", "Son", "M", "1998-09-13", "23", "Trek City", "", "09719607491", "Part-timer", "Luffy", "Class A - 160/hr", "ja159"),

-- Admin/Staff
("AD-100", "Cabrera", "Kellie", "C.", "Kel", "F", "1993-05-14", "28", "Sleles City", "", "09882499543", "Staff", "Sanji", "Class A - 160/hr", "ad100"),
("AD-101", "Duffy", "Rocky", "Z.", "Rock", "M", "1982-10-26", "39", "Baguio City", "", "09292883406", "Staff", "Nami", "Class A - 160/hr", "ad101"),
("AD-102", "Reeves", "Ryan", "K.", "Ry", "M", "1997-12-12", "24", "Caloocan City", "", "09617277527", "Staff", "Nico Robin", "Class A - 160/hr", "ad102");

UPDATE employee_tbl
SET Email = CONCAT(LEFT(Fname, 1), TRIM(Lname), "@gmail.com");

-- Output
SELECT * FROM employee_tbl;

-- ---------------------- ATTENDANCE LOG TABLE --------------------------
-- DML/Integrity Constraints

CREATE TABLE attendanceLog_tbl
(
EmpID VARCHAR (10) NOT NULL,
Date DATE,
TimeIn TIME NOT NULL,
TimeOut TIME NOT NULL DEFAULT "4:00",
FOREIGN KEY (EmpID) REFERENCES employee_tbl (EmpID),
PRIMARY KEY (EmpID, Date) -- composite key so that I can still log by the use of DATE
);

-- Output
SELECT * FROM attendanceLog_tbl;

-- -------------------- JOIN STAMTENTS + Subquery ------------------------

-- Monthly Highest Early "IN"
SELECT EmpId, Month, MAX(MaxIn) AS "Early Ins Count"
FROM (	SELECT et.EmpID, MONTHNAME(Date) AS Month, COUNT(at.TimeIn) AS MaxIn
		FROM employee_tbl et JOIN attendancelog_tbl at 
        ON et.EmpID = at.EmpID
		WHERE at.TimeIn < "8:00"
		GROUP BY et.EmpID, MONTH(Date)
		ORDER BY COUNT(at.TimeIn) DESC) AS sub
GROUP BY Month;

-- "sub" is an alias for the subquery or derived table

-- Monthly Highest Late "IN"
SELECT EmpId, Month, MAX(MaxIn) AS "Late Ins Count"
FROM (	SELECT et.EmpID, MONTHNAME(Date) AS Month, COUNT(at.TimeIn) AS MaxIn
		FROM employee_tbl et JOIN attendancelog_tbl at 
        ON et.EmpID = at.EmpID
		WHERE at.TimeIn > "8:30"
		GROUP BY et.EmpID, MONTH(Date)
		ORDER BY COUNT(at.TimeIn) DESC) AS sub
GROUP BY Month;
        
-- ---------------------- STORED PROCEDURES --------------------------

CALL add_employee ("JA-161", "Rajan", "Coulson", "F.", "Son", "M", "1998-09-13", "23", "Trek City", "", "09719607491", "Part-timer", "Luffy", "Class A - 160/hr", "ja161");

-- --------------------------- VIEWS --------------------------------
SELECT * FROM attendance_log_view;

-- -------------------------- TRIGGERS ------------------------------

CREATE TABLE management_history
(
RecordCount INT AUTO_INCREMENT PRIMARY KEY,
EmpID VARCHAR (10) NOT NULL,
Lname VARCHAR (30) NOT NULL, 
Fname VARCHAR (30) NOT NULL,
MI VARCHAR (5),
Sex CHAR (1) NOT NULL,
EmpType VARCHAR (15) NOT NULL,
TeamName VARCHAR (10) NOT NULL,
TeacherClass VARCHAR (30) NOT NULL,
Password VARCHAR (30) DEFAULT "pass",
Action VARCHAR (15) NOT NULL
);

ALTER TABLE management_history
ADD CONSTRAINT action_chk
CHECK (Action IN ('Added', 'Updated Record', 'Deleted', 'Old Record'));

-- Adds new entry to the management_history AFTER ADDITION of new record

DELIMITER |
CREATE TRIGGER added_record
AFTER INSERT 
ON employee_tbl FOR EACH ROW

BEGIN
INSERT INTO management_history
VALUES (RecordCount, new.EmpID, new.Lname, new.Fname, new.MI, new.Sex, 
new.EmpType, new.TeamName, new.TeacherClass, new.Password, "Added");
END |

-- Adds new entry to the management_history AFTER DELETION of new record

DELIMITER |
CREATE TRIGGER deleted_record
AFTER DELETE 
ON employee_tbl FOR EACH ROW

BEGIN
INSERT INTO management_history
VALUES (RecordCount, old.EmpID, old.Lname, old.Fname, old.MI, old.Sex, 
old.EmpType, old.TeamName, old.TeacherClass, old.Password, "Deleted");
END |

-- Adds new entry to the management_history AFTER UPDATE of new record

DELIMITER |
CREATE TRIGGER updated_record
AFTER UPDATE
ON employee_tbl FOR EACH ROW

BEGIN
INSERT INTO management_history
VALUES (RecordCount, old.EmpID, old.Lname, old.Fname, old.MI, old.Sex, 
old.EmpType, old.TeamName, old.TeacherClass, old.Password, "Old Record");

INSERT INTO management_history
VALUES (RecordCount, new.EmpID, new.Lname, new.Fname, new.MI, new.Sex, 
new.EmpType, new.TeamName, new.TeacherClass, new.Password, "Updated Record");
END |
