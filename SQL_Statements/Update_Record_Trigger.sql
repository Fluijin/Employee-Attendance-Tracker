-- Adds new entry to the management_history AFTER UPDATE of new record

DELIMITER |
CREATE TRIGGER updated_record
AFTER UPDATE
ON employee_tbl FOR EACH ROW

BEGIN
INSERT INTO management_history
VALUES (RecordCount, old.EmpID, old.Lname, old.Fname, old.MI, old.Sex, old.EmpType, old.TeamName, old.TeacherClass, old.Password, "Old Record");

INSERT INTO management_history
VALUES (RecordCount, new.EmpID, new.Lname, new.Fname, new.MI, new.Sex, new.EmpType, new.TeamName, new.TeacherClass, new.Password, "Updated Record");
END |