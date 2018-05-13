package ru.esphere.listener;

import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ApiListener implements ITestListener {

    private ByteArrayOutputStream outputStreamRequest = new ByteArrayOutputStream();
    private ByteArrayOutputStream outputStreamResponse = new ByteArrayOutputStream();

    private PrintStream printStreamRequest = new PrintStream(outputStreamRequest, true);
    private PrintStream printStreamResponse = new PrintStream(outputStreamResponse, true);

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logRequest(outputStreamRequest);
        logResponse(outputStreamResponse);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logRequest(outputStreamRequest);
        logResponse(outputStreamResponse);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        RestAssured.filters(new ResponseLoggingFilter(LogDetail.ALL, printStreamResponse),
                new RequestLoggingFilter(LogDetail.ALL, printStreamRequest));
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    @Attachment(value = "request")
    public byte[] logRequest(ByteArrayOutputStream stream) {
        return attachLog(stream);
    }

    @Attachment(value = "response")
    public byte[] logResponse(ByteArrayOutputStream stream) {
        return attachLog(stream);
    }

    public byte[] attachLog(ByteArrayOutputStream log) {
        byte[] array = log.toByteArray();
        log.reset();
        return array;
    }
}
