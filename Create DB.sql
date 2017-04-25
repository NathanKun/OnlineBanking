CREATE DATABASE IF NOT EXISTS onlineBank;
#DROP DATABASE onlinebank;
USE onlinebank;

DROP TABLE IF EXISTS contactform_ctf;
DROP TABLE IF EXISTS holdingshare_hds;
DROP TABLE IF EXISTS stockhistoricalprice_shp;
DROP TABLE IF EXISTS stock_stk;
DROP TABLE IF EXISTS transactionhistory_tsh;
DROP TABLE IF EXISTS account_acc;
DROP TABLE IF EXISTS client_clt;
DROP PROCEDURE IF EXISTS InsertRandToSHP;
    
    
CREATE TABLE IF NOT EXISTS contactform_ctf (
	ctf_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ctf_name VARCHAR(60) NOT NULL,
    ctf_email VARCHAR(254) NOT NULL,
    ctf_tel VARCHAR(10),
    ctf_message TEXT
) ENGINE = Innodb;
    
CREATE TABLE IF NOT EXISTS client_clt (
	clt_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	clt_login CHAR(10) NOT NULL UNIQUE,
	clt_password CHAR(178) NOT NULL, # Hashed by PasswordAuthentication Class
    clt_fname VARCHAR(30) NOT NULL,
    clt_lname VARCHAR(30) NOT NULL,
    clt_birthday DATE NOT NULL,
    clt_nationality VARCHAR(30) NOT NULL,
    clt_gender CHAR(1) NOT NULL, 	# m/f
    clt_address VARCHAR(255) NOT NULL,
    clt_postalcode CHAR(10) NOT NULL,
    clt_city VARCHAR(30) NOT NULL,
    clt_telephonenumber VARCHAR(14) NOT NULL,
    clt_email VARCHAR(254) NOT NULL,
    clt_status VARCHAR(30) NOT NULL,
    clt_lastlogin DATETIME,
    clt_createdon DATETIME NOT NULL
) ENGINE = Innodb;

