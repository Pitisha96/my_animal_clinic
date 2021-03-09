import actions.*;
import clinics.Clinic;
import exceptions.ClientNotFoundException;
import exceptions.PetNotFoundException;
import validators.Validator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;

/**
 * Класс для запуска клиники
 * @author Илья Петровский
 * @since 20.02.2021
 */
public class ClinicRunner {
    public static void main(String[] args) {
        try(Validator validator=new Validator(System.in,System.out);
            FileInputStream fin=new FileInputStream("src/main/resources/clinic.bin");
            ObjectInputStream in=new ObjectInputStream(fin)) {
            ClinicUI clinic = new ClinicUI((Clinic) in.readObject(), validator);
            clinic.loadAction(new CreateClientAction());
            clinic.loadAction(new CreatePetAction());
            clinic.loadAction(new ShowClientsAction());
            clinic.loadAction(new UpdateClientAction());
            clinic.loadAction(new UpdatePetAction());
            clinic.loadAction(new DeleteClientAction());
            clinic.loadAction(new DeletePetAction());
            clinic.loadAction(new ExitAction());
            clinic.loadAction(new ShowPetsAction());
            do {
                clinic.showMenu();
                clinic.doAction();
            } while (true);
        }catch (ClientNotFoundException ex){
            ex.printStackTrace();
        }catch (PetNotFoundException ex) {
            ex.printStackTrace();
        }catch (UnsupportedEncodingException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
