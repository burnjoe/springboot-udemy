-- @Entity classes need to be created first but the data.sql is executed first before the entities are processed
-- This will get an error if h2 is not yet configured (see application.properties) since todos is not yet existing in h2 database
insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values (101, 'mojo', 'Learn Spring Boot', CURRENT_DATE(), false);

insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values (102, 'mojo', 'Learn AWS Cloud', CURRENT_DATE(), false);

insert into todo (ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values (103, 'mojo', 'Learn Docker', CURRENT_DATE(), false);