package models;

import java.util.ArrayList;

public class Escuela {
	private String varNombre;
	private ArrayList <Curso> cursos;
	
	public Escuela(String pNombre) {
		varNombre = pNombre;
		cursos = new ArrayList<>();
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
	public ArrayList <Curso> getVector(){
		return cursos;
	}
}
