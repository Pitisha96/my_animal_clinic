package actions;

import clinics.IClinic;
import validators.Validator;

public class DeletePetAction implements IAction{

    @Override
    public void execute(IClinic clinic, Validator validator) {
        clinic.deletePet(validator.getInfo("имя клиента: "),
                validator.getInfo("имя питомца: "));
    }

    @Override
    public String intro() {
        return String.format("%s - удалить питомца",key());
    }

    @Override
    public int key() {
        return 8;
    }
}
