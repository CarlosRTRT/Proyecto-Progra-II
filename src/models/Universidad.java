 package models;

import java.util.ArrayList;

public class Universidad {
	//Atributos de la clase.
	private String varNombre;
	private String varDireccion;
	private String varTelefono;
	private ArrayList <Escuela> departamentos;
	
	//Constructor completo. Crea la clase.
	public Universidad(String pN, String pDir, String pT) {
		varNombre = pN;
		varDireccion = pDir;
		varTelefono = pT;
		departamentos = new ArrayList<>();
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
	public void setVector(ArrayList <Escuela> pVector) {
		departamentos = pVector;
	}
	public ArrayList <Escuela> getVector() {
		return departamentos;
	}
	
}
