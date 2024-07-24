USE airport_database;

-- document_types
INSERT INTO document_types (id, documentType) VALUES (11, 'Passport');
INSERT INTO document_types (id, documentType) VALUES (12, 'ID Card');
INSERT INTO document_types (id, documentType) VALUES (13, 'Driver License');
INSERT INTO document_types (id, documentType) VALUES (14, 'Military ID');
INSERT INTO document_types (id, documentType) VALUES (15, 'Residence Permit');

-- rol
INSERT INTO rol (id, nombre) VALUES (11, 'Administrador');
INSERT INTO rol (id, nombre) VALUES (12, 'Usuario');
INSERT INTO rol (id, nombre) VALUES (13, 'Moderador');
INSERT INTO rol (id, nombre) VALUES (14, 'Desarrollador');
INSERT INTO rol (id, nombre) VALUES (15, 'Invitado');

-- user
INSERT INTO user (id, name, password, rol_id) VALUES (11, 'Juan Perez', 'password1', 11);
INSERT INTO user (id, name, password, rol_id) VALUES (12, 'Ana Lopez', 'password2', 12);
INSERT INTO user (id, name, password, rol_id) VALUES (13, 'Carlos Martinez', 'password3', 13);
INSERT INTO user (id, name, password, rol_id) VALUES (14, 'Luisa Fernandez', 'password4', 14);
INSERT INTO user (id, name, password, rol_id) VALUES (15, 'Miguel Sanchez', 'password5', 15);


-- customer
INSERT INTO customer (id, name, lastName, age, documentNumber, idDocumentType) VALUES ('11', 'Carlos', 'Gomez', 30, 123456, 11);
INSERT INTO customer (id, name, lastName, age, documentNumber, idDocumentType) VALUES ('12', 'Maria', 'Perez', 25, 654321, 12);
INSERT INTO customer (id, name, lastName, age, documentNumber, idDocumentType) VALUES ('13', 'Luis', 'Martinez', 40, 111222, 13);
INSERT INTO customer (id, name, lastName, age, documentNumber, idDocumentType) VALUES ('14', 'Ana', 'Garcia', 35, 333444, 14);
INSERT INTO customer (id, name, lastName, age, documentNumber, idDocumentType) VALUES ('15', 'Jorge', 'Lopez', 28, 555666, 15);

-- flight_fares
INSERT INTO flight_fares (id, description, details, value) VALUES ('11', 'Economy', 'Standard Economy Class', 150.00);
INSERT INTO flight_fares (id, description, details, value) VALUES ('12', 'Business', 'Business Class', 300.00);
INSERT INTO flight_fares (id, description, details, value) VALUES ('13', 'First Class', 'First Class Cabin', 500.00);
INSERT INTO flight_fares (id, description, details, value) VALUES ('14', 'Premium Economy', 'Premium Economy Class', 200.00);
INSERT INTO flight_fares (id, description, details, value) VALUES ('15', 'Basic Economy', 'Basic Economy Class', 100.00);

-- trip
INSERT INTO trip (id, tripDate, price) VALUES ('11', '2024-08-01', 150.00);
INSERT INTO trip (id, tripDate, price) VALUES ('12', '2024-08-02', 300.00);
INSERT INTO trip (id, tripDate, price) VALUES ('13', '2024-08-03', 200.00);
INSERT INTO trip (id, tripDate, price) VALUES ('14', '2024-08-04', 250.00);
INSERT INTO trip (id, tripDate, price) VALUES ('15', '2024-08-05', 400.00);

-- booking_status
INSERT INTO booking_status (id, bookingStatus) VALUES (11, 'Confirmed');
INSERT INTO booking_status (id, bookingStatus) VALUES (12, 'Pending');
INSERT INTO booking_status (id, bookingStatus) VALUES (13, 'Cancelled');
INSERT INTO booking_status (id, bookingStatus) VALUES (14, 'Checked-in');
INSERT INTO booking_status (id, bookingStatus) VALUES (15, 'Boarded');

