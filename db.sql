create database hms;

use hms;

drop table login ;
drop table customer;
drop table room;
drop table employee;


create table login(
username varchar(40) primary key, 
password varchar(40), 
authorization varchar(40) 
);


insert into login values ('Akash','12345','Admin');
insert into login values('Abhishek','12345','Admin');
insert into login values('Ashirbad','12345','Admin');
insert into login values('Raju','123','Standard');


create table room(
room_number varchar(20) primary key, 
availability varchar(20), 
clean_status varchar(20), 
price varchar(20), 
bed_type varchar(30)
);

 
insert into room values('100','Available','Cleaned', '2999','Single Bed');
insert into room values('101','Occupied','Cleaned', '2399','Single Bed');
insert into room values('102','Occupied','Cleaned', '2599','Single Bed');
insert into room values('103','Available','Dirty', '2700','Single Bed');
insert into room values('104','Available','Cleaned', '2999','Single Bed');
insert into room values('105','Available','Cleaned', '4500','Double Bed');
insert into room values('106','Occupied','Cleaned', '4499','Double Bed');
insert into room values('107','Occupied','Cleaned', '2999','Double Bed');
insert into room values('108','Available','Dirty', '3500','Double Bed');
insert into room values('109','Available','Cleaned', '5999','Double Bed');
 

create table customer(
id_type varchar(30), 
id_number varchar(30), 
name varchar(30), 
gender varchar(30), 
address varchar(50), 
room_number varchar(20), 
no_of_days int,
deposit varchar(30),
check_in_date date,
primary key (id_type, id_number),
foreign key (room_number) references room(room_number)
);


insert into customer values('Passport',		'56547654',		'Abhishek', 'male','Delhi, India', '101', 7, '3000','2021-05-01');
insert into customer values('Aadhar Card',	'120065437654',	'Jitesh', 'male','Osaka, Japan', '102', 10, '10000','2021-04-28');
insert into customer values('Passport',		'56543686',		'Khushi', 'female','Dubai, UAE', '106', 4, '9000','2021-05-05');
insert into customer values('Passport',		'76328638',		'Swapnil', 'male','Mumbai, India', '107', 7, '12000','2021-05-04');


create table employee(
name varchar(30), 
age varchar(10), 
gender varchar(30), 
job varchar(30), 
salary varchar(30), 
phone varchar(30), 
aadhar varchar(30) primary key, 
email varchar(40)
);


insert into employee values('Vinay Kumar',	'28', 'male', 'Manager', '55000','8009995434', '123454326540', 'vk66@hnmail.com');
insert into employee values('Salini Khan',	'21', 'female', 'Manager', '60000','8655467874', '677854326540', 'sk11@hnmail.com');
insert into employee values('Kunal Kapoor',	'45', 'male', 'Chef', '30000','5765342565', '123544326540', 'kk76@hnmail.com');
insert into employee values('Deepak Kumar',	'34', 'male', 'Housekeeping', '45000','6798995434', '457646576540', 'dk20@hnmail.com');
insert into employee values('Mahima Devi',	'21', 'female', 'Room Service', '26000','6998775434', '124354326540', 'md01@hnmail.com');
insert into employee values('Randeep Singh',	'45', 'male', 'Room Service', '25000','7665475434', '453654326540', 'rs23@hnmail.com');

