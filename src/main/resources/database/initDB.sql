
create table "Category"
(
  "id" SERIAL,
  "name" character varying,
  "parentId" bigint
)
with (
  autovacuum_enabled=true)
;

create index "IX_Relationship2" on "Category" ("parentId")
;

alter TABLE "Category" ADD CONSTRAINT "PK_Category" PRIMARY KEY ("id")
;

-- Table Good

create table "Good"
(
  "id" SERIAL,
  "goodName" character varying,
  "vendorNumber" character varying not null,
  "categoryId" bigint not null
)
with (
  autovacuum_enabled=true)
;

alter TABLE "Good" ADD CONSTRAINT "PK_Good" PRIMARY KEY ("id")
;

-- Table GoodUrl

create table "GoodUrl"
(
  "id" SERIAL,
  "url" character varying not null,
  "createDate" timestamp not null,
  "goodId" bigint not null,
  "shopId" bigint not null
)
with (
  autovacuum_enabled=true)
;

alter TABLE "GoodUrl" ADD CONSTRAINT "PK_GoodUrl" PRIMARY KEY ("id")
;

-- Table Shop

create table "Shop"
(
  "id" SERIAL,
  "name" character varying not null,
  "shopUrl" character varying not null,
  "comment" character varying
)
with (
  autovacuum_enabled=true)
;

alter TABLE "Shop" ADD CONSTRAINT "PK_Shop" PRIMARY KEY ("id")
;

-- Create foreign keys (relationships) section -------------------------------------------------

alter TABLE "Good"
  ADD CONSTRAINT "Contains"
    FOREIGN KEY ("categoryId")
    REFERENCES "Category" ("id")
      ON delete NO ACTION
      ON update NO ACTION
;

alter TABLE "Category"
  ADD CONSTRAINT "Included"
    FOREIGN KEY ("parentId")
    REFERENCES "Category" ("id")
      ON delete NO ACTION
      ON update NO ACTION
;

alter TABLE "GoodUrl"
  ADD CONSTRAINT "Contains"
    FOREIGN KEY ("goodId")
    REFERENCES "Good" ("id")
      ON delete NO ACTION
      ON update NO ACTION
;

alter TABLE "GoodUrl"
  ADD CONSTRAINT "Used"
    FOREIGN KEY ("shopId")
    REFERENCES "Shop" ("id")
      ON delete NO ACTION
      ON update NO ACTION
;