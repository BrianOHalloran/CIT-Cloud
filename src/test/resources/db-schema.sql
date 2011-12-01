create table if not exists PERFORMER (name varchar(250), primary key(name))
create table if not exists LOCATION (name varchar(250), max_ticket_count int, primary key(name))
create table if not exists EVENT (location varchar(250), performer varchar(250), event_name varchar(250), ticket_count int, primary key(event_name))



create table if not exists CUSTOMER(id int, name varchar(250), phone varchar(250), credit_card varchar(250), username varchar(250), password varchar(250), primary key(id))
create table if not exists BOOKING(id int, customer_name int, event_id int, num_tickets int, primary key(id))
