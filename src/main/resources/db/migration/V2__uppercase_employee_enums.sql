ALTER TABLE employees DROP CONSTRAINT employees_employment_type_check;

ALTER TABLE employees ADD CONSTRAINT employees_employment_type_check
    CHECK (employment_type IN ('FULL_TIME', 'PART_TIME', 'MINI_JOB', 'TRAINEE'));

ALTER TABLE employees ALTER COLUMN employment_type SET DEFAULT 'FULL_TIME';

ALTER TABLE employees DROP CONSTRAINT employees_status_check;

ALTER TABLE employees ADD CONSTRAINT employees_status_check
    CHECK (status IN ('ACTIVE','INACTIVE','ARCHIVED'));

ALTER TABLE employees ALTER COLUMN status SET DEFAULT 'ACTIVE';