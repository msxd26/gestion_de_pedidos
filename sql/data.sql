-- Roles (5)
INSERT INTO roles (name) VALUES ('ROLE_USER'), ('ROLE_ADMIN');


-- Users (10)
INSERT INTO Users (name, email, password, total_spent, role_id) VALUES
                                                                    ('Carlos Ruiz', 'carlos@example.com', '1234', 200.00, 2),
                                                                    ('María López', 'maria@example.com', '1234', 0.00, 2),
                                                                    ('Pedro Sánchez', 'pedro@example.com', '1234', 150.50, 2),
                                                                    ('Lucía Pérez', 'lucia@example.com', '1234', 300.00, 2),
                                                                    ('Ana Torres', 'ana@example.com', '1234', 0.00, 5),
                                                                    ('Juan García', 'juan@example.com', '1234', 0.00, 3),
                                                                    ('Marta Díaz', 'marta@example.com', '1234', 0.00, 3),
                                                                    ('Elena Vargas', 'elena@example.com', '1234', 0.00, 4),
                                                                    ('Jorge Castro', 'jorge@example.com', '1234', 0.00, 1),
                                                                    ('Nina Rojas', 'nina@example.com', '1234', 0.00, 2);

-- Products (15)
INSERT INTO Products (name, stock, price, description) VALUES
                                                           ('Laptop HP', 10, 1200.00, 'Laptop para uso profesional'),
                                                           ('Mouse Logitech', 50, 25.00, 'Mouse inalámbrico'),
                                                           ('Teclado Mecánico', 30, 80.00, 'Teclado gamer RGB'),
                                                           ('Monitor Samsung 24"', 20, 150.00, 'Monitor Full HD'),
                                                           ('Disco SSD 1TB', 40, 110.00, 'Disco sólido rápido'),
                                                           ('Memoria RAM 16GB', 60, 75.00, 'DDR4 para PC'),
                                                           ('Impresora HP', 15, 200.00, 'Impresora multifunción'),
                                                           ('Webcam Logitech', 25, 50.00, 'HD 1080p'),
                                                           ('Auriculares Sony', 35, 90.00, 'Cancelación de ruido'),
                                                           ('Tablet Samsung', 12, 300.00, 'Android 10 pulgadas'),
                                                           ('Smartphone Xiaomi', 18, 250.00, 'Buen rendimiento a bajo costo'),
                                                           ('Cargador Universal', 40, 20.00, 'Para varios dispositivos'),
                                                           ('Silla Gamer', 8, 180.00, 'Ergonómica y ajustable'),
                                                           ('Router TP-Link', 22, 60.00, 'WiFi de alta velocidad'),
                                                           ('Power Bank 20000mAh', 45, 40.00, 'Carga portátil');

-- Orders (10)
INSERT INTO Orders (user_id, total, status) VALUES
                                                (1, 150.00, 'Completed'),
                                                (2, 80.00, 'Completed'),
                                                (3, 300.00, 'Pending'),
                                                (4, 250.00, 'Completed'),
                                                (1, 110.00, 'Shipped'),
                                                (5, 60.00, 'Cancelled'),
                                                (6, 90.00, 'Pending'),
                                                (2, 180.00, 'Completed'),
                                                (7, 120.00, 'Processing'),
                                                (8, 200.00, 'Completed');

-- OrderDetails (10)
INSERT INTO OrderDetails (order_id, product_id, quantity, price) VALUES
                                                                     (1, 2, 2, 25.00),
                                                                     (1, 3, 1, 80.00),
                                                                     (2, 5, 1, 110.00),
                                                                     (3, 1, 1, 1200.00),
                                                                     (4, 4, 2, 150.00),
                                                                     (5, 6, 1, 75.00),
                                                                     (6, 11, 1, 250.00),
                                                                     (7, 9, 1, 90.00),
                                                                     (8, 10, 1, 300.00),
                                                                     (9, 7, 1, 200.00);
