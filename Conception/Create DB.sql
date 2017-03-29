CREATE DATABASE IF NOT EXISTS onlineBank;
#DROP DATABASE onlinebank;
USE onlinebank;
DROP TABLE IF EXISTS holdingshare_hds;
DROP TABLE IF EXISTS stockhistoricalprice_shp;
DROP TABLE IF EXISTS stock_stk;
DROP TABLE IF EXISTS transactionhistory_tsh;
DROP TABLE IF EXISTS account_acc;
DROP TABLE IF EXISTS client_clt;
DROP PROCEDURE IF EXISTS InsertRandToSHP;
    
CREATE TABLE IF NOT EXISTS client_clt (
	clt_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	clt_login VARCHAR(30) NOT NULL,
    clt_fname VARCHAR(30) NOT NULL,
    clt_lname VARCHAR(30) NOT NULL,
    clt_birthday DATE NOT NULL,
    clt_nationality VARCHAR(30) NOT NULL,
    clt_gender CHAR(1) NOT NULL, 	# m/f
    clt_address VARCHAR(255) NOT NULL,
    clt_postalcode INT(5) NOT NULL,
    clt_city VARCHAR(30) NOT NULL,
    clt_telephonenumber VARCHAR(14) NOT NULL,
    clt_email VARCHAR(254) NOT NULL,
    clt_status TINYINT(1) NOT NULL,
    clt_lastlogin DATETIME,
    clt_createdon DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS account_acc (
	acc_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    acc_number CHAR(16) NOT NULL UNIQUE,
    acc_clt_id INT(10) NOT NULL,
    acc_balance NUMERIC(17,2) DEFAULT 0,
    acc_interest NUMERIC(5,2) NOT NULL DEFAULT 0,
    acc_type TINYINT(1) NOT NULL, # 1 for transaction account, 2 for savings account, 3 for securities account
    FOREIGN KEY(acc_clt_id) REFERENCES client_clt(clt_id) ON DELETE CASCADE ON UPDATE CASCADE
);

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
);

CREATE TABLE IF NOT EXISTS stock_stk (
	stk_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    #stk_ticker VARCHAR(10) NOT NULL UNIQUE,
    stk_name VARCHAR(254) NOT NULL,
    stk_description TEXT(65534),
    stk_price NUMERIC(10,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS stockhistoricalprice_shp (
	shp_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    shp_stk_id INT(10) NOT NULL,
    shp_datetime DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    shp_price NUMERIC(10,2) NOT NULL,
    FOREIGN KEY(shp_stk_id) REFERENCES stock_stk(stk_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS holdingshare_hds(
	hds_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    hds_stk_id INT(10) NOT NULL,
    hds_acc_id INT(10) NOT NULL,
    hds_numberofshares INT(10) NOT NULL,
    hds_boughton DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    hds_total NUMERIC(17,2) NOT NULL,
    FOREIGN KEY(hds_stk_id) REFERENCES stock_stk(stk_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(hds_acc_id) REFERENCES account_acc(acc_id) ON DELETE CASCADE ON UPDATE CASCADE
);





# insert data

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


# procedure to generate random historical price
DELIMITER $$
CREATE PROCEDURE InsertRandToSHP(IN MinVal INT, IN MaxVal INT)
    BEGIN
        DECLARE i INT;
        DECLARE stockId INT;
        SET i = 1;
        SET stockId = 1;
        START TRANSACTION;
        WHILE stockId <= 40 DO
			WHILE i <= 180 DO
				INSERT INTO stockhistoricalprice_shp VALUES (
                null, stockId, subdate(current_date, i), (MinVal + CEIL(RAND() * (MaxVal - MinVal))) * (stockId % 7 + 1) + RAND());
				SET i = i + 1;
			END WHILE;
			SET stockId = stockId + 1;
			SET i = 1;
            # set today's stock price
			UPDATE stock_stk 
			SET stk_price = (MinVal + CEIL(RAND() * (MaxVal - MinVal))) * (stockId % 7) + RAND()
			WHERE stk_id = stockId;
        END WHILE;
        COMMIT;
    END$$
DELIMITER ;

CALL InsertRandToSHP(45, 60);