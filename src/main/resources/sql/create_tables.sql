CREATE TABLE table_user
(
  id   INT AUTO_INCREMENT
    PRIMARY KEY,
  name VARCHAR(10) NULL,
  age  INT         NULL
);
---mysql version must be above THEN 5.5
CREATE TABLE message
(
  id          INT       AUTO_INCREMENT
    PRIMARY KEY,
  name        VARCHAR(50)                                                     NOT NULL,
  description VARCHAR(500)                                                    NULL,
  createdAt   TIMESTAMP DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  updatedAt   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  endAt       TIMESTAMP DEFAULT '0000-00-00 00:00:00'                         NOT NULL,
  source      VARCHAR(100)                                                    NULL
);

CREATE TABLE user_token (
  id        BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  user_id   BIGINT                              NOT NULL,
  token     VARCHAR(64)                         NOT NULL,
  createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);
CREATE UNIQUE INDEX UNQ_TOKEN_TOKEN
  ON user_token (token);
CREATE UNIQUE INDEX UNQ_TOKEN_USER
  ON user_token (user_id);

CREATE TABLE classmates (
  id               BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  name             VARCHAR(32)  NOT NULL,
  mobile           VARCHAR(128) NULL,
  email            VARCHAR(128) NULL,
  birthday         DATETIME     NULL,
  guaduated_school VARCHAR(128) NULL,
  major            VARCHAR(128) NULL,
  double_major     VARCHAR(128) NULL,
  upgraded_school  VARCHAR(128) NULL,
  city             VARCHAR(128) NULL,
  company          VARCHAR(128) NULL
)


