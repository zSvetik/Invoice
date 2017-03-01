CREATE TABLE bank (
	mfo int NOT NULL,
	edrpou int NOT NULL,
	description varchar(200) NOT NULL,
	PRIMARY KEY (mfo)
);

CREATE TABLE organization (
	edrpou int NOT NULL,
	description varchar(200) NOT NULL,
	PRIMARY KEY (edrpou)
);

CREATE TABLE room (
	id bigint NOT NULL,
	owner varchar(200) NOT NULL,
	guests int NOT NULL,
	area FLOAT NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE payment_account (
	id bigint NOT NULL,
	mfo_bank int NOT NULL,
	edrpou_organization int NOT NULL,
	payment_account bigint NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY payment_account_fk0 (mfo_bank) REFERENCES bank(mfo),
	FOREIGN KEY payment_account_fk1 (edrpou_organization) REFERENCES organization(edrpou)
);

CREATE TABLE invoice (
	id bigint NOT NULL,
	id_payment_account bigint NOT NULL,
	id_room bigint NOT NULL,
	personal_account bigint NOT NULL,
	credited_with bigint NOT NULL,
	rate bigint NOT NULL,
	discount bigint NOT NULL DEFAULT '0',
	subvention bigint NOT NULL DEFAULT '0',
	total bigint NOT NULL,
	paid bigint NOT NULL DEFAULT '0',
	d_open DATE,
	d_close DATE,
	PRIMARY KEY (id),
	FOREIGN KEY invoice_fk0 (id_payment_account) REFERENCES payment_account(id),
	FOREIGN KEY invoice_fk1 (id_room) REFERENCES room(id)
);

CREATE TABLE users (
	id_room bigint NOT NULL,
	id bigint NOT NULL,
	login varchar(50) NOT NULL UNIQUE,
	password varchar(50) NOT NULL,
	balance bigint NOT NULL DEFAULT '0',
	PRIMARY KEY (id),
	FOREIGN KEY users_fk0 (id_room) REFERENCES room(id)
);

CREATE TABLE role (
	id bigint NOT NULL,
	role varchar(20) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE user_role (
	id_user bigint NOT NULL,
	id_role bigint NOT NULL,
	PRIMARY KEY (id_user,id_role),
	FOREIGN KEY users_role_fk0 (id_user) REFERENCES users(id),
	FOREIGN KEY users_role_fk1 (id_role) REFERENCES role(id)
);