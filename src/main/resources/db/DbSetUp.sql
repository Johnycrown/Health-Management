create  database health_management;

create user 'health_user'@'localhost' identified by 'pass_123';
grant all privileges  on health_management.* to 'health_user'@'localhost';
flush privileges;