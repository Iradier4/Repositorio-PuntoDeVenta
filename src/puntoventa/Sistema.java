/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package puntoventa;

import Conexion.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.time.LocalDate;

/**
 *
 */
public class Sistema extends javax.swing.JFrame {

    /**
     * Creates new form Sistema
     */
    ButtonGroup btnGr;
    ButtonGroup btnGr2;
    
    public Sistema() {
        initComponents();
        this.setLocationRelativeTo(null);
        btnGr = new ButtonGroup();
        btnGr2 = new ButtonGroup();
        btnGr.add(rbSActivo);
        btnGr.add(rbSDesactivo);
        btnGr2.add(rbPActivo);
        btnGr2.add(rbPDesactivo);
        cargarTablaVentas();
        cargarTablaDetalleVenta();
        cargarTablaSucursal();
        cargarTablaProductos();
        
    }
    private void LimpiarSuc(){
        txtSId.setText("");
        txtSNombre.setText("");
        txtSDomicilio.setText("");
        btnGr.clearSelection();
    }
    private void LimpiarProd(){
        txtPId.setText("");
        txtPNombre.setText("");
        txtPPrecio.setText("");
        btnGr2.clearSelection();
    }
    private void LimpiarVenta(){
    txtVFolioVenta.setText("");
    txtVSucursal.setText("");
    txtVSubtotal.setText("");
    txtVIVA.setText("");
    txtVTotal.setText("");
    txtVFecha.setText("");
}
    
