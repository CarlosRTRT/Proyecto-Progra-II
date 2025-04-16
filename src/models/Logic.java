package models;

public class Logic {
	private Universidad u;
	
	public Logic(Universidad pUniversidad) {
		u=pUniversidad;
	}
	
	public void agregarEscuela(Escuela pDepartamento){
		u.getVector().add(pDepartamento);
	}
	public String mostrarEscuelas() {
		String result = "";
		result = "\nDepartamentos de la " + u.getNombreU() + ":";
		for(int i = 0; i < u.getVector().size(); i++) {
			result += u.getVector().get(i).getNombre() + "\n";
		}
		return result;
	}
	public void actualizarDireccion(String pDireccion) {
		u.setDireccionU(pDireccion);
	}
	public void actualizarTelefono(String pTelefono) {
		u.setTelefonoU(pTelefono);
	}
	//Aca abajo iran los metodos de los cursos
}
