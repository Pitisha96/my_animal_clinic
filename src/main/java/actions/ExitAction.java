package actions;

import clinics.IClinic;
import validators.Validator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ExitAction implements IAction{
    @Override
    public void execute(IClinic clinic, Validator validator){
        try(FileOutputStream fos=new FileOutputStream("src/main/resources/clinic.bin");
            ObjectOutputStream out=new ObjectOutputStream(fos)
        ){
            out.writeObject(clinic);
        }catch(IOException ex){
            ex.printStackTrace();
        }
        System.exit(0);
    }

    @Override
    public String intro() {
        return String.format("%s - выйти из программы",key());
    }

    public int key(){
        return 9;
    }
}
