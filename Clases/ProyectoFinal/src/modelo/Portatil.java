package modelo;

import excepciones.NoPortatilException;

public class Portatil {
    private int id;
    private int ram;
    private int ssd;
    private int pantalla;

    public Portatil(int id, int ram, int ssd, int pantalla) throws NoPortatilException {
        if (!Auxiliar.validarPortatil(id, ram, ssd, pantalla)){
            throw new NoPortatilException();
        }
        this.id = id;
        this.ram = ram;
        this.ssd = ssd;
        this.pantalla = pantalla;
    }

    public Portatil(int ram, int ssd, int pantalla) throws NoPortatilException {
        if (!Auxiliar.validarPortatil(100, ram, ssd, pantalla)){
            throw new NoPortatilException();
        }
        this.ram = ram;
        this.ssd = ssd;
        this.pantalla = pantalla;
    }

    public Portatil(int id) throws NoPortatilException {
        if (!Auxiliar.validarPortatil(id,1, 128, 10)){
            throw new NoPortatilException();
        }
        this.id = id;
    }

    public Portatil() {}

    public int getId() {
        return id;
    }

    public void setId(int id) throws NoPortatilException {
        if (!Auxiliar.validarID(id)){
            throw new NoPortatilException();
        }
        this.id = id;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) throws NoPortatilException {
        if (!Auxiliar.validarRAM(ram)){
            throw new NoPortatilException();
        }
        this.ram = ram;
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) throws NoPortatilException {
        if (!Auxiliar.validarSSD(ssd)){
            throw new NoPortatilException();
        }
        this.ssd = ssd;
    }

    public int getPantalla() {
        return pantalla;
    }

    public void setPantalla(int pantalla) throws NoPortatilException {
        if (!Auxiliar.validarPantalla(pantalla)){
            throw new NoPortatilException();
        }
        this.pantalla = pantalla;
    }

    @Override
    public String toString() {
        return String.format("%d, %d, %d, %d%n", id, ram, ssd, pantalla);
    }


}
