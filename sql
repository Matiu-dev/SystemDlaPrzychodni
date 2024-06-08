DROP TABLE IF EXISTS `uzytkownicy`;

CREATE TABLE `uzytkownik` (
  `id_uzytkownika` int NOT NULL,
  `haslo` varchar(45) NOT NULL,
  `data_rejestracji` date NOT NULL,
  `email` varchar(45) NOT NULL,
  `imie` varchar(45) NOT NULL,
  `nazwisko` varchar(45) NOT NULL,
  `pesel` int NOT NULL,
  `numer_telefonu` int NOT NULL,
  `data_urodzenia` date NOT NULL,
  `adres` varchar(45) NOT NULL,
  PRIMARY KEY (`id_uzytkownika`),
  UNIQUE KEY `pesel_UNIQUE` (`pesel`),
  UNIQUE KEY `email_UNIQUE` (`email`)
)

CREATE TABLE `pacjent` (
  `id_pacjenta` int NOT NULL,
  `id_uzytkownika` int DEFAULT NULL,
  PRIMARY KEY (`id_pacjenta`),
  KEY `id_uzytkownika` (`id_uzytkownika`),
  CONSTRAINT `pacjent_ibfk_1` FOREIGN KEY (`id_uzytkownika`) REFERENCES `uzytkownicy` (`id_uzytkownika`),
  CONSTRAINT `pacjent_ibfk_2` FOREIGN KEY (`id_uzytkownika`) REFERENCES `uzytkownicy` (`id_uzytkownika`)
)

CREATE TABLE `lekarz` (
  `id_lekarza` int NOT NULL,
  `specjalizacja` varchar(255) DEFAULT NULL,
  `id_uzytkownika` int DEFAULT NULL,
  PRIMARY KEY (`id_lekarza`),
  KEY `id_uzytkownika` (`id_uzytkownika`),
  CONSTRAINT `lekarz_ibfk_1` FOREIGN KEY (`id_uzytkownika`) REFERENCES `uzytkownicy` (`id_uzytkownika`)
)

CREATE TABLE `wizyty` (
  `id_wizyty` int NOT NULL,
  `data_utworzenia` date DEFAULT NULL,
  `historia_leczenia` varchar(255) DEFAULT NULL,
  `id_pacjenta` int DEFAULT NULL,
  `id_lekarza` int DEFAULT NULL,
  PRIMARY KEY (`id_wizyty`),
  KEY `id_pacjenta` (`id_pacjenta`),
  KEY `id_lekarza` (`id_lekarza`),
  CONSTRAINT `wizyty_ibfk_1` FOREIGN KEY (`id_pacjenta`) REFERENCES `pacjent` (`id_pacjenta`),
  CONSTRAINT `wizyty_ibfk_2` FOREIGN KEY (`id_lekarza`) REFERENCES `lekarz` (`id_lekarza`)
)

CREATE TABLE `karta_pacjenta` (
  `id_karta_pacjenta` int NOT NULL,
  `data_utworzenia` date DEFAULT NULL,
  `historia_leczenia` varchar(255) DEFAULT NULL,
  `id_pacjenta` int DEFAULT NULL,
  `id_wizyty` int DEFAULT NULL,
  PRIMARY KEY (`id_karta_pacjenta`),
  KEY `id_pacjenta` (`id_pacjenta`),
  KEY `id_wizyty` (`id_wizyty`),
  CONSTRAINT `karta_pacjenta_ibfk_1` FOREIGN KEY (`id_pacjenta`) REFERENCES `pacjent` (`id_pacjenta`),
  CONSTRAINT `karta_pacjenta_ibfk_2` FOREIGN KEY (`id_wizyty`) REFERENCES `wizyty` (`id_wizyty`)
)

CREATE TABLE `unikalne_kody_pacjentow` (
  `id_unikalne_kody` int NOT NULL,
  `unikalne_kody_pacjentow` varchar(45) DEFAULT NULL,
  `id_pacjenta` int DEFAULT NULL,
  PRIMARY KEY (`id_unikalne_kody`),
  KEY `id_pacjenta` (`id_pacjenta`),
  CONSTRAINT `unikalne_kody_pacjentow_ibfk_1` FOREIGN KEY (`id_pacjenta`) REFERENCES `pacjent` (`id_pacjenta`)
)

CREATE TABLE `recepty` (
  `id_recepty` int NOT NULL,
  `data_wystawienia` date NOT NULL,
  `dawkowanie` varchar(45) NOT NULL,
  `nazwa_leku` varchar(45) NOT NULL,
  `ilosc` int NOT NULL,
  `id_pacjenta` int DEFAULT NULL,
  `id_wizyty` int DEFAULT NULL,
  PRIMARY KEY (`id_recepty`),
  KEY `id_pacjenta` (`id_pacjenta`),
  KEY `id_wizyty` (`id_wizyty`),
  CONSTRAINT `recepty_ibfk_1` FOREIGN KEY (`id_pacjenta`) REFERENCES `pacjent` (`id_pacjenta`),
  CONSTRAINT `recepty_ibfk_2` FOREIGN KEY (`id_wizyty`) REFERENCES `wizyty` (`id_wizyty`)
)