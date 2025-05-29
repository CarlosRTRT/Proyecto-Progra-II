package models;

import java.util.ArrayList;

public class EstudianteNacional extends Estudiante {
    private double varBeca;

    public EstudianteNacional(String pCedula, String pCarnet, String pNombre, String pApellido , String pNacionalidad, int pPorcentajeBeca) {
        super(pCedula, pCarnet, pNombre, pApellido, pNacionalidad);

        varBeca = (pPorcentajeBeca / 100.0);
    }

    @Override
    public double calcularAranceles() {
        int total = 0;
        if (cursos == null || cursos.isEmpty()) {
            return 0.0;
        }
        for(Curso auxCurso: cursos){
            if(auxCurso.getVarCreditos() >= 1){
                total += (auxCurso.getVarCreditos() * 10000); //cobro por creditos totales de un curso
            }
        }
        total += 15000; //matricula
        return total - (total * varBeca); //Descuento
    }

    @Override
    public void setVarNacionalidad(String pNacionalidad) {
        varNacionalidad = pNacionalidad;
    }

    @Override
    public String getCedula() {
        return varCedula;
    }

    @Override
    public String getVarCarnet() {
        return super.getVarCarnet();
    }

    @Override
    public String getVarNombre() {
        return super.getVarNombre();
    }

    @Override
    public String getVarApellido() {
        return super.getVarApellido();
    }

    @Override
    public ArrayList<Curso> getVectorCursos() {
        return super.getVectorCursos();
    }

    @Override
    public String getVarNacionalidad() {
        return varNacionalidad;
    }

    @Override
    public void setVarNombre(String varNombre) {
        super.setVarNombre(varNombre);
    }

    @Override
    public void setVarApellido(String varApellido) {
        super.setVarApellido(varApellido);
    }
}
