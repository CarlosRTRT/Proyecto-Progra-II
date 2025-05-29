package models;

import java.util.ArrayList;

public abstract class Estudiante {
    protected String varCedula;
    protected String varCarnet;
    protected String varNombre;
    protected String varApellido;
    protected String varNacionalidad;
    protected ArrayList<Curso> cursos;

    public Estudiante(String pCedula, String pCarnet, String pNombre, String pApellido , String pNacionalidad){
        varCedula = pCedula;
        varCarnet = pCarnet;
        varNombre = pNombre;
        varApellido = pApellido;
        varNacionalidad = pNacionalidad;
        cursos = new ArrayList<Curso>();

    }
    public abstract double calcularAranceles();
    public abstract void setVarNacionalidad(String pNacionalidad);

    public void setVarNombre(String varNombre) {
        this.varNombre = varNombre;
    }

    public void setVarApellido(String varApellido) {
        this.varApellido = varApellido;
    }

    public String getVarCarnet() {
        return varCarnet;
    }

    public String getVarNombre() {
        return varNombre;
    }

    public String getVarApellido() {
        return varApellido;
    }

    public ArrayList<Curso> getVectorCursos() {
        return cursos;
    }

    public abstract String getCedula();
    public abstract String getVarNacionalidad();
}
