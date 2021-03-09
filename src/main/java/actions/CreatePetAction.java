package actions;

import animals.Dog;
import clinics.IClinic;
import validators.Validator;

public class CreatePetAction implements IAction{

    @Override
    public void execute(IClinic clinic, Validator validator) {
        validator.println("------------------------------------");
        validator.println("Создание питомца: ");
        clinic.addPet(validator.getInfo("Имя хозяина питомца: "),
                new Dog(validator.getInfo("Имя питомца: ")));
    }

    @Override
    public String intro() {
        return String.format("%s - создать питомца",key());
    }

    @Override
    public int key(){
        return 4;
    }
}
