CREATE TABLE IF NOT EXISTS work_role (
    role_id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    title VARCHAR(50) NOT NULL,
    description VARCHAR(255),
    salary DOUBLE NOT NULL,
    creation_date DATE NOT NULL,
    PRIMARY KEY (role_id)
);
