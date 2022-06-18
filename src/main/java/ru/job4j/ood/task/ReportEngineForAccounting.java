package ru.job4j.ood.task;

import java.util.function.Predicate;

public class ReportEngineForAccounting implements Report {

    private Store store;

    public ReportEngineForAccounting(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(ConstantValues.DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                    .append(ConstantValues.DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                    .append(employee.getSalary() / ConstantValues.DIVIDER_ACCOUTER).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
