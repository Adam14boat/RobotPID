package robot;

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
    public double setpoint;
    public double distance;
    public AdamPID (double input_kP, double input_kI, double input_kD, double input_LoopTime) {
        kP = input_kP;
        kI = input_kI;
        kD = input_kD;
        LoopTime = input_LoopTime;

    }

    public void UpdateKP(double kP) {
        this.kP = kP;
    }
    public void UpdateKI(double kI) {
        this.kI = kI;
    }
    public void UpdateKD(double kD) {
        this.kD = kD;
    }
    public void setSetpoint(double targetSetpoint) {
       setpoint = targetSetpoint;
    }
    public void update(double distance) {
        error = setpoint - distance; //proportional
        Integral += error * LoopTime;
        derivative = (error - lastError) / LoopTime;
        adampid.getOutput(); //PID
        lastError = error;
        UpdateKD(kP);
        UpdateKI(kI);
        UpdateKP(kP);
    }
    public double getOutput() {
        return kP * error + kI * Integral + kD * derivative;
    }
    public void reset(){
        Integral = 0;
        lastError = error;
    }
}
