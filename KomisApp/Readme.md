## IntivePatronage2018 - KomisApp

Program do obsugi bazy danych komisu samochodowego <br />
Możliwość przegladania, dodawania, usuwania i aktualizacji danych w bazie samochodów (Car) oraz klientów (Customer)<br />
<app_url> = http://localhost:8080<br />

Link do dokumentacji Swagger: http://localhost:8080/swagger-ui.html<br />

Link do konsoli bazy danych H2: http://localhost:8080/h2-console<br />
Jako H2 JBDC URL należy podać:  jdbc:h2:mem:testdb

## Uruchomienie

Do uruchomienia wymagane są:
- Java
- Maven
- InteliJ Community edition
- Postman

Kroki: <br />
W InteliJ importujemy projekt <br />
wykonujemy polecenia: 
- mvn clean install <br />

Wybieramy Run -> Run KomisAppAplication <br />
W postmanie generujemy zapytania na podstawie poniższych danych

##Implementacja

W programie zawarte sa 2 implementcaje (obie bazują na H2 gdyż moje pierwsze zadanie bazowało już na H2)<br />
Aby przełączać się między implementacjami należy ustawić odpowiedni parametr H2_STORAGE_ENABLED w pliku application.properties:
- H2_STORAGE_ENABLED=false - implementacja CarService
- H2_STORAGE_ENABLED=true - implementacja CarServiceH2

## Parametry zasobów

Każdy zasób typu Car posiada sześć parametrów(oraz id generowane automatycznie):

- maker
- engineCapacity
- numberOfSeats
- firstRegistrationDate
- registrationCardIssueDate
- registrationNumber<br />
Przy dodawaniu nowego samochodu wszystkie parametry prócz numberOfSeats są wymagane

Każdy zasób typu Customer posiada cztery parametry(oraz id generowane automatycznie):
- firstName
- lastName
- idCardNumber
- peselNumber

## Dane zaimplementowane w kodzie programu

W kodzie programu dodano cztery zasoby typu Car oraz cztery zasoby typu Customer<br />

Car:
- Maker.HONDA, 1589, 5, new Date(98, 1, 5), new Date(98, 2, 5), "AB1111"));
- Maker.FIAT, 900, 4, new Date(99, 2, 5), new Date(100, 3, 11), "CD2222"));
- Maker.SKODA, 2000, 6, new Date(93, 10, 20), new Date(94, 1, 5), "EF3333"));
- Maker.HONDA, 2500, 2, new Date(98, 10, 5), new Date(98, 11, 1), "GH4444"));


Customer:
- "Jan", "Kowalski", "NHW399139", "43062460106"
- "Adam", "Nowak", "KQL847332", "07240779183"
- "Zygfryd", "Kopytko", "EIS182302", "79121576859"
- "Andrzej", "Zawada", "65020522882", "EXY304697"

## Obsługa bazy samochodów (Car)

Najłatwiejszym sposobem do obsługo zapytań jest użycie interfejsu Swaggera. Interfejs ten również generuje linki zapytań które można wklepić bezpośrednio do Postmana.

GET: <app_url>/car <br />
	zwraca wszystkie samochody w bazie danych
	
GET: <app_url>/car/{id} <br />
	zwraca samochód o podanym id
	
POST: <app_url>/car <br />
	tworzy nowy samochód w bazie danych <br />
	wszystkie parametry prócz numberOfSeats są wymagane  (maker, engineCapacity, numberOfSeats, firstRegistrationDate, registrationCardIssueDate, registrationNumber) <br />
	
DELETE: <app_url>/car/{id} <br />
	usunięcie samochodu o podamym id
	
PUT: <app_url>/car/{id} <br />
	aktualizacja danych samochodu o podanym id <br />
	można podać dowolnie wybrane parametry do zmiany, pozostałe nie ulegną zmianie, id samochodu do zmiany jest wymagane (id, maker, engineCapacity, numberOfSeats, firstRegistrationDate, registrationCardIssueDate, registrationNumber) <br />
			
## Obsługa bazy klientów (Customer)

GET: <app_url>/customer <br />
	zwraca wszystkich klientów w bazie danych
	
GET: <app_url>/customer/{id} <br />
	zwraca klienta o podanym id
	
POST: <app_url>/customer <br />
	tworzy nowego klienta w bazie danych <br />
	wymagane jest podanie wszystkich parametrów (firstName, lastName, idCardNumber, peselNumber) <br />
	przykład: <br />
	<app_url>/customer?firstName=Jan&lastName=Kowalski&idCardNumber=NHW399139&peselNumber=43062460106
	
DELETE: <app_url>/customer/{id} <br />
	usunięcie klienta o podanym id
	
PUT: <app_url>/customer/{id} <br />
	aktualizacja danych klienta o podanym id <br />
	można podać dowolnie wybrane parametry do zmiany, pozostałe nie ulegną zmianie (firstName, lastName, idCardNumber, peselNumber) <br />
	przykład: <br />
	<app_url>/customer/1?idCardNumber=NHW399139&peselNumber=43062460106 <br />
		klientowi o id = 1 zmienione zostanie idCardNumber oraz peselNumber, pozostałe parametry pozostaną bez zmian
		
## Obsługa bazy klientów (Customer) - Funkcje dodatkowe:
	
GET: <app_url>/customer/firstName={firstName} <br />
	zwraca wszystkich klientów o tym samym parametrze firstName
	
GET: <app_url>/customer/lastName={lastName} <br />
	zwraca wszystkich klientów o tym samym parametrze lastName

GET: <app_url>/customer/idCardNumber={idCardNumber} <br />
	zwraca klienta o podanym idCardNumber

GET: <app_url>/customer/peselNumber={peselNumber} <br />
	zwraca klienta o podanym peselNumber
		
		
## Autor

Paweł Bachta