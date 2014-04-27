package ru.hse.se.g272.ervo.ooaip.clock;

import javax.swing.JComponent;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;

/**
 * Часы.
 */
public class Clock extends JComponent implements Serializable {
    /**
     * Доля формы, которую занимают часы.
     */
    public static final double DIAMETER_MULTIPLICATION = 0.75;

    /**
     * Мультипликотор перевода секунд и минут в градусы.
     */
    public static final int SIXTY_TO_360_MULTIPLICATION = 6;

    /**
     * Мультипликотор перевода часов в градусы.
     */
    public static final int TWELVE_TO_360_MULTIPLICATION = 30;

    /**
     * Доля радиуса, которую занимает секундная стрелка.
     */
    public static final double SECOND_ARROW_MULTIPLICATION = 0.95;

    /**
     * Число 3.
     */
    public static final int INT = 3;

    /**
     * Доля радиуса, которую занимает минутная стрелка.
     */
    public static final double MINUTE_ARROW_MULTIPLICATION = (2.0 / INT);

    /**
     * Доля радиуса, которую занимает часовая стрелка.
     */
    public static final double HOUR_ARROW_MULTIPLICATION = 0.5;

    /**
     * Ширина минутной стрелки по умолчанию.
     */
    public static final float DEFAULT_MINUTE_ARROW_WIDTH = 5.0f;

    /**
     * Ширина часовой стрелки по умолчанию.
     */
    public static final float DEFAULT_HOUR_ARROW_WIDTH = 10.0f;

    /**
     * Секунды.
     */
    private int seconds;

    /**
     * Минуты.
     */
    private int minutes;

    /**
     * Часы.
     */
    private int hours;

    /**
     * Ширина секундной стрелки.
     */
    private float secondArrowWidth = new BasicStroke().getLineWidth();

    /**
     * Ширина минутной стрелки.
     */
    private float minuteArrowWidth = DEFAULT_MINUTE_ARROW_WIDTH;

    /**
     * Ширина часовой стрелки.
     */
    private float hourArrowWidth = DEFAULT_HOUR_ARROW_WIDTH;

    /**
     * Ширина круга часов.
     */
    private float circleWidth = DEFAULT_HOUR_ARROW_WIDTH;

    /**
     * Getter of secondArrowWidth property.
     * @return secondArrowWidth
     */
    public final float getSecondArrowWidth() {
        return secondArrowWidth;
    }

    /**
     * Setter of secondArrowWidth property.
     * @param width secondArrowWidth
     */
    public final void setSecondArrowWidth(final float width) {
        this.secondArrowWidth = width;
    }

    /**
     * Getter of minuteArrayWidth property.
     * @return minuteArrayWidth
     */
    public final float getMinuteArrowWidth() {
        return minuteArrowWidth;
    }

    /**
     * Setter of minuteArrayWidth property.
     * @param width minuteArrayWidth
     */
    public final void setMinuteArrowWidth(final float width) {
        this.minuteArrowWidth = width;
    }

    /**
     * Getter of hourArrowWidth property.
     * @return hourArrowWidth
     */
    public final float getHourArrowWidth() {
        return hourArrowWidth;
    }

    /**
     * Setter of hourArrowWidth property.
     * @param width hourArrowWidth
     */
    public final void setHourArrowWidth(final float width) {
        this.hourArrowWidth = width;
    }

    /**
     * Getter of seconds property.
     * @return seconds
     */
    public final int getSeconds() {
        return seconds;
    }

    /**
     * Setter of seconds property.
     * @param s seconds
     */
    public final void setSeconds(final int s) {
        this.seconds = s;
    }

    /**
     * Getter of minutes property.
     * @return minutes
     */
    public final int getMinutes() {
        return minutes;
    }

    /**
     * Setter of minutes property.
     * @param m minutes
     */
    public final void setMinutes(final int m) {
        this.minutes = m;
    }

    /**
     * Getter of hours property.
     * @return hours
     */
    public final int getHours() {
        return hours;
    }

    /**
     * Getter of circleWidth property.
     * @return hours
     */
    public final float getCircleWidth() {
        return circleWidth;
    }

    /**
     * Setter of circleWidth property.
     * @param cw circleWidth
     */
    public final void setCircleWidth(final float cw) {
        this.circleWidth = cw;
    }

    /**

     * Setter of hours property.
     * @param h hours
     */
    public final void setHours(final int h) {
        this.hours = h;
    }

    @Override
    protected final void paintComponent(final Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.translate(getWidth() / 2, getHeight() / 2);
        int min = Math.min(getWidth(), getHeight());
        int d = (int) (min * DIAMETER_MULTIPLICATION);
        int r = d / 2;
        double secRad = Math.toRadians(seconds * SIXTY_TO_360_MULTIPLICATION);
        double minRad = Math.toRadians(minutes * SIXTY_TO_360_MULTIPLICATION);
        double hourRad = Math.toRadians(hours * TWELVE_TO_360_MULTIPLICATION);
        g.setStroke(new BasicStroke(secondArrowWidth));
        g.drawLine(0, 0,
                (int) (r * SECOND_ARROW_MULTIPLICATION * Math.sin(secRad)),
                (int) (-r * SECOND_ARROW_MULTIPLICATION * Math.cos(secRad)));
                //секундная стрелка
        g.setStroke(new BasicStroke(minuteArrowWidth));
        g.drawLine(0, 0,
                (int) ((r * MINUTE_ARROW_MULTIPLICATION) * Math.sin(minRad)),
                (int) (-(r * MINUTE_ARROW_MULTIPLICATION) * Math.cos(minRad)));
                //минутная стрелка
        g.setStroke(new BasicStroke(hourArrowWidth));
        g.drawLine(0, 0,
                (int) ((r * HOUR_ARROW_MULTIPLICATION) * Math.sin(hourRad)),
                (int) (-(r * HOUR_ARROW_MULTIPLICATION) * Math.cos(hourRad)));
                //часовая стрелка
        g.setStroke(new BasicStroke(circleWidth));
        g.drawOval(-r, -r, d, d);
        g.fillOval((int)(-0.03*r), (int)(-0.03*r),
                (int)(0.03*d), (int)(0.03*d));
    }
}
