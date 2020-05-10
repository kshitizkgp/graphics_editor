package graphicseditor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;


public class Edit extends javax.swing.JFrame {

    Color fill_color = Color.WHITE;
    Color line_color = Color.BLACK;
    String line_style;
    String fill_style;
    PaintSurface paint_surface;
    float[] dash_style={1.0f,1.0f};
    float linewidth=1.0f;
    /**
     * Creates new form Edit
     */
    public Edit( PaintSurface ps) {
        initComponents();
        this.paint_surface = ps;
        fillColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                         Color backgroundColor = JColorChooser.showDialog(new JFrame(),
                          "Choose background color", Color.white);
                         fill_color = backgroundColor;
                        System.out.print(fill_color);
                    }
                });
                t.start();
            }
        });
        lineColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                         Color backgroundColor = JColorChooser.showDialog(new JFrame(),
                          "Choose background color", Color.white);
                         line_color = backgroundColor;
                         System.out.print(line_color);
                    }
                });
                t.start();
            }
        });
        line_style_value.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        line_style = line_style_value.getSelectedItem().toString();
                        if (line_style.equalsIgnoreCase("continous")){
                            dash_style[0] = 1.0f;
                            dash_style[1] = 1.0f;
                        }
                        if (line_style.equalsIgnoreCase("dashed")){
                            dash_style[0] = 5.0f;
                            dash_style[1] = 5.0f;
                        }
                        if (line_style.equalsIgnoreCase("dotted")){
                            dash_style[0] = 1.0f;
                            dash_style[1] = 3.0f;
                        }
                    }
                });
                t.start();
            }
        });

        fillStyle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        line_style = line_style_value.getSelectedItem().toString();
                    }
                });
                t.start();
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                       updateShape();
                        setDefaultCloseOperation(WIDTH);
                        dispose();
                    }
                });
                t.start();
            }
        });

    }

    public void updateShape(){
        System.out.print("I m here");
        for (Rect r : paint_surface.getRect_array()){

            if (r.isSelected()){
                r.setSelected(false);
                r.setFillColor(fill_color);
                r.setDashPattern(dash_style);
                r.setBoundaryColor(line_color);
                if (!line_width_value.getText().isEmpty())
                    r.setLineWidth(Float.parseFloat(line_width_value.getText()));
            }
        }
        for (Ellipse e : paint_surface.getEllipse_array()){

            if (e.isSelected()){
                e.setSelected(false);
                e.setFillColor(fill_color);
                e.setDashPattern(dash_style);
                e.setBoundaryColor(line_color);
                if (!line_width_value.getText().isEmpty())
                    e.setLineWidth(Float.parseFloat(line_width_value.getText()));
            }
        }
        for (Line l : paint_surface.getLine_array()){

            if (l.isSelected()){
                l.setSelected(false);
                l.setDash_pattern(dash_style);
                l.setBoundary_color(line_color);
                if (!line_width_value.getText().isEmpty())
                    l.setLine_width(Float.parseFloat(line_width_value.getText()));
            }
        }
        paint_surface.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lineColor = new javax.swing.JButton();
        fillStyle = new javax.swing.JButton();
        fillColor = new javax.swing.JButton();
        line_style_value = new javax.swing.JComboBox();
        lineStyle = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        line_width = new javax.swing.JLabel();
        line_width_value = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lineColor.setText("line_color");

        fillStyle.setText("fillStyle");

        fillColor.setText("fillColor");

        line_style_value.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "continous", "dashed", "dotted" }));
        line_style_value.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                line_style_valueActionPerformed(evt);
            }
        });

        lineStyle.setText("jLabel1");

        exit.setText("exit");

        line_width.setText("line width");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(fillStyle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lineColor, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lineStyle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(line_style_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fillColor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(line_width)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(line_width_value, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exit)
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(line_style_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lineStyle, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lineColor)
                .addGap(18, 18, 18)
                .addComponent(fillStyle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fillColor, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(line_width)
                    .addComponent(line_width_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exit))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void line_style_valueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_line_style_valueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_line_style_valueActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JButton fillColor;
    private javax.swing.JButton fillStyle;
    private javax.swing.JButton lineColor;
    private javax.swing.JLabel lineStyle;
    private javax.swing.JComboBox line_style_value;
    private javax.swing.JLabel line_width;
    private javax.swing.JTextField line_width_value;
    // End of variables declaration//GEN-END:variables
}
