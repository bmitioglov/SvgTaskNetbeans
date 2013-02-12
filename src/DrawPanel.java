
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.List;



public class DrawPanel extends javax.swing.JPanel {


    
    public DrawPanel(List<Otrezok> listOtr, JFrame frame) {
        initComponents();
        this.frame = frame;
        this.listOtr = listOtr;
        frame.pack();
        frame.setSize(1200, 730);
        frame.setResizable(true);
        frame.setLocation(0, 0);
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        for(Otrezok otr: listOtr){
            line = new Line2D.Double(otr.getX1(),otr.getY1(),otr.getX2(),otr.getY2());
            g2.draw(line);
        }
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    List<Otrezok> listOtr;
    JFrame frame;
    Line2D line;
}
