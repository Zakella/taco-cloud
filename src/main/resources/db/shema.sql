
CREATE TABLE IF NOT EXISTS Ingredient (
                                          id VARCHAR(4) NOT NULL,
                                          name VARCHAR(25) NOT NULL,
                                          type VARCHAR(150) NOT NULL
);

create table if not exists Taco (
                                    id int primary key ,
                                    name varchar(50) not null,
                                    createdAt timestamp not null
);

create table if not exists Taco_Ingredients (
                                                taco bigint not null,
                                                ingredient varchar(4) not null
);

alter table Taco_Ingredients
    add foreign key (taco) references Taco(id);

ALTER TABLE Ingredient ADD PRIMARY KEY (id);

alter table Taco_Ingredients
    add foreign key (ingredient) references Ingredient(id);

create table if not exists Taco_Order (
                                          id int primary key ,
                                          deliveryName varchar(50) not null,
                                          deliveryStreet varchar(50) not null,
                                          deliveryCity varchar(50) not null,
                                          deliveryState varchar(2) not null,
                                          deliveryZip varchar(10) not null,
                                          ccNumber varchar(16) not null,
                                          ccExpiration varchar(5) not null,
                                          ccCVV varchar(3) not null,
                                          placedAt timestamp not null
);



CREATE TABLE IF NOT EXISTS Taco_Order_Tacos (
                                                tacoOrder BIGINT NOT NULL,
                                                taco BIGINT NOT NULL
);

alter table Taco_Order_Tacos
    add foreign key (tacoOrder) references Taco_Order(id);
alter table Taco_Order_Tacos
    add foreign key (taco) references Taco(id);

alter  table taco ADD taco_order_key BIGINT not null;
alter table taco add taco_order bigint not null ;

create table if not exists Ingredient_Ref (
                                              ingredient varchar(4) not null,
                                              taco bigint not null,
                                              taco_key bigint not null
);