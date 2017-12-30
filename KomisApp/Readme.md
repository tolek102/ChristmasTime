## Zadanie 1 - IntivePatronage2018 - KomisApp

Program do obsugi bazy danych komisu samochodowego
Możliwość przegladania, dodawania, usuwania i aktualizacji danych w bazie samochodów (Car) oraz klientów (Customer)
<app_url> = http://localhost:8080

## Parametry zasobów

Każdy zasób typu Car posiada cztery parametry:
- maker
- model
- registrationNumber
- vinNumber

Każdy zasób typu Customer posiada cztery parametry:
- firstName
- lastName
- idCardNumber
- peselNumber

## Dane zaimplementowane w kodzie programu

W kodzie programu dodano cztery zasoby typu Car oraz cztery zasoby typu Customer

Car:
"Subaru","Legacy","ZS85H55","4S3BP616556397994"
"Dodge","Caliber","ZGR02GU","1B3HB28B18D508661"
"Jeep","Patriot","ZSW1523","1J4FT28A99D140347"
"Ford","Expedition","ZP18KL","1FMRU15W61LA66899"

Customer:
"Jan", "Kowalski", "NHW399139", "43062460106"
"Adam", "Nowak", "KQL847332", "07240779183"
"Zygfryd", "Kopytko", "EIS182302", "79121576859"
"Andrzej", "Zawada", "65020522882", "EXY304697"

## Obsługa bazy samochodów (Car)

GET: <app_url>/car
	zwraca wszystkie samochody w bazie danych
	
GET: <app_url>/car/{id}
	zwraca samochód o podanym id
	
POST: <app_url>/car
	tworzy nowy samochód w bazie danych
	wymagane jest podane wszytskich parametrów (maker, model, registrationNumber, vinNumber)
	przykład: 
	<app_url>/car?maker=Subaru&model=Legacy&registrationNumber=ZS85H55&vinNumber=4S3BP616556397994
	
DELETE: <app_url>/car/{id}
	usunięcie samochodu o podamym id
	
PUT: <app_url>/car/{id}
	aktualizacja danych samochodu o podanym id
	można podać dowolnie wybrane parametry do zmiany, pozostałe nie ulegną zmianie (maker, model, registrationNumber, vinNumber)
	przykład: <app_url>/car/1?maker=Subaru&registrationNumber=ZS85H5
		w samochodzie o id = 1 zmieniony zostanie parametr maker oraz registrationNumber, pozostałe parametry pozostaną bez zmian
		
## Obsługa bazy samochodów (Car) - Funkcje dodatkowe:

GET: <app_url>/car/maker={maker}
	zwraca wszystkie samochody o tym samym parametrze maker

GET: <app_url>/car/model={model}
	zwraca wszystkie samochody o tym samym parametrze model

GET: <app_url>/car/registrationNr={registrationNumber}
	zwraca samochód o podanym registrationNumber

GET: <app_url>/car/vin={vinNumber}
	zwraca samochód o podamym vinNumber

## Obsługa bazy klientów (Customer)

GET: <app_url>/customer
	zwraca wszystkich klientów w bazie danych
	
GET: <app_url>/customer/{id}
	zwraca klienta o podanym id
	
POST: <app_url>/customer
	tworzy nowego klienta w bazie danych
	wymagane jest podanie wszystkich parametrów (firstName, lastName, idCardNumber, peselNumber)
	przykład:
	<app_url>/customer?firstName=Jan&lastName=Kowalski&idCardNumber=NHW399139&peselNumber=43062460106
	
DELETE: <app_url>/customer/{id}
	usunięcie klienta o podanym id
	
PUT: <app_url>/customer/{id}
	aktualizacja danych klienta o podanym id
	można podać dowolnie wybrane parametry do zmiany, pozostałe nie ulegną zmianie (firstName, lastName, idCardNumber, peselNumber)
	przykład:
	<app_url>/customer/1?idCardNumber=NHW399139&peselNumber=43062460106
		klientowi o id = 1 zmienione zostanie idCardNumber oraz peselNumber, pozostałe parametry pozostaną bez zmian
		
## Obsługa bazy klientów (Customer) - Funkcje dodatkowe:
	
GET: <app_url>/customer/firstName={firstName}
	zwraca wszystkich klientów o tym samym parametrze firstName
	
GET: <app_url>/customer/lastName={lastName}
	zwraca wszystkich klientów o tym samym parametrze lastName

GET: <app_url>/customer/idCardNumber={idCardNumber}
	zwraca klienta o podanym idCardNumber

GET: <app_url>/customer/peselNumber={peselNumber}
	zwraca klienta o podanym peselNumber
		
		
## Autor

Paweł Bachta