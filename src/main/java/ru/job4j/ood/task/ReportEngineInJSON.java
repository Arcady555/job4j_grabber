package ru.job4j.ood.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.function.Predicate;

public class ReportEngineInJSON implements Report {

    private Store store;

    public ReportEngineInJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setDateFormat(ConstantValues.DATE_FORMAT_FOF_SERIALISATION);
            String json = mapper.writeValueAsString(new Employees(store.findBy(filter)));
            text.append(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}
