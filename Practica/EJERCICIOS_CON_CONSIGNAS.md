# EJERCICIOS PRÁCTICOS CON CONSIGNAS

---

## EJERCICIO 1: Implementar una Pila Simple con ArrayList

**Consigna:**
Crea una clase `Pila` que implemente una estructura LIFO (Last In, First Out) usando ArrayList. 
Debe tener los siguientes métodos:
- `push(int elemento)` - Agregar elemento al tope
- `pop()` - Remover y retornar el elemento del tope
- `peek()` - Ver el elemento del tope sin remover
- `isEmpty()` - Verificar si la pila está vacía
- `tamaño()` - Retornar la cantidad de elementos

**Requisitos:**
- Evitar UNDERFLOW (verificar si está vacía antes de pop)
- Mostrar mensaje de error si ocurre underflow

**Ejemplo de uso:**
```java
Pila p = new Pila();
p.push(10);
p.push(20);
p.push(30);
System.out.println(p.pop()); // Debe imprimir: 30
System.out.println(p.tamaño()); // Debe imprimir: 2
p.pop(); // Remueve 20
p.pop(); // Remueve 10
p.pop(); // ERROR: UNDERFLOW
```

---

## EJERCICIO 2: Crear una Pila Dinámica con Nodos

**Consigna:**
Implementa una pila usando **nodos enlazados** (LinkedList manual). 
Debe incluir:

**Clase Nodo:**
- Atributo `dato` (int)
- Atributo `siguiente` (referencia al siguiente nodo)
- Constructor

**Clase PilaDinamica:**
- `push(int valor)` - Agregar al tope
- `pop()` - Remover del tope (retornar valor o -1 si error)
- `mostrar()` - Imprimir todos los elementos de arriba hacia abajo
- `estaVacia()` - Retornar true si está vacía

**Requisitos:**
- Evitar UNDERFLOW
- Complejidad O(1) en push y pop

**Ejemplo:**
```java
PilaDinamica pila = new PilaDinamica();
pila.push(5);
pila.push(15);
pila.push(25);
pila.mostrar(); // Salida: 25 -> 15 -> 5
System.out.println(pila.pop()); // 25
pila.mostrar(); // Salida: 15 -> 5
```

---

## EJERCICIO 3: Mejorar la clase Impresora (Cola Optimizada)

**Consigna:**
Modifica la clase `Impresora` usando **LinkedList** en lugar de ArrayList 
para que `imprimirDocumento()` sea **O(1)** en lugar de **O(n)**.

**Cambios requeridos:**
- Cambiar `ArrayList<Documento>` por `LinkedList<Documento>`
- El método `agregarDocumento()` sigue siendo O(1)
- El método `imprimirDocumento()` ahora será O(1)
- Mantener el método `mostrarCola()`

**Bonus:** Agregar un método `tamanoCola()` que retorne la cantidad de documentos pendientes.

**Comparación de complejidad:**
```
ArrayList:   agregarDocumento() = O(1) | imprimirDocumento() = O(n)
LinkedList:  agregarDocumento() = O(1) | imprimirDocumento() = O(1)
```

---

## EJERCICIO 4: Invertir una Pila

**Consigna:**
Crea un método `invertirPila()` que reciba una Pila y retorne una nueva 
pila con los elementos invertidos (sin modificar la original).

**Método:**
```java
public static Pila invertirPila(Pila original) {
    // Tu código aquí
}
```

**Requisitos:**
- NO modificar la pila original
- Crear una nueva pila invertida
- Usar push() y pop()

**Ejemplo:**
```java
Pila p = new Pila();
p.push(1);
p.push(2);
p.push(3);

Pila invertida = invertirPila(p);
invertida.mostrar(); // 1 -> 2 -> 3
p.mostrar();         // 3 -> 2 -> 1 (sin cambios)
```

---

## EJERCICIO 5: Detector de Paréntesis Balanceados

**Consigna:**
Crea un método que verifique si una cadena tiene paréntesis/corchetes/llaves 
correctamente balanceados usando una **pila**.

**Método:**
```java
public static boolean estanBalanceados(String expresion) {
    // Tu código aquí
}
```

**Requisitos:**
- Validar: `()`, `[]`, `{}`
- Retornar `true` si están balanceados, `false` si no
- Usar una Pila para validar

**Ejemplos:**
```java
estanBalanceados("(a + b)");           // true
estanBalanceados("([{}])");            // true
estanBalanceados("(a + b");            // false
estanBalanceados("[([)]");             // false (intercalados)
estanBalanceados("((()))");            // true
```

