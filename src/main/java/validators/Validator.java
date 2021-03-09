package validators;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

/**
 * Валидатор ввода/вывода данных
 * @author Илья Петровский
 * @since 19.02.2021
 */
public class Validator implements Closeable {
    private final Scanner scanner;
    private final PrintStream ps;

    /**
     * Конструктор валидатора
     * @param is поток ввода данных
     * @param os поток вывода данных
     * @throws UnsupportedEncodingException - если кодировка Cp866 не поддерживается
     */
    public Validator(InputStream is, OutputStream os)
            throws UnsupportedEncodingException {
        this.scanner=new Scanner(is);
        this.ps=new PrintStream(os,false,"UTF-8");
    }

    /**
     * Вывод сообщения клиенту и получение номера операции
     * @param message сообщение клиенту
     * @return номер операции
     */
    public int getOperation(String message){
        ps.print(message);
        return scanner.nextInt();
    }

    /**
     * Вывод сообщения клиенту и получение от него информации в виде текста
     * @param message сообщение клиенту
     * @return информация от клиента
     */
    public String getInfo(String message){
        ps.print(message);
        scanner.useDelimiter("\n");
        return scanner.next();
    }

    /**
     * Вывод сообщения пользователю
     * @param o сообщение
     */
    public void println(Object o){
        ps.println(o);
    }


    /**
     * Возвращает номер введенной операции ,если такая присутствует
     * @param set список с номерами операций
     * @return номер выбранной операции
     * @throws InputMismatchException если введены не верные данный
     * @throws UnsupportedOperationException если введен номер не поддерживающей операции
     */
    public int getIntFromList(Set<Integer> set)
    throws InputMismatchException,UnsupportedOperationException {
        ps.print("введите номер операции: ");
        int num=scanner.nextInt();
        if(!set.contains(num))
            throw new UnsupportedOperationException("Такая операция не поддерживается");
        else
            return num;
    }

    public void print(Object o){
        this.ps.print(o);
    }

    @Override
    public void close(){
        scanner.close();
        ps.close();
    }
}
