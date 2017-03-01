INSERT INTO bank (mfo,edrpou,description) VALUES (300023,39019,'ПАТ \"УКРСОЦБАНК\"');
INSERT INTO bank (mfo,edrpou,description) VALUES (300346,23494714,'ПАТ \"АЛЬФА-БАНК\"');
INSERT INTO bank (mfo,edrpou,description) VALUES (320478,23697280,'АБ \"УКРГАЗБАНК\"');
INSERT INTO bank (mfo,edrpou,description) VALUES (320854,23362711,'ПАТ \"ДІАМАНТБАНК\"');
INSERT INTO bank (mfo,edrpou,description) VALUES (353553,9353504,'Фiлiя - Чернiгiвське обласне управлiння АТ \"Ощадбанк\"');
INSERT INTO bank (mfo,edrpou,description) VALUES (353586,14360570,'ЧЕРНІГІВСЬКЕ РУ ПАТ КБ \"ПРИВАТБАНК\"');
INSERT INTO bank (mfo,edrpou,description) VALUES (353649,25571287,'Філія АТ \"Укрексімбанк\" у м.Чернігові');
INSERT INTO bank (mfo,edrpou,description) VALUES (380805,14305909,'АТ \"Райффайзен Банк Аваль\"');



INSERT INTO organization (edrpou,description) VALUES (3357671,'ПУБЛІЧНЕ АКЦІОНЕРНЕ ТОВАРИСТВО \"ОБЛТЕПЛОКОМУНЕНЕРГО\"');
INSERT INTO organization (edrpou,description) VALUES (3358222,'КОМУНАЛЬНЕ ПІДПРИЄМСТВО \"ЧЕРНІГІВВОДОКАНАЛ\" ЧЕРНІГІВСЬКОЇ МІСЬКОЇ РАДИ');
INSERT INTO organization (edrpou,description) VALUES (14252113,'КОМУНАЛЬНЕ ПІДПРИЄМСТВО \"ЖЕК-10\" ЧЕРНІГІВСЬКОЇ МІСЬКОЇ РАДИ');
INSERT INTO organization (edrpou,description) VALUES (14254632,'ВІДОКРЕМЛЕНИЙ ПІДРОЗДІЛ ЧЕРНІГІВСЬКІ МІСЬКІ ЕЛЕКТРИЧНІ МЕРЕЖІ ПАТ \"ЧЕРНІГІВОБЛЕНЕРГО\"');
INSERT INTO organization (edrpou,description) VALUES (21560766,'ПУБЛІЧНЕ АКЦІОНЕРНЕ ТОВАРИСТВО \"УКРТЕЛЕКОМ\"');
INSERT INTO organization (edrpou,description) VALUES (24558439,'ПРИВАТНЕ ПІДПРИЄМСТВО \"ТЕЛЕРАДІОАГЕНСТВО \"ТЕРРА\"');
INSERT INTO organization (edrpou,description) VALUES (33660167,'ТОВАРИСТВО З ОБМЕЖЕНОЮ ВІДПОВІДАЛЬНІСТЮ \"К.С - ІНВЕСТ\"');
INSERT INTO organization (edrpou,description) VALUES (39576385,'ТОВАРИСТВО З ОБМЕЖЕНОЮ ВІДПОВІДАЛЬНІСТЮ \"ЧЕРНІГІВГАЗ ЗБУТ\"');



INSERT INTO payment_account (id,mfo_bank,edrpou_organization,payment_account) VALUES (1,300023,14252113,26006000037654);
INSERT INTO payment_account (id,mfo_bank,edrpou_organization,payment_account) VALUES (2,353586,33660167,26002060341224);
INSERT INTO payment_account (id,mfo_bank,edrpou_organization,payment_account) VALUES (3,353649,24558439,2600000014234);
INSERT INTO payment_account (id,mfo_bank,edrpou_organization,payment_account) VALUES (4,353553,3358222,26004300930431);
INSERT INTO payment_account (id,mfo_bank,edrpou_organization,payment_account) VALUES (5,353553,14254632,26036324864);
INSERT INTO payment_account (id,mfo_bank,edrpou_organization,payment_account) VALUES (6,353553,39576385,26032300014749);
INSERT INTO payment_account (id,mfo_bank,edrpou_organization,payment_account) VALUES (7,353553,3357671,26036301000264);
INSERT INTO payment_account (id,mfo_bank,edrpou_organization,payment_account) VALUES (8,300346,21560766,26003010194914);
INSERT INTO payment_account (id,mfo_bank,edrpou_organization,payment_account) VALUES (9,320478,21560766,26003113058);
INSERT INTO payment_account (id,mfo_bank,edrpou_organization,payment_account) VALUES (10,320854,24558439,2600133312446);
INSERT INTO payment_account (id,mfo_bank,edrpou_organization,payment_account) VALUES (11,380805,3358222,26000704210924);



INSERT INTO role (id,role) VALUES (1,'admin');
INSERT INTO role (id,role) VALUES (2,'user');



INSERT INTO room (id,owner,guests,area) VALUES (1,'admin',1,1);



INSERT INTO users (id_room,id,login,password,balance) VALUES (1,1,'admin','admin',0);



INSERT INTO user_role (id_user,id_role) VALUES (1,1);