package actions;

import clinics.IClinic;
import validators.Validator;

public class UpdateClientAction implements IAction{
    @Override
    public void execute(IClinic clinic, Validator validator) {
        clinic.updateClient(validator.getInfo("имя клиента:"), validator.getInfo("новое имя клиента:"));
    }

    @Override
    public String intro() {
        return String.format("%s - переименовать клиента",key());
    }

    @Override
    public int key() {
        return 5;
    }
}
