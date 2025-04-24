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
                return "Nombre: " + curso.getNombreCurso() + ", Sigla: " + curso.getSigla();
            }
        }
        
        return "Curso no encontrado.";
    }
    
    public String consultarCursosDeEscuela(Escuela pEscuela) {
        StringBuilder resultado = new StringBuilder();
        
        ArrayList<Curso> cursos = pEscuela.getVector(); // Obtienes el vector de cursos de la escuela
        if (cursos.isEmpty()) {
            return "La escuela " + pEscuela.getNombre() + " no tiene cursos registrados.";
        }

        resultado.append("Escuela: ").append(pEscuela.getNombre()).append("\n");
        for (Curso curso : cursos) {
            resultado.append(" - Nombre: ").append(curso.getNombreCurso())
                     .append(", Sigla: ").append(curso.getSigla()).append("\n");
        }

        return resultado.toString();
    }
    
    
    public String consultarCursosUniversidad(Universidad pUniversidad) {
    	StringBuilder resultado = new StringBuilder();
    	
    	ArrayList <Escuela> escuelas =pUniversidad.getVector();
    	 if (escuelas.isEmpty()) {
    	        return "No hay escuelas registradas.";
    	    }
    	 
    	 for (Escuela escuela : escuelas) {
    	        ArrayList<Curso> cursos = escuela.getVector(); // Vector de cursos de la escuela actual
    	        if (cursos.isEmpty()) {
    	            resultado.append("Escuela: ").append(escuela.getNombre()).append(" no tiene cursos registrados.\n");
    	        } else {
    	            resultado.append("Escuela: ").append(escuela.getNombre()).append("\n");
    	            for (Curso curso : cursos) {
    	                resultado.append(" - Nombre: ").append(curso.getNombreCurso())
    	                         .append(", Sigla: ").append(curso.getSigla()).append("\n");
    	            }
    	        }
    	        resultado.append("\n");
    	    }

    	    return resultado.toString();
    }
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}