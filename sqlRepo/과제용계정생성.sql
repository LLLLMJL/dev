--과제용 계정 생성
CREATE USER C##KH_WORKBOOK IDENTIFIED BY 1234;

GRANT CONNECT, RESOURCE TO C##KH_WORKBOOK;

alter user C##KH_WORKBOOK quota 100M on users;