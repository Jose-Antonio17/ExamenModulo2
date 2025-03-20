CREATE TABLE TB_Productos (
    id NUMBER(5) PRIMARY KEY,
    nombre VARCHAR2(50) NOT NULL,
    tipo VARCHAR2(50) CHECK (tipo IN ('Alimentación','Electrónica', 'Ropa'))NOT NULL,
    precio NUMBER(10,2)NOT NULL,
    stock NUMBER(5)NOT NULL
);

INSERT INTO TB_Productos (id,nombre,tipo,precio,stock) values (1, 'Manzana', 'Alimentación',10,8);
INSERT INTO TB_Productos (id,nombre,tipo,precio,stock) values (2, 'Teclado', 'Electrónica',20,10);
INSERT INTO TB_Productos (id,nombre,tipo,precio,stock) values (3, 'Televisor', 'Electrónica',85,6);
INSERT INTO TB_Productos (id,nombre,tipo,precio,stock) values (4, 'Camisa', 'Ropa',25,15);
INSERT INTO TB_Productos (id,nombre,tipo,precio,stock) values (5, 'Sudadera', 'Ropa',35,3);
INSERT INTO TB_Productos (id,nombre,tipo,precio,stock) values (6, 'Pantalon', 'Ropa',30,5);

select id, nombre, tipo, precio, stock from TB_Productos;

select tipo, avg(precio) as precio_medio, sum(stock)as stock_por_tipos from TB_Productos group by tipo;