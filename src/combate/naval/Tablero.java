package combate.naval;


public class Tablero {
    public char matriz[][];
    public boolean pierde_jugador;
    
    public Tablero(){
        matriz = new char[10][10];
        pierde_jugador = false;
        PintarMatriz();
    }

    public void Mostrar(){
        System.out.print("\t");
        for (int i=0;i<10;i++){
            System.out.print((i + 1) + " ");
        }
        System.out.println("");
        for (int i=0;i<10;i++){
            System.out.print((i+1) + "\t");
            for (int j=0;j<10;j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    private void PintarMatriz(){
        for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                matriz[i][j] = '.';
            }
        }
    }
    
    public boolean Insertar_barco(int x, int y){
        if(matriz[x][y]=='B'){
            System.out.println("Ya hay un barco en la coordenada dada");
            return false;
        }
        else{
            matriz[x][y] = 'B';
            return true;
        }
    }

    public boolean Insertar_barco(int x, int y, int tamano, boolean isVertical){
        if(isVertical == true){
            if((x + tamano) < 10){
                for(int i = 0;i<=tamano;i++){
                    if(matriz[x+i][y]=='B'){
                        System.out.println("Ya hay un barco en la coordenada dada");
                        return false;
                    }
                }
                for(int i =0;i<=tamano;i++){
                    matriz[x+i][y] = 'B';
                }
                    return true;
            }
            else{
                System.out.println("El barco se sale del tablero");
                return false;
            }
        }
        else{
            if((y + tamano) < 10){
                for(int i = 0;i<=tamano;i++){
                    if(matriz[x][y+i]=='B'){
                        System.out.println("Ya hay un barco en la coordenada dada");
                        return false;
                    }
                }
                for(int i =0;i<=tamano;i++){
                    matriz[x][y+i] = 'B';
                }
                    return true;
            }
            else{
                System.out.println("El barco se sale del tablero");
                return false;
            }
        }
    }

    public boolean Ataque(int x, int y){
        if(matriz[x][y]=='B'){
            matriz[x][y] = '*';
            System.out.println("Barco impactado, vuelva a disparar");
            return true;
        }
        else{
            System.out.println("Falló el disparo");
            return false;
        }
    }
    
    public void VerificarTablero(){
        int contador = 0;
        for(int i = 0; i<10;i++){
            for(int j = 0; j<10;j++){
                if(matriz[i][j]=='B'){
                    contador++;
                }
            }
        }
        if(contador == 0){
            System.out.println("Toda la flota ha sido hundida");
            this.pierde_jugador = true;
        }
        else{
            System.out.println(this.pierde_jugador);
            this.pierde_jugador = false;
        }
    }
}
