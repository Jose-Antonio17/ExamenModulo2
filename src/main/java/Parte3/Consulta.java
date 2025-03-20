package Parte3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Consulta {

	private static final String CONSULTA_TB_PRODUCTOS = "select id, nombre, tipo, precio, stock from TB_productos";
	private static final String CONSULTA_TB_PRODUCTOS2 = "select tipo, avg(precio) as precio_medio, sum(stock)as stock_por_tipos from TB_Productos group by tipo";
	
	
	public static void main(String[] args) {
		
		System.out.println("================");
		consultaTabla();
		System.out.println("================");
		filtroTabla();
		
	}
	
	public static void consultaTabla() {

		Connection conexion = Conexion.crearConexion();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conexion.createStatement();
			rs = st.executeQuery(CONSULTA_TB_PRODUCTOS);
			while (rs.next()) {
				int id = rs.getInt("ID");
				String nombre = rs.getString("NOMBRE");
				String tipo = rs.getString("TIPO");
				int precio = rs.getInt("PRECIO");
				int stock = rs.getInt("STOCK");
			
				System.out.println(
						"ID: " + id + ", Nombre: " + nombre + ", Tipo: " + tipo+ ", Precio: " + precio + ", Stock: " + stock);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	public static void filtroTabla() {

		Connection conexion = Conexion.crearConexion();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conexion.createStatement();
			rs = st.executeQuery(CONSULTA_TB_PRODUCTOS2);
			while (rs.next()) {
				String tipo = rs.getString("TIPO");	
				int precioMedio = rs.getInt("PRECIO_MEDIO");
				int stockPorTipo = rs.getInt("STOCK_POR_TIPOS");
			
				System.out.println(
						"Tipo: " + tipo + ", PRECIO MEDIO: " + precioMedio + ", STOCK POR TIPOS: " + stockPorTipo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
