INSERT INTO person (nome, cognome, eta)
VALUES
  ('Mario', 'Rossi', FLOOR(RAND() * (70 - 18 + 1)) + 18),
  ('Luca', 'Bianchi', FLOOR(RAND() * (70 - 18 + 1)) + 18),
  ('Anna', 'Verdi', FLOOR(RAND() * (70 - 18 + 1)) + 18),
  ('Sara', 'Neri', FLOOR(RAND() * (70 - 18 + 1)) + 18),
  ('Giuseppe', 'Gialli', FLOOR(RAND() * (70 - 18 + 1)) + 18);

  INSERT INTO feedback (commento, user_id)
VALUES
('Ottimo lavoro!', 1),
('Molto deluso!', 2),
('Soddisfatto del servizio', 3),
('Non è quello che mi aspettavo', 4),
('Servizio eccellente!', 5);