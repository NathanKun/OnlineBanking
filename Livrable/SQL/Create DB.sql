CREATE DATABASE IF NOT EXISTS onlinebank;
#DROP DATABASE onlinebank;
USE onlinebank;


DROP TABLE IF EXISTS offer_ofr;
DROP TABLE IF EXISTS offres_ofr;
DROP TABLE IF EXISTS manager_mng;
DROP TABLE IF EXISTS news_nws;
DROP TABLE IF EXISTS advisor_avs;
DROP TABLE IF EXISTS contactform_ctf;
DROP TABLE IF EXISTS holdingshare_hds;
DROP TABLE IF EXISTS stockhistoricalprice_shp;
DROP TABLE IF EXISTS stock_stk;
DROP TABLE IF EXISTS transactionhistory_tsh;
DROP TABLE IF EXISTS account_acc;
DROP TABLE IF EXISTS client_clt;
DROP PROCEDURE IF EXISTS InsertRandToSHP;

CREATE TABLE IF NOT EXISTS offer_ofr (
	ofr_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ofr_title VARCHAR(255),
    ofr_text LONGTEXT,
    ofr_image VARCHAR(255),
    ofr_date DATETIME
);

CREATE TABLE IF NOT EXISTS manager_mng (
	mng_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    mng_name VARCHAR(30) NOT NULL,
	mng_login VARCHAR(30) NOT NULL UNIQUE,
    mng_password VARCHAR(178) NOT NULL
);

CREATE TABLE IF NOT EXISTS advisor_avs (
	avs_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    avs_name VARCHAR(60) NOT NULL,
    avs_login VARCHAR(20) NOT NULL UNIQUE,
    avs_password VARCHAR(178) NOT NULL
);
    
CREATE TABLE IF NOT EXISTS contactform_ctf (
	ctf_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ctf_name VARCHAR(60) NOT NULL,
    ctf_email VARCHAR(255) NOT NULL,
    ctf_tel VARCHAR(13),
    ctf_message TEXT
) ENGINE = Innodb;
    
CREATE TABLE IF NOT EXISTS client_clt (
	clt_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	clt_login CHAR(10) NOT NULL UNIQUE,
	clt_password CHAR(178) NOT NULL, # Hashed by Class PasswordAuthentication
    clt_fname VARCHAR(30) NOT NULL,
    clt_lname VARCHAR(30) NOT NULL,
    clt_birthday DATE NOT NULL,
    clt_nationality VARCHAR(30) NOT NULL,
    clt_gender CHAR(1) NOT NULL, 	# m/f
    clt_address VARCHAR(255) NOT NULL,
    clt_postalcode CHAR(10),
    clt_city VARCHAR(30) NOT NULL,
    clt_telephonenumber VARCHAR(14) NOT NULL,
    clt_email VARCHAR(255) NOT NULL,
    clt_status VARCHAR(30) NOT NULL,
    clt_lastlogin DATETIME,
    clt_createdon DATETIME NOT NULL
) ENGINE = Innodb;

