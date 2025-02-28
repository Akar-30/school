<!-- 
4- Create a Function for Calculating Factorial
The factorial of a number n is the product of all positive integers less than or equal to n (i.e., n!= n 1). 
-->

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Factorial</title>
</head>

<body>
    <form action="" method="get">
        <label for="num">Enter the number:</label>
        <input type="number" name="num" id="num">
        <input type="submit" value="Submit">
    </form>

    <?php
    function factorial($num)
    {
        $fact = 1;
        for ($i = 1; $i <= $num; $i++) {
            $fact *= $i;
        }
        return $fact;
    }

    if (isset($_GET['num'])) {
        $num = $_GET['num'];
        if ($num < 0) {
            echo "Please enter a non-negative number";
            return;
        } else {
            echo "Factorial of $num is " . factorial($num);
        }
    } else {
        echo "Please enter the number";
    }
    ?>
</body>

</html>