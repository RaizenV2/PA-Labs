CREATE TABLE countries (
  name VARCHAR(30),
  continentID INT,
  UNIQUE (name)
);

ALTER TABLE countries ADD COLUMN ID SERIAL PRIMARY KEY;

/* Need some space here */


CREATE TABLE continents (
  name VARCHAR(30),
  UNIQUE (name)
);

ALTER TABLE continents ADD COLUMN ID SERIAL PRIMARY KEY;

/* Command to use for executing the script: \i /path/to/file */
