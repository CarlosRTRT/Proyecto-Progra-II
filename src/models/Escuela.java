package models;

import java.util.ArrayList;

public class Escuela {
	private String varNombre;
	private Profesor director;
	private ArrayList <Curso> cursos;
	private ArrayList <Profesor> profesoresDeEscuela;
	
	public Escuela(String pNombre) {
		varNombre = pNombre;
		cursos = new ArrayList<>();
		profesoresDeEscuela = new ArrayList<>();
	}
	public void setNombre(String pNombre) {
		varNombre = pNombre;
	}
	public String getNombre() {
		return varNombre;
	}
	public void setVector(ArrayList pArray) {
		cursos = pArray;
	}
	public void setDirector(Profesor pDirector) {
		this.director = pDirector;
	}
	public ArrayList <Curso> getCursos(){	
		return cursos;
	}
	public ArrayList<Profesor> getProfesores() {
		return profesoresDeEscuela;
	}
	
}
