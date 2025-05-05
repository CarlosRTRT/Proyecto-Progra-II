package models;

import java.util.ArrayList;

public class Logic {
    private Universidad u;
    
    public Logic(Universidad pUniversidad) {
        u = pUniversidad;
    }
    
    public Universidad getUniversidad() {
        return u;
    }
    
    public void agregarEscuela(Escuela pDepartamento){
        u.getVector().add(pDepartamento);
    }
    
    public String mostrarEscuelas() {
        String result = "";
        result = "\nDepartamentos de la " + u.getNombreU() + ":";
        for(int i = 0; i < u.getVector().size(); i++) {
            result += "\n" + (i+1) + ". " + u.getVector().get(i).getNombre();
        }
        return result;
    }
    
    public void actualizarDireccion(String pDireccion) {
        u.setDireccionU(pDireccion);
    }
    
    public void actualizarTelefono(String pTelefono) {
        u.setTelefonoU(pTelefono);
    }
    
    // Metodos CRUD para cursos de escuelas
    
    public void agregarCurso(Curso pCurso, Escuela pEscuela) {
    	pEscuela.getVector().add(pCurso);
    }
    
    public boolean eliminarCurso(String nombreCurso,Escuela pEscuela) {
    	ArrayList <Curso> cursos =pEscuela.getVector();
    	for(int i=0; i< cursos.size(); i++) {
    		if(cursos.get(i).getNombreCurso().equalsIgnoreCase(nombreCurso)) {
    			cursos.remove(i);
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean modificarCurso(String nombreCurso,Escuela pEscuela, String nuevoNombreCurso) {
    	ArrayList <Curso> cursos =pEscuela.getVector();
    	for (Curso curso : cursos) {
            if (curso.getNombreCurso().equalsIgnoreCase(nombreCurso)) {
                curso.setNombreCurso(nuevoNombreCurso);
                return true;
            }
    	}
    	return false;
    }
    
    public String consultarCurso(Escuela pEscuela, String nombreCurso) {
        ArrayList<Curso> cursos = pEscuela.getVector(); // Obtienes el vector de cursos de la escuela
        
        for (Curso curso : cursos) {
            if (curso.getNombreCurso().equalsIgnoreCase(nombreCurso)) {
            	 return curso.toString();
            }
        }
        
        return "Curso no encontrado.";
    }
    
    public String consultarCursosDeEscuela(Escuela pEscuela) {
    	 String resultado = "";
    	    
    	    ArrayList<Curso> cursos = pEscuela.getVector();
    	    if (cursos.isEmpty()) {
    	        return "La escuela " + pEscuela.getNombre() + " no tiene cursos registrados.";
    	    }

    	    resultado += "Escuela: " + pEscuela.getNombre() + "\n";
    	    for (Curso curso : cursos) {
    	        resultado += " - " + curso.toString() + "\n";
    	    }

    	    return resultado;
    }
    
    
    public String consultarCursosUniversidad(Universidad pUniversidad) {
    	 String resultado = "";
    	    
    	    ArrayList<Escuela> escuelas = pUniversidad.getVector();
    	    if (escuelas.isEmpty()) {
    	        return "No hay escuelas registradas.";
    	    }
    	    
    	    for (Escuela escuela : escuelas) {
    	        ArrayList<Curso> cursos = escuela.getVector();
    	        if (cursos.isEmpty()) {
    	            resultado += "Escuela: " + escuela.getNombre() + " no tiene cursos registrados.\n";
    	        } else {
    	            resultado += "Escuela: " + escuela.getNombre() + "\n";
    	            for (Curso curso : cursos) {
    	                resultado += " - " + curso.toString() + "\n";
    	            }
    	        }
    	        resultado += "\n";
    	    }

    	    return resultado;
    }
    //NUEVO!!
    public String agregarNuevoProfesor(String pNombre,String pCedula,String pApellido1,String pApellido2, Escuela escuelaSeleccionada, Universidad u) {
    	if (verificarProfesor(pCedula, u)) {
            return "Ya existe un profesor con la cédula " + pCedula;
        }

        Profesor nuevoProfesor = new Profesor(pCedula, pNombre, pApellido1, pApellido2);
        escuelaSeleccionada.getProfesores().add(nuevoProfesor);
        
        return "Profesor agregado exitosamente a la escuela " + escuelaSeleccionada.getNombre();
    }
    
    public boolean verificarProfesor(String cedula, Universidad universidad) {
        ArrayList<Escuela> escuelas = universidad.getVector();

        for (Escuela escuela : escuelas) {
            ArrayList<Profesor> profesores = escuela.getProfesores();
            for (Profesor profesor : profesores) {
                if (profesor.getCedula().equals(cedula)) {
                    return true; // Ya existe un profesor con esta cédula
                }
            }
        }

        return false; // No se encontró en ninguna escuela
    }
    
    public Profesor buscarProfesor(String cedula, Universidad universidad) {
        for (Escuela escuela : universidad.getVector()) {
            for (Profesor profesor : escuela.getProfesores()) {
                if (profesor.getCedula().equals(cedula)) {
                    return profesor;
                }
            }
        }
        return null;
        //No hice que imprimiera el toString del profesor ya que de esta forma solo retornando al profesor el metodo sirve para mas cosas
    }
    public void modificarDatosProfesor(Profesor profesor, String nuevoNombre, String nuevoApellido1, String nuevoApellido2) {
        if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
            profesor.setNombre(nuevoNombre);
        }
        if (nuevoApellido1 != null && !nuevoApellido1.isEmpty()) {
            profesor.setApellido1(nuevoApellido1);
        }
        if (nuevoApellido2 != null && !nuevoApellido2.isEmpty()) {
            profesor.setApellido2(nuevoApellido2);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}