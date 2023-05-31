CREATE TABLE employee_addresses
(
    id           BIGINT PRIMARY KEY AUTO_INCREMENT,
    address      VARCHAR(255) NOT NULL,
    number       VARCHAR(10)  NOT NULL,
    complement   VARCHAR(255) NOT NULL,
    neighborhood VARCHAR(255) NOT NULL,
    cep          VARCHAR(8)   NOT NULL,
    city         VARCHAR(255) NOT NULL,
    state        VARCHAR(255) NOT NULL,
    employee_id  BIGINT       NOT NULL,
    created_at   TIMESTAMP,
    updated_at   TIMESTAMP,
    FOREIGN KEY (employee_id) REFERENCES employees (id)
);
