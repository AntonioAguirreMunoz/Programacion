import java.time.LocalDate;

public class Profesor extends Persona{

    private double sueldoBruto;
    private Materia meteriaImpartida;

    public Profesor(String nombrePersona, String apellido1, String apellido2,
                    LocalDate fechaNacimiento, String dni, double sueldoBruto, Materia meteriaImpartida) {
        super(nombrePersona, apellido1, apellido2, fechaNacimiento, dni);
        this.sueldoBruto = sueldoBruto;
        this.meteriaImpartida = meteriaImpartida;
    }

    public double getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public Materia getMeteriaImpartida() {
        return meteriaImpartida;
    }

    public void setMeteriaImpartida(Materia meteriaImpartida) {
        this.meteriaImpartida = meteriaImpartida;
    }

    public double getSueldoNeto (double retencion){
        return sueldoBruto = sueldoBruto * retencion / 100;
    }

    @Override
    public String toString() {
        return String.format("%s;%.2f;%s", super.toString(), sueldoBruto, meteriaImpartida);
    }


}