CREATE TABLE IF NOT EXISTS account_acc (
	acc_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    acc_number CHAR(16) NOT NULL UNIQUE,
    acc_iban VARCHAR(34) NOT NULL UNIQUE,
    acc_clt_id INT(10) NOT NULL,
    acc_balance NUMERIC(17,2) DEFAULT 0, # + if add funds, - if payment
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
	tsh_description VARCHAR(255),
    tsh_acc_number CHAR(16) NOT NULL,
    tsh_transactionon DATETIME NOT NULL,
    tsh_amount NUMERIC(17,2) NOT NULL,
    #FOREIGN KEY(tsh_clt_id) REFERENCES client_clt(clt_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(tsh_acc_number) REFERENCES account_acc(acc_number) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = Innodb;

CREATE TABLE IF NOT EXISTS stock_stk (
    stk_ticker VARCHAR(10) NOT NULL PRIMARY KEY,
    stk_name VARCHAR(255) NOT NULL,
    stk_description MEDIUMTEXT
) ENGINE = Innodb;

/*
CREATE TABLE IF NOT EXISTS stockhistoricalprice_shp (
	shp_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    shp_stk_ticker VARCHAR(10) NOT NULL,
    shp_datetime DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    shp_price NUMERIC(10,2) NOT NULL,
    FOREIGN KEY(shp_stk_ticker) REFERENCES stock_stk(stk_ticker) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = Innodb;
*/

CREATE TABLE IF NOT EXISTS holdingshare_hds(
	hds_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    hds_stk_ticker VARCHAR(10) NOT NULL,
    hds_acc_id INT(10) NOT NULL,
    hds_numberofshares INT(10) NOT NULL,
    hds_boughton DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    #hds_total NUMERIC(17,2) NOT NULL,
    FOREIGN KEY(hds_stk_ticker) REFERENCES stock_stk(stk_ticker) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(hds_acc_id) REFERENCES account_acc(acc_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = Innodb;

CREATE TABLE IF NOT EXISTS news_nws (
	nws_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nws_title VARCHAR(255),
    nws_text LONGTEXT,
    nws_image VARCHAR(255),
    nws_type VARCHAR(32),
    nws_date DATETIME
);


# insert data

INSERT INTO client_clt VALUES(null, "1000000000", 
	"$31$16$-uVazABmj_zVigoaLAUSoXxH8J9lmy4yODXNHijAuJAqd-KK7-6J3Mxl4mPNxIe5B5hfqdswHa5KXlMLwW4JqPP27cvaZFNjQ1yvrW6aLfns_7PcrF72o4f7gSyj8oLTCxnTAq8Pf5dH_zkklWcJiTnXXcpjapxydXSE_GdHQR0", 
    "firstName", "lastName", STR_TO_DATE('1994-07-10','%Y-%m-%d'),
	"Chinese", "M", "1 rue Abc", "76000", "Rouen", "01234567", "e@mail.com", "Marié(e)", NOW(), 
	('2009-06-08 23:53:17'));
INSERT INTO account_acc VALUES(null, "4444555566660001", "AL47212110090000000235698741", 1, 987.65, 0, 1);
INSERT INTO account_acc VALUES(null, "4444555566660002", "BG80BNBG96611020345678", 1, 23333.33, 2.5, 2);
INSERT INTO account_acc VALUES(null, "4444555566660003", "BA391290079401028494", 1, 0.00, 0, 3);


INSERT INTO client_clt VALUES(null, "1000000001", 
	"$31$16$dbPTfmG7Rsoc_404pj9xhSdcYfeSnRWUTpceh1k2Qf9WYXmEYdjU-kAf3Lo4wycfc2awxnRyCiMhDVPl4V-AX24NuC6dC2iXaMEVm_5p2D0Egbb6gR4M08o_w1oWEgk5zkH_Kkr8g7_JdCbxGngvPVwFL49KWXGfKvQXm353FdY", 
	"Haoran", "Wang", STR_TO_DATE('1999-09-09','%Y-%m-%d'),
	"Chinese", "M", "233 rue de Rouen", "76800", "St du Ry", "0607080910", "wanghaoran@gmail.com", 
	"Divorcé(e)", NOW(), ('2017-03-29 10:05:21'));
INSERT INTO account_acc VALUES(null, "2222333322220001", "BE62510007547061", 2, 1643.68, 0, 1);
INSERT INTO account_acc VALUES(null, "2222333322220002", "BH67BMAG00001299123456", 2, 2500.00, 2.5, 2);
#INSERT INTO account_acc VALUES(null, "2222333322220003", "x", 2, 0, 0, 3);

INSERT INTO transactionhistory_tsh VALUES(null, "a acc1 description 3", "2222333322220001", NOW(), -13.33);
INSERT INTO transactionhistory_tsh VALUES(null, "a acc1 description 4", "2222333322220001", NOW(), -3.33);
INSERT INTO transactionhistory_tsh VALUES(null, "a acc1 description 1", "2222333322220001", NOW(), -33.33);
INSERT INTO transactionhistory_tsh VALUES(null, "a acc1 description 2", "2222333322220001", NOW(), -23.33);
INSERT INTO transactionhistory_tsh VALUES(null, "a acc1 description 3", "2222333322220001", NOW(), -13.33);
INSERT INTO transactionhistory_tsh VALUES(null, "a acc1 description 4", "2222333322220001", NOW(), -3.33);
INSERT INTO transactionhistory_tsh VALUES(null, "a acc1 description 1", "2222333322220001", NOW(), -33.33);
INSERT INTO transactionhistory_tsh VALUES(null, "a acc1 description 2", "2222333322220001", NOW(), -23.33);
INSERT INTO transactionhistory_tsh VALUES(null, "a acc1 description 3", "2222333322220001", NOW(), -13.33);
INSERT INTO transactionhistory_tsh VALUES(null, "a acc1 description 4", "2222333322220001", NOW(), -3.33);
INSERT INTO transactionhistory_tsh VALUES(null, "a acc1 description 1", "2222333322220001", NOW(), -33.33);
INSERT INTO transactionhistory_tsh VALUES(null, "a acc1 description 2", "2222333322220001", NOW(), -23.33);
INSERT INTO transactionhistory_tsh VALUES(null, "a acc1 description 3", "2222333322220001", NOW(), -13.33);
INSERT INTO transactionhistory_tsh VALUES(null, "a acc1 description 4", "2222333322220001", NOW(), -3.33);

INSERT INTO transactionhistory_tsh VALUES(null, "a acc2 description 1", "2222333322220002", NOW(), -333.33);
INSERT INTO transactionhistory_tsh VALUES(null, "a acc2 description 2", "2222333322220002", NOW(), -323.33);
INSERT INTO transactionhistory_tsh VALUES(null, "a acc2 description 3", "2222333322220002", NOW(), -313.33);

INSERT INTO transactionhistory_tsh VALUES(null, "virement emis vers le compte 3333666699990001","2222333322220001", NOW(), -23.33);
INSERT INTO transactionhistory_tsh VALUES(null, "virement recu du compte 3333666699990001", "2222333322220001", NOW(), 13.33);
INSERT INTO transactionhistory_tsh VALUES(null, "virement recu du compte 3333666699990001", "2222333322220001", NOW(), 3.33);
INSERT INTO transactionhistory_tsh VALUES(null, "virement emis vers le compte 3333666699990001", "2222333322220001", NOW(), -33.33);
INSERT INTO transactionhistory_tsh VALUES(null, "virement recu du compte 3333666699990001", "2222333322220001", NOW(), 23.33);
INSERT INTO transactionhistory_tsh VALUES(null, "virement recu du compte 3333666699990001", "2222333322220001", NOW(), 13.33);
INSERT INTO transactionhistory_tsh VALUES(null, "virement emis vers le compte 3333666699990001", "2222333322220001", NOW(), -3.33);
INSERT INTO transactionhistory_tsh VALUES(null, "virement emis vers le compte 3333666699990001", "2222333322220001", NOW(), -33.33);
INSERT INTO transactionhistory_tsh VALUES(null, "virement emis vers le compte 3333666699990001", "2222333322220001", NOW(), -23.33);
INSERT INTO transactionhistory_tsh VALUES(null, "virement recu du compte 3333666699990001", "2222333322220001", NOW(), 13.33);

INSERT INTO client_clt VALUES(null, "1000000002", 
	"$31$16$qcBh8ENZcSfpeStNzJnhpc0-uw6SIxwJUK6gAEaIn3hkb_Rg6BAhXcqw2EUWabPq3kz6e7eXMTKgOLpbSUTiCnEKlvvpOga2G760JqfQu7ljJbl1D-7vGEGKY-Z00XjC7jrD4BdKny4CI82dchPxQBWLbt7xEeAgeKfAYfzedG0", 
	"Onepunch", "Man", STR_TO_DATE('1888-08-08','%Y-%m-%d'),
	"Chinese", "M", "321 rue abbe de l'epee21 rue abbe de l'epee21 rue abbe de l'epee21 rue abbe de l'epee21 rue abbe de l'epee21 rue abbe de l'epee21 rue abbe de l'epee21 rue abbe de l'epee21 rue abbe de l'epee", "33445", "Fukuchima", "0607080910", "wanghaoran@gmail.com", 
	"Séparé(e)", NOW(), ('2015-01-02 20:33:45'));
INSERT INTO account_acc VALUES(null, "3333666699990001", "AZ21NABZ00000000137010001944", 3, 65535.00, 0, 1);
#INSERT INTO account_acc VALUES(null, "3333666699990003", "xx", 3, 1200.00, 0, 3);
#INSERT INTO account_acc VALUES(null, "3333666699990002", "AD1200012030200359100100", 3, 10, 2.7, 2);

INSERT INTO transactionhistory_tsh VALUES(null, "virement recu du compte 2222333322220001", "3333666699990001", NOW(), 733.33);
INSERT INTO transactionhistory_tsh VALUES(null, "virement recu du compte 2222333322220001", "3333666699990001", NOW(), 723.33);
INSERT INTO transactionhistory_tsh VALUES(null, "virement emis vers le compte 2222333322220001", "3333666699990001", NOW(), -713.33);
INSERT INTO transactionhistory_tsh VALUES(null, "virement emis vers le compte 2222333322220001", "3333666699990001", NOW(), -73.33);

INSERT INTO client_clt VALUES(null, "1236784567", 
	"$31$16$BnYo6uJe7XrpkVWoOB0VQ3a_czDxDs0Y3K6JnhN-dTTGNgskiOsIFSywcuBgB_gR2JBuMFkLmus91-IaaRdl3ZAMLlnsaXIcJy0soYuTmdmo_VEJJbXG2FbsZ-iukUTvxnno0LUqokfwKpjI8qtcUkP_DsHSqNo7Gt8UaLmwLBQ", 
	"Bill", "Gate", STR_TO_DATE('1960-03-11','%Y-%m-%d'),
	"American", "M", "some rode", "01234", "SomeCity", "0607080910", "billgate@gmail.com", 
	"Célibataire", NOW(), ('2016-07-08 07:20:11'));
INSERT INTO account_acc VALUES(null, "4444888844440001", "HR1210010051863000160", 4, 10086, 0, 1);


INSERT INTO client_clt VALUES(null, "1236784568", 
	"$31$16$2ec4sn8HF7BL3emHhaRnVO1mXuBS1kgT8n2dZGeLnOvEteyjEb27Gsba06Cjdl1bFJKVKlek93veTr_llOpFuWkAiOLLMw2w2vUaf0l9A11pQLN8Wyngn1-lywD0Rzxt1g7TleFaTwf91d7qqKTSK_3kOBNjqPoS50zOzqJU53o", 
	"What", "Ever", STR_TO_DATE('1990-03-11','%Y-%m-%d'),
	"American", "M", "What ever rode", "01234", "WhatEverCity", "0607080910", "what@ever.omg", 
	"Célibataire", NOW(), ('2016-03-03 03:30:30'));
INSERT INTO account_acc VALUES(null, "4444888844440002", "FR7688888666661123678456816", 5, 600, 0, 1);
INSERT INTO account_acc VALUES(null, "4444888844440003", "FR7688888666662123678456863", 5, 1322, 1.5, 2);
INSERT INTO account_acc VALUES(null, "4444888844440004", "FR7688888666663123678456813", 5, 0, 0, 3);

INSERT INTO transactionhistory_tsh VALUES(null, "212 euros ajoutés via une carte de type Visa", "2222333322220001", STR_TO_DATE('2016-12-02, 07:08:09','%Y-%m-%d, %H:%i:%s'), 212);
INSERT INTO transactionhistory_tsh VALUES(null, "312 euros ajoutés via une carte de type Visa", "3333666699990001", STR_TO_DATE('2016-12-02, 07:08:09','%Y-%m-%d, %H:%i:%s'), 312);
INSERT INTO transactionhistory_tsh VALUES(null, "12 euros ajoutés via une carte de type Visa", "2222333322220002", STR_TO_DATE('2016-12-13, 07:08:09','%Y-%m-%d, %H:%i:%s'), 12);
INSERT INTO transactionhistory_tsh VALUES(null, "232 euros ajoutés via une carte de type Visa", "2222333322220002", STR_TO_DATE('2016-12-24, 07:08:09','%Y-%m-%d, %H:%i:%s'), 232);
INSERT INTO transactionhistory_tsh VALUES(null, "1 euros ajoutés via une carte de type Visa", "2222333322220001", STR_TO_DATE('2017-01-01, 07:08:09','%Y-%m-%d, %H:%i:%s'), 1);
INSERT INTO transactionhistory_tsh VALUES(null, "231 euros ajoutés via une carte de type Visa", "2222333322220002", STR_TO_DATE('2017-01-08, 07:08:09','%Y-%m-%d, %H:%i:%s'), 231);
INSERT INTO transactionhistory_tsh VALUES(null, "1 euros ajoutés via une carte de type Visa", "2222333322220001", STR_TO_DATE('2017-01-09, 07:08:09','%Y-%m-%d, %H:%i:%s'), 1);
INSERT INTO transactionhistory_tsh VALUES(null, "2 euros ajoutés via une carte de type Visa", "3333666699990001", STR_TO_DATE('2017-01-20, 07:08:09','%Y-%m-%d, %H:%i:%s'), 2);
INSERT INTO transactionhistory_tsh VALUES(null, "212 euros ajoutés via une carte de type Visa", "2222333322220001", STR_TO_DATE('2017-02-02, 07:08:09','%Y-%m-%d, %H:%i:%s'), 212);
INSERT INTO transactionhistory_tsh VALUES(null, "312 euros ajoutés via une carte de type Visa", "3333666699990001", STR_TO_DATE('2017-02-02, 07:08:09','%Y-%m-%d, %H:%i:%s'), 312);
INSERT INTO transactionhistory_tsh VALUES(null, "231 euros ajoutés via une carte de type Visa", "2222333322220002", STR_TO_DATE('2017-03-08, 07:08:09','%Y-%m-%d, %H:%i:%s'), 231);
INSERT INTO transactionhistory_tsh VALUES(null, "2 euros ajoutés via une carte de type Visa", "3333666699990001", STR_TO_DATE('2017-03-20, 07:08:09','%Y-%m-%d, %H:%i:%s'), 2);
INSERT INTO transactionhistory_tsh VALUES(null, "12 euros ajoutés via une carte de type Visa", "2222333322220002", STR_TO_DATE('2017-04-13, 07:08:09','%Y-%m-%d, %H:%i:%s'), 12);
INSERT INTO transactionhistory_tsh VALUES(null, "232 euros ajoutés via une carte de type Visa", "2222333322220002", STR_TO_DATE('2017-05-24, 07:08:09','%Y-%m-%d, %H:%i:%s'), 232);

INSERT INTO transactionhistory_tsh VALUES(null, "vous avez effectue un virement au compte 3333666699990001  motif: ", "2222333322220002", STR_TO_DATE('2016-10-13, 07:08:09','%Y-%m-%d, %H:%i:%s'), -122);
INSERT INTO transactionhistory_tsh VALUES(null, "vous avez effectue un virement au compte 3333666699990001  motif: ", "2222333322220002", STR_TO_DATE('2016-10-24, 07:08:09','%Y-%m-%d, %H:%i:%s'), -632);
INSERT INTO transactionhistory_tsh VALUES(null, "vous avez effectue un virement au compte 2222333322220002  motif: ", "2222333322220001", STR_TO_DATE('2016-11-02, 07:08:09','%Y-%m-%d, %H:%i:%s'), -612);
INSERT INTO transactionhistory_tsh VALUES(null, "vous avez effectue un virement au compte 2222333322220002  motif: ", "3333666699990001", STR_TO_DATE('2016-11-02, 07:08:09','%Y-%m-%d, %H:%i:%s'), -312);
INSERT INTO transactionhistory_tsh VALUES(null, "vous avez effectue un virement au compte 3333666699990001  motif: ", "2222333322220001", STR_TO_DATE('2016-12-01, 07:08:09','%Y-%m-%d, %H:%i:%s'), -123);
INSERT INTO transactionhistory_tsh VALUES(null, "vous avez effectue un virement au compte 3333666699990001  motif: ", "2222333322220002", STR_TO_DATE('2017-01-08, 07:08:09','%Y-%m-%d, %H:%i:%s'), -231);
INSERT INTO transactionhistory_tsh VALUES(null, "vous avez effectue un virement au compte 3333666699990001  motif: ", "2222333322220001", STR_TO_DATE('2017-01-09, 07:08:09','%Y-%m-%d, %H:%i:%s'), -13);
INSERT INTO transactionhistory_tsh VALUES(null, "vous avez effectue un virement au compte 2222333322220001  motif: ", "3333666699990001", STR_TO_DATE('2017-01-20, 07:08:09','%Y-%m-%d, %H:%i:%s'), -20);
INSERT INTO transactionhistory_tsh VALUES(null, "vous avez effectue un virement au compte 2222333322220002  motif: ", "2222333322220001", STR_TO_DATE('2017-02-02, 07:08:09','%Y-%m-%d, %H:%i:%s'), -712);
INSERT INTO transactionhistory_tsh VALUES(null, "vous avez effectue un virement au compte 2222333322220001  motif: ", "3333666699990001", STR_TO_DATE('2017-02-02, 07:08:09','%Y-%m-%d, %H:%i:%s'), -512);
INSERT INTO transactionhistory_tsh VALUES(null, "vous avez effectue un virement au compte 3333666699990001  motif: ", "2222333322220002", STR_TO_DATE('2017-03-08, 07:08:09','%Y-%m-%d, %H:%i:%s'), -431);
INSERT INTO transactionhistory_tsh VALUES(null, "vous avez effectue un virement au compte 2222333322220001  motif: ", "3333666699990001", STR_TO_DATE('2017-03-20, 07:08:09','%Y-%m-%d, %H:%i:%s'), -233);
INSERT INTO transactionhistory_tsh VALUES(null, "vous avez effectue un virement au compte 2222333322220001  motif: ", "2222333322220002", STR_TO_DATE('2017-04-13, 07:08:09','%Y-%m-%d, %H:%i:%s'), -112);
INSERT INTO transactionhistory_tsh VALUES(null, "vous avez effectue un virement au compte 2222333322220001  motif: ", "2222333322220002", STR_TO_DATE('2017-04-24, 07:08:09','%Y-%m-%d, %H:%i:%s'), -32);


INSERT INTO stock_stk VALUES('^FCHI', 'CAC 40', '');
INSERT INTO stock_stk VALUES('%5EFCHI', 'CAC 40', '');
INSERT INTO stock_stk VALUES('AC.PA', 'Accor', 'FR0000120404');
INSERT INTO stock_stk VALUES('AI.PA', 'Air Liquide', 'FR0000120073');
INSERT INTO stock_stk VALUES('ALO.PA', 'Alstom', '');
INSERT INTO stock_stk VALUES('MT.AS', 'ArcelorMittal', 'LU0323134006');
INSERT INTO stock_stk VALUES('CS.PA', 'AXA', 'FR0000120628');
INSERT INTO stock_stk VALUES('BNP.PA', 'BNP Paribas', 'FR0000131104');
INSERT INTO stock_stk VALUES('EN.PA', 'Bouygues', 'FR0000120503');
INSERT INTO stock_stk VALUES('CAP.PA', 'Cap Gemini', 'FR0000125338');
INSERT INTO stock_stk VALUES('CA.PA', 'Carrefour', 'FR0000120172');
INSERT INTO stock_stk VALUES('SGO.PA', 'Compagnie de Saint-Gobain', 'FR0000125007');
INSERT INTO stock_stk VALUES('ACA.PA', 'Crédit Agricole', 'FR0000045072');
INSERT INTO stock_stk VALUES('EDF.PA', 'EDF', '');
INSERT INTO stock_stk VALUES('AIR.PA', 'EADS - Airbus', '');
INSERT INTO stock_stk VALUES('EI.PA', 'Essilor International', 'FR0000121667');
INSERT INTO stock_stk VALUES('ORA.PA', 'France Télécom(Orange)', '');
INSERT INTO stock_stk VALUES('ENGI.PA', 'GDF Suez', '');
INSERT INTO stock_stk VALUES('GTO.AS', 'Gemalto', '');
INSERT INTO stock_stk VALUES('BN.PA', 'Groupe Danone', 'FR0000120644');
INSERT INTO stock_stk VALUES('KER.PA', 'Kering', 'FR0000121485');
INSERT INTO stock_stk VALUES('LHN.PA', 'LafargeHolcim', 'CH0012214059');
INSERT INTO stock_stk VALUES('LR.PA', 'LEGRAND', 'FR0010307819');
INSERT INTO stock_stk VALUES('OR.PA', 'LOréal', 'FR0000120321');
INSERT INTO stock_stk VALUES('MC.PA', 'LVMH Moet Hennessy Louis Vuitton', 'FR0000121014');
INSERT INTO stock_stk VALUES('ML.PA', 'Michelin (Compagnie Générale d Etablissements Michelin SCPA)', 'FR0000121261');
INSERT INTO stock_stk VALUES('RI.PA', 'Pernod Ricard', 'FR0000120693');
INSERT INTO stock_stk VALUES('PUB.PA', 'Publicis Groupe', 'FR0000130577');
INSERT INTO stock_stk VALUES('RNO.PA', 'Renault', 'FR0000131906');
INSERT INTO stock_stk VALUES('SAF.PA', 'SAFRAN', 'FR0000073272');
INSERT INTO stock_stk VALUES('SAN.PA', 'Sanofi', 'FR0000120578');
INSERT INTO stock_stk VALUES('SU.PA', 'Schneider Electric', 'FR0000121972');
INSERT INTO stock_stk VALUES('GLE.PA', 'Société Générale SA', 'FR0000130809');
INSERT INTO stock_stk VALUES('STM.PA', 'STMicroelectronics', '');
INSERT INTO stock_stk VALUES('SOLB.BR', 'Solvay', 'BE0003470755');
INSERT INTO stock_stk VALUES('TEC.PA', 'Technip', 'FR0000131708');
INSERT INTO stock_stk VALUES('FP.PA', 'TOTAL', 'FR0000120271');
INSERT INTO stock_stk VALUES('UL.MI', 'Unibail-Rodamco', 'FR0000124711');
INSERT INTO stock_stk VALUES('FR.PA', 'Valeo', 'FR0000130338');
INSERT INTO stock_stk VALUES('VIE.PA', 'Veolia Environnement', 'FR0000124141');
INSERT INTO stock_stk VALUES('DG.PA', 'Vinci', 'FR0000125586');
INSERT INTO stock_stk VALUES('VIV.PA', 'Vivendi', 'FR0000127771');

# gauss distribution generator
/*DROP FUNCTION IF EXISTS gauss;
DELIMITER //
CREATE FUNCTION gauss(mean float, stdev float) RETURNS float
BEGIN
set @x=rand(), @y=rand();
set @gaus = ((sqrt(-2*log(@x))*cos(2*pi()*@y))*stdev)+mean;
return @gaus;
END
//
DELIMITER ;*/

# procedure to generate random historical price
/*DELIMITER $$
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
DELIMITER ;*/

#CALL InsertRandToSHP(25);

INSERT INTO advisor_avs VALUES(null, 'MrAdvisorA', 'a', 
	"$31$16$dbPTfmG7Rsoc_404pj9xhSdcYfeSnRWUTpceh1k2Qf9WYXmEYdjU-kAf3Lo4wycfc2awxnRyCiMhDVPl4V-AX24NuC6dC2iXaMEVm_5p2D0Egbb6gR4M08o_w1oWEgk5zkH_Kkr8g7_JdCbxGngvPVwFL49KWXGfKvQXm353FdY"
);
INSERT INTO advisor_avs VALUES(null, 'MsAdvisorB', 'b', 
	"$31$16$qcBh8ENZcSfpeStNzJnhpc0-uw6SIxwJUK6gAEaIn3hkb_Rg6BAhXcqw2EUWabPq3kz6e7eXMTKgOLpbSUTiCnEKlvvpOga2G760JqfQu7ljJbl1D-7vGEGKY-Z00XjC7jrD4BdKny4CI82dchPxQBWLbt7xEeAgeKfAYfzedG0"
);
INSERT INTO advisor_avs VALUES(null, 'MrsAdvisorC', 'c', 
	"$31$16$BnYo6uJe7XrpkVWoOB0VQ3a_czDxDs0Y3K6JnhN-dTTGNgskiOsIFSywcuBgB_gR2JBuMFkLmus91-IaaRdl3ZAMLlnsaXIcJy0soYuTmdmo_VEJJbXG2FbsZ-iukUTvxnno0LUqokfwKpjI8qtcUkP_DsHSqNo7Gt8UaLmwLBQ"
);


INSERT INTO news_nws VALUES(null, "Emmanuel MACRON élu président de la République Française !", "Avec une estimation de 65.5% des voix, le jeune de 39 ans devient le nouveau président français pour les 5 ans à venir, devançant ainsi Marine LE PEN, la leader droite en France. Notons que le taux d'abstention est un record depuis 1969.", "http://france3-regions.francetvinfo.fr/hauts-de-france/sites/regions_france3/files/styles/top_big_2x/public/assets/images/2017/05/07/12424293-3041841.png?itok=jbhqj4cR", "OFFICIEL", STR_TO_DATE('2017-05-08, 06:07:08','%Y-%m-%d, %H:%i:%s'));
INSERT INTO news_nws VALUES(null, "BankRading expose au salon Franchise Expo Toulouse 2016", "BankRading expose au Salon de Toulouse. Toute l'équipe du pôle Franchise et Commerce Associé deBankRading sera présente afin d'informer sur un projet,répondre aux interrogations et conseiller/accompagner dans la réalisation d'un projet.", "http://www.accesscreditspro.com/wp-content/uploads/2017/02/slider.jpg", "BankRading", STR_TO_DATE('2017-05-07, 21:22:23','%Y-%m-%d, %H:%i:%s'));
INSERT INTO news_nws VALUES(null, "L'euro au-dessus de $1,10 après les résultats de la présidentielle", "L'euro a franchi dimanche le seuil de 1,10 dollar pour la première fois depuis l'élection de Donald Trump à la présidence des Etats-Unis et a inscrit un plus haut d'un an contre le yen en réaction à la large victoire d'Emmanuel Macron.", "http://fm.cnbc.com/applications/cnbc.com/resources/img/editorial/2013/11/20/101216114-stacks_oh_euro_bank_notes.1910x1000.jpg", "BOURSE", STR_TO_DATE('2017-05-06, 17:18:19','%Y-%m-%d, %H:%i:%s'));
INSERT INTO news_nws VALUES(null, "Prêt Personnel BankRading, au printemps, c'est maintenant !", "Vous avez envie de partir en vacances ou de changer de voiture, vous avez besoin de remplacer une partie de votre équipement, les projets ne manquent pas, encore faut-il disposer des bons leviers pour les rendre concrets !", "http://img.20mn.fr/coWoab2ETqqi-wwlQm8l1w/2048x1536-fit_illustration-fleurs-printemps.jpg", "BankRading", STR_TO_DATE('2017-05-05, 11:10:09','%Y-%m-%d, %H:%i:%s'));
INSERT INTO news_nws VALUES(null, "BankRading et Compte-Normandie s'allient", "Dans le cadre des partenariats avec la Confédération des Buralistes de France, notre banque rajoute un nouvel allié à son actif.", "images/bank.png", "BankRading", STR_TO_DATE('2017-03-10, 14:15:16','%Y-%m-%d, %H:%i:%s'));
INSERT INTO news_nws VALUES(null, "Actionnaires : nouvelle plateforme !", "Bonne nouvelle pour le cercle des actionnaires de la BankRading, notre groupe se fortifie d'un nouveau site Internet exclusif, muni des dernières mises à jour.", "images/bank.png", "BankRading", STR_TO_DATE('2017-04-15, 14:15:16','%Y-%m-%d, %H:%i:%s'));
INSERT INTO news_nws VALUES(null, "Groupe BankRading : Résultars au 31 mars 2017", "Le Conseil d'administration de la BankRading a examiné les résultats de la banque pour le premier trimestre de l'année en cours.", "images/bank.png", "BankRading", STR_TO_DATE('2017-05-01, 18:19:20','%Y-%m-%d, %H:%i:%s'));
INSERT INTO news_nws VALUES(null, "MACRON ET LE PEN AU DERNIER TOUR !", "Le ministère de l'Intérieur a publié les résultats définitifs du premier tour de la présidentielle ce lundi après-midi. Emmanuel Macron obtient ainsi 24,01% des suffrages exprimes, devant à 21,30%. ", "./images/macron.jpg", "OFFICIEL", STR_TO_DATE('2017-04-24, 14:15:16','%Y-%m-%d, %H:%i:%s'));
INSERT INTO news_nws VALUES(null, "le CAC40 en forte hausse après les premiers résultats.", "Les principales Bourses européennes ont ouvert en vive hausse lundi au lendemain du premier tour de l'élection présidentielle française qui a placé en tête Emmanuel Macron, un résultat qui profite aux actifs financiers français, en premier lieu le CAC 40 et ses valeurs bancaires.", "http://www.cbnews.fr/var/media/225/original/indice-cac40-224325.jpg", "BOURSE", STR_TO_DATE('2017-04-24, 07:08:09','%Y-%m-%d, %H:%i:%s'));
INSERT INTO news_nws VALUES(null, "LIGUE DES CHAMPIONS : Monaco dans le dernier carré !", "L'AS Monaco a battu le Borussia Dortmund ce mercredi en quarts de finale retour de la Ligue des champions (3-1, 6-3 sur l'ensemble des deux matches) grâce à des buts Mbappé, Falcao et Germain, et disputera les demi-finales, une première pour un club français depuis 2010.", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Monaco_City_001.jpg/750px-Monaco_City_001.jpg", "SPORT", STR_TO_DATE('2017-04-24, 9:15:35','%Y-%m-%d, %H:%i:%s'));
INSERT INTO news_nws VALUES(null, "Offre d'emploi : Ingénieur Expert en Collaboration (Voix et Vidéo)", "Le candidat sera affecté à un environnement à forte expertise technique allant de l'évaluation, conception, implémentation et livraison de solutions complexes. ", "images/bank.png", "BankRading", STR_TO_DATE('2017-05-05, 14:10:08','%Y-%m-%d, %H:%i:%s'));
INSERT INTO news_nws VALUES(null, "LIGUE DES CHAMPIONS : Ce sera JUVENTUS vs Real Madrid en Finale !", "Pour l'édition 2017 de la Coupe européenne des clubs, la JUVENTUS s'est qualifiée au détriment de l'AS MONACO, au terme d'une rencontre bouillante. Ainsi était le cas pour le REAL MADRID qui s'est contenté d'un nul au retour.", "https://www.cuw.edu/_files/images/test3.JPG", "SPORT", STR_TO_DATE('2017-05-07, 9:15:35','%Y-%m-%d, %H:%i:%s'));
INSERT INTO news_nws VALUES(null, "LVMH détrône Total au sommet du CAC 40","Andrea Tueni,analyste chez Saxo Banque:'C’est une première depuis la fin des années 1980, puisqu’il y avait habituellement des valeurs de l’industrie lourde en tête des capitalisations.'Mieux vaut vendre des robes Dior et des sacs Louis Vuitton que d’extraire et raffiner du pétrole!","https://r.lvmh-static.com/uploads/2015/02/lvmh-losange-noir1-2335x876.jpg", "BOURSE", STR_TO_DATE('2017-05-06, 13:12:11','%Y-%m-%d, %H:%i:%s'));

INSERT INTO manager_mng VALUES(null, "manager a", "a", 
	"$31$16$dbPTfmG7Rsoc_404pj9xhSdcYfeSnRWUTpceh1k2Qf9WYXmEYdjU-kAf3Lo4wycfc2awxnRyCiMhDVPl4V-AX24NuC6dC2iXaMEVm_5p2D0Egbb6gR4M08o_w1oWEgk5zkH_Kkr8g7_JdCbxGngvPVwFL49KWXGfKvQXm353FdY");


INSERT INTO offer_ofr VALUES(null, "Compte sans frais", 
				"<br>Compte sans frais!:<br><br><br>
                <h2>*Mentions legales</h2>
				<img src='./images/mentions.png' alt='Mentions legals' />", 
                "./images/offre_1.png", NOW());
INSERT INTO offer_ofr VALUES(null, "Carte VISA graduite", 
				"<br>Carte VISA graduite:<br><br><br>
                <h2>*Mentions legales</h2>
				<p>Avec votre Carte Bancaire Visa Premier BankRading, c’est vous
					qui décidez, vous pouvez :</p>
				<p>-Bénéficier de garanties d’assurance et assistance pour vous
					et votre famille, en France et à l’étranger lors de vos voyages</p>
				<p>-Choisir entre le débit immédiat et différé</p>
				<p>-Ajuster vous-même vos plafonds de façon temporaire ou
					définitive en fonction de vos besoins (Sous réserve d’acceptation en
					ligne par la Banque)</p>
				<p>-Disposer du paiement sans contact</p>
				<p>-Fixer les alertes sur vos opérations cartes depuis votre
					Espace Client</p>", 
				"./images/offre2.png", NOW());
INSERT INTO offer_ofr VALUES(null, "Offre compte bancaire", 
					"<br>Prime de 80€ offerte:<br><br><br>
                    <h2>Conditions de l'offre :</h2>
					<p>-Prime de 80€ offerte pour une première ouverture d'un Compte Bancaire BankRading 
					jusqu'au 27/04/2017 dont la Carte Bancaire a été activée dans le mois suivant l'ouverture du compte</p>  
					<p>-La prime sera versée sur le Compte Bancaire par la banque dans les 15 jours ouvrés suivant l’activation de la carte.</p>
					<h3>Si demande d'ouverture simultanée d'un Livret d'épargne BankRading :</h3>
					<p>-Prime de 50€ offerte pour une première ouverture d'un Livret d'épargne BankRading, jusqu'au 27/04/2017,
					ouvert concomitamment au compte bancaire, et 3% annuels brut garantis pendant 2 mois pour un montant de 75 000€ maximum.
					Au-delà de cette période et de ce montant, le taux standard du Livret d'épargne est appliqué. 
					Le taux standard du Livret d’épargne BforBank est actuellement de 0,30% annuel brut et est susceptible d’être révisé à tout moment par la banque.</p>", 
                    "./images/offre3.png", NOW());
