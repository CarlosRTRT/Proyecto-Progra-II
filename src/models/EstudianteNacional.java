package models;

import java.util.ArrayList;

public class EstudianteNacional extends Estudiante {
    private double varBeca;

    public EstudianteNacional(String pCedula, String pCarnet, String pNombre, String pApellido, String pNacionalidad, int pPorcentajeBeca) {
        super(pCedula, pCarnet, pNombre, pApellido, pNacionalidad);
        varBeca = pPorcentajeBeca;
    }

    public double calcularAranceles() {
        double descuento = this.varBeca /= 100.0;

        int total = 0;
        if (cursos == null || cursos.isEmpty()) {
            return 0.0;
        }
        for (Curso auxCurso : cursos) {
            if (auxCurso.getVarCreditos() >= 1) {
                total += (auxCurso.getVarCreditos() * 10000); //cobro por creditos totales de un curso
            }
        }
        total += 15000; //matricula
        return total - (total * descuento); //Descuento
    }
    @Override
    public String toString() {
        return "\nNombre: " + varNombre + "\nApellido: " + varApellidos +
                "\nCédula: " + varCedula + "\nCarnet estudiantil: " + varCarnet +
                "\nNacionalidad: " + varNacionalidad + "\nBeca del: " + varBeca + "%\n";
    }
}
