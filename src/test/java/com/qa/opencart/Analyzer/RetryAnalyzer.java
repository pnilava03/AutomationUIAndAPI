package com.qa.opencart.Analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int count=0;
    int maximumTryCount =3;

    @Override
    public boolean retry(ITestResult result) {
        if(count<maximumTryCount){
            count++;
            return true;
        }
        return false;
    }




}
