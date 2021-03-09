package animals;

import java.io.Serializable;
import java.util.Objects;

/**
 * Реализация питомца - собака
 * @author Илья Петровский
 * @since 18.02.2021
 */
public class Dog implements Pet, Serializable {
    private String name;

    /**
     * Конструктор
     * @param name имя питомца
     */
    public Dog(String name){
        this.name=name;
    }

    /**
     * {inherit Doc}
     * @param name новое имя питомца
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     * @return имя питомца
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void move(){

    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || this.getClass()!=o.getClass()) return false;
        Dog dog=(Dog) o;
        return Objects.equals(name, dog.getName());
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }

}
