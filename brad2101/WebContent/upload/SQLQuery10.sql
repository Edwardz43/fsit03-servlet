use TestDB
go 

drop table test1
go


create table test1
(
	id int identity(1, 10) not null primary key, 
	data int null default 100,
	data2 int not null,
	--�]�i�H�[�b�̫�  primary key(id)
) 
go

--�������
alter table test1
	add constraint chk_data check (data >= 0)
--���\
insert into test1  (data, data2) values (100, 100);
--����
insert into test1  (data, data2) values (-1, 100);

select * from test1


