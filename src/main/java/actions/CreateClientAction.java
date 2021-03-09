package actions;

import clinics.Client;
import clinics.IClinic;
import validators.Validator;

public class CreateClientAction implements IAction{

    @Override
    public void execute(IClinic clinic, Validator validator) {
        validator.println("------------------------------------");
        validator.println("Создание клиента:");
        clinic.addClient(new Client(validator.getInfo("Имя нового клиента: ")));
    }

    @Override
    public String intro() {
        return String.format("%s - создать клиента",key());
    }

    @Override
    public int key() {
        return 3;
    }
}
