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
	departure_time integer,
	departure_place_id integer,
	no_of_artists integer,
	no_of_crew integer,
	no_of_guests integer,
	extra_info varchar(500),
	foreign key(arrival_place_id) references places on delete cascade,
	foreign key(hotel_id) references places on delete cascade,
	foreign key(departure_place_id) references places on delete cascade,
	primary key(id)
);

insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Faithless (uk)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Skinny Puppy (can)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Cradle of Filth (uk)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Karl Bartos (d)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('The Soundtrack of our lives',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('My Dying Bride (uk)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Ellen Allien (d)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Broder Daniel',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Marit Bergman',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Weeping Willows',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Eskobar',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Lustans Lakejer',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Meshuggah',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Olle Ljungström',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Fixmer/McCarthy (fr/uk)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Allied Vision (e)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Sara Noxx (d)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Magnet (n)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Vive La Fête (b)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Sophie Rimheden',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Wolfsheim (d)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Iris (us)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Space Tribe (aus)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Her Majesty',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Jens Lekman',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Universal Poplab',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('The Low Frequency in Stereo (n)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('The Immortal Lee County Killers (us)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Patrick Wolf (uk)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Wizzy Noise (gr)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Bamboo Forest (fr)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Disco Volante',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Etnoscope',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Deportees',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('SUB6 (isr)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('DJ Antaro (d)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('DJ D-Nox (d)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('DJ Dimitri (uk)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('DJ Pushava (d)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Moonbabies',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('C.Aarmé',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Laakso',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Blanka',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Lolita stasi collective',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Burst',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Richard Reagh & wwnb2',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Gustav & The seasick sailors',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Chandra',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Seventribe',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Spektralized (n)',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Strip Music',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Sturm Café',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('The Accidents',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('The Legends',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('The Sweetbacks',4,4,1);
insert into artists (name,arrival_place_id,departure_place_id,hotel_id) values ('Kraftwerk',4,4,1);

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
	foreign key (role_id) references roles on delete cascade,
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
	foreign key (mobile_phone_id) references mobile_phones on delete cascade,
	primary key (id)
);

insert into transports (start_time, return_time, internal) values ('2004-07-16 20:00','2004-07-16 23:00', 0);

create table transport_dropoffs (
	id serial,
	transport_id integer,
	place_id integer,
	dropoff_time timestamp,
	foreign key (transport_id) references transports on delete cascade,
	foreign key (place_id) references places on delete cascade,
	primary key (id)
);

insert into transport_dropoffs (transport_id, place_id, dropoff_time) values (1,2,'2004-07-16 21:15');
insert into transport_dropoffs (transport_id, place_id, dropoff_time) values (1,3,'2004-07-16 22:00');

create table car_transport (
	car_id integer,
	transport_id integer,
	foreign key (car_id) references cars on delete cascade,
	foreign key (transport_id) references transports on delete cascade
);

insert into car_transport (car_id, transport_id) values (1,1);
insert into car_transport (car_id, transport_id) values (4,1);

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

