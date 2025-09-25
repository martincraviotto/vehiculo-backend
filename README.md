# vehiculo-backend
 43 / 5,000 Backend for vehicle management


Tener docker desktop corriendo.
Ejecutar la instrucciòn:
    docker-compose up

    Esto levanta la instancia de la BD y el PGAdmin

Ingresar a PgAdmin e ingresar con las claves que figuran en 
el docker-compose.yml :
    admin@admin.com /  maac

Dentro del PGAdmin Registrar un nuevo Server.
    Pestaña General --> name : ej/localhost
    Pestaña Connection (siempre de acuerdo a lo definido en docker-compose.yml)
                --> Host name/address : postgres-local
                --> Port: 5432
                --> Password : maac

