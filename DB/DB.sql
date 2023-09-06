-- Create the 'role' table
DROP TABLE IF EXISTS "role" CASCADE; 
CREATE TABLE "role" (
    role_id BIGSERIAL PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL
);


-- Create the 'user' table
DROP TABLE IF EXISTS "user" CASCADE;
CREATE TABLE "user" (
    user_id BIGSERIAL PRIMARY KEY,
    user_name VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);


DROP TABLE IF EXISTS user_role ; 
CREATE TABLE user_role(
	user_id INT, 
	role_id INT,
	FOREIGN KEY(user_id) REFERENCES "user"(user_id),
	FOREIGN KEY(role_id) REFERENCES "role"(role_id)
);



-- Insert data into the 'role' table
INSERT INTO role (role_name) VALUES
    ('USER'),
    ('ADMIN');
	
-- Insert data into the 'user' table
INSERT INTO "user" (user_name, password) VALUES
    ('admin_user', 'admin_password'),
    ('moderator_user', 'moderator_password');




