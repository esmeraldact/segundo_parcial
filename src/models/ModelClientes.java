
package models;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelClientes {
    
    private Connection conexion;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;


    private int id_cliente;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;


    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public String getDireccion(){
        return direccion;
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
          setId_cliente(rs.getInt("id_cliente"));
          setNombre(rs.getString("nombre"));
          setTelefono(rs.getString("telefono"));
          setEmail(rs.getString("email"));
          setDireccion(rs.getString("direccion"));
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
          sql = "SELECT * FROM clientes;";
          ps = conexion.prepareStatement(sql);
          rs = ps.executeQuery();
          moverPrimero();
          llenarValores();
      }catch (SQLException ex){
          JOptionPane.showMessageDialog(null,"Error 107"+ ex.getMessage());
      }
  }
  public void insertar(){
      try{
          sql = "INSERT INTO clientes(id_cliente,nombre,telefono,email,direccion) VALUES (?,?,?,?,?);";
          ps = conexion.prepareStatement(sql);
          ps.setInt(1,this.getId_cliente());
          ps.setString(2,this.getNombre());
          ps.setString(3,this.getTelefono());
          ps.setString(4,this.getEmail());
          ps.setString(5,this.getDireccion());
          ps.executeUpdate();
          Conectar();
          moverPrimero();
         
          
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null,"Error 108"+ ex.getMessage());
      }
  }
  
  public void borrar(){
      try{
          sql = "DELETE * FROM clientes WHERE id_clientes = ;";
          ps = conexion.prepareStatement(sql);
          ps.setInt(0, id_cliente);
          ps.executeUpdate();
          Conectar();
          moverPrimero();
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null, "Error 109"+ ex.getMessage());
      }
  }
  
  public void actualizar(){
      try{
          sql = "UPDATE clientes SET nombre = ? , telefono = ? , email = ?, direccion= ? WHERE id_cliente;";
          ps = conexion.prepareStatement(sql);
          ps.setInt(4, id_cliente);
          ps.setString(0, nombre);
          ps.setString(1, telefono);
          ps.setString(2, email);
          ps.setString(3, direccion);
          ps.executeUpdate();
          Conectar();
          moverPrimero();
          
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null,"Error 110"+ ex.getMessage());
      }
  }
}