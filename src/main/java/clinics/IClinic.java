package clinics;

import animals.Pet;

import java.util.List;

/**
 * Абстрагирует интерфейс клиники
 * @author Илья Петровский
 * @since 18.02.2021
 */
public interface IClinic {
    /**
     * Доюавление клиента
     * @param client новый клиент
     */
    void addClient(Client client);

    /**
     * Добавление питомца Клиенту
     * @param name имя клиента
     * @param pet новый питомец
     */
    void addPet(String name, Pet pet);

    /**
     * Смена имени клиента
     * @param name старое имя клиента
     * @param newName новое имя клиента
     */
    void updateClient(String name,String newName);

    /**
     * Меняем имя клиента
     * @param nameClient имя хозяина питомца
     * @param oldName старое имя питомца
     * @param newName новое имя питомца
     */
    void updatePet(String nameClient, String oldName, String newName);

    /**
     * Удаление клиента
     * @param name имя клиента
     */
    void deleteClient(String name);

    /**
     * Удаление питомца
     * @param nameClient имя хозяина
     * @param namePet имя питомца
     */
    void deletePet(String nameClient,String namePet);

    /**
     * Получить список всех клиентов
     * @return список клиентов клиники
     */
    List<Client> getClients();
}
