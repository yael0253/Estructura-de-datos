package EstructuraDeDatos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Marco_presenta extends JFrame{
	public static JLabel lblReloj;
		//Construye el marco principal centrado en la pantalla 
	public Marco_presenta(String titulo) {
		lblReloj = new JLabel();
		//Crea el objeto reloj para que cambie el segundero de la hora desplegada
		new Reloj();
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = pantalla.getScreenSize();
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		setSize(anchoPantalla/2,alturaPantalla/2);
		setLocation(anchoPantalla/4,alturaPantalla/4);
		setTitle(titulo);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel_fecha_hora = new JPanel();
		panel_fecha_hora.setLayout(new BorderLayout());
		JLabel lblFecha = new JLabel(Estructura.getFecha());
		lblFecha.setFont(new Font("Verdana", Font.PLAIN, 18));
		panel_fecha_hora.add(lblFecha,BorderLayout.EAST);
		//panel_fecha_hora.add(new JLabel(Estructura.getFecha()),BorderLayout.EAST);
		panel_fecha_hora.add(lblReloj,BorderLayout.WEST);
		add(panel_fecha_hora,BorderLayout.NORTH);
		setVisible(true);
		}
	}

