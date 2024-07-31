package katuada.ejemplohospital;

import clases.*;
import clases.empleado.*;
import javax.swing.JOptionPane;

public class Procesos {
    ModeloDatos miModeloDatos;
    
    public Procesos() {
        miModeloDatos = new ModeloDatos();
        presentarMenuOpciones();
    }
    
    private void presentarMenuOpciones() {
        String menu="MENU HOSPITAL\n\n";
        menu+="1. Registrar Paciente\n";
        menu+="2. Registrar Empleado\n";
        menu+="3. Registrar Cita Medica\n";
        menu+="4. Imprimir Información\n";
        menu+="5. Salir\n\n";
        menu+="Ingrese una Opción\n";
        int opcion=0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1: registrarPaciente(); break;
                case 2: registrarEmpleado(); break;
                case 3: registrarCitaMedica(); break;
                case 4: imprimirInformacion(); break;
                case 5: System.out.println("El sistema ha terminado!"); break; default: System.out.println("No existe el código, verifique nuevamente");
                break;
            }
        } while (opcion!=5);
    }
    
    private void registrarPaciente() {
        Paciente miPaciente=new Paciente();
        miPaciente.registrarDatos();
        if (miModeloDatos.consultarPacientePorDocumento(miPaciente.getNumeroDeDNI()) == null) {
            miModeloDatos.registrarPersona (miPaciente);
        } else {
            JOptionPane.showMessageDialog(null, "El paciente ya está registrado");
        }
    }
    
    private void registrarEmpleado () {
        String menuTipoEmpleado="Registro de Empleado\n";
        menuTipoEmpleado+="1. Empleado Eventual\n";
        menuTipoEmpleado+="2. Empleado por Planilla\n";
        menuTipoEmpleado+="Seleccione el tipo de empleado a registrar\n";
        int tipoEmpleado = Integer.parseInt(JOptionPane.showInputDialog(menuTipoEmpleado));
        switch (tipoEmpleado) {
            case 1: //Registro Empleado Eventual
                EmpleadoEventual miEmpleadoEventual=new EmpleadoEventual();
                miEmpleadoEventual.registrarDatos();
                miModeloDatos.registrarPersona (miEmpleadoEventual);
                break;
            case 2:
                String resp=JOptionPane.showInputDialog("Ingrese si, si es un médico, de lo contrario es otro tipo de empleado");
                if (resp.equalsIgnoreCase("si")) {
                    //Registro Medico
                    Medico miMedico=new Medico();
                    miMedico.registrarDatos();
                    if (miModeloDatos.consultarMedicoPorNombre(miMedico.getNombre()) == null) {
                        miModeloDatos.registrarPersona (miMedico);
                    } else {
                        JOptionPane.showMessageDialog(null, "El médico ya está registrado");
                    }
                }else {
                    //Registro Empleado Planilla
                    EmpleadoPlanilla miEmpleadoPlanilla=new EmpleadoPlanilla();
                    miEmpleadoPlanilla.registrarDatos();
                    miModeloDatos.registrarPersona (miEmpleadoPlanilla);
                }
                break;
            default:
                System.out.println("El tipo de empleado no es valido, intentelo nuevamente");
                break;
        }
    }
    
    private void registrarCitaMedica() {
        String menuImprimir="MENU IMPRESIONES\n";
        menuImprimir+="1. Listar Pacientes\n";
        menuImprimir+="2. Listar Empleados Eventuales\n";
        menuImprimir+="3. Listar Empleados Por Planilla\n";
        menuImprimir+="4. Listar Medicos\n";
        menuImprimir+="Ingrese una opción\n";
        System.out.println("**************************************");
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(menuImprimir));
        switch (opcion) {
            case 1: miModeloDatos.imprimirPacientes(); break;
            case 2: miModeloDatos.imprimirEmpleadosEventuales(); break;
            case 3: 
                miModeloDatos.imprimirEmpleadosPorPlanilla();break;
            case 4: miModeloDatos.imprimirMedicos();
            break;
            default: System.out.println("No exite esa opción");
            break;
        }
    }
    
    private void registrarCitaledica() {
        String documentoPaciente=JOptionPane.showInputDialog("Ingrese el documento del paciente");
        Paciente pacienteEncontrado=  miModeloDatos.consultarPacientePorDocumento(documentoPaciente);
        if (pacienteEncontrado!=null) {
            String nombreMedico=JOptionPane.showInputDialog("Ingrese el nombre del médico");
            Medico medicoEncontrado=miModeloDatos.consultarMedicoPorNombre (nombreMedico);
            if (medicoEncontrado!=null) {
                String servicio=JOptionPane.showInputDialog("Ingrese el servicio o motivo de la consulta");
                String fechaConsulta=JOptionPane.showInputDialog("Ingrese la fecha de la consulta");
                String horaConsulta=JOptionPane.showInputDialog("Ingrese la hora de la consulta");
                String lugar = "La cita será en el consultorio "+medicoEncontrado.getNumeroDeConsultorio();
                CitaMedica miCita = new CitaMedica (pacienteEncontrado, medicoEncontrado, servicio, fechaConsulta, horaConsulta, lugar);
                miModeloDatos.registrarCitaMedica(miCita);
            } else {
                System.out.println("El medico no se encuentra registrado en el sistema");
            }
        }else {
            System.out.println("El paciente no se encuentra registrado en el sistema");
        }
    }
    
    private void imprimirInformacion() {
        String menuImprimir="MENU IMPRESIONES\n";
        menuImprimir+="1. Listar Pacientes\n";
        menuImprimir+="2. Listar Empleados Eventuales\n";
        menuImprimir+="3. Listar Empleados Por Planilla\n";
        menuImprimir+="4. Listar Medicos\n";
        menuImprimir+="5. Listar Citas Programadas\n";
        menuImprimir+="Ingrese una opción\n";
        System.out.println("**************************************");
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(menuImprimir));
        switch (opcion) {
            case 1: miModeloDatos.imprimirPacientes(); break;
            case 2: miModeloDatos.imprimirEmpleadosEventuales();break;
            case 3: miModeloDatos.imprimirEmpleadosPorPlanilla();break;
            case 4: miModeloDatos.imprimirMedicos();break;
            case 5: miModeloDatos.imprimirCitasMedicasProgramadas();break;
            default: System.out.println("No exite esa opción"); break;
        }
    }
}