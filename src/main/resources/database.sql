-- Tables: users

CREATE table users(
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Tables: roles
CREATE table roles(
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(64) NOT NULL
);

-- Table mapping roles
CREATE table user_roles(
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id),

    UNIQUE (user_id, role_id)
);

-- Insert date

INSERT INTO users VALUE (1, 'Stas', '12345678');

INSERT INTO roles VALUE (1, 'ROLE_USER');
INSERT INTO roles VALUE (2, 'ROLE_ADMIN');

INSERT INTO user_roles VALUE (1,2);