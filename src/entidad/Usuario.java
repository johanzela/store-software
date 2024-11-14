
package entidad;

public class Usuario {
    private Integer id;
    private String nombre;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }    
}
/*
CREATE TABLE usuario(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) UNIQUE NOT NULL,
    clave BLOB NOT NULL
)ENGINE=INNODB;

INSERT INTO usuario(nombre,clave) VALUES ('admin', AES_ENCRYPT('2000','2000'));
*/


