import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.Timer;
import javax.swing.*;

public class Stopwatch implements ActionListener{

    
    JFrame frame = new JFrame();
    JButton startButton = new JButton("Start");
    JButton resetButton = new JButton("Reset");
    JButton stopButton = new JButton("Stop");

    JLabel timeLabel = new JLabel();

    int elapsedTime = 0;

    int seconds = 0;
    String seconds_string = String.format("%02d", seconds);
    int minutes = 0;    
    String minutes_string = String.format("%02d", minutes);
    int hours = 0;
    String hours_string = String.format("%02d", hours);

	Timer timer = new Timer(1000, new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
			
			elapsedTime=elapsedTime+1000;
			hours = (elapsedTime/3600000);
			minutes = (elapsedTime/60000) % 60;
			seconds = (elapsedTime/1000) % 60;
			seconds_string = String.format("%02d", seconds);
			minutes_string = String.format("%02d", minutes);
			hours_string = String.format("%02d", hours);
			timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
        }});	

    boolean isRunning = false;



    Stopwatch(){

        //zadefinovanie casovaca
        timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
        timeLabel.setBounds(100,100,200,100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN,35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        //nastavenie start tlacidla
        startButton.setBounds(100,200,100,50);
        startButton.setFont(new Font("Verdana", Font.PLAIN,20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        //nastavenie reset tlacidla
        resetButton.setBounds(200,200,100,50);
        resetButton.setFont(new Font("Verdana", Font.PLAIN,20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        //nastavenie stop tlacidla
        stopButton.setBounds(100,250,200,50);
        stopButton.setFont(new Font("Verdana", Font.PLAIN,20));
        stopButton.setFocusable(false);
        stopButton.addActionListener(this);

        //vykreslenie v okne
        frame.add(timeLabel);
        frame.add(startButton);
        frame.add(resetButton);
        frame.add(stopButton);

        //spravenie okna a jeho vlastnosti
        frame.setTitle("Stopky");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }



    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==startButton)
        {
            start();
            isRunning = true;
        }

        if(e.getSource()==resetButton)
        {
            isRunning = false;
            reset();
        }

        if(e.getSource()==stopButton)
        {
            stop();
        }
    }

    void start(){
        timer.start();
    }

    void stop(){
        timer.stop();
    }

    void reset(){
        //zastavenie casovaca
        timer.stop();
        //nastavenie pociatocneho casu 0
        elapsedTime = 0;

        //vynulovanie
        seconds = 0;
        minutes = 0;
        hours = 0;

        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
    }
    
}
