# JiraCalculator

**Run project:**

`mvn clean install`

**Run application:**

`mvn -q clean compile exec:java -Dexec.mainClass="com.miskevich.jiracalculator.AppRunner" -Dexec.args=<path_to_your_file>`

example:

`mvn -q clean compile exec:java -Dexec.mainClass="com.miskevich.jiracalculator.AppRunner" -Dexec.args=/home/user/Downloads/subtasks-0504.csv`

**Getting results:**

check file with name `result.txt` created inside the basedir