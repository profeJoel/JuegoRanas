from Jugador import Jugador
from Laguna import Laguna


if __name__ == "__main__":
    print("Bienvenido al Juego de Ranas\nIngrese su nombre: ")
    jugador1 = Jugador(input())
    laguna = Laguna(jugador1)
    
    laguna.comenzar_juego()
    
    print("Juego terminado, Gracias por jugar!")