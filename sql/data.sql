-- INSERTAR ROLES
INSERT INTO Roles (name, description)
VALUES ('Admin', 'Administrador con todos los privilegios'),
       ('Seller', 'Vendedor que gestiona productos y ventas'),
       ('Customer', 'Cliente que realiza pedidos');

-- INSERTAR USUARIOS
INSERT INTO Users (name, email, password, role_id)
VALUES ('Juan Pérez', 'juanperez@example.com', 'hash1', 1),
       ('Laura Gómez', 'lauragomez@example.com', 'hash2', 2),
       ('Carlos Ruiz', 'carlosruiz@example.com', 'hash3', 3),
       ('Ana Torres', 'anatorres@example.com', 'hash4', 3),
       ('Mario Vargas', 'mariovargas@example.com', 'hash5', 3),
       ('Lucía Ramírez', 'luciaramirez@example.com', 'hash6', 3),
       ('Pedro Álvarez', 'pedroalvarez@example.com', 'hash7', 3),
       ('Sofía Rojas', 'sofiarojas@example.com', 'hash8', 3),
       ('Diego Castro', 'diegocastro@example.com', 'hash9', 3),
       ('Valeria Medina', 'valeriamedina@example.com', 'hash10', 3);

-- INSERTAR PRODUCTOS
INSERT INTO Products (name, stock, price, description)
VALUES ('Laptop HP Pavilion', 15, 850.00, 'Laptop de alto rendimiento para estudiantes'),
       ('Tablet Samsung Galaxy', 20, 320.50, 'Tablet ligera con pantalla AMOLED'),
       ('Impresora Epson EcoTank', 8, 199.99, 'Impresora multifunción sin cartuchos'),
       ('Monitor LG 24"', 12, 180.75, 'Monitor Full HD con tecnología IPS'),
       ('Mouse Gamer Redragon', 40, 35.90, 'Mouse con luces RGB y DPI ajustable'),
       ('Teclado Logitech K380', 30, 45.00, 'Teclado Bluetooth multi-dispositivo'),
       ('Disco SSD Kingston 480GB', 25, 75.00, 'Disco sólido para acelerar tu equipo'),
       ('Auriculares Sony WH-CH510', 22, 59.99, 'Auriculares Bluetooth de calidad'),
       ('Webcam Logitech C920', 10, 110.00, 'Cámara HD para videollamadas'),
       ('Silla Gamer Cougar', 5, 250.00, 'Silla ergonómica para largas sesiones');

-- INSERTAR ÓRDENES
INSERT INTO Orders (user_id, status)
VALUES (3, 'Pending'),
       (4, 'Completed'),
       (5, 'Pending'),
       (6, 'Completed'),
       (7, 'Pending'),
       (8, 'Pending'),
       (9, 'Completed'),
       (10, 'Completed'),
       (3, 'Pending'),
       (5, 'Completed');

-- INSERTAR DETALLES DE ORDEN (50+ REGISTROS)
INSERT INTO OrderDetails (order_id, product_id, quantity, price)
VALUES (1, 1, 1, 850.00),
       (1, 5, 2, 35.90),
       (1, 7, 1, 75.00),

       (2, 2, 1, 320.50),
       (2, 6, 1, 45.00),
       (2, 10, 1, 250.00),

       (3, 4, 2, 180.75),
       (3, 3, 1, 199.99),

       (4, 8, 2, 59.99),
       (4, 9, 1, 110.00),

       (5, 5, 1, 35.90),
       (5, 1, 1, 850.00),
       (5, 2, 2, 320.50),

       (6, 3, 1, 199.99),
       (6, 6, 2, 45.00),
       (6, 9, 1, 110.00),

       (7, 4, 1, 180.75),
       (7, 7, 2, 75.00),

       (8, 8, 1, 59.99),
       (8, 5, 2, 35.90),

       (9, 10, 1, 250.00),
       (9, 1, 1, 850.00),
       (9, 2, 1, 320.50),

       (10, 6, 2, 45.00),
       (10, 9, 1, 110.00),
       (10, 3, 1, 199.99),

-- Datos adicionales para llegar a 50+
       (1, 4, 1, 180.75),
       (2, 5, 1, 35.90),
       (3, 6, 2, 45.00),
       (4, 7, 1, 75.00),
       (5, 8, 1, 59.99),
       (6, 10, 1, 250.00),
       (7, 1, 1, 850.00),
       (8, 2, 1, 320.50),
       (9, 3, 1, 199.99),
       (10, 4, 1, 180.75),
       (1, 5, 1, 35.90),
       (2, 6, 1, 45.00),
       (3, 7, 1, 75.00),
       (4, 8, 1, 59.99),
       (5, 9, 1, 110.00),
       (6, 10, 1, 250.00),
       (7, 1, 1, 850.00),
       (8, 2, 1, 320.50),
       (9, 3, 1, 199.99),
       (10, 4, 1, 180.75);