-- trip_booking
INSERT INTO trip_booking (id, bookingDate, idTrip, idBookingStatus, idCustomer) VALUES ('11', '2024-07-01', '11', 11, '11');
INSERT INTO trip_booking (id, bookingDate, idTrip, idBookingStatus, idCustomer) VALUES ('12', '2024-07-02', '12', 12, '12');
INSERT INTO trip_booking (id, bookingDate, idTrip, idBookingStatus, idCustomer) VALUES ('13', '2024-07-03', '13', 13, '13');
INSERT INTO trip_booking (id, bookingDate, idTrip, idBookingStatus, idCustomer) VALUES ('14', '2024-07-04', '14', 14, '14');
INSERT INTO trip_booking (id, bookingDate, idTrip, idBookingStatus, idCustomer) VALUES ('15', '2024-07-05', '15', 15, '15');

-- trip_booking_details
INSERT INTO trip_booking_details (id, seatNumber, idTripBooking, idFlightFares) VALUES ('11', 1, '11', '11');
INSERT INTO trip_booking_details (id, seatNumber, idTripBooking, idFlightFares) VALUES ('12', 2, '12', '12');
INSERT INTO trip_booking_details (id, seatNumber, idTripBooking, idFlightFares) VALUES ('13', 3, '13', '13');
INSERT INTO trip_booking_details (id, seatNumber, idTripBooking, idFlightFares) VALUES ('14', 4, '14', '14');
INSERT INTO trip_booking_details (id, seatNumber, idTripBooking, idFlightFares) VALUES ('15', 5, '15', '15');

-- payment_method
INSERT INTO payment_method (id, paymentMethod) VALUES (11, 'Credit Card');
INSERT INTO payment_method (id, paymentMethod) VALUES (12, 'Debit Card');
INSERT INTO payment_method (id, paymentMethod) VALUES (13, 'PayPal');
INSERT INTO payment_method (id, paymentMethod) VALUES (14, 'Bank Transfer');
INSERT INTO payment_method (id, paymentMethod) VALUES (15, 'Cash');

-- payment
INSERT INTO payment (id, amount, paymentMethod, creditCardNumber, idTripBookingDetails) VALUES ('11', 150.00, 11, 123, '11');
INSERT INTO payment (id, amount, paymentMethod, creditCardNumber, idTripBookingDetails) VALUES ('12', 300.00, 12, 234, '12');
INSERT INTO payment (id, amount, paymentMethod, creditCardNumber, idTripBookingDetails) VALUES ('13', 200.00, 13, 567, '13');
INSERT INTO payment (id, amount, paymentMethod, creditCardNumber, idTripBookingDetails) VALUES ('14', 250.00, 14, 890, '14');
INSERT INTO payment (id, amount, paymentMethod, creditCardNumber, idTripBookingDetails) VALUES ('15', 400.00, 15, 1011, '15');

-- manufacturer
INSERT INTO manufacturer (id, manufacturer) VALUES ('11', 'Boeing');
INSERT INTO manufacturer (id, manufacturer) VALUES ('12', 'Airbus');
INSERT INTO manufacturer (id, manufacturer) VALUES ('13', 'Embraer');
INSERT INTO manufacturer (id, manufacturer) VALUES ('14', 'Bombardier');
INSERT INTO manufacturer (id, manufacturer) VALUES ('15', 'Cessna');

-- model
INSERT INTO model (id, model, idManufacturer) VALUES ('11', '737', '11');
INSERT INTO model (id, model, idManufacturer) VALUES ('12', 'A320', '12');
INSERT INTO model (id, model, idManufacturer) VALUES ('13', 'E190', '13');
INSERT INTO model (id, model, idManufacturer) VALUES ('14', 'CRJ700', '14');
INSERT INTO model (id, model, idManufacturer) VALUES ('15', 'Citation X', '15');

