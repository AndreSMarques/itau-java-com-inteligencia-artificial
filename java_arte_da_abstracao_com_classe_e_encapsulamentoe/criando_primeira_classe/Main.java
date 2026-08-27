public class Main {
    
    public static void main(String[] args) {
        var male = new Person();
        male.setName("jão");
        male.setAge(14);

        var female = new Person();
        female.setName("Marelson");
        female.setAge(15);

        System.out.println("Male nome: " + male.getName() + " age: " + male.getAge());
        System.out.println("Female nome: " + female.getName() + " age: " + female.getAge());
    }
}
