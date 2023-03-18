/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.bd.ConexionBD;
import org.utl.dsm.model.Juego;

/**
 *
 * @author carlossanchez
 */
public class ControllerJuego {
    public int insert(Juego j) throws Exception {

        //1. Generar consulta que vamos a enviar a la BD
        String query = "{call insertarJuego(?, ?, ?, ?, ?, ?, ?)}";

        //2. Preparar las variables para recibir los valores de retorno
        int idJuegoG = 0;

        //3. Conectarse a la BD
        ConexionBD objConexion = new ConexionBD();
        Connection conexion = objConexion.open();

        //4. Generar el objeto que va a invocar el Store Procedure
        CallableStatement cstmt = conexion.prepareCall(query);

        //5. Asignar a cada uno los valores que se requieren
        cstmt.setString(1, j.getNombre());
        cstmt.setString(2, j.getDesarrollador());
        cstmt.setString(3, j.getCategoria());
        cstmt.setString(4, j.getClasificacion());
        cstmt.setString(5, j.getPlataforma());
        cstmt.setInt(6, j.getPrecio());

        cstmt.registerOutParameter(7, Types.VARCHAR);

        //6. Ejecutar la instruccion
        cstmt.executeUpdate();

        //7. Recuperar los parametros de retorno
        idJuegoG = cstmt.getInt(7);

        //8. Colocar los varlores recuperados dentro del objeto
        j.setIdJuego(idJuegoG);

        //9. Cerrar los objetos de uso de BD
        cstmt.close();
        conexion.close();
        objConexion.close();

        //10. Devolver el id que se genero
        return idJuegoG;
    }

    public void update(Juego j) throws Exception {

        //1. Generar consulta que vamos a enviar a la BD
        String query = "{call actualizarJuego(?, ?, ?, ?, ?, ?, ?)}";

        //3. Conectarse a la BD
        ConexionBD objConexion = new ConexionBD();
        Connection conexion = objConexion.open();

        //4. Generar el objeto que va a invocar el Store Procedure
        CallableStatement cstmt = conexion.prepareCall(query);

        //5. Asignar a cada uno los valores que se requieren
        cstmt.setString(1, j.getNombre());
        cstmt.setString(2, j.getDesarrollador());
        cstmt.setString(3, j.getCategoria());
        cstmt.setString(4, j.getClasificacion());
        cstmt.setString(5, j.getPlataforma());
        cstmt.setInt(6, j.getPrecio());
        cstmt.setInt(7, j.getIdJuego());

        //6. Ejecutar la instruccion
        cstmt.executeUpdate();

        //9. Cerrar los objetos de uso de BD
        cstmt.close();
        conexion.close();
        objConexion.close();

    }

    public void activate(Juego j) throws Exception {

        String query = "{call activarJuego(?)}";

        ConexionBD objConexion = new ConexionBD();
        Connection conexion = objConexion.open();

        CallableStatement cstmt = conexion.prepareCall(query);

        cstmt.setInt(1, j.getIdJuego());

        cstmt.executeUpdate();

        cstmt.close();
        conexion.close();
        objConexion.close();

    }
    
    public void delete(Juego j) throws Exception {

        String query = "{call eliminarJuego(?)}";

        ConexionBD objConexion = new ConexionBD();
        Connection conexion = objConexion.open();

        CallableStatement cstmt = conexion.prepareCall(query);

        cstmt.setInt(1, j.getIdJuego());

        cstmt.executeUpdate();

        cstmt.close();
        conexion.close();
        objConexion.close();

    }

    public List<Juego> getAll(String filtro) throws Exception {

        //1. La Consulta SQL que vamos a ejecutar
        String sql = "SELECT * FROM v_juego WHERE estatus = " + filtro + ";";

        //2. Con este objeto nos conectamos a la base de datos
        ConexionBD connMySQL = new ConexionBD();

        //3.Abrimos las conexion
        Connection conn = connMySQL.open();

        //4, Con este objeto ejecutaremos la consulta
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //5. Aqui guardaremos los resultados de la cosulta
        ResultSet rs = pstmt.executeQuery();

        List<Juego> juegos = new ArrayList<>();

        while (rs.next()) {
            juegos.add(fill(rs));
        }

        rs.close();
        pstmt.close();
        connMySQL.close();
        return juegos;
    }

    private Juego fill(ResultSet rs) throws Exception {
        
        Juego j = new Juego();

        j.setNombre(rs.getString("nombre"));
        j.setDesarrollador(rs.getString("desarrollador"));
        j.setCategoria(rs.getString("categoria"));
        j.setClasificacion(rs.getString("clasificacion"));
        j.setPlataforma(rs.getString("plataforma"));
        j.setPrecio(rs.getInt("precio"));
        j.setEstatus(rs.getInt("estatus"));
        j.setIdJuego(rs.getInt("idJuego"));

        return j;

    }

    public List<Juego> search(String busqueda) throws Exception {

        String sql = "SELECT * FROM v_juego WHERE nombre LIKE '%" + busqueda + "%' OR desarrollador LIKE '%" + busqueda + "%' OR plataforma LIKE '%" + busqueda + "%' OR categoria LIKE '%" + busqueda + "%' OR clasificacion LIKE '%" + busqueda + "%';";

        ConexionBD connMySQL = new ConexionBD();

        Connection conn = connMySQL.open();

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        List<Juego> juegos = new ArrayList<>();

        while (rs.next()) {
            juegos.add(fill(rs));
        }

        rs.close();
        stmt.close();
        connMySQL.close();
        return juegos;

    }
    
}
