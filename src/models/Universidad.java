 package models;

import java.util.ArrayList;

public class Universidad {
	//Atributos de la clase.
	private String varNombre;
	private String varDireccion;
	private String varTelefono;
	private ArrayList <Escuela> departamentos;
	
	//Constructor completo. Crea la clase.
	public Universidad(String pN, String pDir, String pT, Escuela pEscuela) {
		varNombre = pN;
		varDireccion = pDir;
		varTelefono = pT;
		departamentos = new ArrayList<>();
		departamentos.add(pEscuela);
	}
	
	//Setters y getters.
	public String getNombreU() {
		return varNombre;
	}
	public void setDireccionU(String pText) {
		varDireccion = pText;
	}
	public String getDireccionU() {
		return varDireccion;
	}
	public void setTelefonoU(String pText) {
		varTelefono = pText;
	}
	public String getTelefonoU() {
		return varTelefono;
	}
	//Métodos
	public void agregarEscuela(Escuela pDepartamento) {
		departamentos.add(pDepartamento);
	}
	public String vectorToString() {
		String txt = "";
		for(int i = 0; i < departamentos.size(); i++) {
			txt = "\n" + departamentos.get(i).getNombre() + "\n";
		}
		return txt;
	}
}
