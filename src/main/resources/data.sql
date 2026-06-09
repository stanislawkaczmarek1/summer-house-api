-- ============================================================
-- Test data (dev profile) — extended
-- ============================================================

-- Admin (password: admin123)
INSERT INTO admins (login, password_hash, created_at)
VALUES ('admin', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', CURRENT_TIMESTAMP);

-- ============================================================
-- Amenities
-- ============================================================
INSERT INTO amenities (name) VALUES ('WiFi');
INSERT INTO amenities (name) VALUES ('Parking');
INSERT INTO amenities (name) VALUES ('Swimming pool');
INSERT INTO amenities (name) VALUES ('BBQ grill');
INSERT INTO amenities (name) VALUES ('Air conditioning');
INSERT INTO amenities (name) VALUES ('Garden');
INSERT INTO amenities (name) VALUES ('Sauna');
INSERT INTO amenities (name) VALUES ('Fireplace');
INSERT INTO amenities (name) VALUES ('Pet friendly');
INSERT INTO amenities (name) VALUES ('Bicycles');

-- ============================================================
-- Cottages (10 items)
-- ============================================================

-- 1. Forest Cabin (Zakopane)
INSERT INTO cottages (name, description, capacity, price_per_night, address, latitude, longitude, is_visible, created_at)
VALUES (
           'Forest Cabin',
           'A cozy cabin in the heart of the forest, perfect for families with children. Surrounded by old pine trees, with a large terrace and a bonfire area. Close to hiking trails.',
           6, 250.00, 'Leśna 1 St, Zakopane', 49.299, 19.949, true, CURRENT_TIMESTAMP
       );

-- 2. Lake House (Mikołajki)
INSERT INTO cottages (name, description, capacity, price_per_night, address, latitude, longitude, is_visible, created_at)
VALUES (
           'Lake House',
           'A unique house with a private pier and a view of Lake Śniardwy. Perfect for relaxation, fishing, and kayaking. Kayaks and pedal boats available.',
           4, 320.00, 'Jeziorowa 5 St, Mikołajki', 53.794, 21.574, true, CURRENT_TIMESTAMP
       );

-- 3. Mountain Retreat (Bukowina Tatrzańska)
INSERT INTO cottages (name, description, capacity, price_per_night, address, latitude, longitude, is_visible, created_at)
VALUES (
           'Mountain Retreat',
           'A luxury cabin with a panoramic terrace overlooking the Tatra Mountains. Equipped with a Finnish sauna, fireplace, and jacuzzi. Ideal for romantic or active mountain getaways.',
           8, 480.00, 'Tatrzańska 12 St, Bukowina Tatrzańska', 49.364, 20.084, true, CURRENT_TIMESTAMP
       );

-- 4. Seaside Villa (Sopot)
INSERT INTO cottages (name, description, capacity, price_per_night, address, latitude, longitude, is_visible, created_at)
VALUES (
           'Seaside Villa',
           'An elegant villa 200 meters from the beach in Sopot. Spacious garden, sea-view terrace, modern interior. Walking distance to the pier in 10 minutes.',
           10, 650.00, 'Plażowa 8 St, Sopot', 54.441, 18.560, true, CURRENT_TIMESTAMP
       );

-- 5. Lake Serenity (Giżycko)
INSERT INTO cottages (name, description, capacity, price_per_night, address, latitude, longitude, is_visible, created_at)
VALUES (
           'Lake Serenity',
           'A cozy cabin in Masuria with a private dock on Lake Niegocin. Silence, nature, and the scent of pine forest. Nearby marina and water equipment rental.',
           4, 280.00, 'Spokojna 3 St, Giżycko', 54.037, 21.762, true, CURRENT_TIMESTAMP
       );

-- 6. Bieszczady Escape (Ustrzyki Dolne)
INSERT INTO cottages (name, description, capacity, price_per_night, address, latitude, longitude, is_visible, created_at)
VALUES (
           'Bieszczady Escape',
           'A traditional mountain hut with a stone fireplace and wooden beams. Perfect base for hiking in the Bieszczady Mountains. Truly the end of the world.',
           6, 220.00, 'Przełęcz Wyżna 2 St, Ustrzyki Dolne', 49.433, 22.583, true, CURRENT_TIMESTAMP
       );

-- 7. Kashubian Cottage (Chmielno)
INSERT INTO cottages (name, description, capacity, price_per_night, address, latitude, longitude, is_visible, created_at)
VALUES (
           'Kashubian Cottage',
           'A charming cottage in the heart of Kashubia near Lake Raduńskie. Large garden with hammocks, BBQ, bonfire area. Bikes available for guests.',
           5, 240.00, 'Raduńska 14 St, Chmielno', 54.210, 17.985, true, CURRENT_TIMESTAMP
       );

-- 8. Highland Hut (Nowy Targ) — HIDDEN
INSERT INTO cottages (name, description, capacity, price_per_night, address, latitude, longitude, is_visible, created_at)
VALUES (
           'Highland Hut',
           'Authentic highlander hut under renovation. Coming soon.',
           4, 180.00, 'Górska 7 St, Nowy Targ', 49.477, 20.031, false, CURRENT_TIMESTAMP
       );

-- 9. Forest Clearing Cabin (Augustów)
INSERT INTO cottages (name, description, capacity, price_per_night, address, latitude, longitude, is_visible, created_at)
VALUES (
           'Forest Clearing Cabin',
           'A cabin in the Augustów Forest on the edge of a clearing. Escape from civilization — no TV, pure silence, and birds singing.',
           3, 190.00, 'Leśna Polana 1, Augustów', 53.844, 22.979, true, CURRENT_TIMESTAMP
       );

-- 10. Panorama Lodge (Karpacz)
INSERT INTO cottages (name, description, capacity, price_per_night, address, latitude, longitude, is_visible, created_at)
VALUES (
           'Panorama Lodge',
           'Modern cabin with panoramic windows overlooking the Karkonosze Mountains. Minimalist design, sauna, heated floors. For design and mountain lovers.',
           6, 420.00, 'Karkonoska 3 St, Karpacz', 50.779, 15.740, true, CURRENT_TIMESTAMP
       );

-- ============================================================
-- Zdjęcia domków (Unsplash — ujednolicone URL-e)
-- ============================================================

-- 1. Domek Leśny
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (1, 'https://plus.unsplash.com/premium_photo-1686090450488-48ce19426bbe?w=1600&h=900&fit=crop', 1);
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (1, 'https://plus.unsplash.com/premium_photo-1686090450488-48ce19426bbe?w=1600&h=900&fit=crop', 2);
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (1, 'https://plus.unsplash.com/premium_photo-1686090450488-48ce19426bbe?w=1600&h=900&fit=crop', 3);

-- 2. Chata nad Jeziorem
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (2, 'https://plus.unsplash.com/premium_photo-1686090450488-48ce19426bbe?w=1600&h=900&fit=crop', 1);
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (2, 'https://plus.unsplash.com/premium_photo-1686090450488-48ce19426bbe?w=1600&h=900&fit=crop', 2);

-- 3. Górski Azyl
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (3, 'https://plus.unsplash.com/premium_photo-1686090450488-48ce19426bbe?w=1600&h=900&fit=crop', 1);
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (3, 'https://plus.unsplash.com/premium_photo-1686090450488-48ce19426bbe?w=1600&h=900&fit=crop', 2);
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (3, 'https://plus.unsplash.com/premium_photo-1686090450488-48ce19426bbe?w=1600&h=900&fit=crop', 3);

-- 4. Nadmorska Willa
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (4, 'https://plus.unsplash.com/premium_photo-1686090450488-48ce19426bbe?w=1600&h=900&fit=crop', 1);
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (4, 'https://plus.unsplash.com/premium_photo-1686090450488-48ce19426bbe?w=1600&h=900&fit=crop', 2);

-- 5. Mazurska Cisza
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (5, 'https://plus.unsplash.com/premium_photo-1686090450488-48ce19426bbe?w=1600&h=900&fit=crop', 1);
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (5, 'https://plus.unsplash.com/premium_photo-1686090450488-48ce19426bbe?w=1600&h=900&fit=crop', 2);

-- 6. Bieszczadzka Ostoja
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (6, 'https://plus.unsplash.com/premium_photo-1686090450488-48ce19426bbe?w=1600&h=900&fit=crop', 1);
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (6, 'https://plus.unsplash.com/premium_photo-1686090450488-48ce19426bbe?w=1600&h=900&fit=crop', 2);

-- 7. Domek na Kaszubach
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (7, 'https://plus.unsplash.com/premium_photo-1686090450488-48ce19426bbe?w=1600&h=900&fit=crop', 1);
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (7, 'https://plus.unsplash.com/premium_photo-1686090450488-48ce19426bbe?w=1600&h=900&fit=crop', 2);

-- 8. Podhalańska Chałupa (ukryta — brak zdjęć celowo)

-- 9. Leśna Polana
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (9, 'https://plus.unsplash.com/premium_photo-1686090450488-48ce19426bbe?w=1600&h=900&fit=crop', 1);

-- 10. Wielka Panorama
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (10, 'https://plus.unsplash.com/premium_photo-1686090450488-48ce19426bbe?w=1600&h=900&fit=crop', 1);
INSERT INTO cottage_images (cottage_id, image_url, sort_order) VALUES (10, 'https://plus.unsplash.com/premium_photo-1686090450488-48ce19426bbe?w=1600&h=900&fit=crop', 2);
-- ============================================================
-- Udogodnienia domków
-- ============================================================

-- 1. Domek Leśny
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (1, 1); -- WiFi
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (1, 2); -- Parking
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (1, 4); -- Grill
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (1, 8); -- Kominek
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (1, 9); -- Zwierzęta

-- 2. Chata nad Jeziorem
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (2, 1); -- WiFi
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (2, 3); -- Basen
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (2, 2); -- Parking
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (2, 10);-- Rowerki

-- 3. Górski Azyl
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (3, 1); -- WiFi
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (3, 2); -- Parking
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (3, 5); -- Klimatyzacja
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (3, 6); -- Ogród
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (3, 7); -- Sauna
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (3, 8); -- Kominek

-- 4. Nadmorska Willa
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (4, 1); -- WiFi
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (4, 2); -- Parking
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (4, 3); -- Basen
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (4, 5); -- Klimatyzacja
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (4, 6); -- Ogród
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (4, 4); -- Grill

-- 5. Mazurska Cisza
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (5, 1); -- WiFi
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (5, 2); -- Parking
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (5, 10);-- Rowerki
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (5, 9); -- Zwierzęta

-- 6. Bieszczadzka Ostoja
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (6, 2); -- Parking
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (6, 4); -- Grill
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (6, 8); -- Kominek
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (6, 9); -- Zwierzęta

-- 7. Domek na Kaszubach
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (7, 1); -- WiFi
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (7, 2); -- Parking
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (7, 4); -- Grill
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (7, 6); -- Ogród
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (7, 10);-- Rowerki

-- 9. Leśna Polana
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (9, 2); -- Parking
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (9, 9); -- Zwierzęta

-- 10. Wielka Panorama
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (10, 1); -- WiFi
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (10, 2); -- Parking
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (10, 5); -- Klimatyzacja
INSERT INTO cottage_amenities (cottage_id, amenity_id) VALUES (10, 7); -- Sauna

-- ============================================================
-- Klienci testowi
-- ============================================================
INSERT INTO clients (first_name, last_name, email, phone, created_at)
VALUES ('Jan',     'Kowalski',  'jan.kowalski@example.com',  '500100200', CURRENT_TIMESTAMP);

INSERT INTO clients (first_name, last_name, email, phone, created_at)
VALUES ('Anna',    'Nowak',     'anna.nowak@example.com',    '600200300', CURRENT_TIMESTAMP);

INSERT INTO clients (first_name, last_name, email, phone, created_at)
VALUES ('Piotr',   'Wiśniewski','piotr.w@example.com',       '700300400', CURRENT_TIMESTAMP);

INSERT INTO clients (first_name, last_name, email, phone, created_at)
VALUES ('Marta',   'Wójcik',    'marta.wojcik@example.com',  '510400500', CURRENT_TIMESTAMP);

INSERT INTO clients (first_name, last_name, email, phone, created_at)
VALUES ('Tomasz',  'Kamiński',  'tomasz.k@example.com',      '660500600', CURRENT_TIMESTAMP);

-- ============================================================
-- Rezerwacje testowe (mix statusów)
-- ============================================================

-- CONFIRMED
INSERT INTO reservations (cottage_id, client_id, start_date, end_date, guests_count, total_price, status, created_at)
VALUES (1, 1, '2026-07-01', '2026-07-07', 4, 1500.00, 'CONFIRMED', CURRENT_TIMESTAMP);

INSERT INTO reservations (cottage_id, client_id, start_date, end_date, guests_count, total_price, status, created_at)
VALUES (3, 2, '2026-07-10', '2026-07-17', 6, 3360.00, 'CONFIRMED', CURRENT_TIMESTAMP);

INSERT INTO reservations (cottage_id, client_id, start_date, end_date, guests_count, total_price, status, created_at)
VALUES (4, 3, '2026-08-01', '2026-08-08', 8, 4550.00, 'CONFIRMED', CURRENT_TIMESTAMP);

-- PENDING
INSERT INTO reservations (cottage_id, client_id, start_date, end_date, guests_count, total_price, status, created_at)
VALUES (2, 4, '2026-07-20', '2026-07-25', 3, 1600.00, 'PENDING', CURRENT_TIMESTAMP);

INSERT INTO reservations (cottage_id, client_id, start_date, end_date, guests_count, total_price, status, created_at)
VALUES (5, 5, '2026-08-05', '2026-08-10', 4, 1400.00, 'PENDING', CURRENT_TIMESTAMP);

INSERT INTO reservations (cottage_id, client_id, start_date, end_date, guests_count, total_price, status, created_at)
VALUES (10, 1, '2026-09-01', '2026-09-05', 2, 1680.00, 'PENDING', CURRENT_TIMESTAMP);

-- CANCELLED
INSERT INTO reservations (cottage_id, client_id, start_date, end_date, guests_count, total_price, status, created_at, cancelled_at)
VALUES (1, 2, '2026-06-01', '2026-06-05', 2, 1000.00, 'CANCELLED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO reservations (cottage_id, client_id, start_date, end_date, guests_count, total_price, status, created_at, cancelled_at)
VALUES (6, 3, '2026-06-15', '2026-06-20', 4, 1100.00, 'CANCELLED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);