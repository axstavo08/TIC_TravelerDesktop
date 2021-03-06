/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import dao.AirportDao;
import dao.impl.AirportDaoImpl;
import java.util.List;
import model.Airport;

/**
 *
 * @author Gustavo Ramos
 * @author
 */
public class frmListAirports extends javax.swing.JInternalFrame {

    List<Airport> listAirports;

    /**
     * Creates new form frmListAirports
     */
    public frmListAirports() {
        initComponents();
        AirportDao adao = new AirportDaoImpl();
        listAirports = adao.getAll();
        String oo[][] = new String[listAirports.size()][5];
        for (int i = 0; i < listAirports.size(); i++) {
            Airport a = (Airport) listAirports.get(i);
            oo[i][0] = "" + a.getId();
            oo[i][1] = a.getName();
            oo[i][2] = a.getLocation();
            oo[i][3] = "" + a.getCapacity();
            oo[i][4] = "" + a.getTracks();
        }
        gridAirports.setModel(new javax.swing.table.DefaultTableModel(
                oo,
                new String[]{
                    "Id", "Nombre", "Ubicación", "Aforo", "Cantidad de Pistas"
                }
        ));
        jScrollPane1.setViewportView(gridAirports);
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
        searcher = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gridAirports = new javax.swing.JTable();
        btnExit = new javax.swing.JButton();

        setClosable(true);
        setTitle("Lista de Aeropuertos");
        setToolTipText("");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName(""); // NOI18N
        setVisible(true);

        jLabel1.setText("Buscar:");

        searcher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searcherKeyReleased(evt);
            }
        });

        btnNew.setText("Nuevo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        gridAirports.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gridAirports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gridAirportsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(gridAirports);

        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searcher)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNew))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExit)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(searcher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void searcherKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searcherKeyReleased
        AirportDao adao = new AirportDaoImpl();
        listAirports = adao.getAllCoincidences(searcher.getText().trim());
        String oo[][] = new String[listAirports.size()][5];
        for (int i = 0; i < listAirports.size(); i++) {
            Airport airport = (Airport) listAirports.get(i);
            oo[i][0] = "" + airport.getId();
            oo[i][1] = airport.getName();
            oo[i][2] = airport.getLocation();
            oo[i][3] = "" + airport.getCapacity();
            oo[i][4] = "" + airport.getTracks();
        }
        gridAirports.setModel(new javax.swing.table.DefaultTableModel(
                oo,
                new String[]{
                    "Id", "Nombre", "Ubicación", "Aforo", "Cantidad de Pistas"
                }
        ));
        jScrollPane1.setViewportView(gridAirports);
    }//GEN-LAST:event_searcherKeyReleased

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        new dlgAirport(new javax.swing.JFrame(), true, null).setVisible(true);
        searcherKeyReleased(null);
    }//GEN-LAST:event_btnNewActionPerformed

    private void gridAirportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridAirportsMouseClicked
        new dlgAirport(new javax.swing.JFrame(), true, new Airport(
                Integer.parseInt(gridAirports.getValueAt(gridAirports.getSelectedRow(), 0).toString()),
                gridAirports.getValueAt(gridAirports.getSelectedRow(), 1).toString(),
                gridAirports.getValueAt(gridAirports.getSelectedRow(), 2).toString(),
                Integer.parseInt(gridAirports.getValueAt(gridAirports.getSelectedRow(), 3).toString()),
                Integer.parseInt(gridAirports.getValueAt(gridAirports.getSelectedRow(), 4).toString())
        )).setVisible(true);
        searcherKeyReleased(null);
    }//GEN-LAST:event_gridAirportsMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNew;
    private javax.swing.JTable gridAirports;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searcher;
    // End of variables declaration//GEN-END:variables
}
