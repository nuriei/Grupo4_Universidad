
package vistas;

import javax.swing.JOptionPane;

public class VistaAlumno extends javax.swing.JInternalFrame {

       
    private persistencia.AlumnoData alumnoData;
    private javax.swing.table.DefaultTableModel modeloTabla;
    private int idAlumnoSeleccionado = -1;
    
    public VistaAlumno() {
        initComponents();
         panelFormulario.setVisible(false);
        modeloTabla = (javax.swing.table.DefaultTableModel)tableAlumnos.getModel();
        
        persistencia.miConexion conexion = new persistencia.miConexion("jdbc:mysql://localhost:3306/grupo4_universidad","root","");

        alumnoData = new persistencia.AlumnoData(conexion);
        cargarAlumnos();
        
        //los botones estan deshabilitados hasta q seleccionemos un objeto en la tabla-Jess
        btnModificar.setEnabled(false);
        btnBaja.setEnabled(false);
        btnAlta.setEnabled(false);
        btnEliminar.setEnabled(false);
        
        
        //Si un elemento de la tabla esta seleccionado, se habilitan los botones a la derecha d la tabla- Jess
        tableAlumnos.getSelectionModel().addListSelectionListener(e -> {
         if (!e.getValueIsAdjusting()) {
            int fila = tableAlumnos.getSelectedRow();
            boolean seleccionado = tableAlumnos.getSelectedRow() != -1;

        btnModificar.setEnabled(seleccionado);
        btnBaja.setEnabled(seleccionado);
        btnEliminar.setEnabled(seleccionado);
        
        //depediendo del estado activo o inactivo del alumno se habilita el btn baja y alta segun corresponda
        if (seleccionado) {
            String estado = tableAlumnos.getValueAt(fila, 5).toString();

            btnBaja.setEnabled(estado.equals("Activo"));
            btnAlta.setEnabled(estado.equals("Inactivo"));
                        } 
        else {
            btnBaja.setEnabled(false);
            btnAlta.setEnabled(false);
                 }
    
    }
});
    
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelBusqueda = new javax.swing.JPanel();
        txtBuscarDoc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnBuscarDoc = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();
        btnAlta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAlumnos = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        panelFormulario = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtDocumento = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        comboBoxEstado = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setTitle("Sistema de Gestion Universidad de La Punta");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Gestion de Alumnos");

        panelBusqueda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Documento:");

        btnBuscarDoc.setText("Buscar");
        btnBuscarDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDocActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(204, 204, 204));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoMas.png"))); // NOI18N
        btnNuevo.setText("+ Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Buscar alumno");

