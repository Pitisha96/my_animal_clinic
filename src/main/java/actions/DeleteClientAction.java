package actions;

import clinics.IClinic;
import validators.Validator;

public class DeleteClientAction implements IAction{
    @Override
    public void execute(IClinic clinic, Validator validator) {
        clinic.deleteClient(validator.getInfo("имя клиента: "));
    }

    @Override
    public String intro() {
        return String.format("%s - удалить клиента",key());
    }

    @Override
    public int key() {
        return 7;
    }
}
