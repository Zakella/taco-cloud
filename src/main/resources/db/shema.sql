
CREATE TABLE IF NOT EXISTS INGREDIENT (
                                          id VARCHAR(4) NOT NULL,
                                          name VARCHAR(25) NOT NULL,
                                          type VARCHAR(10) NOT NULL
);

create table if not exists TACO (
                                    id identity,
                                    name varchar(50) not null,
                                    createdAt timestamp not null
);

create table if not exists TACO_INGREDIENTS (
                                                taco bigint not null,
                                                ingredient varchar(4) not null
);

alter table TACO_INGREDIENTS
    add foreign key (taco) references Taco(id);

ALTER TABLE INGREDIENT ADD PRIMARY KEY (ID);

alter table TACO_INGREDIENTS
    add foreign key (INGREDIENT) references INGREDIENT(ID);

create table if not exists TACO_ORDER (
                                          id identity,
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



CREATE TABLE IF NOT EXISTS TACO_ORDER_TACOS (
                                                tacoOrder BIGINT NOT NULL,
                                                taco BIGINT NOT NULL
);

alter table TACO_ORDER_TACOS
    add foreign key (tacoOrder) references Taco_Order(id);
alter table TACO_ORDER_TACOS
    add foreign key (taco) references Taco(id);