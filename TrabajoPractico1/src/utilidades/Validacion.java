package utilidades;

import java.awt.event.KeyEvent;

public class Validacion {
	
	public static void soloAdmiteDigitos(KeyEvent e)
	{
		  char caracter = e.getKeyChar();
	      // Verificar si la tecla pulsada no es un digito
	      if(((caracter < '0') ||(caracter > '9')) && (caracter != '\b' /*corresponde a BACK_SPACE*/) && (caracter != ','))
	      {
	         e.consume();  // ignorar el evento de teclado
	      }		
	}
	
	

}
