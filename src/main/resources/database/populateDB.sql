insert into "Category" (name, "parentId") values ('Смартфоны и гаджеты', null);
insert into "Category" (name, "parentId") values ('Смартфоны', 5);

insert into "Good" ("goodName", "vendorNumber", "categoryId") values ('Смартфон Samsung Galaxy M21 64 ГБ черный', 'SM-M215FZKUSER', 5);

-- https://www.dns-shop.ru/product/5fbc44bb7b2a3332/64-smartfon-samsung-galaxy-m21-64-gb-cernyj/

insert into "Shop" (name, "shopUrl", "comment") values ('GoodsRU', 'https://www.goods.ru/', 'Маркетплейс goods');
insert into "Shop" (name, "shopUrl", "comment") values ('DNS', 'https://www.dns-shop.ru/', 'Цифровая и бытовая техника');