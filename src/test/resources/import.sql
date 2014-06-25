-- SQL QUERIES TO SETUP HSQLDB FOR EMBEDDED DAO TESTS

-- Cree des utilisateurs pour les tests CRUD
INSERT INTO user(email, password, name, surname) VALUES ('romain.dauby@gmail.com', 'ngLzopB+RVaKg+Lx5Uuu3w==', 'Dauby', 'Romain');
INSERT INTO user(email, password, name, surname) VALUES ('felix.wattez@gmail.com', 'ngtototo+RVaKg+Lx5Uuu3w==', 'Wattez', 'Felix');
INSERT INTO user(email, password, name, surname) VALUES ('thomas.lorenzato@gmail.com', 'trPzopB+RVaKg+Lx5Uuu3w==', 'Lorenzato', 'Thomas');