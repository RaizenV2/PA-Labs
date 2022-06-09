CREATE TABLE countries (
  name VARCHAR(50)
);

ALTER TABLE countries ADD COLUMN ID SERIAL PRIMARY KEY;

/* Need some space here ^^ */


CREATE TABLE continents (
  name VARCHAR(50)
);

ALTER TABLE continents ADD COLUMN ID SERIAL PRIMARY KEY;

/* Command to use for executing the script: \i /path/to/file */
