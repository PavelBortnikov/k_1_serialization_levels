
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS TX_TEST;


CREATE TABLE USERS(
  ID INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  LOGIN VARCHAR(255) NOT NULL ,
  PASSWORD VARCHAR(255) NOT NULL ,
  EMAIL VARCHAR(255) NOT NULL
);

CREATE TABLE TX_TEST(
  ID INTEGER
);


SET DATABASE TRANSACTION CONTROl MVCC;
--SET DATABASE TRANSACTION CONTROl LOCKS;
--SET DATABASE TRANSACTION CONTROl MVLOCKS;