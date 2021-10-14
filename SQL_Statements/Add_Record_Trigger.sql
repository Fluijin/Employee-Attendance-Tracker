-- Adds new entry to the management_history AFTER ADDITION of new record

DELIMITER |
CREATE TRIGGER added_record
AFTER INSERT 
ON employee_tbl FOR EACH ROW

BEGIN
INSERT INTO management_history
VALUES (RecordCount, new.EmpID, new.Lname, new.Fname, new.MI, new.Sex, new.EmpType, new.TeamName, new.TeacherClass, new.Password, "Added");
END |