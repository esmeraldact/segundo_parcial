
package models;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelPeliculas {
    
    private Connection conexion;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;


    private int id_pelicula;
    private String nombre;
    private String formato;
    private String duracion;
    private String descripcion;


    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getFormato() {
        return formato;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getDuracion() {
        return duracion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public String getDescripcion(){
        return descripcion;
    }
    
    public void Conectar(){
    try{
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/peliculas", "root","utec");
        st = conexion.createStatement();
        seleccionarTodos();
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error 101" + ex.getMessage());
    }  
  }//Conectar
  
  public void llenarValores(){
      try{
          setId_pelicula(rs.getInt("id_pelicula"));
          setNombre(rs.getString("nombre"));
          setFormato(rs.getString("formato"));
          setDuracion(rs.getString("duracion"));
          setDescripcion(rs.getString("descripcion"));
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null, "Error 102" + ex.getMessage());
      }
  }//llenarvalores
  
  public void moverPrimero(){
      try{
          rs.first();
          llenarValores();
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null, "Error 103" + ex.getMessage());
      }
  }
  
  public void moverUltimo(){
      try{
          rs.last();
          llenarValores();
      } catch (SQLException ex){
          JOptionPane.showMessageDialog(null, "Error 104"+ ex.getMessage());
      }
  }
  
  public void moverSiguiente(){
      try{
          if(rs.isLast() == false){
              rs.next();
              llenarValores();
          }
      } catch (SQLException ex){
          JOptionPane.showMessageDialog(null, "Error 105"+ ex.getMessage());
      }
  }
  public void moverAnterior(){
      try{
          if(rs.isFirst() == false){
              rs.previous();
              llenarValores();}
          }catch (SQLException ex){
              JOptionPane.showMessageDialog(null,"Error 106"+ ex.getMessage());
      }
  }
  
  public void seleccionarTodos(){
      try{
          sql = "SELECT * FROM peliculas";
          ps = conexion.prepareStatement(sql);
          rs = ps.executeQuery();
          moverPrimero();
          
      }catch (SQLException ex){
          JOptionPane.showMessageDialog(null,"Error 107"+ ex.getMessage());
      }
  }
  public void insertar(){
      try{
          sql = "INSERT INTO peliculas(nombre,formato,duracion,descripcion) VALUES (?,?,?,?);";
          ps = conexion.prepareStatement(sql);
          ps.setString(0,nombre);
          ps.setString(1,formato);
          ps.setString(2, duracion);
          ps.setString(3, descripcion);
          ps.executeUpdate();
          Conectar();
          moverPrimero();
          
        
          
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null,"Error 108"+ ex.getMessage());
      }
  }
  
  public void borrar(){
      try{
          sql = "DELETE * FROM peliculas WHERE id_pelicula = ?;";
          ps = conexion.prepareStatement(sql);
          ps.setInt(0, id_pelicula);
          ps.executeUpdate();
          Conectar();
          moverPrimero();
          
          
          
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null, "Error 109"+ ex.getMessage());
      }
  }
  
  public void actualizar(){
      try{
          sql = "UPDATE peliculas SET nombre = ? , formato = ? , duracion = ?, descripcion= ? WHERE id_pelicula;";
          ps.setInt(5, id_pelicula);
          ps.setString(1, nombre);
          ps.setString(2, formato);
          ps.setString(3, duracion);
          ps.setString(4, descripcion);
          ps.executeUpdate();
          Conectar();
          moverPrimero();
          
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null,"Error 110"+ ex.getMessage());
      }
  }

    
}
    
 