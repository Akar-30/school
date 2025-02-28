<!-- 
2- Use switch-case for Grade Evaluation
If the grade is between 90 and 100, print "Excellent".
If the grade is between 75 and 89, print "Good".
If the grade is between 60 and 74, print "Average".
If the grade is below 60, print "Fail".
-->

<!-- 
1- Write a PHP script that checks the temperature and classifies it as "Cold", "Warm", or "Hot".
If the temperature is below 20°C, print "Cold".
If the temperature is between 20°C and 30°C, print "Warm".
If the temperature is above 30°C, print "Hot". 
-->
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Grade</title>
</head>

<body>
    <form action="" method="get">
        <label for="grade">Enter the Grade:</label>
        <input type="number" name="grade" id="grade">
        <input type="submit" value="Submit">
    </form>

    <?php
    if (isset($_GET['grade'])) {
        $grade = $_GET['grade'];
        switch ($grade) {
            case ($grade == 0):
                echo "Fail";
                break;
            case ($grade >= 90 && $grade <= 100):
                echo "Excellent";
                break;
            case ($grade >= 75 && $grade <= 89):
                echo "Good";
                break;
            case ($grade >= 60 && $grade <= 74):
                echo "Average";
                break;
            case ($grade < 60):
                echo "Fail";
                break;
            default:
                echo "Invalid Grade";
        }
    } else {
        echo "Please enter the grade";
    }
    ?>
</body>

</html>