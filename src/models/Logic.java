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
    	pEscuela.getCursos().add(pCurso);
    }
    
    public boolean eliminarCurso(String nombreCurso,Escuela pEscuela) {
    	ArrayList <Curso> cursos =pEscuela.getCursos();
    	for(int i=0; i< cursos.size(); i++) {
    		if(cursos.get(i).getNombre().equalsIgnoreCase(nombreCurso)) {
    			cursos.remove(i);
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean modificarCurso(String nombreCurso,Escuela pEscuela, String nuevoNombreCurso) {
    	ArrayList <Curso> cursos =pEscuela.getCursos();
    	for (Curso curso : cursos) {
            if (curso.getNombre().equalsIgnoreCase(nombreCurso)) {
                curso.setNombreCurso(nuevoNombreCurso);
                return true;
            }
    	}
    	return false;
    }
    
    public String consultarCurso(Escuela pEscuela, String nombreCurso) {
        ArrayList<Curso> cursos = pEscuela.getCursos(); // Obtienes el vector de cursos de la escuela
        
        for (Curso curso : cursos) {
            if (curso.getNombre().equalsIgnoreCase(nombreCurso)) {
            	 return curso.toString();
            }
        }
        
        return "Curso no encontrado.";
    }
    
    public String consultarCursosDeEscuela(Escuela pEscuela) {
    	 String resultado = "";
    	    
    	    ArrayList<Curso> cursos = pEscuela.getCursos();
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
    	        ArrayList<Curso> cursos = escuela.getCursos();
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
    public String agregarNuevoProfesor(String pNombre, String pCedula, String pApellidos, Escuela escuelaSeleccionada, Universidad u) {
        if (verificarProfesor(pCedula, u)) {
            return "Ya existe un profesor con la cédula " + pCedula;
        }

        // Dividir apellidos en caso de que vengan juntos
        String apellido1 = "";
        String apellido2 = "";

        if (pApellidos != null && !pApellidos.trim().isEmpty()) {
            String[] apellidos = pApellidos.trim().split("\\s+", 2);
        }

        Profesor nuevoProfesor = new Profesor(pCedula, pNombre, pApellidos);
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
    public void modificarDatosProfesor(Profesor profesor, String nuevoNombre, String nuevosApellidos) {
        if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
            profesor.setNombre(nuevoNombre);
        }
        if (nuevosApellidos != null && !nuevosApellidos.isEmpty()) {
            profesor.setApellidos(nuevosApellidos);
        }
    }
    
    public void agregarCursoProfesor(Profesor pProfesor, Curso pCurso) {
    	if(pProfesor.getCursosDelProfesor().contains(pCurso) == false) {
    		pProfesor.getCursosDelProfesor().add(pCurso);
    	}
    	if(pCurso.getProfesoresDelCurso().contains(pProfesor) == false) {
    		pCurso.getProfesoresDelCurso().add(pProfesor);
    	}
    }
    
    public void cambiarDirectorEscuela(Profesor pDirector, Escuela pEscuela) {
    	Director nuevoDirector = new Director(pDirector, pEscuela);
    	pEscuela.setDirector(nuevoDirector);
    }
    
    public String mostrarProfesores(Escuela pEscuela) {
    	String txt = ""; int contador = 1;
    	if(!pEscuela.getProfesores().isEmpty()) {
    		txt += "Profesores \n";
        	for(Profesor profesorAux : pEscuela.getProfesores()) {
        		txt += contador++ + " | "+ profesorAux.getCedula() + " " + profesorAux.getNombre() +
                        " " + profesorAux.getApellidos() + "\n";
        	}
    	}else {
    		txt = "Error";
    	}
    	return txt;
    }
    
    public String mostrarProfesoresDeCurso(Escuela pEscuela, String pNombreCurso) {
    	String txt = "";
    	for(Curso cursoAux : pEscuela.getCursos()) {
    		if(cursoAux.getNombre().equals(pNombreCurso)) {
    			for(Profesor profeAux : cursoAux.getProfesoresDelCurso()) {
        			txt += profeAux.toString() + "\n";
    			}
    			return txt;
    		}
    	}
    	return "Error";
    }
    
    
    
    
    
    
    
    
    
    
}