-- plane_status
INSERT INTO plane_status (id, status) VALUES ('11', 'Operational');
INSERT INTO plane_status (id, status) VALUES ('12', 'Maintenance');
INSERT INTO plane_status (id, status) VALUES ('13', 'Out of Service');
INSERT INTO plane_status (id, status) VALUES ('14', 'Retired');
INSERT INTO plane_status (id, status) VALUES ('15', 'In Transit');

-- airline
INSERT INTO airline (id, airline) VALUES ('11', 'Delta');
INSERT INTO airline (id, airline) VALUES ('12', 'American Airlines');
INSERT INTO airline (id, airline) VALUES ('13', 'United');
INSERT INTO airline (id, airline) VALUES ('14', 'Southwest');
INSERT INTO airline (id, airline) VALUES ('15', 'JetBlue');

-- plane
INSERT INTO plane (id, plates, capacity, fabricationDate, idModel, idStatus) VALUES ('11', 'N12345', 150, '2010-05-10', '11', '11');
INSERT INTO plane (id, plates, capacity, fabricationDate, idModel, idStatus) VALUES ('12', 'N67890', 180, '2012-03-15', '12', '12');
INSERT INTO plane (id, plates, capacity, fabricationDate, idModel, idStatus) VALUES ('13', 'N54321', 120, '2015-11-20', '13', '13');
INSERT INTO plane (id, plates, capacity, fabricationDate, idModel, idStatus) VALUES ('14', 'N09876', 200, '2018-07-25', '14', '14');
INSERT INTO plane (id, plates, capacity, fabricationDate, idModel, idStatus) VALUES ('15', 'N56789', 170, '2020-09-30', '15', '15');

-- country
INSERT INTO country (id, country) VALUES ('11', 'USA');
INSERT INTO country (id, country) VALUES ('12', 'Canada');
INSERT INTO country (id, country) VALUES ('13', 'Mexico');
INSERT INTO country (id, country) VALUES ('14', 'Brazil');
INSERT INTO country (id, country) VALUES ('15', 'Argentina');

-- city
INSERT INTO city (id, city, idCountry) VALUES ('11', 'New York', '11');
INSERT INTO city (id, city, idCountry) VALUES ('12', 'Toronto', '12');
INSERT INTO city (id, city, idCountry) VALUES ('13', 'Mexico City', '13');
INSERT INTO city (id, city, idCountry) VALUES ('14', 'Sao Paulo', '14');
INSERT INTO city (id, city, idCountry) VALUES ('15', 'Buenos Aires', '15');

-- airport
INSERT INTO airport (id, airport, idCity) VALUES ('11', 'JFK International', '11');
INSERT INTO airport (id, airport, idCity) VALUES ('12', 'Toronto Pearson', '12');
INSERT INTO airport (id, airport, idCity) VALUES ('13', 'Benito Juarez', '13');
INSERT INTO airport (id, airport, idCity) VALUES ('14', 'Guarulhos', '14');
INSERT INTO airport (id, airport, idCity) VALUES ('15', 'Ezeiza', '15');

-- gate
INSERT INTO gate (id, gate, idAirport) VALUES ('11', 'A1', '11');
INSERT INTO gate (id, gate, idAirport) VALUES ('12', 'B2', '12');
INSERT INTO gate (id, gate, idAirport) VALUES ('13', 'C3', '13');
INSERT INTO gate (id, gate, idAirport) VALUES ('14', 'D4', '14');
INSERT INTO gate (id, gate, idAirport) VALUES ('15', 'E5', '15');

-- tripulation_role
INSERT INTO tripulation_role (id, roleName) VALUES ('11', 'Pilot');
INSERT INTO tripulation_role (id, roleName) VALUES ('12', 'Co-pilot');
INSERT INTO tripulation_role (id, roleName) VALUES ('13', 'Flight Attendant');
INSERT INTO tripulation_role (id, roleName) VALUES ('14', 'Ground Staff');
INSERT INTO tripulation_role (id, roleName) VALUES ('15', 'Maintenance');

