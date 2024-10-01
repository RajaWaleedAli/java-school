package introClasses.AnimalLesson;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[5];
        animals[0] = new Animal("Bob", "cat",15);
        animals[1] = new Animal("Tom", "cat",2);
        animals[2] = new Animal("Jerry", "mouse",1);
        animals[3] = new Animal("Perry", "platypus",25);
        animals[4] = new Animal("Dog", "dog",13);
        int count=0;
        for(Animal a : animals){
            if(a.getAge()>10){
                System.out.println("Name:"+a.getName()+"\tSpezie: "+a.getSpecies()+"\talter: "+a.getAge());
            }
        }



    }
}
