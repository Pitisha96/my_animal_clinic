package animals;

/**
 * Интерфейс, который абстрагирует всех домашних животных
 * @author Илья Петровский
 * @since 18.02.2021
 */
public interface Pet {
    /**
     * Возвращает имя питомца
     * @return имя питомца
     */
    String getName();

    /**
     * Дает имя питомцу
     * @param name новое имя питомца
     */
    void setName(String name);

    /**
     * Питомец играет
     */
    void move();
}
