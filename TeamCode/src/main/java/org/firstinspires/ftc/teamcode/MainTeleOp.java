package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.SubSystems.Intake;
import org.firstinspires.ftc.teamcode.SubSystems.MecanumDrive;

@TeleOp
public class MainTeleOp extends LinearOpMode {
    MecanumDrive mecanumDrive = new MecanumDrive();
    Intake intake = new Intake();

    @Override
    public void runOpMode() throws InterruptedException {
        mecanumDrive.init(hardwareMap);
        intake.init(hardwareMap);
        waitForStart();

        while (opModeIsActive()) {
            mecanumDrive.drive(gamepad1);
            intake.intake(gamepad1);
        }
    }
}