-- employee
INSERT INTO employee (id, name, lastName, ingressDate, idRole, idAirline, idAirport) VALUES ('11', 'Alice', 'Brown', '2015-01-10', '11', '11', '11');
INSERT INTO employee (id, name, lastName, ingressDate, idRole, idAirline, idAirport) VALUES ('12', 'Bob', 'Smith', '2016-02-20', '12', '12', '12');
INSERT INTO employee (id, name, lastName, ingressDate, idRole, idAirline, idAirport) VALUES ('13', 'Charlie', 'Johnson', '2017-03-30', '13', '13', '13');
INSERT INTO employee (id, name, lastName, ingressDate, idRole, idAirline, idAirport) VALUES ('14', 'Daisy', 'Williams', '2018-04-10', '14', '14', '14');
INSERT INTO employee (id, name, lastName, ingressDate, idRole, idAirline, idAirport) VALUES ('15', 'Eve', 'Jones', '2019-05-20', '15', '15', '15');

-- flight_connection
INSERT INTO flight_connection (id, connectionOrder, idTrip, idPlane, idAirportA, idAirportB) VALUES ('11', 1, '11', '11', '11', '12');
INSERT INTO flight_connection (id, connectionOrder, idTrip, idPlane, idAirportA, idAirportB) VALUES ('12', 2, '12', '12', '12', '13');
INSERT INTO flight_connection (id, connectionOrder, idTrip, idPlane, idAirportA, idAirportB) VALUES ('13', 3, '13', '13', '13', '14');
INSERT INTO flight_connection (id, connectionOrder, idTrip, idPlane, idAirportA, idAirportB) VALUES ('14', 4, '14', '14', '14', '15');
INSERT INTO flight_connection (id, connectionOrder, idTrip, idPlane, idAirportA, idAirportB) VALUES ('15', 5, '15', '15', '15', '11');

-- trip_crews
INSERT INTO trip_crews (id, idEmployee, idConnection) VALUES ('11', '11', '11');
INSERT INTO trip_crews (id, idEmployee, idConnection) VALUES ('12', '12', '12');
INSERT INTO trip_crews (id, idEmployee, idConnection) VALUES ('13', '13', '13');
INSERT INTO trip_crews (id, idEmployee, idConnection) VALUES ('14', '14', '14');
INSERT INTO trip_crews (id, idEmployee, idConnection) VALUES ('15', '15', '15');

-- revision_details
INSERT INTO revision_details (id, description, idEmployee) VALUES ('11', 'Engine check', '11');
INSERT INTO revision_details (id, description, idEmployee) VALUES ('12', 'Fuel system check', '12');
INSERT INTO revision_details (id, description, idEmployee) VALUES ('13', 'Navigation system check', '13');
INSERT INTO revision_details (id, description, idEmployee) VALUES ('14', 'Hydraulic system check', '14');
INSERT INTO revision_details (id, description, idEmployee) VALUES ('15', 'Electrical system check', '15');

-- revision
INSERT INTO revision (id, revisionDate, idPlane, idDetails) VALUES ('11', '2024-07-01', '11', '11');
INSERT INTO revision (id, revisionDate, idPlane, idDetails) VALUES ('12', '2024-07-02', '12', '12');
INSERT INTO revision (id, revisionDate, idPlane, idDetails) VALUES ('13', '2024-07-03', '13', '13');
INSERT INTO revision (id, revisionDate, idPlane, idDetails) VALUES ('14', '2024-07-04', '14', '14');
INSERT INTO revision (id, revisionDate, idPlane, idDetails) VALUES ('15', '2024-07-05', '15', '15');

-- revision_employee
INSERT INTO revision_employee (id, idEmployee, idRevision) VALUES ('11', '11', '11');
INSERT INTO revision_employee (id, idEmployee, idRevision) VALUES ('12', '12', '12');
INSERT INTO revision_employee (id, idEmployee, idRevision) VALUES ('13', '13', '13');
INSERT INTO revision_employee (id, idEmployee, idRevision) VALUES ('14', '14', '14');
INSERT INTO revision_employee (id, idEmployee, idRevision) VALUES ('15', '15', '15');
