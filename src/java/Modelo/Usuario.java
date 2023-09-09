
package Modelo;

/**
 *
 * @author PAHUENA
 */
public class Usuario {
int id;
    String email;
    String contraseña;
    String Cod_Materia;
    String Materia;
    

    public Usuario() {
    }

    public Usuario(int id,String email, String contraseña, String Nit_Empresa, String Nombre_empresa, String Departamento, String Municipio, String Sector ) {
        this.id = id;
        this.email = email;
        this.contraseña = contraseña;
        
        this.Cod_Materia = Cod_Materia;
        this.Materia = Materia;
        
    }

    //insertar código

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCod_Materia() {
        return Cod_Materia;
    }

    public void setCod_Materia(String Cod_Materia) {
        this.Cod_Materia = Cod_Materia;
    }

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String Materia) {
        this.Materia = Materia;
    }
    
}
