# Parking Lot

This Project is implemented in Java. which is a fully automated Parking System. It assigns the nearest slot available to a vehicle based on its distance. This Project handles below operations.

1.  create\_parking\_lot &lt;size&gt;

    initializes a new parking lot with given numbers of the slots.

2.  park &lt;registration_number&gt; &lt;color_of_car&gt;
    
    parks a vehicle in the nearest slot based on distance.

3.  leave &lt;slot_number&gt;

    remove the vehicle from the given slot and this slot is available now for another vehicle.

4.  status

    show all the vehicles details which are parked in tabular format.

5.  registration\_numbers\_for\_cars\_with\_colour &lt;color&gt;

    prints all the registration numbers of vehicles which are of a given color.

6.  slot\_numbers\_for\_cars\_with\_colour &lt;color&gt;

    prints all slot numbers which have vehicles of a given color.

7.  slot\_number\_for\_registration\_number &lt;registration_number&gt;

    print slot allocated for a particular vehicle.

8.  exit

    the program stops executing.


## Installation

below are the requirements for the execution of this project.

-&gt;maven

-&gt;jre 1.8

-&gt;Unix


1. First, you need to build this project. for which you need to execute `setup`, which is located inside the bin folder. It builds `ParkingLot.jar` and run test cases.

   ``./setup``

2. You need to execute `parking_lot`, which starts the execution of this project. This is also located inside the bin folder. This file can be executed in two formats.

   ``./parking_lot test.txt``  : It accepts all instructions written in a text file.

   ``./parking_lot``  : You can give instructions from the command prompt.




