
CREATE USER 'app1'@'localhost' IDENTIFIED BY 'qwerty';
GRANT ALL PRIVILEGES ON *.* TO 'app1'@'localhost' WITH GRANT OPTION;
CREATE USER 'app1'@'%' IDENTIFIED BY 'qwerty';
GRANT ALL PRIVILEGES ON *.* TO 'app1'@'%' WITH GRANT OPTION;
