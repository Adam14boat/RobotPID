package com.company;

public class AdamPID {
    AdamPID adampid = new AdamPID(1, 1, 1, 1);
    public double kP;
    public double kI;
    public double kD;
    public double LoopTime;
    public double error;
    public double Integral = 0;
    public double lastError = error;
    public double derivative;
    public AdamPID (double input_kP, double input_kI, double input_kD, double input_LoopTime) {
        kP = input_kP;
        kI = input_kI;
        kD = input_kD;
        LoopTime = input_LoopTime;

    }
    public void UpdateKP() {

    }
    public void UpdateKI() {

    }
    public void UpdateKD() {

    }
    public void setSetpoint(double ) {

    }
    public void update(double ) {
        error = targetDistance - driveSubsystem.getDistance(); //proportional
        Integral += error * LoopTime;
        derivative = (error - lastError) / LoopTime;
        adampid.setSpeed(kP * error + kI * Integral + kD * derivative); //PID
        lastError = error;
    }
    public double getOutput() {

    }
    public void reset(){

    }
}
