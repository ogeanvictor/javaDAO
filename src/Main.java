import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("\n** FindById **");
        Seller sellerId = sellerDao.findById(3);
        System.out.println(sellerId);

        System.out.println("\n** FindByDepartment **");
        Department department = new Department(2, null);
        List<Seller> sellers = sellerDao.findByDepartment(department);
        for (Seller seller : sellers) {
            System.out.println(seller);
        }

        System.out.println("\n** FindAll **");
        List<Seller> list = sellerDao.findAll();
        for (Seller seller : list) {
            System.out.println(seller);
        }

        System.out.println("\n** Insert **");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n** Update **");
        Seller seller = sellerDao.findById(5);
        seller.setName("Marta");
        sellerDao.update(seller);
        System.out.println("Updated!");

        System.out.println("\n** Delete **");
        System.out.println("Insert id: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Deleted!");


        System.out.println("======================================");
        System.out.println("Department");

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("\n** Insert **");
        Department newDepartment = new Department(null, "Sports");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        sc.close();
    }
}