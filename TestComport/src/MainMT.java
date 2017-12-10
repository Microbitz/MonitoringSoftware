import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.fazecast.jSerialComm.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;


public class MainMT {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		JSlider slider = new JSlider();
		JLabel label = new JLabel();
		JPanel panel = new JPanel();
	    panel.setLayout(null);
	    
        label.setBounds(400, 200, 130, 20);
        label.setBackground(Color.WHITE);
        label.setOpaque(true);
        
		slider.setMaximum(1023);
		window.add(slider);
		window.add(label);
	    window.add(panel);
		//window.pack();
		window.setSize(800, 600);
		window.setVisible(true);

		
		SerialPort[] ports = SerialPort.getCommPorts();
		System.out.println("Select a port:");
		int i = 1;
		for(SerialPort port : ports)
			System.out.println(i++ +  ": " + port.getSystemPortName());
		Scanner s = new Scanner(System.in);
		int chosenPort = s.nextInt();

		SerialPort serialPort = ports[chosenPort - 1];
		if(serialPort.openPort())
			System.out.println("Port opened successfully.");
		else {
			System.out.println("Unable to open the port.");
			return;
		}
		//serialPort.setComPortParameters(9600, 8, 1, SerialPort.NO_PARITY);
		serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 0, 0);

		Scanner data = new Scanner(serialPort.getInputStream());
		int value = 0;
		while(data.hasNextLine()){
			try{value = Integer.parseInt(data.nextLine());}catch(Exception e){}
			slider.setValue(value);
			label.setText(String.valueOf(value));
			
		}
		System.out.println("Done.");
		
	}

}
