package GUI;

import LOGIC.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class SafheTaghirPass extends JPanel {
    JLabel previousPass;
    JLabel newPass;
    JTextField previousPass1;
    JTextField newPass1;
    JButton sabt;
    JOptionPane jOptionPane;
    MainFrame frame;


    public SafheTaghirPass() {
        initPanle();
        initComps1();
        align2();
        setActionListener2();

        GuiController.getInstance().addJpannel(this);
    }

    private void initPanle() {

        this.setBounds(0, 30, 800, 770);
        this.setVisible(true);
        this.setLayout(null);


    }

    public void initComps1() {
        previousPass = new JLabel("PASS GHABLI :");
        newPass = new JLabel("PASS JADID :");
        previousPass1 = new JTextField();
        newPass1 = new JTextField();
        sabt = new JButton("TAGHIIR");
        jOptionPane = new JOptionPane();
        frame = (MainFrame) GuiController.getFrame();

    }

    public void align2() {
        previousPass.setBounds(50,100,200,30);
        previousPass1.setBounds(200,100,200,30);
        this.add(previousPass);
        this.add(previousPass1);
        newPass.setBounds(50,150,200,30);
        newPass1.setBounds(200,150,200,30);
        this.add(newPass);
        this.add(newPass1);
        sabt.setBounds(300,300,200,30);
        this.add(sabt);
    }

    public void setActionListener2(){
        sabt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (newPass1.getText().isEmpty() || previousPass1.getText().isEmpty()){
                    jOptionPane.showMessageDialog(GuiController.getFrame(),"FIEL PASS JADID EJBARIST");
                    return;
                }
                String checkPrePass = previousPass1.getText();
                String newPass2 = newPass1.getText();
                boolean a = Controller.getInstance().sabtNewPass(checkPrePass,newPass2);
                if (a){

                    Controller.getInstance().setAkharinZamanVorood();
                    Controller.getInstance().setChangedPass(true);
                    GuiController.getInstance().resetJpanels();
                    SafheVorod safheVorod = new SafheVorod(frame);
                    setVisible(false);
                    frame.add(safheVorod);
                    jOptionPane.showMessageDialog(GuiController.getFrame(),"BA MOVAFAGHIAT AVAZSHOD");
                    return;
                }else {
                    jOptionPane.showMessageDialog(GuiController.getFrame(),"FIEL HARA DOROST MEGHDAR DEHI KONID");

                }
            }
        });
    }
}
