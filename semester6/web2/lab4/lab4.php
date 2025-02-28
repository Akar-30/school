<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
</head>

<body>
    <form method="post">
        username: <input type="text" name="user"> <br><br>
        password: <input type="password" name="passw"><br><br>
        Email: <input type="email" name="email"> <br><br>
        <input type="submit" name="sub">
    </form>
</body>

</html>
<?php
if (isset($_POST["sub"])) {
    require_once './dbcon.php';
    $sql = "insert into users(username,password,email) values (:username,:password,:email)";
    $query = $dbh->prepare($sql);
    $query->bindParam(":username", $_POST['user'], PDO::PARAM_STR);
    $query->bindParam(":password", $_POST['passw'], PDO::PARAM_STR);
    $query->bindParam(":email", $_POST['email'], PDO::PARAM_STR);
    $query->execute();
    $last = $dbh->lastInsertId();
    if ($last) {
        echo "<script>alert('successfully added " . $last . " ID');</script>";
    }
}
?>