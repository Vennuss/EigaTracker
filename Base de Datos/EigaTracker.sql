drop database if exists eigatracker;
create database eigatracker;
use eigatracker;

create table series (
nombre VARCHAR(250) not null primary key,
descripcion TEXT null
);

create table peliculas (
nombre VARCHAR(250) not null primary key,
descripcion TEXT null,
conocida bool default false
);

create table capitulos (
id int null auto_increment primary key,
conocida bool default false,
capitulo int(2) not null,
serie VARCHAR(250) not null,
temporada int(1) default 1,
foreign key (serie) references series(nombre)
on update cascade on delete cascade
);

create table registros_peliculas(
id int null auto_increment primary key,
notas text null,
comprension int(3) not null,
diversion int(3) not null,
fecha timestamp default current_timestamp,
PELICULA_REF VARCHAR(250) not null,
foreign key (PELICULA_REF) references peliculas(nombre)
on update cascade on delete cascade
);

create table registros_capitulos(
id int null auto_increment primary key,
notas text null,
comprension int(3) not null,
diversion int(3) not null,
fecha timestamp default current_timestamp,
CAPITULO_REF int not null,
foreign key (CAPITULO_REF) references capitulos(id)
on update cascade on delete cascade
);