import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;

import com.fazecast.jSerialComm.SerialPort;

public class LAbeltest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      JFrame window = new JFrame("MT Serial Monitor");
	      JPanel panel = new JPanel();
          panel.setLayout(new FlowLayout());
          JLabel label = new JLabel("This is a label!");
          JButton button = new JButton();
          panel.add(label);
          panel.add(button);
          button.setBounds(250, 250, 60, 100);
          button.setText("Press me");
          window.add(panel);
          window.setSize(800, 600);
          window.setLocationRelativeTo(null);
          window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          window.setVisible(true);

        //Seleccion de Puerto
        /*  JComboBox<String> portlist = new JComboBox<String>();
          JButton connectButton = new JButton("Conectar");
          JPanel topPanel = new JPanel();
          topPanel.add(portlist);
          topPanel.add(connectButton);


          //Llenar Campos de puertos
          SerialPort[] portNames = SerialPort.getCommPorts();
          for(int i = 0; i < portNames.length; i++)
          	portlist.addItem(portNames[i].getSystemPortName());
           */
          
	}

}
