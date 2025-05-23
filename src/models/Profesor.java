package models;

import java.util.ArrayList;

public class Profesor {
	protected String cedula;
	protected String nombre;
	protected String apellidos;
	protected ArrayList <Curso> cursos;
	
	public Profesor(String cedula, String nombre, String apellidos) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellidos = apellidos;		this.cursos = new ArrayList <>();
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void agregarCurso(Curso curso) {
		if (!cursos.contains(curso)) {
			cursos.add(curso);
		}
	}

	public void eliminarCurso(Curso curso) {
		cursos.remove(curso);
	}

	public ArrayList<Curso> getCursosDelProfesor() {
		return cursos;
	}
	
	public String toString() {
		  String resultado = "Profesor:\n";
		    resultado += "Cedula: " + cedula + "\n";
		    resultado += "Nombre completo: " + nombre + " " + apellidos + "\n";
		    resultado += "Cursos asignados:\n";

		    if (cursos == null || cursos.isEmpty()) {
		        resultado += "  No tiene cursos asignados.\n";
		    } else {
		        for (Curso curso : cursos) {
		            resultado += "  - " + curso.toString() + "\n";
		        }
		    }
		    return resultado;
		
	}

	/*ToString alternativo para probar

	@Override
    public String toString() {
        return nombre + " " + apellido;
    }

	 */
	
}
