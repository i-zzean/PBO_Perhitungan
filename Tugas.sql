DROP TABLE perhitungan;
CREATE TABLE perhitungan(
	idOperasi SERIAL PRIMARY KEY,
	bilangan1 NUMERIC(12,2),
	bilangan2 INTEGER,
	operator CHAR(1)
);

