package models;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelRentas {
    
    private Connection conexion;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;


    private int id_renta;
    private int id_cliente;
    private int id_pelicula;
    private String formato;
    private String costo;
    private String numero_dias;
    private String costo_renta;


    public void setId_renta(int id_renta) {
        this.id_renta = id_renta;
    }

    public int getId_renta() {
        return id_renta;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }
    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getFormato() {
        return formato;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getCosto() {
        return costo;
    }

    public void setNumero_dias(String numero_dias) {
        this.numero_dias = numero_dias;
    }

    public String getNumero_dias() {
        return numero_dias;
    }
    public void setCosto_renta(String costo_renta){
        this.costo_renta = costo_renta;
    }
    public String getCosto_renta(){
        return costo_renta;
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
          setId_renta(rs.getInt("id_renta"));
          setId_cliente(rs.getInt("id_cliente"));
          setId_pelicula(rs.getInt("id_pelicula"));
          setFormato(rs.getString("formato"));
          setCosto(rs.getString("costo"));
          setNumero_dias(rs.getString("numero_dias"));
          setCosto_renta(rs.getString("costo_renta"));
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
          sql = "INSERT INTO peliculas(id_renta,id_cliente,id_pelicula,formato,costo,numero_dias,costo_renta) VALUES (?,?,?,?,?,?,?);";
          ps = conexion.prepareStatement(sql);
          ps.setInt(0,id_renta);
          ps.setInt(1,id_cliente);
          ps.setInt(2,id_pelicula);
          ps.setString(3,formato);
          ps.setString(4, costo);
          ps.setString(5, numero_dias);
          ps.setString(6, costo_renta);
          ps.executeUpdate();
          Conectar();
          moverPrimero();
          
        
          
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null,"Error 108"+ ex.getMessage());
      }
  }
  
  public void borrar(){
      try{
          sql = "DELETE * FROM peliculas WHERE id_renta = ?;";
          ps = conexion.prepareStatement(sql);
          ps.setInt(0, id_renta);
          ps.executeUpdate();
          Conectar();
          moverPrimero();
          
          
          
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null, "Error 109"+ ex.getMessage());
      }
  }
  
  public void actualizar(){
      try{
          sql = "UPDATE peliculas SET id_cliente = ? , id_pelicula = ?, formato = ? , costo = ?, numero_dias= ?, costo_renta = ? WHERE id_renta;";
          ps.setInt(6, id_renta);
          ps.setInt(0, id_cliente);
          ps.setInt(1, id_pelicula);
          ps.setString(2, formato);
          ps.setString(3, costo);
          ps.setString(4, numero_dias);
          ps.setString(5, costo_renta);
          ps.executeUpdate();
          Conectar();
          moverPrimero();
          
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null,"Error 110"+ ex.getMessage());
      }
  }

    
}
    
 