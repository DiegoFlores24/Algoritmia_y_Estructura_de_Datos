package ACTIVIDAD;

class Tarea implements Comparable<Tarea> { //Implementa Comparable para poder comparar tareas por prioridad
	private String nombre;     // Nombre descriptivo de la tarea
	private int prioridad;     // Valor numérico que representa la prioridad

	public Tarea(String nombre, int prioridad) {
		this.nombre = nombre;
		this.prioridad = prioridad;
	}

 // Getter para el nombre de la tarea
	public String getNombre() {
		return this.nombre;
	}

 // Getter para la prioridad de la tarea
	public Integer getPrioridad() {
		return this.prioridad;
	}

 // Representación en texto de la tarea
	@Override
	public String toString() {
		return "Tarea: " + nombre + " | Prioridad: " + prioridad;
	}

 // Método de comparación que permite ordenar tareas por su prioridad
	@Override
	public int compareTo(Tarea otra) {
		return Integer.compare(this.prioridad, otra.prioridad);
	}

 // Método para comparar si dos tareas son iguales (mismo nombre y prioridad)
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true; // Mismo objeto en memoria
		if (obj == null || getClass() != obj.getClass()) return false;
		Tarea tarea = (Tarea) obj;
		return nombre.equals(tarea.nombre) && prioridad == tarea.prioridad;
	}
}
