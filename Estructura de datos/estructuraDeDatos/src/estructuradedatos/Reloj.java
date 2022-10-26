package EstructuraDeDatos;

import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JLabel;



public class Reloj implements Runnable{
	String hora;
	String minutos;
	String segundos;
	String ampm;
	static String hora_actualizada; 
	Thread h1;
	//public static String relojx;	
	public Reloj() {
		h1 = new Thread(this);
		h1.start();
	}

	@Override
	public void run() {
		
		Thread ct= Thread.currentThread();
		while(ct==h1) {
			calcula();
			Marco_presenta.lblReloj.setText(hora+":"+minutos+":"+segundos);
			Marco_presenta.lblReloj.setFont(new Font("Verdana", Font.PLAIN, 18));
		    //System.out.println("Hora actualizada "+hora+":"+minutos+":"+segundos);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e){}
		}
	}
	//Obtiene la hora del dia y da formato
	public void calcula() {
		Calendar calendario = new GregorianCalendar();
		Date fechaHoraActual = new Date();
		calendario.setTime(fechaHoraActual);
		ampm = calendario.get(Calendar.AM_PM)==0?"AM":"PM";
		if(ampm.equals("PM")) {
			int h = calendario.get(Calendar.HOUR_OF_DAY)-12;
			hora= h>9? "" +h:"0"+h;
		}else {
			hora= calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);
		}
		minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
	}

}
