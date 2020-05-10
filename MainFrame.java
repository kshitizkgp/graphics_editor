
package graphicseditor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.Runnable;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {

        desktop = new JDesktopPane();
        this.setContentPane(desktop);
        initComponents();
        buttons.add(Line);
        buttons.add(Ellipse);
        buttons.add(circle);
        buttons.add(Rect);
        buttons.add(select);
        buttons.add(change_properties);
        buttons.add(delete);
        buttons.add(pan);
        buttons.add(sel_multiple);
        buttons.add(make_group);
        buttons.add(poly);
        buttons.add(zoom);
        buttons.add(normal);
        buttons.add(fit);
        buttons.add(out);
        buttons.add(text);
        buttons.add(copy);
        Rect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        DrawingArea.setShape(1);
                        DrawingArea.enableCreating();
                        for (JButton b : buttons){
                            b.setBackground(new Color(249,249,248));
                        }
                        Rect.setBackground(Color.red);

                    }
                });
                t.start();
            }
        });

        Ellipse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        DrawingArea.setShape(2);
                        DrawingArea.enableCreating();
                        for (JButton b : buttons){
                            b.setBackground(new Color(249,249,248));
                        }
                        Ellipse.setBackground(Color.red);
                    }
                });
                t.start();
            }
        });

        circle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        DrawingArea.setShape(5);
                        DrawingArea.enableCreating();
                        for (JButton b : buttons){
                            b.setBackground(new Color(249,249,248));
                        }
                        circle.setBackground(Color.red);
                    }
                });
                t.start();
            }
        });

         Line.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        DrawingArea.setShape(3);
                        DrawingArea.enableCreating();
                        for (JButton b : buttons){
                            b.setBackground(new Color(249,249,248));
                        }
                        Line.setBackground(Color.red);
                    }
                });
                t.start();
            }
        });

         poly.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        DrawingArea.enablePolygonCreating();
                        for (JButton b : buttons){
                            b.setBackground(new Color(249,249,248));
                        }
                        poly.setBackground(Color.red);

                    }
                });
                t.start();
            }
        });


        text.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Thread t = new Thread(new Runnable(){

                    public void run(){

                        DrawingArea.setShape(4);
                        DrawingArea.enableCreating();
                        Text t = new Text(DrawingArea);
                        t.setVisible(true);
                    }
                });
                t.start();
            }
        });

         select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        DrawingArea.setShape(4);
                        DrawingArea.enableSelecting();
                        for (JButton b : buttons){
                            b.setBackground(new Color(249,249,248));
                        }
                        select.setBackground(Color.red);
                    }
                });
                t.start();
            }
        });

         change_properties.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        JFrame edit_panel = new Edit(DrawingArea);
                        edit_panel.setVisible(true);
                        JInternalFrame edit_pan = new EditShapes();
                        edit_pan.setVisible(true);
                        desktop.add(edit_pan);
                        if (!edit_pan.isShowing()){
                            System.out.println("Helllo!!! I m not showing");
                        }
                        for (JButton b : buttons){
                            b.setBackground(new Color(249,249,248));
                        }
                        change_properties.setBackground(Color.red);

                    }
                });
                t.start();
            }
        });

         delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        for (JButton b : buttons){
                            b.setBackground(new Color(249,249,248));
                        }
                        delete.setBackground(Color.red);
                        for (int i=0;i<DrawingArea.getRect_array().size();i++){
                            if (DrawingArea.getRect_array().get(i).isSelected()){
                                DrawingArea.getRect_array().remove(DrawingArea.getRect_array().get(i));
                                i--;
                                DrawingArea.setNum_rect(DrawingArea.getNum_rect() - 1);
                            }
                        }
                        for (int i=0;i<DrawingArea.getEllipse_array().size();i++){
                            if (DrawingArea.getEllipse_array().get(i).isSelected()){
                                DrawingArea.getEllipse_array().remove(DrawingArea.getEllipse_array().get(i));
                                i--;
                                DrawingArea.setNum_ellipse(DrawingArea.getNum_ellipse()- 1);
                            }
                        }
                        for (int i=0;i<DrawingArea.getLine_array().size();i++){
                            if (DrawingArea.getLine_array().get(i).isSelected()){
                                DrawingArea.getLine_array().remove(DrawingArea.getLine_array().get(i));
                                i--;
                                DrawingArea.setNum_line(DrawingArea.getNum_line()- 1);
                            }
                        }
                        DrawingArea.repaint();
                    }
                });
                t.start();
            }
        });


         copy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Thread t = new Thread(new Runnable(){
                    public void run(){

                        for (JButton b : buttons){
                            b.setBackground(new Color(249,249,248));
                        }
                        copy.setBackground(Color.red);
                        for (int i=0;i<DrawingArea.getRect_array().size();i++){
                            if (DrawingArea.getRect_array().get(i).isSelected()){
                                Rect r = new Rect(DrawingArea.getRect_array().get(i));
                                r.getRectangle().x += 10;
                                r.getRectangle().y += 10;
                                DrawingArea.getRect_array().add(r);
                                DrawingArea.setNum_rect(DrawingArea.getNum_rect() + 1);
                            }
                        }
                        for (int i=0;i<DrawingArea.getEllipse_array().size();i++){
                            if (DrawingArea.getEllipse_array().get(i).isSelected()){
                                Ellipse e = new Ellipse(DrawingArea.getEllipse_array().get(i));
                                e.getEll().x += 10;
                                e.getEll().y += 10;
                                DrawingArea.setNum_ellipse(DrawingArea.getNum_ellipse()+ 1);
                            }
                        }
                        for (int i=0;i<DrawingArea.getLine_array().size();i++){
                            if (DrawingArea.getLine_array().get(i).isSelected()){
                                DrawingArea.getLine_array().remove(DrawingArea.getLine_array().get(i));
                                i--;
                                DrawingArea.setNum_line(DrawingArea.getNum_line()- 1);
                            }
                        }
                        DrawingArea.repaint();
                    }
                });
            }
        });

         pan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        JFrame panning = new PanArea(DrawingArea);
                        panning.setVisible(true);

                        for (JButton b : buttons){
                            b.setBackground(new Color(249,249,248));
                        }
                        pan.setBackground(Color.red);
                    }
                });
                t.start();
            }
        });

        zoom.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        DrawingArea.enableZooming();
                        DrawingArea.setZoom_flag(true);
                        for (JButton b : buttons){
                            b.setBackground(new Color(249,249,248));
                        }
                        zoom.setBackground(Color.red);
                    }
                });

                t.start();
            }
        });

        fit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        FitScreen f =  new FitScreen(DrawingArea);
                        f.fit();
                        for (JButton b : buttons){
                            b.setBackground(new Color(249,249,248));
                        }
                        fit.setBackground(Color.red);
                    }
                });

                t.start();
            }
        });

        out.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        DrawingArea.getZoom().zoomOut();
                        for (JButton b : buttons){
                            b.setBackground(new Color(249,249,248));
                        }
                        out.setBackground(Color.red);
                    }
                });

                t.start();
            }
        });

        normal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        DrawingArea.getZoom().zoomIn();
                        for (JButton b : buttons){
                            b.setBackground(new Color(249,249,248));
                        }
                        zoom.setBackground(Color.red);
                    }
                });

                t.start();
            }
        });

        images.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
               Thread t = new Thread(new Runnable(){
                  public void run(){
                       System.out.println("I have done this");
                      int returnVal = image_chooser.showOpenDialog(new JFrame());
                        if (returnVal == JFileChooser.APPROVE_OPTION) {

                            File file = image_chooser.getSelectedFile();
                            DrawingArea.setShape(6);
                            DrawingArea.enableCreating();
                           try {
                               DrawingArea.getImages().add(ImageIO.read(file));
                           } catch (IOException ex) {
                               Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                           }
                        }else {

                            System.out.println("File access cancelled by user.");
                        }
                  }
               });
               t.start();
            }
        });

        sel_multiple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        DrawingArea.setShape(4);
                        DrawingArea.enableMultiSelecting();
                        for (JButton b : buttons){
                            b.setBackground(new Color(249,249,248));
                        }
                        sel_multiple.setBackground(Color.red);
                    }
                });
                t.start();
            }
        });

        make_group.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {

                        grouping g = new grouping(DrawingArea);
                        DrawingArea.getGroup_array().add(g);
                        DrawingArea.enableNothing();
                        for (JButton b : buttons){
                            b.setBackground(new Color(249,249,248));
                        }
                        make_group.setBackground(Color.red);
                    }
                });
                t.start();
            }
        });

        Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {

                        clipArt ca = new clipArt(DrawingArea);
                        DrawingArea.getClip_array().add(ca);
                        for (JButton b : buttons){
                            b.setBackground(new Color(249,249,248));
                        }
                        make_group.setBackground(Color.red);
                    }
                });
                t.start();
            }
        });

        clip1.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (DrawingArea.getClip_array().size() >=1){
                    DrawingArea.getClip_array().get(0).show();
                    DrawingArea.repaint();
                }
                DrawingArea.enableNothing();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        clip2.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (DrawingArea.getClip_array().size() >=2){
                    DrawingArea.getClip_array().get(1).show();
                }
                DrawingArea.enableNothing();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        clip3.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (DrawingArea.getClip_array().size() >=3){
                    DrawingArea.getClip_array().get(2).show();
                }
                DrawingArea.enableNothing();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        clip4.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (DrawingArea.getClip_array().size() >=4){
                    DrawingArea.getClip_array().get(3).show();
                }
                DrawingArea.enableNothing();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        clip5.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (DrawingArea.getClip_array().size() >=5){
                    DrawingArea.getClip_array().get(4).show();
                }
                DrawingArea.enableNothing();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        clip6.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (DrawingArea.getClip_array().size() >=6){
                    DrawingArea.getClip_array().get(5).show();
                    DrawingArea.repaint();
                }
                DrawingArea.enableNothing();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        clip7.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (DrawingArea.getClip_array().size() >=7){
                    DrawingArea.getClip_array().get(6).show();
                    DrawingArea.repaint();
                }
                DrawingArea.enableNothing();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        clip8.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (DrawingArea.getClip_array().size() >=8){
                    DrawingArea.getClip_array().get(7).show();
                    DrawingArea.repaint();
                }
                DrawingArea.enableNothing();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        clip9.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (DrawingArea.getClip_array().size() >=9){
                    DrawingArea.getClip_array().get(8).show();
                    DrawingArea.repaint();
                }
                DrawingArea.enableNothing();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        clip10.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
               if (DrawingArea.getClip_array().size() >=10){
                    DrawingArea.getClip_array().get(9).show();
                    DrawingArea.repaint();
               }
               DrawingArea.enableNothing();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        New.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Thread t = new Thread( new Runnable(){

                    public void run(){
                        DrawingArea.getRect_array().clear();
                        DrawingArea.getEllipse_array().clear();
                        DrawingArea.getLine_array().clear();
                        DrawingArea.getImages().clear();
                        DrawingArea.getImg_rect().clear();
                        DrawingArea.setNum_ellipse(0);
                        DrawingArea.setNum_rect(0);
                        DrawingArea.setNum_line(0);
                        DrawingArea.setNum_images(0);
                        DrawingArea.getGroup_array().clear();
                        DrawingArea.repaint();
                    }

                });
                t.start();
            }
        });

        Save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Thread t = new Thread(new Runnable(){

                    public void run(){
                        Save s = new Save(DrawingArea);
                        s.setVisible(true);
                    }
                });
                t.start();
            }
        });

        load.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Thread t = new Thread(new Runnable(){

                    public void run(){
                        Load l = new Load(DrawingArea);
                        l.setVisible(true);
                    }
                });
                t.start();
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        image_chooser = new javax.swing.JFileChooser();
        left_toolbar = new javax.swing.JPanel();
        Rect = new javax.swing.JButton();
        Ellipse = new javax.swing.JButton();
        Line = new javax.swing.JButton();
        select = new javax.swing.JButton();
        poly = new javax.swing.JButton();
        circle = new javax.swing.JButton();
        zoom = new javax.swing.JButton();
        normal = new javax.swing.JButton();
        fit = new javax.swing.JButton();
        out = new javax.swing.JButton();
        text = new javax.swing.JButton();
        copy = new javax.swing.JButton();
        Bottom_toolbar = new javax.swing.JPanel();
        delete = new javax.swing.JButton();
        change_properties = new javax.swing.JButton();
        pan = new javax.swing.JButton();
        sel_multiple = new javax.swing.JButton();
        make_group = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        clip1 = new javax.swing.JLabel();
        clip2 = new javax.swing.JLabel();
        clip3 = new javax.swing.JLabel();
        clip4 = new javax.swing.JLabel();
        clip5 = new javax.swing.JLabel();
        clip6 = new javax.swing.JLabel();
        clip7 = new javax.swing.JLabel();
        clip8 = new javax.swing.JLabel();
        clip9 = new javax.swing.JLabel();
        clip10 = new javax.swing.JLabel();
        Add = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        DrawingArea = new graphicseditor.PaintSurface();
        menu = new javax.swing.JMenuBar();
        file_handle = new javax.swing.JMenu();
        New = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        load = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        insert = new javax.swing.JMenu();
        images = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Rect.setLabel("Rect");

        Ellipse.setText("Ellipse");

        Line.setText("Line");

        select.setText("Select");

        poly.setText("Poly");

        circle.setText("circle");

        zoom.setText("Zoom");

        normal.setText("normal");

        fit.setText("fit");

        out.setText("zoomOut");

        text.setText("Text");

        copy.setText("copy");

        javax.swing.GroupLayout left_toolbarLayout = new javax.swing.GroupLayout(left_toolbar);
        left_toolbar.setLayout(left_toolbarLayout);
        left_toolbarLayout.setHorizontalGroup(
            left_toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left_toolbarLayout.createSequentialGroup()
                .addComponent(Line, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(select, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, left_toolbarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(left_toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(zoom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(left_toolbarLayout.createSequentialGroup()
                .addGroup(left_toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(left_toolbarLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(Rect, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Ellipse, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(poly, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(circle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(normal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fit, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(out, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(copy, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        left_toolbarLayout.setVerticalGroup(
            left_toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left_toolbarLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(left_toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rect, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ellipse, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(left_toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Line, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(select, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(left_toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(poly, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(circle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(normal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fit, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(out, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(copy, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(zoom, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        delete.setText("Delete");

        change_properties.setText("property");

        pan.setText("Pan");

        sel_multiple.setText("select_multiple");

        make_group.setText("Group");

        clip1.setText("clip1");

        clip2.setText("clip2");

        clip3.setText("clip3");

        clip4.setText("clip4");

        clip5.setText("clip5");

        clip6.setText("clip6");

        clip7.setText("clip7");

        clip8.setText("clip8");

        clip9.setText("clip9");

        clip10.setText("clip10");

        Add.setText("Add");

        remove.setText("Remove");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(clip1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clip3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(clip2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clip4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(clip6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clip8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(clip5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clip7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clip10, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clip9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Add)
                    .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 94, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clip1)
                    .addComponent(clip3)
                    .addComponent(clip5)
                    .addComponent(clip7)
                    .addComponent(clip9)
                    .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clip2)
                    .addComponent(clip4)
                    .addComponent(clip6)
                    .addComponent(clip8)
                    .addComponent(clip10)
                    .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Bottom_toolbarLayout = new javax.swing.GroupLayout(Bottom_toolbar);
        Bottom_toolbar.setLayout(Bottom_toolbarLayout);
        Bottom_toolbarLayout.setHorizontalGroup(
            Bottom_toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Bottom_toolbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(change_properties, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sel_multiple, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(make_group, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Bottom_toolbarLayout.setVerticalGroup(
            Bottom_toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Bottom_toolbarLayout.createSequentialGroup()
                .addGroup(Bottom_toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(change_properties, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pan, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sel_multiple, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(make_group, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Bottom_toolbarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout DrawingAreaLayout = new javax.swing.GroupLayout(DrawingArea);
        DrawingArea.setLayout(DrawingAreaLayout);
        DrawingAreaLayout.setHorizontalGroup(
            DrawingAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );
        DrawingAreaLayout.setVerticalGroup(
            DrawingAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );

        file_handle.setText("File");

        New.setText("New");
        New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActionPerformed(evt);
            }
        });
        file_handle.add(New);

        Save.setText("Save");
        file_handle.add(Save);

        load.setText("Load");
        file_handle.add(load);

        Exit.setText("Exit");
        file_handle.add(Exit);

        menu.add(file_handle);

        insert.setText("Insert");
        insert.setToolTipText("");

        images.setText("bitmap");
        insert.add(images);

        menu.add(insert);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(left_toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Bottom_toolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DrawingArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(left_toolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(DrawingArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Bottom_toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
                int x = 1;
                String[]  names = {"Krishna","Bagadia","000"};
                names[--x] += ".";
                for (int i=0;i<2;i++){
                    System.out.println(names[i]);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JPanel Bottom_toolbar;
    private graphicseditor.PaintSurface DrawingArea;
    private javax.swing.JButton Ellipse;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JButton Line;
    private javax.swing.JMenuItem New;
    private javax.swing.JButton Rect;
    private javax.swing.JMenuItem Save;
    private javax.swing.JButton change_properties;
    private javax.swing.JButton circle;
    private javax.swing.JLabel clip1;
    private javax.swing.JLabel clip10;
    private javax.swing.JLabel clip2;
    private javax.swing.JLabel clip3;
    private javax.swing.JLabel clip4;
    private javax.swing.JLabel clip5;
    private javax.swing.JLabel clip6;
    private javax.swing.JLabel clip7;
    private javax.swing.JLabel clip8;
    private javax.swing.JLabel clip9;
    private javax.swing.JButton copy;
    private javax.swing.JButton delete;
    private javax.swing.JMenu file_handle;
    private javax.swing.JButton fit;
    private javax.swing.JFileChooser image_chooser;
    private javax.swing.JMenuItem images;
    private javax.swing.JMenu insert;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel left_toolbar;
    private javax.swing.JMenuItem load;
    private javax.swing.JButton make_group;
    private javax.swing.JMenuBar menu;
    private javax.swing.JButton normal;
    private javax.swing.JButton out;
    private javax.swing.JButton pan;
    private javax.swing.JButton poly;
    private javax.swing.JButton remove;
    private javax.swing.JButton sel_multiple;
    private javax.swing.JButton select;
    private javax.swing.JButton text;
    private javax.swing.JButton zoom;
    // End of variables declaration//GEN-END:variables
    private JDesktopPane desktop;

    ArrayList<JButton> buttons = new ArrayList<JButton>();
}
