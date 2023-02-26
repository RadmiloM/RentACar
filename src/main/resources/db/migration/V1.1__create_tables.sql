create table cars(
id uuid primary key,
licence_plate varchar,
make varchar,
model varchar,
year integer,
engine_capacity integer,
color varchar,
price serial,
doors integer,
size varchar(1),
power integer,
automatic boolean not null,
fuel varchar,
image varchar
);

create table users(
id uuid primary key,
username varchar unique,
email varchar unique not null,
password varchar,
first_name varchar,
last_name varchar,
phone_number varchar,
personal_number varchar,
image varchar,
admin boolean not null
);

create table contracts(
id uuid primary key,
start_date timestamp not null,
end_date timestamp not null,
total_price serial,
signed boolean not null,
approved boolean not null,
car_id uuid references cars(id),
user_id uuid references users(id)
);