package GUI;

import LOGIC.AzayeDaneshgah;
import LOGIC.DaneshKade;
import LOGIC.Dars;
import LOGIC.Ostad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SafheListAsatid extends JPanel {
    JButton namayesh;
    JTable jTable;
    JScrollPane jScrollPane;


    public SafheListAsatid(){
        initAsatidPanel();
        initcomps();
        align();
        setActinListener();

        GuiController.getInstance().addJpannel(this);
    }
    public void initAsatidPanel(){


        this.setBounds(0,30,800,770);
        this.setVisible(true);
        this.setLayout(null);




    }

    public void initcomps(){
        namayesh=new JButton("NAMAYESH");
        jTable = null;
        jScrollPane = null;
    }
    public void align(){
        namayesh.setBounds(30,30,100,30);
        this.add(namayesh);
    }

    public void setActinListener(){
        namayesh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(jScrollPane==null)){
                    remove(jScrollPane);
                }
                repaint();
                revalidate();
                ArrayList<ArrayList<String>> etelat = new ArrayList<>();
                int j = 0;
                for (AzayeDaneshgah i:
                     AzayeDaneshgah.getAzayeDaneshgahs()) {
                    if (i instanceof Ostad){
                        etelat.add(new ArrayList<>());
                        etelat.get(j).add(i.getId());
                        etelat.get(j).add(i.getName());
                        etelat.get(j).add(i.getEmail());
                        etelat.get(j).add(String.valueOf(((Ostad) i).getDaneshKade()));
                        etelat.get(j).add(((Ostad) i).getShomareTamas());
                        etelat.get(j).add(String.valueOf(((Ostad) i).getDarajeOstadi()));
                        j++;
                    }

                }
                String colomns[] = {"ID","NAME","EMAIL","DANESHKADE","SHOMARETAMAS","DARAJE OSTADI"};
                String rows[][] = etelat.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

                jTable = new JTable(rows,colomns);
                jScrollPane = new JScrollPane(jTable);
                jScrollPane.setBounds(50,200,600,400);
                jScrollPane.repaint();
                jScrollPane.revalidate();
                add(jScrollPane);
                repaint();
                revalidate();
            }
        });
    }

}
