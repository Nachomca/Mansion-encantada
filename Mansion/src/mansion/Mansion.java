/*
 * Este es un reto especial por Halloween.
 * Te encuentras explorando una mansión abandonada llena de habitaciones.
 * En cada habitación tendrás que resolver un acertijo para poder avanzar a la siguiente.
 * Tu misión es encontrar la habitación de los dulces.
 *
 * Se trata de implementar un juego interactivo de preguntas y respuestas por terminal.
 * (Tienes total libertad para ser creativo con los textos)
 *
 * - 🏰 Casa: La mansión se corresponde con una estructura cuadrada 4 x 4
 *   que deberás modelar. Las habitaciones de puerta y dulces no tienen enigma.
 *   (16 habitaciones, siendo una de entrada y otra donde están los dulces)
 *   Esta podría ser una representación:
 *   🚪⬜️⬜️⬜️
 *   ⬜️👻⬜️⬜️
 *   ⬜️⬜️⬜️👻
 *   ⬜️⬜️🍭⬜️
 * - ❓ Enigmas: Cada habitación propone un enigma aleatorio que deberás responder con texto.
 *   Si no lo aciertas no podrás desplazarte.
 * - 🧭 Movimiento: Si resuelves el enigma se te preguntará a donde quieres desplazarte.
 *   (Ejemplo: norte/sur/este/oeste. Sólo deben proporcionarse las opciones posibles)
 * - 🍭 Salida: Sales de la casa si encuentras la habitación de los dulces.
 * - 👻 (Bonus) Fantasmas: Existe un 10% de que en una habitación aparezca un fantasma y
 *   tengas que responder dos preguntas para salir de ella.
 */

package mansion;

import java.util.Random;

/**
 *
 * @author Nacho
 * 
 */

public class Mansion {
    
    private static void intro()
    {
        System.out.println("Es la noche de halloween, la mejor noche del año para tí y tus amigos.");
        System.out.println("Vais disfrazados con vuestros trajes favoritos. Ya es tarde, es hora de ir a casa.");
        System.out.println("Pero al final de la calle hay una casa, grande, vieja... da miedo.");
        System.out.println("Decidís entrar ¿Por qué no?, no hay nada que perder. Sois valientes.");
        System.out.println("... MUY MALA DECISIÓN ... Habeis entrado y la puerta se ha cerrado. La casa es enorme.");
        System.out.println("Hay algo ahí con vosotros. Se os acaba el tiempo... CORRED! Buscad la salida.");
        System.out.println("\nINSTRUCCIONES:");
        System.out.println("\tHay 16 secciones en la mansión, 14 habitaciones, 1 puerta de entrada y 1 caramelo de salida");
        System.out.println("\tTienes un mapa, para moverte por las habitaciones usa w -> norte, a -> oeste, s -> sur, d -> este.");
        System.out.println("\tPara poder avanzar de habitación tendras que acertar un puzzle. Pero CUIDADO, si aparece el fantasma"
                + " tendrás que acertar otro puzzle más.");
        System.out.println("\tMirando el mapa y siguiendo las coordenadas, intenta llegar lo más rápido posible a la salida.");
    }
    
    private static String[][] crearMansion()
    {
        String mansion[][] = new String [4][4];
        
        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++)
                mansion[i][j] = "[]";
        
        //Generar numeros random
        Random r = new Random();
        
        //Generar la puerta
        int [] puerta = {r.nextInt(4), r.nextInt(4)};
        
        if(puerta[0] != 0 && puerta[0] != 3)
        {
            if(puerta[1] != 0 && puerta[1] != 3)
            {
                int numero = r.nextInt(1)+1;

                if(numero == 0)
                    numero = 0;
                else
                    numero = 3;

                puerta[1] = numero;
                
            }                 
        }
        
        //Generar salida
        int [] salida = new int [2];
        do{
            salida[0] = r.nextInt(4);
            salida[1] = r.nextInt(4);
            
        }while(salida[0] == puerta [0] && salida[1] == puerta[1]);
        
        //Metemos la puerta y la salida en la mansión
        mansion[puerta[0]][puerta[1]] = "/";
        mansion[salida[0]][salida[1]] = "O";
        
        System.out.println("\nHas entrado en la mansión en las coordenadas (" + (puerta[0] + 1)+ ", " + (puerta[1] + 1) + ").");
        
