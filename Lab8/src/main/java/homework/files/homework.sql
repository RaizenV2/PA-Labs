CREATE TABLE cities (
  name VARCHAR(50),
  capital BOOLEAN,
  latitude FLOAT,
  longitude FLOAT
);

ALTER TABLE countries ADD COLUMN ID SERIAL PRIMARY KEY;
