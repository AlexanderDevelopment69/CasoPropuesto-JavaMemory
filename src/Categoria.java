import java.util.*;

public enum Categoria {
    PLATINUM(500),
    GOLD(350),
    SILVER(100);

    private final int costo;

    Categoria(int costo) {
        this.costo = costo;
    }

    public int getCosto() {
        return costo;
    }


    public static Categoria seleccionarCategoria() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione una categoría por sus iniciales (P - Platinum, G - Gold, S - Silver): ");
        String opcion = scanner.nextLine().toUpperCase();

        switch (opcion) {
            case "P":
                return Categoria.PLATINUM;
            case "G":
                return Categoria.GOLD;
            case "S":
                return Categoria.SILVER;
            default:
                System.out.println("Opción inválida. Seleccionando categoría");
                return Categoria.SILVER;
        }
    }

}