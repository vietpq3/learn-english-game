if not exists(select name from master.sys.databases where name = 'G2')
create database G2
go
----------------------------------------------------------------------------------------
use G2
go
----------------------------------------------------------------------------------------
if not exists (select * from sys.objects where object_id = object_id('[dbo].[authority]') and type in ('U'))
BEGIN
create table authority(
	authority_id int primary key,
	authority_name nvarchar(50)
)

insert into authority(authority_id, authority_name) values(1, 'Administrator')
END
go
----------------------------------------------------------------------------------------
if not exists (select * from sys.objects where object_id = object_id('[dbo].[loginInf]') and type in ('U'))
BEGIN
create table loginInf(
	username varchar(20) primary key not null,
	passwords varchar(20) not null,
	authority_id int
)
insert into loginInf(username, passwords, authority_id) values('aaa','aaa',1)
END
go
----------------------------------------------------------------------------------------
if not exists (select * from sys.objects where object_id = object_id('[dbo].[themes]') and type in ('U'))
BEGIN
create table themes(
	themeId int primary key,
	themeName varchar(20)
)
insert into themes(themeId, themeName) values(1, 'vegetables')
insert into themes(themeId, themeName) values(2, 'fruits')
insert into themes(themeId, themeName) values(3, 'animals')
END
go
----------------------------------------------------------------------------------------
if not exists (select * from sys.objects where object_id = object_id('[dbo].[pictureInfo]') and type in ('U'))
BEGIN
create table pictureInfo(
	pictureId int primary key,
	pictureName varchar(20),
	themeId int,
	url varchar(300)
)
insert into pictureInfo(pictureId, pictureName, themeId, url) values
(1, )
END
go
----------------------------------------------------------------------------------------
--select * from loginInf
--select @@SERVERNAME as svname