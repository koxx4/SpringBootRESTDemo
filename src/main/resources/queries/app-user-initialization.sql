DROP TABLE IF EXISTS appUser;
CREATE TABLE appUser(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nickname VARCHAR(60),
    password VARCHAR(300),
    enabled BOOLEAN DEFAULT TRUE
);
DROP TABLE IF EXISTS authorities;
CREATE TABLE authorities(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nickname VARCHAR (60),
    authority VARCHAR(200),
    CONSTRAINT `fk_app_user`
                        FOREIGN KEY (nickname) REFERENCES appUser(nickname)
                        ON UPDATE RESTRICT
);