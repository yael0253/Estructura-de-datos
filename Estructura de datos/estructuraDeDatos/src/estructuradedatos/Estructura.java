package EstructuraDeDatos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

//import MetodosNumericos.miMarco;

public class Estructura {
	public static JTextField TxtRenglones;
	public static JTextField TxtColumnas;
	public static JTextField TxtElementos;
	public static Marco_presenta marcoMatriz;
	public static JPanel panel1;
	public static GridBagConstraints c;
	public static JTable tabla;
	public static Marco_presenta marco_presenta;
	
	public static void main(String[] args) {
		marco_presenta = new Marco_presenta("Estructura de datos");
		opciones();
	}
	
	static void opciones(){
		JPanel panelBotones = new JPanel();
		JPanel panelDown = new JPanel();
		JButton btnVon = new JButton("Matriz Dispersa");
		JButton btnSalir = new JButton("Salir");
		panelBotones.add(btnVon);
		marco_presenta.add(panelBotones);
		panelDown.add(btnSalir);
		marco_presenta.add(panelDown,BorderLayout.SOUTH);
		btnVon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marco_presenta.dispose();
				datos();
				
			}
		});
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	static void datos() {
		Marco_presenta marcoDatos = new Marco_presenta("Matriz");
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		//panel1.setBackground(Color.blue);
		panel1.add(new JLabel("Dimensión de la matriz: "));
		TxtRenglones = new JTextField(3);
		num(TxtRenglones);
		panel1.add(TxtRenglones);
	    TxtColumnas = new JTextField(3);
	    num(TxtColumnas);
		panel1.add(TxtColumnas);
		panel1.add(new JLabel("Número de elementos: "));
		TxtElementos = new JTextField(3);
		num(TxtElementos);
		panel1.add(TxtElementos);
		marcoDatos.add(panel1,BorderLayout.CENTER);
		JPanel panel2 = new JPanel();
		JButton btnBack = new JButton("Regresar");
		JButton btnDatos = new JButton("Datos");
		panel2.add(btnBack);
		panel2.add(btnDatos);
		marcoDatos.add(panel2,BorderLayout.SOUTH);
		btnDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Valida que introduzca las dimensiones de la matriz y que sean valores positivos
				if(TxtRenglones.getText().length()!=0 && Integer.parseInt(TxtRenglones.getText())>0 
						&& TxtColumnas.getText().length()!=0 && Integer.parseInt(TxtColumnas.getText())>0
						&& TxtElementos.getText().length()!=0 && Integer.parseInt(TxtElementos.getText())>0) {
					marcoDatos.dispose();
					ventana();
				}
			}
			
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcoDatos.dispose();
				marco_presenta = new Marco_presenta("Estructura de datos");
				opciones();
			}
			
		});
		
	}
	
	static void ventana() {
		marcoMatriz = new Marco_presenta("Matriz");
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1; 
		//cantidad de columnas que quiero que ocupe
		c.gridwidth = 1;
		c.gridheight = 1;
		
		int elementos= Integer.parseInt(TxtElementos.getText());
		tabla = new JTable(3,elementos);
		//Valida que no se introduzca un valor mayor al nùmero de columnas y renglones que se definió para la matriz dispersa
		tabla.addKeyListener(new KeyListener() {
		public void keyPressed(KeyEvent e) {
			try {
			if(tabla.getSelectedRow()==0) {
					if(Integer.parseInt(KeyEvent.getKeyText(e.getKeyCode()))> Integer.parseInt(TxtRenglones.getText())) {
						JOptionPane.showMessageDialog(null,"La matriz dispersa definida no tiene "+KeyEvent.getKeyText(e.getKeyCode())+" renglones");
					}
			}
			else if(tabla.getSelectedRow()==1) {
				if(Integer.parseInt(KeyEvent.getKeyText(e.getKeyCode()))> Integer.parseInt(TxtColumnas.getText())) {
						JOptionPane.showMessageDialog(null,"La matriz dispersa definida no tiene "+KeyEvent.getKeyText(e.getKeyCode())+" columnas");
				}
			}
			}catch(NumberFormatException ex) {};
		}

			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if(((caracter >'9'))&& (caracter != '\b')){
					e.consume(); 
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		//Borde exterior de la tabla
		tabla.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		//Colorea las rejillas de la tabla
		tabla.setGridColor(Color.BLACK);
		tabla.setBackground(Color.WHITE);
		panel1 = new JPanel(new GridBagLayout());
		JButton btnCalcula = new JButton("Calcula dispersa");
		c.gridx = 0;
		c.gridy = 0; 
		//cantidad de columnas que quiero que ocupe
		c.gridwidth = 1;
		c.gridheight = 1;
		panel1.add(tabla,c);
		c.gridx = 0;
		c.gridy = 1; 
		//cantidad de columnas que quiero que ocupe
		c.gridwidth = 1;
		c.gridheight = 1;
		panel1.add(btnCalcula,c); 
		marcoMatriz.add(panel1);
		btnCalcula.addActionListener(new ActionListener() {
			//Si no hay celdas vacias calcula la matriz dispersa
			public void actionPerformed(ActionEvent e) {
				if (estaVacio()==false)
					calculaDispersa();
				
			}
			
		});
	}
	
	public static void calculaDispersa() {
		int valor=0;
		int renglon=0;
		int columna=0;
		int ren =Integer.parseInt(TxtRenglones.getText());
		int col= Integer.parseInt(TxtColumnas.getText());
		JTable tablaDispersa = new JTable(ren,col) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		tablaDispersa.setGridColor(Color.BLACK);
		tablaDispersa.setBackground(Color.WHITE);
		int columnas=tablaDispersa.getColumnCount();
		int renglones=tablaDispersa.getRowCount();
		
		for (int r=0;r<tablaDispersa.getRowCount();r++) {
			for(int i=0;i<tablaDispersa.getColumnCount();i++) {
				tablaDispersa.setValueAt(0,r,i);
				tablaDispersa.setEditingRow(r);
			}
		}
		for(int i=0;i<tabla.getColumnCount();i++) {
			for (int r=0;r<tabla.getRowCount();r++) {
				
				//System.out.println("valor["+r+"]["+i+"]"+valor);
				if(r==0) {
					renglon=Integer.parseInt(tabla.getValueAt(r, i).toString())-1;
				}
				else if(r==1) {
					columna = Integer.parseInt(tabla.getValueAt(r, i).toString())-1;
				}
				else if (r==2) {
					valor=Integer.parseInt((tabla.getValueAt(r,i)).toString());
					tablaDispersa.setValueAt(valor,renglon,columna);
				}
			}
			
			
		}
		JPanel panelDispersa = new JPanel();
		panelDispersa.setBackground(Color.CYAN);
		c.gridx = 0;
		c.gridy = 2; 
		//cantidad de columnas que quiero que ocupe
		c.gridwidth = 1;
		c.gridheight = 1;
		panel1.add(tablaDispersa,c);
		JButton btnSalir = new JButton("Salir");
		c.gridx = 0;
		c.gridy = 6; 
		//cantidad de columnas que quiero que ocupe
		c.gridwidth = 1;
		c.gridheight = 1;
		JPanel panelDown = new JPanel();
		JButton btnOtro = new JButton("Otro");
		panelDown.add(btnOtro);
		panelDown.add(btnSalir);
		//panel1.add(btnSalir,c);
		marcoMatriz.add(panelDown,BorderLayout.SOUTH);
		btnOtro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcoMatriz.dispose();
				datos();
			}
		});
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	//Valida alguna celda vacia en la matriz de origen
	static boolean estaVacio() {
		for (int r=0;r<tabla.getRowCount();r++) {
			for(int c=0;c<tabla.getColumnCount();c++) {
				if (tabla.getValueAt(r, c)==null)
					return true;
			}
			
		}
		return false;
	}
	
	
	//Procedimiento que devuelve la cadena de la fecha del sistema
		public static String getFecha(){
			Calendar fecha = new GregorianCalendar();
			String anio = Integer.toString(fecha.get(Calendar.YEAR));
			int num_mes = fecha.get(Calendar.MONTH);
			String mes ="";
			switch(num_mes){
				case 0:
					mes = "Ene";
					break;
				case 1:
					mes = "Feb";
					break;
				case 2:
					mes = "Mar";
					break;
				case 3:
					mes = "Abr";
					break;
				case 4:
					mes = "May";
					break;
				case 5:
					mes = "Jun";
					break;
				case 6:
					mes = "Jul";
					break;
				case 7:
					mes = "Ago";
					break;
				case 8:
					mes = "Sep";
					break;
				case 9:
					mes = "Oct";
					break;
				case 10:
					mes = "Nov";
					break;
				case 11:
					mes = "Dic";
					break;
			}
			
			String dia = Integer.toString(fecha.get(Calendar.DATE));
			return dia +"-" + mes +"-"+ anio;
		}
		
		//validacion que no permite letras en las cajas de texto
		public static void num(JTextField a) {
			a.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					char caracter = e.getKeyChar();
					if(((caracter >'9'))&& (caracter != '\b')){
					e.consume(); 
					}
				}
			});
		}


}
