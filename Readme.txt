------------How to run the program-----------------
1. Clone this link in your desired path on your laptop
---> < git clone -b selenium-practice https://github.com/taftaniza/QA-Automation.git >

2. Open the project to your IDE.

3. Run the program in the file SeleniumTest.java ---> (src/test/java/com/automation/SeleniumTest.java)



-----------How to run Allure Report----------------

**Open Terminal**:
   - In your IDE, open the terminal (make sure the path is on the project's path)

   **Run the installation command**:
   - Execute the following command:

  #1
     ```
     mvn clean test
     ```

--- After that, run the code on the SeleniumTes.java
--- Next, execute:

  #2
     ```
     allure serve
     ```
   This command runs allure report for the testing.

