package combate.naval;

import java.util.Scanner;

public class Juego {
    public Tablero jugador1;
    public Tablero jugador2;
    
    Scanner sc = new Scanner(System.in);
    
    private int fila, columna;
    private boolean findelJuego;

    public void Juego(){
        findelJuego = false;
    }
 
    public void IniciarJuego(){
        jugador1 = new Tablero();
        jugador2 = new Tablero();
        
        Posicionamiento();
        Ciclo_juego();
    }
    
    public void Posicionamiento(){
 
        System.out.println("Para el jugador 1");
        Seleccionar_posicion(2,jugador1);
        Seleccionar_posicion(1,jugador1);
        Seleccionar_posicion(1,jugador1);
        Seleccionar_posicion(jugador1);
        Seleccionar_posicion(jugador1);
        Seleccionar_posicion(jugador1);
        jugador1.Mostrar();
        System.out.println("Para el jugador 2");
        Seleccionar_posicion(2,jugador2);
        Seleccionar_posicion(1,jugador2);
        Seleccionar_posicion(1,jugador2);
        Seleccionar_posicion(jugador2);
        Seleccionar_posicion(jugador2);
        Seleccionar_posicion(jugador2);
        jugador2.Mostrar();
    }
    
    public void Ciclo_juego(){
        
        boolean turno = true;
        boolean ataque;
        do{
            
            if(turno){
                System.out.println("Turno Jugador 1");
                do{

                    System.out.println("Ingrese un valor para la Fila entre 1 y 10: ");
                    fila = verificar_valor();
                    System.out.println("Ingrese un valor para la Columna entre 1 y 10: ");
                    columna = verificar_valor();
                    ataque = jugador2.Ataque(fila, columna);
                    jugador2.VerificarTablero();
                    if(jugador2.pierde_jugador) ataque = false;
                }while(ataque);

                turno = false; 
                jugador2.Mostrar();
            }
            else{
                System.out.println("Turno Jugador 2");
                do{
                    System.out.println("Ingrese un valor para Fila entre 1 y 10");
                    fila = verificar_valor();
                    System.out.println("Ingrese un valor para Columna entre 1 y 10");
                    columna = verificar_valor();
                    ataque = jugador1.Ataque(fila, columna);
                    jugador1.VerificarTablero();
                    if(jugador1.pierde_jugador) ataque = false;
                }while(ataque);
                turno = true;
                jugador1.Mostrar();
            }
            
            if(jugador1.pierde_jugador == true){
                System.out.println("Jugador 1 Pierde");
                findelJuego = true;
            }
            if(jugador2.pierde_jugador == true){
                System.out.println("Jugador 2 Pierde");
                findelJuego = true;
            }
        }while(!findelJuego);
        System.out.println("Partida Finalizada");
    }
    
    public int verificar_valor(){
        int numValue;
        do{
            numValue = sc.nextInt();
            if(numValue >10 || numValue <1)
                System.out.println("Valor no valido, intente nuevamente");
        }while(numValue >10 || numValue <1);
        numValue--;
        return numValue;
    }

    public boolean Orientacion(){
        System.out.println("Seleccione una orientación para el barco");
        System.out.println("1 para Horizontal, 2 para vertical");
        switch(sc.nextInt()){
            case 1:
                return false;
            case 2:
                return true;
            default:
                return false;
        }
    }

    public void Seleccionar_posicion(int largoBarco, Tablero Player){
        boolean errorAlColocar, orientacion;
        System.out.println("Ingrese Coordenadas para el Barco de tamaño " + (largoBarco+1));
        Player.Mostrar();
        do{
            System.out.println("Ingrese un valor para Fila entre 1 y 10: ");
            fila = verificar_valor();
            System.out.println("Ingrese un valor para Columna entre 1 y 10: ");
            columna = verificar_valor();
            orientacion = Orientacion();
            errorAlColocar = Player.Insertar_barco(fila, columna, largoBarco, orientacion);
            if(!errorAlColocar) System.out.println("Intente Nuevamente");
        }while(!errorAlColocar);
    }

    public void Seleccionar_posicion(Tablero Player){
        boolean errorAlColocar;
        System.out.println("Ingrese Coordenadas para el Barco de tamaño 1");
        Player.Mostrar();
        do{
            System.out.println("Ingrese un valor para Fila entre 1 y 10: ");
            fila = verificar_valor();
            System.out.println("Ingrese un valor para Columna entre 1 y 10: ");
            columna = verificar_valor();
            errorAlColocar = Player.Insertar_barco(fila, columna);
            if(!errorAlColocar) System.out.println("Intente Nuevamente");
        }while(!errorAlColocar);
    }
}
