-- Adds new entry to the management_history AFTER DELETION of new record

DELIMITER |
CREATE TRIGGER deleted_record
AFTER DELETE 
ON employee_tbl FOR EACH ROW

BEGIN
INSERT INTO management_history
VALUES (RecordCount, old.EmpID, old.Lname, old.Fname, old.MI, old.Sex, old.EmpType, old.TeamName, old.TeacherClass, old.Password, "Deleted");
END |