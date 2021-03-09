package actions;

import animals.Pet;
import clinics.Client;
import clinics.IClinic;
import validators.Validator;

import java.io.IOException;
import java.util.List;

public class ShowPetsAction implements IAction{
    /**
     * Выводит список питомцев на экран
     * @param clinic клиника
     * @param validator валидатор
     * @throws IOException
     */
    @Override
    public void execute(IClinic clinic, Validator validator) throws IOException {
        List<Client> clients = clinic.getClients();
        clients.forEach(c->{
            validator.print(String.format("%s:",c.getName()));
            List<Pet> pets =c.getPets();
            pets.forEach(p-> validator.print(String.format(" %s|",p.getName())));
            validator.println("");
        });
    }

    @Override
    public String intro() {
        return String.format("%s - список питомцев",key());
    }

    @Override
    public int key() {
        return 2;
    }
}