CREATE TABLE IF NOT EXISTS account_acc (
	acc_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    acc_number CHAR(16) NOT NULL UNIQUE,
    acc_clt_id INT(10) NOT NULL,
    acc_balance NUMERIC(17,2) DEFAULT 0,
    acc_interest NUMERIC(5,2) NOT NULL DEFAULT 0,
    acc_type TINYINT(1) NOT NULL, # 1 for transaction account, 2 for savings account, 3 for securities account
    FOREIGN KEY(acc_clt_id) REFERENCES client_clt(clt_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = Innodb;

/*
CREATE TABLE IF NOT EXISTS savingsaccount_sva (
	sav_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sav_acc_id INT(10) NOT NULL,
    sav_interest NUMERIC(5,2) NOT NULL DEFAULT 1.5,
    FOREIGN KEY(sav_acc_id) REFERENCES account_acc(acc_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS securitiesaccount_sca (
	scv_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    scv_acc_id INT(10) NOT NULL,
    FOREIGN KEY(scv_acc_id) REFERENCES account_acc(acc_id) ON DELETE CASCADE ON UPDATE CASCADE
);*/

CREATE TABLE IF NOT EXISTS transactionhistory_tsh (
	tsh_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    #tsh_clt_id INT(10) NOT NULL,	# optional
	tsh_description VARCHAR(254),
    tsh_acc_number CHAR(16) CHARACTER SET utf8 NOT NULL,
    tsh_transactionon DATETIME NOT NULL,
    tsh_amount NUMERIC(17,2) NOT NULL,
    #FOREIGN KEY(tsh_clt_id) REFERENCES client_clt(clt_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(tsh_acc_number) REFERENCES account_acc(acc_number) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = Innodb;

CREATE TABLE IF NOT EXISTS stock_stk (
	stk_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    #stk_ticker VARCHAR(10) NOT NULL UNIQUE,
    stk_name VARCHAR(254) NOT NULL,
    stk_description TEXT(65534),
    stk_price NUMERIC(10,2) NOT NULL
) ENGINE = Innodb;

CREATE TABLE IF NOT EXISTS stockhistoricalprice_shp (
	shp_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    shp_stk_id INT(10) NOT NULL,
    shp_datetime DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    shp_price NUMERIC(10,2) NOT NULL,
    FOREIGN KEY(shp_stk_id) REFERENCES stock_stk(stk_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = Innodb;

CREATE TABLE IF NOT EXISTS holdingshare_hds(
	hds_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    hds_stk_id INT(10) NOT NULL,
    hds_acc_id INT(10) NOT NULL,
    hds_numberofshares INT(10) NOT NULL,
    hds_boughton DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    #hds_total NUMERIC(17,2) NOT NULL,
    FOREIGN KEY(hds_stk_id) REFERENCES stock_stk(stk_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(hds_acc_id) REFERENCES account_acc(acc_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = Innodb;





# insert data

INSERT INTO client_clt VALUES(null, "login", 
	"$31$16$-uVazABmj_zVigoaLAUSoXxH8J9lmy4yODXNHijAuJAqd-KK7-6J3Mxl4mPNxIe5B5hfqdswHa5KXlMLwW4JqPP27cvaZFNjQ1yvrW6aLfns_7PcrF72o4f7gSyj8oLTCxnTAq8Pf5dH_zkklWcJiTnXXcpjapxydXSE_GdHQR0", 
    "firstName", "lastName", STR_TO_DATE('1994-07-10','%Y-%d-%m'),
	"Chinese", "M", "1 rue Abc", "76000", "Rouen", "01234567", "e@mail.com", "Celebataire", NOW(), 
	('2009-06-08 23:53:17'));
INSERT INTO account_acc VALUES(null, "4444555566660001", 1, 987.65, 0, 1);
INSERT INTO account_acc VALUES(null, "4444555566660002", 1, 23333.33, 2.5, 2);
INSERT INTO account_acc VALUES(null, "4444555566660003", 1, 1200.00, 0, 3);


INSERT INTO client_clt VALUES(null, "a", 
	"$31$16$dbPTfmG7Rsoc_404pj9xhSdcYfeSnRWUTpceh1k2Qf9WYXmEYdjU-kAf3Lo4wycfc2awxnRyCiMhDVPl4V-AX24NuC6dC2iXaMEVm_5p2D0Egbb6gR4M08o_w1oWEgk5zkH_Kkr8g7_JdCbxGngvPVwFL49KWXGfKvQXm353FdY", 
	"Haoran", "Wang", STR_TO_DATE('1999-09-09','%Y-%d-%m'),
	"Chinese", "M", "233 rue de Rouen", "76800", "St du Ry", "0607080910", "wanghaoran@gmail.com", 
	"Celebataire", NOW(), ('2017-03-29 10:05:21'));
INSERT INTO account_acc VALUES(null, "2222333322220001", 2, 1643.68, 0, 1);
INSERT INTO account_acc VALUES(null, "2222333322220002", 2, 2500.00, 2.5, 2);

INSERT INTO transactionhistory_tsh VALUES(null, "a acc1 description 1", "2222333322220001", NOW(), 33.33);
INSERT INTO transactionhistory_tsh VALUES(null, "a acc1 description 2", "2222333322220001", NOW(), 23.33);
INSERT INTO transactionhistory_tsh VALUES(null, "a acc1 description 3", "2222333322220001", NOW(), 13.33);
INSERT INTO transactionhistory_tsh VALUES(null, "a acc1 description 4", "2222333322220001", NOW(), 3.33);

INSERT INTO transactionhistory_tsh VALUES(null, "a acc2 description 1", "2222333322220002", NOW(), 333.33);
INSERT INTO transactionhistory_tsh VALUES(null, "a acc2 description 2", "2222333322220002", NOW(), 323.33);
INSERT INTO transactionhistory_tsh VALUES(null, "a acc2 description 3", "2222333322220002", NOW(), 313.33);


INSERT INTO client_clt VALUES(null, "b", 
	"$31$16$qcBh8ENZcSfpeStNzJnhpc0-uw6SIxwJUK6gAEaIn3hkb_Rg6BAhXcqw2EUWabPq3kz6e7eXMTKgOLpbSUTiCnEKlvvpOga2G760JqfQu7ljJbl1D-7vGEGKY-Z00XjC7jrD4BdKny4CI82dchPxQBWLbt7xEeAgeKfAYfzedG0", 
	"Onepunch", "Man", STR_TO_DATE('1888-08-08','%Y-%d-%m'),
	"Chinese", "M", "321 rue abbe de l'epee", "33445", "Fukuchima", "0607080910", "wanghaoran@gmail.com", 
	"Celebataire", NOW(), ('2015-01-02 20:33:45'));
INSERT INTO account_acc VALUES(null, "3333666699990001", 3, 65535.00, 0, 1);
INSERT INTO account_acc VALUES(null, "3333666699990003", 3, 1200.00, 0, 3);

INSERT INTO transactionhistory_tsh VALUES(null, "b acc1 description 1", "3333666699990001", NOW(), 733.33);
INSERT INTO transactionhistory_tsh VALUES(null, "b acc1 description 2", "3333666699990001", NOW(), 723.33);
INSERT INTO transactionhistory_tsh VALUES(null, "b acc1 description 3", "3333666699990001", NOW(), 713.33);
INSERT INTO transactionhistory_tsh VALUES(null, "b acc1 description 4", "3333666699990001", NOW(), 73.33);

INSERT INTO transactionhistory_tsh VALUES(null, "b acc3 description 1", "3333666699990003", NOW(), 433.33);
INSERT INTO transactionhistory_tsh VALUES(null, "b acc3 description 2", "3333666699990003", NOW(), 423.33);
INSERT INTO transactionhistory_tsh VALUES(null, "b acc3 description 3", "3333666699990003", NOW(), 413.33);


INSERT INTO client_clt VALUES(null, "1236784567", 
	"$31$16$BnYo6uJe7XrpkVWoOB0VQ3a_czDxDs0Y3K6JnhN-dTTGNgskiOsIFSywcuBgB_gR2JBuMFkLmus91-IaaRdl3ZAMLlnsaXIcJy0soYuTmdmo_VEJJbXG2FbsZ-iukUTvxnno0LUqokfwKpjI8qtcUkP_DsHSqNo7Gt8UaLmwLBQ", 
	"Bill", "Gate", STR_TO_DATE('1960-03-11','%Y-%d-%m'),
	"American", "M", "some rode", "01234", "SomeCity", "0607080910", "billgate@gmail.com", 
	"Married", NOW(), ('2016-07-08 07:20:11'));
INSERT INTO account_acc VALUES(null, "4444888844440001", 4, 10086, 0, 1);


INSERT INTO stock_stk VALUES(null, 'Accor', 'FR0000120404', 46.42);
INSERT INTO stock_stk VALUES(null, 'Air Liquide', 'FR0000120073', 10);
INSERT INTO stock_stk VALUES(null, 'Airbus', 'NL0000235190', 10);
INSERT INTO stock_stk VALUES(null, 'ArcelorMittal', 'LU0323134006', 10);
INSERT INTO stock_stk VALUES(null, 'Atos', 'FR0000051732', 10);
INSERT INTO stock_stk VALUES(null, 'AXA', 'FR0000120628', 10);
INSERT INTO stock_stk VALUES(null, 'BNP Paribas', 'FR0000131104', 10);
INSERT INTO stock_stk VALUES(null, 'Bouygues', 'FR0000120503', 10);
INSERT INTO stock_stk VALUES(null, 'Cap Gemini', 'FR0000125338', 10);
INSERT INTO stock_stk VALUES(null, 'Carrefour', 'FR0000120172', 10);
INSERT INTO stock_stk VALUES(null, 'Compagnie de Saint-Gobain', 'FR0000125007', 10);
INSERT INTO stock_stk VALUES(null, 'Crédit Agricole', 'FR0000045072', 10);
INSERT INTO stock_stk VALUES(null, 'Engie SA', 'FR0010208488', 10);
INSERT INTO stock_stk VALUES(null, 'Essilor International', 'FR0000121667', 10);
INSERT INTO stock_stk VALUES(null, 'Groupe Danone', 'FR0000120644', 10);
INSERT INTO stock_stk VALUES(null, 'Kering', 'FR0000121485', 10);
INSERT INTO stock_stk VALUES(null, 'LafargeHolcim', 'CH0012214059', 10);
INSERT INTO stock_stk VALUES(null, 'LEGRAND', 'FR0010307819', 10);
INSERT INTO stock_stk VALUES(null, 'LOréal', 'FR0000120321', 10);
INSERT INTO stock_stk VALUES(null, 'LVMH Moet Hennessy Louis Vuitton', 'FR0000121014', 10);
INSERT INTO stock_stk VALUES(null, 'Michelin (Compagnie Générale d Etablissements Michelin SCPA)', 'FR0000121261', 10);
INSERT INTO stock_stk VALUES(null, 'Nokia', 'FI0009000681', 10);
INSERT INTO stock_stk VALUES(null, 'Orange', 'FR0000133308', 10);
INSERT INTO stock_stk VALUES(null, 'Pernod Ricard', 'FR0000120693', 10);
INSERT INTO stock_stk VALUES(null, 'Peugeot', 'FR0000121501', 10);
INSERT INTO stock_stk VALUES(null, 'Publicis Groupe', 'FR0000130577', 10);
INSERT INTO stock_stk VALUES(null, 'Renault', 'FR0000131906', 10);
INSERT INTO stock_stk VALUES(null, 'SAFRAN', 'FR0000073272', 10);
INSERT INTO stock_stk VALUES(null, 'Saint-Gobain', 'FR0000125007', 10);
INSERT INTO stock_stk VALUES(null, 'Sanofi', 'FR0000120578', 10);
INSERT INTO stock_stk VALUES(null, 'Schneider Electric', 'FR0000121972', 10);
INSERT INTO stock_stk VALUES(null, 'Société Générale SA', 'FR0000130809', 10);
INSERT INTO stock_stk VALUES(null, 'Sodexo', 'FR0000121220', 10);
INSERT INTO stock_stk VALUES(null, 'Solvay', 'BE0003470755', 10);
INSERT INTO stock_stk VALUES(null, 'Technip', 'FR0000131708', 10);
INSERT INTO stock_stk VALUES(null, 'TOTAL', 'FR0000120271', 10);
INSERT INTO stock_stk VALUES(null, 'Unibail-Rodamco', 'FR0000124711', 10);
INSERT INTO stock_stk VALUES(null, 'Valeo', 'FR0000130338', 10);
INSERT INTO stock_stk VALUES(null, 'Veolia Environnement', 'FR0000124141', 10);
INSERT INTO stock_stk VALUES(null, 'Vinci', 'FR0000125486', 10);
INSERT INTO stock_stk VALUES(null, 'Vivendi', 'FR0000127771', 10);

# gauss distribution generator
DROP FUNCTION IF EXISTS gauss;
DELIMITER //
CREATE FUNCTION gauss(mean float, stdev float) RETURNS float
BEGIN
set @x=rand(), @y=rand();
set @gaus = ((sqrt(-2*log(@x))*cos(2*pi()*@y))*stdev)+mean;
return @gaus;
END
//
DELIMITER ;

# procedure to generate random historical price
DELIMITER $$
CREATE PROCEDURE InsertRandToSHP(IN Seed INT)
    BEGIN
        DECLARE i INT;
        DECLARE stockId INT;
        DECLARE basePrice INT;
        DECLARE lastPrice INT;
        DECLARE thisPrice DOUBLE;
        SET i = 180;
        SET stockId = 1;
        START TRANSACTION;
        WHILE stockId <= 40 DO
			# Generate base price
			SET basePrice = Seed * (stockId % 9) + 1;
            SET lastPrice = basePrice;
			WHILE i >= 1 DO
				# Generate today's data
				SET thisPrice = lastPrice + gauss(0, 0.1) * lastPrice; # varie maximum +- 10%
				# prevent price < 0
                IF (thisPrice < 0) THEN
					SET thisPrice = RAND() * Seed;
				END IF;
                # INSERT data
                INSERT INTO stockhistoricalprice_shp VALUES (
                null, stockId, subdate(current_date, i), thisPrice);
                # Counter++
				SET i = i - 1;
                SET lastPrice = thisPrice;
			END WHILE;
			SET stockId = stockId + 1;
			SET i = 180;
            # set today s stock price
			UPDATE stock_stk 
				SET stk_price = lastPrice + gauss(0, 0.1) * lastPrice
				WHERE stk_id = stockId;
        END WHILE;
        COMMIT;
    END$$
DELIMITER ;

CALL InsertRandToSHP(25);