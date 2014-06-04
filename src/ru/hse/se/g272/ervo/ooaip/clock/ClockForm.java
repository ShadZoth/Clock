package ru.hse.se.g272.ervo.ooaip.clock;

import ru.hse.se.g272.ervo.Now;
import ru.hse.se.g272.ervo.ooaip.Form;
import ru.hse.se.g272.ervo.ooaip.TimerForm;

import javax.swing.*;

/**
 * Форма с изображением аналоговых часов.
 */
public class ClockForm extends TimerForm {

    /**
     * Часы.
     */
    private final Clock clock;

    /**
     * Создаёт форму с часами.
     */
    public ClockForm() {
        setTitle("Часы");
        clock = new Clock();
        add(clock);
    }

    /**
     * Метод, вызываемый при запуске программы.
     * @param args Аргументы командной строки
     */
    public static void main(final String[] args) {
        final ClockForm form = new ClockForm();
        form.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        form.pack();
        form.setVisible(true);
        form.setDefaultSize(Form.FULLSCREEN);
        form.setActionListener(actionEvent -> {
            form.getClock().setSeconds(Now.getSeconds());
            form.getClock().setMinutes(Now.getMinutes());
            form.getClock().setHours(Now.getHours());
            form.repaint();
        });
        form.setActioning(true);
    }

    /**
     * Getter for clock property.
     * @return clock
     */
    public final Clock getClock() {
        return clock;
    }
}





