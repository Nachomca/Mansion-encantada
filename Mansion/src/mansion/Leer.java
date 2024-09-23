package mansion;

import java.io.*;

/*
    LA CLASE LEER ESTA MODIFICADA DE MANERA QUE SOLO MANEJA LOS DATOS QUE UTILIZO EN EL. ADEMÁS, TIENE INCLUIDO EXCEPCIONES PARA COMPROBAR QUE SON NUMEROS EN VEZ DE LETRAS, ETC.
*/
public class Leer
{
  public static String dato()
  {
    String sdato = "";
    try
    {
      // Definir un flujo de caracteres de entrada: flujoE
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader flujoE = new BufferedReader(isr);
      // Leer. La entrada finaliza al pulsar la tecla Entrar
      sdato = flujoE.readLine();
    }
    catch(IOException e)
    {
      System.err.println("Error: " + e.getMessage());
    }
    return sdato; // devolver el dato tecleado
  }
  
  public static int datoInt()
  {
    int bandera ; //BANDERA QUE SALTA CUANDO HAY FALLO
    
    do{
        try
        {
            return Integer.parseInt(dato());
        }
        catch(NumberFormatException e)
        {
            System.out.println("ERROR. Introduce el dato de nuevo: ");
   
            bandera = 1;
      
        }
        
    }while(bandera == 1);
    
    return Integer.MIN_VALUE; // valor más pequeño
    
  }
  
  public static float datoFloat()
  {
    int bandera; //BANDERA QUE SALTA CUANDO HAY FALLO
    
    do{
        try
        {
            return Float.parseFloat(dato());
        }
            catch(NumberFormatException e)
        {
            System.out.println("ERROR. Introduce el dato de nuevo: ");
            bandera = 1;
        }
        
    }while(bandera == 1);
    
    return Float.NaN; // No es un número (valor float)
  }
  
}
