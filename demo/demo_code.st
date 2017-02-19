<?xml version="1.0" encoding="UTF-8"?><session xmlns="http://formal.iti.kit.edu/stvs/logic/io/xml">
<code>
<plaintext>TYPE
  OpMode : (Op , Teach);
  TeachStatus :  (Ok, NoTeachPoints, Teaching, InvalidTeachPoints, InvalidInputValue);
END_TYPE


FUNCTION_BLOCK TON

VAR_INPUT
    IN : BOOL;
    PT : USINT;
END_VAR

VAR_OUTPUT
    Q  : BOOL;
    ET : USINT;
END_VAR

IF IN THEN
    Q:= ET = USINT#0;
    IF ET &gt; USINT#0 THEN
        ET := ET - USINT#1;
    ELSE
        ET := USINT#0;
    END_IF
ELSE
    Q  := FALSE;
    ET := PT;
END_IF;

END_FUNCTION_BLOCK


PROGRAM  Analogsensor

VAR CONSTANT
  SENSORINPUT_MIN : INT := 0;
  SENSORINPUT_MAX : INT := 4095;
  TEACHTIMEOUT : TIME := TIME#20s0ms;
  ICONST : INT := 1000;
END_VAR

VAR_INPUT
  TPSet, SensorInput, TPy  : INT;
  OperationMode : OpMode;
END_VAR

VAR_OUTPUT
  SensorOutput : INT;
END_VAR

VAR
  initial          : BOOL;
  lastmode : OpMode;
  Status        : TeachStatus;
  teachstep : SINT;
  x_temp, y_temp, t, m, x1, y1, x2, y2 : INT;

  timeout : TON;
END_VAR

IF NOT initial THEN
  x1 := 0;
  y1 := 0;
  x2 := 0;
  y2 := 0;
  Status := TeachStatus#NoTeachPoints;
  initial := TRUE;
ELSE
  IF OperationMode = OpMode#Op THEN
    IF Status = TeachStatus#Ok AND SensorInput &gt;= SENSORINPUT_MIN AND SensorInput &lt;= SENSORINPUT_MAX THEN
      SensorOutput := m * SensorInput / ICONST + t;
    ELSE
      SensorOutput := 0;
    END_IF;
  ELSIF OperationMode = OpMode#Teach THEN
    IF lastmode &lt;&gt; OperationMode THEN
      teachstep := 0;
      timeout(IN := FALSE);
    END_IF;

    CASE teachstep OF
      0:
         Status := TeachStatus#Teaching;
         timeout(IN := TRUE, PT:=TEACHTIMEOUT);
         IF timeout.Q THEN
           OperationMode := OpMode#Op;
         END_IF;

         IF TPSet AND SensorInput &gt;= SENSORINPUT_MIN AND SensorInput &lt;= SENSORINPUT_MAX THEN
           y1 := TPy;
           x1 := SensorInput;
           teachstep := 1;
           timeout(IN := FALSE);
         END_IF;
      1:
         IF TPSet = FALSE THEN
           teachstep := 2;
         END_IF
      2:
         timeout(IN := TRUE, PT:=TEACHTIMEOUT);

         IF timeout.Q THEN
           OperationMode := OpMode#Op;
         END_IF;

         IF TPSet AND SensorInput &gt;= SENSORINPUT_MIN
             AND SensorInput &lt;= SENSORINPUT_MAX THEN
           y2 := TPy;
           x2 := SensorInput;
           teachstep := 3;
           timeout(IN := FALSE);
         END_IF;
       3:
        IF x1 &gt; x2 THEN
           x_temp := x1;
	   y_temp := y1;
	   x1 := x2;
	   y1 := y2;
	   x2 := x_temp;
	   y2 := y_temp;
         END_IF;

         IF x2 - x1 &lt;&gt; 0 THEN
           m   := (y2 - y1) * ICONST / (x2 - x1);
           t   := y1 - m * x1 / ICONST;
           Status := TeachStatus#Ok;
	 ELSE
           Status := TeachStatus#InvalidTeachPoints;
	   OperationMode := OpMode#Op;
         END_IF
       END_CASE;
  END_IF;
