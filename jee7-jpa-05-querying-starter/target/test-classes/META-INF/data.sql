insert into person(id, firstName, lastName, birthDate, street, number, postalCode, city) values(1000, 'John', 'Doe', '1970-01-01', 'Brighton Road', '27', '1000', 'Brussels');
insert into person(id, firstName, lastName, birthDate, street, number, postalCode, city) values(2000, 'Jane', 'Doe', '1970-01-02', 'Harper Lane', '8', '2845', 'London');
insert into person(id, firstName, lastName, birthDate, street, number, postalCode, city) values(3000, 'Tyler', 'Turner', '1983-07-15', 'Masonstreet', '72B', '5874', 'Winterfell');
insert into person(id, firstName, lastName, birthDate, street, number, postalCode, city) values(4000, 'Marcia', 'Jackson', '1975-03-28', 'Factory Lane', '100/7', '1578', 'Glasgow');
insert into person(id, firstName, lastName, birthDate, street, number, postalCode, city) values(5000, 'Allan', 'Wilson', '1964-12-28', 'Turingstreet', '1', '2547', 'Newcastle');

insert into candy_preferences(person_id, candy_color) values(1000, 'BLUE');
insert into candy_preferences(person_id, candy_color) values(2000, 'YELLOW');
insert into candy_preferences(person_id, candy_color) values(2000, 'VIOLET');
insert into candy_preferences(person_id, candy_color) values(3000, 'RED');
insert into candy_preferences(person_id, candy_color) values(3000, 'YELLOW');
insert into candy_preferences(person_id, candy_color) values(4000, 'RED');
insert into candy_preferences(person_id, candy_color) values(4000, 'GREEN');
insert into candy_preferences(person_id, candy_color) values(4000, 'BLUE');
insert into candy_preferences(person_id, candy_color) values(5000, 'RED');
insert into candy_preferences(person_id, candy_color) values(5000, 'YELLOW');
insert into candy_preferences(person_id, candy_color) values(5000, 'BLUE');

insert into candy(id, name, color, price, candy_type) values(1000, 'Jolly Ranger M&Ms', 'RED', 4.95, 'm&m');
insert into candy(id, name, color, price, candy_type) values(2000, 'Pink Kisses', 'PINK', 3.99, 'm&m');
insert into candy(id, name, color, price, candy_type) values(3000, 'Jumbo Gummy Bears', 'BLUE', 3.24, 'gummy');
insert into candy(id, name, color, price, candy_type) values(4000, 'Roaring Gummy Bears', 'VIOLET', 7.98, 'gummy');
insert into candy(id, name, color, price, candy_type) values(5000, 'Ultra Long Mega Bars', 'WHITE', 6.99, 'chocolate');
insert into candy(id, name, color, price, candy_type) values(6000, 'Sweethearts', 'BROWN', 3.74, 'chocolate');

insert into mnm(id, nuts) values(1000, true);
insert into mnm(id, nuts)  values(2000, false);
insert into gummy_bears(id, flavour) values(3000, 'cherry');
insert into gummy_bears(id, flavour) values(4000, 'spicy');
insert into chocolate_bar(id, length) values(5000, 100);
insert into chocolate_bar(id, length) values(6000, 3);

insert into candy_order(id, street, number, postalCode, city, person_id) values(1000, 'Churchstreet', '27', '1080', 'Antwerp', 3000);
insert into candy_order(id, street, number, postalCode, city, person_id) values(2000, 'Manhattan', '13', '1078', 'Geel', 4000);
insert into candy_order(id, street, number, postalCode, city, person_id) values(3000, 'Abbey Road', '7', '574', 'Lipton', 5000);
insert into candy_order(id, street, number, postalCode, city, person_id) values(4000, 'Red Herring Lane', '1', '2547', 'Dublin', 3000);


insert into order_line(id, quantity, order_id, candy_id) values(1000, 50, 1000, 1000);
insert into order_line(id, quantity, order_id, candy_id) values(2000, 20, 1000, 2000);
insert into order_line(id, quantity, order_id, candy_id) values(3000, 37, 1000, 3000);
insert into order_line(id, quantity, order_id, candy_id) values(4000, 7, 2000, 4000);
insert into order_line(id, quantity, order_id, candy_id) values(5000, 10, 2000, 5000);
insert into order_line(id, quantity, order_id, candy_id) values(6000, 1000, 3000, 6000);
insert into order_line(id, quantity, order_id, candy_id) values(7000, 300, 4000, 1000);
insert into order_line(id, quantity, order_id, candy_id) values(8000, 250, 4000, 3000);