package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm extends SimpleArm {

  private final Servo grabber;

  public Arm(DcMotor liftMotor, Servo grabber, double openPos, double closedPos) {
    super(liftMotor);
    this.grabber = grabber;

    initScaleRange(openPos, closedPos);
  }

  private void initScaleRange(double openPos, double closedPos) {
    if (openPos > closedPos) {
      grabber.setDirection(Servo.Direction.REVERSE);
      grabber.scaleRange(1 - openPos, 1 - closedPos);
    } else {
      grabber.scaleRange(openPos, closedPos);
    }
  }

  public void openGrabber() {
    setGrabberPosition(0.0);
  }

  public void closeGrabber() {
    setGrabberPosition(1.0);
  }

  public void moveGrabber(double offset) {
    setGrabberPosition(getGrabberPosition() + offset);
  }

  public void setGrabberPosition(double position) {
    grabber.setPosition(position);
  }

  public double getGrabberPosition() {
    return grabber.getPosition();
  }
}
