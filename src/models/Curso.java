package models;

import java.util.ArrayList;

public class Curso {
	private String sigla;
	private String nombreCurso;
	private ArrayList <Profesor> profesoresDelCurso;

	public Curso(String pSigla,String pNombreCurso) {
		sigla = pSigla;
		nombreCurso = pNombreCurso;
		profesoresDelCurso = new ArrayList<>();  // ← LÍNEA NUEVA
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String pSigla) {
		this.sigla = pSigla;
	}

	public String getNombre() {
		return nombreCurso;
	}

	public void setNombreCurso(String pNombreCurso) {
		this.nombreCurso = pNombreCurso;
	}

	public ArrayList<Profesor> getProfesoresDelCurso() {
		return profesoresDelCurso;
	}
	public String toString() {
		
	    return "Nombre: " + nombreCurso + ", Sigla: " + sigla;
	}
}
