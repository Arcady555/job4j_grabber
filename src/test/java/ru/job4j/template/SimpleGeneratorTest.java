package ru.job4j.template;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SimpleGeneratorTest {

    @Ignore
    @Test
    public void whenProduceCorrect() {
        SimpleGenerator simpleGenerator = new SimpleGenerator();
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Arcady");
        args.put("subject", "You");
        String rsl = simpleGenerator.produce(template, args);
        Assert.assertEquals(rsl, "I am Arcady, Who are You?");
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenKeysNotEnough() {
        SimpleGenerator simpleGenerator = new SimpleGenerator();
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name1", "Arcady");
        args.put("subject2", "You");
        simpleGenerator.produce(template, args);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenKeysExcess() {
        SimpleGenerator simpleGenerator = new SimpleGenerator();
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Arcady");
        args.put("subject", "You");
        args.put("subjectName", "ArcadyMe");
        simpleGenerator.produce(template, args);
    }
}