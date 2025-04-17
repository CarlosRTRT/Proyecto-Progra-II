package models;

public class Curso {
	private char sigla;
	private String nombreCurso;
	
	public Curso(char pSigla,String pNombreCurso) {
		sigla=pSigla;
		nombreCurso=pNombreCurso;
	}

	public char getSigla() {
		return sigla;
	}

	public void setSigla(char pSigla) {
		this.sigla = pSigla;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String pNombreCurso) {
		this.nombreCurso = pNombreCurso;
	}
}