        javax.swing.GroupLayout panelBusquedaLayout = new javax.swing.GroupLayout(panelBusqueda);
        panelBusqueda.setLayout(panelBusquedaLayout);
        panelBusquedaLayout.setHorizontalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBusquedaLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBusquedaLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelBusquedaLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarDoc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNuevo)
                        .addGap(59, 59, 59))))
        );
        panelBusquedaLayout.setVerticalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(16, 16, 16)
                .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtBuscarDoc)
                    .addComponent(btnBuscarDoc)
                    .addComponent(btnNuevo))
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Listado de Alumnos");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnModificar.setBackground(new java.awt.Color(153, 153, 153));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(153, 153, 153));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBaja.setBackground(new java.awt.Color(153, 153, 153));
        btnBaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/baja.png"))); // NOI18N
        btnBaja.setText("Baja");
        btnBaja.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });

        btnAlta.setBackground(new java.awt.Color(153, 153, 153));
        btnAlta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/alta.png"))); // NOI18N
        btnAlta.setText("Alta");
        btnAlta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });

        tableAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DNI", "Apellido", "Nombre", "Fecha Nac", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableAlumnos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBaja)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlta)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)))
                .addGap(47, 47, 47))
        );

        btnSalir.setBackground(new java.awt.Color(153, 153, 153));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/log-out.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        panelFormulario.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Documento:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Apellido:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Fecha de nacimiento:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Estado:");

        comboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        btnGuardar.setBackground(new java.awt.Color(153, 153, 153));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(153, 153, 153));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Formulario de Alumno");

        javax.swing.GroupLayout panelFormularioLayout = new javax.swing.GroupLayout(panelFormulario);
        panelFormulario.setLayout(panelFormularioLayout);
        panelFormularioLayout.setHorizontalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtApellido)
                            .addComponent(txtDocumento)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelFormularioLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioLayout.createSequentialGroup()
                                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelFormularioLayout.setVerticalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxEstado)
                    .addComponent(jLabel6))
                .addGap(34, 34, 34)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(28, 28, 28)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(48, 48, 48))
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDocumento))
                .addGap(18, 18, 18)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellido))
                .addGap(18, 18, 18)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(87, 87, 87))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDocActionPerformed

        String documento = txtBuscarDoc.getText().trim();

        if (documento.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,"Ingresá un documento para buscar.");
            return;
        }

        try {
            int dni = Integer.parseInt(documento);
            entidades.Alumno alumno = alumnoData.buscarAlumnoPorDni(dni);

            if (alumno != null) {
                cargarAlumnos();

                for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                    int dniFila = Integer.parseInt(modeloTabla.getValueAt(i, 1).toString());

                    if (dniFila == dni) {
                        Object[] fila = new Object[modeloTabla.getColumnCount()];

                        for (int j = 0; j < fila.length; j++) {
                            fila[j] = modeloTabla.getValueAt(i, j);
                        }

                        modeloTabla.removeRow(i);
                        modeloTabla.insertRow(0, fila);
                        tableAlumnos.setRowSelectionInterval(0, 0);
                        break;
                    }
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this,"No se encontró un alumno con ese documento.");
            }

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this,"El documento debe contener solo números.");
        }

    }//GEN-LAST:event_btnBuscarDocActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        
        idAlumnoSeleccionado = -1;

        txtDocumento.setText("");
        txtApellido.setText("");
        txtNombre.setText("");
        jDateChooser1.setDate(null);
        comboBoxEstado.setSelectedItem("Activo");
        panelFormulario.setVisible(true);

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        //Coloca en el formulario los valores de la fila seleccionada y muestra el formulario oculto.
        //tambien guarda el id del alumno seleccionado
        int fila = tableAlumnos.getSelectedRow();

        if (fila == -1) {
            return;
        }
        
        idAlumnoSeleccionado = Integer.parseInt(tableAlumnos.getValueAt(fila, 0).toString());

        txtDocumento.setText(tableAlumnos.getValueAt(fila, 1).toString());
        txtApellido.setText(tableAlumnos.getValueAt(fila, 2).toString());
        txtNombre.setText(tableAlumnos.getValueAt(fila, 3).toString());

        java.sql.Date fecha = java.sql.Date.valueOf(tableAlumnos.getValueAt(fila, 4).toString());
        jDateChooser1.setDate(fecha);

        comboBoxEstado.setSelectedItem(tableAlumnos.getValueAt(fila, 5).toString());
         panelFormulario.setVisible(true);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
