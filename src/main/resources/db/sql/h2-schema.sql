-- TODO schema
-- example
create table members
(
    id                 bigint primary key      not null auto_increment,
    name               varchar(50)             not null,
    created_date       timestamp default now() not null,
    last_modified_date timestamp
);

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
