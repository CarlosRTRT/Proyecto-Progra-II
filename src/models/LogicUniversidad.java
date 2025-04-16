package models;

//Lógica de la clase universidad.

public class LogicUniversidad {
	private Universidad U;
	
	public LogicUniversidad(Universidad pU) {
		U = pU;
	}
	public void agregarEscuela(Escuela pDepartamento){
		U.getVector().add(pDepartamento);
	}
	public String mostrarEscuelas() {
		String result = "";
		result = "\nDepartamentos de la " + U.getNombreU() + ":";
		for(int i = 0; i < U.getVector().size(); i++) {
			result += U.getVector().get(i).getNombre() + "\n";
		}
		return result;
	}
	public void actualizarDireccion(String pDireccion) {
		U.setDireccionU(pDireccion);
	}
	public void actualizarTelefono(String pTelefono) {
		U.setTelefonoU(pTelefono);
	}
}
