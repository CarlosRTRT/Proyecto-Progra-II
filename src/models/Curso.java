package models;

public class Curso {
	private String sigla;
	private String nombreCurso;
	
	public Curso(String pSigla,String pNombreCurso) {
		sigla=pSigla;
		nombreCurso=pNombreCurso;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String pSigla) {
		this.sigla = pSigla;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String pNombreCurso) {
		this.nombreCurso = pNombreCurso;
	}
}
