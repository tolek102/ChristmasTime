create table carDatabase
(
    ID INTEGER not null,
    maker ENUM('HONDA', 'FIAT', 'SKODA'),
    engineCapacity INTEGER,
    numberOfSeats INTEGER,
    firstRegistrationDate DATE,
    registrationCardIssueDate DATE,
    registrationNumber VARCHAR(255),
    PRIMARY KEY (ID)
);

INSERT INTO carDatabase (ID, maker, engineCapacity, numberOfSeats, firstRegistrationDate, registrationCardIssueDate, registrationNumber)
VALUES (1, 'SKODA', 2500, 5, '1998-02-19', '1999-01-01', 'ZS1236');
INSERT INTO carDatabase (ID, maker, engineCapacity, numberOfSeats, firstRegistrationDate, registrationCardIssueDate, registrationNumber)
VALUES (2, 'HONDA', 1500, 4, '2000-11-22', '2000-12-01', 'FG562');
INSERT INTO carDatabase (ID, maker, engineCapacity, numberOfSeats, firstRegistrationDate, registrationCardIssueDate, registrationNumber)
VALUES (3, 'FIAT', 2300, 6, '2011-02-22', '2011-02-22', 'AB5622');