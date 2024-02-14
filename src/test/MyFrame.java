package test;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyFrame extends JFrame implements ActionListener {
    private  ButtonGroup bg;
    private Image dimg;
    private  JPanel grafika;
    private  JLabel zdjecieL;
    private  ImageIcon zdj;
    JButton dalej;
    JRadioButton radioButton, radioButton2, radioButton3, radioButton4;
    JButton testprzy;
    JLabel  question;
    int correctBtn_here, chosen_answer, score, i;

    ArrayList<JRadioButton> rbuttons;
    ArrayList<Zadanie> zadania;
    JLabel wynik;
    String s;

    MyFrame() {

        i = 0;
        zadania = new ArrayList<Zadanie>();


        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("dane.txt");
            Scanner sc = new Scanner(is, "UTF-8");
            sc.useDelimiter("%");
            while (sc.hasNextLine()) {
                String a = sc.nextLine();
                String b = sc.nextLine();
                String c = sc.nextLine();
                String d = sc.nextLine();
                String e = sc.nextLine();
                String f = sc.nextLine();
                String g = sc.nextLine();
                zadania.add(new Zadanie(Integer.valueOf(a), b, c, d, e, f, g));
            }
            sc.close();
        }
        catch (NoSuchElementException exception)
        {
            System.out.println("NSE");
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1080, 1080);
        this.setTitle("Quiz!");
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(10, 10));
        this.setResizable(true);
        correctBtn_here = zadania.get(i).poprawne;

        ImageIcon image = new ImageIcon( getClass().getClassLoader().getResource("Pytajnik.jpg"));
        this.setIconImage(image.getImage());

        this.getContentPane().setBackground(new Color(196, 161, 154));
        Border border = BorderFactory.createLineBorder(Color.WHITE);

        JPanel gora = new JPanel();
        gora.setBackground(new Color(196, 161, 154));
        grafika = new JPanel();
        grafika.setBackground(new Color(196, 161, 154));
        JPanel ans = new JPanel();
        ans.setBackground(new Color(196, 161, 154));
        JPanel control = new JPanel();
        control.setBackground(new Color(196, 161, 154));

        ans.setPreferredSize(new Dimension(300, 1080));
        control.setPreferredSize(new Dimension(200, 1000));

        ans.setLayout(new GridLayout(4, 1, 0, 150));
        control.setLayout(new GridLayout(3, 1, 0, 150));
        gora.setLayout(new GridLayout(1, 2, 700, 20));
        this.add(control, BorderLayout.EAST);
        this.add(ans, BorderLayout.WEST);

        question = new JLabel();
        question.setText("<html>"+zadania.get(i).pytanie+"<html>");
        question.setBackground(new Color(213, 180, 173));
        question.setOpaque(true);
        question.setForeground(Color.WHITE);
        question.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        question.setBorder(border);
        question.setVerticalAlignment(JLabel.CENTER);
        question.setHorizontalAlignment(JLabel.CENTER);

        wynik = new JLabel();
        s = String.valueOf(score);
        wynik.setText(s);
        wynik.setBackground(new Color(213, 180, 173));
        wynik.setForeground(Color.WHITE);
        wynik.setOpaque(true);
        wynik.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        wynik.setBorder(border);
        wynik.setVerticalAlignment(JLabel.CENTER);
        wynik.setHorizontalAlignment(JLabel.CENTER);
        wynik.setPreferredSize(new Dimension(100, 100));


        radioButton = new JRadioButton(zadania.get(i).odp1);
        radioButton2 = new JRadioButton(zadania.get(i).odp2);
        radioButton3 = new JRadioButton(zadania.get(i).odp3);
        radioButton4 = new JRadioButton(zadania.get(i).odp4);
        radioButton.setForeground(Color.WHITE);
        radioButton2.setForeground(Color.WHITE);
        radioButton3.setForeground(Color.WHITE);
        radioButton4.setForeground(Color.WHITE);
        radioButton.setBackground(new Color(213, 180, 173));
        radioButton2.setBackground(new Color(213, 180, 173));
        radioButton3.setBackground(new Color(213, 180, 173));
        radioButton4.setBackground(new Color(213, 180, 173));
        radioButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        radioButton2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        radioButton3.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        radioButton4.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        radioButton.setBorder(BorderFactory.createEtchedBorder());
        radioButton.setBorderPainted(true);
        radioButton2.setBorder(BorderFactory.createEtchedBorder());
        radioButton2.setBorderPainted(true);
        radioButton3.setBorder(BorderFactory.createEtchedBorder());
        radioButton3.setBorderPainted(true);
        radioButton4.setBorder(BorderFactory.createEtchedBorder());
        radioButton4.setBorderPainted(true);

        bg = new ButtonGroup();
        bg.add(radioButton);
        bg.add(radioButton2);
        bg.add(radioButton3);
        bg.add(radioButton4);


        testprzy = new JButton();
        testprzy.addActionListener(this);
        testprzy.setFocusable(false);
        testprzy.setText("<html>"+"Sprawdź!"+"<html>");
        testprzy.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        testprzy.setForeground(Color.white);
        testprzy.setBackground(new Color(213, 180, 173));
        testprzy.setBorder(BorderFactory.createEtchedBorder());

        dalej = new JButton();
        dalej.addActionListener(this);
        dalej.setFocusable(false);
        dalej.setText("Dalej");
        dalej.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        dalej.setForeground(Color.white);
        dalej.setBackground(new Color(213, 180, 173));
        dalej.setBorder(BorderFactory.createEtchedBorder());
        dalej.setEnabled(false);

        control.add(wynik);
        control.add(testprzy);
        control.add(dalej);
        gora.add(question);

        this.add(gora, BorderLayout.NORTH);
        ans.add(radioButton);
        ans.add(radioButton2);
        ans.add(radioButton3);
        ans.add(radioButton4);
        radioButton.addActionListener(this);
        radioButton2.addActionListener(this);
        radioButton3.addActionListener(this);
        radioButton4.addActionListener(this);

        rbuttons = new ArrayList<>();
        rbuttons.add(radioButton);
        rbuttons.add(radioButton2);
        rbuttons.add(radioButton3);
        rbuttons.add(radioButton4);


        zdjecieL = new JLabel();
        zdj = new ImageIcon(getClass().getClassLoader().getResource(zadania.get(i).nazwa_pliku));

        this.add(grafika, BorderLayout.CENTER);
        this.setVisible(true);
        dimg = zdj.getImage().getScaledInstance(-1 ,grafika.getHeight(), Image.SCALE_SMOOTH);
        zdj = new ImageIcon(dimg);
        zdjecieL.setIcon(zdj);

        grafika.add(zdjecieL);
        zdjecieL.setHorizontalAlignment(JLabel.CENTER);
        zdjecieL.setVerticalAlignment(JLabel.CENTER);




        this.pack();
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }


    public void update(){
        correctBtn_here = zadania.get(i).poprawne;
        byte[] bytes = zadania.get(i).pytanie.getBytes(StandardCharsets.UTF_8);
        question.setText(new String(bytes, StandardCharsets.UTF_8));
        radioButton.setText(zadania.get(i).odp1);
        radioButton2.setText(zadania.get(i).odp2);
        radioButton3.setText(zadania.get(i).odp3);
        radioButton4.setText(zadania.get(i).odp4);
        s = String.valueOf(score);
        wynik.setText(s);
        bg.clearSelection();

        zdj = new ImageIcon(getClass().getClassLoader().getResource(zadania.get(i).nazwa_pliku));
            if(zdj.getIconHeight() > zdj.getIconWidth()) {
                dimg = zdj.getImage().getScaledInstance(-1, grafika.getHeight(), Image.SCALE_SMOOTH);
            }
            else {
                dimg = zdj.getImage().getScaledInstance(grafika.getWidth(), -1, Image.SCALE_SMOOTH);}
            zdj = new ImageIcon(dimg);
            zdjecieL.setIcon(zdj);
            zdjecieL.setVerticalAlignment(JLabel.CENTER);
            zdjecieL.setHorizontalAlignment(JLabel.CENTER);
        }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == radioButton){
            chosen_answer = 1;
            System.out.println(chosen_answer);}
        else if(e.getSource() == radioButton2)
            chosen_answer = 2;
        else if(e.getSource() == radioButton3)
            chosen_answer = 3;
        else if(e.getSource() == radioButton4) {
            chosen_answer = 4;
        }
        else if(e.getSource() == testprzy)
        {


            {
                dalej.setEnabled(true);
                testprzy.setEnabled(false);
                if (correctBtn_here == chosen_answer) {
                    rbuttons.get(chosen_answer - 1).setForeground(new Color(52, 158, 45));

                    score += 1;
                } else {
                    rbuttons.get(chosen_answer - 1).setForeground(new Color(158,45,45));
                    rbuttons.get(correctBtn_here - 1).setForeground(new Color(52, 158, 45));
                }
            }
        }
        else if (e.getSource() == dalej) {
            i++;
            rbuttons.get(chosen_answer - 1).setForeground(Color.white);
            rbuttons.get(correctBtn_here - 1).setForeground(Color.white);
            if (i<zadania.size()) {
                this.update();
                dalej.setEnabled(false);
                testprzy.setEnabled(true);
            }
            else{
                this.getContentPane().removeAll();
                this.repaint();
                JLabel podsumowanie = new JLabel();
                podsumowanie.setText("<html>"+String.valueOf(score)+"/"+String.valueOf(zadania.size())+"<br/><br/>" + "Pozdro poćwicz:)))" + "<html>");
                this.add(podsumowanie);
                podsumowanie.setHorizontalAlignment(JLabel.CENTER);
                podsumowanie.setVerticalAlignment(JLabel.CENTER);
                podsumowanie.setFont(new Font("Comic Sans MS", Font.PLAIN, 80));
                podsumowanie.setForeground(Color.white);
            }
        }
        }
    }