    private void cargarTablaVentas(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tbVentas.getModel();
        modeloTabla.setRowCount(0);
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int[] anchos={90,80,90,100,100,150};
        for (int i=0;i<tbVentas.getColumnCount();i++){
            tbVentas.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        try{
            Connection con = Conexion.getConexion();
            ps = con.prepareStatement("SELECT folioVenta, sucursal_id, subtotal, IVA, total, fechaVenta FROM Venta");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            
            while (rs.next()){
                Object[] fila = new Object[columnas];
                for (int i = 0; i<columnas; i++){
                    fila[i] = rs.getObject(i + 1);
                }
                modeloTabla.addRow(fila);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    private void cargarTablaDetalleVenta(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tbDetalleVenta.getModel();
        modeloTabla.setRowCount(0);
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int[] anchos={70,70,100,100,100};
        for (int i=0;i<tbDetalleVenta.getColumnCount();i++){
            tbDetalleVenta.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        try{
            Connection con = Conexion.getConexion();
            ps = con.prepareStatement("SELECT folioVenta_id, producto_id, precio, cantidad, importe FROM detalleVenta");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            
            while (rs.next()){
                Object[] fila = new Object[columnas];
                for (int i = 0; i<columnas; i++){
                    fila[i] = rs.getObject(i + 1);
                }
                modeloTabla.addRow(fila);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    private void cargarTablaSucursal(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tbSucursal.getModel();
        modeloTabla.setRowCount(0);
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int[] anchos={30,70,150,100};
        for (int i=0;i<tbSucursal.getColumnCount();i++){
            tbSucursal.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        try{
            Connection con = Conexion.getConexion();
            ps = con.prepareStatement("SELECT id, nombre, domicilio, estatus FROM Sucursal");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            
            while (rs.next()){
                Object[] fila = new Object[columnas];
                for (int i = 0; i<columnas; i++){
                    fila[i] = rs.getObject(i + 1);
                }
                modeloTabla.addRow(fila);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    private void cargarTablaProductos(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tbProductos.getModel();
        modeloTabla.setRowCount(0);
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int[] anchos={30,150,70,100};
        for (int i=0;i<tbProductos.getColumnCount();i++){
            tbProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        try{
            Connection con = Conexion.getConexion();
            ps = con.prepareStatement("SELECT id, nombre, precio, estatus FROM Producto");
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            
            while (rs.next()){
                Object[] fila = new Object[columnas];
                for (int i = 0; i<columnas; i++){
                    fila[i] = rs.getObject(i + 1);
                }
                modeloTabla.addRow(fila);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbVentas = new javax.swing.JTable();
        btnVModificar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtVFolioVenta = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtVSucursal = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtVSubtotal = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtVIVA = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtVTotal = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtVFecha = new javax.swing.JTextField();
        btnVLimpiar = new javax.swing.JButton();
        btnVEliminar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbDetalleVenta = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtDFolioVenta = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtDProducto = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtDPrecio = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtDCantidad = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtDImporte = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnDLimpiar = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbSucursal = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        txtSId = new javax.swing.JTextField();
        btnSModificar = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        txtSNombre = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtSDomicilio = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        rbSActivo = new javax.swing.JRadioButton();
        rbSDesactivo = new javax.swing.JRadioButton();
        btnSAgregar = new javax.swing.JButton();
        btnSLimpiar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtPId = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtPNombre = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtPPrecio = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        rbPActivo = new javax.swing.JRadioButton();
        rbPDesactivo = new javax.swing.JRadioButton();
        btnPModificar = new javax.swing.JButton();
        btnPAgregar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        btnPLimpiar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        btnProductosVendidos = new javax.swing.JButton();
        btnVentasSucursal = new javax.swing.JButton();
        btnVentasGenerales = new javax.swing.JButton();
        btnSucursales = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnDetalleVentas = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnNuevaVenta = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnVentas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Punto de venta");
        setResizable(false);

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.disabledText"));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTabbedPane1.setBackground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(181, 203, 219));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Ventas");

        tbVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "FolioVenta", "Sucursal_id", "Subtotal", "IVA", "Total", "FechaVenta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVentasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbVentas);

        btnVModificar.setBackground(new java.awt.Color(255, 255, 255));
        btnVModificar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnVModificar.setText("Modificar");
        btnVModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVModificarActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("Folio de Venta");

        txtVFolioVenta.setEditable(false);

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setText("ID de la sucursal");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setText("Subtotal");

        txtVSubtotal.setEditable(false);

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setText("IVA");

        txtVIVA.setEditable(false);
        txtVIVA.setToolTipText("");
        txtVIVA.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtVIVA.setName(""); // NOI18N

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setText("Total");

        txtVTotal.setEditable(false);

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setText("Fecha de la Venta");

        btnVLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        btnVLimpiar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnVLimpiar.setText("Limpiar");
        btnVLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVLimpiarActionPerformed(evt);
            }
        });

        btnVEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnVEliminar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnVEliminar.setText("Eliminar");
        btnVEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(txtVFolioVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                            .addComponent(txtVSucursal)
                            .addComponent(txtVSubtotal)
                            .addComponent(txtVIVA)
                            .addComponent(txtVTotal)
                            .addComponent(txtVFecha))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnVModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnVLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel11)
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVFolioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(265, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ventas", jPanel3);

        jPanel4.setBackground(new java.awt.Color(181, 203, 219));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Detalles de Ventas");

        tbDetalleVenta.setForeground(new java.awt.Color(0, 0, 0));
        tbDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "FolioVenta_id", "Producto_id", "Precio", "Cantidad", "Importe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDetalleVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDetalleVentaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbDetalleVenta);

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("FolioVenta_id");

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setText("Producto_id");

        txtDProducto.setEditable(false);

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setText("Precio");

        txtDPrecio.setEditable(false);

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setText("Cantidad");

        txtDCantidad.setEditable(false);

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel23.setText("Importe");

        txtDImporte.setEditable(false);

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnBuscar.setText("Buscar por folio");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnDLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        btnDLimpiar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDLimpiar.setText("Limpiar");
        btnDLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDLimpiarActionPerformed(evt);
            }
        });

        btnRefrescar.setBackground(new java.awt.Color(255, 255, 255));
        btnRefrescar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnRefrescar.setText("Refrescar");
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel12)
                            .addComponent(txtDFolioVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                            .addComponent(txtDPrecio)
                            .addComponent(txtDCantidad)
                            .addComponent(txtDImporte)
                            .addComponent(txtDProducto))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 37, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel13)
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDFolioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(244, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DetalleVentas", jPanel4);

        jPanel5.setBackground(new java.awt.Color(181, 203, 219));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Sucursales");

        tbSucursal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Nombre", "Domicilio", "Estatus"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Byte.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSucursal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSucursalMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbSucursal);

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel25.setText("id");

        txtSId.setEditable(false);

        btnSModificar.setBackground(new java.awt.Color(255, 255, 255));
        btnSModificar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSModificar.setText("Modificar");
        btnSModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSModificarActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel26.setText("Nombre");

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel27.setText("Domicilio");

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel28.setText("Estatus");

        rbSActivo.setBackground(new java.awt.Color(181, 203, 219));
        rbSActivo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbSActivo.setText("Activo");

        rbSDesactivo.setBackground(new java.awt.Color(181, 203, 219));
        rbSDesactivo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbSDesactivo.setText("Desactivado");

        btnSAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnSAgregar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSAgregar.setText("Agregar");
        btnSAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSAgregarActionPerformed(evt);
            }
        });

        btnSLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        btnSLimpiar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSLimpiar.setText("Limpiar");
        btnSLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSLimpiarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("Refrescar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSId, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel26)
                                .addComponent(jLabel27)
                                .addComponent(jLabel28)
                                .addComponent(txtSNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                .addComponent(txtSDomicilio)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(rbSActivo)
                                    .addGap(18, 18, 18)
                                    .addComponent(rbSDesactivo)
                                    .addGap(22, 22, 22))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnSAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbSActivo)
                            .addComponent(rbSDesactivo))
                        .addGap(287, 287, 287))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnSAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Sucursal", jPanel5);

        jPanel6.setBackground(new java.awt.Color(181, 203, 219));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Productos");

        jLabel30.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel30.setText("id");

        txtPId.setEditable(false);

        jLabel31.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel31.setText("Nombre");

        jLabel32.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel32.setText("Precio");

        jLabel33.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel33.setText("Estatus");

        rbPActivo.setBackground(new java.awt.Color(181, 203, 219));
        rbPActivo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbPActivo.setText("Activo");

        rbPDesactivo.setBackground(new java.awt.Color(181, 203, 219));
        rbPDesactivo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbPDesactivo.setText("Desactivado");

        btnPModificar.setBackground(new java.awt.Color(255, 255, 255));
        btnPModificar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnPModificar.setText("Modificar");
        btnPModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPModificarActionPerformed(evt);
            }
        });

        btnPAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnPAgregar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnPAgregar.setText("Agregar");
        btnPAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPAgregarActionPerformed(evt);
            }
        });

        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Nombre", "Precio", "Estatus"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Byte.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbProductos);

        btnPLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        btnPLimpiar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnPLimpiar.setText("Limpiar");
        btnPLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPLimpiarActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setText("Refrescar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtPPrecio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                .addComponent(txtPNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPId, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(rbPActivo)
                                .addGap(18, 18, 18)
                                .addComponent(rbPDesactivo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btnPAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel29)
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbPDesactivo)
                            .addComponent(rbPActivo)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(btnPModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(250, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Productos", jPanel6);

        jPanel2.setBackground(new java.awt.Color(181, 203, 219));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Reportes");

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Detalles de venta por fecha");

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Ventas por sucursal segun la fecha");

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Los 3 productos más vendidos");

        btnProductosVendidos.setBackground(new java.awt.Color(255, 255, 255));
        btnProductosVendidos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnProductosVendidos.setText("Mostrar");
        btnProductosVendidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosVendidosActionPerformed(evt);
            }
        });

        btnVentasSucursal.setBackground(new java.awt.Color(255, 255, 255));
        btnVentasSucursal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnVentasSucursal.setText("Mostrar");
        btnVentasSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasSucursalActionPerformed(evt);
            }
        });

        btnVentasGenerales.setBackground(new java.awt.Color(255, 255, 255));
        btnVentasGenerales.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnVentasGenerales.setText("Mostrar");
        btnVentasGenerales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasGeneralesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(btnVentasSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(btnVentasGenerales, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addComponent(btnProductosVendidos, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel34)
                .addGap(33, 33, 33)
                .addComponent(jLabel36)
                .addGap(18, 18, 18)
                .addComponent(btnVentasSucursal)
                .addGap(59, 59, 59)
                .addComponent(jLabel35)
                .addGap(18, 18, 18)
                .addComponent(btnVentasGenerales)
                .addGap(59, 59, 59)
                .addComponent(jLabel37)
                .addGap(18, 18, 18)
                .addComponent(btnProductosVendidos)
                .addContainerGap(324, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reportes", jPanel2);

        btnSucursales.setBackground(new java.awt.Color(255, 255, 255));
        btnSucursales.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSucursales.setText("Sucursales");
        btnSucursales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSucursalesActionPerformed(evt);
            }
        });

        btnProductos.setBackground(new java.awt.Color(255, 255, 255));
        btnProductos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnProductos.setText("Productos");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        btnUsuarios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnDetalleVentas.setBackground(new java.awt.Color(255, 255, 255));
        btnDetalleVentas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnDetalleVentas.setText("DetalleVentas");
        btnDetalleVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleVentasActionPerformed(evt);
            }
        });

        btnReportes.setBackground(new java.awt.Color(255, 255, 255));
        btnReportes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnReportes.setText("Reportes");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        btnNuevaVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevaVenta.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnNuevaVenta.setText("\nNueva\nVenta");
        btnNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaVentaActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnVentas.setBackground(new java.awt.Color(255, 255, 255));
        btnVentas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnVentas.setText("Ventas");
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(btnSalir)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                        .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                        .addComponent(btnDetalleVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                        .addComponent(btnSucursales, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                        .addComponent(btnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                        .addComponent(btnVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                                    .addComponent(btnNuevaVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVentas)
                        .addGap(34, 34, 34)
                        .addComponent(btnDetalleVentas)
                        .addGap(34, 34, 34)
                        .addComponent(btnSucursales)
                        .addGap(34, 34, 34)
                        .addComponent(btnProductos)
                        .addGap(34, 34, 34)
                        .addComponent(btnReportes)
                        .addGap(34, 34, 34)
                        .addComponent(btnUsuarios)
                        .addGap(34, 34, 34)
                        .addComponent(btnNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnSalir)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        Usuarios usu = new Usuarios();
        usu.setVisible(true);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnVModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVModificarActionPerformed
        int folio = Integer.parseInt(txtVFolioVenta.getText());
        int sucursalid = Integer.parseInt(txtVSucursal.getText());
        String fecha = txtVFecha.getText();
        
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareCall("{call Modificar_Venta(?,?,?)}");
            ps.setInt(2, sucursalid);
            ps.setString(3, fecha);
            ps.setInt(1, folio);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modificacion al registro exitosa");
            LimpiarVenta();
            cargarTablaVentas();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_btnVModificarActionPerformed

    private void tbVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVentasMouseClicked
        try{
        int fila =tbVentas.getSelectedRow();
        int folio=Integer.parseInt(tbVentas.getValueAt(fila, 0).toString());
        PreparedStatement ps;
        ResultSet rs;
        
        Connection con = Conexion.getConexion();
            ps = con.prepareStatement("SELECT sucursal_id, subtotal, IVA, total, fechaVenta FROM Venta WHERE folioVenta=?");
            ps.setInt(1, folio);
            rs = ps.executeQuery();            
           
            while(rs.next()){
                txtVFolioVenta.setText(String.valueOf(folio));
                txtVSucursal.setText(rs.getString("sucursal_id"));
                txtVSubtotal.setText(rs.getString("subtotal"));
                txtVIVA.setText(rs.getString("IVA"));
                txtVTotal.setText(rs.getString("total"));
                txtVFecha.setText(rs.getString("fechaVenta"));
            }
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
    }
    }//GEN-LAST:event_tbVentasMouseClicked

    private void tbDetalleVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDetalleVentaMouseClicked
        try{
        int fila =tbDetalleVenta.getSelectedRow();
        int folio=Integer.parseInt(tbDetalleVenta.getValueAt(fila, 0).toString());
        int productoid = Integer.parseInt(tbDetalleVenta.getValueAt(fila, 1).toString());
        PreparedStatement ps;
        ResultSet rs;
        
        Connection con = Conexion.getConexion();
            ps = con.prepareStatement("SELECT precio, cantidad, importe FROM detalleVenta WHERE folioVenta_id=? AND producto_id=?");
            ps.setInt(1, folio);
            ps.setInt(2, productoid);
            rs = ps.executeQuery();            
           
            while(rs.next()){
                txtDFolioVenta.setText(String.valueOf(folio));
                txtDProducto.setText(String.valueOf(productoid));
                txtDPrecio.setText(rs.getString("precio"));
                txtDCantidad.setText(rs.getString("cantidad"));
                txtDImporte.setText(rs.getString("importe"));
                
            }
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
    }
    }//GEN-LAST:event_tbDetalleVentaMouseClicked

    private void btnVLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVLimpiarActionPerformed
        LimpiarVenta();
    }//GEN-LAST:event_btnVLimpiarActionPerformed

    private void btnDLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDLimpiarActionPerformed
        txtDFolioVenta.setText("");
        txtDProducto.setText("");
        txtDPrecio.setText("");
        txtDCantidad.setText("");
        txtDImporte.setText("");
    }//GEN-LAST:event_btnDLimpiarActionPerformed

    private void btnSAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSAgregarActionPerformed
        
       int id = Integer.parseInt(txtSId.getText());
        String nombre = txtSNombre.getText();
        String domicilio = txtSDomicilio.getText();
        byte estatus;
        
        if (rbSActivo.isSelected() == true){
            estatus = 1;
        } else if (rbSDesactivo.isSelected() == true){
            estatus = 0;
        }else {
            estatus = 1;
        }
        
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareCall("{call Insertar_Sucursal(?,?,?)}");
            ps.setString(1, nombre);
            ps.setString(2, domicilio);
            ps.setByte(3, estatus);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Registro guardado");
            LimpiarSuc();
            cargarTablaSucursal();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_btnSAgregarActionPerformed

    private void btnSModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSModificarActionPerformed
        int id = Integer.parseInt(txtSId.getText());
        String nombre = txtSNombre.getText();
        String domicilio = txtSDomicilio.getText();
        byte estatus;
        
        if (rbSActivo.isSelected() == true){
            estatus = 1;
        } else if (rbSDesactivo.isSelected() == true){
            estatus = 0;
        }else {
            estatus = 1;
        }
        
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareCall("{call Modificar_Sucursal(?,?,?,?)}");
            ps.setString(2, nombre);
            ps.setString(3, domicilio);
            ps.setByte(4, estatus);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modificacion al registro exitosa");
            LimpiarSuc();
            cargarTablaSucursal();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_btnSModificarActionPerformed

    private void tbSucursalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSucursalMouseClicked
        try{
        int fila =tbSucursal.getSelectedRow();
        int id=Integer.parseInt(tbSucursal.getValueAt(fila, 0).toString());
        PreparedStatement ps;
        ResultSet rs;
        
        Connection con = Conexion.getConexion();
            ps = con.prepareStatement("SELECT nombre, domicilio, estatus FROM Sucursal WHERE id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();            
           
            while(rs.next()){
                txtSId.setText(String.valueOf(id));
                txtSNombre.setText(rs.getString("nombre"));
                txtSDomicilio.setText(rs.getString("domicilio"));
                if(rs.getString("estatus").equals("1")){
                    rbSActivo.setSelected(true);                   
                }else if(rs.getString("estatus").equals("0")){
                    rbSDesactivo.setSelected(true); 
                }
            }
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
    }
    }//GEN-LAST:event_tbSucursalMouseClicked

    private void btnSLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSLimpiarActionPerformed
        LimpiarSuc();
    }//GEN-LAST:event_btnSLimpiarActionPerformed

    private void btnPAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPAgregarActionPerformed
        
        String nombre = txtPNombre.getText();
        double precio = Double.parseDouble(txtPPrecio.getText());
        byte estatus;
        
        if (rbPActivo.isSelected() == true){
            estatus = 1;
        } else if (rbPDesactivo.isSelected() == true){
            estatus = 0;
        }else {
            estatus = 1;
        }
        
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareCall("{call Insertar_Producto (?,?,?)}");
            ps.setString(1, nombre);
            ps.setDouble(2, precio);
            ps.setByte(3, estatus);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Registro guardado");
            LimpiarProd();
            cargarTablaProductos();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_btnPAgregarActionPerformed

    private void btnPModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPModificarActionPerformed
        int id = Integer.parseInt(txtPId.getText());
        String nombre = txtPNombre.getText();
        double precio = Double.parseDouble(txtPPrecio.getText());
        byte estatus;
        
        if (rbPActivo.isSelected() == true){
            estatus = 1;
        } else if (rbPDesactivo.isSelected() == true){
            estatus = 0;
        }else {
            estatus = 1;
        }
        
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareCall("{call Modificar_Producto(?,?,?,?)}");
            ps.setString(2, nombre);
            ps.setDouble(3, precio);
            ps.setByte(4, estatus);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modificacion al registro exitosa");
            LimpiarProd();
            cargarTablaProductos();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_btnPModificarActionPerformed

    private void tbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMouseClicked
        try{
        int fila =tbProductos.getSelectedRow();
        int id=Integer.parseInt(tbProductos.getValueAt(fila, 0).toString());
        PreparedStatement ps;
        ResultSet rs;
        
        Connection con = Conexion.getConexion();
            ps = con.prepareStatement("SELECT nombre, precio, estatus FROM Producto WHERE id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();            
           
            while(rs.next()){
                txtPId.setText(String.valueOf(id));
                txtPNombre.setText(rs.getString("nombre"));
                txtPPrecio.setText(rs.getString("precio"));
                if(rs.getString("estatus").equals("1")){
                    rbPActivo.setSelected(true);                   
                }else if(rs.getString("estatus").equals("0")){
                    rbPDesactivo.setSelected(true); 
                }
            }
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.toString());
    }
    }//GEN-LAST:event_tbProductosMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnPLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPLimpiarActionPerformed
        LimpiarProd();
    }//GEN-LAST:event_btnPLimpiarActionPerformed

    private void btnNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaVentaActionPerformed
        this.dispose();
        NuevaVenta nv = new NuevaVenta();
        nv.setVisible(true);
    }//GEN-LAST:event_btnNuevaVentaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cargarTablaProductos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cargarTablaSucursal();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnVEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVEliminarActionPerformed
        LocalDate todaysDate = LocalDate.now();
        int folio = Integer.parseInt(txtVFolioVenta.getText());
        String fecha = todaysDate.toString();
        
        try{
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareCall("Delete from Venta where folioVenta=?");
            ps.setInt(1, folio);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Registro eliminado");
            LimpiarVenta();
            cargarTablaVentas();      
            cargarTablaDetalleVenta();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_btnVEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int folio = Integer.parseInt(txtDFolioVenta.getText());
        DefaultTableModel modeloTabla = (DefaultTableModel) tbDetalleVenta.getModel();
        modeloTabla.setRowCount(0);
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int[] anchos={70,70,100,100,100};
        for (int i=0;i<tbDetalleVenta.getColumnCount();i++){
            tbDetalleVenta.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        try{
            Connection con = Conexion.getConexion();
            ps = con.prepareCall("{call Ventas_Por_Folio(?)}");
            ps.setInt(1, folio);
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();           
            while (rs.next()){
                Object[] fila = new Object[columnas];
                for (int i = 0; i<columnas; i++){
                    fila[i] = rs.getObject(i + 1);
                }
                modeloTabla.addRow(fila);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        cargarTablaDetalleVenta();
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnSucursalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSucursalesActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnSucursalesActionPerformed

    private void btnDetalleVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleVentasActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnDetalleVentasActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnVentasSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasSucursalActionPerformed
        VentasSucursal ns = new VentasSucursal();
        ns.setVisible(true);
    }//GEN-LAST:event_btnVentasSucursalActionPerformed

    private void btnVentasGeneralesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasGeneralesActionPerformed
        VentasGenerales ng = new VentasGenerales();
        ng.setVisible(true);
    }//GEN-LAST:event_btnVentasGeneralesActionPerformed

    private void btnProductosVendidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosVendidosActionPerformed
        ProductosVendidos pv = new ProductosVendidos();
        pv.setVisible(true);
    }//GEN-LAST:event_btnProductosVendidosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDLimpiar;
    private javax.swing.JButton btnDetalleVentas;
    private javax.swing.JButton btnNuevaVenta;
    private javax.swing.JButton btnPAgregar;
    private javax.swing.JButton btnPLimpiar;
    private javax.swing.JButton btnPModificar;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProductosVendidos;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnSAgregar;
    private javax.swing.JButton btnSLimpiar;
    private javax.swing.JButton btnSModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSucursales;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JButton btnVEliminar;
    private javax.swing.JButton btnVLimpiar;
    private javax.swing.JButton btnVModificar;
    private javax.swing.JButton btnVentas;
    private javax.swing.JButton btnVentasGenerales;
    private javax.swing.JButton btnVentasSucursal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rbPActivo;
    private javax.swing.JRadioButton rbPDesactivo;
    private javax.swing.JRadioButton rbSActivo;
    private javax.swing.JRadioButton rbSDesactivo;
    private javax.swing.JTable tbDetalleVenta;
    private javax.swing.JTable tbProductos;
    private javax.swing.JTable tbSucursal;
    private javax.swing.JTable tbVentas;
    private javax.swing.JTextField txtDCantidad;
    private javax.swing.JTextField txtDFolioVenta;
    private javax.swing.JTextField txtDImporte;
    private javax.swing.JTextField txtDPrecio;
    private javax.swing.JTextField txtDProducto;
    private javax.swing.JTextField txtPId;
    private javax.swing.JTextField txtPNombre;
    private javax.swing.JTextField txtPPrecio;
    private javax.swing.JTextField txtSDomicilio;
    private javax.swing.JTextField txtSId;
    private javax.swing.JTextField txtSNombre;
    private javax.swing.JTextField txtVFecha;
    private javax.swing.JTextField txtVFolioVenta;
    private javax.swing.JTextField txtVIVA;
    private javax.swing.JTextField txtVSubtotal;
    private javax.swing.JTextField txtVSucursal;
    private javax.swing.JTextField txtVTotal;
    // End of variables declaration//GEN-END:variables
}
