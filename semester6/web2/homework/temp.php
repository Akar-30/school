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
    <title>Temperature</title>
</head>

<body>
    <form action="" method="get">
        <label for="temp">Enter the temperature:</label>
        <input type="text" name="temp" id="temp">
        <input type="submit" value="Submit">
    </form>

    <?php
    if (isset($_GET['temp'])) {
        $temp = $_GET['temp'];
        if ($temp < 20) {
            echo "Cold";
        } elseif ($temp >= 20 && $temp <= 30) {
            echo "Warm";
        } else {
            echo "Hot";
        }
    } else {
        echo "Please enter the temperature";
    }
    ?>
</body>

</html>