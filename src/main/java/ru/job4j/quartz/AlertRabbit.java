package ru.job4j.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

public class AlertRabbit {
    private static Connection connection;

    private static void insert() throws SQLException {
        try (PreparedStatement ps = connection
                .prepareStatement("insert into rabbit(created_date) values (?)")) {
            ps.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            ps.execute();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        AlertRabbit alertRabbit = new AlertRabbit();
        Properties prop = alertRabbit.readProperties("rabbit.properties");
        alertRabbit.initConnection(prop);
        try {
            List<Long> store = new ArrayList<>();
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            JobDataMap data = new JobDataMap();
            data.put("store", store);
            JobDetail job = newJob(Rabbit.class)
                    .usingJobData(data)
                    .build();
            SimpleScheduleBuilder times = simpleSchedule()
                    .withIntervalInSeconds(5)
                    .repeatForever();
            Trigger trigger = newTrigger()
                    .startNow()
                    .withSchedule(times)
                    .build();
            scheduler.scheduleJob(job, trigger);
            Thread.sleep(5000);
            scheduler.shutdown();
            System.out.println(store);
        } catch (Exception se) {
            se.printStackTrace();
        }
    }

    private Properties readProperties(String str) throws IOException {
        Properties prop = new Properties();
        try (InputStream in = Rabbit.class.getClassLoader()
                .getResourceAsStream(str)) {
            prop.load(in);
        }
        return prop;
    }

    private void initConnection(Properties properties) throws ClassNotFoundException, SQLException {
        Class.forName(properties.getProperty("driver-class"));
        String url = properties.getProperty("url");
        String login = properties.getProperty("username");
        String password = properties.getProperty("password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public static class Rabbit implements Job {

        public Rabbit() {
            System.out.println(hashCode());
        }

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            System.out.println("Rabbit runs here ...");
            List<Long> store = (List<Long>) context.getJobDetail().getJobDataMap().get("store");
            store.add(System.currentTimeMillis());
            try {
                insert();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}