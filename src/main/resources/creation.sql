CREATE DATABASE e-kandra;

\c e-kandra

CREATE TABLE "user" (
    id SERIAL PRIMARY KEY,
    user_name VARCHAR(100),
    user_firstname VARCHAR(100),
    email VARCHAR(250) UNIQUE,
    password VARCHAR(250),
    mobile VARCHAR(20),
    skills VARCHAR(100)
);

CREATE TABLE offers (
    id SERIAL PRIMARY KEY,
    titre VARCHAR(255),
    description TEXT,
    entreprise VARCHAR(100)
    salary DECIMAL(10, 2),
    city VARCHAR(100),
    remote BOOLEAN,
    offer_domain INT REFERENCES domain(id)
);

CREATE TABLE category(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE domain (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100)
);

