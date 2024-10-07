from Rana import Rana
from Jugador import Jugador

class Laguna:
    
    def __init__(self, jugador:Jugador):
        self.jugador = jugador
        self.rana = [Rana] * 7
        self.rana[0] = Rana("v", ">")
        self.rana[1] = Rana("v", ">")
        self.rana[2] = Rana("v", ">")
        self.rana[3] = Rana("-", "-")
        self.rana[4] = Rana("r", "<")
        self.rana[5] = Rana("r", "<")
        self.rana[6] = Rana("r", "<")
        
    def comenzar_juego(self):
        while not self.hay_ganador() and not self.sin_movimientos():
            self.mostrar_rocas()
            self.mover_rana()
            
        self.mostrar_rocas()
        if self.hay_ganador():
            print("Felicidades!!! " + self.jugador.get_nombre() + " has logrado finalizar el juego")
        else:
            print("Has perdido!!! " + self.jugador.get_nombre() + " sigue intentando...")
    
    def hay_ganador(self):
        if not self.rana[0].va_para("<"): return False
        if not self.rana[1].va_para("<"): return False
        if not self.rana[2].va_para("<"): return False
        if not self.rana[3].va_para("-"): return False
        if not self.rana[4].va_para(">"): return False
        if not self.rana[5].va_para(">"): return False
        if not self.rana[6].va_para(">"): return False
        
        return True
    
    def sin_movimientos(self):
        for i in range(7):
            if not self.rana_tiene_movimiento(i): return False
        return True
    
    def rana_tiene_movimiento(self, i:int):
        
        if self.rana[i].va_para("<") and ((i>=2 and (self.rana[i-1].va_para("-") or self.rana[i-2].va_para("-"))) or (i == 1 and self.rana[i-1].va_para("-")) or i== 0): 
            return True
        
        if self.rana[i].va_para(">") and ((i>=4 and (self.rana[i+1].va_para("-") or self.rana[i+2].va_para("-"))) or (i == 5 and self.rana[i+1].va_para("-")) or i==6): 
            return True
        if self.rana[i].va_para("-"):
            return True
        
        return False
    
    def mostrar_rocas(self):
        print("\n***********************\nEstado del Juego: ")
        for rana in self.rana:
            print(rana, end=" ")
        print("")
        for i in range(7):
            print(i, end=" ")
        print("\n***********************\n")
        
    def mover_rana(self):
        r = self.jugador.escoger_rana()
        m = self.jugador.escoger_movimiento(self.rana[r], r)
        while not self.verificar_movimiento_valido(r,m):
            r = self.jugador.escoger_rana()
            m = self.jugador.escoger_movimiento(self.rana[r], r)
            
        auxiliar = self.rana[m]
        self.rana[m] = self.rana[r]
        self.rana[r] = auxiliar
        
    def verificar_movimiento_valido(self, rana:int, movimiento:int):
        return ((movimiento == rana + 1 or movimiento == rana +2) or (movimiento == rana - 1 or movimiento == rana - 2)) and self.rana[movimiento].va_para("-")
            