---

## EJERCICIO 6: Cola de Impresión con Prioridad

**Consigna:**
Extiende la clase `Documento` agregando un atributo `prioridad` (1-5, donde 5 es máxima).
Crea una `Cola con Prioridad` que imprima primero los documentos de mayor prioridad.

**Modificaciones:**
1. Agregar `prioridad` a la clase `Documento`
2. Crear método `agregarDocumentoConPrioridad()` que inserte en la posición correcta
3. El primero en ser impreso es el de mayor prioridad

**Ejemplo:**
```java
Documento d1 = new Documento("Reporte", 5, 2);     // prioridad 2
Documento d2 = new Documento("Carta", 3, 5);       // prioridad 5
Documento d3 = new Documento("Memo", 2, 1);        // prioridad 1

agregarDocumentoConPrioridad(cola, d1); // [d1]
agregarDocumentoConPrioridad(cola, d2); // [d2, d1]
agregarDocumentoConPrioridad(cola, d3); // [d2, d1, d3]

imprimirDocumento(cola); // Imprime d2 (prioridad 5)
imprimirDocumento(cola); // Imprime d1 (prioridad 2)
```

---

## EJERCICIO 7: Análisis de Complejidad

**Consigna:**
Analiza el siguiente código y determina su complejidad Big O:

```java
public void procesarDocumentos(ArrayList<Documento> cola) {
    // Línea 1
    for (int i = 0; i < cola.size(); i++) {
        // Línea 2
        Documento temp = cola.get(i);
        // Línea 3
        for (int j = i + 1; j < cola.size(); j++) {
            // Línea 4
            if (temp.getPags() < cola.get(j).getPags()) {
                // Línea 5
                Documento aux = cola.get(i);
                cola.set(i, cola.get(j));
                cola.set(j, aux);
            }
        }
    }
    // Línea 6
    mostrarCola(cola);
}
```

**Preguntas:**
1. ¿Cuál es la complejidad del bucle anidado (Línea 1-5)?
2. ¿Cuál es la complejidad de `mostrarCola()`?
3. ¿Cuál es la complejidad TOTAL de la función?
4. ¿Qué operación realiza este código? (Hint: algoritmo de ordenamiento)
5. ¿Es eficiente para 1 millón de documentos? Explica.

**Respuestas esperadas:**
1. O(n²)
2. O(n)
3. O(n²)
4. Bubble Sort
5. No, es muy lento. Se recomienda Quick Sort, Merge Sort (O(n log n))

---

## EJERCICIO 8: Validador de Expresiones Matemáticas

**Consigna:**
Crea un método que valide si una expresión matemática tiene los operadores 
correctos usando una **pila** para verificar operandos y operadores.

**Método:**
```java
public static boolean esExpresionValida(String expr) {
    // Tu código aquí
}
```

**Requisitos:**
- Verificar que hay operando antes y después de cada operador
- Validar: `+`, `-`, `*`, `/`
- Números pueden ser de varios dígitos
- Espacios pueden ignorarse

**Ejemplos:**
```java
esExpresionValida("5 + 3 * 2");        // true
esExpresionValida("10 * 2");           // true
esExpresionValida("+ 5");              // false (operador sin operando izq)
esExpresionValida("5 +");              // false (operador sin operando der)
esExpresionValida("5 + 3 +");          // false
```

---

## RESUMEN DE COMPETENCIAS A EVALUAR

| Ejercicio | Tema | Complejidad |
|-----------|------|-------------|
| 1 | Pila con ArrayList | ⭐⭐ |
| 2 | Pila Dinámica con Nodos | ⭐⭐⭐ |
| 3 | Optimización con LinkedList | ⭐⭐ |
| 4 | Manipulación de Pilas | ⭐⭐ |
| 5 | Paréntesis Balanceados | ⭐⭐⭐ |
| 6 | Cola con Prioridad | ⭐⭐⭐ |
| 7 | Análisis Big O | ⭐⭐⭐⭐ |
| 8 | Validación de Expresiones | ⭐⭐⭐ |

---

## TIPS PARA RESOLVER:

✅ Lee bien cada consigna antes de empezar
✅ Implementa primero, luego optimiza
✅ Prueba con varios ejemplos
✅ Verifica casos especiales (vacío, un elemento, etc.)
✅ Comenta tu código
✅ Analiza complejidad cuando termines

