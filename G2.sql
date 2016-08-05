--use master
--go
--drop database G2
--go
----------------------------------------------------------------------------------------
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
insert into themes(themeId, themeName) values(1, 'fruits')
insert into themes(themeId, themeName) values(2, 'vegetables')
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
(1,'avocado', 1, '../picture/pic001.jpeg' )
insert into pictureInfo(pictureId, pictureName, themeId, url) values
(2,'blackberry', 1, '../picture/pic002.jpeg' )
insert into pictureInfo(pictureId, pictureName, themeId, url) values
(3,'blueberry', 1, '../picture/pic003.jpeg' )
insert into pictureInfo(pictureId, pictureName, themeId, url) values
(4,'cherry', 1, '../picture/pic004.jpeg' )
insert into pictureInfo(pictureId, pictureName, themeId, url) values
(5,'coconut', 1, '../picture/pic005.jpeg' )
insert into pictureInfo(pictureId, pictureName, themeId, url) values
(6,'cranberry', 1, '../picture/pic006.jpeg' )
insert into pictureInfo(pictureId, pictureName, themeId, url) values
(7,'gooseberry', 1, '../picture/pic007.jpeg' )
insert into pictureInfo(pictureId, pictureName, themeId, url) values
(8,'mango', 1, '../picture/pic008.jpeg' )
insert into pictureInfo(pictureId, pictureName, themeId, url) values
(9,'papaya', 1, '../picture/pic009.jpeg' )
insert into pictureInfo(pictureId, pictureName, themeId, url) values
(10,'pear', 1, '../picture/pic010.jpeg' )
insert into pictureInfo(pictureId, pictureName, themeId, url) values
(11,'pineapple', 1, '../picture/pic011.jpeg' )
insert into pictureInfo(pictureId, pictureName, themeId, url) values
(12,'dried grapes', 1, '../picture/pic012.jpeg' )
insert into pictureInfo(pictureId, pictureName, themeId, url) values
(13,'raspberry', 1, '../picture/pic013.jpeg' )
insert into pictureInfo(pictureId, pictureName, themeId, url) values
(14,'walnut', 1, '../picture/pic014.jpeg' )
insert into pictureInfo(pictureId, pictureName, themeId, url) values
(15,'peanuts', 1, '../picture/pic015.jpeg' )
END
go
----------------------------------------------------------------------------------------
--select * from loginInf
--select @@SERVERNAME as svname
--select * from pictureInfo where themeId = 1