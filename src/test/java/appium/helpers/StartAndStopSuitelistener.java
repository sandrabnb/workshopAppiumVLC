package appium.helpers;

import org.testng.IExecutionListener;

public class StartAndStopSuitelistener implements IExecutionListener {

    private long StartTime;

    @Override
    public void onExecutionStart() {
        long startTime = System.currentTimeMillis();
        System.out.println("TESTS ARE GOING TO START AT "+startTime);
    }

    @Override
    public void onExecutionFinish() {
        long finishTime = System.currentTimeMillis();
        System.out.println("TEST HAVE FINISHED AT "+ finishTime);
    }
}
