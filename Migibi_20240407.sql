Use Migibi;

CREATE TABLE Usuario(
	Id_Usuario int primary key auto_increment,
    Nombre_Usuario varchar(250) not null,
    Contraseña varchar(250) not null
);

CREATE TABLE cat_Tipo_Alimento(
	Id_Tipo_Alimento int primary key auto_increment,
    Tipo_Alimento varchar(250)  not null,
    Activo bool not null default(1),
    Id_Usuario_Alta int not null,
    Fecha_Alta datetime not null ,
    Id_Usuario_Modif int null,
    Fecha_Modif datetime null,
    Id_Usuario_Baja int  null, 
    cat_tipo_alimentoId_Tipo_AlimentoFecha_Baja datetime  null,
    
    FOREIGN KEY (Id_Usuario_Alta) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Usuario_Modif) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Usuario_Baja) REFERENCES Usuario (Id_Usuario)
);

CREATE TABLE cat_Unidad_Medida(
	Id_Unidad_Medida int primary key auto_increment,
    Unidad_Medida varchar(50)  not null,
    Abreviatura varchar(5)  not null,
    Activo bool not null default(1),
    Id_Usuario_Alta int not null,
    Fecha_Alta datetime not null ,
    Id_Usuario_Modif int null,
    Fecha_Modif datetime null,
    Id_Usuario_Baja int  null, 
    Fecha_Baja datetime  null,
    
    FOREIGN KEY (Id_Usuario_Alta) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Usuario_Modif) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Usuario_Baja) REFERENCES Usuario (Id_Usuario)
);

CREATE TABLE cat_Alimento(
	Id_Alimento int primary key auto_increment,
    Id_Tipo_Alimento int not null,
    Id_Unidad_Medida int not null,
    Alimento varchar(250)  not null,
    Activo bool not null default(1),
    Id_Usuario_Alta int not null,
    Fecha_Alta datetime not null ,
    Id_Usuario_Modif int null,
    Fecha_Modif datetime null,
    Id_Usuario_Baja int  null, 
    Fecha_Baja datetime  null,
    
    FOREIGN KEY (Id_Usuario_Alta) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Usuario_Modif) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Usuario_Baja) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Tipo_Alimento) REFERENCES cat_Tipo_Alimento (Id_Tipo_Alimento)
);

CREATE TABLE Stock(
	Id_Stock int primary key auto_increment,
    Activo bool not null default(1),
    Id_Usuario_Alta int not null,
    Fecha_Alta datetime not null ,
    Id_Usuario_Modif int null,
    Fecha_Modif datetime null,
    Id_Usuario_Baja int  null, 
    Fecha_Baja datetime  null,
    
    FOREIGN KEY (Id_Usuario_Alta) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Usuario_Modif) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Usuario_Baja) REFERENCES Usuario (Id_Usuario)
);

CREATE TABLE Stock_Detalle(
	Id_Stock_Detalle int primary key auto_increment,
    Id_Tipo_Alimento int not null,
    Id_Unidad_Medida int not null,
    Cantidad decimal null,
    Activo bool not null default(1),
    Id_Usuario_Alta int not null,
    Fecha_Alta datetime not null ,
    Id_Usuario_Modif int null,
    Fecha_Modif datetime null,
    Id_Usuario_Baja int  null, 
    Fecha_Baja datetime  null,
    
    FOREIGN KEY (Id_Usuario_Alta) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Usuario_Modif) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Usuario_Baja) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Tipo_Alimento) REFERENCES cat_Tipo_Alimento (Id_Tipo_Alimento),
    FOREIGN KEY (Id_Unidad_Medida) REFERENCES cat_Unidad_Medida (Id_Unidad_Medida)
);

CREATE TABLE Receta(
	Id_Receta int primary key auto_increment,
    Nombre varchar(250) not null,
    Activo bool not null default(1),
    Id_Usuario_Alta int not null,
    Fecha_Alta datetime not null ,
    Id_Usuario_Modif int null,
    Fecha_Modif datetime null,
    Id_Usuario_Baja int  null, 
    Fecha_Baja datetime  null,
    
    FOREIGN KEY (Id_Usuario_Alta) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Usuario_Modif) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Usuario_Baja) REFERENCES Usuario (Id_Usuario)
);

