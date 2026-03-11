-- TODO schema
-- example
CREATE TABLE users
(
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY,
    username           VARCHAR(50) UNIQUE NOT NULL,
    password           VARCHAR(100)       NOT NULL,
    role               VARCHAR(20)        NOT NULL,
    created_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    last_modified_date TIMESTAMP
);

CREATE TABLE contents
(
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY,
    title              VARCHAR(100) NOT NULL,
    description        TEXT,
    view_count         BIGINT DEFAULT 0 NOT NULL,
    created_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    created_by         VARCHAR(50)  NOT NULL,
    last_modified_date TIMESTAMP,
    last_modified_by   VARCHAR(50)
);
