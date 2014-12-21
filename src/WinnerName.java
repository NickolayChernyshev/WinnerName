/**
 * Created by Николай on 14.12.2014.
 */
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class WinnerName extends JFrame implements ActionListener { //обеспечиваем прием события
    JLabel label = new JLabel("Имя игрока"); //поясняющая надпись "Имя игрока"
    JTextField textfield = new JTextField("Введите имя"); //поле для ввода имени
    JButton button = new JButton("ОК"); //кнопка подтверждения
    public WinnerName() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout()); //используется шаблон FlowLayout
        add(label);
        add(textfield);
        add(button); //добавляем надпись, текстовое поле и кнопку
        button.addActionListener(this);
        setSize(300,150); //размеры - 300 на 150
        setVisible(true);
    }
    static void saveToFile(String text) {
        BufferedWriter newBufferedWriter = null;
        try {
            newBufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Николай\\output.txt",true)); //путь к файлу, в который будут сохраняться имена победителей
            newBufferedWriter.append(text); //записываем текст, введенный в наше поле
            newBufferedWriter.newLine(); //переход на новую строку
            newBufferedWriter.close(); //закрываем BufferedWriter после окончания записи
        }
        catch(IOException exception) {
            System.out.println(exception); //вывод сообщения об ошибке при наличии таковой
        }
    }
    @Override //сообщение о реализации метода интерфейса
        public void actionPerformed(ActionEvent exception) {
            saveToFile(textfield.getText()); //реакция на действие - сохранение введенных в текстовое поле данных
        }
    public static void main(String args[]) {
        new WinnerName(); //запуск окна с запросом имени
    }
}
