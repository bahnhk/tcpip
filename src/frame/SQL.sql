
create table T_IN (
flower_code number(20),
flower_name varchar2(20),
amount number(20),
prime_cost number(20),
grade number(3));

create table T_OUT(
flower_code number(20),
amount number(20),
selling_price number(20),
client_code varchar2(20)
);

create table T_VENDOR(
client_code varchar2(20),
account varchar2(20),
address varchar2(20),
phone_number varchar2(10));


alter table t_in add constraint TIPK primary key(flower_code);

alter table t_out add constraint TIFK foreign key(flower_code)
references t_in(flower_code);

alter table t_out add constraint TOFK foreign key(client_code)
references t_vendor(client_code);

alter table t_vendor add constraint TVPK primary key(client_code)

alter table T_IN modify Register_Date varchar(200)

alter table T_OUT add Sold_Date varchar(200);

alter table T_IN modify Register_Date Date;

alter table T_OUT modify Sold_Date Date;


-- ============================T_IN SQL문=============================
INSERT into T_IN values (?,?,?,?,sysdate);

UPDATE T_IN SET flower_name=?, amount=?,prime_cost=?, grade=?  WHERE flower_code = ?;

delete from T_IN where flower_code = ?

select * from T_IN where flower_code = ?

select * from t_in order by flower_code

select amount from T_IN where flower_code=?

select Register_Date from T_IN

select Sold_Date from 


-- ============================T_OUT SQL문=============================
select * from T_OUT

INSERT into T_OUT to values (?,?,?,?,?) 

UPDATE T_OUT SET flower_name=?, amount=?, client_code=?  WHERE flower_code = ?;

delete from T_OUT where flower_code = ?

select * from T_OUT where flower_code = ?

select * from T_OUT order by flower_code

UPDATE T_OUT SET selling_price = ? where flower_code = ?

select prime_cost from T_IN a join T_OUT b on a.flower_code = b.flower_code
where flower_code = ?

select distinct flower_name from T_OUT a join T_IN b on a.flower_code = b.flower_code where a.flower_code = '3';


INSERT into T_VENDOR values ('cl001','110-234-53566','경기도 과천시','0011');
INSERT into T_VENDOR values ('cl002','110-234-53444','서울시 강남구','0234');
INSERT into T_VENDOR values ('cl003','110-234-53666','경기도 수원시','0034');
INSERT into T_VENDOR values ('cl004','136-267-45744','서울시 성동구','0123');
INSERT into T_VENDOR values ('cl005','200-142-911209','서울시 광진구','0556');
INSERT into T_VENDOR values ('cl006','300-663-911209','서울시 광진구','0556');
INSERT into T_VENDOR values ('cl007','400-663-911209','서울시 광진구','0556');
INSERT into T_VENDOR values ('cl008','500-234-911209','서울시 광진구','0556');
INSERT into T_VENDOR values ('cl009','600-623-911209','서울시 광진구','0556');
INSERT into T_VENDOR values ('cl010','700-112-911209','서울시 광진구','0556');
INSERT into T_VENDOR values ('cl011','800-559-911209','서울시 광진구','0556');
INSERT into T_VENDOR values ('cl012','900-990-911209','서울시 광진구','0556');
INSERT into T_VENDOR values ('cl013','120-144-911209','서울시 광진구','0556');

INSERT into T_OUT values (3,100,10000,'cl001') 
INSERT into T_OUT values (4,12,10000,'cl001');
INSERT into T_OUT values (3,10,20000,'cl001');
INSERT into T_OUT values (5,50,30000,'cl001');

delete from T_IN where flower_code = 1;
delete from T_IN where flower_code = 2;
delete from T_IN where flower_code = 3;
delete from T_IN where flower_code = 4;
delete from T_IN where flower_code = 5;
delete from T_IN where flower_code = 6;


INSERT into T_IN values (2,'해바라기',500,100,1,sysdate);
INSERT into T_IN values (1,'장미',100,300,2,sysdate);
INSERT into T_IN values (3,'튤립',500,100,1,sysdate);
INSERT into T_IN values (4,'수국',100,400,1,sysdate);
INSERT into T_IN values (5,'안개꽃',1000,50,3,sysdate);
INSERT into T_IN values (6,'민들레',300,10,2,sysdate);


alter table T_OUT drop column flower_name;

-- ============================T_VENDOR SQL문=============================

select  * from T_VENDOR a inner join T_OUT b on a.client_code = b.client_code  where a.client_code = 'cl001'

select * from T_VENDOR order by client_code;