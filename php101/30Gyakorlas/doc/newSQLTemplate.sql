/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  adamr
 * Created: 2019.03.16.
 */

CREATE TABLE szoftverleltar.gep (
    id INT(2) NOT null AUTO_INCREMENT PRIMARY KEY,
    hely VARCHAR(4)  NOT null,
    tipus VARCHAR(8) NOT null,
    ipcim VARCHAR(12) NOT null
) ENGINE = INNODB CHARSET=utf8mb4 COLLATE utf8mb4_hungarian_ci;  

CREATE TABLE szoftverleltar.szoftver (
    id INT(3) NOT null AUTO_INCREMENT PRIMARY KEY,
    nev VARCHAR(33) NOT null,
    kategoria VARCHAR(26) NOT null
) ENGINE = INNODB CHARSET=utf8mb4 COLLATE utf8mb4_hungarian_ci;  

CREATE TABLE szoftverleltar.telepites (
    id INT(4) NOT null AUTO_INCREMENT PRIMARY KEY,
    gepid INT(2) NOT null,
    szoftverid int(3) NOT null,
    verzio VARCHAR(17) null,
    datum DATE null,
    INDEX gep_index (gepid),
    INDEX szoftverid_index (szoftverid),
    CONSTRAINT gep_megszoritas FOREIGN KEY (gepid) REFERENCES gep (id) ON DELETE CASCADE,
    CONSTRAINT szoftver_megszoritas FOREIGN key (szoftverid) REFERENCES szoftver (ID) ON DELETE CASCADE
) ENGINE = INNODB CHARSET=utf8mb4 COLLATE utf8mb4_hungarian_ci;  