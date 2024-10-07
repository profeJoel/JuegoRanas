class Rana:
    def __init__(self, color:str, sentido:str):
        self.color = color
        self.sentido = sentido
        
    def get_sentido(self):
        return self.sentido
    
    def va_para(self, sentido:str):
        return self.sentido == sentido
    
    def __str__(self) -> str:
        return self.sentido