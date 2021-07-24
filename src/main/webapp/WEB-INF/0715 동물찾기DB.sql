drop table member;
drop sequence member_seq;
CREATE TABLE member(
    membernumber number PRIMARY KEY,
    userid varchar2(20) NOT NULL,
    userpassword varchar2(25) NOT NULL,
    username varchar2(20) NOT NULL,
    phone varchar2(15) NOT NULL
    );
    
CREATE SEQUENCE member_seq
NOCACHE;


select * from member;

INSERT INTO MEMBER
VALUES(member_seq.nextval,'dog123','dog123','강아지','010-1111-1111');
INSERT INTO MEMBER
VALUES(member_seq.nextval,'cat123','cat123','고양이','010-2222-2222');
INSERT INTO MEMBER
VALUES(member_seq.nextval,'tiger123','tiger123','호랑이','010-3333-3333');
INSERT INTO MEMBER
VALUES(member_seq.nextval,'zebra123','zebra123','얼룩말','010-4444-4444');
INSERT INTO MEMBER
VALUES(member_seq.nextval,'monkey123','monkey123','원숭이','010-5555-5555');

commit;

CREATE TABLE ADMIN(
    adminid varchar2(20) primary key,
    adminpassword varchar2(25) not null,
    adminname varchar2(20) not null
    );
    
INSERT INTO ADMIN
VALUES('admin1','1234','김효진');
INSERT INTO ADMIN
VALUES('admin2','1234','최유리');
INSERT INTO ADMIN
VALUES('admin3','1234','김찬우');

    
CREATE TABLE lostBoard(
    boardNum number PRIMARY KEY,
    title varchar2(45) not null,
    writer varchar2(20) not null,
    writeDate date not null,
    kind varchar2(30),
    location varchar2(100) not null,
    character varchar2(50),
    animal varchar2(20),
    gender varchar2(10) not null,
    img varchar2(500),
    email varchar2(30),
    phone varchar2(15),
    lostDate date,
    meet number
    );
    
CREATE SEQUENCE lostBoard_seq
NOCACHE;   
    
CREATE TABLE findBoard(
    boardNum number PRIMARY KEY,
    title varchar2(45) NOT NULL,
    writer varchar2(20) not null,
    writeDate date not null,
    kind varchar2(30),
    gender varchar2(10),
    location varchar2(100) not null,
    character varchar2(50),
    img varchar2(500),
    email varchar2(30) NOT NULL,
    findDate date NOT NULL,
    meet number
    );
    
CREATE SEQUENCE findBoard_seq
NOCACHE;     

CREATE TABLE QNABoard(
    boardNum number primary key,
    title varchar2(45) not null,
    writer varchar2(20) not null,
    writeDate date not null,
    contents
    );
    
CREATE SEQUENCE QNABoard_seq
NOCACHE;




