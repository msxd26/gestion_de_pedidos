CREATE TABLE Roles (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(50) NOT NULL UNIQUE,
                       description TEXT
);

CREATE TABLE Users (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       signup_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       total_spent DECIMAL(10, 2) DEFAULT 0.00
);

CREATE TABLE UserRoles (
                           user_id INT NOT NULL,
                           role_id INT NOT NULL,
                           PRIMARY KEY (user_id, role_id),
                           CONSTRAINT fk_userroles_user FOREIGN KEY (user_id) REFERENCES Users (id),
                           CONSTRAINT fk_userroles_role FOREIGN KEY (role_id) REFERENCES Roles (id)
);

CREATE TABLE Products (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(100) NOT NULL UNIQUE,
                          stock INT NOT NULL CHECK (stock >= 0),
                          price DECIMAL(10, 2) NOT NULL CHECK (price > 0),
                          description TEXT
);

CREATE TABLE Orders (
                        id SERIAL PRIMARY KEY,
                        user_id INT NOT NULL,
                        order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        total DECIMAL(10, 2) NOT NULL CHECK (total >= 0),
                        status VARCHAR(20) NOT NULL DEFAULT 'Pending',
                        CONSTRAINT fk_orders_user FOREIGN KEY (user_id) REFERENCES Users (id)
);

CREATE TABLE OrderDetails (
                              id SERIAL PRIMARY KEY,
                              order_id INT NOT NULL,
                              product_id INT NOT NULL,
                              quantity INT NOT NULL CHECK (quantity > 0),
                              price DECIMAL(10, 2) NOT NULL CHECK (price > 0),
                              CONSTRAINT fk_orderdetails_order FOREIGN KEY (order_id) REFERENCES Orders (id),
                              CONSTRAINT fk_orderdetails_product FOREIGN KEY (product_id) REFERENCES Products (id)
);
