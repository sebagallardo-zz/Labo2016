package cinco;

public class Veterinaria<E> {
    private E animal;
    public void setAnimal(E x) {
        animal = x;
    }
    public E getAnimal() {
        return animal;
    }
    
    public static void main(String[] args) {
		Veterinaria<?> vet = new Veterinaria<Gato>();
		Veterinaria<?> vet2 = new Veterinaria<Perro>();
//		vet.setAnimal(new Gato())
		
	}
}

class Animal{
}

class Gato extends Animal {
}

class Perro extends Animal {
}


