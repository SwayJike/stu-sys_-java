

create table if not exists grade
(
	GradeId int(10) auto_increment
		primary key,
	GradeName varchar(50) not null
);

create table if not exists menu
(
	id int auto_increment
		primary key,
	url varchar(255) null comment '项目位置',
	path varchar(255) null comment '菜单URL',
	component varchar(255) null,
	name varchar(64) not null,
	icon varchar(32) null comment '菜单图标',
	parentId int null comment '父菜单ID，一级菜单为0',
	constraint name
		unique (name)
)
charset=utf8;

create table if not exists role
(
	id int auto_increment
		primary key,
	code varchar(255) not null,
	name varchar(255) not null
);

create table if not exists role_menu
(
	roleid int not null,
	menuid int not null
);

create table if not exists student
(
	StudentNo varchar(50) not null
		primary key,
	LoginPwd varchar(20) default '123' not null,
	StudentName varchar(50) not null,
	Sex char(2) not null,
	GradeId int(10) not null,
	Phone varchar(255) not null,
	Address varchar(255) default '学生宿舍' null,
	BornDate datetime null,
	Email varchar(50) null,
	constraint student_ibfk_1
		foreign key (GradeId) references grade (GradeId)
);

create index GradeId
	on student (GradeId);

create table if not exists student_role
(
	sno varchar(20) not null,
	roleid int not null
);

create table if not exists subject
(
	SubjectId int(10) auto_increment
		primary key,
	SubjectName varchar(20) not null,
	ClassHour int(10) not null,
	GradeId int(10) not null
);

create table if not exists result
(
	Id int(10) auto_increment
		primary key,
	StudentNo varchar(50) not null,
	SubjectId int(10) not null,
	StudentResult int(10) not null,
	ExamDate datetime not null,
	constraint result_ibfk_1
		foreign key (StudentNo) references student (StudentNo),
	constraint result_ibfk_2
		foreign key (SubjectId) references subject (SubjectId)
);

create index StudentNo
	on result (StudentNo);

create index SubjectId
	on result (SubjectId);

