package ru.job4j.ood.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.function.Predicate;

public class ReportEngineInJSON implements Report {

    private Store store;
    private ObjectMapper mapper;

    public ReportEngineInJSON(Store store) {
        this.store = store;
        mapper = new ObjectMapper();
        mapper.setDateFormat(ConstantValues.DATE_FORMAT_FOF_SERIALISATION);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        try {
            String json = mapper.writeValueAsString(new Employees(store.findBy(filter)));
            text.append(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}