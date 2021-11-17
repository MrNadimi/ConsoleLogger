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

    private static final Log LOG = Log.getLogger(MainClass.class).setWithAnsi(true);
    public static void main(String[] args){

        long now = System.currentTimeMillis();
        LOG.debug("Hi java Console Logger" );
        LOG.warn("Hi java Console Logger" );
        LOG.error("Hi java Console Logger" );
        LOG.trace("Hi java Console Logger" );
        LOG.info("Hi java Console Logger" );


    }
}
