drop database transport;
create database transport;

\c transport

\set ON_ERROR_STOP 1

create table cars (
	id serial,
	reg_no char(6) not null,
	car_type varchar(30) not null,
	no_of_seats integer not null,
	misc_info varchar(500),
	primary key(id)
);

insert into cars (reg_no, car_type, no_of_seats) values ('ABC123','Minibuss',9);
insert into cars (reg_no, car_type, no_of_seats) values ('ABC124','Minibuss',9);
insert into cars (reg_no, car_type, no_of_seats) values ('ABC125','Minibuss',9);
insert into cars (reg_no, car_type, no_of_seats) values ('ABC126','Minibuss',9);
insert into cars (reg_no, car_type, no_of_seats) values ('ABC127','Minibuss',9);
insert into cars (reg_no, car_type, no_of_seats) values ('ABC128','Minibuss',9);
insert into cars (reg_no, car_type, no_of_seats) values ('ABC129','Minibuss',9);
insert into cars (reg_no, car_type, no_of_seats) values ('QWE321','Personbil',5);
insert into cars (reg_no, car_type, no_of_seats) values ('QWE322','Personbil',5);
insert into cars (reg_no, car_type, no_of_seats) values ('QWE323','Personbil',5);
insert into cars (reg_no, car_type, no_of_seats) values ('QWE324','Personbil',5);
insert into cars (reg_no, car_type, no_of_seats) values ('QWE325','Personbil',5);

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
insert into places (name) values ('Hagagården');
insert into places (name) values ('Arvikafestivalen');
insert into places (name) values ('Hotell Bristol');

create table artists (
	id serial,
	name varchar(50) not null,
	contact_name varchar(40),
	phone_no varchar(25),
	arrival_time timestamp,
	arrival_place_id integer,
	hotel_id integer,
	departure_place_id integer,
	no_of_artists integer,
	no_of_crew integer,
	no_of_guests integer,
	extra_info varchar(500),
	foreign key(arrival_place_id) references places,
	foreign key(hotel_id) references places,
	foreign key(departure_place_id) references places,
	primary key(id)
);

insert into artists (name) values ('Faithless (uk)');
insert into artists (name) values ('Skinny Puppy (can)');
insert into artists (name) values ('Cradle of Filth (uk)');
insert into artists (name) values ('Karl Bartos (d)');
insert into artists (name) values ('The Soundtrack of our lives');
insert into artists (name) values ('My Dying Bride (uk)');
insert into artists (name) values ('Ellen Allien (d)');
insert into artists (name) values ('Broder Daniel');
insert into artists (name) values ('Marit Bergman');
insert into artists (name) values ('Weeping Willows');
insert into artists (name) values ('Eskobar');
insert into artists (name) values ('Lustans Lakejer');
insert into artists (name) values ('Meshuggah');
insert into artists (name) values ('Olle Ljungström');
insert into artists (name) values ('Fixmer/McCarthy (fr/uk)');
insert into artists (name) values ('Allied Vision (e)');
insert into artists (name) values ('Sara Noxx (d)');
insert into artists (name) values ('Magnet (n)');
insert into artists (name) values ('Vive La Fête (b)');
insert into artists (name) values ('Sophie Rimheden');
insert into artists (name) values ('Wolfsheim (d)');
insert into artists (name) values ('Iris (us)');
insert into artists (name) values ('Space Tribe (aus)');
insert into artists (name) values ('Her Majesty');
insert into artists (name) values ('Jens Lekman');
insert into artists (name) values ('Universal Poplab');
insert into artists (name) values ('The Low Frequency in Stereo (n)');
insert into artists (name) values ('The Immortal Lee County Killers (us)');
insert into artists (name) values ('Patrick Wolf (uk)');
insert into artists (name) values ('Wizzy Noise (gr)');
insert into artists (name) values ('Bamboo Forest (fr)');
insert into artists (name) values ('Disco Volante');
insert into artists (name) values ('Etnoscope');
insert into artists (name) values ('Deportees');
insert into artists (name) values ('SUB6 (isr)');
insert into artists (name) values ('DJ Antaro (d)');
insert into artists (name) values ('DJ D-Nox (d)');
insert into artists (name) values ('DJ Dimitri (uk)');
insert into artists (name) values ('DJ Pushava (d)');
insert into artists (name) values ('Moonbabies');
insert into artists (name) values ('C.Aarmé');
insert into artists (name) values ('Laakso');
insert into artists (name) values ('Blanka');
insert into artists (name) values ('Lolita stasi collective');
insert into artists (name) values ('Burst');
insert into artists (name) values ('Richard Reagh & wwnb2');
insert into artists (name) values ('Gustav & The seasick sailors');
insert into artists (name) values ('Chandra');
insert into artists (name) values ('Seventribe');
insert into artists (name) values ('Spektralized (n)');
insert into artists (name) values ('Strip Music');
insert into artists (name) values ('Sturm Café');
insert into artists (name) values ('The Accidents');
insert into artists (name) values ('The Legends');
insert into artists (name) values ('The Sweetbacks');
insert into artists (name) values ('Kraftwerk');

