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
Do generacji zapytań korzystamy ze Swagger2 lub generujemy zapytania w postmanie na podstawie poniższych danych 

## Implementacja

W programie zawarte sa 2 implementcaje CarService (obie bazują na H2 gdyż moje pierwsze zadanie bazowało już na H2)<br />
Aby przełączać się między implementacjami należy ustawić odpowiedni parametr H2_STORAGE_ENABLED w pliku application.properties:
- H2_STORAGE_ENABLED=false - implementacja CarService
- H2_STORAGE_ENABLED=true - implementacja CarServiceH2

## Parametry zasobów i walidacja

Każdy zasób typu Car posiada sześć parametrów(oraz id generowane automatycznie)<br />
W nawiasach"[]" podano zasady walidacji:

- <b>maker</b> [może przyjmować tylko wartości HONDA, FIAT, SKODA]
- <b>engineCapacity</b> [liczby całkowite z przedziału 50 - 6999]
- <b>numberOfSeats</b> [ cyfry z przedziału 1 - 6]
- <b>firstRegistrationDate</b> [data w formacie yyyy-mm-dd, nie może być przed 1900-01-01 oraz po obecnym dniu]
- <b>registrationCardIssueDate</b> [data w formacie yyyy-mm-dd, nie może być przed firstRegistrationDate oraz po obecnym dniu]
- <b>registrationNumber</b> [pierwsze dwa znaki to niepowtarzające się litery + cyfry - łączna maksymalna długość to 10 znaków np. AB3456789]<br />

Przy dodawaniu nowego samochodu wszystkie parametry prócz numberOfSeats są wymagane<br />

<br/>
Każdy zasób typu Customer posiada cztery parametry(oraz id generowane automatycznie)<br />
W nawiasach"[]" podano zasady walidacji:

- <b>firstName</b> [ilość znaków od 3 do 30]
- <b>lastName</b> [ilość znaków od 3 do 30]
- <b>idCardNumber</b> [trzy pierwsze znaki to litery + 6 cyfr np. ABC123456]
- <b>peselNumber</b> [jedenaście cyfr np. 12345678901]<br />

Przy dodawaniu nowego customera wszystkie parametry są wymagane<br />

## Dane zaimplementowane w kodzie programu

W kodzie programu dodano cztery zasoby typu Car oraz cztery zasoby typu Customer<br />

Car(maker, engineCapacity, numberOfSeats, firstRegistrationDate, registrationCardIssueDate, registrationNumber):
- Maker.HONDA, 1589, 5, 1988-01-05, 1998-02-05, 2, 5), "AB1111"));
- Maker.FIAT, 900, 4, 199-02-05, 2000-03-11, "CD2222"));
- Maker.SKODA, 2000, 6, 1993-10-20, 1994-01-05, "EF3333"));
- Maker.HONDA, 2500, 2, 1998-10-05, 1998-11-01, "GH4444"));


Customer(firstName, lastName, idCardNumber, peselNumber):
- "Jan", "Kowalski", "NHW399139", "43062460106"
- "Adam", "Nowak", "KQL847332", "07240779183"
- "Zygfryd", "Kopytko", "EIS182302", "79121576859"
- "Andrzej", "Zawada", "65020522882", "EXY304697"

## Obsługa bazy samochodów (Car)

Najłatwiejszym sposobem do obsługo zapytań jest użycie interfejsu Swaggera. Interfejs ten również generuje linki zapytań które można wkleić bezpośrednio do Postmana.<br />

<b>GET:</b> <app_url>/car <br />
	zwraca wszystkie samochody w bazie danych
	
<b>GET:</b> <app_url>/car/{id} <br />
	zwraca samochód o podanym id
	
<b>POST:</b> <app_url>/car <br />
	tworzy nowy samochód w bazie danych <br />
	wszystkie parametry prócz numberOfSeats są wymagane  (maker, engineCapacity, numberOfSeats, firstRegistrationDate, registrationCardIssueDate, registrationNumber) <br />
	
<b>DELETE:</b> <app_url>/car/{id} <br />
	usunięcie samochodu o podamym id
	
<b>PUT:</b> <app_url>/car/{id} <br />
	aktualizacja danych samochodu o podanym id <br />
	można podać dowolnie wybrane parametry do zmiany, pozostałe nie ulegną zmianie, id samochodu do zmiany jest wymagane (id, maker, engineCapacity, numberOfSeats, firstRegistrationDate, registrationCardIssueDate, registrationNumber) <br />
			
## Obsługa bazy klientów (Customer)

Najłatwiejszym sposobem do obsługo zapytań jest użycie interfejsu Swaggera. Interfejs ten również generuje linki zapytań które można wkleić bezpośrednio do Postmana.<br />

<b>GET:</b> <app_url>/customer <br />
	zwraca wszystkich klientów w bazie danych
	
<b>GET:</b> <app_url>/customer/{id} <br />
	zwraca klienta o podanym id
	
<b>POST:</b> <app_url>/customer <br />
	tworzy nowego klienta w bazie danych <br />
	wymagane jest podanie wszystkich parametrów (firstName, lastName, idCardNumber, peselNumber) <br />

<b>DELETE:</b> <app_url>/customer/{id} <br />
	usunięcie klienta o podanym id
	
<b>PUT:</b> <app_url>/customer/{id} <br />
	aktualizacja danych klienta o podanym id <br />
	można podać dowolnie wybrane parametry do zmiany, pozostałe nie ulegną zmianie (firstName, lastName, idCardNumber, peselNumber) <br />
		
## Obsługa bazy klientów (Customer) - Funkcje dodatkowe:
	
<b>GET:</b> <app_url>/customer/firstName={firstName} <br />
	zwraca wszystkich klientów o tym samym parametrze firstName
	
<b>GET:</b> <app_url>/customer/lastName={lastName} <br />
	zwraca wszystkich klientów o tym samym parametrze lastName

<b>GET:</b> <app_url>/customer/idCardNumber={idCardNumber} <br />
	zwraca klienta o podanym idCardNumber

<b>GET:</b> <app_url>/customer/peselNumber={peselNumber} <br />
	zwraca klienta o podanym peselNumber

## Format odpowiedzi z serwera

Aplikacja umożliwia otrzymanie odpowiedzi w formacie <b>JSON</b> oraz <b>XML</b><br />

Aby wybrać żądany przez nas format odpowiedzi używając Swagger2 wybieramy odpowiednią wartość z listy "Response Content Type" [application/json lub application/xml]<br />

Aby wybrać format odpowiedzi xml używająć Postmana na końcu nagłówka zapytania musimy dodać .xml<br />
Standardowa odpowiedź w Postmanie bez zdefiniowanego w nagłówku typu będzie zwracała dane w formie JSON
		
## Autor

<b>Paweł Bachta</b>