import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Department department = new Department(1, "teste");
        System.out.println(department);

        Seller seller = new Seller(2, "Gean", "gean@email.com", new Date(), 3000.0, department);
        System.out.println(seller);
    }
}