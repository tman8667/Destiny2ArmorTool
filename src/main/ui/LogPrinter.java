package ui;

import model.EventLog;
import model.exception.LogException;

// Defines behaviours that event log printers must support
// Code adapted from AlarmSystem project
public interface LogPrinter {
    void printLog(EventLog el) throws LogException;
}
