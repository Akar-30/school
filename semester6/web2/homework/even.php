<!-- 
3- Write a PHP script using the while loop that displays all even numbers between 1 and 150.
Use a while loop to check if a number is even.
If the number is even, display it. 
-->
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Even Numbers</title>
</head>

<body>
    <?php
    $num = 1;
    while ($num <= 150) {
        if ($num % 2 == 0) {
            echo $num . "<br>";
        }
        $num++;
    }
    ?>
</body>

</html>