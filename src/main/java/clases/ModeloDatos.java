package clases;

import clases.empleado.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ModeloDatos {
    HashMap<String, Paciente> pacientesMap;
    HashMap<String, EmpleadoPlanilla> empleadosPlanillaMap;
    HashMap<String, EmpleadoEventual> empleadosEventualMap;
    HashMap<String, Medico> medicosMap;
    ArrayList<CitaMedica> citasLists;
    
    public ModeloDatos() {
        pacientesMap=new HashMap<String, Paciente>();
        empleadosPlanillaMap=new HashMap<String, EmpleadoPlanilla>();
        medicosMap=new HashMap<String, Medico>();
        empleadosEventualMap=new HashMap<String, EmpleadoEventual>();
        citasLists=new ArrayList<CitaMedica>();
    }
    
    public void registrarPersona (Paciente miPaciente) {
        pacientesMap.put(miPaciente.getNumeroDeDNI(), miPaciente);
        System.out.println("Se ha registrado el paciente "+miPaciente.getNombre()+" Satisfactoriamente");
    }
    
    public void registrarPersona (EmpleadoPlanilla miEmpPlanilla) {
        empleadosPlanillaMap.put(miEmpPlanilla.getNumeroDeDNI(), miEmpPlanilla);
        System.out.println("Se ha registrado el empleado por planilla "+miEmpPlanilla.getNombre()+" Satisfactoriamente");
    }
    
    public void registrarPersona (EmpleadoEventual miEmpEventual) {
        empleadosEventualMap.put(miEmpEventual.getNumeroDeDNI(), miEmpEventual);
        System.out.println("Se ha registrado el empleado eventual "+miEmpEventual.getNombre()+" Satisfactoriamente");
    }

    public void registrarPersona (Medico miMedico) {
        medicosMap.put(miMedico.getNumeroDeDNI(), miMedico);
        System.out.println("Se ha registrado el medico "+miMedico.getNombre()+" Satisfactoriamente");
    }
    
    public void imprimirPacientes() {
        String msj="PACIENTES REGISTRADOS\n";
        if (pacientesMap.size() >= 1) {
            Iterator<String> iterador=pacientesMap.keySet().iterator();
            while (iterador.hasNext()) {
                String clave = iterador.next();
                pacientesMap.get(clave).imprimirDatosPersona(msj);
            }
        } else {
            JOptionPane.showMessageDialog(null, "NO HAY "+msj);
        }
    }
    
    public void imprimirEmpleadosEventuales() {
        String msj="EMPLEADOS EVENTUALES REGISTRADOS\n";
        if (empleadosEventualMap.size() >= 1) {
            for (String clave : empleadosEventualMap.keySet()) {
                empleadosEventualMap.get(clave).imprimirDatosPersona(msj);
            }
        } else {
            JOptionPane.showMessageDialog(null, "NO HAY "+msj);
        }
    }
    
    public void imprimirEmpleadosPorPlanilla() {
        String msj="EMPLEADOS POR PLANILLA REGISTRADOS\n";
        if (empleadosPlanillaMap.size() >= 1) {
            for (EmpleadoPlanilla empleadoPlanilla : empleadosPlanillaMap.values()) {
                empleadoPlanilla.imprimirDatosPersona(msj);
            }
            if (medicosMap.size() >= 1) {
                System.out.println("- Medicos -");
                imprimirMedicos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "NO HAY "+msj);
        }
    }
    
    public void imprimirMedicos() {
        String msj="MEDICOS REGISTRADOS\n";
        if (medicosMap.size() >= 1) {
            for (Map.Entry<String, Medico> elemento : medicosMap.entrySet()) {
                elemento.getValue().imprimirDatosPersona(msj);
            }
        } else {
            JOptionPane.showMessageDialog(null, "NO HAY "+msj);
        }
    }
    
    public Paciente consultarPacientePorDocumento (String documentoPaciente) {
        Paciente miPaciente=null;
        if (pacientesMap.containsKey(documentoPaciente)) {
            miPaciente = pacientesMap.get(documentoPaciente);
        }
        //si el paciente existe lo retorna, sinó retorna null
        return miPaciente;
    }
    
    public EmpleadoPlanilla consultarEmpleadoPlanillaPorDocumento (String docuementoEmpleadoPlanilla) {
        EmpleadoPlanilla miEmpleadoPlanilla = null;
        if (empleadosPlanillaMap.containsKey(docuementoEmpleadoPlanilla))
            miEmpleadoPlanilla = empleadosPlanillaMap.get(docuementoEmpleadoPlanilla);
        return miEmpleadoPlanilla;
    }
    
    public EmpleadoEventual consultarEmpleadoEventualPorDocumento (String docuementoEmpleadoEventual) {
        EmpleadoEventual miEmpleadoEventual=null;
        if (empleadosEventualMap.containsKey(docuementoEmpleadoEventual)) {
            miEmpleadoEventual = empleadosEventualMap.get(docuementoEmpleadoEventual);
        }
        return miEmpleadoEventual;
    }
    
    public Medico consultarMedicoPorDocumento (String docuementoMedico) {
        Medico miMedico=null;
        if (medicosMap.containsKey(docuementoMedico)) {
            miMedico = medicosMap.get(docuementoMedico);
        }
        return miMedico;
    }
    
    public Medico consultarMedicoPorNombre (String nombreMedico) {
        for (Medico medico : medicosMap.values()) {
            if (medico.getNombre().equalsIgnoreCase (nombreMedico)) {
                return medico;//al retornar automaticamente termina el ciclo
            }
        }
        //En caso de no encontrar ningún médico retorna null return null;
        return null;
    }
    
    public void registrarCitaMedica (CitaMedica miCita) {
        citasLists.add(miCita);
        System.out.println("Se ha registrado la cita exitosamente\n");
        System.out.println(miCita.informacionCitaMedica());
    }
    
    public void imprimirCitasMedicasProgramadas() {
        String msj="CITAS MEDICAS PROGRAMADAS\n";
        CitaMedica miCita=null;
        System.out.println(msj+"\n");
        if (citasLists.size() > 0) {
            for (int i = 0; i < citasLists.size(); i++) {
                miCita=citasLists.get(i);
                System.out.println(miCita.informacionCitaMedica());
            }
        }else {
           System.out.println("No existen citas programadas");
        }
    }
}