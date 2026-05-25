# Laboratorio 1: Búsqueda Lineal vs. Búsqueda Binaria

**Facultad de Ingeniería y Ciencias Aplicadas**  
**Programación III**  
**Nombre:** Mathías Castillo

---

## Descripción de la Actividad

Este proyecto implementa y compara dos algoritmos de búsqueda: lineal y binaria. El programa genera un arreglo de números enteros aleatorios de un tamaño especificado por el usuario. Luego, realiza una búsqueda lineal y una búsqueda binaria sobre una copia ordenada del mismo. El objetivo es contar y comparar el número de pasos (iteraciones) que cada algoritmo requiere para encontrar un número, demostrando la eficiencia de la búsqueda binaria en arreglos ordenados.

---

## Casos de Prueba y Capturas de Ejecución

A continuación se muestran las capturas de pantalla de la ejecución del programa, cubriendo los diferentes escenarios posibles.

### 1. Búsqueda Exitosa (Número Encontrado)

*Aquí se muestra una captura donde el número buscado es encontrado por ambos algoritmos.*

![Búsqueda Exitosa](image/prueba-1.png)

### 2. Búsqueda No Exitosa (Número No Encontrado)

*Captura que demuestra el caso en que el número no existe en el arreglo.*

![Búsqueda No Exitosa](image/prueba-2.png)

### 3. Búsqueda en los Extremos del Arreglo

*Ejemplo de búsqueda de un número que se encuentra al inicio o al final del arreglo para ver el comportamiento de los algoritmos.*

![Búsqueda en Extremos](image/prueba-3.png)

---

## Gráfica Comparativa: Pasos vs. Tamaño del Array

La siguiente gráfica ilustra la relación entre el número de pasos requeridos por cada algoritmo y el tamaño del arreglo. Se puede observar que la búsqueda lineal tiene un crecimiento lineal (O(n)), mientras que la búsqueda binaria tiene un crecimiento logarítmico (O(log n)), siendo significativamente más eficiente para arreglos grandes.

![Gráfica Comparativa](image/grafica-big-o.png)

---

## Complejidad Algorítmica

- **Búsqueda Lineal**: O(n) - peor caso
- **Búsqueda Binaria**: O(log n) - mucho más eficiente

Con arrays de tamaño 1000:
- Lineal: hasta 1000 iteraciones
- Binaria: máximo 10 iteraciones
