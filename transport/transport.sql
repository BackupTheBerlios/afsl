drop database transport;
create database transport;

\c transport

\set ON_ERROR_STOP 1

create table cars (
	id serial,
	reg_no varchar(12) not null,
	car_type varchar(60) not null,
	no_of_seats integer not null,
	misc_info varchar(2500),
	primary key(id)
);

create table places (
	id serial,
	name varchar(50) unique not null,
	primary key (id)
);

insert into places (name) values ('Brunskog');
insert into places (name) values ('Hotell Ekelunden');
insert into places (name) values ('Oscar Statt');
insert into places (name) values ('Gardemoen');
insert into places (name) values ('Torp');
insert into places (name) values ('Hagegården');
insert into places (name) values ('Arvikafestivalen');
insert into places (name) values ('Hotell Bristol');

create table artists (
	id serial,
	name varchar(150) not null,
	contact_name varchar(140),
	phone_no varchar(50),
	arrival_time timestamp with time zone,
	arrival_place_id integer,
	hotel_id integer,
	departure_time timestamp with time zone,
	departure_place_id integer,
	no_of_artists integer,
	no_of_crew integer,
	no_of_guests integer,
	extra_info varchar(50000),
	foreign key(arrival_place_id) references places on delete set null,
	foreign key(hotel_id) references places on delete cascade,
	foreign key(departure_place_id) references places on delete cascade,
	primary key(id)
);

create table mobile_phones (
	id serial,
	phone_no varchar(15) not null,
	primary key(id)
);

create table roles (
	id serial,
	short_descr varchar(40) not null,
	long_descr varchar(200) not null,
	primary key (id)
);

insert into roles (short_descr,long_descr) values ('Artistkoordinator','Har hand om artisterna från flygplatsen till och med första avlämningspunkt');
insert into roles (short_descr,long_descr) values ('Chaufför','Kör bilar');
insert into roles (short_descr,long_descr) values ('Artisttransportkoordinator','Koordinerar transport och har hand om funktionärer');
insert into roles (short_descr,long_descr) values ('Bitr Artisttransportkoordinator','Biträder den som koordinerar transport och har hand om funktionärer');
insert into roles (short_descr,long_descr) values ('Aristkoordinatorchef','Koordinerar artisternas ankomst och har hand om funktionärer');

create table functionaries (
	id serial,
	name varchar(50) not null,
	begins_work timestamp not null,
	stops_work timestamp not null,
	role_id integer not null,
	foreign key (role_id) references roles on delete set null,
	primary key(id)
);

create table transports (
	id serial,
	start_time timestamp not null,
	return_time timestamp not null,
	actual_return_time timestamp,
	internal integer not null,
	misc_info varchar(4000),
	primary key (id)
);

create table mobile_phone_transport (
	mobile_phone_id integer,
	transport_id integer,
	foreign key (mobile_phone_id) references mobile_phones on delete cascade,
	foreign key (transport_id) references transports on delete cascade
);

create table transport_waypoints (
	id serial,
	transport_id integer,
	place_id integer,
	waypoint_time timestamp,
	foreign key (transport_id) references transports on delete cascade,
	foreign key (place_id) references places on delete cascade,
	primary key (id)
);

create table car_transport (
	car_id integer,
	transport_id integer,
	foreign key (car_id) references cars on delete cascade,
	foreign key (transport_id) references transports on delete cascade
);

create table artist_transport (
	artist_id integer,
	transport_id integer,
	foreign key (artist_id) references artists on delete cascade,
	foreign key (transport_id) references transports on delete cascade
);

create table functionary_transport (
	functionary_id integer,
	transport_id integer,
	foreign key (functionary_id) references functionaries on delete cascade,
	foreign key (transport_id) references transports on delete cascade
);

create table distance_reference (
	place_id_1 integer,
	place_id_2 integer,
	distance integer not null,
	foreign key (place_id_1) references places on delete cascade,
	foreign key (place_id_2) references places on delete cascade
);

