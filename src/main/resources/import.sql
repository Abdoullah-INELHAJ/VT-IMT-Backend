-- === Utilisateurs ===
INSERT INTO users (email, full_name, created_at) VALUES ('alice@test.com', 'Alice Dupont', CURRENT_TIMESTAMP);
INSERT INTO users (email, full_name, created_at) VALUES ('bob@test.com', 'Bob Martin', CURRENT_TIMESTAMP);
INSERT INTO users (email, full_name, created_at) VALUES ('charlie@test.com', 'Charlie Durand', CURRENT_TIMESTAMP);
INSERT INTO users (email, full_name, created_at) VALUES ('diane@test.com', 'Diane Petit', CURRENT_TIMESTAMP);

-- === Courses ===
INSERT INTO races (title, date, location, capacity, route_url, created_at) VALUES ('Course Test Passée', '2024-08-15', 'Gien', 20, 'http://maps.google.com/course1', CURRENT_TIMESTAMP);
INSERT INTO races (title, date, location, capacity, route_url, created_at) VALUES ('Course Test Lille', '2025-09-10', 'Lille', 15, 'http://maps.google.com/course2', CURRENT_TIMESTAMP);
INSERT INTO races (title, date, location, capacity, route_url, created_at) VALUES ('Course Test Paris', '2025-09-20', 'Paris', 30, 'http://maps.google.com/course3', CURRENT_TIMESTAMP);

-- === Inscriptions ===
INSERT INTO registrations (user_id, race_id, registered_at) VALUES (1, 1, CURRENT_TIMESTAMP);
INSERT INTO registrations (user_id, race_id, registered_at) VALUES (2, 1, CURRENT_TIMESTAMP);
INSERT INTO registrations (user_id, race_id, registered_at) VALUES (3, 1, CURRENT_TIMESTAMP);
INSERT INTO registrations (user_id, race_id, registered_at) VALUES (4, 1, CURRENT_TIMESTAMP);

INSERT INTO registrations (user_id, race_id, registered_at) VALUES (1, 2, CURRENT_TIMESTAMP);
INSERT INTO registrations (user_id, race_id, registered_at) VALUES (2, 2, CURRENT_TIMESTAMP);

INSERT INTO registrations (user_id, race_id, registered_at) VALUES (3, 3, CURRENT_TIMESTAMP);
INSERT INTO registrations (user_id, race_id, registered_at) VALUES (4, 3, CURRENT_TIMESTAMP);
