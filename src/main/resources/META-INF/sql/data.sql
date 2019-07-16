
INSERT INTO organizer(email, name, surname, password) VALUES('test@wp.pl', 'Jan', 'Kowalski', '123');
INSERT INTO organizer(email, name, surname, password) VALUES('test2@wp.pl', 'Maria', 'Dibi', '123');
INSERT INTO organizer(email, name, surname, password) VALUES('test3@wp.pl', 'Jason', 'Krol', '123');

INSERT INTO event (type, date, description, howManyGuests, name, place, typeOfEvent, typeOfDance,typeOfDress, organizer_id) VALUES ('dance', '2000-03-02','opis', 15, 'Wydarzenie 1', 'Plac Wojciecha', 'dance', 'szybki', 'ladny', 1);

INSERT INTO event (type, date, description, howManyGuests, name, place, typeOfEvent, band, organizer_id) VALUES ('concert','2000-03-02','opis', 15, 'Wydarzenie 2', 'Plac Kanara', 'concert', 'zespol', 2);

INSERT INTO event (type, date, description, howManyGuests, name, place, typeOfEvent, topic, organizer_id) VALUES ('meeting','2000-03-02','opis', 15, 'Wydarzenie 3', 'Plac Juana', 'meeting', 'temat rozmowy', 3);