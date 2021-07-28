package Application;

import java.util.Locale;
import java.util.Scanner;
import Entities.Worker;
import Entities.HourContract;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entities.Departament;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        Scanner sc = new Scanner(System.in);
        Worker worker = new Worker();
        
        System.out.print("Enter Departament's name: ");
        worker.setDepartament(new Departament(sc.next()));
        System.out.println("Enter worker data");
        System.out.print("Name: ");
        worker.setName(sc.next());
        System.out.print("Basa salary: $ ");
        worker.setBaseSalary(sc.nextDouble());
        System.out.println("how many contracts to this worker? ");
        int numbercontracts = sc.nextInt();
        for (int i = 0; i < numbercontracts; i++) {
            HourContract contract = new HourContract();
            System.out.println("Enter contract #" + i + " data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            try {
                contract.setData(sdf.parse(sc.next()));
            } catch (ParseException ex) {
                Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
            System.out.print("Value per hour: ");
            contract.setValuePerHour(sc.nextDouble());
            System.out.print("Duration (Hour): ");
            contract.setHour(sc.nextInt());
            worker.addContract(contract);
        }
        sdf = new SimpleDateFormat("MM/yyyy");
        System.out.print("Enter moth and year to calcule income(MM/YYYY): ");
        String dateIncome = sc.next();
        double valueIncome =0;
        try {
           valueIncome = worker.income(sdf.parse(dateIncome));
        } catch (ParseException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Name: " + worker.getName());
        System.out.println("Departament: " + worker.getDepartament());
        
        System.out.println(worker.getBaseSalary());
        System.out.println("Income for " + dateIncome + ": " + valueIncome);

    }
}
