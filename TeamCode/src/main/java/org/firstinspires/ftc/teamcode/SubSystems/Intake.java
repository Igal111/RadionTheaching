package org.firstinspires.ftc.teamcode.SubSystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    DcMotor intake;
    CRServo right;
    CRServo left;

    public void init(HardwareMap hardwareMap) {
        intake = hardwareMap.get(DcMotor.class,"intake");

        intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        right = hardwareMap.get(CRServo.class,"Right");
        left = hardwareMap.get(CRServo.class,"Left");

        right.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void setPower(double power) {
        intake.setPower(power);
        right.setPower(power);
        left.setPower(power);
    }

    public void intake (Gamepad gamepad) {
        if (gamepad.a) {
            setPower(1);
        }
        else if (gamepad.b) {
            setPower(-1);
        }
        else {
            setPower(0);
        }
    }
}