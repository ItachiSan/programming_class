package lab_2.exercise_2;

/* Animals... */
class Animal {
    public String toString() {
        return " temmie "; // :3
    }
}
/* Can be dogs... */
class Dog extends Animal {
    public String toString() {
        return "  Doggo  ";
    }
}
/* Or cats */
class Cat extends Animal {
    public String toString() {
        return "FakeDoggo";
    }
}