package org.firstinspires.ftc.teamcode.SubSystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.controller.PIDController;

public class FlyWheel {
    private DcMotorEx flyWheel;
    private final double P = 0;
    private final double I = 0;
    private final double D = 0;
    private final double Fs = 0;
    private final double Fv = 0;
    private PIDController pidController;

    private final double ticksToRPM = (double) 60 / 28;

    public void init(HardwareMap hardwareMap) {
        flyWheel = hardwareMap.get(DcMotorEx.class, "flyWheel");
        flyWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        pidController = new PIDController(P,I,D);
    }

    public double convertTicksToRPM(double ticks) {
        return ticks * ticksToRPM;
    }

    public double convertRpmToTicks(double rpm) {
        return rpm / ticksToRPM;
    }
    public void setRPM(int targetRPM) {
        double flyWheelVel = flyWheel.getVelocity();
        double targetTicks = convertRpmToTicks(targetRPM);

        double pidPower = pidController.calculate(flyWheelVel, targetTicks);
        double power = pidPower + Fs + Fv;

        flyWheel.setPower(power);
    }
}
