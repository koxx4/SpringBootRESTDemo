package com.koxx4.springbootrestdemo.fun;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class HardcodedFactProvider implements RandomFactProvider{

    private Random random = new Random();
    private String[] facts = {"The Muppet vampire, Count von Count from Sesame Street, is based on actual vampire myth. One way to supposedly deter a vampire is to throw seeds outside a door. Vampires are compelled to count the seeds, delaying them until morning.",
            "Gossip and complaining make up approximately 80% of most people's conversations",
            "Developing a larger vocabulary may help protect you against depression. It allows you to precisely label--and confront--subtle emotions.",
            "Riding or sitting on a sea turtle in the United States is a 3rd degree felony",
            "Humans shed about 600,000 particles of skin every hour. By age 70, humans lose an average of 105 pounds of skin",
            "Listening to your favorite music for just 15 minutes a day lowers stress levels, anxiety, sadness, and a depressed mood.",
            "To make one pound of honey, honey bees must gather nectar from nearly 2 million flowers",
            "\"Bluetooth\" technology is named after a 10th century king, King Harald Bluetooth. Bluetooth united the tribes of Denmark, just like the wireless technology united cell phones and computers",
            "A duel between three people is called a \"truel.\"",
            "There is a Statue of Liberty in Paris that faces the Statue of Liberty in America, showing friendship between the two countries.",
            "Research shows that people who laugh at dark jokes have higher IQs and report less aggressive tendencies.",
            "Termite queens live longer than any other insect. Some scientists estimate that they can live as long as 100 years."};


    @Override
    public String getRandomFact() {
        return facts[random.nextInt(facts.length)];
    }
}
