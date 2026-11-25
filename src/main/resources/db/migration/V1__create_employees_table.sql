CREATE TABLE employees (
                                  id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                  employee_number TEXT UNIQUE,
                                  first_name      TEXT NOT NULL,
                                  last_name       TEXT NOT NULL,
                                  abbreviation    TEXT NOT NULL,
                                  color           TEXT NOT NULL DEFAULT '#6366f1',
                                  position        TEXT,
                                  department      TEXT,
                                  employment_type TEXT NOT NULL DEFAULT 'full_time'
                                      CHECK (employment_type IN ('full_time','part_time','mini_job','trainee')),
                                  weekly_hours    NUMERIC(4,2),
                                  phone           TEXT,
                                  status          TEXT NOT NULL DEFAULT 'active'
                                      CHECK (status IN ('active','inactive','archived')),
                                  notes           TEXT,
                                  hired_at        DATE,
                                  created_at      TIMESTAMPTZ NOT NULL DEFAULT now(),
                                  updated_at      TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE INDEX idx_employees_status       ON employees(status);
CREATE INDEX idx_employees_abbreviation ON employees(abbreviation);