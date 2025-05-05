package models;

public class Director extends Profesor {
	
	 private Escuela escuelaDelDirector; // La escuela que dirige

	 public Director(Profesor profesorBase, Escuela escuela) {
		    super(
		        profesorBase.getCedula(),
		        profesorBase.getNombre(),
		        profesorBase.getApellido1(),
		        profesorBase.getApellido2()
		    );
		    this.escuelaDelDirector=escuela;
	 }

	 public Escuela getEscuelaDelDirector() {
		return escuelaDelDirector;
	}

	@Override
	 public String toString() {
	     String resultado = "Director:\n";
	     resultado += "Cédula: " + cedula + "\n";
	     resultado += "Nombre completo: " + nombre + " " + apellido1 + " " + apellido2 + "\n";
	     resultado += "Escuela que dirige: " + escuelaDelDirector.getNombre() + "\n";

	     // Ya no tiene cursos asignados, no se incluye la sección de cursos
	     return resultado;
	 }
}
