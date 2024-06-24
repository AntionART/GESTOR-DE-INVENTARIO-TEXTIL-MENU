# Función para racionalizar el numerador o el denominador
def racionalizar(numerador, denominador):
    # Asumimos que las expresiones vienen en forma de listas de términos [(coef, exp), ...]
    import math
    def simplificar(expr):
        result = []
        for term in expr:
            if term[1] == 0:
                result.append(term)
            else:
                result.append((term[0], term[1]))
        return result

    # Multiplicar por el conjugado
    conjugado = [(term[0], -term[1]) if term[1] != 0 else term for term in numerador]
    numerador = simplificar([(term[0], term[1] * 2) for term in numerador])
    denominador = simplificar([(term[0], term[1] * 2) for term in denominador])
    
    return numerador, denominador

# Función para evaluar el límite utilizando racionalización
def limite_racionalizado(numerador, denominador, punto):
    num, den = racionalizar(numerador, denominador)
    lim_num = evaluar_polinomio(num, punto)
    lim_den = evaluar_polinomio(den, punto)
    if lim_den != 0:
        return lim_num / lim_den
    else:
        return "indeterminado"

# Función para evaluar un polinomio en un punto
def evaluar_polinomio(expr, x_val):
    resultado = 0
    for coef, exp in expr:
        resultado += coef * (x_val ** exp)
    return resultado

# Función principal que resuelve límites y muestra los pasos intermedios
def resolver_expresion(expr, punto):
    partes = expr.split('/')
    numerador = eval(partes[0].strip())
    denominador = eval(partes[1].strip())
    
    # Paso 1: Racionalizar
    num_racionalizado, den_racionalizado = racionalizar(numerador, denominador)
    print("Paso 1: Racionalización del numerador:")
    print("   Numerador:", num_racionalizado)
    print("   Denominador:", den_racionalizado)
    print()
    
    # Paso 2: Evaluar en el punto dado
    lim_num = evaluar_polinomio(num_racionalizado, punto)
    lim_den = evaluar_polinomio(den_racionalizado, punto)
    print("Paso 2: Evaluación en el punto x =", punto)
    print("   Límite Numerador:", lim_num)
    print("   Límite Denominador:", lim_den)
    print()
    
    # Paso 3: Calcular el límite
    if lim_den != 0:
        resultado = lim_num / lim_den
        print("Paso 3: Calcular el límite")
        print("   Límite:", resultado)
        return resultado
    else:
        print("Paso 3: Calcular el límite")
        print("   Límite: indeterminado")
        return "indeterminado"

def main():
    # El usuario ingresa la expresión
    expr = input("Ingresa la expresión (sin límite ni punto de límite): ")
    punto = float(input("Ingresa el punto de límite (x→): "))

    # Resolver la expresión
    print("Resolución paso a paso:")
    resultado = resolver_expresion(expr, punto)
    print("Resultado:", resultado)

main()
