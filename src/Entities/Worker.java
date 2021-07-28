package Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Worker {

    private String name;
    private WorkerLevel level;
    private double baseSalary;
    private Departament departament;
    private List <HourContract> contracts = new ArrayList<>();

    public Worker() {

    }

    public double getBaseSalary() {
        return baseSalary;
    }
    
    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public String getDepartament() {
        return departament.getNameDepartamet();
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        this.contracts.remove(contract);
    }

    public double income(Date date) {
        double totalContracts = baseSalary;
        for (HourContract contract : contracts) {
            if (date.equals(contract.getData())) {
                totalContracts += contract.totalValue();
            }
        }

        return totalContracts;
    }
}
