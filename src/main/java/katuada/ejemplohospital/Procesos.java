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
        menu+="4. Consultar por documento\n";
        menu+="5. Imprimir Información\n";
        menu+="6. Salir\n\n";
        menu+="Ingrese una Opción\n";
        int opcion=0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1: registrarPaciente(); break;
                case 2: registrarEmpleado(); break;
                case 3: registrarCitaMedica(); break;
                case 4: consultarPorDocumento(); break;
                case 5: imprimirInformacion(); break;
                case 6: System.out.println("El sistema ha terminado!"); break; default: System.out.println("No existe el código, verifique nuevamente");
                break;
            }
        } while (opcion!=6);
    }
    
    private void consultarPorDocumento () {
        try {
            int tipoEmpleado = Integer.parseInt(JOptionPane.showInputDialog("1. Consultar paciente por documento\n2. Consultar medico por documento\n3. Consultar empleado de planilla por documento\n4. Consultar empleado eventual por documento\n5. Salir"));
            switch (tipoEmpleado) {
                case 1:
                    String documentoPaciente = JOptionPane.showInputDialog(null, "Ingrese el documento del paciente");
                    Paciente miPaciente = miModeloDatos.consultarPacientePorDocumento(documentoPaciente);
                    if (miPaciente != null)
                        miPaciente.imprimirDatosPersona("Paciente");
                    else
                        JOptionPane.showMessageDialog(null, "No se encontró el paciente");
                    break;
                case 2:
                    String documentoMedico = JOptionPane.showInputDialog(null, "Ingrese el documento del médico");
                    Medico miMedico = miModeloDatos.consultarMedicoPorDocumento(documentoMedico);
                    if (miMedico != null)
                        miMedico.imprimirDatosPersona("Paciente");
                    else
                        JOptionPane.showMessageDialog(null, "No se encontró el médico");
                    break;
                case 3:
                    String documentoEmpleadoPlanilla = JOptionPane.showInputDialog(null, "Ingrese el documento del  empleado por planilla");
                    EmpleadoPlanilla miEmpleadoPlanilla = miModeloDatos.consultarEmpleadoPlanillaPorDocumento(documentoEmpleadoPlanilla);
                    if (miEmpleadoPlanilla != null)
                        miEmpleadoPlanilla.imprimirDatosPersona("Empleado planilla");
                    else
                        JOptionPane.showMessageDialog(null, "No se encontró el empleado");
                    break;
                case 4:
                    String documentoEmpleadoEventual = JOptionPane.showInputDialog(null, "Ingrese el documento del empleado eventual");
                    EmpleadoEventual miEmpleadoEventual = miModeloDatos.consultarEmpleadoEventualPorDocumento(documentoEmpleadoEventual);
                    if (miEmpleadoEventual != null)
                        miEmpleadoEventual.imprimirDatosPersona("Empleado eventual");
                    else
                        JOptionPane.showMessageDialog(null, "No se encontró el empleado");
                    break;
                case 5:
                    System.out.println("Saliendo");
                    break;
                default: System.out.println("No exite esa opción"); break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo consultar");
        }
    }
    
    private void registrarPaciente() {
        Paciente miPaciente=new Paciente();
        try {
            miPaciente.registrarDatos();
            if (miModeloDatos.consultarPacientePorDocumento(miPaciente.getNumeroDeDNI()) == null) {
                miModeloDatos.registrarPersona (miPaciente);
            } else {
                JOptionPane.showMessageDialog(null, "El paciente ya está registrado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Datos invalidos, no se pudo registrar el paciente");
        }
    }
    
    private void registrarEmpleado () {
        String menuTipoEmpleado="Registro de Empleado\n";
        menuTipoEmpleado+="1. Empleado Eventual\n";
        menuTipoEmpleado+="2. Empleado por Planilla\n";
        menuTipoEmpleado+="Seleccione el tipo de empleado a registrar\n";
        try {
            int tipoEmpleado = Integer.parseInt(JOptionPane.showInputDialog(menuTipoEmpleado));
            switch (tipoEmpleado) {
                case 1: //Registro Empleado Eventual
                    EmpleadoEventual miEmpleadoEventual=new EmpleadoEventual();
                    miEmpleadoEventual.registrarDatos();
                    if (miModeloDatos.consultarEmpleadoEventualPorDocumento(miEmpleadoEventual.getNumeroDeDNI()) == null)
                        miModeloDatos.registrarPersona (miEmpleadoEventual);
                    else
                        JOptionPane.showMessageDialog(null, "El empleado eventual ya está registrado");
                    break;
                case 2:
                    String resp=JOptionPane.showInputDialog("Ingrese si, si es un médico, de lo contrario es otro tipo de empleado");
                    if (resp.equalsIgnoreCase("si")) {
                        //Registro Medico
                        Medico miMedico=new Medico();
                        miMedico.registrarDatos();
                        if (miModeloDatos.consultarMedicoPorDocumento(miMedico.getNumeroDeDNI()) == null) {
                            miModeloDatos.registrarPersona(miMedico);
                        } else {
                            JOptionPane.showMessageDialog(null, "El médico ya está registrado");
                        }
                    }else {
                        //Registro Empleado Planilla
                        EmpleadoPlanilla miEmpleadoPlanilla=new EmpleadoPlanilla();
                        miEmpleadoPlanilla.registrarDatos();
                        if (miModeloDatos.consultarEmpleadoPlanillaPorDocumento(miEmpleadoPlanilla.getNumeroDeDNI()) == null)
                            miModeloDatos.registrarPersona (miEmpleadoPlanilla);
                        else
                            JOptionPane.showMessageDialog(null, "El empleado por planilla ya está registrado");
                    }
                    break;
                default:
                    System.out.println("El tipo de empleado no es valido, intentelo nuevamente");
                    break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Datos invalidos, no se pudo registrar el empleado");
        }
    }
    
    private void registrarCitaMedica() {
        String documentoPaciente=JOptionPane.showInputDialog("Ingrese el documento del paciente");
        Paciente pacienteEncontrado=  miModeloDatos.consultarPacientePorDocumento(documentoPaciente);
        if (pacienteEncontrado!=null) {
            try {
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
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Dato equivocado, no se pudo registrar");
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