
CREATE TABLE "Category"
(
  "id" Bigint NOT NULL,
  "name" Character varying,
  "parentId" Bigint
)
WITH (
  autovacuum_enabled=true)
;

CREATE INDEX "IX_Relationship2" ON "Category" ("parentId")
;

ALTER TABLE "Category" ADD CONSTRAINT "PK_Category" PRIMARY KEY ("id")
;

-- Table Good

CREATE TABLE "Good"
(
  "id" Bigint NOT NULL,
  "goodName" Character varying,
  "vendorNumber" Character varying NOT NULL,
  "categoryId" Bigint NOT NULL
)
WITH (
  autovacuum_enabled=true)
;

ALTER TABLE "Good" ADD CONSTRAINT "PK_Good" PRIMARY KEY ("id","categoryId")
;

-- Table GoodUrl

CREATE TABLE "GoodUrl"
(
  "id" Bigint NOT NULL,
  "url" Character varying NOT NULL,
  "createDate" Timestamp NOT NULL,
  "goodId" Bigint NOT NULL,
  "categoryId" Bigint NOT NULL,
  "shopId" Bigint NOT NULL
)
WITH (
  autovacuum_enabled=true)
;

ALTER TABLE "GoodUrl" ADD CONSTRAINT "PK_GoodUrl" PRIMARY KEY ("id","goodId","categoryId","shopId")
;

-- Table Shop

CREATE TABLE "Shop"
(
  "id" Bigint NOT NULL,
  "name" Character varying NOT NULL,
  "shopUrl" Character varying NOT NULL,
  "comment" Character varying
)
WITH (
  autovacuum_enabled=true)
;

ALTER TABLE "Shop" ADD CONSTRAINT "PK_Shop" PRIMARY KEY ("id")
;

-- Create foreign keys (relationships) section -------------------------------------------------

ALTER TABLE "Good"
  ADD CONSTRAINT "Contains"
    FOREIGN KEY ("categoryId")
    REFERENCES "Category" ("id")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
;

ALTER TABLE "Category"
  ADD CONSTRAINT "Included"
    FOREIGN KEY ("parentId")
    REFERENCES "Category" ("id")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
;

ALTER TABLE "GoodUrl"
  ADD CONSTRAINT "Contains"
    FOREIGN KEY ("goodId", "categoryId")
    REFERENCES "Good" ("id", "categoryId")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
;

ALTER TABLE "GoodUrl"
  ADD CONSTRAINT "Used"
    FOREIGN KEY ("shopId")
    REFERENCES "Shop" ("id")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
;