BEGIN TRANSACTION;
CREATE TABLE "adatok" (
	helyezes INTEGER PRIMARY KEY,
	nev TEXT,
	vagyon REAL,
	ev INTEGER,
	ceg TEXT,
	orszag TEXT);
INSERT INTO `adatok` VALUES (1,'Carlos Slim Helu',73.0,1940,'telecom','Mexikó');
INSERT INTO `adatok` VALUES (2,'Bill Gates',67.0,1956,'Microsoft','USA');
INSERT INTO `adatok` VALUES (3,'Amancio Ortega',57.0,1936,'Zara','Spanyolország');
INSERT INTO `adatok` VALUES (4,'Warren Buffett',53.5,1931,'Berkshire Hathaway','USA');
INSERT INTO `adatok` VALUES (5,'Larry Ellison',43.0,1945,'Oracle','USA');
COMMIT;
