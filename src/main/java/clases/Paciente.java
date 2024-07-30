package clases;

import java.util.ArrayList;

public class Paciente extends Persona  {
    private int numeroHistoriaclínica;
    private String sexo;
    private String grupoSanguineo;
    private ArrayList<String> listaMedicamentosAlergico;
    
    public int getNumeroHistoriaClinica() {
        return numeroHistoriaclínica;
    }
    public void setNumerollistoriaClinica(int numeroHistoriaClinica) {
        this.numeroHistoriaclínica = numeroHistoriaclínica;
    }
    
    public String getSexo() {
        return sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }
    
    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }
    
    public ArrayList<String> getListaMedicamentosAlergico() {
        return listaMedicamentosAlergico;
    }
    public void setlistaMedicamentosAlergico(ArrayList<String> listaMedicamentosAlergico) { 
        this.listaMedicamentosAlergico = listaMedicamentosAlergico;
    }
}
