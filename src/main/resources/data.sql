INSERT INTO users  (username, password, enabled)
	values('user', 'passu', true);

INSERT INTO users  (username, password, enabled)
	values('admin', 'passa', true);

INSERT INTO authorities (username, authority)
	values('user', 'ROLE_USER');

INSERT INTO authorities (username, authority)
	values('admin', 'ROLE_ADMIN');
