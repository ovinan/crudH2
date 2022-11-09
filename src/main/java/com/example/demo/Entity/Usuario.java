package com.example.demo.Entity;

import java.util.Objects;
import javax.persistence.Column; // Opcional: solo si se le quiere dar un nombre especifico a una columna
import javax.persistence.Entity;
import javax.persistence.GeneratedValue; //Generacion automatica (autoincremental) del ID
import javax.persistence.GenerationType; //Generacion automatica (autoincremental) del ID
import javax.persistence.Id;
import javax.persistence.Table; // Opcional: solo si se le quiere dar un nombre especifico a una tabla
import javax.persistence.Transient; // Para atributos de los objetos que no estan en la tabla

/**
 *
 * @author ovinan
 */
@Entity
@Table(name="tbl_usuario")  // Nombre de la tabla
public class Usuario {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO) //Generacion automatica (autoincremental) del ID
   @Column(name="usuario_id") //Nombre de la columna
   private Long id;
   
   private String nombreUsuario;
   private String nombreCompleto;
   // Si un atributo lo etiquetamos con la anotacion Transient, el motor no lo mapea en la BD
   @Transient
   private boolean nombreInseguro; // Estara el objeto, pero no en la base de datos
   
   public boolean isNombreIncompleto(){
       return !nombreCompleto.isEmpty() && !nombreUsuario.isEmpty();
   }
   
   public Usuario(){
   
   }
   // Constructor
   public Usuario(Long id, String nombreUsuario, String nombreCompleto) {
       this.id = id;
       this.nombreUsuario = nombreUsuario;
       this.nombreCompleto = nombreCompleto;
   }
   // Getter y setters
    public Long getId() {
        return id;
    }

   public void setId(Long id) {
       this.id = id;
   }

   public String getNombreUsuario() {
       return nombreUsuario;
   }
   
   public void setNombreUsuario(String nombreUsuario) {
       this.nombreUsuario = nombreUsuario;
   }
   public String getNombreCompleto() {
       return nombreCompleto;
   }

   public void setNombreCompleto(String nombreCompleto) {
       this.nombreCompleto = nombreCompleto;
   }
   // Recomendado sobreescribir hashcode and equals, y el tostring

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombreUsuario=" + nombreUsuario + ", nombreCompleto=" + nombreCompleto + '}';
    }
   
}
