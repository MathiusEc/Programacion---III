# Programming III: Exercises and Projects

This repository serves as a comprehensive collection of exercises, examples, and projects developed throughout the Programming III course at Universidad de las Américas (UDLA). It is designed to document the learning process and provide a reference for Advanced Programming concepts, Data Structures, and Algorithmic implementation in Java.

## Core Topics Covered

The repository is organized into modules, each focusing on specific advanced concepts of the Java programming language:

- **Game Development & GUI**: Implementation of interactive applications using Swing and professional game loops.
- **Data Structures**: Advanced handling of collections, custom implementations of lists, stacks, and queues.
- **Algorithms**: Sorting, searching, and complexity analysis (Big O notation).
- **Concurrency & Threads**: Managing multiple execution paths and synchronization.
- **Project Design**: Application of design patterns and clean code principles in larger scale projects.

## Repository Structure

The project follows a modular structure where each folder is an independent project:

```text
Ejercicios_III/
├── Backtracking/                   # Maze solver using backtracking algorithms
│   └── src/
│       ├── Configuracion.java
│       ├── LaberintoGrafico.java
│       ├── Laberintos.java
│       └── Resolver.java
├── Big O/                          # Algorithm complexity analysis and Big O notation
│   └── src/
│       └── Main.java
├── Busqueda Binaria-Lineal/        # Binary and linear search algorithm implementations
│   └── src/
│       ├── Busqueda.java
│       ├── GeneradorDatos.java
│       └── Main.java
├── Dynamic Stack/                  # Stack implementation with dynamic nodes
│   └── src/
│       ├── Main.java
│       ├── Nodo.java
│       └── PilaDinamica.java
├── Invertir Cadena/                # String reversal exercise
│   └── src/
│       └── Main.java
├── Practica/                       # Practice exercises with queue and printer simulation
│   └── src/
│       ├── Documento.java
│       ├── Impresora.java
│       └── Main.java
├── Práctica Prueba I/              # Practice exam preparation exercises
│   ├── Colas_FIFO/                 # FIFO Queue implementation
│   │   └── src/
│   │       └── Main.java
│   ├── Pila_ArrayList/             # Stack implementation using ArrayList
│   │   └── src/
│   │       ├── Main.java
│   │       └── Pila.java
│   ├── Pila_Dinamica_Nodos/        # Dynamic stack implementation with linked nodes
│   │   └── src/
│   │       ├── Main.java
│   │       ├── Nodo.java
│   │       └── Pila_LinkedList_Manual.java
│   ├── Pilas y Colas/              # Stack and Queue data structure implementations
│   │   └── src/
│   │       ├── Cola.java
│   │       ├── Main.java
│   │       ├── Nodo.java
│   │       └── Pila.java
│   ├── Reversa de Cadena/          # String reversal using stacks and queues
│   │   └── src/
│   │       ├── Cola.java
│   │       ├── Main.java
│   │       ├── Nodo.java
│   │       └── Pila.java
│   └── Simetria por Mitades/       # Symmetry check in a string using stacks and queues
│       └── src/
│           ├── Cola.java
│           ├── Main.java
│           ├── Nodo.java
│           └── Pila.java
├── Recursividad Grafos/            # Sierpinski triangle generation using recursion
│   └── src/
│       ├── AlgoritmoSierpinski.java
│       ├── PanelControles.java
│       ├── PanelDibujo.java
│       └── SierpinskiLab.java
│       └── Tema.java
├── RetosAlgoritmos/                # Collection of algorithmic challenges
│   └── src/
│       ├── backtracking/
│       │   ├── Laberinto.java
│       │   └── SolucionadorLaberinto.java
│       ├── busqueda/
│       │   └── AlgoritmosBusqueda.java
│       ├── colasdeprioridad/
│       │   ├── ColaPrioridad.java
│       │   └── Elemento.java
│       ├── deque/
│       │   ├── Deque.java
│       │   └── Nodo.java
│       └── recursividad/
│           ├── Factorial.java
│           └── FractalSierpinski.java
└── SnakeGame/                      # Interactive game implementing GUI, game loops, and logic
    └── src/
        └── SnakeGame.java
```

*Note: New modules and exercises will be added as the course progresses.*

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or higher.
- IntelliJ IDEA (recommended) or any Java-compatible IDE.
- Git installed on your local machine.

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/MathiusEc/Programacion---III.git
   ```

2. Navigate to the project directory:
   ```bash
   cd Programacion---III
   ```

### Working with Projects in IntelliJ IDEA

Each directory is a self-contained project. To ensure proper configuration:

1. Open IntelliJ IDEA.
2. Select **File > Open**.
3. Navigate to the specific topic folder (e.g., `SnakeGame`).
4. IntelliJ will automatically detect the configuration and project structure.

## Development Workflow

When contributing or adding new exercises:

1. **Isolation**: Always work within the specific project folder.
2. **Dependencies**: Ensure all required libraries are correctly referenced in the Project Structure if applicable.
3. **Clean Code**: Ensure source files are located within the `src/` directory.
4. **Exclusions**: The `out/` and `.idea/` directories are ignored by version control to maintain a clean repository.

## Academic Information

- **Institution**: Universidad de las Américas (UDLA)
- **Course**: Programming III
- **Author**: MathiusEc
- **License**: Academic Use Only

---

<div align="center">

### Personal Note

*"No me importa si no soy la mejor, ¡yo seré la mejor para mí!"*

**— Hitori Gotou**

<br>

<img src="https://i.pinimg.com/736x/25/45/86/254586abcd1015a44372c32f18b6ca35.jpg" alt="Inspiration" width="280">

<br><br>

*Document updated on May 2026*

</div>
