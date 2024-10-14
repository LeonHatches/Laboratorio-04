	
	import java.util.*;
	public class DemoBatalla
	{
            static Scanner sc = new Scanner (System.in);
	    public static void main (String [] args)
	    {
	        Nave [] misNaves = new Nave[5];
	        
	        String  nomb, col;
	        int     fil, punt;
	        boolean est;
	
	        // Entrada para las 10 naves y centro de metodos
	        for (int i = 0; i < misNaves.length; i++)
	        {
	        	// Entrada de datos
	            System.out.println("\t| NAVE " + (i+1)+"|");
	            System.out.print("Nombre: ");
	            nomb = sc.next();
	            System.out.print("Fila: ");
	            fil = sc.nextInt();
	            System.out.print("Columna: ");
	            col = sc.next();
	            System.out.print("Estado: ");
	            est = sc.nextBoolean();
	            System.out.print("Puntos: ");
	            punt = sc.nextInt();
	            
	            System.out.println ();
	
	            //Se crea un objeto Nave y se asigna su referencia a misNaves
	            misNaves[i] = new Nave();
	            	
	            // Asignacion de datos en el respectivo objeto
	            misNaves[i].setNombre(nomb);
	            misNaves[i].setFila(fil);
	            misNaves[i].setColumna(col);
	            misNaves[i].setEstado(est);
	            misNaves[i].setPuntos(punt);
	        }
	
	        // Mostrar
	        System.out.println("\n\t| NAVES CREADAS |");
	        mostrarNaves     (misNaves);
	        mostrarPorNombre (misNaves);
	        mostrarPorPuntos (misNaves);
	        
	        // Mayor nave segun puntos
	        System.out.println("\nNave con mayor numero de puntos:\n"+mostrarMayorPuntos(misNaves)+"\n");
	    
	        // Leer nombre
        	String nombre = ingresarNombre();
        	
            //mostrar los datos de la nave con dicho nombre,
        	//mensaje de “no encontrado” en caso contrario
            int pos = busquedaLinealNombre(misNaves, nombre);
            mostrarUna (misNaves, pos, nombre);
            
            // Ordenamiento BURBUJA POR PUNTOS
            ordenarPorPuntosBurbuja (misNaves);
            mostrarNaves            (misNaves);
            
            // Ordenamiento BURBUJA POR A - Z
            ordenarPorNombreBurbuja (misNaves);
            mostrarNaves            (misNaves);
            
            // Leer nombre
        	nombre = ingresarNombre();
        	
            // Mostrar los datos de la nave con dicho nombre,
            // mensaje de “no encontrado” en caso contrario.
            pos=busquedaBinariaNombre(misNaves, nombre);
            mostrarUna (misNaves, pos, nombre);
            
            // Ordenamiento SELECCION POR PUNTOS
            ordenarPorPuntosSeleccion(misNaves); 
            mostrarNaves(misNaves);
            
            // Ordenamiento SELECCION POR NOMBRE
            ordenarPorNombreSeleccion(misNaves); 
            mostrarNaves(misNaves);
            
            // Ordenamiento INSERCION POR PUNTOS
            ordenarPorPuntosInsercion(misNaves); 
            mostrarNaves(misNaves);
            
            // Ordenamiento INSERCION POR NOMBRE
            ordenarPorNombreInsercion(misNaves); 
            mostrarNaves(misNaves);             
	    }
	    
	    //Leer un nombre
        public static String ingresarNombre()
        {	
            System.out.print("\t| BUSQUEDA |\nIngrese un nombre a buscar: ");
            return sc.next();
        }
        
        // Metodo que muestra una sola nave o no si no existe    
        public static void mostrarUna(Nave [] flota, int pos, String n)
        {
        	if (pos == -1)
                System.out.println("No se encontró la nave.\n");
            else
                System.out.println("| NAVE CON EL NOMBRE : "+n+" |\n"+flota[pos]+"\n");
        }
        
	    // Método para mostrar todas las naves
	    public static void mostrarNaves (Nave [] flota)
	    {
	            for (int i = 0 ; i < flota.length ; i++)
	                System.out.println("\t| NAVE "+(i+1)+" |\n"+flota[i]+"\n");
	    }
	
	    // Método para mostrar todas las naves de un nombre que se pide por teclado
	    public static void mostrarPorNombre (Nave [] flota)
	    {
	        System.out.println ("| TODAS LAS NAVES POR NOMBRE INGRESADO |");
	        System.out.print ("Ingrese nombre: ");
	        String nombre = sc.next();
	        
	        for (int i = 0 ; i < flota.length ; i++)
	        {
	        	if ( flota[i].getNombre().equals( nombre ) )
	        		 System.out.println("| NAVE ENCONTRADA |\n"+flota[i]+"\n");
	        }
	        
	        System.out.println ();
	    }
	
	    // Método para mostrar todas las naves con un número de puntos inferior o igual
	    // al número de puntos que se pide por teclado
	    public static void mostrarPorPuntos (Nave [] flota)
	    {
	        Scanner sc = new Scanner(System.in);
	        
	        System.out.println ("| TODAS LAS NAVES SEGUN PUNTOS |");
	        System.out.print ("Ingrese un maximo de puntos: ");
	        int puntos = sc.nextInt();
	
	        for (int i = 0 ; i < flota.length ; i++)
	        {
	            if (flota[i].getPuntos() <= puntos)
	                System.out.println("\t| NAVE "+(i+1)+" |\n"+flota[i]+"\n");
	        }
	    }
	
	    // Método que devuelve la Nave con mayor número de Puntos
	    public static Nave mostrarMayorPuntos(Nave [] flota)
	    {
	        int index = 0;
	        for (int i = 1 ; i < flota.length ; i++)
	        {
	            if (flota[index].getPuntos() < flota[i].getPuntos())
	                index = i;
	        }
	        return flota[index];
	    }
	    
	    //Método para buscar la primera nave con un nombre que se pidió por teclado
        public static int busquedaLinealNombre(Nave[] flota, String s)
        {
        	System.out.println ("| BUSQUEDA LINEAL |");
            for (int i = 0 ; i < flota.length ; i++)
            {
                 if ( s.equals( flota [i].getNombre() ) )
                     return i;
            }
            return -1;
        }
            
        //Método que ordena por número de puntos de menor a mayor
        public static void ordenarPorPuntosBurbuja(Nave[] flota)
        {
            Nave intercambio;
            System.out.println ("| ORDENAMIENTO BURBUJA MENOR A MAYOR |");
            
            // Siendo un "i" las iteraciones y el maximo posible despues de cada
            // pasada, se establece este algoritmo
            for (int i = flota.length - 1 ; i > 0 ; i--)
                for (int n = 0 ; n < i ; n++)
                {
                    if ( flota[n].getPuntos() > flota[n+1].getPuntos() )
                    {
                        intercambio = flota[n];
                        flota[n]    = flota[n+1];
                        flota[n+1]  = intercambio;
                    }
                }
        }
            
        //Método que ordena por nombre de A a Z 
        public static void ordenarPorNombreBurbuja(Nave[] flota)
        {
            Nave intercambio;
            System.out.println ("| ORDENAMIENTO BURBUJA A - Z |");
            
            // Siendo un "i" las iteraciones y el maximo posible despues de cada
            // pasada, se establece este algoritmo
            for (int i = flota.length - 1 ; i > 0 ; i--)
                for (int n = 0 ; n < i ; n++)
                {
                	int valor = flota[n].getNombre().compareTo(flota[n+1].getNombre());
                    if ( valor > 0 )
                    {
                        intercambio = flota[n];
                        flota[n]    = flota[n+1];
                        flota[n+1]  = intercambio;
                    }
                }
        }
            
        //Método para buscar la primera nave con un nombre que se pidió por teclado
        public static int busquedaBinariaNombre(Nave[] flota, String s)
        {
        	int bajo = 0, media, alto = flota.length - 1;
    		
        	System.out.println ("| BUSQUEDA BINARIA - NOMBRE |");
    		while (bajo <= alto)
    		{
    			media = (alto + bajo)/2;
    			
    			int valor = s.compareTo( flota[media].getNombre() );
    			
    			if		(valor == 0) return media;
    			else if (valor  > 0) bajo = media + 1;
    			else				 alto = media - 1;
    		}
    		return -1;
        }
            
        //Método que ordena por número de puntos de menor a mayor
        public static void ordenarPorPuntosSeleccion(Nave[] flota)
        { 
        	int menor = 0;
        	Nave intercambio;
    		
        	System.out.println ("| ORDENAMIENTO SELECCION POR PUNTOS |");
    		//ITERACIONES
    		for (int i = 0 ; i < flota.length-1 ; i++)
    		{
    			menor = i;
    			//RECORRIDO (La "i" como inicio, actualizado en cada iteracion)
    			for (int r = i+1 ; r < flota.length ; r++)
    			{
    				if ( flota[menor].getPuntos() > flota[r].getPuntos() )
    					menor = r;
    			}
    			
    			// INTERCAMBIO
    			 intercambio = flota[menor];
    			flota[menor] = flota    [i];
    			flota    [i] =  intercambio;
    		}
        }
        
        //Método que ordena por nombre de A a Z 
        public static void ordenarPorNombreSeleccion(Nave[] flota)
        { 
        	int menor;
        	Nave intercambio;
    		
        	System.out.println ("| ORDENAMIENTO SELECCION A - Z |");
    		//ITERACIONES
    		for (int i = 0 ; i < flota.length-1 ; i++)
    		{
    			menor = i;
    			//RECORRIDO (La "i" como inicio, actualizado en cada iteracion)
    			for (int r = i+1 ; r < flota.length ; r++)
    			{
    				int valor = flota[menor].getNombre().compareTo( flota[r].getNombre() );
    				if ( valor > 0 )
    					menor = r;
    			}
    			
    			// INTERCAMBIO
    			 intercambio = flota[menor];
    			flota[menor] = flota    [i];
    			flota    [i] =  intercambio;
    		}
        }
        
        //Método que muestra las naves ordenadas por número de puntos de mayor a menor 
        public static void ordenarPorPuntosInsercion(Nave[] flota)
        { 
        	Nave intercambio;
    		
        	System.out.println ("| ORDENAMIENTO INSERCION POR PUNTOS |");
    		// ITERACIONES
    		for (int i = 1 ; i < flota.length ; i++)
    		{
    			// RECORRIDO (Con deteccion de recorridos innecesarios)
    			for (int r = i ; r > 0 && flota[r-1].getPuntos() < flota[r].getPuntos() ; r--)
    			{
    				intercambio = flota [r-1];
    				flota [r-1] = flota   [r];
    				flota   [r] = intercambio;
    			}
    		}
        }
        
        //Método que muestra las naves ordenadas por nombre de Z a A 
        public static void ordenarPorNombreInsercion(Nave[] flota)
        { 
        	Nave intercambio;
    		
        	System.out.println ("| ORDENAMIENTO INSERCION A - Z |");
    		// ITERACIONES
    		for (int i = 1 ; i < flota.length ; i++)
    		{
    			// RECORRIDO (Con deteccion de recorridos innecesarios)
    			for
    			(
    				int r = i ;
    					r > 0 && flota[r-1].getNombre().compareTo( flota[r].getNombre() ) < 0;
    					r--
    			)
    			{
    				
    				intercambio = flota [r-1];
    				flota [r-1] = flota   [r];
    				flota   [r] = intercambio;
    			}
    		}
        }
	}
	
	