# RetosAlgoritmos - Kit de Referencia Rápida

Este proyecto contiene implementaciones de los algoritmos clave que necesitarás durante tus retos de programación.

## 📁 Estructura del Proyecto

```
RetosAlgoritmos/
├── src/
│   ├── **recursividad/** - Ejemplos de recursividad
│   │   ├── Factorial.java - Cálculo de factorial (CASO BASE y RECURSIVO)
│   │   └── FractalSierpinski.java - Fractal recursivo
│   │
│   ├── **backtracking/** - Algoritmo de backtracking
│   │   ├── Laberinto.java - Estructura de datos del laberinto
│   │   └── SolucionadorLaberinto.java - Algoritmo de backtracking
│   │
│   ├── **busqueda/** - Algoritmos de búsqueda
│   │   └── AlgoritmosBusqueda.java - Búsqueda lineal y binaria
│   │
│   ├── **deque/** - Cola de doble extremo
│   │   ├── Nodo.java - Nodo para lista doblemente enlazada
│   │   └── Deque.java - Implementación de Deque
│   │
│   ├── **colasdeprioridad/** - Colas con prioridad
│   │   ├── Elemento.java - Estructura de elemento con prioridad
│   │   └── ColaPrioridad.java - Implementación de cola de prioridad
│   │
│   └── **Main.java** - Punto de entrada con demostraciones de todos los algoritmos
```

## 🚀 Cómo Usar

### 1. **Compilar el Proyecto**
```bash
cd RetosAlgoritmos
javac -d . src/**/*.java src/*.java
```

### 2. **Ejecutar la Demostración Completa**
```bash
java Main
```

### 3. **Ejecutar Algoritmos Específicos**

#### Recursividad - Factorial
```bash
java recursividad.Factorial
```

#### Recursividad - Fractal de Sierpinski
```bash
java recursividad.FractalSierpinski
```

#### Backtracking - Solucionador de Laberintos
```bash
java backtracking.SolucionadorLaberinto
```

#### Búsqueda Lineal y Binaria
```bash
java busqueda.AlgoritmosBusqueda
```

#### Deque (Cola de Doble Extremo)
```bash
java deque.Deque
```

#### Cola de Prioridad
```bash
java colasdeprioridad.ColaPrioridad
```

## 🎯 Resumen de Algoritmos y Complejidades

### 1. **Recursividad**
- **Factorial**: O(n) - Caso base: n == 0
- **Sierpinski**: O(3^n) - Fractal recursivo con 3 llamadas recursivas por nivel

### 2. **Backtracking**
- **Solucionador de Laberintos**: O(n*m) donde n y m son dimensiones del laberinto
- Explora recursivamente hasta encontrar la salida
- Retrocede cuando llega a un callejón sin salida

### 3. **Búsqueda**
- **Búsqueda Lineal**: O(n) - Útil para arrays desordenados
- **Búsqueda Binaria**: O(log n) - Requiere array ordenado, más rápida

### 4. **Deque (Double-Ended Queue)**
- **Agregar/Remover del frente**: O(1)
- **Agregar/Remover del final**: O(1)
- Implementación: Lista doblemente enlazada

### 5. **Cola de Prioridad**
- **Encolar**: O(n) (inserta en orden)
- **Desencolar**: O(1) (obtiene el elemento con mayor prioridad)
- Implementación simple con ArrayList ordenado

## 💡 Consejos para la Prueba

1. **Copiar y Pegar Rápido**: Los métodos están diseñados para ser fáciles de copiar
2. **Métodos Estáticos**: La mayoría de métodos son estáticos para rápido acceso
3. **Sin Dependencias Externas**: Todo usa solo Java estándar
4. **Bien Comentado**: Cada algoritmo explica claramente el caso base y recursivo

## 🔧 Ejemplos de Uso Rápido

### Factorial
```java
long resultado = Factorial.calcular(5); // 120
```

### Búsqueda Binaria
```java
int[] array = {10, 20, 30, 40, 50};
int[] resultado = AlgoritmosBusqueda.busquedaBinaria(array, 30);
System.out.println("Índice: " + resultado[0]); // 2
System.out.println("Pasos: " + resultado[1]); // 2
```

### Deque
```java
Deque<Integer> deque = new Deque<>();
deque.agregarFrente(10);
deque.agregarFin(20);
int valor = deque.removerFrente(); // 10
```

### Cola de Prioridad
```java
ColaPrioridad<String> pq = new ColaPrioridad<>();
pq.encolar("Tarea urgente", 5);
pq.encolar("Tarea normal", 1);
Elemento<String> siguiente = pq.desencolar(); // "Tarea urgente"
```

## Notas Importantes

- **Backtracking**: Solo resuelve laberintos simples. Para laberintos complejos, ajusta `crearLaberintoDePrueba()`
- **Cola de Prioridad**: Mayor número = Mayor prioridad
- **Deque**: Implementación manual sin usar `java.util.Deque`
- **Búsqueda Binaria**: Requiere array ORDENADO

---

Buena suerte en tu prueba!

