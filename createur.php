<meta charset="utf-8" />		
<?php

	$db_handle = mysqli_connect('localhost', 'root', '');	

	$fichierR = fopen('bdd.sql','r');

	mysqli_query($db_handle,"DROP DATABASE IF EXISTS EDT;") ;
	mysqli_query($db_handle,"CREATE DATABASE EDT DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;") ;

	$db_found = mysqli_select_db($db_handle, "EDT");

	while (!feof($fichierR)){
		$request = fgets($fichierR, filesize('bdd.sql'));
		mysqli_query($db_handle,$request) ;
	}

	fclose($fichierR);

  exit();

?> 