package clinics;

import animals.Pet;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Клиент клиники
 * @author Илья Петровский
 * @since 18.02.2021
 */
public class Client implements Serializable {
    private String name;
    private List<Pet> pets;

    /**
     * Конструктор
     * @param name имя клиента
     */
    public Client(String name){
        this.name=name;
    }

    /**
     * Конструктор с 2 параметрами
     * @param name имя клиента
     * @param pet имя питомца
     */
    public Client(String name, Pet pet){
        this.name=name;
        pets = new LinkedList<>();
        pets.add(pet);
    }

    /**
     * @return имя клиента
     */
    public String getName() {
        return name;
    }

    /**
     * Задать имя клиента
     * @param name имя клиента
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Добавление питомца клиенту
     * @param pet новый питомец
     */
    public void addPet(Pet pet){
        if(pets==null){
            pets = new LinkedList<>();
        }
        pets.add(pet);
    }

    /**
     * Получаем список питомцев клиента
     * @return
     */
    public List<Pet> getPets() {
        if(pets==null) return Collections.emptyList();
        return pets;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