CREATE TABLE Receta_Detalle(
	Id_Receta_Detalle int primary key auto_increment,
    Id_Receta int not null,
    Id_Tipo_Alimento int not null,
    Id_Unidad_Medida int not null,
    Cantidad decimal null,
    Activo bool not null default(1),
    Id_Usuario_Alta int not null,
    Fecha_Alta datetime not null ,
    Id_Usuario_Modif int null,
    Fecha_Modif datetime null,
    Id_Usuario_Baja int  null, 
    Fecha_Baja datetime  null,
    
    FOREIGN KEY (Id_Usuario_Alta) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Usuario_Modif) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Usuario_Baja) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Receta) REFERENCES Receta (Id_Receta),
    FOREIGN KEY (Id_Tipo_Alimento) REFERENCES cat_Tipo_Alimento (Id_Tipo_Alimento),
    FOREIGN KEY (Id_Unidad_Medida) REFERENCES cat_Unidad_Medida (Id_Unidad_Medida)
);

CREATE TABLE Receta_Instrucciones(
	Id_Receta_Instrucciones int primary key auto_increment,
    Id_Receta int not null,
    Instruccion varchar(3000) not null,
    Orden int not null,
    Activo bool not null default(1),
    Id_Usuario_Alta int not null,
    Fecha_Alta datetime not null ,
    Id_Usuario_Modif int null,
    Fecha_Modif datetime null,
    Id_Usuario_Baja int  null, 
    Fecha_Baja datetime  null,
    
    FOREIGN KEY (Id_Usuario_Alta) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Usuario_Modif) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Usuario_Baja) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Receta) REFERENCES Receta (Id_Receta)
);

CREATE TABLE Consumo(
	Id_Consumo int primary key auto_increment,
    Id_Receta int not null,
    Id_Usuario_Receta int not null,
    Fecha_Consumo datetime not null,
    Activo bool not null default(1),
    Id_Usuario_Alta int not null,
    Fecha_Alta datetime not null ,
    Id_Usuario_Modif int null,
    Fecha_Modif datetime null,
    Id_Usuario_Baja int  null, 
    Fecha_Baja datetime  null,
    
    FOREIGN KEY (Id_Usuario_Alta) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Usuario_Modif) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Usuario_Baja) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Receta) REFERENCES Receta (Id_Receta)
);

CREATE TABLE Tipo_Consumo(
	Id_Tipo_Consumo int primary key auto_increment,
    Tipo_Consumo varchar(250) not null,
    Activo bool not null default(1),
    Id_Usuario_Alta int not null,
    Fecha_Alta datetime not null ,
    Id_Usuario_Modif int null,
    Fecha_Modif datetime null,
    Id_Usuario_Baja int  null, 
    Fecha_Baja datetime  null,
    
    FOREIGN KEY (Id_Usuario_Alta) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Usuario_Modif) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Usuario_Baja) REFERENCES Usuario (Id_Usuario)
);

CREATE TABLE Compras(
	Id_Compras int primary key auto_increment,
    Id_Usuario_Compra int not null,
    Id_Unidad_Medida int not null,
    Fecha_Compra datetime not null,
    Cantidad decimal null,
    Activo bool not null default(1),
    Id_Usuario_Alta int not null,
    Fecha_Alta datetime not null ,
    Id_Usuario_Modif int null,
    Fecha_Modif datetime null,
    Id_Usuario_Baja int  null, 
    Fecha_Baja datetime  null,
    
    FOREIGN KEY (Id_Usuario_Alta) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Usuario_Modif) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Usuario_Baja) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Usuario_Compra) REFERENCES Usuario (Id_Usuario),
    FOREIGN KEY (Id_Unidad_Medida) REFERENCES cat_Unidad_Medida (Id_Unidad_Medida)
);


