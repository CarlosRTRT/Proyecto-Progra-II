package models;

import java.util.ArrayList;

public abstract class Estudiante {
    protected String varCedula;
    protected String varCarnet;
    protected String varNombre;
    protected String varApellidos;
    protected String varNacionalidad;
    protected double varBeca;
    protected ArrayList<Curso> cursos;

    public Estudiante(String pCedula, String pCarnet, String pNombre, String pApellido , String pNacionalidad, double pBeca){
        varCedula = pCedula;
        varCarnet = pCarnet;
        varNombre = pNombre;
        varApellidos = pApellido;
        varBeca=pBeca;
        varNacionalidad = pNacionalidad;
        cursos = new ArrayList<Curso>();

    }
    public abstract double calcularAranceles();
    public abstract String toString();

    public void setVarNacionalidad(String pNacionalidad){ varNacionalidad = pNacionalidad; }

    public double getVarBeca() { return varBeca; };

    public void setVarNombre(String varNombre) { this.varNombre = varNombre; }

    public void setVarApellido(String pApellidos) { this.varApellidos = pApellidos;}

    public String getCedula(){ return varCedula; };

    public String getVarNacionalidad(){ return varNacionalidad; };

    public String getVarCarnet() { return varCarnet; }

    public String getVarNombre() { return varNombre; }

    public String getVarApellido() { return varApellidos;}

    public ArrayList<Curso> getVectorCursos() { return cursos; }


}
