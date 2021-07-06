CREATE TABLE KlinickiCentar(
id INT(0) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
naziv VARCHAR(20) not null,
adresa VARCHAR(20) not null,
spisakLekara VARCHAR(20) not null,
slobodniTermini timestamp
);

CREATE TABLE Korisnik (
id INT(0) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
email VARCHAR(20) not null,
ime VARCHAR(20) not null,
prezime VARCHAR(20) not null,
lozinka VARCHAR(20) not null,
uloga VARCHAR(20) not null,
adresa VARCHAR(20) not null,
pregled timestamp,
lbo Integer not null
);





