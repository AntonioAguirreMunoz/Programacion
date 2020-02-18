package excepcionPropia;

public class TrianguloRectangulo {

    private float cateto1;
    private float cateto2;
    private float hipotenusa;

    public TrianguloRectangulo(float cateto1, float cateto2, float hipotenusa) throws TrianguloRectanguloException {
        if (esTrianguloRectangulo(cateto1, cateto2, hipotenusa)) {
            this.cateto1 = cateto1;
            this.cateto2 = cateto2;
            this.hipotenusa = hipotenusa;
        } else
            throw new TrianguloRectanguloException();
    }

    private boolean esTrianguloRectangulo(float cateto1, float cateto2, float hipotenusa){
        return hipotenusa*hipotenusa == cateto1*cateto1 + cateto2*cateto2;
    }

    @Override
    public String toString() {
        return "TrianguloRectangulo " +
                "cateto1 = " + cateto1 +
                ", cateto2 = " + cateto2 +
                ", hipotenusa = " + hipotenusa;
    }
}
