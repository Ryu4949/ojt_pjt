DROP TABLE IF EXISTS USERS CASCADE;

CREATE TABLE USERS
(
	id int PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(10),
	email VARCHAR(60),
	user_id VARCHAR(20),
	password VARCHAR(255),
	department VARCHAR(20),
	rank_name VARCHAR(10),
	start_date DATE,
	last_change_date DATE,
	use_account boolean,
	authority VARCHAR(12)
);

CREATE TABLE REFRESH_TOKEN
(
    rt_key VARCHAR(20) PRIMARY KEY UNIQUE,
    rt_value VARCHAR(255)
);

CREATE TABLE NOTE
(
    id int PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(64),
    content VARCHAR(255),
    userId int,
    create_date DATE,
    update_date DATE,
    FOREIGN KEY (userId) REFERENCES USERS(id) ON UPDATE CASCADE ON DELETE RESTRICT
);
