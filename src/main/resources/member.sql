CREATE TABLE member
(

    id BIGINT(20) NOT NULL AUTO_INCREMENT -- pk

    , userId VARCHAR(50) NOT NULL -- 아이디

    , password VARCHAR(50) DEFAULT NULL -- 비밀번호

    , nickname VARCHAR(50) DEFAULT NULL -- 닉네임

    , name VARCHAR(50) DEFAULT NULL -- 이름

    , email VARCHAR(50) DEFAULT NULL -- 이메일

    , phone VARCHAR(50) DEFAULT NULL -- 전화번호

    , indate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP() -- 회원 생성일시

    , isMember VARCHAR(25) DEFAULT 'Y' -- 회원 여부

    , role VARCHAR(20) DEFAULT 'ROLE_USER' -- 권한 (일반유저 or Admin)

    , PRIMARY KEY (id)

);