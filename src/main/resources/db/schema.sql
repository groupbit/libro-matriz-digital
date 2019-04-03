alter table Alumno drop foreign key FK86hueaus40jscj8n9txjvb3ur
alter table Alumno drop foreign key FK4e74jwq75t2vtgfxr8tle7oli
alter table Alumno drop foreign key FKh8hbo7sluc7fqwjr06jf34tyq
alter table Alumno_EstudioCursado drop foreign key FKthd9l4j9q1ipm813putv4kwe9
alter table Alumno_EstudioCursado drop foreign key FKllrxo3k1nwslck1916wxp9vsx
alter table Cursada drop foreign key FKrx8i1y7ks8l93bvnfbn00pgiv
alter table Cursada drop foreign key FKsrw2yi8py0x3ular6dk34v5jx
alter table Materia drop foreign key FKs5rc95ma6734n72byjss18x0j
alter table Materia_Materia drop foreign key FKmi92jg4sj1xh2o1xhlt2xcj1r
alter table Materia_Materia drop foreign key FK4ouvg8ndn5lv5aq4vt9brcc6p
drop table if exists Alumno
drop table if exists Alumno_EstudioCursado
drop table if exists Carrera
drop table if exists Cursada
drop table if exists Direccion
drop table if exists EstudioCursado
drop table if exists Examen
drop table if exists JugandoAMigrar
drop table if exists Materia
drop table if exists Materia_Materia
create table Alumno (id integer not null, actividad varchar(255), dni varchar(255), email varchar(255), estadoCivil varchar(255), familiaresACargo varchar(255), fechaDeNacimiento date, genero integer, hijos integer not null, horarioHabitual time, lugarDeNacimiento varchar(255), nombre varchar(255), obraSocial varchar(255), propietarioTelefonoAlternativo varchar(255), telefono varchar(255), telefonoAlternativo varchar(255), trabaja bit not null, carrera_id integer, direccion_id integer, titulo_id integer, primary key (id)) engine=InnoDB
create table Alumno_EstudioCursado (Alumno_id integer not null, otrosTitulos_id integer not null) engine=InnoDB
create table Carrera (id integer not null, archivada bit, duracion float not null, nombre varchar(255), resolucion varchar(255), primary key (id)) engine=InnoDB
create table Cursada (id integer not null, anio integer not null, estado integer, notaFinal integer, materia_id integer, alumno_id integer, primary key (id)) engine=InnoDB
create table Direccion (id integer not null, altura integer not null, calle varchar(255), codigoPostal varchar(255), departamento varchar(255), localidad varchar(255), partido varchar(255), primary key (id)) engine=InnoDB
create table EstudioCursado (id integer not null, anioEgreso integer not null, distrito varchar(255), institucion varchar(255), nombreTitulo varchar(255), primary key (id)) engine=InnoDB
create table Examen (id integer not null, ausente bit not null, calificacion float not null, tipoDeExamen integer, primary key (id)) engine=InnoDB
create table JugandoAMigrar (id integer not null, fedeAloi varchar(255), primary key (id)) engine=InnoDB
create table Materia (id integer not null, anioEnCarrera integer not null, docente varchar(255), esDificil bit not null, nombre varchar(255), promocionable bit, carrera_id integer, primary key (id)) engine=InnoDB
create table Materia_Materia (Materia_id integer not null, correlativas_id integer not null) engine=InnoDB
alter table Alumno_EstudioCursado add constraint UK_p8eq3w7igqp5k3qlvwedgavdp unique (otrosTitulos_id)
alter table Alumno add constraint FK86hueaus40jscj8n9txjvb3ur foreign key (carrera_id) references Carrera (id)
alter table Alumno add constraint FK4e74jwq75t2vtgfxr8tle7oli foreign key (direccion_id) references Direccion (id)
alter table Alumno add constraint FKh8hbo7sluc7fqwjr06jf34tyq foreign key (titulo_id) references EstudioCursado (id)
alter table Alumno_EstudioCursado add constraint FKthd9l4j9q1ipm813putv4kwe9 foreign key (otrosTitulos_id) references EstudioCursado (id)
alter table Alumno_EstudioCursado add constraint FKllrxo3k1nwslck1916wxp9vsx foreign key (Alumno_id) references Alumno (id)
alter table Cursada add constraint FKrx8i1y7ks8l93bvnfbn00pgiv foreign key (materia_id) references Materia (id)
alter table Cursada add constraint FKsrw2yi8py0x3ular6dk34v5jx foreign key (alumno_id) references Alumno (id)
alter table Materia add constraint FKs5rc95ma6734n72byjss18x0j foreign key (carrera_id) references Carrera (id)
alter table Materia_Materia add constraint FKmi92jg4sj1xh2o1xhlt2xcj1r foreign key (correlativas_id) references Materia (id)
alter table Materia_Materia add constraint FK4ouvg8ndn5lv5aq4vt9brcc6p foreign key (Materia_id) references Materia (id)
