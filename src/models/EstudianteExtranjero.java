package models;

import java.util.ArrayList;

public class EstudianteExtranjero extends Estudiante {

    public EstudianteExtranjero(String pCedula, String pCarnet, String pNombre, String pApellido , String pNacionalidad){
        super(pCedula, pCarnet, pNombre, pApellido, pNacionalidad,0);
    }

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
        return total + (total * 0.40); //recargo del 40%
    }

    @Override
    public String toString() {
        return "\nNombre: " + varNombre + "\nApellido: " + varApellidos +
                "\nCédula: " + varCedula + "\nCarnet estudiantil: " + varCarnet +
                "\nNacionalidad: " + varNacionalidad + "\nEstado de beca: no aplicable." + "\n";
    }
}
