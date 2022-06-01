package bg.softuni.intro.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZooService {

    private final Animal animal;
    private final Animal animal1;

    public ZooService(@Qualifier("normalDog") Animal animal, @Qualifier("cat") Animal animal1) {
        this.animal = animal;
        this.animal1 = animal1;
    }

    public void doWork() {
        animal.makeNoise();
        animal1.makeNoise();
    }


//    private final List<Animal> animals;
//
//    public ZooService(List<Animal> animals) {
//        this.animals = animals;
//    }
//
//    public void doWork() {
//        animals.forEach(Animal::makeNoise);
//    }
}
