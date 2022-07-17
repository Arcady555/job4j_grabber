package ru.job4j.ood.isp.task;

public class HardMenuPrinter implements MenuPrinter {
    @Override
    public void print(Menu menu) {
        menu.forEach(i -> {
            StringBuilder hyphen = new StringBuilder();
            int count = countDot(i.getNumber());
            hyphen.append("----".repeat(count - 1));
            System.out.println(hyphen + i.getNumber() + i.getName());
        }
        );
    }

    private int countDot(String str) {
        int rsl = 0;
        while (str.contains(".")) {
            str = str.substring(str.indexOf(".") + 1);
            rsl++;
        }
        return rsl;
    }
}
