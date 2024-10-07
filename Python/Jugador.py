from Rana import Rana

class Jugador:
    
    def __init__(self, nombre:str):
        self.nombre = nombre
        
    def get_nombre(self):
        return self.nombre
    
    def escoger_rana(self):
        print("Indique la rana para saltar [0-6]:")
        rana = int(input())
        if rana < 0 or rana > 6:
            rana = self.escoger_rana()
        return rana
    
    def escoger_movimiento(self, rana:Rana, posicion:int):
        print("Indique: \n - 1 si la rana hace salto simple, o \n - 2 si la rana hace salto doble.")
        salto = int(input())
        while salto < 1 or salto > 2:
            print("Indique: \n - 1 si la rana hace salto simple, o \n - 2 si la rana hace salto doble.")
            salto = int(input())
        
        if rana.va_para(">"):
            return posicion + salto
        if rana.va_para("<"):
            return posicion - salto
        
        return -1
            