/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoabasededatos.vistas;

import accesoabasededatos.modelo.Alumno;
import accesoabasededatos.modelo.AlumnoData;
import accesoabasededatos.modelo.Conexion;
import accesoabasededatos.modelo.Cursada;
import accesoabasededatos.modelo.CursadaData;
import accesoabasededatos.modelo.Materia;
import accesoabasededatos.modelo.MateriaData;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author programador
 */
public class VistaCargaNotas2 extends javax.swing.JInternalFrame {
    
    private DefaultTableModel modelo;
    private ArrayList<Cursada> listaCursada;
    private CursadaData cursadaData;
    private AlumnoData alumnoData;
    private ArrayList<Alumno> listaAlumnos;
    private Conexion conexion;
    /**
     * Creates new form VistaCargaNotas2
     */
    public VistaCargaNotas2() {
        initComponents();
        try {
            conexion = new Conexion("jdbc:mysql://localhost/universidad", "root", "");
    
            modelo = new DefaultTableModel();
        
            cursadaData = new CursadaData(conexion);
            listaCursada =(ArrayList)cursadaData.obtenerCursadas();
        
            alumnoData = new AlumnoData(conexion);
            listaAlumnos = (ArrayList)alumnoData.obtenerAlumnos();
            
            cargaAlumnos();
            armaCabeceraTabla();
            borraFilasTabla();
        
            cargaDatos();
        
       } catch (ClassNotFoundException ex) {
        Logger.getLogger(VistaInscripciones.class.getName()).log(Level.SEVERE, null, ex);
    } 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbAlumnos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tNotas = new javax.swing.JTable();
        jbGuardar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("-CARGA DE NOTAS-");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ALUMNO:");

        cbAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlumnosActionPerformed(evt);
            }
        });

        tNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tNotas);

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2)
                        .addGap(42, 42, 42)
                        .addComponent(cbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jbGuardar)
                        .addGap(76, 76, 76)
                        .addComponent(jbCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbCancelar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlumnosActionPerformed
        // TODO add your handling code here:
        borraFilasTabla();
        cargaDatos();
    }//GEN-LAST:event_cbAlumnosActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada=tNotas.getSelectedRow();
        
        if(filaSeleccionada!=-1){
        
            
            Alumno a = (Alumno)cbAlumnos.getSelectedItem();
            
            
            int idMateria = (Integer)modelo.getValueAt(filaSeleccionada,0);
            int nota = Integer.parseInt((String)modelo.getValueAt(filaSeleccionada,2));
            
            cursadaData.actualizarNotaCursada(a.getId(), idMateria,nota);
            borraFilasTabla();
      
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    public void borraFilasTabla(){

            int a = modelo.getRowCount()-1;
            
            for(int i=a;i>=0;i--){
                modelo.removeRow(i );
                
            }
      }
      
    public void cargaDatos(){
            
        
        //Llenar filas
        Alumno seleccionado = (Alumno)cbAlumnos.getSelectedItem();
        listaCursada = (ArrayList)cursadaData.obtenerCursadasXAlumno(seleccionado.getId());
        
        for(Cursada m:listaCursada){
        
            modelo.addRow(new Object[]{m.getMateria().getId(),m.getMateria().getNombre(),m.getNota()});
        }
        
        
    }
    
    public void cargaAlumnos(){

   
        for(Alumno item:listaAlumnos){
            cbAlumnos.addItem(item);
        }

    }
    
     public void armaCabeceraTabla(){
  
        //Titulos de Columnas
        ArrayList<Object> columnas=new ArrayList<Object>();
        columnas.add("ID");
        columnas.add("Materia");
        columnas.add("Nota");
        for(Object it:columnas){
        
            modelo.addColumn(it);
        }
        tNotas.setModel(modelo);
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Alumno> cbAlumnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JTable tNotas;
    // End of variables declaration//GEN-END:variables
}
