CREATE TABLE user(
user_id bigint(20) NOT NULL AUTO_INCREMENT,
firstname varchar(50) NOT NULL,
lastname varchar(50) NOT NULL,
email varchar (50) NOT NULL,
username varchar(100) NOT NULL,
password varchar(100) NOT NULL,
is_done bit ,
PRIMARY KEY(user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE  role (
  role_id bigint(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

CREATE TABLE user_role (
  user_id bigint(11) NOT NULL,
  role_id bigint(11) NOT NULL,
  PRIMARY KEY (user_id,role_id),
  KEY role_id (role_id),
  CONSTRAINT user_role_1
   FOREIGN KEY (user_id) REFERENCES user (user_id),
  CONSTRAINT role_role_2
   FOREIGN KEY (role_id) REFERENCES role (role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table priority (
    id int not null AUTO_INCREMENT,
    name varchar(100) not null,
    PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

create table label (
    id int not null AUTO_INCREMENT,
    name varchar(100) not null,
    slag varchar (255) not null,
    PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

create table todo (
    todo_id int not null AUTO_INCREMENT,
    title varchar(100) not null,
    note varchar (255) not null,
    priority_id int(11) DEFAULT NULL,
    label_id int(11) DEFAULT NULL ,
    due_date date,
    PRIMARY KEY(todo_id),
    UNIQUE  KEY UK_title (title),
    KEY FK_Todo_ID (priority_id),
    CONSTRAINT FK_TODO
    FOREIGN KEY (id)
    REFERENCES priority (id),
    KEY FK_Todoo_ID (label_id),
    CONSTRAINT FK_TODOO
    FOREIGN KEY (id)
    REFERENCES label (id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

