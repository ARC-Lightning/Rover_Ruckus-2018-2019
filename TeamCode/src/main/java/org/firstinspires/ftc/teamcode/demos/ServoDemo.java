package org.firstinspires.ftc.teamcode.demos;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import java.util.ArrayList;


@TeleOp(name = "ServoDemo", group = "ARC")
public class ServoDemo extends OpMode {

  //private DriveTrain drive;
  protected ArrayList<Servo> servos;
  private double servoPosition = -10;
  private double increment = 0.01;
  protected CRServo servo;

  @Override
  public void init() {
    /*DcMotor motorL = hardwareMap.dcMotor.get("motorL");
    DcMotor motorR = hardwareMap.dcMotor.get("motorR");
    motorR.setDirection(Direction.REVERSE);*/

    servos = new ArrayList<Servo>();
    servo = hardwareMap.crservo.get("servo0");
    //servos.add(hardwareMap.servo.get("servo0"));
    /*servos.add(hardwareMap.servo.get("servo1"));
    servos.add(hardwareMap.servo.get("servo2"));
    servos.add(hardwareMap.servo.get("servo3"));
    servos.add(hardwareMap.servo.get("servo4"));
    servos.add(hardwareMap.servo.get("servo5"));*/

    //drive = TankDrive.fromMotors(motorL, motorR, this, 1, 1);
  }

  @Override
  public void loop() {
    /*drive.setMovementAndRotation(-gamepad1.left_stick_y, gamepad1.left_stick_x);
    telemetry.addData("Left stick y", -gamepad1.left_stick_y);
    telemetry.addData("Left stick x", gamepad1.left_stick_x);
    telemetry.update();*/

    servoPosition = (servoPosition + increment);
    //if(Math.abs(servoPosition) > 1)
    //  increment *= -1;
    for(int i = 0; i < servos.size(); i++) {
      servos.get(i).setPosition(servoPosition);
    }
    servo.setPower(0.5);
    telemetry.addData("servoPosition", servoPosition);
    telemetry.update();
  }

}