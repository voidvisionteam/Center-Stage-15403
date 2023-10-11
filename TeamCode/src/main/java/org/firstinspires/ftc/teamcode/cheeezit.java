package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;



@TeleOp(name="cheezit", group="Pushbot")
public class cheeezit extends Auto_Util {
    practicehwwmap robot=new practicehwwmap();

    private ElapsedTime runtime = new ElapsedTime();

    static double turnPower;
    static double fwdBackPower;
    static double strafePower;
    static double lbPower;
    static double lfPower;
    static double rbPower;
    static double rfPower;
    static double slowamount;
    @Override
    public void runOpMode(){
        robot.init(hardwareMap);
        initAuto();
        telemetry.addData("Status,", "Ready to run");
        telemetry.update();
        waitForStart();

        while(opModeIsActive()) {

            //Drive

            fwdBackPower = -gamepad1.left_stick_y;
            strafePower =-gamepad1.left_stick_x;
            turnPower=-gamepad1.right_stick_x;

            lfPower = (fwdBackPower - turnPower-strafePower);
            rfPower = (fwdBackPower+turnPower+strafePower);
            lbPower = (fwdBackPower-turnPower+strafePower);
            rbPower = (fwdBackPower+turnPower-strafePower);

            robot.leftfrontDrive.setPower(lfPower*slowamount);
            robot.leftbackDrive.setPower(lbPower*slowamount);
            robot.rightfrontDrive.setPower(rfPower*slowamount);
            robot.rightbackDrive.setPower(rbPower*slowamount);

        }








    }











}