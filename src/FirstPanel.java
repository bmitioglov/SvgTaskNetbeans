
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;


public class FirstPanel extends javax.swing.JPanel {

    /**
     * Creates new form FirstPanel
     */
    public FirstPanel(JFrame frame) {
        this.frame = frame;
        myFilter = new MyFilter("svg");
        //chooser = new JFileChooser();
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jNextButton = new javax.swing.JButton();

        jLabel1.setText("Выберите SVG файл");

        jButton1.setText("Обзор");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jNextButton.setText("Далее");
        jNextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jNextButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(158, 206, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(jNextButton)
                .addGap(83, 83, 83))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        chooser = new JFileChooser();
        chooser.setFileFilter(myFilter);
        chooser.setCurrentDirectory(new File("."));
        int status = chooser.showOpenDialog(this);
        if (status == JFileChooser.APPROVE_OPTION){
            svgFile = chooser.getSelectedFile();
            jLabel2.setText("Выбранный файл: "+svgFile.getName());
            chooser.setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jNextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNextButtonActionPerformed
        // TODO add your handling code here:
        if (svgFile == null)
        {
            jLabel2.setText("Выберите файл!");
        } else
        {
            SvgParser svgp = new SvgParser(svgFile);
            map = svgp.getPaths();
            listOtr = svgp.getList();
            ResultPanel rpanel = new ResultPanel(map,listOtr,frame);
            this.removeAll();
            this.updateUI();
            frame.remove(this);
            frame.add(rpanel);   
            revalidate();
            repaint(); 
        }
        
    }//GEN-LAST:event_jNextButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jNextButton;
    // End of variables declaration//GEN-END:variables
    private JFrame frame;
    private File svgFile;
    private JFileChooser chooser;
    private Map<String,Double> map;
    private List<Otrezok> listOtr;
    private MyFilter myFilter;
    

}

class MyFilter extends FileFilter{
    
    public MyFilter(String ext){
        extension = ext;
    }
    
    @Override
    public boolean accept(File f){
        if (f.isDirectory()) {
            return true;
        }
        String path = f.getAbsolutePath().toLowerCase();
        if ((path.endsWith(extension) && (path.charAt(path.length() - extension.length() - 1)) == '.')) {
          return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public String getDescription(){
      return "SVG files";  
    }
    
    String extension;
}

