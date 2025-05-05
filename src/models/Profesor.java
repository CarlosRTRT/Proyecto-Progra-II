package models;

import java.util.ArrayList;

public class Profesor {
	protected String cedula;
	protected String nombre;
	protected String apellido1;
	protected String apellido2;
	protected ArrayList <Curso> cursosDelProfesor;
	
	public Profesor(String cedula, String nombre, String apellido1, String apellido2) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.cursosDelProfesor = new ArrayList <>();
	}

	public String getCedula() {
		return cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public ArrayList<Curso> getCursosDelProfesor() {
		return cursosDelProfesor;
	}
	
	public String toString() {
		  String resultado = "Profesor:\n";
		    resultado += "Cédula: " + cedula + "\n";
		    resultado += "Nombre completo: " + nombre + " " + apellido1 + " " + apellido2 + "\n";
		    resultado += "Cursos asignados:\n";

		    if (cursosDelProfesor == null || cursosDelProfesor.isEmpty()) {
		        resultado += "  No tiene cursos asignados.\n";
		    } else {
		        for (Curso curso : cursosDelProfesor) {
		            resultado += "  - " + curso.toString() + "\n";
		        }
		    }
		    return resultado;
		
	}
	
}
