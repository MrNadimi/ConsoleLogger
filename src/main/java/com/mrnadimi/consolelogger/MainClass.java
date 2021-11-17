package com.mrnadimi.consolelogger;



/**
 * Developer: Mohamad Nadimi
 * Company: Saghe
 * Website: https://www.mrnadimi.com
 * Created on 17 November 2021
 * <p>
 * Description: ...
 */
public class MainClass {

    private static final Log LOG = Log.getLogger(MainClass.class).setWithAnsi(false);
    public static void main(String[] args){

        long now = System.currentTimeMillis();
        for (int i = 0 ; i < 10000 ; i ++)
        LOG.debug("salam" );


        LOG.trace(System.currentTimeMillis() - now);
    }
}
