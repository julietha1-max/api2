create table topicos(

id bigint not null auto_increment,
mensaje varchar(100) not null ,
nombre_curso varchar(100) not null ,
titulo varchar(100) not null ,
fecha_creacion varchar(200) not null ,
autor varchar(200) not null,
primary key(id)
);