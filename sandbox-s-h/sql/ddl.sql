create table dish
(
	id char(36) not null
		primary key,
	name varchar(45) not null,
	description varchar(100) null
)
;

create table dish_ingredient
(
	dish_id char(36) not null,
	ingredient_id char(36) not null,
	primary key (dish_id, ingredient_id),
	constraint fk_dish_ingredient_dish_id
		foreign key (dish_id) references dish (id)
)
;

create index fk_dish_ingredient_ingredient_id_idx
	on dish_ingredient (ingredient_id)
;

create table ingredient
(
	id char(36) not null
		primary key,
	name varchar(45) not null,
	description varchar(100) null,
	freezed tinyint default '0' null
)
;

alter table dish_ingredient
	add constraint fk_dish_ingredient_ingredient_id
		foreign key (ingredient_id) references ingredient (id)
;

create table menu
(
	id char(36) not null
		primary key,
	name varchar(45) not null,
	description varchar(100) null
)
;

create table menu_dish
(
	menu_id char(36) not null,
	dish_id char(36) not null,
	primary key (menu_id, dish_id),
	constraint menu_dish_menu_id
		foreign key (menu_id) references menu (id),
	constraint menu_dish_dish_id
		foreign key (dish_id) references dish (id)
)
;

create index menu_dish_dish_id_idx
	on menu_dish (dish_id)
;

create table person
(
	id int(10) unsigned auto_increment
		primary key,
	full_name varchar(45) not null,
	country varchar(45) null
)
;

