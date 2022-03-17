# Assignment-2 Opening Comment

### Program Title:
* Assignment-2

### Source files:
* Main.java
* Inputs.java
* FermatMiss.java
* PowMath.java

### Requires files:
* N/A

### Creates files:
* N/A

### Programmer Names & Emails:
* Eric Grandizio - grandizioe@duq.edu
* Edward Polens - polense@duq.edu
* Charles Schuck - schuckc@duq.edu 
  
### Course:
* Software Engineering - COSC 445W - Spring 2021

### Start Date:
* 2/15/2021

### Submit Date:
* 3/7/2021

### Resources Used:
* Visual Studio Code
* GitHub
* Wikipedia - https://en.wikipedia.org/wiki/Double-precision_floating-point_format#Precision_limitations_on_integer_values
* IntelliJ's UML Diagram Generation Tool

### Explanation
- This program first reads in two integer values, n and k, from the user, one at a time.
    - The acceptable range of n values is in the range (2, 12) / [3, 11].
    - The minimum acceptable k value is 10.
    - The maximum acceptable k is calculated based on the n value (in order to prevent any overflow or rounding errors).
- Then, it iterates over all x, y pairs in the range [10, k].
- For each pair, it calculates up to two z values such that z^n is as close to (x^n + y^n) as possible.
    - These are calculated by the floor and ceil of the nth root of (x^n + y^n).
- It then creates FermatMiss objects with arguments (x, y, z, n).
- All the while, it keeps track of the Minimum FermatMiss, and for each new one it finds, it outputs it to the console.
    - Since addition is commutative, if x and y are not the same, it will output both possible permutations for (x^n + y^n).
- At the end, it awaits user-input before terminating.

### RUNNING THE PROGRAM
- Make sure you are running the latest version of Java.
    - You can download the latest version here: https://www.oracle.com/java/technologies/javase-downloads.html
- On Windows, open Command Prompt and use the "cd" command to navigate to the directory where you have Assignment-2.jar installed.
- Once you have accessed the correct directory, run the command "java -jar Assignment-2.jar". 

