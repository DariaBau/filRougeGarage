


INSERT INTO garage (nom, rue, cp, ville, tel, email, site_web)
VALUES ('Nom du Garage', 'Rue du Garage', '12345', 'Ville du Garage', '0123456789', 'email@example.com', 'www.site-web.com');
 DELETE FROM modele;
DELETE FROM marque;

INSERT INTO `marque`(id,marque) VALUES(1,'Toyota');

INSERT INTO `marque`(id,marque) VALUES(2,'BMW');

INSERT INTO `marque`(id,marque) VALUES(3,' Ford');

INSERT INTO `marque`(id,marque) VALUES(4,'Chevrolet');

INSERT INTO `marque`(id,marque) VALUES(5,'Mercedes-Benz');

INSERT INTO `marque`(id,marque) VALUES(6,'Audi');

INSERT INTO `marque`(id,marque) VALUES(7,'Nissan');

INSERT INTO `marque`(id,marque) VALUES(8,'Volkswagen');

INSERT INTO `marque`(id,marque) VALUES(9,'Hyundai');

INSERT INTO `marque`(id,marque) VALUES(10,'Honda');

DELETE FROM salaries;

INSERT INTO salaries (id,nom, prenom, mot_de_passe, email, tel, rue, cp, ville, poste, entry_date, id_garage)
VALUES (1,'Doe', 'John', 'password1', 'john.doe@example.com', '0123456789', '123 Main St', '75001', 'Paris', 'Manager', '2024-01-01', 1),
(2,'Smith', 'Jane', 'password2', 'jane.smith@example.com', '0123456780', '456 Elm St', '75002', 'Paris', 'Assistant', '2024-01-02', 1),
(3,'Johnson', 'Alice', 'password3', 'alice.johnson@example.com', '0123456781', '789 Oak St', '75003', 'Paris', 'Technician', '2024-01-03', 1),
(4,'Williams', 'Bob', 'password4', 'bob.williams@example.com', '0123456782', '101 Pine St', '75004', 'Paris', 'Engineer', '2024-01-04', 1),
(5,'Brown', 'Sarah', 'password5', 'sarah.brown@example.com', '0123456783', '111 Cedar St', '75005', 'Paris', 'Analyst', '2024-01-05', 1),
(6,'Miller', 'Mike', 'password6', 'mike.miller@example.com', '0123456784', '222 Maple St', '75006', 'Paris', 'Designer', '2024-01-06', 1);


INSERT INTO `modele` (id,modele, annee, id_marque)
VALUES
(1,'Corolla', 2022-05-15, 1),
(2,'Camry', 2023-01-20, 1),
(3,'RAV4', 2022-11-10, 1),
(4,'Prius', 2021-08-25, 1),
(5,'Highlander', 2023-04-30, 1),
(6,'Tacoma', 2022-09-05, 1),
(7,'Sienna', 2023-07-12, 1),
(8,'Avalon', 2022-12-18, 1),
(9,'4Runner', 2021-06-28, 1),
(10,'Yaris', 2023-03-15, 1);

INSERT INTO `modele` (id,modele, annee, id_marque)
VALUES
 (11,'3 Series', 2023-02-10, 2),
(12,'5 Series', 2022-10-28, 2),
(13,'X3', 2023-05-20, 2),
(14,'X5', 2022-12-03, 2),
(15,'7 Series', 2022-08-15, 2),
(16,'X1', 2023-01-25, 2),
(17,'4 Series', 2022-09-08, 2),
(18,'2 Series', 2023-04-17, 2),
 (19,'Z4', 2022-06-30, 2),
(20,'i3', 2023-07-22, 2);


INSERT INTO `modele` (id,modele, annee, id_marque)
VALUES
 (21,'F-150', 2023-11-05, 3),
(22,'Mustang', 2022-07-18, 3),
(23,'Explorer', 2023-09-10, 3),
(24,'Escape', 2022-12-30, 3),
 (25,'Fusion', 2022-05-12, 3),
 (26,'Ranger', 2023-03-08, 3),
