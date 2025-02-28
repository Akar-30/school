<?php
define('host', 'localhost');
define('user', 'root');
define('pass', '');
define('dbname', 'web_db');
try {
    $dbh = new PDO("mysql:host=" . host . ";dbname=" . dbname, user, pass);
} catch (PDOException $e) {
    exit("Error: " . $e->getMessage());
}
