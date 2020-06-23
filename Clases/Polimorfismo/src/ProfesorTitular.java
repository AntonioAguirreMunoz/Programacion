import java.time.LocalDate;
import java.time.Period;

public class ProfesorTitular extends Profesor{

    private LocalDate fechaIncorporacion;

    public ProfesorTitular(String nombrePersona, String apellido1, String apellido2,
                           LocalDate fechaNacimiento, String dni, double sueldoBruto,
                           Materia meteriaImpartida, LocalDate fechaIncorporacion) {
        super(nombrePersona, apellido1, apellido2, fechaNacimiento, dni, sueldoBruto, meteriaImpartida);
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    @Override
    public double getSueldoNeto(double retencion) {
        return super.getSueldoNeto(retencion) + 100 * obtenerNumeroTrienio();
    }

    private int obtenerNumeroTrienio(){
        Period period = Period.between(LocalDate.now(), fechaIncorporacion);
        return period.getYears();
    }

    @Override
    public String toString() {
        return String.format("%s;%d/%d/%d", super.toString(), fechaIncorporacion.getDayOfMonth(),
                               fechaIncorporacion.getMonthValue(), fechaIncorporacion.getYear() );
    }
}
