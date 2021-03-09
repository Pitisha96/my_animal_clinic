package actions;

import clinics.IClinic;
import validators.Validator;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Интерфес одного действия клиники
 * @author Илья Петровский
 * @since 19.02.2021
 */
public interface IAction {
    /**
     * Выполнение действия клиники с помощью валидатора
     * @param clinic клиника
     * @param validator валидатор
     */
    void execute(IClinic clinic, Validator validator) throws IOException;

    /**
     * Возвращает описание действия клиники
     * @return описание
     */
    String intro();

    /**
     * Номер операции в интерфейсе клиники
     * @return номер операции
     */
    int key();
}
