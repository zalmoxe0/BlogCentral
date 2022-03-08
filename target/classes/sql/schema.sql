
CREATE TABLE users (
                            id INTEGER AUTO_INCREMENT  PRIMARY KEY,
                            first_name VARCHAR(255) NOT NULL,
                            last_name VARCHAR(255) NOT NULL,
                            user_name VARCHAR(255) NOT NULL UNIQUE,
                            email VARCHAR(255) NOT NULL UNIQUE,
                            street VARCHAR(255),
                            house_number VARCHAR(255),
                            city VARCHAR(255),
                            zip VARCHAR(255),
                            passcode VARCHAR(255) NOT NULL,
                            role VARCHAR(255)
);

CREATE TABLE posts (
                       id INTEGER AUTO_INCREMENT  PRIMARY KEY,
                       body TEXT NOT NULL,
                       title VARCHAR(255) NOT NULL,
                       creation TIMESTAMP NOT NULL,
                       views LONG,
                       likes LONG ,
                       user_id INTEGER NOT NULL
);

CREATE TABLE comments (
                          id INTEGER AUTO_INCREMENT  PRIMARY KEY,
                          body TEXT NOT NULL,
                          title VARCHAR(255) NOT NULL,
                          user_name VARCHAR(255) NOT NULL UNIQUE,
                          creation TIMESTAMP NOT NULL,
                          user_id INTEGER NOT NULL
);