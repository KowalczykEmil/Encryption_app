package com.emilkowalczyk;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    private JLabel ltekstjawny, lklucz,ldes;
    private JTextField tjawny, tklucz;
    private JButton bjawny;
    private JTextArea tdes;


    public Main() {
        setSize(500,500);
        setTitle("DataEncryptionStandard");
        setLayout(null);

        ltekstjawny= new JLabel("Wprowadz Tekst jawny:");
        ltekstjawny.setBounds(50, 50, 200, 20);
        add(ltekstjawny);

        tjawny= new JTextField("");
        tjawny.setBounds(50, 70, 150, 20);
        tjawny.setToolTipText("Tekst musi zawierac wiecej niż 8 znakow");
        add(tjawny);

        lklucz= new JLabel("Wprowadz Tekst klucza:");
        lklucz.setBounds(300, 50, 200, 20);
        add(lklucz);

        tklucz= new JTextField("");
        tklucz.setBounds(300, 70, 150, 20);
        tklucz.setToolTipText("Tekst musi zawierac wiecej niż 8 znakow");
        add(tklucz);


        bjawny= new JButton("konwertuj");
        bjawny.setBounds(200, 100, 100, 20);
        add(bjawny);
        bjawny.addActionListener(this);


        tdes =new JTextArea();
        tdes.setBounds(100, 170, 300, 100);
        tdes.setLineWrap(true);
        tdes.setWrapStyleWord(true);
        add (tdes);

        ldes= new JLabel("Zaszyfrowana wiadomość:");
        ldes.setBounds(100, 140, 200, 20);
        add(ldes);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Object zrodlo = e.getSource();
        if(zrodlo==bjawny) {
            String plainText = tjawny.getText();
            String key = tklucz.getText();


            DataEncryptionStandard dataEncryptionStandard = new DataEncryptionStandard();
            dataEncryptionStandard.enterPlainText(plainText);  //tekst jawny
            dataEncryptionStandard.enterKey(key); //klucz szyfru
            String szyf = dataEncryptionStandard.encryptDES();
            tdes.setText(szyf);
        }
    }


    public static void main(String[] args) {

        Main okienko = new Main();
        okienko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okienko.setVisible(true);


    }

}
