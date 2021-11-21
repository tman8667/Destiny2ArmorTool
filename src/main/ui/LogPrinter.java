package ui;


import model.EventLog;
import model.exceptions.LogException;

/**
 * Defines behaviours that event log printers must support.
 *
 * Copied from AlarmSystem demo project
 */
public interface LogPrinter {
    /**
     * Prints the log
     * @param el  the event log to be printed
     * @throws LogException when printing fails for any reason
     */
    void printLog(EventLog el) throws LogException;
}
