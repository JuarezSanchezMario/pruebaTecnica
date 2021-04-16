DROP TABLE IF EXISTS TWITTER_BDD;

CREATE TABLE TWITTER_BDD (
  user_id BIGINT PRIMARY KEY,
  text longtext NOT NULL,
  user_name VARCHAR(100) NOT NULL,
  validated BOOLEAN NOT NULL,
  locale VARCHAR(20) NOT NULL
);