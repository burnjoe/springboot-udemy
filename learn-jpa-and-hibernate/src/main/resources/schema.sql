-- This creates a 'course' table
-- Spring Data JPA starter automatically detects the file /src/main/resources/schema.sql to create the table in h2

create table course
(
    id bigint not null,
    name varchar(255) not null,
    author varchar(255) not null,
    primary key (id)
);