DROP TABLE IF EXISTS users_blog;
CREATE TABLE users_blog (
                               id INTEGER AUTO_INCREMENT  PRIMARY KEY,
                               first_name VARCHAR(250) NOT NULL,
                               last_name VARCHAR(250) NOT NULL,
                               user_name VARCHAR(250) NOT NULL UNIQUE,
                               email VARCHAR(250) NOT NULL UNIQUE,
                               street VARCHAR(250),
                               house_number VARCHAR(250),
                               city VARCHAR(250),
                               zip VARCHAR(250),
                               passcode VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS admin_blog;
CREATE TABLE admin_blog (
                             admin_id INTEGER AUTO_INCREMENT  PRIMARY KEY,
                             user_name VARCHAR(250) NOT NULL UNIQUE,
                             email VARCHAR(250) NOT NULL UNIQUE,
                             passcode VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS blog_posts;
CREATE TABLE blog_posts (
                             blog_id INTEGER AUTO_INCREMENT  PRIMARY KEY,
                             body TEXT NOT NULL,
                             title VARCHAR(255) NOT NULL,
                             creation_date TIMESTAMP NOT NULL,
                             user_id INTEGER NOT NULL
);

DROP TABLE IF EXISTS blog_comments;
CREATE TABLE blog_comments (
                           comment_id INTEGER AUTO_INCREMENT  PRIMARY KEY,
                           body TEXT NOT NULL,
                           title VARCHAR(255) NOT NULL,
                           creation_date TIMESTAMP NOT NULL,
                           user_id INTEGER NOT NULL
);