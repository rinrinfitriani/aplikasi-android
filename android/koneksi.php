<?php

    $host       = "localhost"; 
    $username   = "root";  
    $password   = ""; 
    $database   = "db_android";
    $conn       = new mysqli($host,$username,$password,$database);

    $nama    = $_POST['nama'];
    $jk      = $_POST['jeniskelamin'];
    $umur    = $_POST['umur'];
    $hobi    = $_POST['hobi'];

    mysqli_query($conn,"INSERT INTO `tb_biodata`(`id`, `Nama`, `JenisKelamin`, `Umur`, `Hobi`) VALUES ('','$nama','$jk','$umur','$hobi')");