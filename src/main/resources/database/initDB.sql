create table if not exists Good(
  "id" Bigint NOT NULL PRIMARY KEY,
  "goodName" Character varying,
  "vendorNumber" Character varying(200) NOT NULL
);
