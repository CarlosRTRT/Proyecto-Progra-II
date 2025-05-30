 package models;

import java.util.ArrayList;

public class Universidad {
	//Atributos de la clase.
	private String varNombre;
	private String varDireccion;
	private String varTelefono;
	private ArrayList<Estudiante> estudiantes;
	private ArrayList <Escuela> departamentos;
	
	//Constructor completo. Crea la clase.
	public Universidad(String pNombre, String pDireccion, String pTelefono) {
		varNombre = pNombre;
		varDireccion = pDireccion;
		varTelefono = pTelefono;
		departamentos = new ArrayList<>();
		estudiantes = new ArrayList<Estudiante>();
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
	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	public ArrayList <Escuela> getVector() {
		return departamentos;
	}
	
}