create table mobile_phones (
	id serial,
	phone_no varchar(15) not null,
	primary key(id)
);

insert into mobile_phones (phone_no) values ('0708-111111');
insert into mobile_phones (phone_no) values ('0708-111112');
insert into mobile_phones (phone_no) values ('0708-111113');
insert into mobile_phones (phone_no) values ('0708-111114');
insert into mobile_phones (phone_no) values ('0708-111115');
insert into mobile_phones (phone_no) values ('0708-111111');
insert into mobile_phones (phone_no) values ('0708-111111');
insert into mobile_phones (phone_no) values ('0708-111111');
insert into mobile_phones (phone_no) values ('0708-111116');
insert into mobile_phones (phone_no) values ('0708-111117');
insert into mobile_phones (phone_no) values ('0708-111118');
insert into mobile_phones (phone_no) values ('0708-111119');
insert into mobile_phones (phone_no) values ('0708-111120');
insert into mobile_phones (phone_no) values ('0708-111121');

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
	name varchar(30) not null,
	begins_work timestamp not null,
	stops_work timestamp not null,
	role_id integer not null,
	foreign key (role_id) references roles,
	primary key(id)
);

create table transports (
	id serial,
	start_time timestamp not null,
	return_time timestamp not null,
	actual_return_time timestamp,
	internal integer not null,
	mobile_phone_id integer,
	misc_info varchar(400),
	foreign key (mobile_phone_id) references mobile_phones,
	primary key (id)
);

insert into transports (start_time, return_time, internal) values ('2004-07-16 20:00','2004-07-16 23:00', 0);

create table transport_dropoffs (
	id serial,
	transport_id integer,
	place_id integer,
	dropoff_time timestamp,
	foreign key (transport_id) references transports,
	foreign key (place_id) references places,
	primary key (id)
);

insert into transport_dropoffs (transport_id, place_id, dropoff_time) values (1,2,'2004-07-16 21:15');
insert into transport_dropoffs (transport_id, place_id, dropoff_time) values (1,3,'2004-07-16 22:00');

create table car_transport (
	car_id integer,
	transport_id integer,
	foreign key (car_id) references cars,
	foreign key (transport_id) references transports
);

insert into car_transport (car_id, transport_id) values (1,1);
insert into car_transport (car_id, transport_id) values (4,1);

create table artist_transport (
	artist_id integer,
	transport_id integer,
	foreign key (artist_id) references artists,
	foreign key (transport_id) references transports
);

create table functionary_transport (
	functionary_id integer,
	transport_id integer,
	foreign key (functionary_id) references functionaries,
	foreign key (transport_id) references transports
);

create table distance_reference (
	place_id_1 integer,
	place_id_2 integer,
	distance integer not null,
	foreign key (place_id_1) references places,
	foreign key (place_id_2) references places
);

