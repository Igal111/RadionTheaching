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

    public void intake (Gamepad gamepad) {
        if (gamepad.a) {
            intake.setPower(1);
            right.setPower(1);
            left.setPower(1);
        }
        else if (gamepad.b) {
            intake.setPower(-1);
            right.setPower(-1);
            left.setPower(-1);
        }
        else {
            intake.setPower(0);
            right.setPower(0);
            left.setPower(0);
        }
    }
}