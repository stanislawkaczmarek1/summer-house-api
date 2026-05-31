CREATE TABLE IF NOT EXISTS admins (
    id BIGSERIAL PRIMARY KEY,
    login VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS clients (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20),
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS cottages (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    capacity INT NOT NULL,
    price_per_night NUMERIC(10, 2) NOT NULL,
    address VARCHAR(255),
    latitude NUMERIC(9, 6),
    longitude NUMERIC(9, 6),
    is_visible BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS cottage_images (
    id BIGSERIAL PRIMARY KEY,
    cottage_id BIGINT NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    sort_order INT NOT NULL,
    CONSTRAINT fk_cottage_images_cottage FOREIGN KEY (cottage_id) REFERENCES cottages(id) ON DELETE CASCADE,
    CONSTRAINT uq_cottage_image_order UNIQUE (cottage_id, sort_order)
);

CREATE TABLE IF NOT EXISTS amenities (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS cottage_amenities (
    cottage_id BIGINT NOT NULL,
    amenity_id BIGINT NOT NULL,
    PRIMARY KEY (cottage_id, amenity_id),
    CONSTRAINT fk_cottage_amenities_cottage FOREIGN KEY (cottage_id) REFERENCES cottages(id) ON DELETE CASCADE,
    CONSTRAINT fk_cottage_amenities_amenity FOREIGN KEY (amenity_id) REFERENCES amenities(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS reservations (
    id BIGSERIAL PRIMARY KEY,
    cottage_id BIGINT NOT NULL,
    client_id BIGINT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    guests_count INT NOT NULL,
    total_price NUMERIC(10, 2) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    created_at TIMESTAMP NOT NULL,
    cancelled_at TIMESTAMP,
    CONSTRAINT fk_reservations_cottage FOREIGN KEY (cottage_id) REFERENCES cottages(id),
    CONSTRAINT fk_reservations_client FOREIGN KEY (client_id) REFERENCES clients(id)
);