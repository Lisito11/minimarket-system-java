package bd_logica;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lisito
 */
public class Producto extends Conexion {

    private String id_producto;
    private String nombre;
    private double precioVenta;
    private double precioCompra;
    private int cantidad;
    private String idcategoria;
    private String idproveedor;
    private double gananciaProducto;

    public double getGananciaProducto() {
        return gananciaProducto;
    }

    public void setGananciaProducto(double gananciaProducto) {
        this.gananciaProducto = gananciaProducto;
    }

    public Producto() {
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(String idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(String idproveedor) {
        this.idproveedor = idproveedor;
    }

    // CONSULTAS
    @Override
    public boolean Agregar() {
        sql = "INSERT INTO producto (id_producto,nombre,precioVenta,precioCompra,cantidad,id_categoria) values(?,?,?,?,?,?)";
        try {
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setString(1, this.id_producto);
            ps.setString(2, this.nombre);
            ps.setDouble(3, this.precioVenta);
            ps.setDouble(4, this.precioCompra);
            ps.setInt(5, this.cantidad);
            ps.setString(6, this.idcategoria);
            ps.execute();
            System.out.println("Producto Agregado");
            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }

    

    public ResultSet getTable(String consulta) {
        ResultSet datos = null;
        try {
            ps = (PreparedStatement) conexion.prepareStatement(consulta);
            datos = ps.executeQuery();
            System.out.println("CONSULTA EXITOSA");
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return datos;

    }

    public ResultSet getCategoria() {
        ResultSet datos = null;
        try {
            ps = (PreparedStatement) conexion.prepareStatement("select nombre, id_categoria from categoria");
            datos = ps.executeQuery();
            System.out.println("CONSULTA EXITOSA");
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return datos;

    }

}
