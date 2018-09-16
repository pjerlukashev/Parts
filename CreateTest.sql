DROP DATABASE IF EXISTS test;

CREATE DATABASE test DEFAULT CHARACTER SET 'utf8';

USE test;

create table parts
(
	id int(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	partName varchar(100),
  quantity int,
	isRequired tinyint(4)
);

set names 'utf8';
DELIMITER $$
CREATE PROCEDURE insert_test_data()
BEGIN
  DECLARE i INT DEFAULT 1;
DECLARE j INT DEFAULT 16;
  WHILE i < 16 DO
    INSERT INTO parts (id, partName, quantity, isRequired)
    values(i, 'Motherboard', i*5,  1);
    set i = i + 1;
  END WHILE;
  WHILE j < 31 DO
    INSERT INTO parts (id, partName, quantity, isRequired)
    values(j, 'Joystick', j,  0);
    set j = j + 1;
  END WHILE;
END$$
DELIMITER ;
CALL insert_test_data();
DROP PROCEDURE insert_test_data;