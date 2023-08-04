--DROP TABLE IF EXISTS USERS CASCADE;

CREATE TABLE USERS
(
	id int PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(10),
	email VARCHAR(60),
	user_id VARCHAR(20),
	password VARCHAR(20),
	department VARCHAR(20),
	rank_name VARCHAR(10),
	start_date DATE,
	last_change_date DATE,
	use_account boolean
);

