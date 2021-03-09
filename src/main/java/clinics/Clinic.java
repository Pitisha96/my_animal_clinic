package clinics;

import animals.Dog;
import animals.Pet;
import exceptions.ClientNotFoundException;
import exceptions.PetNotFoundException;

import java.io.Serializable;
import java.util.*;

/**
 * Класс реализующий клинику
 * @author Илья Петровский
 * @since 19.02.2021
 */
public class Clinic implements IClinic, Serializable {
    private Map<String,Client> clients;

    /**
     * {@inheritDoc}
     * @param client новый клиент
     */
    @Override
    public void addClient(Client client){
        if(clients ==null)
            clients=new TreeMap<>();
        clients.put(client.getName(),client);
    }

    /**
     * {@inheritDoc}
     * @param name имя клиента
     * @param pet новый питомец
     */
    @Override
    public void addPet(String name, Pet pet){
        if(!clients.containsKey(name))
            throw new ClientNotFoundException("Клиент с таким именем не существует");
        else
            clients.get(name).addPet(pet);
    }

    /**
     * {@inheritDoc}
     * @param name старое имя клиента
     * @param newName новое имя клиента
     */
    @Override
    public void updateClient(String name, String newName) {
        if(!clients.containsKey(name)) {
            throw new ClientNotFoundException("Клиент с таким именем не найден");
        }
        else{
            clients.get(name).setName(newName);
            clients.put(newName,clients.get(name));
            clients.remove(name);
        }

    }

    /**
     * {@inheritDoc}
     * @param nameClient имя хозяина питомца
     * @param oldName старое имя питомца
     * @param newName новое имя питомца
     */
    @Override
    public void updatePet(String nameClient, String oldName, String newName) {
        if(!clients.containsKey(nameClient)){
            throw new ClientNotFoundException("Клиент с таким именем не найден");
        }
        else{
            List<Pet> pets=clients.get(nameClient).getPets();
            if(!pets.contains(new Dog(oldName))){
                throw new PetNotFoundException("У этого клиента нет питомца с таким именем");
            }
            else{
                pets.forEach((pet)->{
                    if(pet.getName().equals(oldName))
                        pet.setName(newName);
                });
            }
        }
    }

    /**
     * {@inheritDoc}
     * @param name имя клиента
     */
    @Override
    public void deleteClient(String name) {
        if(!clients.containsKey(name))
            throw new ClientNotFoundException("Клиент с таким именем не найден");
        else
            clients.remove(name);
    }

    /**
     * {@inheritDoc}
     * @param nameClient имя хозяина
     * @param namePet имя питомца
     */
    @Override
    public void deletePet(String nameClient, String namePet) {
        if(!clients.containsKey(nameClient))
            throw new ClientNotFoundException("Клиент с таким именем не найден");
        else{
            List<Pet> pets=clients.get(nameClient).getPets();
            if(!pets.contains(new Dog(namePet))){
                throw new PetNotFoundException("нет питомца с таким именем");
            }else
                pets.removeIf(p->p.getName().equals(namePet));
        }
    }

    /**
     * {@inheritDoc}
     * @return список клиентов клиники
     */
     @Override
     public List<Client> getClients(){
        if(clients==null) return Collections.EMPTY_LIST;
        return new ArrayList<>(clients.values());
     }
}
