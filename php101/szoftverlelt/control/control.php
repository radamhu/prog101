<?php

define('HOME', '/hazi/');

//define database info
define('SQLHOST', 'localhost');
define('SQLUSER', 'hazi');
define('SQLPASS', 'hazi');
define('SQLDB', 'szoftverleltar');

//create connection to database and setup character encoding
$db = mysqli_connect(SQLHOST, SQLUSER, SQLPASS, SQLDB);
mysqli_query($db, "SET NAMES 'utf8'");

//get frompage from session and setup backlink
$frompage = $_SESSION["page"];
$backlink = $frompage == "" ? "" : HOME."page/".$frompage;

//get the GET and POST data with filters
$page = filter_input(INPUT_GET, "page", FILTER_DEFAULT) == "" ? 1 : filter_input(INPUT_GET, "page", FILTER_DEFAULT);
$event = filter_input(INPUT_POST, "event", FILTER_DEFAULT);
//setting up the alert for success or failure
$feedbackmessage = "";

//add new computer to database if event is addnewcomp
if($event == "addnewcomp"){
	//gathering POST data for new computer with filters
	$hely = filter_input(INPUT_POST, "hely", FILTER_DEFAULT);
	$tipus = filter_input(INPUT_POST, "tipus", FILTER_DEFAULT);
	$ipcim = filter_input(INPUT_POST, "ipcim", FILTER_DEFAULT);
	$insertquery = "insert into gep (hely, tipus, ipcim) values ('$hely', '$tipus', '$ipcim')";
	//running the SQL insert query
	//set feedbackmessage javascript to success or failure depending the action
	if (mysqli_query($db, $insertquery)) {
		$feedbackmessage = '
		$.notify({
			message: "Új számítógép sikeresen hozzáadva!"
		},{
			type: "success"
		});';
	} else {
		$feedbackmessage = '
		$.notify({
			message: "Új számítógép hozzáadása sikertelen!"
		},{
			type: "danger"
		});';
	}
} else
if($event == "editcomp"){
	//gathering POST data for computer with filters
	$id = filter_input(INPUT_POST, "id", FILTER_DEFAULT);
	$hely = filter_input(INPUT_POST, "hely", FILTER_DEFAULT);
	$tipus = filter_input(INPUT_POST, "tipus", FILTER_DEFAULT);
	$ipcim = filter_input(INPUT_POST, "ipcim", FILTER_DEFAULT);
	$updatequery = "update gep set hely = '$hely', tipus = '$tipus', ipcim = '$ipcim' where id = '$id'";
	//running the SQL update query
	//set feedbackmessage javascript to success or failure depending the action
	if (mysqli_query($db, $updatequery)) {
		$feedbackmessage = '
		$.notify({
			message: "Számítógép sikeresen módosítva!"
		},{
			type: "success"
		});';
	} else {
		$feedbackmessage = '
		$.notify({
			message: "Számítógép módosítása sikertelen!"
		},{
			type: "danger"
		});';
	}
} else
if($event == "addnewsoft"){
	//gathering POST data for computer with filters
	$swname = filter_input(INPUT_POST, "swname", FILTER_DEFAULT);
	$swkat = filter_input(INPUT_POST, "swkat", FILTER_DEFAULT);
	$insertquery = "insert into szoftver (nev, kategoria) values ('$swname', '$swkat')";
	//running the SQL insert query
	//set feedbackmessage javascript to success or failure depending the action
	if (mysqli_query($db, $insertquery)) {
		$feedbackmessage = '
		$.notify({
			message: "Új szoftver sikeresen hozzáadva!"
		},{
			type: "success"
		});';
	} else {
		$feedbackmessage = '
		$.notify({
			message: "Új szoftver hozzáadása sikertelen!"
		},{
			type: "danger"
		});';
	}
} else
if($event == "swremove"){
	//gathering POST data for computer with filters
	$swid = filter_input(INPUT_POST, "swid", FILTER_DEFAULT);
	$deletequery = "delete from szoftver where id = '$swid'";
	//running the SQL delete query
	//set feedbackmessage javascript to success or failure depending the action
	if (mysqli_query($db, $deletequery)) {
		$feedbackmessage = '
		$.notify({
			message: "Szoftver sikeresen törölve!"
		},{
			type: "success"
		});';
	} else {
		$feedbackmessage = '
		$.notify({
			message: "Szoftver törlése sikertelen!"
		},{
			type: "danger"
		});';
	}
} else
if($event == "removesw"){
	//gathering POST data for new computer with filters
	$gepid = filter_input(INPUT_POST, "gepid", FILTER_DEFAULT);
	$telepid = filter_input(INPUT_POST, "telepid", FILTER_DEFAULT);
	$deletequery = "delete from telepites where id = '$telepid'";
	//running the SQL delete query
	//set feedbackmessage javascript to success or failure depending the action
	if (mysqli_query($db, $deletequery)) {
		$feedbackmessage = '
		$.notify({
			message: "Program sikeresen törölve a számítógépről!"
		},{
			type: "success"
		});';
	} else {
		$feedbackmessage = '
		$.notify({
			message: "Program törlése sikertelen!"
		},{
			type: "danger"
		});';
	}	
} else
if($event == "installsw"){
	//gathering POST data for new computer with filters
	$gepid = filter_input(INPUT_POST, "gepid", FILTER_DEFAULT);
	$swid = filter_input(INPUT_POST, "swid", FILTER_DEFAULT);
	$swver = filter_input(INPUT_POST, "swver", FILTER_DEFAULT);
	$installdate = filter_input(INPUT_POST, "installdate", FILTER_DEFAULT);
	$insertquery = "insert into telepites (gepid, szoftverid, verzio, datum) values ('$gepid', '$swid', '$swver', '$installdate')";
	//running the SQL insert query
	//set feedbackmessage javascript to success or failure depending the action
	if (mysqli_query($db, $insertquery)) {
		$feedbackmessage = '
		$.notify({
			message: "Új program sikeresen hozzáadva!"
		},{
			type: "success"
		});';
	} else {
		$feedbackmessage = '
		$.notify({
			message: "Új program hozzáadása sikertelen!"
		},{
			type: "danger"
		});';
	}
}

//list all computers
$allcomputers =  mysqli_fetch_all(mysqli_query($db, "select * from gep"));
//and computers by page from database
$querypage = mysqli_query($db, "select id, hely, tipus, ipcim from gep limit ".($page*10-10).",10");
$computers = mysqli_fetch_all($querypage, MYSQLI_ASSOC);
//and softwares
$swquery = mysqli_query($db, "select * from szoftver");
$swr = mysqli_fetch_all($swquery, MYSQLI_ASSOC);

?>
