package actions;

import clinics.IClinic;
import validators.Validator;

public class UpdatePetAction implements IAction{
    @Override
    public void execute(IClinic clinic, Validator validator) {
        clinic.updatePet(validator.getInfo("имя клиента: "),
                validator.getInfo("имя питомца: "),
                validator.getInfo("новое имя питомца: "));
    }

    @Override
    public String intro() {
        return String.format("%s - переименовать питомца",key());
    }

    @Override
    public int key() {
        return 6;
    }
}
