
package view;

public class Page1 extends javax.swing.JPanel {

    public Page1() {
        initComponents();
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbPeliculas = new javax.swing.JComboBox<>();
        lbSeleccion = new javax.swing.JLabel();
        btnAgregarPelicula = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lsListaPeliculas = new javax.swing.JList<>();
        lbLista = new javax.swing.JLabel();
        btnPagar = new javax.swing.JButton();

        // cbPeliculas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbSeleccion.setText("Selecione la pelicula que desea");

        btnAgregarPelicula.setText("Agregar a la factura");
        // btnAgregarPelicula.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         btnAgregarPeliculaActionPerformed(evt);
        //     }
        // });

        // lsListaPeliculas.setModel(new javax.swing.AbstractListModel<String>() {
        //     String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
        //     public int getSize() { return strings.length; }
        //     public String getElementAt(int i) { return strings[i]; }
        // });
        jScrollPane1.setViewportView(lsListaPeliculas);

        lbLista.setText("Peliculas que  ha agregado");

        btnPagar.setText("Pagar");
        // btnPagar.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         btnPagarActionPerformed(evt);
        //     }
        // });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(cbPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnAgregarPelicula))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(lbSeleccion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(btnPagar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(lbLista)))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbSeleccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarPelicula))
                .addGap(18, 18, 18)
                .addComponent(lbLista)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPagar)
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // private void btnAgregarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPeliculaActionPerformed
    //     System.out.println("Se presiono el boton agregar");
    // }//GEN-LAST:event_btnAgregarPeliculaActionPerformed

    // private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
    //     // TODO add your handling code here:
    // }//GEN-LAST:event_btnPagarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarPelicula;
    public javax.swing.JButton btnPagar;
    public javax.swing.JComboBox<String> cbPeliculas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbLista;
    private javax.swing.JLabel lbSeleccion;
    public javax.swing.JList<String> lsListaPeliculas;
    // End of variables declaration//GEN-END:variables
}
