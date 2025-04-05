 package models;

import models.Escuela;
import java.util.ArrayList;

public class Universidad {
	//Atributos de la clase.
	private String varNombre;
	private String varDireccion;
	private String varTelefono;
	//private ArrayList <Escuela> departamento;
	//Constructor completo. Crea la clase.
	public Universidad(String pN, String pDir, String pT) {
		varNombre = pN;
		varDireccion = pDir;
		varTelefono = pT;
		//departamento.add(pDepa);
	}
	//Setters y getters.
	public void setNombreU(String pText) {
		varNombre = pText;
	}
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
}
