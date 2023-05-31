CREATE TABLE establishment_employees
(
    id               BIGINT PRIMARY KEY AUTO_INCREMENT,
    establishment_id BIGINT NOT NULL,
    employee_id      BIGINT NOT NULL,
    created_at       TIMESTAMP,
    updated_at       TIMESTAMP,
    FOREIGN KEY (establishment_id) references establishments (id),
    FOREIGN KEY (employee_id) references employees (id)
);
