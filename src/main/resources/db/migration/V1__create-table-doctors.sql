CREATE TABLE doctors (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    crm VARCHAR(20) NOT NULL,
    especialization VARCHAR(50) NOT NULL,

    street VARCHAR(100),
    neighborhood VARCHAR(100),
    zip_code VARCHAR(20),
    city VARCHAR(100),
    state VARCHAR(10),
    number INT,
    complement VARCHAR(100),

    PRIMARY KEY (id)
);