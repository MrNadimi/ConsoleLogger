package com.mrnadimi.consolelogger;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

import java.awt.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.BOLD;
import static com.diogonunes.jcolor.Attribute.BRIGHT_YELLOW_TEXT;

/**
 * Developer: Mohamad Nadimi
 * Company: Saghe
 * Website: https://www.mrnadimi.com
 * Created on 17 November 2021
 * <p>
 * Description: ...
 */
public class Log {

    private boolean withAnsi;

    public static Log getLogger(Class<?> logClass){
        return new Log(logClass);
    }


    private final Class<?> logClass;

    private Log(Class<?> logClass) {
        this.logClass = logClass;
        withAnsi = false;
    }

    public Log setWithAnsi(boolean withAnsi) {
        this.withAnsi = withAnsi;
        return this;
    }

    public boolean isWithAnsi() {
        return withAnsi;
    }

    /**
     * Logs an error with debug log level.
     *
     * @param message log this message
     */
    public void debug(Object message){
        print(Level.DEBUG , message , null);
    }


    /**
     * Logs an error with debug log level.
     *
     * @param message log this message
     * @param t log this cause
     */
    public void debug(Object message, Throwable t){
        print(Level.DEBUG , message , t);
    }

    /**
     * Logs a message with error log level.
     *
     * @param message log this message
     */
    public void error(Object message){
        print(Level.ERROR , message , null);
    }

    /**
     * Logs an error with error log level.
     *
     * @param message log this message
     * @param t log this cause
     */
    public void error(Object message, Throwable t){
        print(Level.ERROR , message , t);
    }


    /**
     * Logs a message with info log level.
     *
     * @param message log this message
     */
    public void info(Object message){
        print(Level.INFO , message , null);
    }

    /**
     * Logs an error with info log level.
     *
     * @param message log this message
     * @param t log this cause
     */
    public void info(Object message, Throwable t){
        print(Level.INFO , message , t);
    }


    /**
     * Logs a message with trace log level.
     *
     * @param message log this message
     */
    public void trace(Object message){
        print(Level.TRACE , message , null);
    }

    /**
     * Logs an error with trace log level.
     *
     * @param message log this message
     * @param t log this cause
     */
    public void trace(Object message, Throwable t){
        print(Level.TRACE , message , t);
    }

    /**
     * Logs a message with warn log level.
     *
     * @param message log this message
     */
    public void warn(Object message){
        print(Level.WARN , message , null);
    }

    /**
     * Logs an error with warn log level.
     *
     * @param message log this message
     * @param t log this cause
     */
    public void warn(Object message, Throwable t){
        print(Level.WARN , message , t);
    }

    public Class<?> getLogClass() {
        return logClass;
    }

    private String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw));
        return "\n"+sw.toString();
    }

    private String getDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }


    private void print(Level tag, Object message , Throwable ex){
        System.out.println(
                getDate()+" "+(withAnsi ? getColorizedTag(tag) : tag.toString())+
                        " ["+Thread.currentThread().getName()+"] "+
                        (withAnsi ? getColorizedLogger() : logClass.getName())+" "+
                        (message == null ? null : message instanceof Throwable ? getStackTrace((Throwable) message): message.toString())+" "+
                        (ex == null ? "" : withAnsi ? getColorizedThrow(ex) : getStackTrace(ex))
        );
    }

    private String getColorizedTag(Level tag){
        switch (tag){
            case INFO:
                return Ansi.colorize(" "+tag.toString(), Attribute.BOLD(), Attribute.GREEN_TEXT());
            case WARN:
                return Ansi.colorize(" "+tag.toString(), Attribute.BOLD(), Attribute.YELLOW_TEXT());
            case DEBUG:
                return Ansi.colorize(tag.toString(), Attribute.BOLD(), Attribute.BRIGHT_GREEN_TEXT());
            case ERROR:
                return Ansi.colorize(tag.toString(), Attribute.BOLD(), Attribute.RED_TEXT());
            case FATAL:
                return Ansi.colorize(tag.toString(), Attribute.BOLD(), Attribute.BRIGHT_BLUE_TEXT());
            case TRACE:
                return Ansi.colorize(tag.toString(), Attribute.BOLD(), Attribute.BLUE_TEXT());
            default:
                return Ansi.colorize(tag.toString(), Attribute.BOLD(), Attribute.GREEN_TEXT());
        }
    }

    private String getColorizedLogger(){
        return Ansi.colorize(logClass.getName(), Attribute.TEXT_COLOR(8,143,143));
    }

    private String getColorizedThrow(Throwable th){
        return Ansi.colorize(getStackTrace(th), Attribute.RED_TEXT());
    }

    private enum Level{
        DEBUG,TRACE,INFO,WARN,ERROR,FATAL;
    }






}
