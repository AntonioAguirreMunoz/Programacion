package excepcionPropia;

public class TestTrianguloRectangulo {
    public static void main(String[] args) {

        try {
            TrianguloRectangulo trianguloRectangulo = null;
            trianguloRectangulo = new TrianguloRectangulo(3f, 4f, 5f);
            System.out.println(trianguloRectangulo);
        } catch (TrianguloRectanguloException e) {
            System.out.println("No es un triángulo rectángulo");
        }
    }
}