// Cambia el estado de un alumno a activo sin crear un nuevo registro.

    int fila = tableAlumnos.getSelectedRow();

    if (fila == -1) {
        return;
    }

    int id = Integer.parseInt(
        tableAlumnos.getValueAt(fila, 0).toString()
    );
    Object[] opciones = {"Sí", "No"};//como el panel es en ingles lo cambio
    int respuesta = JOptionPane.showOptionDialog(this,"¿Dar de alta a este alumno?","Confirmar alta",JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
                null,
                opciones, // aca le digo si o no
                opciones[0] // boton seleccionado or defecto que va a ser si

    );

    if (respuesta == JOptionPane.YES_OPTION) {
        alumnoData.altaAlumno(id);
        cargarAlumnos();

        JOptionPane.showMessageDialog(this,"Alumno dado de alta correctamente.");
    }
    }//GEN-LAST:event_btnAltaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        panelFormulario.setVisible(false);
        txtDocumento.setText(null);
        txtApellido.setText(null);
        txtNombre.setText(null);
        jDateChooser1.setDate(null);

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    String documento = txtDocumento.getText().trim();
    String apellido = txtApellido.getText().trim();
    String nombre = txtNombre.getText().trim();

    if (documento.isEmpty() || apellido.isEmpty() || nombre.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Completá todos los campos.");
        return;
    }

    if (jDateChooser1.getDate() == null) {
        JOptionPane.showMessageDialog(this,"Seleccioná la fecha de nacimiento.");
        return;
    }

    try {
        int dni = Integer.parseInt(documento);

        java.time.LocalDate fecha = new java.sql.Date(jDateChooser1.getDate().getTime()).toLocalDate();

        boolean activo = comboBoxEstado.getSelectedItem()
                .toString().equals("Activo");

        entidades.Alumno alumno = new entidades.Alumno(dni, apellido, nombre, fecha, activo);

        if (idAlumnoSeleccionado == -1) {
            alumnoData.guardarAlumno(alumno);
            JOptionPane.showMessageDialog(this,"Alumno guardado.");
        } 
        else {
            alumno.setId(idAlumnoSeleccionado);
            alumnoData.actualizarAlumno(alumno);
            JOptionPane.showMessageDialog(this,"Alumno modificado.");
        }

        cargarAlumnos();
        panelFormulario.setVisible(false);
        idAlumnoSeleccionado = -1;

        txtDocumento.setText("");
        txtApellido.setText("");
        txtNombre.setText("");
        jDateChooser1.setDate(null);
        comboBoxEstado.setSelectedItem("Activo");

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,"El documento debe contener solo números.");
    }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
  // cambia el estado del alumno pero no lo elimina de la base de datos. 
  //Cuando un alumno no esta inscripto en ninguna materia, el estado por defecto es baja
    int fila = tableAlumnos.getSelectedRow();

    if (fila == -1) {
        return;
    }

    int id = Integer.parseInt(tableAlumnos.getValueAt(fila, 0).toString());
    Object[] opciones = {"Sí", "No"};//como el panel es en ingles lo cambio

    int respuesta = JOptionPane.showOptionDialog(this,"¿Dar de baja a este alumno?","Confirmar baja",JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
                null,
                opciones, // aca le digo si o no
                opciones[0] // boton seleccionado or defecto que va a ser si
    );

    if (respuesta == JOptionPane.YES_OPTION) {
        alumnoData.bajaAlumno(id);
        cargarAlumnos();
        JOptionPane.showMessageDialog(this,"Alumno dado de baja.");
    }

    }//GEN-LAST:event_btnBajaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Elimina definitivamente al alumno seleccionado de la base de datos.

    int fila = tableAlumnos.getSelectedRow();

    if (fila == -1) {
        return;
    }

    int id = Integer.parseInt(tableAlumnos.getValueAt(fila, 0).toString());

    int respuesta = JOptionPane.showConfirmDialog(this,"¿Eliminar definitivamente a este alumno? Esta acción no se puede deshacer.","Confirmar eliminación",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);

    if (respuesta == JOptionPane.YES_OPTION) {
        alumnoData.eliminarAlumnoBaseDatos(id);
        cargarAlumnos();

        JOptionPane.showMessageDialog(this,"Alumno eliminado definitivamente.");
    }

    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnBuscarDoc;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> comboBoxEstado;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JPanel panelFormulario;
    private javax.swing.JTable tableAlumnos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscarDoc;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    private void cargarAlumnos() {
    modeloTabla.setRowCount(0);

    for (entidades.Alumno alumno : alumnoData.listarAlumnos()) {
        modeloTabla.addRow(new Object[]{
            alumno.getId(),
            alumno.getDni(),
            alumno.getApellido(),
            alumno.getNombre(),
            alumno.getFecNac(),
            alumno.isActivo() ? "Activo" : "Inactivo"
        });
    }
}

}
