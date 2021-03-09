package actions;

import clinics.IClinic;
import validators.Validator;

public class ShowClientsAction implements IAction{

    @Override
    public void execute(IClinic clinic, Validator validator) {
        validator.println("------------------------------------");
        validator.println("Список клиентов: ");
        clinic.getClients().forEach(c->validator.println(c.getName()));
    }

    @Override
    public String intro() {
        return String.format("%s - показать клиентов",key());
    }

    @Override
    public int key() {
        return 1;
    }
}
