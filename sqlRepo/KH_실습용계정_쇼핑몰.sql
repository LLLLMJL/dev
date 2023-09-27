-- 쇼핑몰
DROP TABLE MEMBER;
CREATE TABLE MEMBER (
    ID VARCHAR2(100)
    , PWD VARCHAR2 (100)
    , NICK VARCHAR2(100)
    , ENROLL_DATE TIMESTAMP);
    
DROP TABLE ITEM;    
CREATE TABLE ITEM (
    NAME VARCHAR2(100)
    , PRICE NUMBER
    , CNT NUMBER
    , ENROLL_DATE TIMESTAMP);
    
-- 회원가입
INSERT INTO MEMBER (ID, PWD, NICK, ENROLL_DATE) VALUES ('아이디', '비번', '닉네임', SYSDATE);

-- 로그인
SELECT * FROM MEMBER WHERE ID = '아이디' AND PWD = '비번';
-- 비밀번호 변경
UPDATE MEMBER SET PWD = '신규비번'
WHERE ID = '아이디' AND PWD = '비번' ;
-- 탈퇴
DELETE MEMBER
WHERE ID = '아이디' AND PWD = '비번';


-- 상품 등록
INSERT INTO ITEM (NAME, PRICE, CNT, ENROLL_DATE) VALUES ('상품명', 1000000, 999, SYSDATE);
-- 상품 가격 변경
UPDATE ITEM SET PRICE = 777
WHERE NAME = '상품명';
-- 상품 삭제
DELETE ITEM
WHERE NAME = '상품명';
-- 모든 상품 조회 (최신 등록순)
SELECT *
FROM ITEM
ORDER BY ENROLL_DATE DESC;


