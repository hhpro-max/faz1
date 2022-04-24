package GUI;

import LOGIC.Controller;
import LOGIC.DaneshKade;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafheProfileAza extends JPanel {
    JLabel name1;
    JLabel name2;
    JLabel kodemeli1;
    JLabel kodemeli2;
    JLabel id1;
    JLabel id2;
    JLabel phoneNumber1;
    JLabel phoneNumber2;
    JLabel email1;
    JLabel email2;
    JLabel daneshkade1;
    JLabel daneshkade2;
    JLabel akskarbar1;
    JLabel akskarbar2;
    JTextField jTextField;
    JButton jButton;
    JButton jButton1;
    JOptionPane jOptionPane;

    public SafheProfileAza(){
        initPanle();
        initComps1();
        align2();
        setActionListener2();


        GuiController.getInstance().addJpannel(this);
    }
    private void initPanle() {

        this.setBounds(0,30,800,770);
        this.setVisible(true);
        this.setLayout(null);



    }
    public void initComps1(){
        name1 = new JLabel("NAME & FAMILYY : ");
        name2 = new JLabel(Controller.getInstance().getAzayeDaneshgah().getName());
        kodemeli1 = new JLabel("KODE MELI : ");
        kodemeli2 = new JLabel(Controller.getInstance().getAzayeDaneshgah().getKodMeli());
        id1 = new JLabel("SHOMARE KARBARY : ");
        id2 = new JLabel(Controller.getInstance().getAzayeDaneshgah().getId());
        phoneNumber1 = new JLabel("TELEPHONE TAMAS :");
        phoneNumber2 = new JLabel(Controller.getInstance().getAzayeDaneshgah().getPhoneNumber());
        email1 = new JLabel("EMAIL :");
        email2 = new JLabel(Controller.getInstance().getAzayeDaneshgah().getEmail());
        daneshkade1 = new JLabel("DANESHKADE : ");
        daneshkade2 = new JLabel(Controller.getInstance().getAzayeDaneshgah().getDaneshKade().toString());
        akskarbar1 = new JLabel("AKS KARBAR : ");
        akskarbar2 = new JLabel(Controller.getInstance().getAzayeDaneshgah().getAkskarbar());
        jTextField = new JTextField();
        jButton = new JButton("VIRAYESH EMAIL");
        jButton1 = new JButton("VIRAYESH TELEPHONE");
        jOptionPane = new JOptionPane();

    }
    public void align2(){
        name1.setBounds(10,50,200,30);
        this.add(name1);
        name2.setBounds(200,50,200,30);
        this.add(name2);
        kodemeli1.setBounds(10,100,150,30);
        this.add(kodemeli1);
        kodemeli2.setBounds(200,100,200,30);
        this.add(kodemeli2);
        id1.setBounds(10,200,150,30);
        this.add(id1);
        id2.setBounds(200,200,200,30);
        this.add(id2);
        phoneNumber1.setBounds(10,300,200,30);
        this.add(phoneNumber1);
        phoneNumber2.setBounds(200,300,200,30);
        this.add(phoneNumber2);
        email1.setBounds(10,400,150,30);
        this.add(email1);
        email2.setBounds(200,400,200,30);
        this.add(email2);
        daneshkade1.setBounds(10,500,150,30);
        this.add(daneshkade1);
        daneshkade2.setBounds(200,500,200,30);
        this.add(daneshkade2);
        akskarbar1.setBounds(500,50,150,30);
        this.add(akskarbar1);
        akskarbar2.setBounds(500,100,100,100);
        this.add(akskarbar2);
        jTextField.setBounds(10,650,200,30);
        this.add(jTextField);
        jButton.setBounds(250,650,200,30);
        this.add(jButton);
        jButton1.setBounds(500,650,200,30);
        this.add(jButton1);
    }
    public void setActionListener2(){
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(jTextField.getText().isEmpty())){
                    try {
                        remove(email2);
                    }catch (Exception exc){

                    }


                    Controller.getInstance().getAzayeDaneshgah().setEmail(jTextField.getText());

                    email2 = new JLabel(Controller.getInstance().getAzayeDaneshgah().getEmail());
                    email2.setBounds(200,400,200,30);
                    add(email2);
                    repaint();
                    revalidate();

                }else {
                    jOptionPane.showMessageDialog(GuiController.getFrame(),"FIELD RA POR KONID");
                }
            }
        });
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(jTextField.getText().isEmpty())){

                       try {
                           remove(phoneNumber2);
                       }catch (Exception exception){

                       }

                    Controller.getInstance().getAzayeDaneshgah().setPhoneNumber(jTextField.getText());
                    phoneNumber2 = new JLabel(Controller.getInstance().getAzayeDaneshgah().getPhoneNumber());
                    phoneNumber2.setBounds(200,300,200,30);
                    add(phoneNumber2);
                    repaint();
                    revalidate();

                }else {
                    jOptionPane.showMessageDialog(GuiController.getFrame(),"FIELD RA POR KONID");
                }
            }
        });
    }
}
