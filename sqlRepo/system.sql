SELECT SYSDATE FROM DUAL;
CREATE TABLE MEMBER(

    ID VARCHAR2(100) ,
    PWD VARCHAR2(100)

);

SELECT * FROM MEMBER;

INSERT INTO MEMBER (ID, PWD) VALUES ('USER01', '1234');