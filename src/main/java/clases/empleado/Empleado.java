package clases.empleado;

import clases.Persona;
import javax.swing.JOptionPane;

public class Empleado extends Persona {
    private String codigoDeEmpleado;
    private int numeroDeHorasExtras;
    private String fechaDeIngreso;
    private String area;
    private String cargo;
    
    @Override
    public void registrarDatos() {
        super.registrarDatos();
    
        codigoDeEmpleado=JOptionPane.showInputDialog("Ingrese el codigo del empleado");
        numeroDeHorasExtras=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de horas extras"));
        fechaDeIngreso=JOptionPane.showInputDialog("Ingrese la fecha de ingreso (dd/mm/aaaa)");
        area=JOptionPane.showInputDialog("Ingrese el area");
        cargo=JOptionPane.showInputDialog("Ingrese el cargo");
    }

    public String getCodigoDeEmpleado() {
        return codigoDeEmpleado;
    }

    public void setCodigoDeEmpleado (String codigoDeEmpleado) {
        this.codigoDeEmpleado = codigoDeEmpleado;
    }
    
    public int getNumeroDeHorasExtras() {
        return numeroDeHorasExtras;
    }
    
    public void setNumeroDeHorasExtras (int numeroDeHorasExtras) {
        this.numeroDeHorasExtras = numeroDeHorasExtras;
    }
    
    public String getFechaDeIngreso() {
        return fechaDeIngreso;
    }
    
    public void setFechaDeIngreso (String fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }
    
    public String getArea() {
        return area;
    }
    
    public void setArea(String area) {
        this.area = area;
    }
    
    public String getCargo() {
        return cargo;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
