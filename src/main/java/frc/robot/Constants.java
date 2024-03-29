// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final int CONTROLLERPORT = 0;
    public static final int R2CONTROLLERPORT = 1;

    // Robot One //
    public static final int R1T1 = 0;
    public static final int R1T2 = 1;
    public static final int R1V1 = 1;
    public static final int R1V2 = 0;
    public static final int R1SE = 8;
    public static final int R1SO = 4;

    // Robot Two //
    public static final int R2T1 = 2;
    public static final int R2T2 = 3;
    public static final int R2V1 = 2;
    public static final int R2V2 = 3;
    public static final int R2SE = 9;
    public static final int R2SO = 5;

    // Field //
    public static final int FSP = 7; //Field Servo Port
    public static final int FSWT = 60; //Field Servo Wait Time (s)
}
