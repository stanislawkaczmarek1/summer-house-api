-- Dane testowe (profil dev)

-- Admin (hasło: admin123 - zahashowane BCrypt)
INSERT INTO admins (login, password_hash, created_at)
VALUES ('admin', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', CURRENT_TIMESTAMP);

-- Udogodnienia
INSERT INTO amenities (name) VALUES ('WiFi');
INSERT INTO amenities (name) VALUES ('Parking');
INSERT INTO amenities (name) VALUES ('Basen');
INSERT INTO amenities (name) VALUES ('Grill');
INSERT INTO amenities (name) VALUES ('Klimatyzacja');
INSERT INTO amenities (name) VALUES ('Ogród');

-- Domki
INSERT INTO cottages (name, description, capacity, price_per_night, address, latitude, longitude, is_visible, created_at)
VALUES (
           'Domek Leśny',
           'Przytulny domek w sercu lasu, idealny dla rodzin.',
           6,
           250.00,
           'ul. Leśna 1, Zakopane',
           49.299,
           19.949,
           true,
           CURRENT_TIMESTAMP
       );

INSERT INTO cottages (name, description, capacity, price_per_night, address, latitude, longitude, is_visible, created_at)
VALUES (
           'Chata nad Jeziorem',
           'Dom z widokiem na jezioro.',
           4,
           320.00,
           'ul. Jeziorowa 5, Mikołajki',
           53.794,
           21.574,
           true,
           CURRENT_TIMESTAMP
       );

INSERT INTO cottages (name, description, capacity, price_per_night, address, latitude, longitude, is_visible, created_at)
VALUES (
           'Górski Azyl',
           'Domek z tarasem i widokiem na Tatry.',
           8,
           480.00,
           'ul. Tatrzańska 12, Bukowina Tatrzańska',
           49.364,
           20.084,
           true,
           CURRENT_TIMESTAMP
       );

-- Zdjęcia domków
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (1, '/images/domek-lesny-1.jpg', 1);
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (1, '/images/domek-lesny-2.jpg', 2);
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (2, '/images/chata-jeziorowa-1.jpg', 1);
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (3, '/images/gorski-azyl-1.jpg', 1);
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (3, '/images/gorski-azyl-2.jpg', 2);

-- Udogodnienia domków
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (1, 1); -- Domek Leśny: WiFi
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (1, 2); -- Domek Leśny: Parking
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (1, 4); -- Domek Leśny: Grill
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (2, 1); -- Chata: WiFi
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (2, 3); -- Chata: Basen
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (3, 1); -- Górski Azyl: WiFi
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (3, 2); -- Górski Azyl: Parking
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (3, 5); -- Górski Azyl: Klimatyzacja
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (3, 6); -- Górski Azyl: Ogród

-- Klient testowy
INSERT INTO clients (first_name, last_name, email, phone, created_at)
VALUES ('Jan', 'Kowalski', 'jan.kowalski@example.com', '500100200', CURRENT_TIMESTAMP);

-- Rezerwacja testowa
INSERT INTO reservations (cottage_id, client_id, start_date, end_date, guests_count, total_price, status, created_at)
VALUES (1, 1, '2026-07-01', '2026-07-07', 4, 1500.00, 'CONFIRMED', CURRENT_TIMESTAMP);