(27,'Edge', 2022-08-25, 3),
(28,'Expedition', 2023-06-15, 3),
(29,'Focus', 2022-11-20, 3),
(30,'EcoSport', 2023-04-02, 3);

INSERT INTO `modele` (id, modele, annee, id_marque)
VALUES
(31, 'Civic',2023-02-28,10),
(32, 'Accord',2022-09-15,10),
(33, 'CR-V',2023-07-10,10),
(34, 'Pilot',2022-12-18,10),
(35,'Odyssey',2023-04-25,10),
(36,'Fit',2022-06-05,10),
(37,'HR-V',2023-01-30,10),
(38,'Ridgeline',2022-10-20,10),
(39,'Passport',2023-08-12,10),
(40,'Insight',2022-11-30,10);


INSERT INTO `modele` (id, modele, annee, id_marque)
VALUES
(41, 'Silverado',2023-06-20,4),
(42, 'Equinox',2022-12-15, 4),
(43, 'Traverse',2023-03-05,4),
(44, 'Malibu',2022-09-28,4),
(45, 'Tahoe',2023-01-10,4),
(46, 'Camaro',2022-07-22,4),
 (47,'Colorado',2023-04-18,4),
 (48,'Suburban',2022-11-08,4),
(49,'Trax',2023-07-30,4),
 (50,'Impala',2022-05-16,4);


INSERT INTO `modele` (id, modele, annee, id_marque)
VALUES
(51,'C-Class',2023-03-18,5),
(52, 'E-Class',2022-10-05,5),
(53, 'GLC',2023-06-28,5),
(54, 'GLE',2022-12-12,5),
(55, 'A- Class',2023-01-25,5),
(56,'S-Class',2022-08-20,5),
(57,'GLA',2023-05-10,5),
(58,'CLA',2022-11-30,5),
(59,'GLB',2023-04-15,5),
(60,'GLS',2022-07-08,5);


INSERT INTO `modele` (id, modele, annee, id_marque)
VALUES
(61,'A4',2023-05-15,6),
(62,'Q5',2022-11-28,6),
(63,'A3',2023-03-10,6),
(64,'Q7',2022-08-25,6),
(65,'A6',2023-01-20,6),
(66,'Q3',2022-06-12,6),
(67,'A5',2023-04-30,6),
(68,'Q8',2022-10-18,6),
(69,'RS3',2023-07-05,6),
(70,'TT',2022-12-15,6);


INSERT INTO `modele` (id, modele, annee, id_marque)
VALUES
(71,'Altima',2023-07-20,7),
(72,'Rogue',2022-12-28,7),
(73,'Sentra',2023-05-10,7),
(74,'Pathfinder',2022-10-15,7),
(75,'Versa',2023-01-30,7),
(76,'Maxima',2022-08-22,7),
(77,'Murano',2023-03-18,7),
(78,'Frontier',2022-06-10,7),
(79,'Titan',2023-04-25,7),
(80,'Armada',2022-11-08,7);


INSERT INTO `modele` (id, modele, annee, id_marque)
VALUES
(81,'Jetta',2023-04-15,8),
(82,'Passat',2022-11-30,8),
(83,'Tiguan',2023-07-25,8),
(84,'Atlas',2022-12-18,8),
(85,'Golf',2023-03-05,8),
(86,'Beetle',2022-08-28,8),
(87,'Arteon',2023-01-20,8),
(88,'ID.4',2022-06-12,8),
(89,'Touareg',2023-05-30,8),
(90,'Atlas Cross Sport',2022-10-22,8);


INSERT INTO `modele` (id, modele, annee, id_marque)
VALUES
(91, 'Elantra',2023-08-20, 9),
(92, 'Sonata',2022-05-28, 9),
(93, 'Tucson',2023-01-10, 9),
(94, 'Santa Fe',2022-07-15, 9),
(95, 'Accent',2023-03-18, 9),
(96, 'Kona',2022-10-30, 9),
(97,'Palisade',2023-06-05,9),
 (98, 'Venue',2022-12-22, 9),
(99, 'Veloster',2023-04-15, 9),
(100,'Ioniq',2022-09-08, 9);


