--DROP TABLE Clients cascade constraints ;
--DROP TABLE Voyages cascade constraints ;
--DROP TABLE TourOperators cascade constraints ;
--DROP TABLE Commandes cascade constraints ;
--DROP TABLE Options cascade constraints ;
--DROP TABLE Passagers cascade constraints ;

CREATE TABLE Clients (
	idClient VARCHAR(5),
	nomC VARCHAR(15),
	prenomC VARCHAR(15),
	adrC VARCHAR(50),
	villeC VARCHAR(20),
	codePostalC INT(5),
	telC VARCHAR(12),
	
	CONSTRAINT pk_domaine PRIMARY KEY(idClient)
);
	
create table Voyages (
	idRef VARCHAR(10),
	destination VARCHAR(3),		-- code de l'aeroport d'arrivé ( code international IATA )
	
	CONSTRAINT pk_voyage PRIMARY KEY(idRef)
);

create table TourOperator (
	idTo VARCHAR(5),
	nomTo VARCHAR(20),
	
	CONSTRAINT pk_TourOperator PRIMARY KEY(idTo)
);

create table Commandes (
	idPassager VARCHAR(5),
	idClient VARCHAR(5),
	idRef VARCHAR(10),
	prix INT,
	dateDep  DATE,
	villeDep VARCHAR(20),
	villeArrive VARCHAR(20),
	accompte INT,
	etat VARCHAR(20),
	nbPassager INT,
	
	CONSTRAINT pk_Commande PRIMARY KEY(idPassager,idClient,idRef),
	CONSTRAINT fk_Commande_idCli FOREIGN KEY(idClient) REFERENCES Clients(idClient),
	CONSTRAINT fk_Commande_idPas FOREIGN KEY(idPassager) REFERENCES Passagers(idPassager),
	CONSTRAINT fk_Commande_idVoy FOREIGN KEY(idRef) REFERENCES Voayages(idRef)
);

create table Options (
	idPassager VARCHAR(5),
	idClient VARCHAR(5),
	idRef VARCHAR(10),
	intitule VARCHAR(10),
	prix INT,
		
	CONSTRAINT pk_Option PRIMARY KEY(idPassager,idClient,idRef),
	CONSTRAINT fk_Option_idCom FOREIGN KEY(idPassager,idClient,idRef) REFERENCES Commandes(idPassager,idClient,idRef),
	CONSTRAINT fk_Option_idVoy FOREIGN KEY(idRef) REFERENCES Voyages(idRef)
);

create table Passagers (
	idPassager VARCHAR(5),
	nomP VARCHAR(15),
	prenomP VARCHAR(15),
	
	CONSTRAINT pk_Passager PRIMARY KEY(idPassager)
);