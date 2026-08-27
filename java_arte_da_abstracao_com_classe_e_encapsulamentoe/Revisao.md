# Revisão: abstração, classes e encapsulamento em Java

Este material resume três conceitos fundamentais da programação orientada a objetos em Java: **classes**, **abstração** e **encapsulamento**.

## 1. Classe

Uma classe é um modelo usado para criar objetos. Ela define:

- **Atributos**: os dados ou características do objeto.
- **Métodos**: os comportamentos ou ações do objeto.
- **Construtores**: os métodos usados para inicializar um objeto.

### Exemplo de classe

```java
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("Meu nome é " + name + " e tenho " + age + " anos.");
    }
}
```

Para criar e utilizar um objeto dessa classe:

```java
public class Main {
    public static void main(String[] args) {
        Person person = new Person("Ana", 25);
        person.introduce();
    }
}
```

Nesse exemplo, `Person` é a classe e `person` é um objeto criado a partir dela.

## 2. Abstração

Abstração é o processo de representar apenas as características e comportamentos importantes de algo, escondendo detalhes desnecessários para quem utiliza o objeto.

Em Java, a abstração pode ser feita principalmente com:

- **Classes abstratas**, usando a palavra-chave `abstract`.
- **Interfaces**, que definem comportamentos que uma classe deve implementar.

### Exemplo com classe abstrata

Uma classe abstrata não pode ser instanciada diretamente. Ela serve como base para outras classes.

```java
public abstract class Animal {
    public abstract void makeSound();

    public void sleep() {
        System.out.println("O animal está dormindo.");
    }
}
```

As classes filhas precisam implementar o método abstrato:

```java
public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Au au!");
    }
}
```

Uso:

```java
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();
        dog.sleep();
    }
}
```

Quem usa `Dog` precisa saber que ele possui o comportamento `makeSound()`, mas não precisa conhecer todos os detalhes internos de como esse som é produzido.

### Exemplo com interface

Uma interface define um contrato. A classe que a implementa deve fornecer o comportamento definido nesse contrato.

```java
public interface Payment {
    void pay(double amount);
}
```

```java
public class PixPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Pagamento via Pix: R$ " + amount);
    }
}
```

```java
Payment payment = new PixPayment();
payment.pay(100.00);
```

A variável pode ser do tipo `Payment`, sem depender diretamente dos detalhes da implementação `PixPayment`.

## 3. Encapsulamento

Encapsulamento é a proteção dos dados internos de um objeto. Em vez de permitir que qualquer código altere os atributos diretamente, a classe controla o acesso por meio de métodos públicos.

Para aplicar encapsulamento, é comum:

- Declarar atributos como `private`.
- Criar métodos `public` para consultar ou alterar os dados.
- Validar os valores antes de armazená-los.

### Exemplo básico

```java
public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

Os atributos `name` e `age` não podem ser acessados diretamente de outra classe:

```java
Person person = new Person();

// Não é permitido:
// person.age = -10;

person.setAge(25);
System.out.println(person.getAge());
```

### Encapsulamento com validação

O encapsulamento fica mais útil quando os métodos impedem estados inválidos:

```java
public class BankAccount {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("O depósito deve ser positivo.");
        }

        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            throw new IllegalArgumentException("Saque inválido.");
        }

        balance -= amount;
    }
}
```

Nesse caso, o saldo não pode ser alterado diretamente. A própria classe garante que depósitos e saques sigam as regras definidas.

## 4. Diferença entre abstração e encapsulamento

| Conceito | Pergunta principal | Objetivo |
| --- | --- | --- |
| Abstração | "O que é importante mostrar?" | Esconder detalhes desnecessários e expor uma ideia simplificada. |
| Encapsulamento | "Como proteger os dados?" | Controlar o acesso e manter o objeto em um estado válido. |

Uma forma simples de lembrar:

- **Abstração** reduz a complexidade para quem usa a classe.
- **Encapsulamento** protege a implementação e os dados internos da classe.

## 5. Exemplo reunindo os conceitos

```java
public abstract class Vehicle {
    private String model;

    public Vehicle(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public abstract void move();
}
```

```java
public class Car extends Vehicle {
    public Car(String model) {
        super(model);
    }

    @Override
    public void move() {
        System.out.println(getModel() + " está se movendo.");
    }
}
```

Nesse exemplo:

- `Vehicle` é uma **classe**.
- `Vehicle` é **abstrata** e define o comportamento `move()`.
- `model` está encapsulado com `private`.
- `getModel()` oferece acesso controlado ao modelo.
- `Car` herda de `Vehicle` e implementa o comportamento específico.

## Resumo rápido

- Classe é um modelo para criar objetos.
- Objeto é uma instância de uma classe.
- Atributos representam dados.
- Métodos representam comportamentos.
- Abstração mostra somente o que é essencial.
- Encapsulamento protege os dados e controla alterações.
- `private` restringe o acesso direto aos atributos.
- `public` permite o acesso por métodos ou operações definidas.
- `abstract` indica uma classe ou método que serve como base para outras classes.
- Getters consultam valores; setters alteram valores, normalmente com validações.

## Perguntas para revisar

1. Qual é a diferença entre uma classe e um objeto?
2. Por que os atributos geralmente são declarados como `private`?
3. Uma classe abstrata pode ser instanciada diretamente?
4. Qual é a função de um método abstrato?
5. Como um método pode proteger um atributo contra valores inválidos?
6. Quando uma interface pode ser útil?
