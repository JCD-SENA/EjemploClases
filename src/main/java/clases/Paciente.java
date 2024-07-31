package clases;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Paciente extends Persona  {
    private int numeroHistoriaclínica;
    private String sexo;
    private String grupoSanguineo;
    private ArrayList<String> listaMedicamentosAlergico;
    
    @Override
    public void registrarDatos() {
        super.registrarDatos();
        
        listaMedicamentosAlergico=new ArrayList<String>();
        numeroHistoriaclínica = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la historia clinica"));
        sexo = JOptionPane.showInputDialog("Ingrese el sexo");
        grupoSanguineo = JOptionPane.showInputDialog("Ingrese el grupo sanguineo");
        String pregunta = JOptionPane.showInputDialog("¿Es alergico a algun medicamento? ingrese si o no");
        if (pregunta.equalsIgnoreCase("si")) {
            String medicamento="";
            String continuar="";
            do {
                medicamento=JOptionPane.showInputDialog("Ingrese el nombre del medicamento al que es alergico");
                listaMedicamentosAlergico.add(medicamento);
                continuar=JOptionPane.showInputDialog("Ingrese si, si desea continuar");
            } while (continuar.equalsIgnoreCase("si"));
        }
    }
    
    
    public int getNumeroHistoriaClinica() {
        return numeroHistoriaclínica;
    }
    public void setNumerollistoriaClinica(int numeroHistoriaClinica) {
        this.numeroHistoriaclínica = numeroHistoriaClinica;
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
