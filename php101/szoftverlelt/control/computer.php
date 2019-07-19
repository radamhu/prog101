<?php
session_start();
require_once("control.php");
//get the computer id from the mainpage get
$computerid = filter_input(INPUT_GET, "computerid", FILTER_DEFAULT);
//getting all pc is in array
$allid = array();
$result = mysqli_query($db, "select id from gep");
while($row = mysqli_fetch_row($result)){
	array_push($allid, $row[0]);
}
//check if id is in the array, otherwise giving 404 error
if (in_array($computerid,$allid)) {
	//getting pc data and softwares
	$pcquery = mysqli_query($db, "select id, hely, tipus, ipcim from gep where id = '$computerid'");
	$pcs = mysqli_fetch_assoc($pcquery);
	$id = $pcs['id'];
	$hely = $pcs['hely'];
	$tipus = $pcs['tipus'];
	$ip = $pcs['ipcim'];
	$softquery = mysqli_query($db, "select t.id as telepid, nev, kategoria, verzio, datum from telepites t, gep g, szoftver s where g.id=t.gepid and s.id=t.szoftverid and g.id=".$id);
	$softwares = mysqli_fetch_all($softquery, MYSQLI_ASSOC);
	
	//loading website header
	require_once("header.php");
?>

	<body>
	
		<div class="modal fade" id="editcomputer" tabindex="-1" role="dialog">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel"><h2>#<?php echo $id; ?> gép módosítása</h2></h5>
				<button type="button" class="close" data-dismiss="modal">
				  <span aria-hidden="true"><i class="fas fa-times-circle"></i></span>
				</button>
			  </div>
			  <div class="modal-body">
				<form method="post" action="<?php echo HOME; ?>computer/<?php echo $id; ?>">
					<div class="d-none"><input name="id" value="<?php echo $id; ?>"></div>
					<div class="form-group">
						<label>Hely:</label>
						<input class="form-control" type="text" name="hely" required value="<?php echo $hely; ?>">
						<small class="text-muted d-block">Írja be a szobaszámot, ahol a számítógép található (pl.: T301)</small>
					</div>
					<div class="form-group">
						<label>Típus:</label>
						<select class="form-control" name="tipus" required>
							<option value="notebook" <?php $tipus == "notebook" ? print "selected" : print ""; ?>>Notebook</option>
							<option value="asztali" <?php $tipus == "asztali" ? print "selected" : print ""; ?>>Asztali</option>
						</select>
					</div>
					<div class="form-group">
						<label>IP cím:</label>
						<input class="form-control" type="text" name="ipcim" required value="<?php echo $ip; ?>">		 
					</div>
			  </div>
			  <div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Mégsem</button>
				<button type="submit" class="btn btn-primary ml-auto" name="event" value="editcomp">
					<i class="fas fa-file-upload"></i> Módosít
				</button>
			  </div>
			  </form>
			</div>
		  </div>
		</div>
		
		<div class="modal fade" id="removesw" tabindex="-1" role="dialog">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel"><h2>#<?php echo $id; ?> gép módosítása</h2></h5>
				<button type="button" class="close" data-dismiss="modal">
				  <span aria-hidden="true"><i class="fas fa-times-circle"></i></span>
				</button>
			  </div>
			  <div class="modal-body">
				<form method="post" action="<?php echo HOME; ?>computer/<?php echo $id; ?>">
					<div class="d-none"><input name="gepid" value="<?php echo $id; ?>"></div>
					<div class="form-group">
						Válassza ki a törölni kívált programot
						<select name="telepid" class="form-control">
<?php 
							foreach($softwares as $rmswsor) {
?>
							<option value="<?php echo $rmswsor['telepid']; ?>"><?php echo $rmswsor['nev']." ".$rmswsor['verzio'];?></option>
<?php
							}
?>
						</select>
					</div>
			  </div>
			  <div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Mégsem</button>
				<button type="submit" class="btn btn-danger ml-auto" name="event" value="removesw">
					<i class="fas fa-trash-alt"></i> Eltávolítás
				</button>
			  </div>
			  </form>
			</div>
		  </div>
		</div>
		
		<div class="modal fade" id="installsw" tabindex="-1" role="dialog">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel"><h2>#<?php echo $id; ?> gép módosítása</h2></h5>
				<button type="button" class="close" data-dismiss="modal">
				  <span aria-hidden="true"><i class="fas fa-times-circle"></i></span>
				</button>
			  </div>
			  <div class="modal-body">
				<form method="post" action="<?php echo HOME; ?>computer/<?php echo $id; ?>">
					<div class="d-none"><input class="form-control" name="gepid" value="<?php echo $id; ?>"></div>
					<div class="form-group">
						Válassza ki a telepíteni kívált programot
						<select class="form-control" name="swid">
<?php 
							foreach($swr as $swsor) {
?>
							<option value="<?php echo $swsor['id']; ?>"><?php echo $swsor['nev']; ?></option>
<?php
							}
?>
						</select>
					</div>
					
					<div class="form-group">
						Írja be a program verzióját
						<input class="form-control" type="text" name="swver">
					</div>
					
					<div class="form-group">
						Írja be a program telepítésének dátumát
						<input class="form-control" type="date" name="installdate" value="<?php echo date("Y-m-d"); ?>">
					</div>
			  </div>
			  <div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Mégsem</button>
				<button type="submit" class="btn btn-primary ml-auto" name="event" value="installsw">
					<i class="fas fa-plus"></i> Telepítés
				</button>
			  </div>
			  </form>
			</div>
		  </div>
		</div>
		
		<div class="container-fluid">
			<div class="container bg-light mt-3 mb-3 rounded">
				<h1 class="text-center">Számítógép</h1>
				<div class="card">
					<div class="card-header">
						<h2>#<?php echo $id; ?> számú számítógép</h2>
					</div>
					<div class="card-body row">
						<div class="col-12">
							<table>
								<tr>
									<td>Helye: </td>
									<td><?php echo $hely; ?></td>							
								</tr>
								<tr>
									<td>Típusa: </td>
									<td><?php echo $tipus; ?></td>							
								</tr>
								<tr>
									<td>IP címe: </td>
									<td><?php echo $ip; ?></td>							
								</tr>
							</table>
						</div>
						<div class="col-12">
							<button class="btn btn-primary" data-toggle="modal" data-target="#editcomputer">
							<i class="far fa-edit"></i> Szerkesztés</button> 
						</div>
						<div class="col-12">
							<hr>
						</div>
						<div class="col-12">
							<h3>Telepített szoftverek 
								<button class="btn btn-primary" data-toggle="modal" data-target="#installsw">
									<i class="fas fa-plus"></i> Telepítés
								</button>
								<button class="btn btn-danger" data-toggle="modal" data-target="#removesw">
									<i class="fas fa-trash-alt"></i> Törlés
								</button>
							</h3>
							<ul class="list-group">
<?php
						//list installed softwares
						foreach($softwares as $ssor) {
								$tdatum = $ssor['datum'] == "" ? "????-??-??" : $ssor['datum'];
?>
							<li class="list-group-item"><small><b><?php echo $ssor['nev']; ?></b> (<?php echo $ssor['kategoria']; ?>) <?php echo $ssor['verzio']; ?><br>						
							Telepítve: <?php echo $tdatum; ?></small></li>
<?php
						}
?>
							</ul>
						</div>
					</div>
					<div class="card-footer">
						<a class="btn btn-primary" href="<?php echo $backlink; ?>">
							<i class="fas fa-arrow-left"></i> Vissza a gépekhez
						</a>
					</div> 
				</div>
			</div>
		</div>
		<script>
			<?php echo $feedbackmessage; ?>
		</script>
	</body>

</html>

<?php
} else {
		http_response_code(404);
}
?>
