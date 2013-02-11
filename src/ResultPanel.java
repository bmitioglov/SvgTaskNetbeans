
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;


public class ResultPanel extends javax.swing.JPanel {

    /**
     * Creates new form ResultPanel
     */
    public ResultPanel(Map<String,Double> map, List<Otrezok> listOtr, JFrame frame) {
        this.map = map;
        this.frame = frame;
        this.listOtr = listOtr;
        mapLength = map.size();
        
        
        initComponents();
        
        //разметка таблицы
        jTable1.getColumnModel().getColumn(0).setHeaderValue(("ID"));
        jTable1.getColumnModel().getColumn(1).setHeaderValue(("Length"));
        TableColumn column = jTable1.getColumnModel().getColumn(0);
        column.setPreferredWidth(150);
        column = jTable1.getColumnModel().getColumn(1);
        column.setPreferredWidth(150);
        //jLabel1.setText(String.valueOf(listOtr.size()));
        TableModel model = jTable1.getModel();
        
        //заполнение таблицы
        int i = 0;
        for (Map.Entry<String,Double> entry: map.entrySet())
        {
            for (int j = 0; j<2; j++)
            {   
                if(j == 0) model.setValueAt(entry.getKey(), i, j);
                if(j == 1) model.setValueAt(entry.getValue(), i, j);
            }
            i++;
        }
        
        jTable1.getTableHeader().resizeAndRepaint();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(mapLength,2);
        jLabel1 = new javax.swing.JLabel();
        jDrawButton = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTable1);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        jLabel1.setText("Отрезки и их длины");

        jDrawButton.setText("Отрисовка");
        jDrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDrawButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jDrawButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jDrawButton)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jDrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDrawButtonActionPerformed
        // TODO add your handling code here:
        DrawPanel dpanel = new DrawPanel(listOtr, frame);
        this.removeAll();
        this.updateUI();
        frame.remove(this);
        frame.add(dpanel);   
        revalidate();
        repaint();
    }//GEN-LAST:event_jDrawButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jDrawButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    Map<String,Double> map;
    JFrame frame;
    int mapLength;
    List<Otrezok> listOtr;
}