END_IF;
lastmode := OperationMode;
END_PROGRAM</plaintext>
</code>
<tabs>
<tab id="0" open="false" readOnly="false">
<specification comment="" isConcrete="false" name="Unnamed Specification">
<variables>
<ioVariable colwidth="100" data-type="INT" io="input" name="TPSet"/>
<ioVariable colwidth="100" data-type="INT" io="input" name="SensorInput"/>
<ioVariable colwidth="100" data-type="INT" io="input" name="TPy"/>
<ioVariable colwidth="100" data-type="OpMode" io="input" name="OperationMode"/>
<ioVariable colwidth="100" data-type="INT" io="output" name="SensorOutput"/>
<freeVariable data-type="INT" default="0" name="x1"/>
<freeVariable data-type="INT" default="23" name="y1"/>
<freeVariable data-type="INT" default="100" name="x2"/>
<freeVariable data-type="INT" default="1500" name="y2"/>
</variables>
<rows>
<row comment="">
<duration>[0,10]</duration>
<cell>-</cell>
<cell>-</cell>
<cell>0</cell>
<cell>Op</cell>
<cell>0</cell>
</row>
<row comment="">
<duration>[1,10]</duration>
<cell>0</cell>
<cell>-</cell>
<cell>-</cell>
<cell>Teach</cell>
<cell>0</cell>
</row>
<row comment="">
<duration>1</duration>
<cell>1</cell>
<cell>x1</cell>
<cell>y1</cell>
<cell>Teach</cell>
<cell>0</cell>
</row>
<row comment="">
<duration>[1,10]</duration>
<cell>0</cell>
<cell>-</cell>
<cell>-</cell>
<cell>Teach</cell>
<cell>0</cell>
</row>
<row comment="">
<duration>1</duration>
<cell>1</cell>
<cell>x1</cell>
<cell>y1</cell>
<cell>Teach</cell>
<cell>0</cell>
</row>
<row comment="">
<duration>1</duration>
<cell>-</cell>
<cell>-</cell>
<cell>-</cell>
<cell>Teach</cell>
<cell>0</cell>
</row>
<row comment="">
<duration>[1,-]</duration>
<cell>-</cell>
<cell>-</cell>
<cell>-</cell>
<cell>Op</cell>
<cell>= y1 + (y2 - y1) / (x2 - x1) * (SensorInput - x1)</cell>
</row>
</rows>
<enumTypes/>
</specification>
<specification isConcrete="true" name="Unnamed Specification">
<variables>
<ioVariable data-type="INT" io="input" name="TPSet"/>
<ioVariable data-type="INT" io="input" name="SensorInput"/>
<ioVariable data-type="INT" io="input" name="TPy"/>
<ioVariable data-type="OpMode" io="input" name="OperationMode"/>
<ioVariable data-type="INT" io="output" name="SensorOutput"/>
</variables>
<rows>
<row>
<duration>1</duration>
<cycle>
<cell>0</cell>
<cell>0</cell>
<cell>0</cell>
<cell>Op</cell>
<cell>0</cell>
</cycle>
</row>
<row>
<duration>1</duration>
<cycle>
<cell>0</cell>
<cell>0</cell>
<cell>0</cell>
<cell>Teach</cell>
<cell>0</cell>
</cycle>
</row>
<row>
<duration>1</duration>
<cycle>
<cell>1</cell>
<cell>0</cell>
<cell>0</cell>
<cell>Teach</cell>
<cell>0</cell>
</cycle>
</row>
<row>
<duration>10</duration>
<cycle>
<cell>0</cell>
<cell>0</cell>
<cell>0</cell>
<cell>Teach</cell>
<cell>0</cell>
</cycle>
<cycle>
<cell>0</cell>
<cell>0</cell>
<cell>0</cell>
<cell>Teach</cell>
<cell>0</cell>
</cycle>
<cycle>
<cell>0</cell>
<cell>0</cell>
<cell>0</cell>
<cell>Teach</cell>
<cell>0</cell>
</cycle>
<cycle>
<cell>0</cell>
<cell>0</cell>
<cell>0</cell>
<cell>Teach</cell>
<cell>0</cell>
</cycle>
<cycle>
<cell>0</cell>
<cell>0</cell>
<cell>0</cell>
<cell>Teach</cell>
<cell>0</cell>
</cycle>
<cycle>
<cell>0</cell>
<cell>0</cell>
<cell>0</cell>
<cell>Teach</cell>
<cell>0</cell>
</cycle>
<cycle>
<cell>0</cell>
<cell>0</cell>
<cell>0</cell>
<cell>Teach</cell>
<cell>0</cell>
</cycle>
<cycle>
<cell>0</cell>
<cell>0</cell>
<cell>0</cell>
<cell>Teach</cell>
<cell>0</cell>
</cycle>
<cycle>
<cell>0</cell>
<cell>0</cell>
<cell>0</cell>
<cell>Teach</cell>
<cell>0</cell>
</cycle>
<cycle>
<cell>0</cell>
<cell>0</cell>
<cell>0</cell>
<cell>Teach</cell>
<cell>0</cell>
</cycle>
</row>
<row>
<duration>1</duration>
<cycle>
<cell>1</cell>
<cell>0</cell>
<cell>0</cell>
<cell>Teach</cell>
<cell>0</cell>
</cycle>
</row>
<row>
<duration>1</duration>
<cycle>
<cell>-2</cell>
<cell>-1</cell>
<cell>-1</cell>
<cell>Teach</cell>
<cell>0</cell>
</cycle>
</row>
<row>
<duration>1</duration>
<cycle>
<cell>1</cell>
<cell>0</cell>
<cell>1</cell>
<cell>Op</cell>
<cell>0</cell>
</cycle>
</row>
</rows>
<enumTypes/>
</specification>
</tab>
</tabs>
<history/>
</session>