package utilidades;

import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

public class Validacion {
	
	static String mensaje;
	
	public static void soloAdmiteDigitos(KeyEvent e)
	{
		  char caracter = e.getKeyChar();
	      // Verificar si la tecla pulsada no es un digito
	      if(((caracter < '0') ||(caracter > '9')) && (caracter != '\b' /*corresponde a BACK_SPACE*/) && (caracter != ','))
	      {
	         if(caracter != '.') //Permite agregar el punto decimal
	    	  e.consume();  // ignorar el evento de teclado
	      }		
	}
	
	public static boolean camposVacios(String precio,Object color, Object consumo,String peso, int tipo, String carga, String res)
	{
		boolean  valido=true;
		mensaje="Los siguientes campos están vacios:\n";
		
		if(precio.trim().isEmpty())
		{
			mensaje +="* Precio base\n";
			valido=false;
		}
		
		if(color==null)
		{
			mensaje +="* Color\n";
			valido=false;
		}
		
		if(consumo==null)
		{
			mensaje +="* Consumo\n";
			valido=false;
		}
		
		if(peso.trim().isEmpty())
		{
			mensaje +="* Peso\n";
			valido=false;
		}
		
		switch(tipo)
		{
			case 1: 	
				if(carga.trim().isEmpty())
				{
					mensaje +="* Carga\n";
					valido=false;
				}			
				break;
			default:				
				if(res.trim().isEmpty())
				{
					mensaje +="* Resolución\n";
					valido=false;
				}
				
		}
		
		if(!valido)
			JOptionPane.showMessageDialog(null, mensaje, "Aviso",JOptionPane.INFORMATION_MESSAGE);	
				
		return valido;
	}

}
