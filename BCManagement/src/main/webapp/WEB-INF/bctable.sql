create table bctable(
   bc_num number primary key,
   company varchar2(30),
   name varchar2(20),
   rank varchar2(20),
   phone varchar2(20),
   email varchar2(30),
   cp_addr varchar2(50) 
);

create sequence bctable_seq;

 insert into bctable values(bctable_seq.nextval,'장미테크','김장미','사장','
010-3839-4222','ryrt12@naver.com','화성시');