        return mansion;
    }
    
    private static void pintarMansion(String mansion[][])
    {
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++){
                System.out.print(mansion[i][j]);
            }
            
            System.out.println("");
        }
    }
    
    private static int[] buscarPosicion(String[][] mansion)
    {
        int[] posicion = new int [2];
        
        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++)
            {
                if(mansion[i][j] == "/")
                {
                    posicion[0] = i;
                    posicion[1] = j;
                }
            }
        
        return posicion;
    }
    
    private static String[][] crearAcertijo()
    {
        String[][] acertijos = new String [16][2];
        
        //Preguntas
        acertijos[0][0] = "Entra duro y grande en la boca, pero sale blando y pequeño. ¿Qué es?";
        acertijos[1][0]= "Húmedo por dentro, con pelos por fuera. Comienza por la C. ¿De qué se trata?";
        acertijos[2][0]= "Lo levanto cuando prometo, pero es más pequeño que el resto. ¿Qué es?";
        acertijos[3][0]= "Me ves en verano y no en invierno y estoy metido entre las manos, ya sea abierto o cerrado. ¿Qué soy?";
        acertijos[4][0]= "Las mujeres no la tienen, pero los hombres sí. Los toros tienen dos, igual que un obispo. ¿Qué soy?";
        acertijos[5][0]= "Estoy rodeado de pelos y estoy en el medio. Tengo una abertura que puedes ver que se abre y se cierra. ¿Qué soy?";
        acertijos[6][0]= "Aunque comience por la noche, termino prácticamente por la mañana. ¿Qué puedo ser?";
        acertijos[7][0]= "Parte del humano que tiene la capacidad de aumentar por 9 su tamaño. ¿Qué es?";
        acertijos[8][0]= "Todos lo llevan por delante, pero lo muestran con recelo. Tiene cabeza y agujas pero ningún pelo. ¿Qué es?";
        acertijos[9][0]= "¿Cuál es el instrumento que se mete y deja líquido dentro?";
        acertijos[10][0]= "Si una rata tiene una ametralladora, ¿qué puede hacer?";
        acertijos[11][0]= "Es largo y duro, lo utilizan hombres y mujeres y siempre da batalla. ¿Qué es?";
        acertijos[12][0]= "Es suave por dentro y peludo por fuera. Con un poco de esfuerzo, lo podrás meter dentro.";
        acertijos[13][0]= "Bolas grandes, colgantes, gordas y peludas que son voluminosas y hermosas. ¿Qué son?";
        acertijos[14][0]= "Cuando lo nombras ya no estará porque desaparece.";
        acertijos[15][0]= "¿Cómo se denomina a un perro con fiebre?";
        
        //Respuestas
        acertijos[0][1] = "Chicle.";
        acertijos[1][1]= "Coco";
        acertijos[2][1]= "Pulgar";
        acertijos[3][1]= "Abanico";
        acertijos[4][1]= "O";
        acertijos[5][1]= "Ojo";
        acertijos[6][1]= "N";
        acertijos[7][1]= "Pupila";
        acertijos[8][1]= "Reloj";
        acertijos[9][1]= "Jeringa";
        acertijos[10][1]= "Ratata";
        acertijos[11][1]= "Pistola";
        acertijos[12][1]= "Calcetin";
        acertijos[13][1]= "Cocos";
        acertijos[14][1]= "Silencio";
        acertijos[15][1]= "Hot dog";
        
        
        return acertijos;
    }
    
    private static boolean puzzle()
    {
        String acertijo [][] = crearAcertijo();
        
        Random r = new Random();
        
        int numero = r.nextInt(16);
        
        System.out.println("Responde a esta pregunta para avanzar:");
        
        String respuesta;
        
        do{
            System.out.println(acertijo[numero][0]);
            respuesta = Leer.dato();
            
            if(respuesta.equals(acertijo[numero][1]))//respuesta correcta
                System.out.println("Respuesta correcta!");
            else
                System.out.println("Respuesta incorrecta... Otra vez.");
            
        }while(!(respuesta.equals(acertijo[numero][1])));
        
        return true;
    }
    
    private static boolean comprobarMovimiento(int[] posicion, String respuesta)
    {
        switch(respuesta)
        {
            case "w":
            {
                if((posicion[0] - 1) < 0)
                    return false;
                break;
            }
            case "s":
            {
                if((posicion[0] + 1) > 3)
                    return false;
                break;
            }
            case "a":
            {
                if((posicion[1] - 1) < 0)
                    return false;
                break;
            }
            case "d":
            {
                if((posicion[1] + 1) > 3)
                    return false;
                break;
            }
        }
        return true;
    }
    
    private static int[] mover(String mansion[][], int[] aux)
    {
        int [] posicion = aux;
        String respuesta;
        int bandera = 0;
        
        while(true)
            if(puzzle()) //si acierto
            {
                do{
                    System.out.println("¿Hacia donde quieres moverte?");
                    respuesta = Leer.dato();
                    
                    //System.out.println(respuesta);
                    
                    if(!respuesta.equals("w") && !respuesta.equals("a") && !respuesta.equals("s") && !respuesta.equals("d"))
                        System.out.println("Debes introducir w/a/s/d para moverte.");
                    else
                    {
                        switch(respuesta)
                        {
                            case "w":
                            {
                                if(comprobarMovimiento(posicion, respuesta))
                                {
                                    posicion[0] = posicion[0] - 1; 
                                    System.out.println("Te has desplazado al norte.");
                                    bandera = 0;
                                    break;
                                }else
                                {
                                    System.out.println("Ese movimiento no es posible. Mira el mapa y piensa donde estas y a donde"
                                            + " puedes ir...");
                                    bandera = 1;
                                }
                            }

                            case "a":
                            {
                                if(comprobarMovimiento(posicion, respuesta))
                                {
                                    posicion[1] = posicion[1] - 1; 
                                    System.out.println("Te has desplazado al oeste.");
                                    bandera = 0;
                                    break;
                                }else
                                {
                                    System.out.println("Ese movimiento no es posible. Mira el mapa y piensa donde estas y a donde"
                                            + " puedes ir...");
                                    bandera = 1;
                                }
                            }

                            case "s":
                            {
                                if(comprobarMovimiento(posicion, respuesta))
                                {
                                    posicion[0] = posicion[0] + 1; 
                                    System.out.println("Te has desplazado al sur.");
                                    bandera = 0;
                                    break;
                                }else
                                {
                                    System.out.println("Ese movimiento no es posible. Mira el mapa y piensa donde estas y a donde"
                                            + " puedes ir...");
                                    bandera = 1;
                                }
                            }

                            case "d":
                            {
                                if(comprobarMovimiento(posicion, respuesta))
                                {
                                    posicion[1] = posicion[1] + 1; 
                                    System.out.println("Te has desplazado al este.");
                                    bandera = 0;
                                    break;
                                }else
                                {
                                    System.out.println("Ese movimiento no es posible. Mira el mapa y piensa donde estas y a donde"
                                            + " puedes ir...");
                                    bandera = 1;
                                }
                            }
                        }
                    }
                    
                }while((!respuesta.equals("w") && !respuesta.equals("a") && !respuesta.equals("s") && !respuesta.equals("d")) || bandera == 1);
                
                break;
            }
        
        return posicion;
    }
    
    private static boolean comprobarLugar(int[] posicion, String[][] mansion)
    {
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                if(mansion[i][j] == "O")
                {
                    if(posicion[0] == i && posicion[1] == j)
                        break;
                    else
                        return false;
                }
            }
        }
        
        return true;
    }
    
    private static boolean fantasma()
    {
        //Generar numeros random
        Random r = new Random();
        
        //Generar coincidencia
        int numero = r.nextInt(5);
        int numero2 = r.nextInt(5);
        
        if(numero == numero2)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        
        intro();
        
        String mansion[][] = crearMansion();
        pintarMansion(mansion);
        
        int posicion[] = buscarPosicion(mansion);
        int bandera = 0;

        while(true)
        {
            posicion = mover(mansion, posicion);
            
            System.out.println("Tu posición actual ahora es (" + (posicion[0] + 1)+ ", " + (posicion[1] + 1) + ").");
            
            if(fantasma())
            {
                System.out.println("️👻 Ha aparecido un fantasma! Debes acertar otra acertijo para seguir");
                
                while(bandera == 0)
                {
                    if(puzzle())
                    {
                        bandera = 1;
                    }else
                    {
                        System.out.println("Has fallado. Intentalo de nuevo...");
                    }
                }
            }
            
            if(comprobarLugar(posicion, mansion))//si he llegado a la salida
                break;
        }
        
        System.out.println("ESCAPASTE! \n\t THE END");
                 
    }
    
}
