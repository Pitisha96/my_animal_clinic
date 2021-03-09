import actions.IAction;
import clinics.IClinic;
import validators.Validator;

import javax.swing.*;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Класс пользовательского интерфейса
 * @author Илья Петровский
 * @since 19.02.2021
 */
public class ClinicUI {
    private final IClinic clinic;
    private final Validator validator;
    private Map<Integer, IAction> actions=new ConcurrentHashMap<>();

    /**
     * Конструктор клиники
     * @param clinic клиника
     * @param validator валидатор
     */
    public ClinicUI(IClinic clinic,Validator validator){
        this.clinic=clinic;
        this.validator=validator;
    }

    /**
     * Просит пользователя ввести номер операции
     */
    public void doAction() throws IOException {
        actions.get(validator.getIntFromList(actions.keySet()))
                .execute(clinic,validator);
    }

    /**
     * Добавление новой операции для клиники
     * @param action операция
     */
    public void loadAction(IAction action){
        actions.put(action.key(),action);
    }

    /**
     * Показывает меню клиники
     */
    public void showMenu(){
        validator.println("------------------------------------");
        actions.values().forEach(a->validator.println(a.intro()));
        validator.println("------------------------------------");
    }
}
